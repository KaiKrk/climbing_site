package oc.projet.p6.Service;

import oc.projet.p6.Dao.MemberRepository;
import oc.projet.p6.Entity.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	EntityManager entityManager;

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public List<Member> findAll() {
		return memberRepository.findAllMemberByOrderByIdAsc();
	}

	@Override
	public Member findById(int theId) {
		return memberRepository.findMemberById(theId);
	}

	@Override
	public void save(Member theMember) {
		memberRepository.save(theMember);
	}

	@Override
	public void deleteById(int theId) {
		memberRepository.deleteById(theId);
	}

	@Override// a mettre en @Query
	public Member findByName(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		String hql = " From Member m where m.email='"+currentPrincipalName+"'";
		Query query = entityManager.createQuery(hql);
		List results = query.getResultList();
		Member currentMember = (Member)results.get(0);
		System.out.println(currentMember);
		return currentMember;
	}

	@Override
	public Member findMemberByEmail() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Member theMember = memberRepository.findMemberByEmail(currentPrincipalName);
		return theMember;
	}


}






