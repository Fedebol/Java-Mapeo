package com.boldrini.federico.reunion.utiles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("reunion");
		EntityManager manager = factory.createEntityManager();
		return manager;
		
	}
	
	

}
