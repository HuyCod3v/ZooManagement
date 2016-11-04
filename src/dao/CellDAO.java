package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cell;
import model.CellStatus;
import model.Region;
import model.Species;
import utilities.DatabaseConnection;

public class CellDAO extends AbstractDAO {

	// get all cell in database
	public ArrayList<Cell> getAll() {
		ArrayList<Cell> cellList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;

		try {

			connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM Cell c JOIN CellStatus cs ON c.CellStatusID = cs.CellStatusID"
					+ " JOIN Region r ON c.RegionID LIKE r.RegionID "
					+ " JOIN Species sp ON c.SpeciesID LIKE sp.SpeciesID ";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Cell cell = new Cell(resultSet.getString("CellID"), resultSet.getString("CellName"),
						resultSet.getString("RegionID"), resultSet.getString("SpeciesID"), resultSet.getInt("Capacity"),
						resultSet.getInt("CellStatusID"), resultSet.getString("Description"));

				CellStatus cellStatus = new CellStatus(resultSet.getInt("CellStatusID"),
						resultSet.getString("CellStatusName"));

				Region region = new Region(resultSet.getString("regionID"), resultSet.getString("regionName"),
						resultSet.getInt("regionStatusID"), resultSet.getLong("regionArea"),
						resultSet.getString("description"));

				Species species = new Species(resultSet.getString("speciesID"), resultSet.getString("speciesName"),
						resultSet.getString("description"));

				cell.setRegion(region);
				cell.setSpecies(species);
				cell.setCellStatus(cellStatus);

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

	// get list cell by region
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
				cellList.add(new Cell(resultSet.getString("CellID"), resultSet.getString("CellName"),
						resultSet.getString("RegionID"), resultSet.getString("SpeciesID"), resultSet.getInt("Capacity"),
						resultSet.getInt("CellStatusID"), resultSet.getString("Description")));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
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

	// create new cell
	public boolean addCell(Cell cell) {
		boolean result = false;
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			connection = DatabaseConnection.getConnection();
			String sql = "INSERT INTO Cell VALUES(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cell.getCellID());
			preparedStatement.setString(2, cell.getCellName());
			preparedStatement.setString(3, cell.getRegionID());
			preparedStatement.setString(4, cell.getSpeciesID());
			preparedStatement.setInt(5, cell.getCapacity());
			preparedStatement.setInt(6, cell.getCellStatusID());
			preparedStatement.setString(7, cell.getDescription());
			preparedStatement.executeUpdate();
			result = true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception ex) {
				System.out.println("In finally scope: " + ex.getMessage());
			}
		}

		return result;
	}

	/*
	 * //check cell is existed public boolean checkExistCellID(String cellID){
	 * 
	 * boolean check = false; Connection connection = null; PreparedStatement
	 * preparedStatement = null; ResultSet resultSet = null;
	 * 
	 * try { connection = DatabaseConnection.getConnection(); String sql =
	 * "SELECT * FROM Cell where CellID = ?"; preparedStatement =
	 * connection.prepareStatement(sql); preparedStatement.setString(1, cellID);
	 * resultSet = preparedStatement.executeQuery(); if(resultSet.next()){ check
	 * = true; } } catch (SQLException ex) {
	 * System.out.println(ex.getMessage()); } finally { try { resultSet.close();
	 * preparedStatement.close(); connection.close(); } catch (Exception ex) {
	 * System.out.println("In finally scope: " + ex.getMessage()); } }
	 * 
	 * return check;
	 * 
	 * }
	 */
	// delete cell
	public boolean deleteCell(String cellID) {

		boolean check = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DatabaseConnection.getConnection();
			String sql = "DELETE FROM Cell where CellID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cellID);
			preparedStatement.executeUpdate();
			check = true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception ex) {
				System.out.println("In finally scope: " + ex.getMessage());
			}
		}

		return check;

	}

	// get Cell by ID
	// check cell is existed
	public Cell getCellByID(String cellID) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Cell cell = null;

		try {
			connection = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM Cell where CellID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cellID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				cell = new Cell(resultSet.getString("CellID"), resultSet.getString("CellName"),
						resultSet.getString("RegionID"), resultSet.getString("SpeciesID"), resultSet.getInt("Capacity"),
						resultSet.getInt("CellStatusID"), resultSet.getString("Description"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception ex) {
				System.out.println("In finally scope: " + ex.getMessage());
			}
		}

		return cell;

	}
	
	public boolean updateCell(Cell cell) {

		boolean result = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DatabaseConnection.getConnection();
			String sql = "UPDATE Cell SET CellName = ?, RegionID = ?, SpeciesID = ?, Capacity = ?, "
					+ "CellStatusID = ?, Description = ? WHERE CellID = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,cell.getCellName() );
			preparedStatement.setString(2,cell.getRegionID());
			preparedStatement.setString(3,cell.getSpeciesID() );
			preparedStatement.setInt(4,cell.getCapacity() );
			preparedStatement.setInt(5,cell.getCellStatusID());
			preparedStatement.setString(6,cell.getDescription() );
			preparedStatement.setString(7,cell.getCellID() );
			preparedStatement.executeUpdate();
			result = true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception ex) {
				System.out.println("In finally scope: " + ex.getMessage());
			}
		}

		return result;

	}
}
