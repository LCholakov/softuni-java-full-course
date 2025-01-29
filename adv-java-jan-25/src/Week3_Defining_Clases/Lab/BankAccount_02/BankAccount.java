package Week3_Defining_Clases.Lab.BankAccount_02;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.2;

    private static double interestRate = DEFAULT_INTEREST_RATE;
    public static int accountCount = 0;

    private  int id;
    private double balance;

    public int getId() {
        return id;
    }

    public BankAccount() {
        id = ++accountCount;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit (double amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }
}
