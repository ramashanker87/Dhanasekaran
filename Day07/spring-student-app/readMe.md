# Spring Student App

### Build Maven

```bash
    mvn clean install
```

### Run SpringBoot App

```bash
    mvn spring-boot:run
```

## Student Application Rest Endpoints in Postman 

### Actuator Health Check Endpoint

    Get http://localhost:8080/actuator/health

### Create Student Using Post Endpoint

    Post http://localhost:8080/student/post

    json type:

        {
        "name": "Student",
        "age": 25,
        "roll": "Roll01"
        }

### Read Student Data Using Get Endpoint

    Get http://localhost:8080/student/get

    Query Parameter: name 

### Update Student Data Using Put Endpoint

    Put http://localhost:8080/student/put

    Parameter: name and age

### Delete Student Data Using Delete Endpoint

    Delete http://localhost:8080/student/delete

    Parameter: name