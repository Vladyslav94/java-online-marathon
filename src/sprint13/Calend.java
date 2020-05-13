package sprint13;

import java.io.*;
import java.nio.charset.StandardCharsets;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calend {
    public static void main(String[] args) {
        System.out.println(lastDayOfMonth(Calendar.MARCH,1995));

    }

    public static Calendar convertDateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static String lastDayOfMonth(int month, int year) {
        if (month < 0 || month > 12)
            return "Wrong Month";

        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.clear();
        gregorianCalendar.set(Calendar.MONTH, month);
        gregorianCalendar.set(Calendar.YEAR, year);
        int dayOfWeekMonth = gregorianCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, dayOfWeekMonth);


        int dayOfWeek = gregorianCalendar.get(Calendar.DAY_OF_WEEK);

        String dayOfWeekName = "";
        switch (dayOfWeek) {
            case 2:
                dayOfWeekName = "Monday";
                break;
            case 3:
                dayOfWeekName = "Tuesday";
                break;
            case 4:
                dayOfWeekName = "Wednesday";
                break;
            case 5:
                dayOfWeekName = "Thursday";
                break;
            case 6:
                dayOfWeekName = "Friday";
                break;
            case 7:
                dayOfWeekName = "Saturday";
                break;
            case 1:
                dayOfWeekName = "Sunday";
                break;
        }

        return dayOfWeekName;
    }

    public static boolean isLeapYear(int year) {
        LocalDate date = LocalDate.of(year, 2, 23);
        return date.isLeapYear();
    }

    public static String getDateAfterToday(int years, int months, int days) {
        LocalDate localDate = LocalDate.now();


        localDate = localDate.plusYears(years);
        localDate = localDate.plusMonths(months);
        localDate = localDate.plusDays(days);


        return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String readFiles(String filename) {
        byte[] encoded = new byte[0];
        try {
            encoded = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(encoded);

    }

    public static void writeFile(String filename, String text) {
        PrintWriter fileOutputStream = null;
        try {
            fileOutputStream = new PrintWriter(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] bytes = text.getBytes();
        StringBuilder binary = new StringBuilder();
        for (int j = 0; j < bytes.length; j++) {
            int val = bytes[j];
            for (int i = 0; i < 7; i++) {
                val <<= 1;
                binary.append((val & 128) == 0 ? 0 : 1);
            }
        }

        fileOutputStream.println(binary.toString());
        fileOutputStream.close();


    }

    public static String readFile(String filename) {
        byte[] encoded = new byte[0];
        try {
            encoded = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String letters = new String(encoded);
        StringBuilder s = new StringBuilder();
        for (int index = 0; index < letters.trim().length(); index += 7) {
            String temp = letters.substring(index, index + 7);
            int num = Integer.parseInt(temp, 2);
            char letter = (char) num;
            s.append(letter);
        }

        return s.toString();
    }
}
