package Vehicles;

import Driving.Bike;

public class MountainBike extends Bike {
    
    private Integer TirePressure = 0;
    /**
     * The top speed of a mountain bike should be 28.5
     * but for every 1 PSI under the recommended tire
     * pressure the tires of the bike are, the top
     * speed should be reduced 1mph.
     *
     * @return 28.5 minus any reduction to top speed
     */
    @Override
    public Double getTopSpeed() {
        return 28.5;
    }


    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the tire pressure. Long trips
     * on a mountain bike will reduce its PSI, so for
     * every 30 miles traveled in a single trip, the
     * tires of the bike should reduce 1 PSI until
     * the tires register 20 PSI where no more air
     * will be lost on trips.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    @Override
    public Integer transport(Double distance) {
        double timeInSeconds =  distance / getTopSpeed() * 60 * 60;
        if(distance >= 30){
            TirePressure = TirePressure-1;
        }
        return (int)timeInSeconds;
    }

    /**
     * Gets the current amount of pressure in PSI
     * in the tires
     *
     * @return PSI as Integer
     */
    @Override
    public Integer getTirePressure() {
        return TirePressure;
    }

    /**
     * Returns the tires to the recommended PSI
     */
    @Override
    public void inflateTires() {
        TirePressure = recommendedTirePressure();
    }

    /**
     * The Recommended PSI of a mountain bike is 30
     * @return recommended PSI
     */
    @Override
    public Integer recommendedTirePressure() {
        return 30;
    }
}
