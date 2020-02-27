package oc.projet.p6.Service;

import oc.projet.p6.Dao.ReservationRepository;
import oc.projet.p6.Entity.Member;
import oc.projet.p6.Entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe Service des reservations
 */
@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void  save(Reservation reservation) { reservationRepository.save(reservation);
    }

    /**
     * methode qui retourne toutes les reservations ayant comme auteur owner et comme statut reservationStatus
     * @param owner
     * @param reservationStatus
     * @return
     */
    @Override
    public List<Reservation> findAllByOwnerMemberAndReservationStatusIgnoreCaseContaining(Member owner, String reservationStatus) {
        return reservationRepository.findAllByOwnerMemberAndReservationStatusIgnoreCaseContaining(owner, reservationStatus);
    }

    /**
     * methode qui retourne toutes les reservations ayant comme emprunteur borrower et comme statut reservationStatus
     * @param borrower
     * @param reservationStatus
     * @return
     */
    @Override
    public List<Reservation> findAllByBorrowingMemberAndReservationStatusIgnoreCaseContaining(Member borrower, String reservationStatus) {
        return reservationRepository.findAllByBorrowingMemberAndReservationStatusIgnoreCaseContaining(borrower, reservationStatus);
    }

    /**
     * methode qui retourne une reservation selon son id
     * @param reservationId
     * @return
     */
    @Override
    public Reservation findById(int reservationId) {
        return reservationRepository.findById(reservationId);
    }

    /**
     * methode qui change le statut d'une reservation
     * @param reservation
     * @param status
     */
    @Override
    public void changeStatus(Reservation reservation, String status) {
        reservation.setReservationStatus(status);
    }


}
