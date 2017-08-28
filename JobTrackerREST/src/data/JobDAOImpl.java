package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Job;

@Transactional
public class JobDAOImpl implements JobDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Job> index() {
		String query = "SELECT j FROM Job j";
		return em.createQuery(query, Job.class).getResultList();
	}

	@Override
	public Job show(int id) {
		return em.find(Job.class, id);
	}

	@Override
	public Job create(String jobJSON) {
		ObjectMapper om = new ObjectMapper();
		Job newJob = null;
		try {
			newJob = om.readValue(jobJSON, Job.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		em.persist(newJob);
		em.flush();
		return em.find(Job.class, newJob.getId());
	}

	@Override
	public Job update(int id, String jobJSON) {
		Job j = em.find(Job.class, id);
		Job jNew = null;
		ObjectMapper om = new ObjectMapper();
		try {
			jNew = om.readValue(jobJSON, Job.class);
			j.setCompany(jNew.getCompany());
			j.setJobTitle(jNew.getJobTitle());
			j.setLocation(jNew.getLocation());
			j.setUrlJob(jNew.getUrlJob());
			return j;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean destroy(int id) {
		boolean removed;
		try {
			Job j = em.find(Job.class, id);
			em.remove(j);
			removed = true;
		} catch (Exception e) {
			e.printStackTrace();
			removed = false;
		}
		return removed;
	}

}
