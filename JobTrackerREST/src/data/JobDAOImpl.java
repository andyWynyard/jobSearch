package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

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
	public Job create(Job job) {
		em.persist(job);
		em.flush();
		return em.find(Job.class, job.getId());
	}

	@Override
	public Job update(int id, Job job) {
		Job j = em.find(Job.class, id);
		j.setCompany(job.getCompany());
		j.setJobTitle(job.getJobTitle());
		j.setLocation(job.getLocation());
		j.setUrlJob(job.getUrlJob());
		return j;
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
