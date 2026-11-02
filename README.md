
# CRUD Spring Boot - API de Usuários

Projeto backend desenvolvido em **Java 21** e **Spring Boot**, estruturado em camadas (Controller, Service, Repository, Model) nos moldes de arquiteturas corporativas modernas. O objetivo é gerenciar o cadastro de usuários integrado a um banco de dados PostgreSQL.

---

## 🛠 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.x**
* **Spring Data JPA** (Hibernate ORM)
* **Spring Web** (Controladores REST e Tomcat embutido)
* **PostgreSQL Driver**
* **dotenv-java** (Gerenciamento seguro de variáveis de ambiente via `.env`)
* **Maven** (Gerenciamento de dependências e build)

---

## 📁 Arquitetura do Projeto

O projeto segue rigorosamente o padrão de separação de responsabilidades em camadas:

```text
src/main/java/com/treino/crud/
│
├── controller/         # Camada de Entrada / Rotas HTTP (Endpoints REST)
├── model/              # Entidades JPA (Mapeamento da tabela "users" no Banco de Dados)
├── repository/         # Interfaces de Acesso a Dados (Spring Data JPA)
├── service/            # Camada de Regra de Negócio
└── CrudSpringbootApplication.java # Ponto de entrada da aplicação

```

---

## ⚙️ Configuração e Execução

### 1. Configurar as Variáveis de Ambiente

Crie um arquivo chamado **`.env`** na raiz do projeto contendo as credenciais de acesso ao seu PostgreSQL:

```env
DB_HOST=localhost
DB_PORT=5432
DB_NAME=treinojava
DB_USER=postgres
DB_PASS=sua_senha_aqui

```

### 2. Rodar a Aplicação

No terminal, utilize o Maven para compilar e iniciar a aplicação:

```cmd
mvn spring-boot:run

```

A aplicação iniciará na porta **`8080`** (`http://localhost:8080`).

---

## 🚀 Documentação das Rotas (Endpoints)

Abaixo estão listadas as rotas disponíveis na API para o gerenciamento de usuários. Todas as requisições e respostas utilizam o formato **JSON**.

### 1. Listar Todos os Usuários

Retorna uma lista com todos os usuários cadastrados no banco de dados.

* **Método:** `GET`
* **Rota:** `/users`
* **Exemplo de Resposta (`200 OK`):**
```json
[
  {
    "id": 1,
    "name": "Romulo Lobato",
    "email": "romulo@email.com",
    "age": 24
  }
]

```



---

### 2. Cadastrar Novo Usuário

Cria um novo registro de usuário no banco de dados.

* **Método:** `POST`
* **Rota:** `/users`
* **Headers:** `Content-Type: application/json`
* **Exemplo de Corpo (Body):**
```json
{
  "name": "Maria Silva",
  "email": "maria@email.com",
  "age": 28
}

```


* **Exemplo de Resposta (`201 Created`):**
```json
{
  "id": 2,
  "name": "Maria Silva",
  "email": "maria@email.com",
  "age": 28
}

```



---

### 3. Atualizar Usuário

Atualiza as informações de um usuário existente com base no seu `id`.

* **Método:** `PUT`
* **Rota:** `/users/{id}` (Exemplo: `/users/2`)
* **Headers:** `Content-Type: application/json`
* **Exemplo de Corpo (Body):**
```json
{
  "name": "Maria Silva Souza",
  "email": "maria.souza@email.com",
  "age": 29
}

```


* **Exemplo de Resposta (`200 OK`):**
```json
{
  "id": 2,
  "name": "Maria Silva Souza",
  "email": "maria.souza@email.com",
  "age": 29
}

```



---

### 4. Deletar Usuário

Remove um usuário do banco de dados com base no seu `id`.

* **Método:** `DELETE`
* **Rota:** `/users/{id}` (Exemplo: `/users/2`)
* **Exemplo de Resposta (`204 No Content`):** Corpo da resposta vazio indicando sucesso na remoção.
