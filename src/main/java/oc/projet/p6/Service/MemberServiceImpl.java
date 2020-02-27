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

/**
 * Classe Service des Membres
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	EntityManager entityManager;

	@Autowired
	private MemberRepository memberRepository;

	/**
	 * methode qui retourne tous les membres
	 * @return List de tous les membres
	 */
	@Override
	public List<Member> findAll() {
		return memberRepository.findAllMemberByOrderByIdAsc();
	}

	/**
	 * methode qui retourne un membre selon son id
	 * @param theId
	 * @return un membre
	 */
	@Override
	public Member findById(int theId) {
		return memberRepository.findMemberById(theId);
	}

	/**
	 * methode qui insert ou update un membre en bdd
	 * @param theMember
	 */
	@Override
	public void save(Member theMember) {
		memberRepository.save(theMember);
	}

	/**
	 * methode qui supprime un membre de la bdd
	 * @param theId
	 */
	@Override
	public void deleteById(int theId) {
		memberRepository.deleteById(theId);
	}

	/**
	 * methode qui retourne un membre selon son email
	 * @return un membre
	 */
	@Override
	public Member findMemberByEmail() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Member theMember = memberRepository.findMemberByEmail(currentPrincipalName);
		return theMember;
	}


}






