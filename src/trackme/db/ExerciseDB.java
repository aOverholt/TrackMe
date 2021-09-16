package trackme.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import trackme.business.Exercise;

/**
 *
 * @author L. Andrew Overholt
 */
public class ExerciseDB implements DAO<Exercise>  {
    
    private Connection getConnection() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/trackme?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String password = "sesame";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        return connection;
    }

    
    // TODO: Is used to prevent the same exercise name from being added twice
    public boolean exists(String name) {
        return false;
    }
    
    // TODO: 
    @Override
    public Exercise get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String getName(String id) {
        String sql = "SELECT ExerciseName "
                   + "FROM Exercises "
                   + "WHERE ExerciseID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("ExerciseName");
                rs.close();
                return name;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
    
    
    // TODO: 
    @Override
    public ArrayList<Exercise> getAll() {
        String sql = "SELECT ExerciseID, ExerciseName, TypeID "
                   + "FROM Exercises ORDER BY TypeID ASC";
        ArrayList<Exercise> exercises = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int exerciseID = rs.getInt("ExerciseID");
                String exerciseName = rs.getString("ExerciseName");
                int typeID = rs.getInt("TypeID");

                Exercise e = new Exercise(exerciseID, exerciseName, typeID);
                exercises.add(e);
            }
            return exercises;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

   /**
     * <h2>When is it called?</h2>
     * When you want to add an exercise to the database
     * <br><br>
     * <h2>What does it do?</h2>
     * Adds an exercise to the database
     */
    public boolean add(String name, int type) {
        String sql = "INSERT INTO Exercises (ExerciseName, TypeID) "
                   + "VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, type);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    // TODO: 
    @Override
    public boolean update(Exercise e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // TODO: 
    @Override
    public boolean delete(Exercise e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Exercise t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
