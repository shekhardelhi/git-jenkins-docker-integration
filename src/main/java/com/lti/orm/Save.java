package com.lti.orm;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

public class Save {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = null;
	    EntityManager entityManager = null;
	    EntityTransaction transaction = null;
	    try {
	      emf = Persistence.createEntityManagerFactory("emp");
	      entityManager = emf.createEntityManager();
	      transaction = entityManager.getTransaction();
	      transaction.begin();
	      Employee e1= new Employee();
			e1.setId(112);
			e1.setFirstName("vikas");
			e1.setLastName("Kumar");
	      entityManager.persist(e1);
	      transaction.commit();
		
		
		/*Configuration cfg= new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tx= session.beginTransaction();
		
		
		Employee e1= new Employee();
		e1.setId(102);
		e1.setFirstName("Vijay");
		e1.setLastName("R");
		
		session.save(e1);
		tx.commit();*/
		System.out.println("Record Inserted");
		
		//factory.close();
		//session.close();
		
		Query q = entityManager.createQuery("select s from emp s");
	     
		List<Employee> resultList = q.getResultList();
	      System.out.println("num of sudents:" + resultList.size());
	      for (Employee next : resultList) {
	        System.out.println("next Employee: " + next);
	      }
		
	    } catch (Exception e) {
	        System.out.println(e);
	        //transaction.rollback();
	      } finally {
	        entityManager.close();
	        emf.close();
	      }
		
		
		
	}

}
