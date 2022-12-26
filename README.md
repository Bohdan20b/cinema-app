# 🎥 Cinema application
### 📗 *Project description*
```
A web application that designs the user's interaction with 
the theater system to purchase tickets for available movies.
The application also implements the ability to recognize 
the user's role and share the range of possibilities. 
It is written with the help of Spring and Hibernate frameworks.
```

###  *Features*
* Registration, authentication and authorization
>It is possible to register a new user, log in to an existing account, and operate the service from that account depending on the role given.
* Scrolling through the information
>The user has the ability to view the available movies, as well as orders. The administrator can also view detailed information about cinema halls and the user database.
* Information handling
> The user has an opportunity to buy tickets (selectively add it to a shopping cart with further purchase). The administrator is given the opportunity to change the hall information, availability of movies and its sessions.

### 💾 *Project's structure*
Based on 3-layer architecture:

* Presentation layer - controllers.
* Application layer - services.
* Data access layer - DAO.

### 🔨 *Project launch:*
1. Clone this project to your IDE as Maven project. Hint: If you use IntelliJ IDEA, use only Ultimate version
2. Open pom.xml and reload all maven projects.
3. Open db.properties and set your credentials.
4. Set a new configuration, use Tomcat Local Server and select war-exploded artifact to deploy. Application content parameter should be like this "/".
5. Build project.

### 🧰 *Application technologies:*
* **[JDK 11 or higher](https://www.oracle.com/cis/java/technologies/javase/jdk11-archive-downloads.html)**
* **[Apache Maven](https://maven.apache.org/download.cgi)**
* **[Apache Tomcat (required: 9.0.50)](https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.50/bin/)**
* **[MySQL](https://dev.mysql.com/downloads/workbench/)**
* **[Hibernate](https://mvnrepository.com/artifact/org.hibernate/hibernate-validator/5.4.3.Final)**
* **[Spring Web, Spring Security](https://mvnrepository.com/artifact/org.springframework/spring-web/5.2.22.RELEASE)**
