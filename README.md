# TMC Case Study

This application is consist of two Backend REStful API projects using Java Spring Boot
with

- CQRS (Command Query Responsibility Segregation)
  Patterns https://martinfowler.com/bliki/CQRS.html and
- Hexagonal Architecture
  https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749

## Kafka and Elastic Database

### Using Docker to simplify development (optional)

To start a kafka and elastic database in a docker container, run:

```
docker-compose -f src/main/docker/<file-name>.yml up -d
```

To stop it and remove the container, run:

```
docker-compose -f src/main/docker/<file-name>.yml down
```

## API Spec

### Authentication :

For Backend Command API and Backend Query API, use simple
API-KEY Authentication :

Headers :
- Authorization : API-KEY

You can find the api key in `src/main/resources/application.yml` file :

```
project:
  api:
    key: <api-key-value>
```

## Backend Command API

### Create Category API :

- Endpoint : POST /api/categories

### Create Product API :

- Endpoint : /api/products
- Request Body :
```
{
    "sku" : "SKU"
    "name" : "Product Name",
    "price" : 1000000,
    "stock" : 100,
    "categoryId" : "categoryId"
}
```

- Success Response :
```
{
    "data" : {
        "id" : "uuid",
        "sku" : "sku"
        "name" : "Product Name",
        "price" : 1000000,
        "stock" : 100,
        "category" : {
            "id" : "uuid",
            "name" : "Category Name"
        },
        "createdAt" : 1234556 // epoch time milis
    }
}
```

- Error Response :
```
{
    "errors" : {
        "sku" : [
            "sku is empty",
            "sku is unique"
        ],
        "name" : [
            "name is empty",
            "name length must not more than 255
            characters”
        ],
        "price" : [
            "price must not negative"
        ],
    }
}
```

## Backend Query API

### Search API

- Endpoint : /api/search

## Implementations

- Validation
- Different Database for Command API and Query API
- Using Message Broker to Sync Between Command API
  and Query API

## Work in progress
- Backend Query API, there are some issue on `@RequestParam`, so currently this feature only support two parameter: `sku, name`

## What's next
- Unit Test
- Database Migration (Create Table, Index, etc)