package testapplication;

import lib.*;

public class TestApplication {

   public TestApplication() {

      //Car car = new Car(); // Car should be a base class.
      int currentFuelAmmount = 27;
      String chasseNumber = "oiqe0934hkkadsn";

      // Logan can extend from Dacia, while Dacia extends from Car
      Car car = new Golf(currentFuelAmmount, chasseNumber);

      car.start();
      car.shiftGear(1);
      car.drive(0.01f);// drives 0.01 Km
      car.shiftGear(2);
      car.drive(0.02f);
      car.shiftGear(3);
      car.drive(0.5f);
      car.shiftGear(4);
      car.drive(0.5f);
      car.shiftGear(4);
      car.drive(0.5f);
      car.shiftGear(5);
      car.drive(10);
      car.shiftGear(4);
      car.drive(0.5f);
      car.shiftGear(3);
      car.drive(0.1f);
      car.stop();

      float availableFuel = car.getAvailableFuel();
     System.out.println("avaible fuel " + availableFuel);
      // this value must be smaller than the initial value passed in the constructor

      float fuleConsumedPer100Km = car.getAverageFuelConsumption();

      System.out.println("fuel/100 km " + fuleConsumedPer100Km);
       // two
       Vehicle vehicle = new Golf(30, "1987ddkshik289"); //available fuel and chassis number

       vehicle.start();
       vehicle.drive(1);
       vehicle.stop();

       Car car2 = (Car) vehicle; // downcast

       availableFuel = car2.getAvailableFuel();
       System.out.println("car two "+availableFuel);
      float fuleConsumedPer100Km2 = car2.getAverageFuelConsumption();
      System.out.println("car two "+fuleConsumedPer100Km2);
       
   }

   public static void main(String[] args) {
      TestApplication t = new TestApplication();
   }

}
