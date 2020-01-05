package oc.projet.p6.Service;

import oc.projet.p6.Dao.MemberRepository;
import oc.projet.p6.Entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public Member findById(int theId) {
		Optional<Member> result = memberRepository.findById(theId);

		Member theMember = null;
		
		if (result.isPresent()) {
			theMember = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find member id - " + theId);
		}
		
		return theMember;
	}

	@Override
	public void save(Member theMember) {
		memberRepository.save(theMember);
	}

	@Override
	public void deleteById(int theId) {
		memberRepository.deleteById(theId);
	}

}






