# Spring Boot Kafka Producer and Consumer Example
This is an example tutorial of spring boot application with apache kafka. 

## Application runner
Locally running application is configured through application.yaml located in `./codenow/config` directory. To override, use JVM options such as

```
-Dserver.port=8080 -Dspring.config.location=file:./codenow/config/application.yaml
```

## Start kafka
To run the application, we have to start zookeeper and kafka services first

### With docker compose
If you have docker installed, you can use prepared docker-compose.yaml. Run the following commands to

start all services
```
docker-compose up
```
stop all services
```
docker-compose down
```

### Locally
You can also start zookeeper and kafka services manually by following this tutorial: https://kafka.apache.org/quickstart

Here is the sequence of commands you should run, after you download the latest kafka release 

```
UNIX

# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties

# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties

# Create kafka topic "create_order" with two partitions
$ bin/kafka-topics.sh --create --topic create_order --partitions 2 --bootstrap-server localhost:9092

# Check the number of partitions
$ bin/kafka-topics.sh --describe --topic create_order --bootstrap-server localhost:9092
```

```
WINDOWS

# Start the ZooKeeper service
$ .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

# Start the Kafka broker service
$ .\bin\windows\kafka-server-start.bat .\config\server.properties

# Create kafka topic "create_order" with two partitions
$ .\bin\windows\kafka-topics.bat --create --topic create_order --partitions 2 --bootstrap-server localhost:9092

# Check the number of partitions
$ .\bin\windows\kafka-topics.bat --describe --topic create_order --bootstrap-server localhost:9092

```

## Deployment configuration
All files located in `./codenow/config` directory will be deployed alongside the application and available in `/codenow/config` directory
