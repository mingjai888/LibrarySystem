import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * This class is for handling user fines.
 * 
 * @author Kyriacos Mosphilis
 *
 */
public class Fine {

	private final int BOOK_DVD_FINE = 2;
	private final int LAPTOP_FINE = 10;
	private final int MAX_BOOK_DVD_FINE = 25;
	private final int MAX_LAPTOP_FINE = 100;
	private int currentFine;
	private int daysOverdue;
	private static Scanner input1;
	private static Scanner input2;

	/**
	 * Constructor that create the current fine.
	 * 
	 * @param resource
	 *            The resource that has been overdue.
	 * @param currentDate
	 *            the date right now
	 * @param dueDate
	 *            date when the item should have been returned
	 */
	public Fine(Resource resource, Date dueDate, Date currentDate) {
		daysOverdue = findDays(dueDate, currentDate).getDays();
		if (daysOverdue > 0) {
			calculateFine(resource, daysOverdue);
		}
	}

	/**
	 * Method to calculate the fine.
	 * 
	 * @param resource
	 *            The resource that has been overdue.
	 * @param daysDelayed
	 *            Days overdue.
	 */
	private void calculateFine(Resource resource, int daysDelayed) {
		if ((resource instanceof Book) || (resource instanceof DVD)) {
			do {
				if (currentFine == 24) {
					currentFine += 1;
				} else {
					currentFine += BOOK_DVD_FINE;
				}
				daysDelayed--;
			} while ((daysDelayed != 0) && (currentFine != MAX_BOOK_DVD_FINE));
		} else {
			do {
				currentFine += LAPTOP_FINE;
				daysDelayed--;
			} while ((daysDelayed != 0) && (currentFine != MAX_LAPTOP_FINE));
		}
	}

	/**
	 * Getter method that returns the current fine.
	 * 
	 * @return The fine to be paid.
	 */
	public int getCurrentFine() {
		return currentFine;
	}

	public int getDaysOverdue() {
		return daysOverdue;
	}

	/**
	 * This method calculates how many days have passed between the due date of
	 * an object and the date and time now.
	 * 
	 * @param dueDate
	 *            Date when then the item was due
	 * @param currentDate
	 *            The date right now
	 * @return The number of days between the 2 dates
	 */
	public static Period findDays(Date dueDate, Date currentDate) {
		LocalDate dateDue = dueDate.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		LocalDate dateNow = currentDate.toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate();
		Period days = Period.between(dateDue, dateNow);
		return days;
	}

	/**
	 * This method calculate for how long has the user had the item for and uses
	 * it to set a due date.
	 * 
	 * @param copy
	 *            Item which the user has borrowed.
	 * @return The due date for the item.
	 */
	public static Date findDuration(Copy copy) {
		Date dateBorrowed = copy.getDateBorrowed();
		Date currentDate = Copy.getDateNow();
		Calendar c = Calendar.getInstance();
		c.setTime(dateBorrowed);
		int daysBorrowed = findDays(dateBorrowed, currentDate).getDays();
		int borrowedDay = c.get(Calendar.DAY_OF_WEEK);
		Calendar calendar = Calendar.getInstance();
		if (copy.getResource() instanceof Book) {
			if (daysBorrowed < copy.LOAN_DURATION_BOOK) {
				borrowedDay = copy.LOAN_DURATION_BOOK - borrowedDay + 1;
				calendar.add(Calendar.DAY_OF_YEAR, borrowedDay);
				return calendar.getTime();
			}
		} else if (copy.getResource() instanceof DVD) {
			if (daysBorrowed < copy.LOAN_DURATION_DVD) {
				borrowedDay = copy.LOAN_DURATION_DVD - borrowedDay + 1;
				calendar.add(Calendar.DAY_OF_YEAR, borrowedDay);
				return calendar.getTime();
			}
		} else {
			if (daysBorrowed < copy.LOAN_DURATION_LAPTOP) {
				borrowedDay = copy.LOAN_DURATION_LAPTOP - borrowedDay + 1;
				calendar.add(Calendar.DAY_OF_YEAR, borrowedDay);
				return calendar.getTime();
			}
		}

		return Copy.getDateTomorrow();
	}

}
