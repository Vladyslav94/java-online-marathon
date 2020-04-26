package sprint08;


import java.util.Arrays;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {
        double[] arrayOfDoubles = {-10, 0, 1, 3, 3};

        Consumer<double[]> cons = doubles -> {
            for (int i = 0; i < doubles.length; i++) {
                if (doubles[i] > 2)
                    doubles[i] = doubles[i] * 0.8;
                else
                    doubles[i] = doubles[i] * 0.9;
            }
        };
        System.out.println(Arrays.toString(getChanged(arrayOfDoubles, cons)));
    }



    public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
        double[] newArrayOfDouble = new double[initialArray.length];

        System.arraycopy(initialArray, 0, newArrayOfDouble, 0, initialArray.length);

        consumer.accept(newArrayOfDouble);

        return newArrayOfDouble;
    }


}
