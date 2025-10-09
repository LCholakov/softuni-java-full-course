package app.user.property;

import app.user.model.Country;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data // geters and setters and other stuff
@Configuration
//the properties will comee from the prop file
@ConfigurationProperties(prefix = "user")
public class UserProperties {

    private DefaultUser defaultUser;
    private String testProperty;

//    nested classes are public static
    @Data
    public static class DefaultUser {
        private String username;
        private String password;
        private Country country;
    }

//    quick trick to see if the properties are loade d
//    otherwise init class in UserInit, autowire and check the object. But it's a bit more work.
    @PostConstruct
    public void test() {
        System.out.println();
    }

}
