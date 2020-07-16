package Vehicles;

import Driving.Car;

public class HondaCivic extends Car {
    private double mileage;

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    /**
     * A civic should need an oil change every
     * 50,000 miles traveled. Once the oil is
     * changed, the car may travel another 50,000
     * miles before needing another oil change.
     *
     * @return true if an oil change is needed
     */
    @Override
    public Boolean needsOilChange() {
        //condition: Mileage > 50000
        if(getDistanceTravel() <= 50000.0){
            changeOil();
            return false;
        }
        changeOil();
        return true;
    }

    /**
     * This method should reset any flags set
     * from when an oil change was needed. It
     * should also indicate that another 50,000
     * miles may be traveled before another oil
     * change is needed.
     */
    @Override
    public void changeOil() {
        mileage = 0.0;
        System.out.println("50,000 miles may be traveled before another oil change is needed.");
    }

    /**
     * the check engine light should be on whenever
     * something is wrong with the car. This class
     * simply turns on the light when an oil change
     * is needed.
     * @return true if anything is wrong with the car
     */
    @Override
    public Boolean checkEngineLight() {
        if(needsOilChange() == true){
            return false;}
        return true;
    }

    /**
     * This method should return the total distance
     * traveled by the car. This number can never
     * decrease, so every time it is called the newest
     * value returned should be equal to or higher
     * than all previous values.
     * @return total distance as a Double
     */
    //@Override
    public Double getDistanceTravel() {
        return mileage;
    }

    /**
     * Should return the top speed for a Civic (70 MPH)
     * @return 70.0
     */
    //@Override
    public Double getTopSpeed() {
        return 70.0;
    }

    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the amount of miles traveled.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    //@Override
    public Integer transport(Double distance) {
        double timeInSeconds =  distance / getTopSpeed() * 60 * 60;
        return (int)timeInSeconds;
    }
}
