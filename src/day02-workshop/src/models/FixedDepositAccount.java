package models;

public class FixedDepositAccount extends BankAccount {
    
    private Float interest = 3.0f;
    private Integer interestCounter = 0;
    private Integer duration = 6; //in months
    private Integer durationCounter = 0;

    public FixedDepositAccount(String name, Float accountBalance) {
        super(name, accountBalance);
    }

    public FixedDepositAccount(String name, Float accountBalance, Float interest){
        // super(name, accountBalance);
        // this.interest = interest;
        this(name, accountBalance, interest, 6);

    }

    public FixedDepositAccount(String name, Float accountBalance, Float interest, Integer duration){
        super(name, accountBalance);
        this.interest = interest;
        this.duration = duration;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        if (interestCounter == 0) {
            this.interest = interest;
            interestCounter++;
        } else {
            throw new IllegalArgumentException("Duration can only be changed once");
        }

    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        if (durationCounter == 0) {
            this.duration = duration;
            durationCounter++;
        } else {
            throw new IllegalArgumentException("Duration can only be changed once");
        }
    }

    public void deposit(Float amount) {
    }

    public void withdraw(Float amount) {
    }

    public void getBalance() {
        System.out.println("Your account balance is: " + (this.interest + super.getAccountBalance()));
    }




}
