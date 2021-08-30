/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trackme.business;

/**
 *
 * @author L. Andrew Overholt
 */
public class ExerciseType {

    // PROPERTIES
    private int id;
    private String type;
    
    
    // CONSTRUCTORS
    public ExerciseType(int id, String type) {
        this.id = id;
        this.type = type;
    }
    
    
    // GETTERS
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    
    
    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    // METHODS  

    

    

    

    
    
    
    
}
