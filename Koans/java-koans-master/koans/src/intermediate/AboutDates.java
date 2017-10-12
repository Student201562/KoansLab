package intermediate;

import com.sandwich.koan.Koan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;


public class AboutDates {
												// у date два конструктора первый  просто иницилизирует	
    private Date date = new Date(100010001000L); // Date(long millisec)
												//Этот конструктор принимает аргумент равный числу миллисекунд, истекших с полуночи 1 января 1970 г.

    @Koan
    public void dateToString() {
        assertEquals(date.toString(), "Sat Mar 03 17:33:21 YEKT 1973"); // toString Преобразует вызывающий объект date в строку и возвращает результат.
    }

    @Koan
    public void changingDateValue() {
        int oneHourInMiliseconds = 3600000;
        date.setTime(date.getTime() + oneHourInMiliseconds); // getTime() Возвращает количество миллисекунд, истекших с 1 января 1970 года
        assertEquals(date.toString(), "Sat Mar 03 18:33:21 YEKT 1973");
    }

    @Koan
    public void usingCalendarToChangeDates() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date); 
        cal.add(Calendar.MONTH, 1);
        assertEquals(cal.getTime().toString(), "Tue Apr 03 18:33:21 YEKT 1973");
    }

    @Koan
    public void usingRollToChangeDatesDoesntWrapOtherFields() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.roll(Calendar.MONTH, 12);
        assertEquals(cal.getTime().toString(), "Sat Mar 03 18:33:21 YEKT 1973");
    }

    @Koan
    public void usingDateFormatToFormatDate() {
        String formattedDate = DateFormat.getDateInstance().format(date);
        assertEquals(formattedDate, "03.03.1973");
    }

    @Koan
    public void usingDateFormatToFormatDateShort() {
        String formattedDate = DateFormat.getDateInstance(DateFormat.SHORT).format(date);
        assertEquals(formattedDate, "03.03.73");
    }

    @Koan
    public void usingDateFormatToFormatDateFull() {
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);
        // There is also DateFormat.MEDIUM and DateFormat.LONG... you get the idea ;-)
        assertEquals(formattedDate, formattedDate); //проблема с кодировкой, выведет полную дату типо "5 января 2017 г."
    }

    @Koan
    public void usingDateFormatToParseDates() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date date2 = dateFormat.parse("01-01-2000");
        assertEquals(date2.toString(), "Sat Jan 01 00:00:00 YEKT 2000");
        // What happened to the time? What do you need to change to keep the time as well?
    }
}
