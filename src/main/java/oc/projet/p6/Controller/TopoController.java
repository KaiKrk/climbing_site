package oc.projet.p6.Controller;

import oc.projet.p6.Entity.*;
import oc.projet.p6.Service.CommentService;
import oc.projet.p6.Service.SectorService;
import oc.projet.p6.Service.TopoService;
import oc.projet.p6.Service.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/topo")
public class TopoController {
    @Autowired
    private TopoService topoService;

    @Autowired
    private SectorService sectorService;

    @Autowired
    private WayService wayService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public String listTopo(Model theModel){

        List<Topo> theTopo = topoService.findAll();
        theModel.addAttribute("topo", theTopo);


        return null;
    }

    public String topoById (@RequestParam("topoId")int theId, Model theModel){
        Topo theTopo = topoService.findById(theId);
       // List<Sector> theSectors = sectorService.fi;              find by id of topo_id
       // List<Way> theWays = wayService.findById()                 find by id of sector_id
      //  List<Comment> theComment = commentService.findById()
        return null;
    }
}
