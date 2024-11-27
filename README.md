In order to make this project work, you need to put the following content in the `/src/main/resources/META-INF/persistence.xml` file and create it if needed. 

``` xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
             version="3.0">
    <persistence-unit name="default"> 
      <class>dev.pedrohflobo.carshopping.domain.Car</class>
      <class>dev.pedrohflobo.carshopping.domain.Acessory</class>
      <class>dev.pedrohflobo.carshopping.domain.Manufacturer</class>

        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/
              db_car_shopping?
              createDatabaseIfNotExist=true
              &amp;useTimezone=true
              &amp;serverTimezone=UTC" />
            <property name="jakarta.persistence.jdbc.user" value="jpa_user"/>
            <property name="jakarta.persistence.jdbc.password" value="secret"/>
            <property
                    name="jakarta.persistence.schema-generation.database.action"
                    value="drop-and-create"/>

            <property name="hibernate.dialect"
                    value="org.hibernate.dialect.MySQL8Dialect" />

        </properties>
    </persistence-unit>
</persistence>
```
Then, create MySQL username, password and database using the same properties names available in the `persistence.xml` file.
Now, you need to download a jar file from gradle. Just use the following command:

```bash
gradle wrapper
```

To run this project, use the command below:

```bash
./gradlew run
```
