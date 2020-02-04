//package oc.projet.p6.Controller;
//
//import oc.projet.p6.Entity.Sector;
//import oc.projet.p6.Entity.Topo;
//import oc.projet.p6.Entity.Way;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/adding")
//public class AjoutController {
//    private Topo topo = null;
//    private List<Sector> sectors = new ArrayList<>();
//    private List<Way> ways = new ArrayList<>();
//
//    @GetMapping("/topo")
//    public String AffichageTopo(Topo theTopo, Model theModel) {
//        Topo topo = new Topo();
//        theModel.addAttribute("topo", topo);
//
//        return "topo-form";
//    }
//    @PostMapping("/transfer")
//    public String saveTopoTransferToSector(@ModelAttribute("topo") Topo theTopo, Model theModel){
//        this.topo = theTopo;
//        System.out.println(theTopo.toString());
//        return "redirect:/adding/sector";
//    }
//
//
//
//
//
//        @GetMapping("/sector")
//        public String AffichageSector( Model theModel) {
//        Sector theSector = new Sector();
//        theModel.addAttribute("sector", theSector);
//
//            System.out.println(this.sectors);
//        return "sector-form";
//    }
//
//    @PostMapping(value = "transfer2", params = "action=save")
//    public String saveSector(@ModelAttribute("sector") Sector theSector, Model theModel){
//        this.sectors.add(theSector);
//        System.out.println("transfere et on passe" );
//        System.out.println(this.topo.toString());
//        //        return "redirect:/adding/way";
//        return "redirect:/adding/way";
//    }
//    @PostMapping(value = "transfer2", params = "action=addAgain")
//    public String saveSectorandAddAgain(@ModelAttribute("sector") Sector theSector, Model theModel){
//        this.sectors.add(theSector);
//        System.out.println("transfere et rebelotte" );
//        //        return "redirect:/adding/way";
//        return "redirect:/adding/sector";
//    }
//
//
//
//    @GetMapping("/way")
//    public String AffichageWay( Model theModel) {
//        Way theWay = new Way();
//
//        theModel.addAttribute("sectors", this.sectors);
//        theModel.addAttribute("way", theWay);
//
////        System.out.println(this.sectors);
//        return "way-form";
//    }
//    @PostMapping(value = "transfer3", params = "action=save")
//    public String saveWay(@ModelAttribute("way") Way theWay, Model theModel){
//        System.out.println("transfere et on passe" );
//        System.out.println(this.topo.toString());
//        //        return "redirect:/adding/way";
//        return "redirect:/adding/way";
//    }
//    @PostMapping(value = "transfer3", params = "action=addAgain")
//    public String saveWayandAddAgain(@ModelAttribute("way") Way theWay, Model theModel){
//        this.ways.add(theWay);
//        System.out.println("transfere et rebelotte" );
//        //        return "redirect:/adding/way";
//        return "redirect:/adding/sector";
//    }
//
//    private String saveAll(){
//
//        this.topo.setSectors(sectors);
//        return null;
//    }
//}
