package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Species;
import utilities.DatabaseConnection;

public class SpeciesDAO extends AbstractDAO {


    public ArrayList<Species> getAll() {
        ArrayList<Species> speciesList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {       
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM species";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Species species = new Species(resultSet.getString("SpeciesID"),
                        resultSet.getString("SpeciesName"),
                        resultSet.getString("Description"));
                speciesList.add(species);
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
        return speciesList;
    }
}
