package com.amb_it_ion.refocus.business.data;

import com.amb_it_ion.refocus.business.entity.api.Entity;
import com.amb_it_ion.refocus.business.entity.api.RoleOwner;

public class User implements Entity, RoleOwner{

	public Integer id;
	public String name;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setID(Integer value) {
		id = value;
	}
}
