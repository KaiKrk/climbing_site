package oc.projet.p6.Entity;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table(name = "way")
public class Way {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int way_id;

    @Column(name = "name")
    private String name_way;

    @Column(name = "cotation")
    private String difficulty;

    @Column(name = "number_points")
    private int points;

//    @Column(name = "sector_id")
//    private int sector_id;

    @ManyToOne
    @JoinColumn(name = "sector_id",referencedColumnName="sector_id", nullable = false)
    private Sector sector;

    public Way() {
    }

    public Way(String name_way, String difficulty, int points, int sector_id, Sector sector) {
        this.name_way = name_way;
        this.difficulty = difficulty;
        this.points = points;
//        this.sector_id = sector_id;
        this.sector = sector;
    }

    public int getWay_id() {
        return way_id;
    }

    public void setWay_id(int way_id) {
        this.way_id = way_id;
    }

    public String getName_way() {
        return name_way;
    }

    public void setName_way(String name_way) {
        this.name_way = name_way;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

//    public int getSector_id() {
//        return sector_id;
//    }
//
//    public void setSector_id(int sector_id) {
//        this.sector_id = sector_id;
//    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
