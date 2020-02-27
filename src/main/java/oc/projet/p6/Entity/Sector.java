package oc.projet.p6.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * entite secteur, lie a un topo et contenant des voies
 */
@Entity
@Table(name = "sector")
public class Sector {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "sector_id")
    private int id;

    @Column(name = "sector_name")
    private String sectorName;

    @Column(name = "sector_status")
    private String sectorStatus;
    /**
     * topo contenant ce secteur
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

    @OneToMany( cascade=CascadeType.ALL)
    @JoinColumn(name="sector_id")
    private List<Way> ways;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getSectorStatus() {
        return sectorStatus;
    }

    public void setSectorStatus(String sectorStatus) {
        this.sectorStatus = sectorStatus;
    }

    public List<Way> getWays() {
        return ways;
    }

    public void setWays(List<Way> ways) {
        this.ways = ways;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "sector_id=" + id +
                ", sector_name='" + sectorName + '\'' +
                ", sector_status='" + sectorStatus + '\'' +
//                ", topo_id=" + topoId +
                ", ways=" + ways +
                '}';
    }
}
