# Spring 7 - REST MVC

## Documentations

* [OpenAPI](./openapi/openapi.json)
* [Beer](./docs/BEER.md)
* [Customer](./docs/CUSTOMER.md)

## References

* [SFG Brewery API](https://sfg-beerDTO-works.github.io/brewery-api/)
* [JSON Path](https://github.com/json-path/JsonPath)
* [MapStruct Documentation](https://mapstruct.org/documentation/reference-guide/)
* [Spring Docs - Testcontainers](https://docs.spring.io/spring-boot/reference/testing/testcontainers.html)
* [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/)
* [surefire:test](https://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html)

---

## Banco de Dados MySQL

- [Script MySQL](./src/scripts/mysql-init.sql)

### Configuração

- Host: `localhost`
- Porta: `3306` (porta padrão do MySQL)
- Banco: `restdb`
- Usuário: `restadmin` (substituir pelo seu usuário)
- Senha: `password` (substituir pela sua senha)

Após testar a conexão com sucesso, o ambiente estará pronto para integração com o Spring Boot.

### Observações

* Esse usuário não possui privilégios globais de administrador, estando restrito ao schema `restdb`.
* A senha utilizada no exemplo é "password" apenas para fins didáticos. Em ambientes de produção, deve-se utilizar
  senhas fortes e políticas adequadas de segurança.

---

## Executar Testes

| Objetivo      | Comando                                                |
|:--------------|:-------------------------------------------------------|
| Testar Classe | `mvn test -Dtest=NomeClasse`                           |
| Testar Método | `mvn test -Dtest=NomeClasse#nomeMetodo`                |
| Debug         | `mvn -Dmaven.surefire.debug test -Dtest=Classe#Metodo` |

## Docker

- `docker ps`
- `docker ps -a`
- `docker start`: Inicializar o Docker
- `docker stop`: Finalizar o Docker
- `docker run hello-world`
- `docker --version`: Verificar a versão do Docker

## Linux

- `sudo apt update`: Atualizar
- `sudo apt install -y`: Instalar
- `sudo apt remove -y`: Remover
- `sudo apt update && sudo apt upgrade -y`
- `sudo service docker start`: Inicializar o Docker
- `sudo service docker restart`: Reinicializar o Docker
- `sudo service docker stop`: Para o Docker
- `clear`: Limpar console (CLI)

### Exemplo de Instalação

- `sudo apt install -y git`: Instalando o Git
- `sudo apt install -y maven`: Instalando o Maven

---

## Maven Failsafe plugin

1. `mvn clean`
2. `mvn test`
3. `mvn verify`