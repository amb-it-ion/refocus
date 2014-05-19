package com.amb_it_ion.refocus.business.interaction.impl.persistence.entity;

import org.jinq.orm.stream.JinqStream;

import com.amb_it_ion.refocus.business.entity.api.Entity;
import com.amb_it_ion.refocus.business.interaction.impl.persistence.PersistenceInteraction;

public class FindByID extends PersistenceInteraction {

	JinqStream<Entity> entityStream;

	public Entity act( Integer value ) {

		return entityStream.where( c -> c.getId().equals(value)).toList().get(0);

	}

}
