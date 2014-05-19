package com.amb_it_ion.refocus.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.amb_it_ion.refocus.business.data.User;

@Entity
@Table(name = "User")
public class UserEntity extends User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	private long id;
	
	@Column(name = "world", length = 128, nullable = true)
	private String world;


	public UserEntity()
	{
		super();
	}
}
