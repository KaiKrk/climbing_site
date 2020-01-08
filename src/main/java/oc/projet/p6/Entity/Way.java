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

    @Column(name = "sector_id")
    private int sector_id;

}
