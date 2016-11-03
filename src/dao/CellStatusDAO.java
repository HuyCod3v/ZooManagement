package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.CellStatus;
import utilities.DatabaseConnection;

public class CellStatusDAO extends AbstractDAO {

    public List<CellStatus> getAll() {
        List<CellStatus> cellStatusList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        try {        
            connection = DatabaseConnection.getConnection();
            String SQL = "SELECT * FROM [CellStatus]";
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                CellStatus cellStatus = new CellStatus(
                		resultSet.getInt("CellStatusID"),
                        resultSet.getString("CellStatusName")                  
                        );
                cellStatusList.add(cellStatus);
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
        
        return cellStatusList;
    }   
}
