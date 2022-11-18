FROM maven:3.8.3-openjdk-17
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn clean test
