# Beer

## Funcionalidades

Exemplos de requisições e respostas para 'Beer'.

### GET - List Beers

**cURL**

```
curl -X 'GET' \
  'http://localhost:8080/api/v1/beerDTO?pageNumber=1&pageSize=25&showInventoryOnHand=false' \
  -H 'accept: application/json'
```

**Request URL**

```http request
http://localhost:8080/api/v1/beerDTO?pageNumber=1&pageSize=25&showInventoryOnHand=false
```

**Response**

* Status Code: 200 OK

```json
[
  {
    "beerName": "Crank",
    "beerStyle": "PALE_ALE",
    "createdDate": "2026-02-21T12:07:06.5885417",
    "id": "111af027-17a9-44f0-bdb5-984dd8ffd833",
    "price": 11.99,
    "quantityOnHand": 392,
    "upc": "12356222",
    "updateDate": "2026-02-21T12:07:06.5885417",
    "version": 1
  },
  {
    "beerName": "Sunshine City",
    "beerStyle": "IPA",
    "createdDate": "2026-02-21T12:07:06.5885417",
    "id": "1237c72e-587e-4b42-9219-5e35c6bafc33",
    "price": 13.99,
    "quantityOnHand": 144,
    "upc": "12356",
    "updateDate": "2026-02-21T12:07:06.5885417",
    "version": 1
  },
  {
    "beerName": "Galaxy Cat",
    "beerStyle": "PALE_ALE",
    "createdDate": "2026-02-21T12:07:06.5885417",
    "id": "ce0e481b-b693-4297-8927-c8455a692086",
    "price": 12.99,
    "quantityOnHand": 122,
    "upc": "12356",
    "updateDate": "2026-02-21T12:07:06.5885417",
    "version": 1
  }
]
```

---

### GET - Get Beer By ID

**cURL**

```
curl -X 'GET' \
  'http://localhost:8080/api/v1/beerDTO/111af027-17a9-44f0-bdb5-984dd8ffd833?showInventoryOnHand=false' \
  -H 'accept: application/json'
```

**Request URL**

```http request
http://localhost:8080/api/v1/beerDTO/111af027-17a9-44f0-bdb5-984dd8ffd833?showInventoryOnHand=false
```

**Response**

* Status Code: 200 OK

```json
{
  "beerName": "Crank",
  "beerStyle": "PALE_ALE",
  "createdDate": "2026-02-21T12:07:06.5885417",
  "id": "111af027-17a9-44f0-bdb5-984dd8ffd833",
  "price": 11.99,
  "quantityOnHand": 392,
  "upc": "12356222",
  "updateDate": "2026-02-21T12:07:06.5885417",
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