# Challenge back end hit

## Sobre

Desafio técnico da Ame Digital.

[link do desafio](https://github.com/AmeDigital/challenge-back-end-hit)

# Recursos do projeto

## Backend java

- Java 17.
- Spring boot.
- Arquitetura limpa.
- SOLID.
- Hibernate JPA.
- Lombok.
- Swegger.
- API SWAPI.
- PostgreSQL.
- JUnit 5.

## Funcionalidades

- Adicinar planeta.
- Listar planetas.
- Pesquisa planeta pelo nome.
- Pesquisar planeta pelo id.
- Remover planeta pelo id.

# Requisições 

## Adicinar planeta

```JSON
POST
/api/planets/add-planet
Content-Type: application/json

{
	"name": "";
        "climate": ""
	"terrain": "";
}
```

## Listar planetas

```JSON
GET
/api/planets/list-planets
```

##  Pesquisa planeta pelo nome

```JSON
GET
/api/planets/search-planet-by-name?name=
```

## Pesquisar planeta pelo id

```JSON
GET
/api/planets/search-planet-by-id?id=
```

## Remover planeta pelo id

```JSON
DELETE
/api/planets/remove-planet-by-id?id=
```

# Execução do projeto

- Copie e execute o repositório em uma IDE.
- Acesse o [documento da API](http://localhost:8080/swagger-ui/index.html) ou use outra plataforma.
- Use [SWAPI API data](https://swapi.dev/).

```bash
# clone repository
git clone https://github.com/abnerjosefelixbarbosa/challenge-back-end-hit.git
```

# Autor

Abner José Felix Barbosa

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/abner-jose-feliz-barbosa/)
