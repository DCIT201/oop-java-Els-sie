import java.time.LocalDate;

public class RentalTransaction {
    private final Customer customer;
    private final Vehicle vehicle;
    private final int rentalDays;
    private final LocalDate rentalDate;

    public RentalTransaction(Customer customer, Vehicle vehicle, int rentalDays) {
        if (customer == null || vehicle == null || rentalDays <= 0) {
            throw new IllegalArgumentException("Invalid rental transaction details");
        }
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.rentalDate = LocalDate.now();
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }
}
