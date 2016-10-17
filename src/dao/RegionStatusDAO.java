package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.RegionStatus;
import utilities.DatabaseConnection;

public class RegionStatusDAO extends AbstractDAO {

    public List<RegionStatus> getAll() {
        List<RegionStatus> regionStatusList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        try {        
            connection = DatabaseConnection.getConnection();
            String SQL = "SELECT * FROM [RegionStatus]";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                RegionStatus regionStatus = new RegionStatus(
                		resultSet.getInt("RegionStatusID"),
                        resultSet.getString("RegionStatusName")                  
                        );
                regionStatusList.add(regionStatus);
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
        
        return regionStatusList;
    }   
}
