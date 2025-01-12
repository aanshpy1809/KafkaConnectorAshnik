package com.ashnik.kafkaconnector;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        String apiUrl = "https://jsonplaceholder.typicode.com/posts";
        String kafkaBootstrapServers = "localhost:9092";
        String kafkaTopic = "sample_topic";

        try {
            // Fetch data from REST API
            String jsonData = RestApiCall.fetchData(apiUrl);

            // Validate data
            List<String> validData = DataValidator.validateData(jsonData);

            // Publish data to Kafka
            KafkaProducerService producer = new KafkaProducerService(kafkaBootstrapServers);
            for (String data : validData) {
                producer.sendMessage(kafkaTopic, data);
                System.out.println("Published: " + data);
            }
            producer.close();

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
