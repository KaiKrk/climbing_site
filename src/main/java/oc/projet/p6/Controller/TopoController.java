package oc.projet.p6.Controller;

import oc.projet.p6.Entity.*;
import oc.projet.p6.Service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe Controller des topos
 */
@Controller
@RequestMapping("/topo")
public class TopoController {

    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private TopoService topoService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CommentService commentService;

    String disponible = DisponibiliteStatus.Disponible.toString();
    String indisponible = DisponibiliteStatus.Indisponible.toString();

    /**
     *methode qui retourne une liste de tous les topos enregistres dans la bdd
     * @param theModel
     * @return
     */
    @GetMapping("/list")
    public String listTopo(Model theModel){

        List<Topo> theTopo = topoService.findAll();
        theModel.addAttribute("topos", theTopo);
        return "Topo/topo-list";
    }

    /**
     * methode qui retourne une liste des topos personnels du membre connecte
     * @param theModel
     * @return
     */
    @GetMapping("/myTopo")
    public String listPersonalTopo(Model theModel){
    Member theMember = memberService.findMemberByEmail();
    List<Topo> thePersonalTopo = topoService.findAllByMemberId(theMember.getId());
    theModel.addAttribute("topos", thePersonalTopo);

        return "Topo/topo-personal-list";
    }

    /**
     * methode qui retourne une page avec les details d'un topo
     * @param theId
     * @param theModel
     * @return
     */
    @GetMapping("/detail")
    public String topoById (@RequestParam("id")int theId, Model theModel){
        Topo theTopo = topoService.findById(theId);
        theModel.addAttribute("topos",theTopo);
        theModel.addAttribute("sectors", theTopo.getSectors());
        theModel.addAttribute("topoFile", theTopo.getTopoFile());

        List<Comment> comments = commentService.findAllByTopo(theId);
        theModel.addAttribute("comments", comments );

        Comment comment = new Comment();
        comment.setMember(memberService.findMemberByEmail());
        comment.setTopo(theTopo);
        theModel.addAttribute("comment", comment);

        return "/Topo/topo-detail";
    }

    /**
     * methode qui retourne les details d'un topo personnel
     * @param theId
     * @param theModel
     * @return
     */
    @GetMapping("/myTopoDetail")
    public String myTopoById (@RequestParam("id")int theId, Model theModel){

        System.out.println( topoService.isConnectedMemberTheAuthor(theId));
        if (topoService.isConnectedMemberTheAuthor(theId) == true){
            Topo theTopo = topoService.findById(theId);
            theModel.addAttribute("topos",theTopo);
            theModel.addAttribute("sectors", theTopo.getSectors());
            theModel.addAttribute("topoFile", theTopo.getTopoFile());
            return "/Topo/topo-personal-detail";
        } else {
            return "redirect:/topo/myTopo";
        }
    }

    /**
     * methode qui retourne le formulaire pour ajouter un topo
     * @param theModel
     * @return
     */
    @GetMapping("/add")
    public String addTopo(Model theModel){
        Topo theTopo = new Topo();
        theModel.addAttribute("topo",theTopo);

        return "forms/topo-form";
    }

    /**
     * methode qui insert le topo recu en parametre en bdd
     * @param theTopo
     * @return
     */
    @PostMapping("/save")
    public String save(@ModelAttribute("topo") Topo theTopo){
        Member theMember = memberService.findMemberByEmail();
        theTopo.setMember(theMember);
        if (theTopo.getTopoStatus().equalsIgnoreCase(disponible)){
            theTopo.setReleaseDate(LocalDate.now());
        }
        topoService.save(theTopo);

        logger.info("new Topo : " + theTopo.getNameTopo() + " added");
        return "redirect:/topo/myTopo";
    }

    /**
     * methode pour liberer un topo reservé
     * @param theId
     * @return
     */
    @GetMapping("/free")
    public String freeReservatedTopo(@RequestParam("id")int theId){
        String reservationTermine = ReservationStatus.Termine.toString();

        Reservation reservation = reservationService.findById(theId);
        reservation.setReservationStatus(reservationTermine);
        Topo theTopo = topoService.findById(reservation.getTopo().getId());
        topoService.changeAvaibility(theTopo,disponible);
        topoService.save(theTopo);

        reservationService.save(reservation);
        return "redirect:/reservations/myReservation";
    }

    /**
     * methode pour changer le statut en disponible ou indisponible
     * @param theId
     * @return
     */
    @GetMapping("/changeStatus")
    public String changeStatus(@RequestParam("id")int theId){
        Topo theTopo = topoService.findById(theId);
        System.out.println(theTopo.getTopoStatus());
        if (theTopo.getTopoStatus().equalsIgnoreCase(disponible)){
            theTopo.setTopoStatus(indisponible);
            theTopo.setReleaseDate(LocalDate.now());
            topoService.save(theTopo);
        } else if (theTopo.getTopoStatus().equalsIgnoreCase(indisponible)){
            theTopo.setTopoStatus(disponible);
            topoService.save(theTopo);
        }
        return "redirect:/topo/myTopo";
    }

    @GetMapping("/officiel")
    public String offciel(@RequestParam("id") int id){
        Topo topo = topoService.findById(id);
        topo.setOfficial(true);
        topoService.save(topo);
        return "redirect:/topo/list";
    }
}
