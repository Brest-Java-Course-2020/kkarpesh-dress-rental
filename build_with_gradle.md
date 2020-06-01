## Build project
Run command in project directory:
```
$ gradle build
```
## Preparing javadoc
For preparing reports do:
```
$ gradle alljavadoc
```
and open:
```
../kkarpesh-dress-rental/build/docs/javadoc/index.html
```
## Deploy application on Tomcat server
Copy:
```
../kkarpesh-dress-rental/dress-rental-web-app/build/libs/dress-rental-web.war
and
../kkarpesh-dress-rental/dress-rental-rest-app/build/libs/dress-rental-rest.war
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
$ gradle -p dress-rental-web-app/ appRun
$ gradle -p dress-rental-rest-app/ appRun
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