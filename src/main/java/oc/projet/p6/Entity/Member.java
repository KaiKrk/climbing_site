package oc.projet.p6.Entity;

import javax.persistence.*;
import java.util.List;

/**
 *Entite membre, correspond a un utilisateur enregistré du site
 */
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "country")
    private String country;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    /**
     *Liste des Topos personels
     */
    @OneToMany( cascade=CascadeType.ALL,  mappedBy = "member")
    private List<Topo> topos;

    /**
     * Roles de l'utilisateur, User ou Admin
     */
    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="member_role",
            joinColumns={@JoinColumn(name="MEMBER_ID", referencedColumnName="member_id")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles;


    public List<Topo> getTopos() {
        return topos;
    }

    public void setTopos(List<Topo> topos) {
        this.topos = topos;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Member(String name, String surname, String pseudo, String country, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.pseudo = pseudo;
        this.country = country;
        this.email = email;
        this.password = password;
    }

    public Member() {

    }


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
