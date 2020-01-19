package oc.projet.p6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
    @GetMapping("/home")
    public String home(){
        return "userhome";
    }
    @GetMapping("/login")
    public String login(){
        return "connexion/login-form";
    }
}
