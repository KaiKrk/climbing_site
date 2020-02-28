package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Member;
import oc.projet.p6.Service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private MemberService memberService;

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("")
    public String root() {
        return "welcome";
    }

    @GetMapping("/home")
    public String home(Model theModel){
        Member theMember = memberService.findMemberByEmail();
        theModel.addAttribute("currentMember", theMember);
        logger.info("member connected" + theMember.toString());
        return "userhome";
    }

    @GetMapping("/login")
    public String login(){
        return "connexion/login-form";
    }
}
