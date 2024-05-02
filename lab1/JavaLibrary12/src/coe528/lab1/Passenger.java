
package coe528.lab1;

/**
 *
 * @author riyad
 */

public abstract class Passenger {
    private String name;
    private int age;
    
    /**
     * Creates a passenger.
     * @param name The name of the passenger.
     * @param age The age of the passenger.
     */
    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    /**
     * Returns the name of the passenger.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Sets the name of the passenger.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Returns the age of the passenger.
     *
     * @return age
     */
    public int getAge() {
        return this.age;
    }
    
    /**
     * Sets the age of the passenger.
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
    
   
    /**
     * Applies a discount to the given price.
     * @param p
     */
    public abstract double applyDiscount(double p);
}