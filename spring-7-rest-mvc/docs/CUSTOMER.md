# Customer

## Funcionalidades

Exemplos de requisições e respostas para 'Customer'.

### GET - List Customers

**cURL**

```
```

**Request URL**

```http request
http://localhost:8080/api/v1/customers
```

**Response**

* Status Code: 200 OK

**Response**

```json
[
  {
    "createdDate": "2026-02-21T12:39:31.3862829",
    "id": "5ee5e377-0a92-4391-a18f-ddd1540cd76a",
    "name": "Customer 3",
    "updateDate": "2026-02-21T12:39:31.3862829",
    "version": 1
  },
  {
    "createdDate": "2026-02-21T12:39:31.3862829",
    "id": "9a5b1488-fd3d-4582-9bf2-85db8b956d5a",
    "name": "Customer 1",
    "updateDate": "2026-02-21T12:39:31.3862829",
    "version": 1
  },
  {
    "createdDate": "2026-02-21T12:39:31.3862829",
    "id": "f14df6a4-a83b-4662-b720-93041ff1a709",
    "name": "Customer 2",
    "updateDate": "2026-02-21T12:39:31.3862829",
    "version": 1
  }
]
```

---

### GET - Get Customer By Id

**cURL**

```
curl -X 'GET' \
  'http://localhost:8080/api/v1/customers/5ee5e377-0a92-4391-a18f-ddd1540cd76a' \
  -H 'accept: application/json'
```

**Request URL**

```http request
http://localhost:8080/api/v1/customers/5ee5e377-0a92-4391-a18f-ddd1540cd76a
```

**Response**

* Status Code: 200 OK

```json
{
  "createdDate": "2026-02-21T12:39:31.3862829",
  "id": "5ee5e377-0a92-4391-a18f-ddd1540cd76a",
  "name": "Customer 3",
  "updateDate": "2026-02-21T12:39:31.3862829",
  "version": 1
}
```

---

### POST

**cURL**

```

```

**Request URL**

```http request

```

**Response**

* Status Code:

```json

```

---

### PUT

**cURL**

```

```

**Request URL**

```http request

```

**Response**

* Status Code:

```json

```

---

### DELETE

**cURL**

```

```

**Request URL**

```http request

```

**Response**

* Status Code:

```json

```

---

### PATCH

**cURL**

```

```

**Request URL**

```http request

```

**Response**

* Status Code:

```json

```