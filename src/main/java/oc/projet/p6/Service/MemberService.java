package oc.projet.p6.Service;


import oc.projet.p6.Entity.Member;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MemberService {

	public List<Member> findAll();
	
	public Member findById(int theId);

	public void save(Member theMember);

	public void deleteById(int theId);

	Member findMemberByEmail();
}
