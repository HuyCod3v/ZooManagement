package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import lib.ConnectDbLib;
import model.Cell;

public class CellDAO extends AbstractDAO {

    public CellDAO() {
    }

    public static ArrayList<Cell> getAllCells() {
        ArrayList<Cell> cellList = new ArrayList<>();
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
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
    
    public static ArrayList<Cell> getCellByRegion(String RegionID) {
        ArrayList<Cell> cellList = new ArrayList<>();
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
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
//    public static void main(String[] args) {
//        ArrayList<Cell> cellList = CellDAO.getAllCells();
//        for (Cell cell : cellList) {
//            System.out.println(cell.getCellID());
//        }
//    }
}
