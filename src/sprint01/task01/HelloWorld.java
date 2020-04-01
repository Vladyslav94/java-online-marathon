package sprint01.task01;

///The main mode is having a method named main inside a class and should return
// nothing but should print a line to the standard output with the message Hello World!
// i.e. print the line Hello World! to the console.
// The main method should receive String array as parameters that can be specified when running from console with the command.
// In Java program can be only one main method for a whole application since it denotes the application entry point.
public class HelloWorld {
    public static void main(String[] args) {
        System.out.print("Hello World!");
    }

    //    Code as fast as you can! You need to double the number and return it.
    public static float doubleNumber(double number) {
        return (float) number * 2;
    }

    //    Write a method that takes a year as input, and returns the century it is in.
//    The first century spans from the year 1 up to and including the year 100,
//    The second century spans from the year 101 up to and including the year 200, etc.
    public static int century(int year) {
        if (year % 100 == 0)
            return year / 100;
        return year / 100 + 1;
    }

//    Write a method to compute the sum of the digits in a three-digits positive integer number.
    public static int sumOfDigits(int number) {
        int count = 0;
        while (number > 0) {
            count += number % 10;
            number = number / 10;
        }
        return count;
    }

    //    Write a method to check if a year is a leap year or not, using only Relational and Logical operators.
//    If a year is leap then method should return true, otherwise - false.
//    Every year that is exactly divisible by 4 is a leap year, except for
//    years that are exactly divisible by 100, but these centurial years are leap years if they are exactly divisible by 400.
    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}

