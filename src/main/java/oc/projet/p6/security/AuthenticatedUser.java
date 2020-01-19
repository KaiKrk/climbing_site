package oc.projet.p6.security;

import oc.projet.p6.Entity.Member;
import oc.projet.p6.Entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ramesh Fadatare
 *
 */
public class AuthenticatedUser extends org.springframework.security.core.userdetails.User
{

	private static final long serialVersionUID = 1L;
	private Member member;
	
	public AuthenticatedUser(Member member)
	{
		super(member.getEmail(), member.getPassword(), getAuthorities(member));
		this.member = member;
	}
	
	public Member getUser()
	{
		return member;
	}
	
	private static Collection<? extends GrantedAuthority> getAuthorities(Member member)
	{
		Set<String> roleAndPermissions = new HashSet<>();
		List<Role> roles = member.getRoles();
		
		for (Role role : roles)
		{
			roleAndPermissions.add(role.getName());
		}
		String[] roleNames = new String[roleAndPermissions.size()];
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
		return authorities;
	}
}
