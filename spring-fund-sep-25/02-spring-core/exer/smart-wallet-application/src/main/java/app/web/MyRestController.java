package app.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class MyRestController {
    @GetMapping("/info")
    public String getInfo(HttpServletRequest request, HttpServletResponse response) {
//        String greetingUser = "Hello " + request.getHeader("author") + "! You are   "
//                + request.getHeader("age") + " years old.";
//        response.setHeader("Greeting", greetingUser);

        response.setHeader("Set-Cookie", "userId=123");

        return "Done";
    }

    @GetMapping("/info2")
    public String getInfo2(HttpServletRequest request, HttpServletResponse response) {

        System.out.println();
        return "Info2";
    }
}
