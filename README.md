# fantacalcio-app
 Fantacalcio app for SOSE (Service-Oriented Software Engineering) exam project.

Steps to properly run the application:

- Run within the code folder the command: docker compose -p fantacalcio up -d

- Build the "lineups" service on a local server (we used Tomcat 8.5) and run it with Java 8

- To scale services and check the load balancing, run inside the code folder the command: docker-compose -p fantacalcio up --scale "SERVICE-NAME"="NUMBER" -d

- Using phpMyAdmin load players.sql and statistics.sql, located in the "data" folder, into the players and statistics tables respectively to populate the db
