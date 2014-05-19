package com.amb_it_ion.refocus.business.interaction.impl;

import com.amb_it_ion.refocus.business.actor.api.Actor;
import com.amb_it_ion.refocus.business.actor.impl.ActorBase;
import com.amb_it_ion.refocus.business.interaction.api.Interaction;

public abstract class InteractionImpl implements Interaction {

	/*
	 * State
	 */
	
	private ActorBase actor; 
	
	@Override
	public Actor getActor() {
		return actor;
	}

	
	
	/*
	 * Constructor
	 */	
	
	public InteractionImpl(ActorBase actor) {
		this.actor = actor;
	}

}
