package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BankAccount {

    // members 
    private String name = "";
    private String accountNumber = "";
    private Float accountBalance;
    private List<String> transactions = new LinkedList<String>();
    private Boolean isClosed = false;
    private Date createDate = new Date();
    private Date closeDate = new Date();


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    LocalDateTime date = LocalDateTime.now();

    //constructors 
    public BankAccount(String name){
        this(name, 0.0f);
        this.createAccount();
    }

    public BankAccount(String name, Float initialBalance){
        this.accountBalance = initialBalance;
        this.name = name;
        this.createAccount();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        System.out.println("Cannot change name");;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        System.out.println("Cannot change account number.");
    }
    public Float getAccountBalance() {
        return accountBalance;
    }
    private void setAccountBalance(Float accountBalance) {
        this.accountBalance = accountBalance;
    }
    public List<String> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
    public Boolean getIsClosed() {
        return isClosed;
    }
    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getCloseDate() {
        return closeDate;
    }
    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public void deposit(Float amount) {
        if (amount > 0f && isClosed == false) {
            String transactionLine = String.format("deposit $%f at %s", amount, date);
            this.transactions.add(transactionLine);
            this.accountBalance += amount;
            this.setAccountBalance(accountBalance+amount);
            System.out.println(transactionLine + " Your account balance is: " + accountBalance);
        } else {
            throw new IllegalArgumentException("Incorrect amount or account closed. Please check.");
        }
    }

    public void withdraw(Float amount) {
        if (amount > 0 && accountBalance > amount && isClosed == false) {
            String transactionLine = String.format("withdraw $%f at %s", amount, date);
            this.transactions.add(transactionLine);
            this.accountBalance -= amount;
        } else {
            throw new IllegalArgumentException("Incorrect amount or account closed. Please check.");
        }
    }

    public void closeAccount() {
        this.isClosed = true;
        Date closeDate = new Date();
        System.out.println("Account closed on: " + closeDate);
    }

    public void createAccount() {
        this.isClosed = false;
        Date createDate = new Date();
        System.out.println("Account created on: " + createDate);
    }


    }

    