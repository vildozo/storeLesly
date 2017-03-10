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
			Discount accessoriesDiscount = new AccessoriesDiscount();
			return accessoriesDiscount.calculateDiscount(this);	
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			Discount bikeDiscount = new BikeDiscount();
			return bikeDiscount.calculateDiscount(this);	
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			Discount cloathingDiscount = new CloathingDiscount();
			return  cloathingDiscount.calculateDiscount(this);
		}
		return 0;
	}

	float itemAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
