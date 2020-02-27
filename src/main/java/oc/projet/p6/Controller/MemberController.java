package oc.projet.p6.Controller;

import oc.projet.p6.Dao.RoleRepository;
import oc.projet.p6.Entity.Member;
import oc.projet.p6.Service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Classe Controller des membres
 */
@Controller
@RequestMapping("/members") // "/admin/members"
public class MemberController {

    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private MemberService memberService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * methode ajoute au model la liste de membres et renvoie un page de tous les membres
     * @param theModel
     * @return
     */
    @GetMapping("/list")
    public String listContact(Model theModel) {
        List<Member> theMember = memberService.findAll();
        theModel.addAttribute("members", theMember);
        return "member-list";
    }

    /**
     * methode qui retourne la page d'inscription d'un membre
     * @param theModel
     * @return
     */
    @GetMapping("/register")
    public String showFormForAdd(Model theModel) {
        Member theMember = new Member();
        theMember.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        theModel.addAttribute("member", theMember);
        return "forms/registration-form";
    }

    /**
     * methode qui retourne la page de mis a jour d'un membre
     * @param theId
     * @param theModel
     * @return
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int theId,
                                    Model theModel) {
        Member theMember = memberService.findById(theId);
        theModel.addAttribute("member", theMember);
        return "forms/member-form";
    }

    /**
     * methode qui insert ou update un membre
     * @param theMember
     * @return
     */
    @PostMapping("/save")
    public String saveMember(@ModelAttribute("member") Member theMember) {
        theMember.setPassword(passwordEncoder.encode(theMember.getPassword()));
         logger.info("member : "+theMember.toString() + " saved as User");
        memberService.save(theMember);

        return "redirect:/login";
    }

    /**
     * methode qui retourne la page pour promouvoir un membre
     * @param theId
     * @param theModel
     * @return
     */
    @GetMapping("/showFormForPromote")
    public String showFormForPromote(@RequestParam("id") int theId,
                                    Model theModel) {
        Member theMember = memberService.findById(theId);
        theModel.addAttribute("member", theMember);
        return "forms/promote-form";
    }

    /**
     * methode pour promouvoir et update un membre
     * @param theMember
     * @return
     */
    @PostMapping("/promote")
    public String promote(@ModelAttribute("member") Member theMember){

        theMember.setRoles(Arrays.asList(roleRepository.findByName("ROLE_ADMIN")));
        logger.info("Member " + theMember.getName() + " saved as Admin");
        memberService.save(theMember);

        return "redirect:/members/list";
    }
}

