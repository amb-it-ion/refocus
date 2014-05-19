package com.amb_it_ion.refocus.business.actor.impl.actor;

import com.amb_it_ion.refocus.business.actor.impl.ActorBase;


public class Search extends ActorBase {
	
	private boolean loggedIn;
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public Search()
	{
		super( "Search" );
	}
}
