package co.edu.eafit.carritocompras.service;

import co.edu.eafit.carritocompras.data.Customer;
import co.edu.eafit.carritocompras.data.Purchase;
import co.edu.eafit.carritocompras.data.PurchaseStatus;
import co.edu.eafit.carritocompras.data.util.ChangeStatusException;

public class PaymentService {

	public boolean pay(Customer customer, Purchase purchase,
			String creditCardNumnber, GenericCreditCardService creditCardService) {
		try {
			if (creditCardService.pay(creditCardNumnber,
					purchase.getTotalPrice())) {
				purchase.setStatus(PurchaseStatus.APPROVED);
			} else {
				purchase.setStatus(PurchaseStatus.REJECTED);
			}
		} catch (ChangeStatusException e) {
			purchase.markAsReview();
		}
		return true;
	}

	public int ivaCalculate() {
		// Method Code
		int iva = 1000;
		return iva;
	}

}
