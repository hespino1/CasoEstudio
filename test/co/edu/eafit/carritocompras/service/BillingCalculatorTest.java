package co.edu.eafit.carritocompras.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.edu.eafit.carritocompras.data.Customer;
import co.edu.eafit.carritocompras.data.Purchase;

public class BillingCalculatorTest {
	

		private Customer customer;
		private BillingCalculator billingCalculator;
		
		@Before
		public void setUp() {
			customer = new Customer("xx1", "xxName");
			billingCalculator = new BillingCalculator();
		}

		@Test
		public void testBill() {
			BillingCalculator billingCalculator = Mockito.mock(BillingCalculator.class);
			Purchase p = BillingCalculator.calculateTotalPurchase(customer,"EL-001,FU-002");
			
			// Mocking external service behavior
			Mockito.when(BillingCalculator.calculateTotalPurchase(customer, "EL-001")).thenReturn(p);

			Assert.assertEquals(BillingCalculator.calculateTotalPurchase(customer, "EL"), p);
			
		}
		
}

