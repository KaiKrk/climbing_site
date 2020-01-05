package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	// that's it ... no need to write any code LOL!
	
	// add a method to sort by last name
	public List<Member> findAll();
	
}
