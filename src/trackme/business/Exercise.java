package trackme.business;

/**
 *
 * @author L. Andrew Overholt
 */
public class Exercise {

    // PROPERTIES
    private int exerciseID;
    private String name;
    private int typeID;
    private String typeName;

    
    
    // CONSTRUCTORS
    public Exercise(int exerciseID, String name, int typeID, String typeName) {
        this.exerciseID = exerciseID;
        this.name = name;
        this.typeID = typeID;
        this.typeName = typeName;
    }

    // GETTERS
    public int getExerciseID() {
        return exerciseID;
    }
    public String getName() {
        return name;
    }
    public int getTypeID() {
        return typeID;
    }
    public String getTypeName() {
        return typeName;
    }
    
    
    // SETTERS
    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
   
    
    // METHODS  

    
    
    
}
