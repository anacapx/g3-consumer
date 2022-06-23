<h1 align="center" font-style="bold">
Kimchi - G3
</h1>

## 💻 Sobre o projeto

- <p style="color: red;">Projeto destinado a criação de pedidos por um administrador com mensageria e deploy em kubernetes</p>

Para ver o repositório da **API Auth**, clique aqui: [API Auth](https://github.com/anacapx/g3-auth)

Para ver o repositório da **API User**, clique aqui: [API User](https://github.com/anacapx/g3-user)

Para ver o repositório da **API Order**, clique aqui: [API Order](https://github.com/anacapx/g3-order)

Para acessar a aplicação diretamente no seu browser ou smartphone, acesse https://http://g3kimchi.tk//

## 👨🏻‍💻 Desenvolvedores

- [Ana Carolina Amaral](https://github.com/anacapx)
- [Alessandro Costa](https://github.com/ab-costa)
- [Debora Brum](https://github.com/DeboraBrum)
- [Ester Lourenco](https://github.com/elolourenco)
- [Lisandre Andreolo](https://github.com/lisdrl)

## 💡 Mentor

- [Rafael Oliveira](https://www.linkedin.com/in/rafaelsomartins/)

## 🚀 Tecnologias

Tecnologias que utilizamos para desenvolver esta API Rest:

- Java
- Spring
- PostgreSQL
- Swagger
- Kafka
- Gitlab
- JUnit
- Mockito
- Kubernetes
- Docker
- AWS
- New Relic

## ▶️ Iniciando

- As instruções a seguir irão te guiar para que você crie uma cópia do projeto na sua máquina local.

### Pré-requisitos

- Configure um banco de dados [PostgreSQL](https://www.postgresql.org/) na sua máquina e crie um novo banco.

**Clone o projeto, e acesse a pasta**

```bash
$ git clone https://github.com/anacapx/g3-consumer.git && cd g3-consumer
```

**Siga as etapas abaixo**

Edite o arquivo "./src/main/resources/application.properties" com as configurações do seu banco de dados:

```
spring.datasource.username = seu_usuario
spring.datasource.password = sua_senha
spring.datasource.url = jdbc:postgresql://localhost:5432/nome_do_seu_banco
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQL10Dialect
spring.jpa.show_sql = true
springdoc.api-docs.path=/api-docs
```
Configure variáveis de ambiente: 
```
KAFKA_HOST = seu_host
KAFKA_TOPIC = seu_topic
EMAIL_SENDER = email cadastrado na conta aws

E rode o projeto na sua IDE.

Tudo pronto! A aplicação está recebendo mensagens do kafka. 

## 📄 Formato de Mensagens recebidas

```
key: "1"
value: "{\"id\":1,\"user\":{\"name\":\"Username\",\"phone\":\"123\",\"email\":\"recipient@email.com\"},\"value\":178.9,\"products\":\"a list of products\",\"date\":" + "\"" + "2022-01-01 + "\",\"status\":\"PENDING\"}"

```

## ⚙️ Funcionalidades

- Ler mensagens do kafka;
- Enviar email ao cliente;
- Alterar o status do pedido.

## 📄 Licença

Este projeto está sob a licença de G3 Corp.

