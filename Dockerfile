FROM openjdk:8-jre-alpine

# Copy app to new directory
RUN mkdir -p /usr/spark
COPY build/libs/spark-starter-0.1.0.jar /usr/spark

# Work out of the directory
WORKDIR /usr/spark

# Expose http ports
EXPOSE 8080 8443

# Start java application
CMD ["java","-jar","spark-starter-0.1.0.jar"]
