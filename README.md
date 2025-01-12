#Kafka Connector


## Prerequisites
To run this project, ensure you have the following installed:

1. **Java Development Kit (JDK)** - Version 11 or later
2. **Apache Kafka** - Version 2.8.0 or later
3. **Maven** - For building the project
4. **Git** - For cloning the repository
5. **Zookeeper** - Required for Kafka cluster management

---

## Getting Started
Follow these steps to set up and run the project:

### 1. Clone the Repository
Clone this repository to your local machine:
```bash
git clone https://github.com/aanshpy1809/KafkaConnectorAshnik.git
cd KafkaConnectorAshnik
```

### 2. Configure Kafka
Update the Kafka configuration file (`src/main/resources/application.properties`) with your Kafka server details:
```properties
kafka.bootstrap.servers=localhost:9092
kafka.topic.name=my-topic
```

### 3. Build the Project
Build the project using Maven:
```bash
mvn clean install
```

### 4. Run the Project
Run the project using the following command:
```bash
java -jar target/kafka-connector-ashnik.jar
```

---

## How to Run Locally
1. **Start Zookeeper**
   Start Zookeeper, which is required by Kafka:
   ```bash
   zookeeper-server-start.sh /path/to/zookeeper/config
   ```

2. **Start Kafka Server**
   Launch the Kafka server:
   ```bash
   kafka-server-start.sh /path/to/kafka/config
   ```

3. **Create Kafka Topics**
   Create the necessary Kafka topics:
   ```bash
   kafka-topics.sh --create --topic my-topic --bootstrap-server localhost:9092
   ```

4. **Run the Connector**
   Start the connector application as described above.

---

## Testing
1. **Produce Messages**
   Send messages to the Kafka topic:
   ```bash
   kafka-console-producer.sh --topic my-topic --bootstrap-server localhost:9092
   > Hello Kafka
   ```

2. **Consume Messages**
   Verify the messages are consumed:
   ```bash
   kafka-console-consumer.sh --topic my-topic --from-beginning --bootstrap-server localhost:9092
   ```

---

