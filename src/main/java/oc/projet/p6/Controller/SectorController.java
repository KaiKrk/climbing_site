package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Sector;
import oc.projet.p6.Service.SectorService;
import oc.projet.p6.Service.TopoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Classe Controller des secteurs
 */
@Controller
@RequestMapping("/sectors") // "/admin/members"
public class SectorController {

    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private SectorService sectorService;

    @Autowired
    private TopoService topoService;

    /**
     * methode qui retourne la page d'un secteur dont on est proprietaire
     * @param theId
     * @param theModel
     * @return
     */
    @GetMapping("/mySector")
    public String listPersonalSector(@RequestParam("id")int theId,Model theModel) {
        if (sectorService.isConnectedMemberTheAuthor(theId) == true){
            Sector theSector = sectorService.findById(theId);
            theModel.addAttribute("sectors", theSector);
            theModel.addAttribute("ways", theSector.getWays());
            System.out.println(theSector.toString());

            return "Topo/sector-personal-detail";
        }else

        return "redirect:/topo/myTopo";
    }

    /**
     * methode qui retourne la page secteur d'un secteur que l'on consulte et qui est public
     * @param theId
     * @param theModel
     * @return
     */
    @GetMapping("/detail")
    public String getSecteur(@RequestParam("id")int theId, Model theModel){

        Sector theSector = sectorService.findById(theId);
        theModel.addAttribute("sectors", theSector);
        theModel.addAttribute("ways", theSector.getWays());
        System.out.println(theSector.toString());
                return "Topo/sector-detail";
    }


    /**
     * methode qui retourne le formulaire pour ajouter un secteur
     * @param theId
     * @param theModel
     * @return
     */
    @GetMapping("/add")
    public String addSector(@RequestParam("id") int theId, Model theModel){
    Sector sector = new Sector();
    sector.setTopo(topoService.findById(theId));
    theModel.addAttribute("sector" ,sector);
    return "forms/sector-form";
    }

    /**
     * methode qui insert un secteur dans la bdd
     * @param theSector
     * @return
     */
    @PostMapping("/save")
    public String save(@ModelAttribute("sector") Sector theSector){
    sectorService.save(theSector);
    logger.info("New Sector :" + theSector.getSectorName() + " added");
    return "redirect:/topo/myTopoDetail?id=" + theSector.getTopo().getId() +"  " ;
    }


}
