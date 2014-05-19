package com.amb_it_ion.refocus.business.interaction.impl.view;

import java.util.Collection;

import rx.Observable;

import com.amb_it_ion.refocus.business.interaction.api.Interaction;

public interface ViewInteraction<T> extends Interaction {
	
	
	/*
	 * Constructor
	 */	
	
//	public ViewInteraction() {
//		super( new View() );
//	}
	

	public Observable<T> selectOnList( Collection<T> collection);
}
