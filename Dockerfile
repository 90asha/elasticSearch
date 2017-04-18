FROM niaquinto/gradle

RUN mkdir /app
ADD . /app
WORKDIR /app

COPY build.gradle .
COPY . .
RUN gradle build

EXPOSE 8080

CMD ["./gradlew","bootrun"]






