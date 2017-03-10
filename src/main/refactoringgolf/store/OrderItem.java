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
			return accessoriesDiscount.calculateAccessoriesDiscount(this);	
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			BikeDiscount bikeDiscount = new BikeDiscount();
			return bikeDiscount.calculateBikeDiscount(this);	
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			CloathingDiscount cloathingDiscount = new CloathingDiscount();
			return  calculateCloathingDiscount(cloathingDiscount);
		}
		return 0;
	}

	private float calculateCloathingDiscount(CloathingDiscount cloathingDiscount) {
		float cloathingDiscounts = 0;
		if (getQuantity() > 2) {
			cloathingDiscounts = getProduct().getUnitPrice();
		}
		return cloathingDiscounts;
	}

	float itemAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}
}
