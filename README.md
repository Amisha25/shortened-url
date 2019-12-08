Basic Shortened-URL API

Technology Stack
- Java 1.8 (SpringBoot)
- Maven 3.6
- H2 database

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
