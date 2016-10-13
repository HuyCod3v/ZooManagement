package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Region;
import utilities.DatabaseConnection;

public class RegionDAO extends AbstractDAO {

    public ArrayList<Region> getAll() {
        ArrayList<Region> regionList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        try {
         
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM region";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region(resultSet.getString("RegionID"),
                        resultSet.getString("RegionName"),
                        resultSet.getInt("RegionStatusID"),
                        resultSet.getDouble("RegionArea"),
                        resultSet.getString("Description"));
                regionList.add(region);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return regionList;
    }

    public Region find(String id) {

        Region region = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {          
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM region WHERE RegionID like ?";
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

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return region;

    }

}
