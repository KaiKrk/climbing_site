package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Way;
import oc.projet.p6.Service.SectorService;
import oc.projet.p6.Service.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ways")
public class WayController {

    @Autowired
    private WayService wayService;


    @Autowired
    private SectorService sectorService;

    @GetMapping("/add")
    public String addWay(@RequestParam("id") int theId, Model theModel){
        Way way = new Way();
        way.setSector(sectorService.findById(theId));
        theModel.addAttribute("way" ,way);
        System.out.println(way.getSector().getId());
        return "way-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("way") Way theWay){
        System.out.println(theWay.toString());
        wayService.save(theWay);
        return "redirect:/sectors/detail?id=" + theWay.getSector().getId();
    }


}

