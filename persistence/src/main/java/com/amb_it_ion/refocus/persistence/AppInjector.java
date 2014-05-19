package com.amb_it_ion.refocus.persistence;

import com.amb_it_ion.refocus.external.plug.api.PersistencePlug;
import com.google.inject.AbstractModule;

public class AppInjector extends AbstractModule {
	 
    @Override
    protected void configure() {
        bind(PersistencePlug.class).to(Server.class); 
    }
 
}