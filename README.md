### Songify
## PURPOSE OF THE APPLICATION

The purpose and goal of the application is management of music library.

### Technologies

Application is based on a backedn layer, which was written in Java (version 17) using frameworks such as Sping Boot (version 3.3.5) and Hibernate. 
The application uses a relational database, which is managed by the PostgresSQL system. Application use a docker environment.

### Running
After cloaning the application, we run it in any idea such as IntelliJ IDEA Ultimate. We need to docker application and database: postgres. If you want you
can use other relational database. Each database you have to configuration.

Example Docker Configuration:
1. You have to create docker-compose.yml file.
2. Next you should paste exemplary code:

  <img src="Images/docker-compose.PNG" alt="screen1" width="400" height="300">
   
3. Run docker-compose.yml
4. Next you have to cretae your database in postgres.
5. And next you should configuration database in IntelliJ IDEA Ultimate.
6. Example application.properties file configuration:
<img src="Images/applicationProperties.PNG" alt="screen2" width="400" height="300">
  
