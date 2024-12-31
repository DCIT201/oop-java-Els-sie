import java.util.List;
import java.util.ArrayList;

public class Customer {
    private final String customerId;
    private final String name;
    private final List<Vehicle> rentalHistory;
    private Vehicle currentRental;

    public Customer(String customerId, String name) {
        if (customerId == null || customerId.isEmpty() || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid customer information");
        }
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<Vehicle> getRentalHistory() {
        return rentalHistory;
    }

    public Vehicle getCurrentRental() {
        return currentRental;
    }

    public void rentVehicle(Rentable vehicle, int days) {
        if (currentRental != null) {
            throw new IllegalStateException("Customer already has a rental");
        }
        vehicle.rent(this, days);
        currentRental = (Vehicle) vehicle;
        rentalHistory.add(currentRental);
    }

    public void returnCurrentRental() {
        if (currentRental == null) {
            throw new IllegalStateException("No current rental to return");
        }
        ((Rentable) currentRental).returnVehicle();
        currentRental = null;
    }
}


