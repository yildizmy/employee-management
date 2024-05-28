## How to test?

After starting the app, some test data is generated automatically.

<br/>

### Open API (Swagger) UI

For Open API (Swagger) Documentation UI and the endpoints, open http://localhost:8060/swagger-ui/index.html after running the app.

<br/>

### Postman Collection

The [Postman Collection](postman/employee_management.postman_collection.json) shared in the resources can be modified and used
for testing the endpoints.

<br/>

### API Endpoints

> [!NOTE]
> All URIs are relative to *http://localhost:8060*


<br/>

| Class              | Method                                                                | HTTP request                        | Description                                             |
|--------------------|-----------------------------------------------------------------------|-------------------------------------|---------------------------------------------------------|
| *EmployeeController* | [**add**](http://localhost:8060/employees/)                           | **POST** /employees/addFunds        | Adds a new employee                                     |
| *EmployeeController* | [**findAll**](http://localhost:8060/employees)                        | **GET** /employees                  | Retrieves all employees                                 |
| *EmployeeController* | [**findById**](http://localhost:8060/employees/{id})                  | **GET** /employees/{id}             | Retrieves a single employee by the given id             |
| *EmployeeController* | [**findByDepartmentId**](http://localhost:8060/employees/departments/{id})       | **GET** /employees/departments/{id} | Retrieves a single employee by the given department id   |
| *EmployeeController* | [**findByOrganizationId**](http://localhost:8060/employees/organizations/{id})       | **GET** /employees/organizations/{id} | Retrieves a single employee by the given organization id   |

<br/>
<br/>










<br/>


### API Endpoints

The following endpoints can be used in order to test services and communication between some services:

```
$ curl http://localhost:8060/employee/
$ curl http://localhost:8060/department/organization/1
$ curl http://localhost:8060/department/organization/1/with-employees
$ curl http://localhost:8060/organization/
$ curl http://localhost:8060/organization/1/with-departments
```

<br/>



