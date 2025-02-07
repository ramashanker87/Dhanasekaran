## Import project
Import the project on either eclipse or inellij as a maven import project

## Building

```
$ mvn clean install
```

## Dockerization

```
$ docker build -t 8889docker/patient-app:0.0.1 .
```
## List docker images

```
$ docker images
```

### Running the application in docker container

```
$ docker run -p 8080:8080 8889docker/patient-app:0.0.1
```

## List docker running container

```
$ docker ps
```

## Create Docker Network

```
$ docker network create <network_name>
```

## Docker compose command

```
$ docker-compose -f docker-compose-patient.yml up
```