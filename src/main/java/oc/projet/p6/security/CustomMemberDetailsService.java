package oc.projet.p6.security;

import oc.projet.p6.Dao.MemberRepository;
import oc.projet.p6.Entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * classe contenant les methodes de login des membres inscrit au site
 */
@Service
@Transactional
public class CustomMemberDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
        return new org.springframework.security.core.userdetails.User(member.getEmail(), member.getPassword(),
                getAuthorities(member));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Member member) {
        String[] memberRoles = member.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(memberRoles);
        System.out.println(authorities);
        return authorities;
    }
}
