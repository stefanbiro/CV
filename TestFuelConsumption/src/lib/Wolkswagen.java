package lib;

/**
 * this class compute the consumption of Wolkswagen models the consumption
 * variabile that is 0 before start , will increese with all car action :
 * shiftGear and drive . At last i make the difference beetwin currentFuelAmount
 * and consumption
 */
public abstract class Wolkswagen extends Car {

   /**
    * gear factor; the consumption is influented even by the gear. biggest is
    * the gear highest is the fuel consumption
    */
   private float gearFact = 1;
   
   private float driveDistance = 0;

   public Wolkswagen(float currentFuelAmount, String chasseNumber) {
      super(currentFuelAmount, chasseNumber);
   }

   public abstract float getMediumFuelConsumption();

   @Override
   public void shiftGear(int gears) {
      gearFact = 1; // reset of the gearFact 
      if (gears == 1) {
         gearFact *= 1.2;
      } else if (gears == 2) {
         gearFact *= 1.1;
      } else if (gears == 3) {
         gearFact *= 1;
      } else if (gears == 4) {
         gearFact *= 0.9;
      } else {
         gearFact *= 0.8;
      }

   }

   @Override
   public void drive(float km) {
      consumption += gearFact * (getMediumFuelConsumption() * km) / 100;
      driveDistance += km;
   }

   @Override
   public float getAvailableFuel() {

      return currentFuelAmount - consumption;
   }

   @Override
   public float getAverageFuelConsumption() {
      float consumedFuel = currentFuelAmount - getAvailableFuel();
      float averageFuelConsumption = (consumedFuel * 100) / driveDistance;
      return averageFuelConsumption;
   }

}
