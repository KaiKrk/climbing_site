package oc.projet.p6.Service;

import oc.projet.p6.Dao.ReservationRepository;
import oc.projet.p6.Entity.Member;
import oc.projet.p6.Entity.Reservation;

import java.util.List;

public interface ReservationService {

    void save(Reservation reservation);

    List<Reservation> findAllByOwnerMemberAndReservationStatusIgnoreCaseContaining(Member owner, String reservationId);

    List<Reservation> findAllByBorrowingMemberAndReservationStatusIgnoreCaseContaining(Member borrower, String reservationStatus);

    Reservation findById(int reservationId);

    void changeStatus(Reservation reservation, String status);
}
