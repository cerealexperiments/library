<h1 align="center"><b>Online Library</b></h3>

<p>Online Library is a web application for easy online access to books. Application provides searching books by various filters, ordering, bying and bookmarking features and login and registration features.</p>

&nbsp;

## 📦 Backend Installation instructions

### For IntellijIDEA users

1. Install and setup Java SE 11
2. Clone the repository
3. Install dependencies from the pom.xml file
4. Create a database in postgresql
5. Paste the name of a newly created database in java-library-project/library/src/main/resources/application.properties like this:
    ```
    spring.datasource.url=jdbc:postgresql://localhost/{NAME_OF_YOUR_DB}
    ```
6. Run LibraryApplication.java in java-library-project/library/src/main/java/alatoo/edu/library/

## 📦 Fastest And Easiest Way of Starting the Backend

To provide an easier approach to access java application backend we use java-library-project/library/src/main/docker/docker-compose.yml file

To setup the backend this way:
1. cd into the java-library-project/library/src/main/docker/ directory
2. Run
    ```
    docker-compose up
    ```

This will run and configure java backend and postgres db automatically. Backend can be accessed by http://localhost:8080/api/v1/ link

Also it has swagger web ui for easier testing of APIs. It can be accessed by http://localhost:8080/swagger-ui.html#/ link

## 📦 Frontend Installation instructions