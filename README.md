## <p align="center"> 🏆 Arremate Certo 🏆</p>

<p align="center"> 

  [![Java CI](https://github.com/Bulletdev/Arremate-certo/actions/workflows/ant.yml/badge.svg)](https://github.com/Bulletdev/Arremate-certo/actions/workflows/ant.y)
  [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Bulletdev_Arremate-certo&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Bulletdev_Arremate-certo)
  <img src="https://img.shields.io/badge/status-em_desenvolvimento-yellow">  <img src="https://img.shields.io/badge/release_date-Março_2025-blue"></p>

<p align="center">
Arremate Certo é uma solução moderna de automação para licitações públicas e dispensas. 
</p>

<p align="center">
  <img src="https://img.shields.io/badge/versão-2.0-brightgreen">
  <img src="https://img.shields.io/badge/licença-Apache_2.0-blue">
  <img src="https://img.shields.io/badge/Java-17-orange">
  <img src="https://img.shields.io/badge/Go-1.21-cyan">
  <img src="https://img.shields.io/badge/Spring_Boot-3.2-green"> 
</p>


## 📋 Índice
1. [Status do Projeto](#-Status-do-projeto)
2. [Arquitetura do Projeto](#-arquitetura-do-projeto)
   - [Frontend (Java Application)](#-frontend-java-application)
   - [Backend (Go API)](#-backend-go-api)
3. [Funcionalidades Principais](#-funcionalidades-principais)
4. [Pré-requisitos](#️-pré-requisitos)
5. [Como Executar](#-como-executar)
6. [Contribuindo](#-contribuindo)
7. [Licença](#-licença)
8. [Suporte](#-suporte)
   

## 🏗️ Arquitetura do Projeto

O projeto é dividido em dois componentes principais:

### 📱 Frontend (Java Application)

- Desenvolvido em Java 17 com Spring Boot 3.2
- Interface do usuário intuitiva e responsiva
- Documentação OpenAPI/Swagger integrada
- Persistência com JPA e H2 Database
- Criptografia com Bouncy Castle

### ⚡ Backend (Go API)

- Desenvolvido em Go 1.21
- Framework Gin para alta performance
- ORM com GORM
- Configuração flexível via variáveis de ambiente
- Captcha Solver com  Wrapper 2Captcha e go-hcaptcha

## 🎯 Funcionalidades Principais

- 🔄 **Automação de Lances:** Defina regras personalizadas para lances automáticos
- 📊 **Relatórios de Participação:** Geração de relatórios detalhados sobre o desempenho em cada licitação
- 🔗 **Integração com Portais:** Conexão facilitada com diversos portais públicos e privados
- 🔐 **Gestão de Dados:** Armazenamento seguro e eficiente das informações
- 📈 **Performance Otimizada:** Backend em Go para processamento rápido de requisições

## ⚙️ Pré-requisitos

### Para a Aplicação Java

- Java 17 ou superior
- Gradle
- IDE compatível com Spring Boot (recomendado: IntelliJ IDEA )

### Para a API Go

- Go 1.21 ou superior
- PostgreSQL
- Docker (opcional)

## 🚀 Como Executar

### Aplicação Java

```bash
cd java-app
./gradlew bootRun
```
A aplicação estará disponível em `http://localhost:8080`

### API Go
```bash
cd go-api
go mod tidy
go run main.go
```
A API estará disponível em `http://localhost:8081`



## 🛠️ Contribuindo

1. Faça um fork do projeto
2. Crie uma branch: `git checkout -b feature/nova-funcionalidade`
3. Faça o commit das alterações: `git commit -m 'Adiciona nova funcionalidade'`
4. Envie para o repositório: `git push origin feature/nova-funcionalidade`
5. Crie um Pull Request

## 📜 Licença

Distribuído sob a licença Apache 2.0. Veja `LICENSE` para mais informações.

## 🔧 Suporte

Em caso de dúvidas ou problemas, abra uma issue no repositório.


## Feito com 💙 por Michael Bullet
