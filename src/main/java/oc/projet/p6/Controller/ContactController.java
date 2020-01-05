package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {


    // load employee data

    private List<Contact> theContacts;

    @PostConstruct
    private void loadData() {

        // create employees
        Contact emp1 = new Contact(1, "Leslie", "Andrews", "leslie@luv2code.com");
        Contact emp2 = new Contact(2, "Emma", "Baumgarten", "emma@luv2code.com");
        Contact emp3 = new Contact(3, "Avani", "Gupta", "avani@luv2code.com");

        // create the list
        theContacts = new ArrayList<>();

        // add to the list
        theContacts.add(emp1);
        theContacts.add(emp2);
        theContacts.add(emp3);

    }


    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // add to the spring model
        theModel.addAttribute("contact", theContacts);

        return "contact";
    }
}

