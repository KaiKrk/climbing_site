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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/research")
public class ResearchController {

    @Autowired
    private TopoService topoService;

    /**
     * methode qui retourne le formulaire pour une recherche multi critere
     * @param theModel
     * @return
     */
    @GetMapping("/search")
    public String search(Model theModel){
        Research research = new Research();
        theModel.addAttribute("research", research);
        return "research/research-form";
    }

    /**
     * methode qui retourne la page une page des resultats d'une recherche multi critere
     * @param recherche
     * @param theModel
     * @return
     */
    @PostMapping("/result")
    public String searchResult(@ModelAttribute("research") Research recherche, Model theModel){
        String country = recherche.getCountry(); String region = recherche.getRegion();
        List<Topo> topos = topoService.findAllByCountryIgnoreCaseContainingAndRegionIgnoreCaseContaining(country, region);
        theModel.addAttribute("topos", topos);
       return "research/research-list";
    }



}
