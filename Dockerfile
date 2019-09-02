FROM anapsix/alpine-java

# Required for starting application up.
RUN apk update && apk add bash

WORKDIR /home/app
COPY ./target/rm-web.jar ./basketball.jar

CMD ["java", "-Xmx1G","-jar","./basketball.jar"]

EXPOSE 8080