public class CabInvoiceGenerator {
    private final int MINIMUM_FARE = 5;
    private final int COST_PER_KILOMETER = 10;
    private final int COST_PER_MINUTE = 1;

    public double calculateFare(double distance, int time) {
        double totalFare = COST_PER_KILOMETER * distance + COST_PER_MINUTE * time;
        if (totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        }
        return totalFare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return totalFare;
    }
}
