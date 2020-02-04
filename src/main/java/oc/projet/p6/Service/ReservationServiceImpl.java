package oc.projet.p6.Service;

import oc.projet.p6.Dao.ReservationRepository;
import oc.projet.p6.Entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void  save(Reservation reservation) { reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAllByOwnerIdAndReservationStatusIgnoreCaseContaining(int theId, String id) {
        return reservationRepository.findAllByOwnerIdAndReservationStatusIgnoreCaseContaining(theId, id);
    }

//    @Override
//    public List<Reservation> findAllReservation(int theId) {
//       return reservationRepository.findAllReservation(theId);
//    }

    @Override
    public List<Reservation> findAllByUserIdAndReservationStatusIgnoreCaseContaining(int userId, String reservationStatus) {
        return reservationRepository.findAllByUserIdAndReservationStatusIgnoreCaseContaining(userId,reservationStatus);
    }

    @Override
    public Reservation findById(int reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public List<Reservation> findAllReservation(int userId, String status) {
        return reservationRepository.findAllReservation(userId, status);
    }


}
