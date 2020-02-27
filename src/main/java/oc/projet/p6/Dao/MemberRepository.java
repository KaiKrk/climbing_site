package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository des membres
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    /**
     * methode qui retourne un membre selon son id
     * @param id
     * @return le membre ayant comme id @param id
     */
    Member findMemberById(int id);

    /**
     * methode qui retourne tous les membres enregistrés avec leurs id en ordre croissant
     * @return List de tous les memebres
     */
    List<Member> findAllMemberByOrderByIdAsc();

    /**
     * methode qui retourne un membre selon son email
     * @param email
     * @return un Optinal de membre
     */
    Optional<Member> findByEmail(String email);

    /**
     * methode qui retourne un membre selon son email
     * @param email
     * @return un Optinal de membre
     */
    Member findMemberByEmail(String email);
}
