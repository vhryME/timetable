FROM gradle:6.8.3-jdk11 AS build
COPY --chown=gradle:gradle . /src/
WORKDIR /src
RUN gradle build --no-daemon
EXPOSE 9090
ENTRYPOINT gradle bootRun