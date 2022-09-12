# TMC Case Study

This application is consist of two Backend REStful API projects using Java Spring Boot
with

- CQRS (Command Query Responsibility Segregation)
  Patterns https://martinfowler.com/bliki/CQRS.html and
- Hexagonal Architecture
  https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749

## API Spec

### Authentication :

For Backend Command API and Backend Query API, use simple
API-KEY Authentication :

## Backend Command API

### Create Category API :

- Endpoint : POST /api/categories

### Create Product API :

- Endpoint : /api/products

## Backend Query API

### Search API

- Endpoint : /api/search

## Implementations

- Validation
- Different Database for Command API and Query API
- Using Message Broker to Sync Between Command API
  and Query API

## Work in progress

- Unit Test
- Database Migration (Create Table, Index, etc)