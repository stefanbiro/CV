package lib;

public abstract class Car implements Vehicle {

   private String CHASSENUMBER;
   protected float currentFuelAmount; // amount of fuel after stop? [l]
   private float initialFuelAmount;
   private final int FUEL_TANK_CAPACITY = 60;
   private FuelType fuelType;
   private final int NR_OF_GEARS = 5;
   protected float consumption; //initial consumption

   public Car(float currentFuelAmount, String CHASSENUMBER) {
      this.CHASSENUMBER = CHASSENUMBER;
      this.currentFuelAmount = currentFuelAmount;
   }

   // from interface
   @Override
   public void start() {
      initialFuelAmount = getAvailableFuel();
      consumption = 0;
   }

   @Override
   public abstract void drive(float km);

   @Override
   public void stop() {

   }

   public abstract void shiftGear(int gears);

   public abstract float getAvailableFuel();

   public abstract float getAverageFuelConsumption();

   enum FuelType {

      PETROL, DIESEL, ELECTRIC, HIBRID;
   }

}
