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
    private int typeID;
    private String typeName;
    
    
    // CONSTRUCTORS
    public ExerciseType(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }
    
    
    // GETTERS
    public int getTypeID() {
        return typeID;
    }

    public String getTypeName() {
        return typeName;
    }
    
    
    // SETTERS
    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    // METHODS  

    

    

    

    
    
    
    
}
