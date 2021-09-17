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

    /**
     * <h2>When is it called?</h2>
     * When you want to get the name of an exercise by using the exerciseID
     * <br><br>
     * <h2>What does it do?</h2>
     * Returns a string containing the Exercise Name
     */
    public String getName(int id) {
        String sql = "SELECT ExerciseName "
                   + "FROM Exercises "
                   + "WHERE ExerciseID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
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
    
    /**
     * <h2>When is it called?</h2>
     * When you want to get a list of all the exercises in the database
     * <br><br>
     * <h2>What does it do?</h2>
     * Gets a list of all the exercises in the database
     */
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

    
    /**
     * <h2>When is it called?</h2>
     * When you want to update an exercise in the database
     * <br><br>
     * <h2>What does it do?</h2>
     * Updates an exercise that's already in the database
     */
    @Override
    public boolean update(Exercise e) {
        String sql = "UPDATE Exercises SET ExerciseName = ?, TypeID = ? "
                   + "WHERE ExerciseID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, e.getName());
            ps.setInt(2, e.getTypeID());
            ps.setInt(3, e.getExerciseID());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * <h2>When is it called?</h2>
     * When you want to delete an exercise from the database
     * <br><br>
     * <h2>What does it do?</h2>
     * Deletes an exercise that's already in the database
     */
    @Override
    public boolean delete(Exercise e) {
        String sql = "DELETE FROM trackme.Exercises "
                   + "WHERE ExerciseID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, e.getExerciseID());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    
}
