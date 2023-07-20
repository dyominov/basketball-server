FROM anapsix/alpine-java:8

# Install Maven
RUN apk add --no-cache maven

# Set the working directory
WORKDIR /home/app

# Copy the source code and pom.xml
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean install

# Copy the built JAR file to the working directory
COPY target/basketball.jar .

# Expose the port
EXPOSE 8080

# Run the application
CMD ["java", "-Xmx1G", "-jar", "basketball-2.1.4.RELEASE.jar"]
