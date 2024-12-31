public class Motorcycle extends Vehicle implements Rentable {
    private final boolean hasHelmet;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean hasHelmet) {
        super(vehicleId, model, baseRentalRate);
        this.hasHelmet = hasHelmet;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days;
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

    public boolean hasHelmet() {
        return hasHelmet;
    }
}

