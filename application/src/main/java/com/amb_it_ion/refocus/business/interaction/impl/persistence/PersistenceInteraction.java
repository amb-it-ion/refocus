package com.amb_it_ion.refocus.business.interaction.impl.persistence;

import com.amb_it_ion.refocus.business.actor.impl.actor.Persistence;
import com.amb_it_ion.refocus.business.interaction.impl.InteractionImpl;

abstract public class PersistenceInteraction extends InteractionImpl {

	public PersistenceInteraction() {
		super( new Persistence() );
	}
}
