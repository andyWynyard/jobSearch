package data;

import java.util.List;

import entities.Job;

public interface JobDAO {
	
	public List<Job> index();
	public Job show(int id);
	public Job create(String jobJSON);
	public Job update(int id, String jobJSON);
	public boolean destroy(int id);

}
