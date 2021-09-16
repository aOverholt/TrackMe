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

    
    public boolean add(WorkoutSession t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(WorkoutSession t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(WorkoutSession t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
