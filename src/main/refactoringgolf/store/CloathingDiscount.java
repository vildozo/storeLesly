package refactoringgolf.store;

public class CloathingDiscount {

	float calculateDiscount(OrderItem orderItem) {
		float cloathingDiscounts = 0;
		if (orderItem.getQuantity() > 2) {
			cloathingDiscounts = orderItem.getProduct().getUnitPrice();
		}
		return cloathingDiscounts;
	}

}
