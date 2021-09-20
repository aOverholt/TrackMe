package trackme.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trackme.business.ExerciseType;

/**
 * @author L. Andrew Overholt
 */
public class ExerciseTypeDB implements DAO<ExerciseType> {
    
    private Connection getConnection() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/trackme?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String password = "sesame";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        return connection;
    }

    @Override
    public ExerciseType get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * <h2>When is it called?</h2>
     * When you want to get a list of all the exercise types in the database
     * <br><br>
     * <h2>What does it do?</h2>
     * @return a list of all the exercise types in the database
     */
    @Override
    public ArrayList<ExerciseType> getAll() {
        String sql = "SELECT TypeID, ExerciseType "
                   + "FROM ExerciseTypes ORDER BY TypeID ASC";
        ArrayList<ExerciseType> types = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int typeID = rs.getInt("TypeID");
                String exerciseType = rs.getString("ExerciseType");

                ExerciseType t = new ExerciseType(typeID, exerciseType);
                types.add(t);
            }
            return types;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public boolean update(ExerciseType t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ExerciseType t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
