# Projeto de Integração com RabbitMQ - Pagamentos

Este projeto utiliza **RabbitMQ** como broker de mensageria para lidar com requisições e respostas de pagamentos.  
As filas e exchanges precisam ser criadas manualmente no painel do RabbitMQ (ou via script de configuração).

---

## 🚀 Tecnologias

- [Java / Spring Boot] (ou outra linguagem usada no projeto)
- [RabbitMQ](https://www.rabbitmq.com/) (mensageria)
- [Docker Compose](https://docs.docker.com/compose/) (infraestrutura)

---

## 📦 Subindo o RabbitMQ

O RabbitMQ está configurado para rodar em **Docker Compose**.  
Na raiz do projeto, execute:

```bash
docker-compose up -d
````

## O painel de administração ficará disponível em:
👉 http://localhost:15672

Usuário: guest

Senha: guest

## 🔧 Configuração das Exchanges, Filas e Bindings

Após o RabbitMQ estar rodando, é necessário criar as exchanges, filas e vincular com suas routing keys.

## 📨 Exchanges

pagamento-request-exchange

pagamento-response-success-exchange

pagamento-response-error-exchange

## 📥 Filas

pagamento-request

pagamento-response-success

pagamento-response-error

## 🔗 Bindings

a) pagamento-request-exchange

routing key: pagamento-request-rout-key

queue: pagamento-request

b) pagamento-response-success-exchange

routing key: pagamento-response-success-rout-key

queue: pagamento-response-success

c) pagamento-response-error-exchange

routing key: pagamento-response-error-rout-key

queue: pagamento-response-error

## 🛠 Passo a passo no painel do RabbitMQ

Acesse http://localhost:15672
.

Vá em Exchanges → Add a new exchange → Informe o nome e o tipo (direct).

Vá em Queues → Add a new queue → Informe o nome da fila.

Em Bindings, vincule a fila à exchange usando a routing key correspondente.

## 📌 Fluxo de Mensagens

A aplicação publica uma mensagem na exchange pagamento-request-exchange, usando a routing key pagamento-request-rout-key.

A fila pagamento-request recebe a mensagem e processa.

A resposta será publicada em uma das exchanges de resposta:

Sucesso: pagamento-response-success-exchange → pagamento-response-success

Erro: pagamento-response-error-exchange → pagamento-response-error

## ▶️ Executando a aplicação

Após configurar as filas e exchanges, basta rodar sua aplicação:

./mvnw spring-boot:run

## 📖 Observações

É importante que as routing keys utilizadas no código da aplicação correspondam exatamente às configuradas no RabbitMQ.
