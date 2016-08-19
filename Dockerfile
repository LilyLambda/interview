FROM openjdk:8-jdk

WORKDIR /interview

# enable gradle daemon, since this is not a ci environment
RUN mkdir /root/.gradle
RUN echo 'org.gradle.daemon=true' > /root/.gradle/gradle.properties

# force caching of gradle
COPY /gradle ./gradle
COPY /gradlew ./gradlew
RUN ./gradlew

# copy in code and configs
COPY /build.gradle ./build.gradle
COPY /src ./src
