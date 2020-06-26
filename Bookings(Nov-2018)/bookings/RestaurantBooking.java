package bookings;
import java.util.Date;

/**
 * A RestaurantBooking is a booking at a specific location for a given number of
 * persons. A RestaurantBooking provides a name, a date, a location and the
 * number of persons for which the booking was made.
 * 
 * @author Nuchem Katz
 */
public class RestaurantBooking extends LocationBooking {
  private int numberOfPersons;

  /**
   * Constructs a new RestaurantBooking according to the parameters.
   *
   * @param name            the name for which the booking was made; ends up
   *                        passed in to constructer of class Booking who ensures
   *                        it's not null.
   * @param date            the point in time for which the booking was made; ends
   *                        up passed in to constructer of class Booking who
   *                        ensures it's not null and not in the past.
   * 
   * @param location        the name of the restaurant; is passed to constructer
   *                        of LocationBooking who ensures it's not null.
   * @param numberOfPersons the number of persons for whom the booking is made; at
   *                        least 1. Sets instance variable kept in its immediate
   *                        superclass LocationBooking to value of formal param
   *                        numberOfPersons, since all subclasses of
   *                        LocationBooking will have to implement method
   *                        getNumberOfPersons() anyway, becasue of it being
   *                        defined in root, abstract superclass Booking.
   */
  public RestaurantBooking(String name, Date date, String location, int numberOfPersons) {
    super(name, date, location);
    if (numberOfPersons < 1) {
      throw new IllegalArgumentException("numberOfPersons must be atleast 1!");
    }
    this.numberOfPersons = numberOfPersons;
  }

  @Override
  public String toString() {
    return super.toString() + "\nLocation: " + this.getLocation();
  }



  @Override
  public int getNumberOfPersons() {
    return numberOfPersons;
  }

}

