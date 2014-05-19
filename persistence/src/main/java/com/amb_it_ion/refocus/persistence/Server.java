package com.amb_it_ion.refocus.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.orm.stream.JinqStream;

import com.amb_it_ion.refocus.business.data.NavigationSection;
import com.amb_it_ion.refocus.business.entity.api.Entity;
import com.amb_it_ion.refocus.external.plug.api.PersistencePlug;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/**
 * This class is responsible for starting up the servers and doing the required initialization.
 */

@Singleton
public class Server implements PersistencePlug
{
	private static final String PERSISTENCE_UNIT_NAME = "persistenceUnit";
	private static EntityManager em = null;

	/**
	 * Does the required initialization for the application.
	 */
	public static synchronized void init()
	{
		if (em == null)
		{
			em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
			initDB();
		}
	}
	
	public JinqStream<NavigationSection> getJinqStream()
	{
		JinqJPAStreamProvider streams = new JinqJPAStreamProvider(em.getMetamodel());
		
		return streams.streamAll(em, NavigationSection.class);
	}

	/**
	 * Returns the entity manager.
	 *
	 * @return the entity manager.
	 */
	public static EntityManager getEntityManager()
	{
		return em;
	}

	/**
	 * Starts the DB and Jetty server.
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) throws Exception
	{
		// Create embedded HSQLDB server.
		final org.hsqldb.Server hsqlServer = new org.hsqldb.Server();

		// HSQLDB prints out a lot of information when
		// starting and closing, which we don't need now.
		// Normally you should point the setLogWriter
		// to some Writer object that could store the logs.
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);

		// The actual database will be named 'xdb' and its
		// settings and data will be stored in files
		// testdb.properties and testdb.script
		hsqlServer.setDatabaseName(0, "xdb");
		//hsqlServer.setDatabasePath(0, "file:testdb");
		hsqlServer.setDatabasePath(0, "mem:testdb");

		// Start the database!
		hsqlServer.start();
		
		init();
		
		String hql = "update UserEntity set world = 'xes' where id = '1'";

		em.getTransaction().begin();
		
		Query query = em.createQuery(hql);
		int result = query.executeUpdate();

		em.flush();
		em.getTransaction().commit();
		
		final TypedQuery<UserEntity> query2 = em.createQuery("SELECT t FROM UserEntity t", UserEntity.class);

		
		for (final UserEntity entity : query2.getResultList())
		{
			System.out.println( entity.name );
		}

        Injector injector = Guice.createInjector(new AppInjector());        
        Server server = injector.getInstance(Server.class);
	}

	private static void initDB()
	{
		em.getTransaction().begin();
		
		em.persist( new NavigationSectionEntity( "dog" ));
		em.persist( new NavigationSectionEntity( "cat" ));
		em.persist( new NavigationSectionEntity( "pinguin" ));
		
		UserEntity user = new UserEntity();
		user.name = "test";
		em.persist( user );
		em.flush();
		em.getTransaction().commit();
		
		em.clear();
	}
}
