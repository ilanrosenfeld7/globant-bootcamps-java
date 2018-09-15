package product;

public class Product {
	
	private int prodID;
	private String name;
	private String brand;
	private float price;
	private int stock;
	private boolean hasWeight;
	public int getProdID() {
		return prodID;
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isHasWeight() {
		return hasWeight;
	}
	public void setHasWeight(boolean hasWeight) {
		this.hasWeight = hasWeight;
	}

}
