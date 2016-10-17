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
            String SQL = "SELECT * FROM [Region] r JOIN RegionStatus rs ON r.RegionStatusID = rs.RegionStatusID";
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
    
}
