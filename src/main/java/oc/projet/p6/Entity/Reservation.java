package oc.projet.p6.Entity;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @Column(name = "reservation_status")
    private String reservationStatus;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "topo_id")
    private int topoId;

    public Reservation() {
    }

    public Reservation(String reservationStatus, int userId, int topoId) {
        this.reservationStatus = reservationStatus;
        this.userId = userId;
        this.topoId = topoId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
    }
}
