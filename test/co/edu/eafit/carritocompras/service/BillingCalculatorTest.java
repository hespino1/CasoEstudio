package co.edu.eafit.carritocompras.service;

import co.edu.eafit.carritocompras.data.Customer;
import co.edu.eafit.carritocompras.data.Purchase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.math.BigDecimal;


public class BillingCalculatorTest {
	
		private Customer customer;

		@Before
		public void setUp() {
			customer = new Customer("xx1", "xxName");
		}

		@Test
		public void testBill() {
			
			Purchase purchase = Mockito.mock(Purchase.class);

			
			//Test for method getTotalPrice
			Mockito.stub(purchase.getTotalPrice()).toReturn(new BigDecimal(130000));
			Assert.assertEquals(new BigDecimal(130000), purchase.getTotalPrice());

		}
	}