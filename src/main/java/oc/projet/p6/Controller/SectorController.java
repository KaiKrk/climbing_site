package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Sector;
import oc.projet.p6.Service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sectors") // "/admin/members"
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/mySector")
    public String listPersonalSector(@RequestParam("sectorId")int theId,Model theModel) {
        Sector theSector = sectorService.findById(theId);
        theModel.addAttribute("sectors", theSector);
        theModel.addAttribute("ways", theSector.getWays());
        System.out.println(theSector.toString());

        return "Topo/sector-personal-detail";
    }

    @GetMapping("/detail")
    public String getSecteur(@RequestParam("sectorId")int theId, Model theModel){

        Sector theSector = sectorService.findById(theId);
        theModel.addAttribute("sectors", theSector);
        theModel.addAttribute("ways", theSector.getWays());
        System.out.println(theSector.toString());
                return "Topo/sector-personal-detail";
    }

    @GetMapping("/add")
    public String addSector(@RequestParam("topoId") int theId, Model theModel){
    Sector sector = new Sector();
    sector.setTopoId(theId);
    theModel.addAttribute("sector" ,sector);
    return "sector-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("sector") Sector theSector){
    sectorService.save(theSector);
    return "redirect:/topo/detail?topoId=" + theSector.getTopoId() ;
    }


}
