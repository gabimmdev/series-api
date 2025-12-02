# 📺 API de Cadastro de Séries – Exame FIAP Java Advanced

Esta API foi desenvolvida para o Exame de Java Advanced, seguindo todos os requisitos da prova.

## 🚀 Tecnologias utilizadas
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
