package oc.projet.p6.Controller;

import oc.projet.p6.Dao.TopoRepository;
import oc.projet.p6.Entity.Member;
import oc.projet.p6.Entity.Research;
import oc.projet.p6.Entity.Topo;
import oc.projet.p6.Service.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ResearchController {

    @Autowired
    private TopoService topoService;

    @GetMapping("/search")
    public String search(Model theModel){
        Research research = new Research();
        theModel.addAttribute("research", research);
        return "research/research-form";
    }

    @PostMapping("/result")
    public String searchResult(@ModelAttribute("research") Research recherche, Model theModel){
        String country = recherche.getCountry(); String region = recherche.getRegion();
        List<Topo> topos = topoService.findAllByCountryIgnoreCaseContainingAndRegionIgnoreCaseContaining(country, region);
        theModel.addAttribute("topos", topos);
        System.out.println(topos.toString());
       return "research/research-list";
    }



}
