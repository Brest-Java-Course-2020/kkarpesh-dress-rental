![Java CI with Maven](https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental/workflows/Java%20CI%20with%20Maven/badge.svg)

# kkarpesh-dress-rental
Dress rental demo application.
+ [Environment setting](#Environment-setting)
+ [Installing](#Installing)
+ [Build project](#Build-project)
+ [Preparing reports](#Preparing-reports)
+ [Deploy application on Tomcat server](#Deploy-application-on-Tomcat-server)
+ [Run application on Jetty test server](#Run-application-on-Jetty-test-server)
    + [Available REST endpoints](#Available-REST-endpoints)
        + [dresses](#dresses)
        + [dress_dtos](#dress_dtos)
        + [rents](#rents)
        + [rent_dtos](#rent_dtos)

## Environment setting
```
install openjdk11
install maven3+
install tomcat
install git
```

## Installing
Select the directory for the project and clone the project from github:
```
$ git clone https://github.com/Brest-Java-Course-2020/kkarpesh-dress-rental.git
```
## Build project
Run command in project directory:
```
$ mvn clean install
```
## Preparing reports
For preparing reports do:
```
$ mvn site
$ mvn site:stage
```
and open:
```
../kkarpesh-dress-rental/target/staging/index.html
```
## Deploy application on Tomcat server
Copy:
```
../kkarpesh-dress-rental/dress-rental-web-app/target/dress-rental-web.war
and
../kkarpesh-dress-rental/dress-rental-rest-app/target/dress-rental-rest.war
```
to tomcat directory:
```
../tomcat/webapps/
```
For shutdown and removing this apps from server remove this files.

Or, you can use GUI at:
```
http://localhost:8080/manager/html
```
and select .war files to deploy.
For shutdown select "stop", for removing "undeploy".

Web-app should be available at:
```
http://localhost:8080/dress-rental-web/
```
## Run application on Jetty test server
Run command in project directory in different terminal windows:
```
$ mvn -pl dress-rental-web-app/ jetty:run -P jetty
$ mvn -pl dress-rental-rest-app/ jetty:run
```
Web-app should be available at
```
http://localhost:8888
```
Rest-app at:
```
http://localhost:8088
```
for shutdown jetty server in terminal window press "CTRL+C"
## Available REST endpoints
Then applications run on Jetty test server, the following endpoints are available:
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
