### Build Application

    mvn clean install

### Start RabbitMQ using docker

    docker-compose up

### Run car-parking-registration microservice

    mvn sprint-boot:run

### Start Car Parking using curl command

    curl --location 'http://localhost:8081/parking/register?parkingNumber=PARK001' \
    --header 'Content-Type: application/json' \
    --data '{
    "ownerName": "John Doe",
    "regNumber": "ABC123",
    "carModel": "Tesla",
    "fuelType": "Electric"
    }'


### Start MySQL using docker-compose in car-parking-process microservice

    docker-compose up

### Run car-parking-process microservice

    mvn sprint-boot:run

### Verify the running container

    docker ps

### Verify database

#### Windows

    docker exec -it container_name_or_id bash

#### Linux

    docker exec -it container_name_or_id /bin/bash

### Connect to mysql database

    mysql -u user -p

### Show database

    show databases;

### Select the database

    use parking;

### Display the table

    show tables;

### Execute mysql query

    select * from parking_status;

### End Car Parking using curl command

    curl --location --request POST 'http://localhost:8081/parking/close?regNumber=ABC123'

### Execute mysql query

    select * from parking_status;

### Exit from docker container

    exit

### Down the docker container

    docker-compose down
