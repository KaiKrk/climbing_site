package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Member;
import oc.projet.p6.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository des reservations
 */
@Repository
public interface ReservationRepository extends JpaRepository <Reservation,Integer> {
    /**
     * methode qui affiche toutes les demandes reservations du membre connecté et qui sont en attente d'une reponse
     * @param theId
     * @param status
     * @return une liste de reservation
     */
   @Query("select reservation from Reservation reservation join reservation.topo topo join topo.member membre where membre.id = :theId and reservation.reservationStatus = :status")
    List<Reservation> findAllReservation(int theId, String status);

    /**
     * methode qui retourne une reservation selon son id
     * @param id
     * @return resersavtion
     */
    Reservation findById(int id);

    /**
     * methode qui affiche toutes les demandes reservations du membre connecté et qui sont en attente d'une reponse
     * @param owner
     * @param reservationStatus
     * @return une liste de reservation
     */
    List<Reservation> findAllByOwnerMemberAndReservationStatusIgnoreCaseContaining(Member owner, String reservationStatus);

    /**
     * methode qui affiche toutes les toutes les reservations acceptées du membre connecté
     * @param borrower
     * @param reservationStatus
     * @return
     */
    List<Reservation> findAllByBorrowingMemberAndReservationStatusIgnoreCaseContaining(Member borrower, String reservationStatus);


}
