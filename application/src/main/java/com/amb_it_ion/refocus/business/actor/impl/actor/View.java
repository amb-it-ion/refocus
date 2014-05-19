package com.amb_it_ion.refocus.business.actor.impl.actor;

import com.amb_it_ion.refocus.business.actor.impl.ActorBase;


public class View extends ActorBase {
	
	private boolean loggedIn;
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public View()
	{
		super( "View" );
	}
}
