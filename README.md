[![Typing SVG](https://readme-typing-svg.herokuapp.com/?color=6F27E3&size=35&center=true&vCenter=true&width=1000&lines=+API+-+Cadastro+de+Séries+)](https://git.io/typing-svg)

## 🚀 Tecnologias utilizadas
- Java
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Validation
- H2 Database

---

## 📌 Endpoints
<p><strong>AO FAZER O POST RETORNARÁ O ID NO JSON, USE ELE PARA BUSCAR POR ID</strong></p>

### ➕ Adicionar série
`POST /series`

Exemplo JSON:
```json
{
  "nome": "Breaking Bad",
  "genero": "Drama",
  "anoLancamento": 2008,
  "temporadas": 5,
  "classificacao": "16+"
}
```

### 🔎 Listar séries (com paginação)
`GET /series?page=0&size=10`

### 🔎 Buscar por ID
`GET /series/{id}`
