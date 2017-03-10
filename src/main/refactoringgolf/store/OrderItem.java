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
		Discount productDiscount=null;
		if (getProduct().getCategory() == ProductCategory.Accessories) 
			productDiscount = new AccessoriesDiscount();
		if (getProduct().getCategory() == ProductCategory.Bikes) 
			productDiscount = new BikeDiscount();
		if (getProduct().getCategory() == ProductCategory.Cloathing) 
			productDiscount = new CloathingDiscount();
		return  productDiscount.calculateDiscount(this);
	}

	float itemAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
