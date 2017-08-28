package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/****************************************************
 * Entity designed to map job table in job_search_db
 * @author andrewwynyard
 ****************************************************/

@Entity
@Table(name="job")
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="job_title")
	private String jobTitle;
	
	private String company;
	
	private String location;
	
	@Column(name="url_job")
	private String urlJob;
	
	// GETTERS AND SETTERS

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrlJob() {
		return urlJob;
	}

	public void setUrlJob(String urlJob) {
		this.urlJob = urlJob;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobTitle=" + jobTitle + ", company=" + company + ", location=" + location
				+ ", urlJob=" + urlJob + "]";
	}
	
	
	


}
