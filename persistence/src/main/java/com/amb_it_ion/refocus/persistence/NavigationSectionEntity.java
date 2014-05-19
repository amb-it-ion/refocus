package com.amb_it_ion.refocus.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.amb_it_ion.refocus.business.data.NavigationSection;

@Entity
@Table(name = "NavigationSectionEntity")
public class NavigationSectionEntity extends NavigationSection
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "navigation_section_id")
	private long id;

	@Column(name = "name", length = 128, nullable = true)
	private String name;
	
	private NavigationSectionEntity() {
		super();
	}
	
	public NavigationSectionEntity(String name) {
		super(name);
	}
}
