package tests;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Job;

public class JobTest {
	
	private EntityManagerFactory  emf = null;
	private EntityManager em = null;
	
	@Before
	public void setup() throws Exception {
		emf = Persistence.createEntityManagerFactory("JobTracker");
		em = emf.createEntityManager();
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	public void test() {
		boolean pass = true;
		assertEquals(pass,  true);
	}
	
	@Test
	public void testToSeeIfJobCompanyThere() {
		Job j = em.find(Job.class, 2);
		assertEquals(j.getCompany(), "Ratheon");
	}
	
	@Test
	public void testToSeeIfwebSiteExists() {
		Job j = em.find(Job.class, 2);
		assertEquals(j.getUrlJob(), "www.wewe.com");
	}

}
