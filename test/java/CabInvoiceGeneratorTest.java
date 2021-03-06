import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator = null;

    @Before
    public void setUp(){
        cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double result = cabInvoiceGenerator.calculateFare(15, 30);
        Assert.assertEquals(180, result, 0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double result = cabInvoiceGenerator.calculateFare(0.1, 1);
        Assert.assertEquals(5, result, 0);
    }

    @Test
    public void givenMultipleDistanceAndTime_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary() {
        String userId = "userOne";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        cabInvoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = cabInvoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
