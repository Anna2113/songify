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
   version: "3.8"
   services:
      db:
        image: postgres
        container_name: your configuration
        restart: always
        ports:
          - "your configuration"
        environment:
          POSTGRES_USER: your configuration
          POSTGRES_PASSWORD: your configuration
          POSTGRES_DB: your configuration
        volumes:
          - local_pgdata:/var/lib/postgresql/data
      pgadmin:
        image: dpage/pgadmin4
        container_name: your configuration
        restart: always
        ports:
          - "your configuration"
        environment:
          PGADMIN_DEFAULT_EMAIL: your configuration
          PGADMIN_DEFAULT_PASSWORD: your configuration
        volumes:
          - pgadmin-data:/var/lib/pgadmin

    volumes:
      local_pgdata:
      pgadmin-data:
   
3. Run docker-compose.yml
4. Next you have to cretae your database in postgres.
5. And next you should configuration database in IntelliJ IDEA Ultimate.
6. Example application.properties file configuration:

spring.datasource.url= your configuration
spring.datasource.username= your configuration
spring.datasource.password= your configuration

spring.datasource.hikari.connection-timeout=20000
spring.datasource.hikari.maximum-pool-size=5

spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
  
