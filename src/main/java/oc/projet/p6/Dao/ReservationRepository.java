package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository <Reservation,Integer> {
}
