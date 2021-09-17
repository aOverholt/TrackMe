/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trackme.business;

import trackme.db.ExerciseDB;

/**
 *
 * @author L. Andrew Overholt
 */
public class WorkoutSession {

    // PROPERTIES
    private int sessionID;
    private String date;
    private int exerciseID;
    private String exerciseName;
    private String duration;
    private int bodyWeight;
    private int averageHeartRate;
    private double distance;
    private int weight;
    private int sets;
    private int reps;

    
    
    // CONSTRUCTORS
    public WorkoutSession(int sessionID, String date, int exerciseID,
                          String duration, int bodyWeight, int averageHeartRate,
                          double distance, int weight, int sets, int reps) {
        this.sessionID = sessionID;
        this.date = date;
        this.exerciseID = exerciseID;
        this.duration = duration;
        this.bodyWeight = bodyWeight;
        this.averageHeartRate = averageHeartRate;
        this.distance = distance;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
        
        ExerciseDB exerciseDB = new ExerciseDB();
        this.exerciseName = exerciseDB.getName(exerciseID);
    }
    
    
    
    
    // GETTERS
    public int getSessionID() {
        return sessionID;
    }
    public String getDate() {
        return date;
    }
    public int getExerciseID() {
        return exerciseID;
    }
    public String getExerciseName() {
        return exerciseName;
    }
    public String getDuration() {
        return duration;
    }
    public int getBodyWeight() {
        return bodyWeight;
    }
    public int getAverageHeartRate() {
        return averageHeartRate;
    }
    public double getDistance() {
        return distance;
    }
    public int getWeight() {
        return weight;
    }
    public int getSets() {
        return sets;
    }
    public int getReps() {
        return reps;
    }
    
    // SETTERS
    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }
    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void setBodyWeight(int bodyWeight) {
        this.bodyWeight = bodyWeight;
    }
    public void setAverageHeartRate(int averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setSets(int sets) {
        this.sets = sets;
    }
    public void setReps(int reps) {
        this.reps = reps;
    }
    
    
    
    // METHODS  

    

    

    

    

    
    
}
