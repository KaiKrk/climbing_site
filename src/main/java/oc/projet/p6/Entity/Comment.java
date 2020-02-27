package oc.projet.p6.Entity;

import javax.persistence.*;

/**
 *  Entite Comment qui correspond a un commentaire d'un utilisateur sur un site
 */
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    /**
     * contenu du commentaire
     */
    @Column(name = "comment")
    private String commentaire;


    /**
     * Auteur du commentaire
     */
    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    /**
     *le topo dans lequel le commantaire est soumis
     */
    @ManyToOne
    @JoinColumn(name = "topo_id", referencedColumnName = "id")
    private Topo topo;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }
}
