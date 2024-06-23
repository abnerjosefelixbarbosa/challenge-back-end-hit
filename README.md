# challenge-back-end-hit

## About

Desafio tecnico da AmeDigital.

# Project resource

## Backend java

- Java 17
- Spring boot.
- Clean arch.
- SOLID.
- Lombok
- Swegger.
- API SWAPI.
- PostgreSQL.
- JUnit 5.

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

## Search planet by name

```JSON
GET
/api/planets?name=
```

## Search planet by id

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

- Copie o repositório.
- Importe o projeto em uma IDE Java.
- Excute o projeto.
- Acesse o [documento da API](http://localhost:8080/swagger-ui/index.html) ou use um plataforma para teste de API.
- Use [dados da API SWAPI](https://swapi.dev/).

```bash
# clone repository
git clone https://github.com/abnerjosefelixbarbosa/challenge-back-end-hit.git
```

# Author

Abner José Felix Barbosa

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/abner-jose-feliz-barbosa/)
