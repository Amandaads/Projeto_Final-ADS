# 🏥 Projeto Final - Sistema de Gestão Multidisciplinar Hospitalar

Este é o back-end de um sistema de gestão hospitalar desenvolvido como Projeto Final. A aplicação consiste em uma API REST robusta construída com Spring Boot, responsável por gerenciar o fluxo de usuários, pacientes e médicos.

---

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência e mapeamento de dados)
* **Validation** (Validação de payloads com `@Valid`)
* **Flyway Migrations** (Controle de versão do banco de dados)
* **PostgreSQL** (Banco de dados relacional)
* **Maven** (Gerenciador de dependências)

---

## 📊 Estrutura e Arquitetura do Projeto

O projeto segue o padrão arquitetural em camadas para facilitar a manutenção e garantir uma boa separação de conceitos (*Separation of Concerns*):

* **`Domain`**: Entidades que mapeiam as tabelas do banco de dados (ex: `Usuario`, `Paciente`, `Medico`).
* **`DTO (Data Transfer Object)`**: Padrão utilizando Java *Records* para validação e tráfego seguro de dados entre o cliente (Postman/Front-end) e a API.
* **`Repository`**: Interfaces que estendem o `JpaRepository`, responsáveis pelas operações de CRUD direto no banco.
* **`Service`**: Camada de regras de negócio da aplicação, onde ocorrem as amarrações de entidades e conversões de dados.
* **`Controller`**: Endpoints expostos da API que recebem as requisições HTTP e retornam os status codes corretos (ex: `201 Created`, `200 OK`, `404 Not Found`).

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos
* Java 21 instalado.
* Instância do PostgreSQL rodando localmente.

### Passos para Configuração:
1. Clone o repositório para a sua máquina local.
2. Abra o arquivo `src/main/resources/application.properties` e configure as credenciais do seu banco de dados:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5123/nome_do_seu_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha


3.Execute a aplicação através da sua IDE (IntelliJ/Eclipse) ou via terminal com o comando:



Endpoints da API

Pacientes

POST /pacientes: Cadastra um novo paciente e cria automaticamente suas credenciais de acesso vinculadas na tabela de usuários (CascadeType.ALL).

PUT /pacientes/{id}: Atualiza dados específicos (Nome, Telefone, Endereço, Nascimento) de um paciente existente baseado no seu UUID.

Médicos

POST /medicos: Cadastra um médico associando o seu CRM, especialidade e criando seu login com perfil MEDICO.

PUT /medicos/{id}: Atualiza informações profissionais e de contato do médico.


# Exemplos de Requisições (JSON)


Cadastro de Paciente 

(POST /pacientes)

JSON
{

    "nome": "Carlos Silva",
    "cpf": "12345678901",
    "telefone": "11999998888",
    "nascimento": "1995-10-25",
    "endereco": "Rua das Flores, 123",
    "email": "carlos.paciente@email.com",
    "senha": "senhaDoPaciente123"
}


Cadastro de Médico

(POST /medicos)

JSON
{

    "nome": "Dr. Arnaldo Almeida",
    "crm": "CRM/SP 123456",
    "especialidade": "Cardiologia",
    "telefone": "11988887777",
    "email": "arnaldo.medico@hospital.com",
    "senha": "senhaDoMedico123"
    
}

