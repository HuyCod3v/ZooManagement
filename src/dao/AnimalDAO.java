package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

import model.Animal;
import model.Cell;
import model.Species;
import utilities.DatabaseConnection;

public class AnimalDAO extends AbstractDAO {

    public boolean delete(String animalID) {
        boolean success = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        
        try {
            connection = DatabaseConnection.getConnection();
            String SQL = "DELETE FROM animal WHERE AnimalID = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, animalID);
            success = (preparedStatement.executeUpdate() == 1);
        } catch (Exception exception) {
        	exception.printStackTrace();
        } finally {
            try {
            	if (preparedStatement != null) {
            		preparedStatement.close();
            	}
                if (connection != null) {
                	connection.close();
                }            
            } catch (Exception exception) {
            	exception.printStackTrace();
            }
        }
        
        return success;
    }

    public boolean edit(Animal animal) {
    	boolean success = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        
        try {
        	connection = DatabaseConnection.getConnection();         
            
        	String SQL = "UPDATE animal SET AnimalName = ?, SpeciesID = ?, Gender = ?, Weight = ?, Height = ?, HealthStatus = ?, Description = ?, CellID = ? WHERE AnimalID = ?";
            
            preparedStatement = connection.prepareStatement(SQL);            
            preparedStatement.setString(1, animal.getAnimalName());
            preparedStatement.setString(2, animal.getSpeciesID());
            preparedStatement.setInt(3, animal.getGender());
            preparedStatement.setDouble(4, animal.getWeight());
            preparedStatement.setDouble(5, animal.getHeight());
            preparedStatement.setString(6, animal.getHealthStatus());
            preparedStatement.setString(7, animal.getDescription());
            preparedStatement.setString(8, animal.getCellID());
            preparedStatement.setString(9, animal.getAnimalID());
            preparedStatement.executeUpdate();
            success = true;
        } catch (Exception exception) {
        	exception.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                	preparedStatement.close();
                }
                if (connection != null) {
                	connection.close();
                }                              
            } catch (Exception exception) {
            	exception.printStackTrace();
            }
        }
        
        return success;
    }

    public  ArrayList<Animal> getAll() {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Animal> animals = new ArrayList<Animal>();
        
        try {
        	connection = DatabaseConnection.getConnection(); 
            String SQL = "SELECT * FROM animal as an JOIN cell as cl ON an.CellID = cl.CellID JOIN Species as sp ON an.SpeciesID = sp.SpeciesID";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Animal animal = new Animal(resultSet.getString("AnimalID"),
                        resultSet.getString("AnimalName"),
                        resultSet.getInt("Gender"),
                        resultSet.getDouble("Height"),
                        resultSet.getDouble("Weight"),
                        resultSet.getString("HealthStatus"),
                        resultSet.getString("Description"),
                        resultSet.getString("CellName"));
                
                Cell cell = new Cell(resultSet.getString("CellID"), resultSet.getString("CellName"));
                
                Species species = new Species(resultSet.getString("SpeciesID"),
                        resultSet.getString("SpeciesName"),
                        resultSet.getString("Description"));
                
                animal.setCell(cell);
                animal.setSpecies(species);
                animals.add(animal);
            }

        } catch (Exception exception) {
        	exception.printStackTrace();
        } finally {
            try {
            	if (resultSet != null) {
            		resultSet.close();
            	}
            	if (preparedStatement != null) {
            		preparedStatement.close();
            	}
                if (connection != null) {
                	connection.close();
                }                              
            } catch (Exception exception) {
            	exception.printStackTrace();
            }
        }

        return animals;
    }
    

    public Animal find(String id) {
        Animal animal = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        try {
            connection = DatabaseConnection.getConnection();
            String SQL = "SELECT * FROM animal an LEFT JOIN cell cl ON an.CellID = cl.CellID LEFT JOIN region rg ON cl.RegionID = rg.RegionID LEFT JOIN species sc ON an.SpeciesID = sc.SpeciesID WHERE an.AnimalID = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                animal = new Animal(resultSet.getString("AnimalID"),
                        resultSet.getString("AnimalName"),
                        resultSet.getString("SpeciesID"),
                        resultSet.getInt("Gender"),
                        resultSet.getDouble("Height"),
                        resultSet.getDouble("Weight"),
                        resultSet.getString("HealthStatus"),
                        resultSet.getString("Description"),
                        resultSet.getString("CellID"),
                        resultSet.getString("RegionName"),
                        resultSet.getString("RegionID"));
                Species species = new Species(resultSet.getString("SpeciesID"),
                        resultSet.getString("SpeciesName"),
                        resultSet.getString("Description"));
                animal.setSpecies(species);

            }
        } catch (Exception ex) {

        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {

            }
        }

        return animal;
    }
    
    public ArrayList<Animal> getByRegion(String regionId) {
    	ArrayList<Animal> animalList = new ArrayList<Animal>();
    	PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM animal an LEFT JOIN cell cl ON an.CellID = cl.CellID LEFT JOIN region rg ON cl.RegionID = rg.RegionID LEFT JOIN species sc ON an.SpeciesID = sc.SpeciesID WHERE cl.RegionID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, regionId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Animal animal = new Animal(resultSet.getString("AnimalID"),
                        resultSet.getString("AnimalName"),
                        resultSet.getString("SpeciesID"),
                        resultSet.getInt("Gender"),
                        resultSet.getDouble("Height"),
                        resultSet.getDouble("Weight"),
                        resultSet.getString("HealthStatus"),
                        resultSet.getString("Description"),
                        resultSet.getString("CellID"),
                        resultSet.getString("RegionName"),
                        resultSet.getString("RegionID"));
                		Species species = new Species(resultSet.getString("SpeciesID"),
                        resultSet.getString("SpeciesName"),
                        resultSet.getString("Description"));
                animal.setSpecies(species);
                animalList.add(animal);
            }

        } catch (Exception ex) {

        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {

            }
        }

        return animalList;
    }
    
    public ArrayList<Animal> getByCell(String cellId) {
    	ArrayList<Animal> animalList = new ArrayList<Animal>();
    	PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        try {        
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM animal an LEFT JOIN cell cl ON an.CellID = cl.CellID LEFT JOIN region rg ON cl.RegionID = rg.RegionID LEFT JOIN species sc ON an.SpeciesID = sc.SpeciesID WHERE an.CellID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cellId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Animal animal = new Animal(resultSet.getString("AnimalID"),
                        resultSet.getString("AnimalName"),
                        resultSet.getString("SpeciesID"),
                        resultSet.getInt("Gender"),
                        resultSet.getDouble("Height"),
                        resultSet.getDouble("Weight"),
                        resultSet.getString("HealthStatus"),
                        resultSet.getString("Description"),
                        resultSet.getString("CellID"),
                        resultSet.getString("RegionName"),
                        resultSet.getString("RegionID"));
                Species species = new Species(resultSet.getString("SpeciesID"),
                        resultSet.getString("SpeciesName"),
                        resultSet.getString("Description"));
                animal.setSpecies(species);
                animalList.add(animal);
            }

        } catch (Exception ex) {

        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {

            }
        }

        return animalList;
    }

    public ArrayList<Animal> getById(String id) {
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {         
        	connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM animal an LEFT JOIN cell cl ON an.CellID = cl.CellID LEFT JOIN region rg ON cl.RegionID = rg.RegionID LEFT JOIN species sc ON an.SpeciesID = sc.SpeciesID WHERE an.AnimalID LIKE ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + id + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Animal animal = new Animal(resultSet.getString("AnimalID"),
                        resultSet.getString("AnimalName"),
                        resultSet.getString("SpeciesID"),
                        resultSet.getInt("Gender"),
                        resultSet.getDouble("Height"),
                        resultSet.getDouble("Weight"),
                        resultSet.getString("HealthStatus"),
                        resultSet.getString("Description"),
                        resultSet.getString("CellID"),
                        resultSet.getString("RegionName"),
                        resultSet.getString("RegionID"));
                Species species = new Species(resultSet.getString("SpeciesID"),
                        resultSet.getString("SpeciesName"),
                        resultSet.getString("Description"));
                animal.setSpecies(species);
                animalList.add(animal);
            }

        } catch (Exception ex) {

        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {

            }
        }

        return animalList;
    }

    public boolean add(Animal newAnimal) {
        boolean ok = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO animal (AnimalID, AnimalName,SpeciesID, Gender, "
                                           + "Weight, Height, HealthStatus, Description, CellID) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, newAnimal.getAnimalID());
            preparedStatement.setString(2, newAnimal.getAnimalName());
            preparedStatement.setString(3, newAnimal.getSpeciesID());
            preparedStatement.setInt(4, newAnimal.getGender());
            
            if (newAnimal.getWeight() != 0.0)
                preparedStatement.setDouble(5, newAnimal.getWeight());
            else 
                preparedStatement.setNull(5, Types.DOUBLE);
            
            if (newAnimal.getHeight() != 0.0)
                preparedStatement.setDouble(6, newAnimal.getHeight());
            else 
                preparedStatement.setNull(6, Types.DOUBLE);
            
            preparedStatement.setString(7, newAnimal.getHealthStatus());
                                   
            if (null != newAnimal.getDescription()) 
                preparedStatement.setString(8, newAnimal.getDescription());
            else 
                preparedStatement.setNull(8, Types.VARCHAR);

            preparedStatement.setString(9, newAnimal.getCellID());

            preparedStatement.executeUpdate();
            ok = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return ok;
    }
    
    public ArrayList<Animal> getBySpecies(String speciesId) {
    	ArrayList<Animal> animalList = new ArrayList<Animal>();
    	PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {           
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM animal an LEFT JOIN cell cl ON an.CellID = cl.CellID LEFT JOIN region rg ON cl.RegionID = rg.RegionID LEFT JOIN species sc ON an.SpeciesID = sc.SpeciesID WHERE an.SpeciesID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, speciesId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Animal animal = new Animal(resultSet.getString("AnimalID"),
                        resultSet.getString("AnimalName"),
                        resultSet.getString("SpeciesID"),
                        resultSet.getInt("Gender"),
                        resultSet.getDouble("Height"),
                        resultSet.getDouble("Weight"),
                        resultSet.getString("HealthStatus"),
                        resultSet.getString("Description"),
                        resultSet.getString("CellID"),
                        resultSet.getString("RegionName"),
                        resultSet.getString("RegionID"));
                		Species species = new Species(resultSet.getString("SpeciesID"),
                        resultSet.getString("SpeciesName"),
                        resultSet.getString("Description"));
                animal.setSpecies(species);
                animalList.add(animal);
            }

        } catch (Exception ex) {

        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {

            }
        }

        return animalList;
    }

	public boolean checkExistAnimal(String animalID) {
		
		boolean check = false;
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM animal where AnimalID = ?";
		
		try{
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, animalID);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				check = true;
			}
			
		}catch(Exception e){
			
		} finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {

            }
		}
		
		return check;
	}

}
