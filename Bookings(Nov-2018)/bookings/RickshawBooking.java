package bookings;
import java.util.Date;

/**
 * A RickshawBooking is a booking for travelling from a start point to a
 * destination point via a rickshaw taxi. In our setting, a rickshaw always
 * transports exactly one passenger.
 *
 * @author Nuchem Katz
 */
public class RickshawBooking extends Booking {
  /** The locatin from which the ride begins - non-null */
  private String from;
  /** The location to which booker wants to get to - non-null */
  private String to;

  /**
   * Constructs a RickshawBooking object according to the parameters.
   *
   * @param name the name for which the booking was made; is passed to superclass
   *             booking constructer who assures it's set to a value.
   * @param date the point in time for which the booking was made; is passed to
   *             superclass booking constructer who assures it's set to a value.
   * @param from the start point of the rickshaw travel; must not be null
   * @param to   the destination point of the rickshaw travel; must not be null
   */
  public RickshawBooking(String name, Date date, String from, String to) {
    super(name, date);
    if (from == null) {
      throw new IllegalArgumentException("from must not be null!");
    }
    if (to == null) {
      throw new IllegalArgumentException("to must not be null!");
    }

    this.from = from;
    this.to = to;
  }

  /** @return from the origin the Rickshaw booking was made for */
  public String getFrom() {
    return this.from;
  }

  /** @return to the destination the Rickshaw booking was made for */
  public String getTo() {
    return this.to;
  }

  @Override
  /** @return 1 , the number of people who've booked, never not equal to 1. */
  public int getNumberOfPersons() {
    return 1;
  }

  @Override
  public String toString() {
    return super.toString() + "\nFrom: " + this.getFrom() + "\nTo: " + this.getTo();
  }
}