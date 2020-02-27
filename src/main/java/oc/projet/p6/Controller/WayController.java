package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Way;
import oc.projet.p6.Service.SectorService;
import oc.projet.p6.Service.WayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Classe Controller des voies
 */
@Controller
@RequestMapping("/ways")
public class WayController {

    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private WayService wayService;


    @Autowired
    private SectorService sectorService;

    /**
     * methode qui retourne le formulaire pour ajouter des voies
     * @param theId
     * @param theModel
     * @return
     */
    @GetMapping("/add")
    public String addWay(@RequestParam("id") int theId, Model theModel){
        Way way = new Way();
        way.setSector(sectorService.findById(theId));
        theModel.addAttribute("way" ,way);
        System.out.println(way.getSector().getId());
        return "forms/way-form";
    }

    /**
     * methode pour insert une voie en bdd
     * @param theWay
     * @return
     */
    @PostMapping("/save")
    public String save(@ModelAttribute("way") Way theWay){
        System.out.println(theWay.toString());
        wayService.save(theWay);
        logger.info("New Way : " + theWay.getNameWay() + " added");
        return "redirect:/sectors/mySector?id=" + theWay.getSector().getId();
    }


}

