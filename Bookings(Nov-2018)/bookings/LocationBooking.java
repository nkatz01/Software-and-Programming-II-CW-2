package bookings;
import java.util.Date;

/**
 * Abstract superclass for all bookings that are made for a fixed location. A
 * LocationBooking provides a location string for which th ebooking was made.
 *
 * @author Nuchem Katz
 */
public abstract class LocationBooking extends Booking {
  /**
   * The name of the location the booking was made for. non-null
   */
  private String location;
  /*
   * The number of persons for which a booking was made - protected so that its
   * immediate and their subclassess can access it directly
   */


  /**
   * @param name     for which the booking was made, is passed on to constructer
   *                 of class booking, who makes sure it's not null.
   * @param date     the point in time for which the booking was mad is passed on
   *                 to constructer of class booking, who makes sure it's not null
   *                 and not in the past.
   * @param location the loaction for which the booking was made, must not be
   *                 null.
   */
  public LocationBooking(String name, Date date, String location) {
    super(name, date);
    if (location == null) {
      throw new IllegalArgumentException("location must not be null!");
    }
    this.location = location;

  }

  /**
   * @return the location for which the booking was made, non null.
   */
  public String getLocation() {
    return location;
  }

  public abstract int getNumberOfPersons();

}