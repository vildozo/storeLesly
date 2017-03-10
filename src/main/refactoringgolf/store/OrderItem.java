package refactoringgolf.store;

public class OrderItem {
	
	private Product product;
	private int quantity;

	/*
	 * Order Item Constructor
	 */
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	float totalItem() {
		return itemAmount() - calculateDiscount();
	}

	private float calculateDiscount() {
		if (getProduct().getCategory() == ProductCategory.Accessories) {
			AccessoriesDiscount accessoriesDiscount = new AccessoriesDiscount();
			return calculateAccessoriesDiscount(accessoriesDiscount);	
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			return calculateBikeDiscount();	
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			return  calculateCloathingDiscount();
		}
		return 0;
	}

	private float calculateCloathingDiscount() {
		float cloathingDiscount = 0;
		if (getQuantity() > 2) {
			cloathingDiscount = getProduct().getUnitPrice();
		}
		return cloathingDiscount;
	}

	private float calculateBikeDiscount() {
		return itemAmount() * 20 / 100;
	}

	private float calculateAccessoriesDiscount(AccessoriesDiscount accessoriesDiscount) {
		float booksDiscount = 0;
		if (itemAmount() >= 100) {
			booksDiscount = itemAmount() * 10 / 100;
		}
		return booksDiscount;
	}

	private float itemAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
