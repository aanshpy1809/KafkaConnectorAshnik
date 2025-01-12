## Kafka Connector Project
Follow the steps below to set up and run the application.

## Prerequisites
Before you begin, ensure that the following are installed on your machine:

Java (version 8 or higher)
Maven (for building the project)
Apache Kafka (Kafka broker running locally or on a remote server)

## Getting Started
Follow these steps to set up and run the project:

### 1. Clone the Repository
Clone this repository to your local machine:
```bash
git clone https://github.com/aanshpy1809/KafkaConnectorAshnik.git
cd KafkaConnectorAshnik
```
### 2. Install Dependencies
Clone this repository to your local machine:
```bash
mvn clean install
```
This command will resolve and install all required dependencies defined in the pom.xml file.

### 3. Configure Kafka
Ensure that your Kafka broker is up and running. You can run Kafka locally by following the instructions in the Kafka documentation.

Make sure you have a running Kafka instance and a topic created where messages will be published.
Update the Kafka server configuration (if necessary) in the MainApp.java file to match your Kafka server and topic configuration.

### 4. Run the Application
To run the application, execute the MainApp.java class. This can be done directly from Maven or through your IDE.

Running from Maven:
```bash
Copy code
mvn exec:java -Dexec.mainClass="com.ashnik.kafkaconnector.MainApp"
```
Running from Eclipse:
Open the project in Eclipse.
Right-click the MainApp.java file in the src/main/java/com/ashnik/kafkaconnector directory.
Select Run As > Java Application.

---

### 5. Verify Messages in Kafka Consumer
Once the application runs, it will publish messages to the Kafka topic.

To verify that the messages are being successfully published:

Open a Kafka consumer to consume messages from the topic.
Run the following command to start the Kafka console consumer (replace <topic-name> with your actual Kafka topic):
```bash
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <topic-name> --from-beginning
```
You should start seeing the messages being published into the Kafka topic in real-time.
