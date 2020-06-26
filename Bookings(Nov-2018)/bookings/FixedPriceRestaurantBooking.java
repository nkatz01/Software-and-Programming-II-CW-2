package bookings;
import java.util.Date;

/**
 * A FixedPriceRestaurantBooking is a RestaurantBooking where a special menu for
 * the evening with a fixed price per person is ordered in advance. Thus, the
 * total price for all persons together is also fixed.
 * FixedPriceRestaurantBooking class provides a name, a date, a location and the
 * number of persons for which the booking was made. It also provides a
 * booking's total price in pence and in pounds.
 *
 * @author Nuchem Katz
 */
public class FixedPriceRestaurantBooking extends RestaurantBooking implements HasFixedPrice {
  /* The price per person in pence */
  private int pricePerPersonInPence;

  /**
   * Constructs a new FixedPriceRestaurantBooking according to the parameters.
   *
   * @param name                  the name for which the booking was made; ends up
   *                              passed in to constructer of class Booking who
   *                              ensures it's not null.
   * @param date                  the point in time for which the booking was
   *                              made; ends up passed in to constructer of class
   *                              Booking who ensures it's not null and not in the
   *                              past.
   * 
   * @param location              the name of the restaurant; ends up passed in to
   *                              constructer of class LocationBooking who ensures
   *                              it's not null.
   * @param numberOfPersons       the number of persons for whom the booking is
   *                              made; at least 1. Sets instance variable kept,
   *                              two calsses up, in abstract superclass
   *                              LocationBooking to value of formal param
   *                              numberOfPersons, since all subclasses of
   *                              LocationBooking will have to implement method
   *                              getNumberOfPersons() anyway, becasue of it being
   *                              defined in root, abstract superclass Booking.
   * @param pricePerPersonInPence the price per person in pence.
   */

  public FixedPriceRestaurantBooking(String name, Date date, String location, int numberOfPersons,
      int pricePerPersonInPence) {
    super(name, date, location, numberOfPersons);
    this.pricePerPersonInPence = pricePerPersonInPence;
  }

  @Override
  public int getFixedPriceInPence() {
    return this.pricePerPersonInPence * getNumberOfPersons();
  }

  @Override
  public String toString() {
    return super.toString() + "\nPrice: " + this.getFormattedPrice();
  }
}