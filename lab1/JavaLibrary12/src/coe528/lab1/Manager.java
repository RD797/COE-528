
package coe528.lab1;

import java.util.NoSuchElementException;



public class Manager {
    private Flight[] flights;
    private Ticket[] tickets = new Ticket [100];
    
    public void createFlights(){
        flights = new Flight[4];
        flights[0] = new Flight(1, "Toronto", "Denver", "02/27/24 7:50 pm",20,1000.0);
        flights[1] = new Flight(2, "London", "Rio", "07/13/23 3:25 pm",60,700.0);
        flights[2] = new Flight(3, "Toronto", "Germany", "04/11/24 10:50 am",2,2000.0);
    }
    
    // This method is responsible for displaying available flights based on the given origin and destination.
    public void displayAvailableFlights(String origin, String destination){
        // Print a message indicating the origin and destination for which flights are being displayed.
        System.out.println("Flights from " + origin + " to " + destination + " are:");
         // Iterate through the list of flights
        for (Flight flight : flights) {
              // Check if the current element in the flights array is not null
            if (flight != null) {
                // Check if the origin and destination of the current flight match the provided parameters
                if (flight.getOrigin().equals(origin)  && flight.getDestination().equals(destination)) {
                    // If there is a match, print the details of the current flight using its toString() method
                    System.out.println(flight.toString());
                }
            }                
        }
    }
    
    public Flight getFlight(int flightNumber){
        // Iterate through the array of flights using a for loop.
       for(int i = 0; i < flights.length; i++) {
        // Check if the flightNumber of the current Flight object matches the provided flightNumber.
        if (flights[i].getFlightNumber() == flightNumber) {
            // If a match is found, return the corresponding Flight object.
            return flights[i];
        }
    }
                throw new NoSuchElementException("The requested flight does not exist.");
        }
      
    
    public void bookSeat(int flightNumber, Passenger p){
        // Iterate through the list of available flights
        for (Flight flight : flights) {
            
            if (flight != null && flight.getFlightNumber() == flightNumber) {
                // Check if the current flight is not null and matches the provided flight number
                if (flight.getNumberOfSeatsLeft() > 0) {
                    // Check if there are available seats on the selected flight
                    //Create a new Ticket object with the passenger, flight, and discounted price
                    Ticket ticket = new Ticket(p, flight, p.applyDiscount(flight.getOriginalPrice()));
                    flight.bookASeat();
                    // Store the created ticket in the tickets array
                    tickets[Ticket.getNumber()] =  ticket;
                    System.out.println("Ticket booked");
                    System.out.println(ticket.toString());
                }else{
                    System.out.println("Seats on Flight#:" + flightNumber + " are full");
                }
                
            }
        }
    }
    
    public static void main(String[] args ){
        Manager manager = new Manager();
        // create three flights
        manager.createFlights();
        // test Manger functions
        manager.displayAvailableFlights("Toronto", "Germany");
        System.out.println("\n");
        System.out.println(manager.getFlight(2));
        
        
        System.out.println("\n");
        
        // Passengers 
        Member Percy = new Member ( "Percy Jackson", 42, 7);
        manager.bookSeat(1,Percy);
        
        System.out.println("\n");
        
        Member Harry = new Member ( "Harry Potter",42,3);
        manager.bookSeat(2,Harry);
        
        System.out.println("\n");
        
        Member Riya = new Member ( "Riya Dave",22,9);
        manager.bookSeat(3,Riya);
        
        System.out.println("\n");
        
        NonMember Sirius = new NonMember ("Sirius Black", 70);
        manager.bookSeat(3,Sirius);
        
        System.out.println("\n");
        
        NonMember Annabeth = new NonMember ("Annabeth Chase", 40);
        manager.bookSeat(1,Annabeth);
        
        System.out.println("\n");
        
        NonMember Frodo = new NonMember ("Frodo Baggins", 22);
        manager.bookSeat(3,Frodo);
        
       
        
    }
    
}


