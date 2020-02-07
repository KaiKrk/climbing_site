package oc.projet.p6.Entity;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    @Column(name = "comment")
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "user_id")
    private Member member;


    @ManyToOne
    @JoinColumn(name = "topo_id", referencedColumnName = "id")
    private Topo topo;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + commentaire + '\'' +
                ", member=" + member +
                ", topo=" + topo +
                '}';
    }

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
