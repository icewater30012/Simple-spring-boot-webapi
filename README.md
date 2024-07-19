# Simple-spring-boot-webapi
This is a simple Web API read dataset.json file and return the content back.

## System Requirement
JDK: openjdk-8-jdk
Maven: Apache Maven 3.6.0+
Podman: 4.2.0


## Configure Project
1. Clone the prohject.

       git clone git@github.com:icewater30012/Simple-spring-boot-webapi.git

2. Build and package the project into war.file

       mvn package

3. Build the docker image

       podman build -t java-api .

4. Run the container in background with port 8080 and 8443.

       podman run -d -p 8080:9080 -p 8443:9443 --name java-api java-api

5. The Swagger url of this project :http://<your_ip_address>:8080/ibm-demo-api/swagger-ui/index.html

6. The simple java api endpoint is :http://<your_ip_address>:8080/ibm-demo-api/api/getJsonData
