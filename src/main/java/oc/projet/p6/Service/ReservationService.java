package oc.projet.p6.Service;

import oc.projet.p6.Dao.ReservationRepository;
import oc.projet.p6.Entity.Reservation;

import java.util.List;

public interface ReservationService {

    public void save(Reservation reservation);

    List<Reservation> findAllByOwnerIdAndReservationStatusIgnoreCaseContaining(int theId, String reservationId);

    List<Reservation> findAllByUserIdAndReservationStatusIgnoreCaseContaining(int userId, String reservationStatus);

    Reservation findById(int reservationId);

    List<Reservation> findAllReservation(int userId, String status);

    public void deleteById(int theId);
}
