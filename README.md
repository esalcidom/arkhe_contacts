# arkhe_contacts
Personal business contact directory using Spring Boot and postregs as DB. Right now there is V1 file with first migration to run.

---

## Run application with Docker
First build postgresql image

docker build -t postgresql postgres:latest

Build application image with Dockerfile and jar file after build

docker build -t arkhe-app .

After this run docker compose to run one container with postgresql and another with application

docker compose up
