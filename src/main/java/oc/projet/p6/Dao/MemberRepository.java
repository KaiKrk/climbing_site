package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {


	
}
