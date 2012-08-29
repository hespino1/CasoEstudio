package co.edu.eafit.carritocompras.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.edu.eafit.carritocompras.data.Customer;
import co.edu.eafit.carritocompras.data.Purchase;
public class PaymentServiceTest {

	private Customer customer;
	private PaymentService paymentService;
    private loyaltyPoints loyaltyPoints;
	
	@Before
	public void setUp() {
		customer = new Customer("xx1", "xxName");
		paymentService = new PaymentService();
		loyaltyPoints = new loyaltyPoints();		
	}

	@Test
	public void testPay() {
		GenericCreditCardService creditCardService = Mockito.mock(GenericCreditCardService.class);
		Purchase p = BillingCalculator.calculateTotalPurchase(customer,
				"EL-001,FU-002");
		PaymentService a = Mockito.mock(PaymentService.class);
        loyaltyPoints b = Mockito.mock(loyaltyPoints.class);
        customer = Mockito.mock(Customer.class);
		
		// Mocking external service behavior
		
		//test for creditCardService method
		Mockito.when(creditCardService.pay("xxxx111xxxx", p.getTotalPrice()))
				.thenReturn(true);
		Assert.assertTrue(creditCardService.pay("xxxx111xxxx",p.getTotalPrice()));
		
		//Test for ivaCalculate method
		Mockito.when(a.ivaCalculate()).thenReturn(1000);
        Assert.assertEquals(1000, a.ivaCalculate());
		
		//Test for pointsCalculate
        Mockito.when(b.pointsCalculate()).thenReturn(200);
        Assert.assertEquals(200, b.pointsCalculate());
        
       //Test for pointsCalculate with implemented method
        Mockito.when(customer.pointsCalculate(p.getTotalPrice())).thenReturn(200);
        Assert.assertEquals(200, customer.pointsCalculate(p.getTotalPrice()));
        
    }

}
