package sprint11;

public class CheckingAccount {
    private double balance;
    private int number;

    public CheckingAccount(int number) {
        this.number = number;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientAmountException {
        if(amount <= balance) {
            balance -= amount;
        }else {
            double needs = amount - balance;
            throw new InsufficientAmountException(needs);
        }
    }

    class InsufficientAmountException extends Exception{
        double amount;
        public InsufficientAmountException(double n){
            this.amount = n;
        }

        @Override
        public String getMessage() {
            return "Sorry, but you are short $" + amount;
        }

        public double getAmount(){
            return amount;
        }
    }
}

class BankDemo {
    public static void main(String[] args) {
        doOperations();
    }
    public static void doOperations() {
        CheckingAccount c = new CheckingAccount(101);
        c.deposit(500.00);
        try {
            c.withdraw(100.00);
            c.withdraw(600.00);
        } catch (CheckingAccount.InsufficientAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please, deposit at least $" + e.getAmount());
            e.printStackTrace();
        }
    }
}
