package oc.projet.p6.Entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "member_id")
    private int memberId;


    @Column(name = "comment_status")
    private String commentStatus;

    @ManyToOne
    private Topo topo;
}
