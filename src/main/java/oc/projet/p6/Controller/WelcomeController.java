package oc.projet.p6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {
private String message ="";
private List<String> messages= new ArrayList<>();
    @GetMapping("/welcome")
    public String welcome() {
        System.out.println(this.message);
        System.out.println(this.messages);

        return "welcome";
    }
    @GetMapping("/home")
    public String home(){
        return "userhome";
    }
    @GetMapping("/login")
    public String login(){
        this.message="toto";
        this.messages.add("premier");
        this.messages.add("second");
        return "connexion/login-form";
    }
}
