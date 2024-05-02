
package coe528.lab1;

/**
 *
 * @author riyad
 */
public class Member extends Passenger {
    private int yearsOfMembership;
    
    /**
     * Creates a member.
     * @param name The passenger's name.
     * @param age The passenger's age.
     * @param yearsOfMembership The number of years a passenger has been a member.
     */
    public Member(String name, int age, int yearsOfMembership) {
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    @Override
    /**
     * Applies a discount to given price depending on the number of years passenger has been a member.
     * @param p
     */
    public double applyDiscount (double p) {
        if(yearsOfMembership > 5)
            return (p - p*0.5);
        if(yearsOfMembership > 1)
            return (p - p*0.1);
        return p;          
    }
}