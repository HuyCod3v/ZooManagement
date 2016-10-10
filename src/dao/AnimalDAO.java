package dao;

import java.sql.Types;
import java.util.ArrayList;

import model.Animal;
import model.Cell;
import model.Region;
import model.Species;
import lib.ConnectDbLib;

public class AnimalDAO extends AbstractDAO {

    public AnimalDAO() {
        
    }

    public static boolean deleteAnimal(String animalID) {
        boolean ok = false;
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
            String sql = "DELETE FROM animal WHERE AnimalID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, animalID);
            ok = (preparedStatement.executeUpdate() == 1);

        } catch (Exception ex) {

        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {

            }
        }
        return ok;

    }

    public static boolean updateAnimal(Animal updatedAnimal) {
        boolean ok = false;
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
            String sql = "UPDATE animal SET AnimalName = ?, SpeciesID = ?, Gender = ?, Weight = ?, Height = ?, HealthStatus = ?, Description = ?, CellID = ? WHERE AnimalID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updatedAnimal.getAnimalName());
            preparedStatement.setString(2, updatedAnimal.getSpeciesID());
            preparedStatement.setInt(3, updatedAnimal.getGender());
            preparedStatement.setDouble(4, updatedAnimal.getWeight());
            preparedStatement.setDouble(5, updatedAnimal.getHeight());
            preparedStatement.setString(6, updatedAnimal.getHealthStatus());
            preparedStatement.setString(7, updatedAnimal.getDescription());
            preparedStatement.setString(8, updatedAnimal.getCellID());
            preparedStatement.setString(9, updatedAnimal.getAnimalID());
            ok = (preparedStatement.executeUpdate() == 1);
        } catch (Exception ex) {

        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {

            }
        }
        return ok;
    }

    public static ArrayList<Animal> getAllAnimals() {
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
            String sql = "SELECT * FROM animal an LEFT JOIN cell cl ON an.CellID = cl.CellID LEFT JOIN region rg ON cl.RegionID = rg.RegionID LEFT JOIN species sc ON an.SpeciesID = sc.SpeciesID";
            preparedStatement = connection.prepareStatement(sql);
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

    public static Animal getAnimalById(String id) {
        Animal animal = null;
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
            String sql = "SELECT * FROM animal an LEFT JOIN cell cl ON an.CellID = cl.CellID LEFT JOIN region rg ON cl.RegionID = rg.RegionID LEFT JOIN species sc ON an.SpeciesID = sc.SpeciesID WHERE an.AnimalID = ?";
            preparedStatement = connection.prepareStatement(sql);
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
    
    public static ArrayList<Animal> searchAnimalByRegion(String regionId) {
    	ArrayList<Animal> animalList = new ArrayList<Animal>();
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
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
    
    public static ArrayList<Animal> searchAnimalByCell(String cellId) {
    	ArrayList<Animal> animalList = new ArrayList<Animal>();
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
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

    public static ArrayList<Animal> searchAnimalById(String id) {
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
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

    public static boolean addNewAnimal(Animal newAnimal) {
        boolean ok = false;
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
            String sql = "INSERT INTO animal (AnimalID, AnimalName, SpeciesID, Gender, "
                                           + "Weight, Height, HealthStatus, Description, CellID) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

            ok = (preparedStatement.executeUpdate() == 1);
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
        return ok;
    }
    
    public static ArrayList<Animal> searchAnimalBySpecies(String speciesId) {
    	ArrayList<Animal> animalList = new ArrayList<Animal>();
        try {
            dbAccess = new ConnectDbLib();
            connection = dbAccess.getConnectMySQL();
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

}
