FROM openjdk:17-oracle
ARG JAR_FILE=target/products-1.jar
WORKDIR /opt/app

COPY ${JAR_FILE} products-1.jar

COPY entrypoint.sh entrypoint.sh

RUN chmod 755 entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]