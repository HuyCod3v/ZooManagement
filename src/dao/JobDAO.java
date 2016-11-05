package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Job;
import utilities.DatabaseConnection;

public class JobDAO {
	public ArrayList<Job> getAllJob() {
		ArrayList<Job> jobList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM Job";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Job job = new Job();
				job.setJobId(resultSet.getString(1));
				job.setDescription(resultSet.getString(2));
				job.setJobName(resultSet.getString(3));
				
				jobList.add(job);
			}
		} catch (Exception ex) {
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception ex) {
			}
		}
		return jobList;
	}
	
	public boolean creatJob(Job job) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO Job (JobID,JobDescription,JobName)"
                       + "VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, job.getJobId());
            preparedStatement.setString(2, job.getDescription());
            preparedStatement.setString(3, job.getJobName());
            return preparedStatement.executeUpdate()== 1 ? true : false;
        } catch (Exception ex) {
            return false;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
	
	public Job getJobById(String id) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Job job = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM Job where jobId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				job = new Job(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
			}
			
		} catch (Exception ex) {
			return null;
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception ex) {
			}
		}
		return job;
	}
}
