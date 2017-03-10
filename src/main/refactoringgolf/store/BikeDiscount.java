package refactoringgolf.store;

public class BikeDiscount {

	float calculateBikeDiscount(OrderItem orderItem) {
		return orderItem.itemAmount() * 20 / 100;
	}

}
