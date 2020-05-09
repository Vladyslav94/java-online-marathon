package sprint12;

import java.util.function.BinaryOperator;

public class ParallelCalculator implements Runnable{
    private BinaryOperator<Integer> operationToTake;
    private int operand1;
    private int operand2;
    int result;


    public ParallelCalculator(BinaryOperator<Integer> binaryOperator, int operand1, int operand2){
        this.operationToTake = binaryOperator;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public void run() {
        this.result = operationToTake.apply(operand1, operand2);
    }
}
