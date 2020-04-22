package sprint07;

public class Resolve {
    public static void main(String[] args) {
        System.out.println(drawLine(LineType.DOUBLE));
    }

    public static String drawLine(LineType lineType) {
         return String.format("The line is %s type", lineType.name().toLowerCase());
    }
}
