package com.amb_it_ion.refocus.business.interaction.impl.view.navigation;

import java.util.Collection;

import com.amb_it_ion.refocus.business.data.NavigationSection;

import rx.Observable;

public interface NavigationViewInteraction {
	public Observable<NavigationSection> navigateTo( Collection<NavigationSection> collection);
}
