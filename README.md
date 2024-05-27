## employee-management
Sample Microservices with Spring Boot 3, Spring Cloud, FeignClient and Zipkin

> [!NOTE]
> To provide a clearer focus on the microservices architecture, some features, such as the database, services, and validation, have been omitted in this application and in-memory data is used.
<br/>

### Description

This project is created to demonstrate useful features of [Spring Cloud Project](https://spring.io/projects/spring-cloud) for building microservice-based architecture. By default, Spring Cloud Config Server stores the configuration data inside the Git repository. We will change that behavior by activating the native mode. In this mode, Spring Cloud Config Server reads property sources from the classpath.

<br/>

### Architecture

This microservices-based system consists of the following modules:


<img src="config-service/src/main/resources/images/architecture.png" width="960"/>

- **gateway-service** : acts as a proxy/gateway in our architecture
- **config-service** : uses Spring Cloud Config Server for running configuration server in the `native` mode
- **discovery-service** : uses Spring Cloud Netflix Eureka as an embedded discovery server
- **employee-service** : sample microservice that allows to perform CRUD operation on in-memory repository of employees
- **department-service** : sample microservice that allows to perform CRUD operation on in-memory repository of departments. Communicates with employee-service.
- **organization-service** : sample microservice that allows to perform CRUD operation on in-memory repository of organizations. Communicates with both employee-service and organization-service.

<br/>


## Getting Started

> [!NOTE]
> The following apps should be installed before running the application:

- A command line app
- Docker Desktop
  <br/>

> [!TIP]
> For more information regarding the system requirements, etc. refer to the following pages: <br/>
> [Install on Mac](https://docs.docker.com/desktop/install/mac-install/)<br/>
> [Install on Windows](https://docs.docker.com/desktop/install/windows-install/)<br/>
> [Install on Linux](https://docs.docker.com/desktop/install/linux-install/)<br/>

<br/>

### Running the application

In order to run the application on local, follow these steps:

1. Run Docker desktop.

<br/>

2. Open command prompt window and clone the project from GitHub using the following command:

```shell
git clone https://github.com/yildizmy/employee-management.git
```
<br/>

3. Run Zipkin container with the following command:

```shell
docker run -d --name zipkin -p 9411:9411 openzipkin/zipkin
```
<br/>

4. Open the project using `IntelliJ IDEA`. Then select `Java 21` version via `File > Project Structure > Project > SDK` menu and run the services in the following order:

> [!IMPORTANT]
> If "_Lombok requires enabled annotation processing_" dialog appears at this stage, click "_Enable annotation processing_" button.

- **config-service**
- **discovery-service**
- **gateway-service**
- the other services (**employee-service**, **department-service**, **organization-service**)

<br/>

### Testing the application
After starting the app, some test data is generated automatically and the following endpoints can be used in order to test services and communication between some services:

```
$ curl http://localhost:8060/employee/
$ curl http://localhost:8060/department/organization/1
$ curl http://localhost:8060/department/organization/1/with-employees
$ curl http://localhost:8060/organization/
$ curl http://localhost:8060/organization/1/with-departments
```

<br/>

Swagger UI page could be accessed on 

### Dependencies

* Spring Boot
* Spring Cloud
* Spring Cloud Netflix - Eureka
* Spring Cloud Config
* Spring Cloud OpenFeign
* Docker
* Zipkin

<br/>

### Documentation
[Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)<br/>
[Spring Cloud](https://spring.io/projects/spring-cloud/)<br/>
[Spring Cloud Netflix - Eureka](https://cloud.spring.io/spring-cloud-netflix/reference/html/)<br/>
[Spring Cloud Config](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/)<br/>
[Spring Cloud OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)<br/>
[Docker](https://www.docker.com/)<br/>
[Zipkin](https://zipkin.io/)<br/>

<br/>

### Version History

* v0.0.1 Initial Release

<br/>
<br/>
