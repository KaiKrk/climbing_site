package oc.projet.p6.Entity;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int id;

    @Column(name = "reservation_status")
    private String reservationStatus;

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Column(name = "owner_id")
    private int ownerId;

    @Column(name = "user_id")
    private int userId;

    @OneToOne
    @JoinColumn(name = "topo_id", referencedColumnName = "id")
    private Topo topo;

    public Topo getTopo() {
        return topo;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + id +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", ownerId=" + ownerId +
                ", userId=" + userId +
                ", topo=" + topo +
                '}';
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }
//
//    @Column(name = "topo_id")
//    private int topoId;

    public Reservation() {
    }

    public Reservation(String reservationStatus, int userId, int topoId) {
        this.reservationStatus = reservationStatus;
        this.userId = userId;
//        this.topoId = topoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
//
//    public int getTopoId() {
//        return topoId;
//    }
//
//    public void setTopoId(int topoId) {
//        this.topoId = topoId;
//    }
}
