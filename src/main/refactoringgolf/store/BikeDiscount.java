package refactoringgolf.store;

public class BikeDiscount implements Discount{

	public float calculateDiscount(OrderItem orderItem) {
		return orderItem.itemAmount() * 20 / 100;
	}

}
