Basic Shortened-URL API

## Technology Stack
- Java 1.8 (SpringBoot)
- Maven 3.6
- H2 database

## Run

Using Docker:
- Download `shortened-url-0.0.1-SNAPSHOT.jar` file from Releases.
- Run docker run -p 8080:8080 -v `pwd`:/mnt java:8 java -jar mnt/shortened-url-0.0.1-SNAPSHOT.jar (make sure to run this command from same directory as your jar file or specify path to jar while running docker command)

Spring Boot Run:
- Download and extract Maven 3.6 from https://maven.apache.org/download.cgi. Make sure `MAVEN_HOME` ENV Var is present in the PATH
- Download and install JRE 1.8. Make sure `JAVA_HOME` ENV Var is present in the PATH
- Go to root directory of `shortened-url` and run `mvn spring-boot:run`

## Test

http method: `POST` using curl
`curl -X POST -H "Content-Type: application/json" -d @post.json localhost:8080/api/v1/url/short`

success response body (http status `200`):  
```
{
    "shortUrl": "http://localhost:8080/short/cssa"
}
```

failure response body (http status `400`):
```
{
    "errorMessage": "Entered URL is invalid"
}
```
