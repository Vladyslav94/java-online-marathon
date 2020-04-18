package sprint06.task4;

import java.util.Objects;

public class Square implements Shape{
    private double width;

    public Square(double width){
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getPerimeter() {
        return width*4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }

}
