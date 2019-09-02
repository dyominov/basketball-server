FROM anapsix/alpine-java:8
COPY /target/basketball-2.1.4.RELEASE.jar /home/app
WORKDIR /home/app
EXPOSE 8080
CMD ["java", "-Xmx1G","-jar","./basketball.jar"]
