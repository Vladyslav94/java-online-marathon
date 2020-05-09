package sprint12;

public class Accountant {

    public static int sum(int x, int y) {
        ParallelCalculator parallelCalculator = new ParallelCalculator(Integer::sum,x, y);
        Thread thread = new Thread(parallelCalculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return parallelCalculator.result;
    }


    public static void main(String[] args) {
        System.out.println(sum(3,9));
    }


}
