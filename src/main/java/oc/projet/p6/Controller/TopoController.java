package oc.projet.p6.Controller;

import oc.projet.p6.Entity.*;
import oc.projet.p6.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/topo")
public class TopoController {
    @Autowired
    private TopoService topoService;

    @Autowired
    private SectorService sectorService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private WayService wayService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public String listTopo(Model theModel){

        List<Topo> theTopo = topoService.findAll();
        theModel.addAttribute("topos", theTopo);

        System.out.println(theTopo.toString() + "AAAAA");

        return "Topo/topo-list";
    }

    @GetMapping("/myTopo")
    public String listPersonalTopo(Model theModel){
    Member theMember = memberService.findByName();
    List<Topo> thePersonalTopo = topoService.findAllByUserId(theMember.getId());


    theModel.addAttribute("topos", thePersonalTopo);

        return "Topo/topo-personal-list";
    }
    @GetMapping("/detail")
    public String topoById (@RequestParam("topoId")int theId, Model theModel){
        Topo theTopo = topoService.findById(theId);
        theModel.addAttribute("topos",theTopo);
        theModel.addAttribute("sectors", theTopo.getSectors());
        System.out.println(theTopo.toString());
        System.out.println("Et");
        System.out.println(theTopo.getSectors().toString());
        return "/Topo/topo-personal-detail"; //form of the page showing the list of topos
    }
    @GetMapping("/add")
    public String addTopo(Model theModel){
        Member theMember = memberService.findByName();

        Topo theTopo = new Topo();
        theModel.addAttribute("topo",theTopo);

        return "topo-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("topo") Topo theTopo){
        Member theMember = memberService.findByName();
        theTopo.setUserId(theMember.getId());
        topoService.save(theTopo);

        return "redirect:/topo/myTopo";
    }
}
