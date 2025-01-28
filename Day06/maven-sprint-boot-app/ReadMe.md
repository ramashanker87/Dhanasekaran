# Spring boot Application

## Build Maven project

```Bash
    mvn clean install
```
## Run Spring Boot Application

```Bash
    mvn spring-boot:run
```
## Run Spring Boot with profile

```Bash
    mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

```Bash
    mvn spring-boot:run -Dspring-boot.run.profiles=test
```

## To Find Open PortNumber

```Bash
    netstat -ano | findstr :<PortNumber>
```

## To Kill the Port Using PID

```Bash
    taskkill /PID <PID> /F
```