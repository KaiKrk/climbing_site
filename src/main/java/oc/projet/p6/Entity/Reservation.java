package oc.projet.p6.Entity;

import javax.persistence.*;

/**
 * Entite Reservation, correspond a un reservation par un membre d'un topo disponible
 */
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int id;

    @Column(name = "reservation_status")
    private String reservationStatus;

    /**
     * membre emprunteur du topo
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "member_id")
    private Member borrowingMember;

    /**
     * membre proprietaire du topo
     */
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "member_id")
    private Member ownerMember;

    /**
     * topo voulant etre reserve par le membre emprunteur
     */
    @ManyToOne
    @JoinColumn(name = "topo_id", referencedColumnName = "id")
    private Topo topo;

    public Topo getTopo() {
        return topo;
    }



    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Reservation() {
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", borrowingMember=" + borrowingMember +
                ", ownerMember=" + ownerMember +
                ", topo=" + topo +
                '}';
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

    public Member getBorrowingMember() {
        return borrowingMember;
    }

    public void setBorrowingMember(Member borrowingMember) {
        this.borrowingMember = borrowingMember;
    }

    public Member getOwnerMember() {
        return ownerMember;
    }

    public void setOwnerMember(Member ownerMember) {
        this.ownerMember = ownerMember;
    }
}
