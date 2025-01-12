package com.ashnik.kafkaconnector;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RestApiCall {

    private static final int TIMEOUT = 5000; 
    private static final int MAX_RETRIES = 3;
    

    public static String fetchData(String apiUrl) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(TIMEOUT)
                .setSocketTimeout(TIMEOUT)
                .setConnectionRequestTimeout(TIMEOUT)
                .build();

        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build()) {
            int attempt = 0;
            while (attempt < MAX_RETRIES) {
                attempt++;
                String variable="";
                try {
                    
                    return executeRequest(httpClient, apiUrl);
                } catch (RuntimeException e) {
                    if (attempt >= MAX_RETRIES) {
                        throw new RuntimeException("Failed after " + MAX_RETRIES + " attempts: " + e.getMessage(), e);
                    }
                    System.err.println("Attempt " + attempt + " failed: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error during API fetch: " + e.getMessage(), e);
        }
        throw new RuntimeException("API fetch failed unexpectedly.");
    }

    
    private static String executeRequest(CloseableHttpClient httpClient, String apiUrl) {
        HttpGet request = new HttpGet(apiUrl);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity);
            } else if (statusCode == 400) {
                throw new RuntimeException("Bad Request: The server could not understand the request.");
            } else if (statusCode == 404) {
                throw new RuntimeException("Not Found: The requested resource could not be found.");
            } else if (statusCode == 500) {
                throw new RuntimeException("Internal Server Error: The server encountered an unexpected condition.");
            } else {
                throw new RuntimeException("Unexpected HTTP Status Code: " + statusCode);
            }
        } catch (RuntimeException e) {
            throw e; 
        } catch (Exception e) {
            throw new RuntimeException("Request execution failed: " + e.getMessage(), e);
        }
    }
}
