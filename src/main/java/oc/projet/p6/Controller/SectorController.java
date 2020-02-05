package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Sector;
import oc.projet.p6.Service.SectorService;
import oc.projet.p6.Service.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sectors") // "/admin/members"
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @Autowired
    private TopoService topoService;

    @GetMapping("/mySector")
    public String listPersonalSector(@RequestParam("id")int theId,Model theModel) {
        Sector theSector = sectorService.findById(theId);
        theModel.addAttribute("sectors", theSector);
        theModel.addAttribute("ways", theSector.getWays());
        System.out.println(theSector.toString());

        return "Topo/sector-personal-detail";
    }

    @GetMapping("/detail")
    public String getSecteur(@RequestParam("id")int theId, Model theModel){

        Sector theSector = sectorService.findById(theId);
        theModel.addAttribute("sectors", theSector);
        theModel.addAttribute("ways", theSector.getWays());
        System.out.println(theSector.toString());
                return "Topo/sector-detail";
    }



    @GetMapping("/add")
    public String addSector(@RequestParam("id") int theId, Model theModel){
    Sector sector = new Sector();
    sector.setTopo(topoService.findById(theId));
    theModel.addAttribute("sector" ,sector);
    return "sector-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("sector") Sector theSector){
    sectorService.save(theSector);
        System.out.println(theSector.getTopo().getId());
    return "redirect:/topo/detail?id=" + theSector.getTopo().getId() +"  " ;
    }


}
