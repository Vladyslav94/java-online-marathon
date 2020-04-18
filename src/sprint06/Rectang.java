package sprint06;

import java.util.*;
import java.util.stream.Collectors;



public class Rectang extends Square{
    private double height;
    public Rectang(double height, double width) {
        super(width);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getPerimeter() {
        return getWidth()*height;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Rectang))
            return false;
        Rectang rectang = (Rectang) obj;
        return this.height == ((Rectang) obj).height && this.getWidth() == ((Rectang) obj).getWidth();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getHeight());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getWidth());
        result = prime*result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static void main(String[] args) {
        List<Square> squares = new ArrayList<>();
        squares.add(new Square(4.00));
        squares.add(new Square(5.00));
        squares.add(new Square(5.00));
        squares.add(new Rectang(2.00, 3.00));
        MyUt myUt = new MyUt();


        System.out.println(myUt.sumPerimeter(squares));
    }
}

class Square{
    private double width;

    public Square(double width){
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getPerimeter(){
        return width*width;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Square))
            return false;
        Square square = (Square) obj;
        return this.width == square.width;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hash(getWidth());
        return result;
    }
}

class MyUt {
    public double sumPerimeter(List<Square> firures) {
        Set<Square> squares = new LinkedHashSet<>(firures);
        List<Square> squareList = new ArrayList<>();
        List<Rectang> rectangList = new ArrayList<>();

        for (Square s:squares) {
            if(s instanceof Rectang)
                rectangList.add((Rectang) s);
            else squareList.add(s);
        }


        double count = 0;

        for (Square s:squareList) {
            count += s.getPerimeter();
        }

        for (Rectang r:rectangList) {
            count+= r.getPerimeter();
        }

        return count;
    }
}
