# Bilgeadam Fullstack Project with Spring Boot, React, Docker, JIB, AWS, Github Actions and Postgresql

## Commands Guide

Generate local Docker image with JIB; 

### `mvnw clean install jib:dockerBuild -Djib.to.image=bilgeadam-fullstack:v1`

Run generated local Docker image;

### `docker run --name bilgeadam-fullstack -p 8080:8080 bilgeadam-fullstack:v1`

Generate Docker image with JIB and push to Docker HUB;

### `mvnw clean install jib:build -Djib.to.image=korayguney/bilgeadam-fullstack:v1` (after docker login via CLI)
### `mvnw clean install jib:build -Djib.to.image=korayguney/bilgeadam-fullstack:v1 -D jib.to.auth.username=korayguney -Djib.to.auth.password=<yourpassword>` (without docker login)

Generate Docker image with JIB using maven profile;
### `mvn clean install -P build-frontend -P jib-push-to-local -Dapp.image.tag=v2` (to local)
### `mvn clean install -P build-frontend -P jib-push-to-dockerhub -Dapp.image.tag=v2` (to Docker Hub)

Postgres Docker Configuration
-------
create network;
### `docker network create db`

Generate Postgresql docker image;
### `docker run --name db -p 5432:5432 --network=db -v "%cd%:/var/lib/postgresql/data" -e POSTGRES_PASSWORD=password -d postgres:alpine` (Windows)
### `docker run --name db -p 5432:5432 --network=db -v "$PWD:/var/lib/postgresql/data" -e POSTGRES_PASSWORD=password -d postgres:alpine` (MAC,Linux)

Generate and connect to Postgresql Docker Image with psql;
### `docker run -it --rm --network=db postgres:alpine psql -h db -U postgres`
