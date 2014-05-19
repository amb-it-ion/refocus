package com.amb_it_ion.refocus.external.plug.api;

import org.jinq.orm.stream.JinqStream;

import com.amb_it_ion.refocus.business.data.NavigationSection;

public interface PersistencePlug {

	public JinqStream<NavigationSection> getJinqStream();
}
