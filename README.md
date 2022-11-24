# Spring Boot Kafka Producer and Consumer Example
This is an example tutorial of spring boot application with apache kafka. 

## Application runner
Locally running application is configured through application.yaml located in `./codenow/config` directory. To override, use JVM options such as

```
-Dserver.port=8080 -Dspring.config.location=file:./codenow/config/application.yaml
```

## Start kafka
To run the application, we have to first start zookeeper and kafka services

### With docker compose
If you have docker installed, you can run the following command to start all services
```
docker-compose up
```
To stop all services run
```
docker-compose down
```

### Locally
You can also install and run zookeeper and kafka services manually by following this tutorial

https://kafka.apache.org/quickstart

## Deployment configuration
All files located in `./codenow/config` directory will be deployed alongside the application and available in `/codenow/config` directory
