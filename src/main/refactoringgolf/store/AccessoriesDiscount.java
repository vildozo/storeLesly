package refactoringgolf.store;

public class AccessoriesDiscount {

	float calculateDiscount(OrderItem orderItem) {
		float booksDiscount = 0;
		if (orderItem.itemAmount() >= 100) {
			booksDiscount = orderItem.itemAmount() * 10 / 100;
		}
		return booksDiscount;
	}

}
