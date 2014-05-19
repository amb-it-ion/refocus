package com.amb_it_ion.refocus.external.jack.impl.view;

import org.jinq.orm.stream.JinqStream;

import rx.Observable;

import com.amb_it_ion.refocus.business.data.NavigationSection;
import com.amb_it_ion.refocus.external.jack.impl.JackImpl;
import com.amb_it_ion.refocus.external.plug.api.PersistencePlug;
import com.amb_it_ion.refocus.external.plug.api.ViewPlug;
import com.google.inject.Inject;

public class ViewJack extends JackImpl{
	
	// TODO dependency
	ViewPlug viewPlug;
	
	JinqStream<NavigationSection> navigationSectionStream;
	
	@Inject
	PersistencePlug persistencePlug;
	
	public void init()
	{
		Observable<NavigationSection> navigationObs = viewPlug.selectOnList( navigationSectionStream.toList() );
	}

}
