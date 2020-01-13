package oc.projet.p6.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sector")
public class Sector {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int sector_id;

    @Column(name = "sector_name")
    private String sector_name;

    @Column(name = "sector_status")
    private String sector_status;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="sector_id")
    private List<Way> ways;

    public int getSector_id() {
        return sector_id;
    }

    public void setSector_id(int sector_id) {
        this.sector_id = sector_id;
    }

    public String getSector_name() {
        return sector_name;
    }

    public void setSector_name(String sector_name) {
        this.sector_name = sector_name;
    }

    public String getSector_status() {
        return sector_status;
    }

    public void setSector_status(String sector_status) {
        this.sector_status = sector_status;
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
                "sector_id=" + sector_id +
                ", sector_name='" + sector_name + '\'' +
                ", sector_status='" + sector_status + '\'' +
                ", ways=" + ways +
                '}';
    }
}
