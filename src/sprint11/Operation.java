package sprint11;

public class Operation {
    public static void main(String[] args) {

    }

    public static  int squareRectangle (int a, int b) {
        if(a < 0 || b < 0)
            throw new IllegalArgumentException();
        return a*b;
    }

    public static int trySquareRectangle(int a, int b) {
        int square = 0;
        try{
            square = squareRectangle(a, b);
        } catch (IllegalArgumentException e){

        }
        if(a < 0 || b < 0){
            return 0;
        }
        return square;
    }
}
