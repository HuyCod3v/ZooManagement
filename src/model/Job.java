package model;

public class Job {
	private String jobId;
	private String description;
	private String jobName;
	public Job(){
		
	}
	public Job(String jobId, String description, String jobName) {
		super();
		this.jobId = jobId;
		this.description = description;
		this.jobName = jobName;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	
	
}
