## Pre-requisites
- Install Nodejs v6.9+
- Install Apache Maven
- Install MySQL

## Start developing

### Run backend
- mvn spring-boot:run
- check in browser http://localhost:8081/api

### Run frontend
- cd src/main/frontend
- npm start
- check in browser http://localhost:8082

### Build jar
- open 'src/main/frontend' and run 'ng build' for generate html,js,css in static folder
- mvn package

## Configuration files
- src/main/frontend/package.json
- pom.xml
- resources/application.properties

## Database
change credentials `resources/application.properties`
- db.url (default `jdbc:mysql://localhost:3306/spreadsheet`)
- db.username (default `admin`)
- db.password (default `admin`)

## CI (Travis)
change credentials
- .travis.yml