package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Member;
import oc.projet.p6.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {
//
//
//    // load employee data
//
//    private List<Contact> theContacts;
//
//    @PostConstruct
//    private void loadData() {
//
//        // create employees
//        Contact emp1 = new Contact(1, "Leslie", "Andrews", "leslie@luv2code.com");
//        Contact emp2 = new Contact(2, "Emma", "Baumgarten", "emma@luv2code.com");
//        Contact emp3 = new Contact(3, "Avani", "Gupta", "avani@luv2code.com");
//
//        // create the list
//        theContacts = new ArrayList<>();
//
//        // add to the list
//        theContacts.add(emp1);
//        theContacts.add(emp2);
//        theContacts.add(emp3);
//
//    }
//
//
//    // add mapping for "/list"
//
//    @GetMapping("/list")
//    public String listEmployees(Model theModel) {
//
//        // add to the spring model
//        theModel.addAttribute("contact", theContacts);
//
//        return "contact";
//    }

    @Autowired
    private MemberService memberService;

    // add mapping for "/list"

    @GetMapping("/list")
    public String listContact(Model theModel) {

        // get employees from db
        List<Member> theMember = memberService.findAll();

        // add to the spring model
        theModel.addAttribute("members", theMember);
        System.out.println(theMember);
        return "member-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Member theContact = new Member();

        theModel.addAttribute("member", theContact);

        return "member-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("memberId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Member theMember = memberService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("member", theMember);

        // send over to our form
        return "member-form";
    }


    @PostMapping("/save")
    public String saveContact(@ModelAttribute("member") Member theMember) {

        // save the employee
        memberService.save(theMember);

        // use a redirect to prevent duplicate submissions
        return "/members/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("memberId") int theId) {

        // delete the employee
        memberService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/members/list";

    }
}

