FROM java:8
ADD target/inventory-service-0.0.1-SNAPSHOT.jar inventory-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT["java","-jar","inventory-service-0.0.1-SNAPSHOT.jar"]