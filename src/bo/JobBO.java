package bo;

import java.util.ArrayList;

import dao.JobDAO;
import model.Job;

public class JobBO {
	public ArrayList<Job> getAllJob() {
		return new JobDAO().getAllJob();
	}
	public Job getJobById(String id) {
		return new JobDAO().getJobById(id);
	}
	
	public boolean creatJob(Job job) {
		return new JobDAO().creatJob(job);
	}
}
