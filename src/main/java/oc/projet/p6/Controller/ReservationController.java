package oc.projet.p6.Controller;

import oc.projet.p6.Entity.*;
import oc.projet.p6.Service.MemberService;
import oc.projet.p6.Service.ReservationService;
import oc.projet.p6.Service.TopoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe Controller des Reservations
 */
@Controller
@RequestMapping("/reservations")
public class ReservationController {
    Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    @Autowired
    private TopoService topoService;

    @Autowired
    private MemberService  memberService;

    @Autowired
    private ReservationService reservationService;

    /**
     * methode qui retourne une page avec tous les topos disponible
     * @param theModel
     * @return
     */
    @GetMapping("/reservation")
    public String reservationList(Model theModel){
        String status = DisponibiliteStatus.Disponible.toString();
        List<Topo> availableTopo = topoService.findAllByTopoStatus(status);
        theModel.addAttribute("topos", availableTopo);
        return "reservation/reservation-list";
    }

    /**
     * methode qui retourne la page pour confirmer une reservation
     * @param theId
     * @param theModel
     * @return
     */
    @GetMapping("/confirmReservation")
    public String confirm(@RequestParam("id") int theId, Model theModel){
        Reservation reservation = new Reservation();
        String statut = ReservationStatus.EnAttente.toString();
        Topo theTopo = topoService.findById(theId);
        Member theMember = memberService.findMemberByEmail();
        reservation.setTopo(theTopo);
        reservation.setBorrowingMember(theMember);
        reservation.setReservationStatus(statut);
        theModel.addAttribute("reservation" ,reservation);

        return "reservation/confirmation-reservation";
    }

    /**
     * methode qui enregistre une reservation et redirige vers l'accueil
     * @param reservation
     * @return
     */
    @PostMapping("save")
    public String save(@ModelAttribute("reservation") Reservation reservation) {
        Topo theTopo = topoService.findById(reservation.getTopo().getId());
        Member theMember = memberService.findMemberByEmail();
        String reservationStatut = ReservationStatus.EnAttente.toString();
        String topoStatut = DisponibiliteStatus.Indisponible.toString();
        reservation.setTopo(theTopo);
        reservation.setBorrowingMember(theMember);
        reservation.setReservationStatus(reservationStatut);
        reservation.setOwnerMember(theTopo.getMember());
        System.out.println("avant le save " + reservation.toString());
        reservationService.save(reservation);
       //  Topo theTopo = reservation.getTopo();
        topoService.changeAvaibility(theTopo,topoStatut);
        topoService.save(theTopo);
        logger.info("Reservation on Topo :" +reservation.getTopo().getNameTopo()+ " by Member : "+ reservation.getBorrowingMember().getName() );
        return "redirect:/home";
    }

    /**
     * methode qui retourne la page avec les demandes de reservation ainsi que les topos empruntes
     * @param theModel
     * @return
     */
    @GetMapping("/myReservation")
    public String showReservation(Model theModel){
        Member theMember = memberService.findMemberByEmail();
        String statusAttente = ReservationStatus.EnAttente.toString();
        String statusAccept = ReservationStatus.Accepte.toString();
        int theId = theMember.getId();
        System.out.println(theId);
        List<Reservation> queryreservation = reservationService.findAllByOwnerMemberAndReservationStatusIgnoreCaseContaining(theMember, statusAttente);
        theModel.addAttribute("reservation", queryreservation);
        List<Reservation> topoReserve = reservationService.findAllByBorrowingMemberAndReservationStatusIgnoreCaseContaining(theMember, statusAccept);
       theModel.addAttribute("topos", topoReserve);
        return "reservation/reservation-personnal";
    }


    /**
     * methode qui manage l'acceptance ou le refus d'une demande de reservation
     * @param action
     * @param reservationId
     * @return
     */
    @GetMapping("/management")
    public String allowReservation(@RequestParam(value = "action" , required = false) String action, @RequestParam(value = "id") int reservationId){
        String statusAccept = ReservationStatus.Accepte.toString();
        String statusDecline = ReservationStatus.Refusee.toString();
        String disponible = DisponibiliteStatus.Disponible.toString();

        if (action.equalsIgnoreCase("accept")){
            System.out.println("accept confirm" + "id = " +reservationId);
            logger.info("Reservation with id : "+ reservationId + " is accepted");
            Reservation reservation = reservationService.findById(reservationId);
            reservationService.changeStatus(reservation,statusAccept);
            reservationService.save(reservation);

        } else if (action.equalsIgnoreCase("decline")){
            System.out.println("decline confirm" + "id = " +reservationId);
            logger.info("Reservation with id : "+ reservationId + " is declined");
            Reservation reservation = reservationService.findById(reservationId);
            reservationService.changeStatus(reservation,statusDecline);
            topoService.changeAvaibility(reservation.getTopo(),disponible);
            reservationService.save(reservation);
        }

        System.out.println("out");
        return "redirect:/reservations/myReservation";
    }
    }
