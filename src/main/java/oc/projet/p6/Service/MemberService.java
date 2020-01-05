package oc.projet.p6.Service;


import oc.projet.p6.Entity.Member;

import java.util.List;


public interface MemberService {

	public List<Member> findAll();
	
	public Member findById(int theId);

	public void save(Member theEmployee);

	public void deleteById(int theId);
	
}
