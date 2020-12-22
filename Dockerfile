FROM openjdk:8-jdk-alpine

COPY target/*.jar app.jar

RUN apk add --update --no-cache libcrypto1.0 libssl1.0 \
    --repository http://dl-cdn.alpinelinux.org/alpine/v3.8/main

RUN apk add --update --no-cache \
    libgcc libstdc++ libx11 glib libxrender libxext libintl \
    libcrypto1.0 libssl1.0 \
    ttf-dejavu ttf-droid ttf-freefont ttf-liberation ttf-ubuntu-font-family

VOLUME /logs

ENTRYPOINT ["java","-jar","/app.jar"]