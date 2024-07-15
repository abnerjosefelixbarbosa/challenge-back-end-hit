# Challenge back end hit

## About

Technical challenge from Ame Digital.

# Project resource

## Backend java

- Java 17.
- Spring boot.
- Arquitetura limpa.
- SOLID.
- Lombok.
- Swegger.
- API SWAPI.
- PostgreSQL.
- JUnit 5.

## Function

- Add planet.
- List planets.
- Search for planet by name.
- Search for planet by id.
- Remove planet by id.

# End points

## Add planet

```JSON
POST
/api/planets
Content-Type: application/json

{
	"name": "";
        "climate": ""
	"terrain": "";
}
```

## List planets

```JSON
GET
/api/planets
```

##  Search for planet by name

```JSON
GET
/api/planets?name=
```

## Search for planet by id

```JSON
GET
/api/planets?id=
```

## Remove planet by id

```JSON
DELETE
/api/planets?id=
```

# Project execution

- Copy the repository.
- Import the project into an IDE.
- Run the project.
- Access the [API document](http://localhost:8080/swagger-ui/index.html) or use an API testing platform.
- Use [SWAPI API data](https://swapi.dev/).

```bash
# clone repository
git clone https://github.com/abnerjosefelixbarbosa/challenge-back-end-hit.git
```

# Author

Abner José Felix Barbosa

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/abner-jose-feliz-barbosa/)
