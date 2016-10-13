package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cell;
import utilities.DatabaseConnection;

public class CellDAO extends AbstractDAO {

    public ArrayList<Cell> getAll() {
        ArrayList<Cell> cellList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        try {
           
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM cell";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cell cell = new Cell(resultSet.getString("CellID"),
                        resultSet.getString("CellName"),
                        resultSet.getString("RegionID"),
                        resultSet.getString("SpeciesID"),
                        resultSet.getInt("Capacity"),
                        resultSet.getInt("CellStatusID"),
                        resultSet.getString("Description"));
                cellList.add(cell);
            }
        } catch (Exception ex) {
            System.out.println("In catch scope: " + ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println("In finally scope: " + ex.getMessage());
            }
        }
        return cellList;
    }
    
    public ArrayList<Cell> getByRegion(String RegionID) {
        ArrayList<Cell> cellList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {       
            connection = DatabaseConnection.getConnection();
            String sql = "select * from cell where RegionID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, RegionID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cellList.add(new Cell(resultSet.getString("CellID"),
                        resultSet.getString("CellName"),
                        resultSet.getString("RegionID"),
                        resultSet.getString("SpeciesID"),
                        resultSet.getInt("Capacity"),
                        resultSet.getInt("CellStatusID"),
                        resultSet.getString("Description")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println("In finally scope: " + ex.getMessage());
            }
        }
        return cellList;
    }

}
