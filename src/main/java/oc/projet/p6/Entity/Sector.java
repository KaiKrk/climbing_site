package oc.projet.p6.Entity;

import javax.persistence.*;

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

    @Column(name = "topo_id")
    private int topo_id;
}
