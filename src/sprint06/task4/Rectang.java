package sprint06.task4;

import java.util.*;

public class Rectang implements Shape{
    private double height;
    private double width;

    public Rectang(double height, double width){
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }


    @Override
    public double getPerimeter() {
        return (height+width)*2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectang rectang = (Rectang) o;
        return Double.compare(rectang.height, height) == 0 &&
                Double.compare(rectang.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }


    public static void main(String[] args) {
        List<Shape> squares = new ArrayList<>();
        squares.add(new Square(4.00));
        squares.add(new Square(5.00));
        squares.add(new Rectang(2.00, 3.00));
        MyUtils myUtils = new MyUtils();


        System.out.println(myUtils.sumPerimeter(squares));
    }
}

class MyUtils {
    public double sumPerimeter(List<Shape> firures) {
        List<Shape> shapes = new ArrayList<>(firures);
        double countSumOfPerimeter = 0;

        for (Shape s:shapes) {
            if(s != null)
            countSumOfPerimeter += s.getPerimeter();
        }

        return countSumOfPerimeter;
    }
}
