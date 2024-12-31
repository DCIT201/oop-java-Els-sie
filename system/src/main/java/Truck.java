public class Truck extends Vehicle implements Rentable {
    private final double cargoCapacity;

    public Truck(String vehicleId, String model, double baseRentalRate, double cargoCapacity) {
        super(vehicleId, model, baseRentalRate);
        if (cargoCapacity <= 0) {
            throw new IllegalArgumentException("Invalid cargo capacity");
        }
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRentalRate() * days) + (cargoCapacity * 10);
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.rentVehicle(this, days);
        } else {
            throw new IllegalStateException("Vehicle not available for rental");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }
}




