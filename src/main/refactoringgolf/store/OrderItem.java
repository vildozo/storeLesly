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
			Discount productDiscount;
			productDiscount = new AccessoriesDiscount();
			return productDiscount.calculateDiscount(this);	
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			Discount productDiscount;
			productDiscount = new BikeDiscount();
			return productDiscount.calculateDiscount(this);	
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			Discount productDiscount;
			productDiscount = new CloathingDiscount();
			return  productDiscount.calculateDiscount(this);
		}
		return 0;
	}

	float itemAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
