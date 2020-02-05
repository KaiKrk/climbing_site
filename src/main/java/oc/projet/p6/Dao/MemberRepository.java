package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findMemberById(int id);

    List<Member> findAllMemberByOrderByIdAsc();

    Optional<Member> findByEmail(String email);

    Member findMemberByEmail(String email);
}
