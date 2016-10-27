package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Region;
import model.RegionStatus;
import utilities.DatabaseConnection;

public class RegionDAO extends AbstractDAO {

    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        try {        
            connection = DatabaseConnection.getConnection();
            String SQL = "SELECT * FROM Region r JOIN RegionStatus rs ON r.RegionStatusID = rs.RegionStatusID";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Region region = new Region(
                		resultSet.getString("RegionID"),
                        resultSet.getString("RegionName"),
                        resultSet.getInt("RegionStatusID"),
                        resultSet.getDouble("RegionArea"),
                        resultSet.getString("Description")
                        );
                regions.add(region);
                
                RegionStatus regionStatus = new RegionStatus(
                		resultSet.getInt("RegionStatusID"),
                		resultSet.getString("RegionStatusName")
                		);
                
                region.setRegionStatus(regionStatus);
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        
        return regions;
    }

    public Region find(String id) {
        Region region = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        try {          
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM Region WHERE RegionID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                region = new Region(resultSet.getString("RegionID"),
                        resultSet.getString("RegionName"),
                        resultSet.getInt("RegionStatusID"),
                        resultSet.getDouble("RegionArea"),
                        resultSet.getString("Description"));
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        
        return region;
    }
    
    public boolean add(Region region) {    
        PreparedStatement preparedStatement = null;
        Connection connection = null;      
        boolean success = false;
        try {          
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO Region(RegionID, RegionName, RegionArea, RegionStatusID, Description) VALUES"
            		+ " (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, region.getRegionID());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.setDouble(3, region.getRegionArea());
            preparedStatement.setInt(4, region.getRegionStatusID());
            preparedStatement.setString(5, region.getDescription());
            
            success = preparedStatement.executeUpdate() > 0;

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
            
                preparedStatement.close();
                connection.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        
        return success;
    }
    
    public boolean delete(String regionID) {
    	PreparedStatement preparedStatement = null;
        Connection connection = null;      
        boolean success = false;
        try {          
            connection = DatabaseConnection.getConnection();
            String sql = "DELETE FROM Region WHERE RegionID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, regionID);     
            success = preparedStatement.executeUpdate() > 0;

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
            
                preparedStatement.close();
                connection.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        
        return success;
    }
    
    public boolean edit(Region region) {    
        PreparedStatement preparedStatement = null;
        Connection connection = null;      
        boolean success = false;
        try {          
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE Region SET RegionName = ?, RegionArea = ?, RegionStatusID = ?, Description = ?"
            		+ " WHERE RegionID = ?";
            preparedStatement = connection.prepareStatement(sql);          
            preparedStatement.setString(1, region.getRegionName());
            preparedStatement.setDouble(2, region.getRegionArea());
            preparedStatement.setInt(3, region.getRegionStatusID());
            preparedStatement.setString(4, region.getDescription());
            preparedStatement.setString(5, region.getRegionID());
            
            success = preparedStatement.executeUpdate() > 0;

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
            
                preparedStatement.close();
                connection.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        
        return success;
    }
    
    
}
