package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Species;
import utilities.DatabaseConnection;

public class SpeciesDAO extends AbstractDAO {

	public List<Species> getAll() {
        List<Species> species = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        try {        
            connection = DatabaseConnection.getConnection();
            String SQL = "SELECT * FROM Species";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Species theSpecies = new Species(
                		resultSet.getString("SpeciesID"),
                        resultSet.getString("SpeciesName"),
                        resultSet.getString("Description")                    
                        );
                species.add(theSpecies);                                            
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
        
        return species;
    }

    public Species find(String id) {
        Species species = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        try {          
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM Species WHERE SpeciesID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                species = new Species(resultSet.getString("SpeciesID"),
                        resultSet.getString("SpeciesName"),
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
        
        return species;
    }
    
    public boolean add(Species species) {    
        PreparedStatement preparedStatement = null;
        Connection connection = null;      
        boolean success = false;
        try {          
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO Species(SpeciesID, SpeciesName, Description) VALUES"
            		+ " (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, species.getSpeciesID());
            preparedStatement.setString(2, species.getSpeciesName());
            preparedStatement.setString(3, species.getDescription());
            
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
    
    public boolean delete(String id) {
    	PreparedStatement preparedStatement = null;
        Connection connection = null;      
        boolean success = false;
        try {          
            connection = DatabaseConnection.getConnection();
            String sql = "DELETE FROM Species WHERE SpeciesID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);     
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
    
    public boolean edit(Species species) {    
        PreparedStatement preparedStatement = null;
        Connection connection = null;      
        boolean success = false;
        try {          
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE Species SET SpeciesName = ?, Description = ?"
            		+ " WHERE SpeciesID = ?";
            preparedStatement = connection.prepareStatement(sql);          
            preparedStatement.setString(1, species.getSpeciesName());
            preparedStatement.setString(2, species.getDescription());
            preparedStatement.setString(3, species.getSpeciesID());
            
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
