package refactoringgolf.store;

public class BikeDiscount {

	float calculateDiscount(OrderItem orderItem) {
		return orderItem.itemAmount() * 20 / 100;
	}

}
