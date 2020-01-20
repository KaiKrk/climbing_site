package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Sector;
import oc.projet.p6.Service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sectors") // "/admin/members"
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/detail")
    public String getSecteur(@RequestParam("SectorId")int theId, Model theModel){

        Sector theSector = sectorService.findById(theId);
        theModel.addAttribute("sectors", theSector);
        theModel.addAttribute("ways", theSector.getWays());
        System.out.println(theSector.toString());
                return "Topo/sector-detail";
    }

    public String save(@ModelAttribute("sector") Sector theSector){
    sectorService.save(theSector);
    return null ;
    }
}
