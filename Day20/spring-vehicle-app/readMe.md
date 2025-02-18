## Spring Logging App using Vehicle Owner Registration Details

### Build Application
```
mvn clean install
```

### Start SpringBoot Application
```
mvn spring-boot:run
```

### Register Vehicle and Owner Details using POST API

curl --location 'http://localhost:8080/register/vehicle'

Application Json:-

'{
    "vehicle": {
    "vehicleNumber": "IND123",
    "vehicleType": "Sedan",
    "fuelType": "Petrol"
    },
    "owner": {
    "name": "Owner1",
    "address": "123 Main St",
    "age": 28
    }
}'

### Retreive Vehicle and Owner Details using GET API

curl --location 'http://localhost:8080/retrieve/vehicle?vehicleNumber=IND123'

### Delete Vehicle and Owner Details using DELETE API

curl --location --request DELETE 'http://localhost:8080/deregister/vehicle?vehicleNumber=IND123'

### Logging Properties

### Set root logging level
logging.level.root=DEBUG

### Set Logging level for specific packages
logging.level.com.vehicle.app.model.Vehicle=INFO

logging.level.com.vehicle.app.model.Owner=DEBUG

### Output logs to file
logging.file.name=vehicle.log

logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n

### Dynamically updating the logging level at Runtime
management.endpoints.web.exposure.include=loggers

```
http://localhost:8080/actuator/loggers
```
```
curl --location 'http://localhost:8080/actuator/loggers/com.vehicle.app' \
--header 'Content-Type: application/json' \
--data '{
   "configuredLevel": "TRACE"
}'
```
```
curl --location 'http://localhost:8080/actuator/loggers/com.vehicle.app.model.Vehicle' \
--header 'Content-Type: application/json' \
--data '{
   "configuredLevel": "DEBUG"
}'
```
```
curl --location 'http://localhost:8080/actuator/loggers/com.vehicle.app.model.Owner' \
--header 'Content-Type: application/json' \
--data '{
   "configuredLevel": "INFO"
}'
```