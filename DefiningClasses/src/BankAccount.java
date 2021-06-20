public class BankAccount {
    public static int accountNextId = 1;
    private int Id;
    private double balance;
    public static double interestRate = 0.02;

    public int getId() {
        return Id;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate(int years) {
        return this.balance*interestRate*years;
    }

    public static void setInterestRate(double interestRate){
        interestRate=interestRate;
    }


    public void setId(int id) {
        Id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


        public void deposit(double amount){
        this.balance+=amount;
        }

    public BankAccount() {
        this.Id = accountNextId++;
    }
}
