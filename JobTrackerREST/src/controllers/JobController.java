package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.JobDAO;
import entities.Job;

@RestController
public class JobController {
	
	@Autowired
	private JobDAO dao;
	
	@RequestMapping(path="ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path="jobs", method=RequestMethod.GET)
	public List<Job> index() {
		return dao.index();
	}
	
	@RequestMapping(path="jobs/{id}", method=RequestMethod.GET)
	public Job show(@PathVariable int id) {
		return dao.show(id);
	}
	
	@RequestMapping(path="jobs", method=RequestMethod.POST)
	public Job create(@RequestBody String jobJSON, HttpServletResponse res) {
		ObjectMapper om = new ObjectMapper();
		Job newJob = null;
		try {
			newJob = om.readValue(jobJSON, Job.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao.create(newJob);
		
	}
	
	@RequestMapping(path="jobs/{id}", method=RequestMethod.PUT)
	public Job update(@PathVariable int id,@RequestBody String jobJSON, HttpServletResponse res) {
		ObjectMapper om = new ObjectMapper();
		Job job = null;
		try {
			job = om.readValue(jobJSON, Job.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao.update(id, job);
	}
	
	@RequestMapping(path="jobs/{id}", method=RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id) {
		return dao.destroy(id);
	}

}
