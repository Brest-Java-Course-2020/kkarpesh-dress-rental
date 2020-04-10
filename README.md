![Java CI with Maven](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/workflows/Java%20CI%20with%20Maven/badge.svg)

# kkarpesh-dress-rental
Dress rental.

## Available REST endpoints

### dresses

##### findAll
```
curl -s -X GET 'http://localhost:8088/dresses' | json_pp
```
##### findById
```
curl -s -X GET 'http://localhost:8088/dresses/1' | json_pp
```
##### create
```
curl -X POST 'http://localhost:8088/dresses' \
-H 'Accept: application/json' \
-H 'Content-Type: application/json' \
--data-raw '{
        "dressName": "New dress"
}'
```
##### update
```
curl -X PUT 'http://localhost:8088/dresses' \
-H 'Accept: application/json' \
-H 'Content-Type: application/json' \
--data-raw '{
        "dressId": 2,
        "dressName": "Updated dress"
}'
```
##### delete
```
curl -X DELETE 'http://localhost:8088/dresses/3'
```
##### isNameAlreadyExist
```
curl -s -X GET 'http://localhost:8088/dresses/isExists?name=Jacquard%20shirt%20dress'
```
##### isDressHasRents
```
curl -s -X GET 'http://localhost:8088/dresses/1/hasRents'
```
### dress_dtos

#####findAllWithNumberOfOrders
```
curl -s -X GET 'http://localhost:8088/dress_dtos' | json_pp
```
### rents

##### findAll
```
curl -s -X GET 'http://localhost:8088/rents' | json_pp
```
##### findById
```
curl -s -X GET 'http://localhost:8088/rents/1' | json_pp
```
##### create
```
curl -X POST 'http://localhost:8088/rents' \
-H 'Accept: application/json' \
-H 'Content-Type: application/json' \
--data-raw '{
        "client": "Marya Noganova",
        "dressId": 1,
        "rentDate": "2020-05-30",
        "rentId": 0
}'
```
##### update
```
curl -X PUT 'http://localhost:8088/rents' \
-H 'Accept: application/json' \
-H 'Content-Type: application/json' \
--data-raw '{
         "client": "Marya Minogarova",
         "dressId": 5,
         "rentDate": "2020-05-30",
         "rentId": 2
}'
```
##### delete
```
curl -X DELETE 'http://localhost:8088/rents/3'
```
##### isDressRented
```
curl -X POST 'http://localhost:8088/rents/isExists' \
-H "Content-Type: application/json" \
--data-raw '{
        "client": "",
        "dressId": 5,
        "rentDate": "2020-05-30",
        "rentId": 0
}'
```
### rent_dtos
##### findAllWithDressNameByDate
```
curl -s -X GET 'http://localhost:8088/rent_dtos?dateFrom=2020-01-01&dateTo=2020-03-01' | json_pp
```
