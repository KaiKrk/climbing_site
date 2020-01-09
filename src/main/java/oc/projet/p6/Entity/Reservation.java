package oc.projet.p6.Entity;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservation_id;

    @Column(name = "reservation_status")
    private String reservation_status;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "topo_id")
    private int topo_id;

    public Reservation() {
    }

    public Reservation(String reservation_status, int user_id, int topo_id) {
        this.reservation_status = reservation_status;
        this.user_id = user_id;
        this.topo_id = topo_id;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(String reservation_status) {
        this.reservation_status = reservation_status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTopo_id() {
        return topo_id;
    }

    public void setTopo_id(int topo_id) {
        this.topo_id = topo_id;
    }
}
