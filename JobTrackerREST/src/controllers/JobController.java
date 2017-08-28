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
	public List<Job> index(HttpServletResponse res) {
		//res.addHeader("Access-Control-Allow-Origin", "*");
		return dao.index();
	}
	
	@RequestMapping(path="jobs/{id}", method=RequestMethod.GET)
	public Job show(@PathVariable int id) {
		return dao.show(id);
	}
	
	@RequestMapping(path="jobs", method=RequestMethod.POST)
	public Job create(@RequestBody String jobJSON, HttpServletResponse res) {
		//res.addHeader("Access-Control-Allow-Origin", "*");
		return dao.create(jobJSON);
		
	}
	
	@RequestMapping(path="jobs/{id}", method=RequestMethod.PUT)
	public Job update(@PathVariable int id,@RequestBody String jobJSON, HttpServletResponse res) {
		//res.addHeader("Access-Control-Allow-Origin", "*");
		return dao.update(id, jobJSON);
	}
	
	@RequestMapping(path="jobs/{id}", method=RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id) {
		return dao.destroy(id);
	}

}
