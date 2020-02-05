package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Member;
import oc.projet.p6.Entity.Reservation;
import oc.projet.p6.Entity.Topo;
import oc.projet.p6.Service.MemberService;
import oc.projet.p6.Service.ReservationService;
import oc.projet.p6.Service.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private TopoService topoService;

    @Autowired
    private MemberService  memberService;

    @Autowired
    private ReservationService reservationService;

    String statutPending = "En Attente";// a mettre dans une enum
    String statutAccepted = "Accepte";
    String statutDeclined = "Rejete";

    @GetMapping("/reservation")
    public String reservationList(Model theModel){
        String status = "Disponible"; // a mettre dans une enum
        List<Topo> availableTopo = topoService.findAllByTopoStatus(status);
        theModel.addAttribute("topos", availableTopo);
        return "reservation-list";
    }

    @GetMapping("/confirmReservation")
    public String confirm(@RequestParam("id") int theId, Model theModel){
        Reservation reservation = new Reservation();
        Topo theTopo = topoService.findById(theId);
        //       theTopo.setTopoStatus("Indisponible");
//        reservation.setTopo();
  //      reservation.setOwnerId(theTopo.getMember().getId());

        Member theMember = memberService.findMemberByEmail();
        reservation.setTopo(theTopo);
        reservation.setUserId(theMember.getId());
        reservation.setReservationStatus("En Attente");
        theModel.addAttribute("reservation" ,reservation);

        return "confirmation-reservation";
    }

    @PostMapping("save")
    public String save(@ModelAttribute("reservation") Reservation reservation) {
        String status = "Indisponible";
        reservationService.save(reservation);
        Topo theTopo = topoService.findById(reservation.getTopo().getId());
        theTopo.setTopoStatus(status);
        topoService.save(theTopo);
        return "redirect:/welcome";
    }

    @GetMapping("/myReservation")
    public String showReservation(Model theModel){
        //Demande de reservations
        Member theMember = memberService.findMemberByEmail();
        int theId = theMember.getId();
        System.out.println(theId);

        String st = "En Attente";
        System.out.println("-----------------------------------------------------");
        List<Reservation> reservations = reservationService.findAllByOwnerIdAndReservationStatusIgnoreCaseContaining(theId, statutPending);
        System.out.println("-----------------------------------------------------");
        List<Reservation> queryreservation = reservationService.findAllReservation(theId, statutPending);
        System.out.println("-----------------------------------------------------");
        System.out.println("1 " +reservations);
        System.out.println(st);
        System.out.println("2" + queryreservation);
        theModel.addAttribute("reservation", queryreservation);
        //Topo Empruntes

        List<Reservation> topoReserve = reservationService.findAllByUserIdAndReservationStatusIgnoreCaseContaining(theId, statutAccepted);
        System.out.println(topoReserve.toString()); // check
//        List<Topo> topos = new ArrayList<>();
//        for (Reservation reservation: topoReserve
//             ) {
//            Topo theTopo = topoService.findById(reservation.getTopo().getId());
//            topos.add(theTopo);
//            System.out.println(" B "+ theTopo.toString()); // check
//        }
//        theModel.addAttribute("topos", topos);

       theModel.addAttribute("topos", topoReserve);
        return "reservation/reservation-personnal";
    }



    @GetMapping("/management")
    public String allowReservation(@RequestParam(value = "action" , required = false) String action, @RequestParam(value = "id") int reservationId){
        if (action.equalsIgnoreCase("accept")){
            System.out.println("accept confirm" + "id = " +reservationId);
            Reservation reservation = reservationService.findById(reservationId);
            reservation.setReservationStatus(statutAccepted);
            reservationService.save(reservation);

        } else if (action.equalsIgnoreCase("decline")){
            System.out.println("decline confirm" + "id = " +reservationId);
            Reservation reservation = reservationService.findById(reservationId);
            reservation.getTopo().setTopoStatus("Disponible");
         //   reservation.setReservationStatus(statutDeclined);
            reservationService.deleteById(reservationId);
         //   reservationService.save(reservation);
        }

        System.out.println("out");
        return "redirect:/reservations/myReservation";
    }
    }
