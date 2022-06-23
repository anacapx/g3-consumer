<h1 align="left">
  <img src="https://scontent.fcgh8-1.fna.fbcdn.net/v/t39.30808-6/289976373_1831753467021092_1415066520732617_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=730e14&_nc_eui2=AeHemTm85mGYGpEQE56ucVfxXf8q3M7fx65d_yrczt_HrtiTJxnjL4TKNWLpXSrAbicqtQZR1gObqpPUfH2jro06&_nc_ohc=1JQFZXHIX5sAX-PzHkv&_nc_ht=scontent.fcgh8-1.fna&oh=00_AT8mmJn7emQopNDKuBMeB-y9j7MPhwbSFLdGRpG5ZKrZ2A&oe=62B9E6F3" title="Kimchi Logo" width="400" />
</h1>

## 💻 Sobre o projeto

<p>Projeto elaborado para o desafio final do iLab, programa de aceleração de talentos em tech.
Consiste em um sistema que permite ao administrador, devidamente autenticado e autorizado, cadastrar e consultar pedidos e clientes. Foi realizado com uso de microsserviços, mensageria e deploy por pipeline em Kubernetes.</p>

- Para ver o repositório da **API Auth**, clique [aqui](https://github.com/anacapx/g3-auth)

- Para ver o repositório da **API User**, clique [aqui](https://github.com/anacapx/g3-user)

- Para ver o repositório da **API Order**, clique [aqui](https://github.com/anacapx/g3-order)

- Para acessar a aplicação diretamente no seu browser, acesse: http://g3kimchi.tk

### 👩🏽‍💻 Pessoas Desenvolvedoras

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
- SpringBoot
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

## 🏁 Iniciando o projeto

### Pré-requisitos

- Configure um banco de dados [PostgreSQL](https://www.postgresql.org/) na sua máquina e crie um novo banco.

### Passo a passo

**Clone o projeto e acesse a pasta:**

```bash
$ git clone https://github.com/anacapx/g3-consumer.git && cd g3-consumer
```

**Siga as etapas abaixo:**

Edite o arquivo "./src/main/resources/application.properties" com as configurações do seu banco de dados:

```
spring.datasource.username = seu_usuario
spring.datasource.password = sua_senha
spring.datasource.url = jdbc:postgresql://localhost:5432/nome_do_seu_banco
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQL10Dialect
spring.jpa.show_sql = true
springdoc.api-docs.path=/api-docs
```

**Configure variáveis de ambiente:** 
```
KAFKA_HOST = seu_host
KAFKA_TOPIC = seu_topic
EMAIL_SENDER = email cadastrado na conta aws
```
E rode o projeto na sua IDE.

Tudo pronto! A aplicação está recebendo mensagens do Kafka. 

## 📄 Formato de Mensagens recebidas

```
key: "1"
value: "{\"id\":1,\"user\":{\"name\":\"Username\",\"phone\":\"123\",\"email\":\"recipient@email.com\"},\"value\":178.9,\"products\":\"a list of products\",\"date\":" + "\"" + "2022-01-01 + "\",\"status\":\"PENDING\"}"

```

## ⚙️ Funcionalidades

- Ler mensagens do Kafka;
- Enviar email ao cliente;
- Alterar o status do pedido.

## 📄 Licença

Este projeto está sob a licença de G3 Corp.

