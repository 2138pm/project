import java.util.Scanner;
class BankAccount{
    private String accountNumber;
    private String accoutName;
    private double balance;

    public BankAccount(String accoutNumber, String accountName){
        this.accountNumber = accoutNumber;
        this.accoutName = accountName;
        this.balance = 0.00;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposit: "+amount);
        System.out.println("Current Balance: "+balance);
    }

    public void widthdraw(double amount){
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Widthdraw: "+amount);
            System.out.println("Current Balance: "+balance);
        }
        else{
            System.out.println("There is not enough money in the account.");
        }
    }

    public double getBalance(){
        return balance;
    }

    public void transfer(BankAccount receiver, double amount){
        if (balance >= amount) {
            widthdraw(amount);
            receiver.deposit(amount);
            System.out.println("Transfer successful!");
        }
        else{
            System.out.println("There is not enough money in the account.");
        }
    }
}
public class BankApp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        BankAccount account1 = new BankAccount("012346", "Peeranat Phaophom");
        BankAccount account2 = new BankAccount("025045", "John Sena");

        account1.deposit(1000);
        account2.deposit(2000);

        System.out.println("Transfer money from accout 1 to accout 2");
        account1.transfer(account2, 300);

        System.out.println("Final Balance in Account 1: "+account1.getBalance());
        System.out.println("Final Balace in Account 2: "+account2.getBalance());
    }
}