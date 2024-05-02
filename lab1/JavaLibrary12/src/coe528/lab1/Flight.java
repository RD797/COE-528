
package coe528.lab1;


public class Flight {
    private int flightNumber, capacity, numberOfSeatsLeft;
    private String origin, destination, departureTime;
    private double originalPrice;
    
    /**
     * Creates a flight.
     * @param flightNumber The flight's number.
     * @param origin Where the flight is coming from.
     * @param destination Where the flight is going.
     * @param departureTime When the flight is leaving.
     * @param capacity How many seats there are on a plane.
     * @param originalPrice The original cost of a seat (without discounts).
     */
    public Flight (int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice) {
        if(origin.equals(destination))
            throw new IllegalArgumentException("The from and to locations cannot be the same."); //Throws an exception if the from and to locations are the same.
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.originalPrice = originalPrice;
        numberOfSeatsLeft = capacity;
    }
    
    /**
     * Returns the flight's number.
     *
     * @return flightNumber
     */
    public int getFlightNumber() {
        return flightNumber;
    }
    
    /**
     * Sets the flight's number.
     *
     * @param flightNumber
     */
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    /**
     * Returns the flight's capacity.
     *
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * Sets the flight's capacity.
     *
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    /**
     * Returns the number of seats left on the flight.
     *
     * @return numberOfSeatsLeft
     */
    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }
    
      
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    
    /**
     * Returns the origin of the flight.
     *
     * @return origin
     */
    public String getOrigin () {
        return origin;
    }
    
    /**
     * Sets the origin of the flight.
     *
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    /**
     * Returns the destination of the flight.
     *
     * @return destination
     */
    public String getDestination() {
        return destination;
    }
    
    /**
     * Sets the destination of the flight.
     *
     * @param destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    /**
     * Returns the departure time of the flight.
     *
     * @return departureTime
     */
    public String getDepartureTime() {
        return departureTime;
    }
    
    /**
     * Sets the departure time of the flight.
     *
     * @param departureTime
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    
    /**
     * Returns the original price of the flight.
     *
     * @return originalPrice
     */
    public double getOriginalPrice() {
        return originalPrice;
    }
    
    /**
     * Sets the original price of the flight.
     *
     * @param originalPrice
     */
    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    
    /**
     * If there are still seats left, the numberOfSeatsLeft is decreased by one and the boolean value of true is returned. Otherwise, false is returned.
     *
     * @return true or false
     */
    public boolean bookASeat() {
        if(numberOfSeatsLeft > 0) {
            numberOfSeatsLeft--;
            return true;
        }
        return false;
    }
    
    /**
     * Returns the String representation of the flight.
     *
     * @return s
     */
    public String toString() {
        String s;
        s = "Flight " + flightNumber + ", " + origin + " to " + destination + ", ";
        s +=  departureTime + ", original price: " + originalPrice + "$";
        return s;
    }
    
    
    
}