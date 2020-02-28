package oc.projet.p6.Service;


import oc.projet.p6.Entity.Member;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MemberService {

	List<Member> findAll();
	
	Member findById(int theId);

	void save(Member theMember);

	Member findMemberByEmail();
}
