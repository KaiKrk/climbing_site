package oc.projet.p6.Entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="roles")
public class Role
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name",nullable=false, unique=true)
	private String name;
		
	@ManyToMany(mappedBy="roles")
	private List<Member> members;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Member> getUsers() {
		return members;
	}

	public void setUsers(List<Member> users) {
		this.members = members;
	}
	
}
