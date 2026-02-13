# Spring 7 REST MVC

## GET

### List Beers

* Request

```text
curl --location 'http://localhost:8080/api/v1/beer?pageNumber=1&pageSize=25&beerName=string&beerStyle=STOUT&showInventoryOnHand=false' \
--header 'Accept: application/json'
```

* Response - Status 200 OK

```json
[
  {
    "beerName": "Crank",
    "beerStyle": "PALE_ALE",
    "createdDate": "2026-02-10T18:46:51.2617073",
    "id": "03fd42c7-ab8c-464f-8698-be9b20382413",
    "price": 11.99,
    "quantityOnHand": 392,
    "upc": "12356222",
    "updateDate": "2026-02-10T18:46:51.2617073",
    "version": 1
  },
  {
    "beerName": "Sunshine City",
    "beerStyle": "IPA",
    "createdDate": "2026-02-10T18:46:51.2627114",
    "id": "ef74fbb5-2bcd-4d12-a2fe-c7dbbe15b64f",
    "price": 13.99,
    "quantityOnHand": 144,
    "upc": "12356",
    "updateDate": "2026-02-10T18:46:51.2627114",
    "version": 1
  },
  {
    "beerName": "Galaxy Cat",
    "beerStyle": "PALE_ALE",
    "createdDate": "2026-02-10T18:46:51.2617073",
    "id": "2bb94087-ec16-492e-a930-80342318b2b9",
    "price": 12.99,
    "quantityOnHand": 122,
    "upc": "12356",
    "updateDate": "2026-02-10T18:46:51.2617073",
    "version": 1
  }
]
```

### Get Beer by ID

* Request

```text
curl --location 'http://localhost:8080/api/v1/beer/2bb94087-ec16-492e-a930-80342318b2b9' \
--header 'Accept: application/json'
```

* Response - Status 200 OK

```json
{
  "beerName": "Galaxy Cat",
  "beerStyle": "PALE_ALE",
  "createdDate": "2026-02-10T18:46:51.2617073",
  "id": "2bb94087-ec16-492e-a930-80342318b2b9",
  "price": 12.99,
  "quantityOnHand": 122,
  "upc": "12356",
  "updateDate": "2026-02-10T18:46:51.2617073",
  "version": 1
}
```

## POST

### Handle Post

* Request

```text
curl --location 'http://localhost:8080/api/v1/beer' \
--header 'Content-Type: application/json' \
--data '{
  "beerName": "Mango Bobs - JTs 5",
  "beerStyle": "ALE",
  "upc": "063123420003633",
  "quantityOnHand": 250,
  "price": 12.16
}'
```

* Response - Status 201 Created
