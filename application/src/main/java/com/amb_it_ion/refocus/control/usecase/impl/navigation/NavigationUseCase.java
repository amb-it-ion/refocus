package com.amb_it_ion.refocus.control.usecase.impl.navigation;

import rx.Observable;

import com.amb_it_ion.refocus.business.data.NavigationSection;
import com.amb_it_ion.refocus.control.usecase.impl.UseCaseImpl;

public class NavigationUseCase extends UseCaseImpl {

	Observable<NavigationSection> state;

	public NavigationUseCase()
	{
		super("Navigation");
		
		Observable<NavigationSection> state = Observable.from( new NavigationSection("cat"), new NavigationSection("dog")  );
	}

	/*
	 * Behaviour
	 */

	public Observable<NavigationSection> start() {
		return state;
	}

	public void navigateTo( NavigationSection value )
	{
		
	}
}
