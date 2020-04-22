package sprint07;

public class Anonymous {
    public static void main(String[] args) {
        Strategy strategyAdd = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a+b;
            }
        };


        Strategy strategySubtract = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a-b;
            }
        };

        Strategy strategyMultiply = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a*b;
            }
        };

        Strategy strategyDivide = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a/b;
            }
        };

    }


}
