package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation,Integer> {

   @Query("select reservation from Reservation reservation join reservation.topo topo where topo.userId = :theId and reservation.reservationStatus = :status")
    List<Reservation> findAllReservation(int theId, String status);

    Reservation findById(int id);

    List<Reservation> findAllByOwnerIdAndReservationStatusIgnoreCaseContaining(int theId, String reservationStatus);

    List<Reservation> findAllByUserIdAndReservationStatusIgnoreCaseContaining(int userId, String reservationStatus);


}
