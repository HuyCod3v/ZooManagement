package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.LinkJobEmployee;
import model.User;
import utilities.DatabaseConnection;

public class LinkJobEmployeeDAO {
	public List<LinkJobEmployee> listAllJob(){
		List<LinkJobEmployee> list= new ArrayList<LinkJobEmployee>();
		PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
		try{
			con = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM Linkjobemployee l inner join Employee e on l.EmployeeID = e.EmployeeID"
					+ " inner join Job j on l.JobID = j.JobID";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				LinkJobEmployee link = new LinkJobEmployee();
				link.getEmployee().setEmployeeId(rs.getString("EmployeeID"));
				link.getEmployee().setEmployeeName(rs.getString("EmployeeName"));
				link.getJob().setJobName(rs.getString("JobName"));
				link.getJob().setJobId(rs.getString("JobID"));
				link.setStartTime(rs.getString("startTime"));
				link.setEndTime(rs.getString("endTime"));
				link.setDescription(rs.getString("Description"));
				link.setId(rs.getInt("ID"));
				list.add(link);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				con.close();
				pst.close();
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public boolean createLinkJob(LinkJobEmployee link) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO Linkjobemployee (JobID, EmployeeID, startTime, endTime,Description)"
                       + "VALUES (?, ?, ?, ?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, link.getJob().getJobId());
            preparedStatement.setString(2, link.getEmployee().getEmployeeId());
            preparedStatement.setString(3, link.getStartTime());
            preparedStatement.setString(4, link.getEndTime());
            preparedStatement.setString(5, link.getDescription());
            preparedStatement.executeUpdate();
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
        return true;
    }
	
	public boolean deleteLinkJob(String id) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "DELETE FROM LinkJobEmployee where ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
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
        return true;
    }
	
}
