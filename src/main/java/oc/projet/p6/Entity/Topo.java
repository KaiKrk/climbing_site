package oc.projet.p6.Entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * entite topo, comprenant un ou plusieurs secteurs
 */
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

    @Column(name = "official")
    private boolean official;

    /**
     * Membre auteur de ce topo
     */
    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    /**
     * List de commentaire lié a ce topo
     */
   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "topo_id")
   private List<Comment> comments;

    /**
     * List de reservation dans laquelle le topo reservé est celui ci
     */
   @OneToMany(mappedBy = "topo")
   private List<Reservation> reservation;

    @OneToMany( cascade=CascadeType.ALL)
    @JoinColumn(name="topo_id")
    private List<Sector> sectors;

    /**
     * date de parution du topo lorsqu'il est disponible
     */
    @Column(name = "release_date")
    private LocalDate releaseDate;

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

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

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public TopoFile getTopoFile() {
        return topoFile;
    }

    public void setTopoFile(TopoFile topoFile) {
        this.topoFile = topoFile;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Topo{" +
                "id=" + id +
                ", nameTopo='" + nameTopo + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", topoStatus='" + topoStatus + '\'' +
                ", topoFile=" + topoFile +
                ", official=" + official +
                ", member=" + member +
                ", comments=" + comments +
                ", reservation=" + reservation +
                ", sectors=" + sectors +
                ", releaseDate=" + releaseDate +
                '}';
    }
}

