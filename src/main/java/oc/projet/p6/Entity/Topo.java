package oc.projet.p6.Entity;

import org.codehaus.groovy.reflection.CacheAccessControlException;

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

    @OneToOne(mappedBy = "topo")
    private TopoFile topoFile;

    public TopoFile getTopoFile() {
        return topoFile;
    }

    public void setTopoFile(TopoFile topoFile) {
        this.topoFile = topoFile;
    }
    //    @Column(name = "user_id")

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
//    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Member member;

   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "topo_id")
   private List<Comment> comments;

    @OneToMany(mappedBy = "topo")
    private List<Reservation> reservation;

    @OneToMany( cascade=CascadeType.ALL)
    @JoinColumn(name="topo_id")
    private List<Sector> sectors;



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

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
public Member getMember() {
    return member;
}

    public void setMember(Member member) {
        this.member = member;
    }

    public Topo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
//                ", userId=" + userId +
                ", sectors=" + sectors +
                '}';
    }
}

