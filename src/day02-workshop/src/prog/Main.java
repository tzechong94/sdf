package prog;

import models.BankAccount;
import models.FixedDepositAccount;

public class Main {
    
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("John", 100.50f);
        bankAccount.deposit(10.023f);
        bankAccount.withdraw(50.50f);
        bankAccount.getAccountBalance();
        bankAccount.setName("John");
        bankAccount.setAccountNumber("12123");

        FixedDepositAccount fixedDeposit = new FixedDepositAccount("Joshua", 100.5f, 5.5f, 5);
        fixedDeposit.getInterest();
        fixedDeposit.getBalance();

     }
}
