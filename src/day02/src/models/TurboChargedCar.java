package models;

public class TurboChargedCar extends Car {

    private Boolean turbo = false;

    public TurboChargedCar(String registration) {
        // super has to be the first line
        // need this because the car class doesn't use the default constructor
        super(registration);
    }

    

    @Override
    public void accelerate() {
        if (this.turbo) {
            super.accelerate();
            super.accelerate();
            super.accelerate();
            super.accelerate();
            super.accelerate();
            System.out.println("Vrooooom!");
        } else {
            super.accelerate();
            System.out.println("pftt...!");
        }
    }



    public Boolean getTurbo() {
        return turbo;
    }

    public void setTurbo(Boolean turbo) {
        this.turbo = turbo;
    }
}
