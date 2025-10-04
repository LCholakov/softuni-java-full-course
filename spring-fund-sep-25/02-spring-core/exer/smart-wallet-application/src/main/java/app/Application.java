package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


//Notes

// DTO -> CONTROLLER -> SERVICE -> ENTITY -> REPOSITORY -> DATABASE
// get validation on step 1, the DTO

// when data comes from user -> better to use record
// because records are immutable, which protects the user data
// we can't add symbols, concat etc

//entities are not beans. biz logic classes are beans
// beans in spring are objects for IoC