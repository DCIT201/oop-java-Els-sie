import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RentalAgency {
    private final List<Vehicle> vehicleFleet;
    private final List<RentalTransaction> rentalTransactions;

    public RentalAgency() {
        vehicleFleet = new ArrayList<>();
        rentalTransactions = new ArrayList<>();
    }

    public void addVehicleToFleet(Vehicle vehicle) {
        vehicleFleet.add(vehicle);
    }

    public void processRental(Customer customer, Rentable rentable, int days) {
        Vehicle vehicle = (Vehicle) rentable;
        if (!vehicle.isAvailableForRental()) {
            throw new IllegalStateException("Vehicle not available for rental");
        }
        customer.rentVehicle(rentable, days);
        RentalTransaction transaction = new RentalTransaction(customer, vehicle, days);
        rentalTransactions.add(transaction);
    }

    public void returnRental(Customer customer) {
        customer.returnCurrentRental();
    }

    public List<Vehicle> getAvailableVehicles() {
        return vehicleFleet.stream().filter(Vehicle::isAvailableForRental).collect(Collectors.toList());
    }

    public List<RentalTransaction> getRentalTransactions() {
        return new ArrayList<>(rentalTransactions);
    }
}


