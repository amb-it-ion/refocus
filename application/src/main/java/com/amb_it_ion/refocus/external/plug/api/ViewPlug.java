package com.amb_it_ion.refocus.external.plug.api;

import java.util.Collection;

import com.amb_it_ion.refocus.business.data.NavigationSection;
import com.amb_it_ion.refocus.control.usecase.impl.navigation.NavigationUseCase;

import rx.Observable;

public interface ViewPlug {

	public Observable<NavigationSection> selectOnList( Collection<NavigationSection> collection);
	
	public void start();
}
