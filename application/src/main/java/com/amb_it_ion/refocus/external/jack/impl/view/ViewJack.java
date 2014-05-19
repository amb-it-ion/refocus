package com.amb_it_ion.refocus.external.jack.impl.view;

import org.jinq.orm.stream.JinqStream;

import rx.Observable;

import com.amb_it_ion.refocus.business.data.NavigationSection;
import com.amb_it_ion.refocus.control.usecase.impl.navigation.NavigationUseCase;
import com.amb_it_ion.refocus.external.jack.impl.JackImpl;
import com.amb_it_ion.refocus.external.plug.api.PersistencePlug;
import com.amb_it_ion.refocus.external.plug.api.ViewPlug;
import com.google.inject.Inject;

public class ViewJack extends JackImpl {
	
	ViewPlug viewPlug;
	
	public Observable<NavigationSection> ready()
	{
		NavigationUseCase useCase = new NavigationUseCase();
		
		return useCase.start();
	}
	
	
}
