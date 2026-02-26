# 🐳 Acessando o MySQL via Docker (Linha de Comando)

Esta seção descreve como acessar o banco de dados MySQL em execução dentro de um container Docker e executar comandos
básicos para inspeção de dados.

---

## Pré-requisitos

* Docker instalado e em execução
* Container do MySQL ativo
* Nome do container (ex: `spring-7-rest-mvc-mysql-1`)
* Credenciais de acesso (usuário `root` e senha configurada)

Para listar os containers ativos:

```bash
docker ps
```

---

## 1. Acessando o MySQL no Container

Execute o comando abaixo para entrar no terminal interativo do MySQL:

```bash
docker exec -it <nome_do_container> mysql -u root -p
```

### Exemplo:

```bash
docker exec -it spring-7-rest-mvc-mysql-1 mysql -u root -p
```

Após executar o comando:

* Informe a senha do usuário `root` quando solicitado.
* Você será direcionado para o prompt interativo do MySQL.

Exemplo de saída:

```bash
Enter password: 
Server version: 9.6.0 MySQL Community Server - GPL

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.
```

---

## 2. Comandos Básicos no MySQL

Após acessar o prompt do MySQL, utilize os seguintes comandos:

### Listar bancos de dados

```bash
SHOW DATABASES;
```

Exemplo de retorno:

```bash
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| restdb             |
| sys                |
+--------------------+
```

---

### Selecionar banco de dados

```bash
USE restdb;
```

---

### Listar tabelas

```bash
SHOW TABLES;
```

Exemplo:

```bash
+-----------------------+
| Tables_in_restdb      |
+-----------------------+
| beer                  |
| customer              |
| flyway_schema_history |
+-----------------------+
```

---

### Consultar registros

```bash
SELECT * FROM beer LIMIT 10;
```

Exemplo de retorno:

```bash
+--------------------------------------+----------------------------------------+------------+----------------------------+-------+------------------+------+----------------------------+---------+
| id                                   | beer_name                              | beer_style | created_date               | price | quantity_on_hand | upc  | update_date                | version |
+--------------------------------------+----------------------------------------+------------+----------------------------+-------+------------------+------+----------------------------+---------+
| 00136e9e-9371-4de4-b56d-16ec71678cf1 | Charlie in the Rye                     |          7 | 2026-02-26 09:48:03.782957 | 10.00 |             2345 | 2345 | 2026-02-26 09:48:03.782957 |       0 |
| 0017a190-94ac-4778-a3ef-347f50ea96ea | Hop A Potamus Double Dark Rye Pale Ale |          1 | 2026-02-26 09:48:00.924339 | 10.00 |              972 | 972  | 2026-02-26 09:48:00.924339 |       0 |
| 0020a040-ef74-4eb6-b785-eabe0559f405 | Trader Session IPA                     |          7 | 2026-02-26 09:48:03.605368 | 10.00 |             2254 | 2254 | 2026-02-26 09:48:03.605368 |       0 |
| 00214d87-fa6f-4155-a261-58d23d7e5ccb | Two-One Niner                          |          1 | 2026-02-26 09:48:01.331465 | 10.00 |             1197 | 1197 | 2026-02-26 09:48:01.331465 |       0 |
| 0029e8e5-5304-4ec6-baec-435aa992f5cf | Isis                                   |          7 | 2026-02-26 09:48:03.142417 | 10.00 |             2063 | 2063 | 2026-02-26 09:48:03.142417 |       0 |
| 0044f639-22e0-4ecb-bf5e-e6181590c53a | I-10 IPA                               |          7 | 2026-02-26 09:48:01.163282 | 10.00 |             1115 | 1115 | 2026-02-26 09:48:01.163282 |       0 |
| 004d8da3-8489-4b0a-acd1-4c780c8a0076 | Shift                                  |          0 | 2026-02-26 09:48:01.817050 | 10.00 |             1455 | 1455 | 2026-02-26 09:48:01.817050 |       0 |
| 007f3566-f2b3-4394-8809-f4e8396ef3d2 | Midnight Ryder                         |          5 | 2026-02-26 09:48:01.145595 | 10.00 |             1106 | 1106 | 2026-02-26 09:48:01.145595 |       0 |
| 00932bfc-e172-496b-bfb7-bb70ed6bbf9e | Bikini Blonde Lager                    |          1 | 2026-02-26 09:48:01.529242 | 10.00 |             1311 | 1311 | 2026-02-26 09:48:01.529242 |       0 |
| 00a5b65f-4fa7-4353-a857-7cf69e4cfaa2 | Tsunami IPA                            |          7 | 2026-02-26 09:48:01.551849 | 10.00 |             1320 | 1320 | 2026-02-26 09:48:01.551849 |       0 |
+--------------------------------------+----------------------------------------+------------+----------------------------+-------+------------------+------+----------------------------+---------+
10 rows in set (0.001 sec)
```

---

## 3. Sair do MySQL

Para encerrar a sessão:

```bash
exit;
```

ou

```bash
\
q
```

---

## Observações

* Substitua `<nome_do_container>` pelo nome real do seu container.
* Caso esteja utilizando `docker-compose`, o nome do container pode incluir o prefixo do projeto.
* Certifique-se de que o container esteja em execução antes de tentar acessá-lo.
* Para ambientes produtivos, evite utilizar o usuário `root`. Prefira usuários com permissões específicas.

---

Se necessário, consulte também:

```bash
docker logs <nome_do_container>
```

Para verificar logs do container em caso de erro de conexão.
