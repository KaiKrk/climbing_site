package oc.projet.p6.Controller;

import oc.projet.p6.Dao.RoleRepository;
import oc.projet.p6.Entity.Member;
import oc.projet.p6.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/members") // "/admin/members"
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // add mapping for "/list"

    @GetMapping("/list")
    public String listContact(Model theModel) {

        // get employees from db
        List<Member> theMember = memberService.findAll();

        // add to the spring model
        theModel.addAttribute("members", theMember);
        //System.out.println(theMember);
        return "member-list";
    }

    @GetMapping("/register")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Member theMember = new Member();

        theModel.addAttribute("member", theMember);

        return "member-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int theId,
                                    Model theModel) {

        // get the employee from the service
        Member theMember = memberService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("member", theMember);

        // send over to our form
        return "member-form";
    }


    @PostMapping("/save")
    public String saveMember(@ModelAttribute("member") Member theMember) {
        theMember.setPassword(passwordEncoder.encode(theMember.getPassword()));
        theMember.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        // save the employee
        System.out.println(theMember.toString());
        memberService.save(theMember);

        // use a redirect to prevent duplicate submissions
        return "redirect:/members/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") int theId) {

        // delete the employee
        memberService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/members/list";

    }
    @GetMapping("/showFormForPromote")
    public String showFormForPromote(@RequestParam("id") int theId,
                                    Model theModel) {

        // get the employee from the service
        Member theMember = memberService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("member", theMember);

        return "promote-form";
    }

    @PostMapping("/promote")
    public String promote(@ModelAttribute("member") Member theMember){
        theMember.setRoles(Arrays.asList(roleRepository.findByName("ROLE_ADMIN")));
        System.out.println(theMember.toString());
        // save the employee
        memberService.save(theMember);
        return "redirect:/members/list";
    }
}

