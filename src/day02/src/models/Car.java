package models;

import java.util.Date;

public class Car {

    // Properties, or members of the class
    private String colour;
    private String make;
    private String registration;
    private Date registrationDate;
    private Integer acceleration = 0;

    // Constructor

    // overload constructors
    public Car() {} 
    //When you add a constructor, the default constructor disappears
    public Car(String registration) {
        this.registration = registration;
    }
    public Car(String registration, String colour) {
        this.registration = registration;
        this.colour = colour;
    }
    public Car(String registration, String colour, String make) {
        this.registration = registration;
        this.colour = colour;
        this.make = make;
    }



    //Access methods to our members
    // getMemberName, setMemberName, 
    public String getColour() { //string because it returns a string
        return this.colour;
    }

    public void setColour(String colour) { //void because not returning anything
        this.colour = colour;
    }

    // getter and setter

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        switch (make.toLowerCase()) {
            case "honda":
            case "mazda":
            case "toyota":
                this.make = make;
                break;
            default:
                
        }
        this.make = make;
    }

    public String getRegistration() {
        return this.registration;
    }

    public void setRegistration(String registration) {
        //this.registration = registration; no effect
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getAcceleration() {
        return this.acceleration;
    }

    // Behaviour - method 
    public void horn() {
        System.out.println("horn horn horn");
    }

    public void accelerate() {
        if (this.acceleration < 200) {
            this.acceleration++;
        }
    }

    public void accelerate(Integer  n, Integer fac) {
        for (Integer i = 0; i < n; i++) {
            this.accelerate();
        }
    }

    public void accelerate(Integer  n) {
        for (Integer i = 0; i < n; i++) {
            this.accelerate();
        }
    }

    public void decelerate() {
        if (this.acceleration > 0) {
            this.acceleration--;
        }
    }
    
}