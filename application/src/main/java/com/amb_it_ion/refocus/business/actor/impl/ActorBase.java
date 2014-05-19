package com.amb_it_ion.refocus.business.actor.impl;

import com.amb_it_ion.refocus.business.actor.api.Actor;

public class ActorBase implements Actor{

	
	
	/*
	 * State  
	 */
	
	private String name;

	@Override
	public String getName() {
		return name;
	}
	

	
	/*
	 * Constructor
	 */
	
	public ActorBase(String name) {
		this.name = name;
	}
	
	
	
	/*
	 * behaviour
	 */
	
	@Override
	public String toString()
	{
		return name;
	}
}
