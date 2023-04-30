import java.util.Scanner;

public class CalendarProgram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scan.nextInt();

        System.out.print("Enter day (1-31): ");
        int day = scan.nextInt();

        System.out.print("Enter year (2000-2025): ");
        int year = scan.nextInt();

        if (month < 1 || month > 12) {
            invalidDate(scan);
            return;
        } else if (day < 1 || day > 31) {
            invalidDate(scan);
            return;
        } else if (year < 2000 || year > 2025) {
            invalidDate(scan);
            return;
        }

        String holidayName = getPhilippineHolidayName(month, day, year);

        if (holidayName != null) {
            System.out.println("It's a Philippine National Holiday: " + holidayName);
        } else {
            System.out.println("It's a Regular Day.");
        }

        scan.close();
    }

    public static String getPhilippineHolidayName(int month, int day, int year) {
        // Multi-dimensional array consisting of the holidays in the Philippines
        // according to rappler.com.
        // Each holiday array follows the following format: { "Name of Holiday", "Month
        // by Number", "Day by Number" }
        String[][] holidays = {
                { "New Year's Day", "1", "1" },
                { "Valentine's Day", "2", "14" },
                { "EDSA People Power Revolution Anniversary", "2", "25" },
                { "Maundy Thursday", "4", "6" },
                { "Good Friday", "4", "7" },
                { "Black Saturday", "4", "8" },
                { "Araw ng Kagitingan", "4", "9" },
                { "Eid'l Fitr", "4", "21" },
                { "Labor Day", "5", "1" },
                { "Independence Day", "6", "12" },
                { "National Heroes Day", "8", "28" },
                { "Ninoy Aquino Day", "8", "21" },
                { "Bonifacio Day", "11", "30" },
                { "All Saints' Day", "11", "1" },
                { "All Souls' Day", "11", "2" },
                { "Feast of the Immaculate Conception of Mary", "12", "8" },
                { "Christmas Day", "12", "25" },
                { "Rizal Day", "12", "30" },
        };

        // Loops through each holiday and checks if user input is equal to any
        // Philippine Holiday.
        for (String[] holiday : holidays) {
            if (month == Integer.parseInt(holiday[1]) && day == Integer.parseInt(holiday[2])) {
                return holiday[0];
            }
        }

        return null;
    }

    public static void invalidDate(Scanner scan) {
        System.out.println("Invalid date!");
        scan.close();
    }
}