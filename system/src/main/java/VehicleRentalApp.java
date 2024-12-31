public class VehicleRentalApp {
    public static void main(String[] args) {
        RentalAgency rentalAgency = new RentalAgency();

        // Adding vehicles to the fleet
        Car car = new Car("C001", "Sedan", 50.0, 10.0);
        Motorcycle motorcycle = new Motorcycle("M001", "Sport Bike", 30.0, true);
        Truck truck = new Truck("T001", "Pickup", 80.0, 2000);

        rentalAgency.addVehicleToFleet(car);
        rentalAgency.addVehicleToFleet(motorcycle);
        rentalAgency.addVehicleToFleet(truck);

        // Creating customers
        Customer customer1 = new Customer("CU001", "John Doe");
        Customer customer2 = new Customer("CU002", "Jane Smith");

        // Processing rentals
        rentalAgency.processRental(customer1, car, 3);
        rentalAgency.processRental(customer2, motorcycle, 2);

        // Calculate and display rental costs
        System.out.println("Rental cost for customer 1's car rental: " + car.calculateRentalCost(3));
        System.out.println("Rental cost for customer 2's motorcycle rental: " + motorcycle.calculateRentalCost(2));

        // Check if motorcycle has a helmet
        if (motorcycle.hasHelmet()) {
            System.out.println("The motorcycle " + motorcycle.getModel() + " comes with a helmet.");
        } else {
            System.out.println("The motorcycle " + motorcycle.getModel() + " does not come with a helmet.");
        }

        // Check cargo capacity of the truck
        System.out.println("The truck " + truck.getModel() + " has a cargo capacity of " + truck.getCargoCapacity() + " units.");

        // Display available vehicles after rentals
        System.out.println("Available vehicles after rentals:");
        for (Vehicle vehicle : rentalAgency.getAvailableVehicles()) {
            System.out.println(vehicle.getModel() + " (" + vehicle.getVehicleId() + ")");
        }

        // Display current rental of customer1
        if (customer1.getCurrentRental() != null) {
            System.out.println("Customer " + customer1.getName() + " is currently renting: " + customer1.getCurrentRental().getModel());
        }

        // Returning rentals
        rentalAgency.returnRental(customer1);
        rentalAgency.returnRental(customer2);

        // Display available vehicles after returns
        System.out.println("Available vehicles after returns:");
        for (Vehicle vehicle : rentalAgency.getAvailableVehicles()) {
            System.out.println(vehicle.getModel() + " (" + vehicle.getVehicleId() + ")");
        }

        // Display rental transactions
        System.out.println("Rental Transactions:");
        for (RentalTransaction transaction : rentalAgency.getRentalTransactions()) {
            System.out.println("Customer ID: " + transaction.getCustomer().getCustomerId() +
                    ", Customer Name: " + transaction.getCustomer().getName() +
                    ", Vehicle: " + transaction.getVehicle().getModel() +
                    ", Days: " + transaction.getRentalDays() +
                    ", Date: " + transaction.getRentalDate());
        }

        // Display rental history of customer1
        System.out.println("Rental history of customer " + customer1.getName() + ":");
        for (Vehicle vehicle : customer1.getRentalHistory()) {
            System.out.println(vehicle.getModel() + " (" + vehicle.getVehicleId() + ")");
        }
    }
}
