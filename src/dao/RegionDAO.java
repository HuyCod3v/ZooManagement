package dao;

import java.util.ArrayList;

import lib.ConnectDbLib;
import model.Region;

public class RegionDAO extends AbstractDAO {

    public RegionDAO() {

    }

    public static ArrayList<Region> getAllRegions() {
        ArrayList<Region> regionList = new ArrayList<>();
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
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

    public static Region getRegionById(String id) {
        Region region = null;
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
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
