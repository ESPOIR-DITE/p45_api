#FROM openjdk:8
#ADD target/ostm-0.0.1-SNAPSHOT.jar ostmApi
#EXPOSE 8085
#ENTRYPOINT ["java", "-jar","ostmApi"]


FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD


MAINTAINER Espoir D


COPY pom.xml /build/

COPY src /build/src/

WORKDIR /build/

RUN mvn package

FROM openjdk:8


WORKDIR /app


COPY --from=MAVEN_BUILD /build/target/p45_api.jar /app/

EXPOSE 8089

ENTRYPOINT ["java", "-jar","p45_api.jar"]

##From doctor Kab
#<plugin>
#  <groupId>com.spotify</groupId>
#  <artifactId>dockerfile-maven-plugin</artifactId>
#  <version>${dockerfile-maven-version}</version>
#  <executions>
#    <execution>
#      <id>default</id>
#      <goals>
#        <goal>build</goal>
#        <goal>push</goal>
#      </goals>
#    </execution>
#  </executions>
#  <configuration>
#    <repository>spotify/foobar</repository>
#    <tag>${project.version}</tag>
#    <buildArgs>
#      <JAR_FILE>${project.build.finalName}.jar</JAR_FILE>
#    </buildArgs>
#  </configuration>
#</plugin>



## Build Stage for Spring boot application image
#FROM openjdk:8-jdk-alpine as build
#
#WORKDIR /app
#
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#
#RUN chmod +x ./mvnw
## download the dependency if needed or if the pom file is changed
#RUN ./mvnw dependency:go-offline -B
#
#COPY src src
#
#RUN ./mvnw package -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
#
## Production Stage for Spring boot application image
#FROM openjdk:8-jre-alpine as production
#ARG DEPENDENCY=/app/target/dependency
#
## Copy the dependency application file from build stage artifact
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#EXPOSE 8089
## Run the Spring boot application
#ENTRYPOINT ["java", "-cp", "app:app/lib/*","company.ac.za.studentbookstore.StudentbookstoreApplication"]

#FROM openjdk:8-jdk-alpine
#MAINTAINER Espoir
#VOLUME /tmp
#WORKDIR /app
#ARG JAR_FILE=target/*.jar
##COPY ${JAR_FILE} app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/StudentbookstoreApplication.jar"]

#FROM openjdk:8 AS MAVEN_BUILD
#MAINTAINER Espoir d
#COPY pom.xml /build/
#COPY src /build/src/
#WORKDIR /build/
#FROM openjdk:8-jre-alpine
#WORKDIR /app
#COPY --from=MAVEN_BUILD /build/target/studentbookApi.jar /app/
#ENTRYPOINT ["java", "-jar", "studentbookApi.jar"]

#FROM openjdk:8-jdk-alpine
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]