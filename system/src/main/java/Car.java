public class Car extends Vehicle implements Rentable {
    private final double insuranceCost;

    public Car(String vehicleId, String model, double baseRentalRate, double insuranceCost) {
        super(vehicleId, model, baseRentalRate);
        if (insuranceCost < 0) {
            throw new IllegalArgumentException("Invalid insurance cost");
        }
        this.insuranceCost = insuranceCost;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRentalRate() * days) + insuranceCost;
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
}
