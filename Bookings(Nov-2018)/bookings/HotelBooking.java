package bookings;
import java.util.Date;

/**
 * A HotelBooking is a LocationBooking with a fixed total price, a number of
 * booked single rooms, and a number of booked double rooms. It is assumed that
 * a double room is for two persons and a single room is for one. A Hotel
 * Booking must be made at least for one person. HotelBooking provides a name, a
 * date, a location and the number of persons for which the booking was made. It
 * also provides a booking's total price in pence and in pounds.
 *
 * @author Nuchem Katz
 */
public class HotelBooking extends LocationBooking implements HasFixedPrice {
  /**
   * The number of singel rooms for which a hotle booking was made must not be
   * less than 0
   */
  private int singleRooms;
  /**
   * The number of double rooms for which a hotle booking was made must not be
   * less than 0
   */
  private int doubleRooms;
  /* The total price in pence of a hotel booking */
  private int totalPriceInPence;

  private int numberOfPersons;
  /**
   * Constructs a new HotelBooking according to the parameters. Note that at least
   * one room must be booked. Constructer also sets numberOfPersons variable kept
   * in its immediate superclass LocationBooking to value computed from formal
   * parameters doubleRooms and getSingleRooms, since all subclasses of
   * LocationBooking will have to implement method getNumberOfPersons() anyway,
   * becasue of it being defined in root, abstract superclass Booking.
   *
   * @param name              the name for which the booking was made; ends up
   *                          passed in to constructer of class Booking who
   *                          ensures it's not null.
   * @param date              the point in time for which the booking was made;
   *                          mends up passed in to constructer of class Booking
   *                          who ensures it's not null and not in the past
   * @param location          the name of the Hotel; is passed to constructer of
   *                          LocationBooking who ensures it's not null
   * @param totalPriceInPence the total price in pence for the booking, can't be
   *                          null.
   * @param singleRooms       the number of single rooms booked, must be at least
   *                          0
   * @param doubleRooms       the number of double rooms booked, must be at least
   *                          0. The last two parameters cannot both be 0.
   */
  public HotelBooking(String name, Date date, String location, int totalPriceInPence, int singleRooms,
      int doubleRooms) {
    super(name, date, location);
    if (singleRooms <= 0 && doubleRooms <= 0) {
      throw new IllegalArgumentException("A booking for at least one person has to be made");
    }

    this.singleRooms = singleRooms;
    this.doubleRooms = doubleRooms;
    this.numberOfPersons = (singleRooms + (doubleRooms * 2));
    this.totalPriceInPence = totalPriceInPence;

  }

  /**
   * @return singleRooms the number of single rooms booked
   */
  public int getSingleRooms() {
    return this.singleRooms;
  }

  /**
   * @return the doubleRooms the number of double rooms booked
   */
  public int getDoubleRooms() {
    return this.doubleRooms;
  }

  @Override
  public int getFixedPriceInPence() {
    return this.totalPriceInPence;
  }

  @Override
  public String toString() {
    return super.toString() + "\nLocation: " + this.getLocation() + "\nPrice: " + this.getFormattedPrice()
        + "\nSingle rooms: " + this.getSingleRooms() + "\nDouble rooms: " + this.getDoubleRooms();
  }

  @Override
  public int getNumberOfPersons() {
    return numberOfPersons;
  }
}