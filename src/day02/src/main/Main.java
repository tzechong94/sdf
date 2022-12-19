package main;


import java.util.Date;

import models.Car;
import models.TurboChargedCar;

public class Main {
    
    public static void main(String[] args) {

        Car myCar = new Car("S1234A");
        Car myOtherCar = new TurboChargedCar("S4321A");
        Date date = new Date();

        myCar.setColour("red");
        myCar.setMake("Honda");
        myCar.setRegistration("S1234A");
        myCar.setRegistrationDate(date);

        myCar.horn();
        System.out.printf("colour: %s, make: %s, registration: %s\n", myCar.getColour(), myCar.getMake(), myCar.getRegistration());
        
        myCar.accelerate();
        myCar.accelerate();
        myCar.accelerate();

        System.out.printf("Acceleration is %d", myCar.getAcceleration());

        if (myOtherCar instanceof TurboChargedCar) {
            // Cast it into a TurboChargedCar type to access it
            TurboChargedCar turbo = (TurboChargedCar)myOtherCar;
            turbo.setTurbo(true);
        }
    }
}
