package trackme.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trackme.business.Exercise;
import trackme.business.WorkoutSession;

/**
 *
 * @author L. Andrew Overholt
 */
public class WorkoutSessionDB implements DAO<WorkoutSession> {
    
    private Connection getConnection() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/trackme?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String password = "sesame";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        return connection;
    }

    
    @Override
    public WorkoutSession get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<WorkoutSession> getAll() {
        String sql = "SELECT SessionID, Date, ExerciseID, Duration, BodyWeight, AverageHeartRate, Distance, Weight, Sets, Reps "
                   + "FROM WorkoutSessions ORDER BY SessionID ASC";
        ArrayList<WorkoutSession> sessions = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int sessionID = rs.getInt("SessionID");
                String date = rs.getString("Date");
                int exerciseID = rs.getInt("ExerciseID");
                String duration = rs.getString("Duration");
                int bodyWeight = rs.getInt("BodyWeight");
                int averageHeartRate = rs.getInt("AverageHeartRate");
                double distance = rs.getDouble("Distance");
                int weight = rs.getInt("Weight");
                int sets = rs.getInt("Sets");
                int reps = rs.getInt("Reps");

                WorkoutSession s = new WorkoutSession(sessionID, date, exerciseID, duration, bodyWeight, averageHeartRate, distance, weight, sets, reps);
                sessions.add(s);
            }
            return sessions;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * <h2>When is it called?</h2>
     * When you want to add a workout session to the database
     * <br><br>
     * <h2>What does it do?</h2>
     * Adds a workout session to the database
     */
    public boolean add(WorkoutSession s) {
        String sql = "INSERT INTO WorkoutSessions (Date, ExerciseID, Duration, BodyWeight, AverageHeartRate, Distance, Weight, Sets, Reps) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, s.getDate());
            ps.setInt(2, s.getExerciseID());
            ps.setString(3, s.getDuration());
            ps.setInt(4, s.getBodyWeight());
            ps.setInt(5, s.getAverageHeartRate());
            ps.setDouble(6, s.getDistance());
            ps.setInt(7, s.getWeight());
            ps.setInt(8, s.getSets());
            ps.setInt(9, s.getReps());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    /**
     * <h2>When is it called?</h2>
     * When you want to update a workout session in the database
     * <br><br>
     * <h2>What does it do?</h2>
     * Updates a workout session that's already in the database
     */
    @Override
    public boolean update(WorkoutSession s) {
        String sql = "UPDATE WorkoutSessions "
                   + "SET Date = ?, ExerciseID = ?, Duration = ? , BodyWeight = ? , AverageHeartRate = ? , Distance = ? , Weight = ? , Sets = ? , Reps = ?  "
                   + "WHERE SessionID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, s.getDate());
            ps.setInt(2, s.getExerciseID());
            ps.setString(3, s.getDuration());
            ps.setInt(4, s.getBodyWeight());
            ps.setInt(5, s.getAverageHeartRate());
            ps.setDouble(6, s.getDistance());
            ps.setInt(7, s.getWeight());
            ps.setInt(8, s.getSets());
            ps.setInt(9, s.getReps());
            ps.setInt(10, s.getSessionID());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    /**
     * <h2>When is it called?</h2>
     * When you want to delete a workout session from the database
     * <br><br>
     * <h2>What does it do?</h2>
     * Deletes a workout session that's already in the database
     */
    @Override
    public boolean delete(WorkoutSession s) {
        String sql = "DELETE FROM WorkoutSessions "
                   + "WHERE SessionID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, s.getSessionID());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }
    
}
