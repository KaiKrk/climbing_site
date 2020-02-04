package oc.projet.p6.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "topo")
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_topo")
    private String nameTopo;

    @Column(name = "region")
    private String region;

    @Column(name = "country")
    private String country;

    @Column(name = "topo_status")
    private String topoStatus;

    @Column(name = "user_id")
    private int userId;

    @OneToOne(mappedBy = "topo")
    private Reservation reservation;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="topo_id")
    private List<Sector> sectors;

    @OneToMany( cascade=CascadeType.REMOVE, orphanRemoval=true, mappedBy="topo")
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }

    public Topo(String nameTopo, String region, String country, String topoStatus, int user_id) {
        this.nameTopo = nameTopo;
        this.region = region;
        this.country = country;
        this.topoStatus = topoStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Topo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getNameTopo() {
        return nameTopo;
    }

    public void setNameTopo(String nameTopo) {
        this.nameTopo = nameTopo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTopoStatus() {
        return topoStatus;
    }

    public void setTopoStatus(String topoStatus) {
        this.topoStatus = topoStatus;
    }

    @Override
    public String toString() {
        return "Topo{" +
                "topo_id=" + id +
                ", name_topo='" + nameTopo + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", topo_status='" + topoStatus + '\'' +
                ", userId=" + userId +
                ", sectors=" + sectors +
                '}';
    }
}

