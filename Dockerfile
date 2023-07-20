FROM anapsix/alpine-java:8

# Required for starting application up.
RUN mvn clean install

COPY /target/basketball.jar /home/app
WORKDIR /home/app
EXPOSE 8080
CMD ["java", "-Xmx1G","-jar","./basketball.jar"]
