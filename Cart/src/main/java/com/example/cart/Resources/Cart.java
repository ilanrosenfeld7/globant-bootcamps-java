package com.example.cart.Resources;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.data.annotation.Persistent;



@Data
@Entity

public class Cart {
	
	private @Id @GeneratedValue Long id;
	@Transient
	private List<ProductPurchase> productPurchaseList = new ArrayList<ProductPurchase>();
	private boolean finished = false;
	private double price = 0.0;
	
	public Cart() {
		super();
	}
	
	public Cart(List<ProductPurchase> productPurchase) {
		this.productPurchaseList = productPurchase;
		this.setPrice();
	}

	//goes over the whole List and calculates total price, then sets price value
	public void setPrice() {
		double sum = 0;
		for (int i = 0; i < productPurchaseList.size(); i++) {
			ProductPurchase productPurchase = productPurchaseList.get(i);
			sum += productPurchase.getProduct().getPrice() * productPurchase.getQuantity();
		}
		this.price = sum;
	}
	
	//searches ProductPurchase by product
	public ProductPurchase findByProduct(Product product) {
		ProductPurchase productPurchase = productPurchaseList.stream().filter(productPurchaseFromList -> product.getId().equals(productPurchaseFromList.getProduct().getId()))
				.findAny().orElse(null);
		return productPurchase;
	}
	
	//adds quantity to ProductPurchase if it exists, otherwise it adds new ProductPurchase with set quantity
	public void addProduct(Product product, int quantity) {
		ProductPurchase productPurchase = this.findByProduct(product);
		if (productPurchase != null) {
			productPurchase.addQuantity(quantity);
		} else {
			ProductPurchase newProductPurchase = new ProductPurchase(product, quantity);
			productPurchaseList.add(newProductPurchase);
		}
		this.setPrice();
	}
	
	//substracts quantity if productPurchase found, if quantity reaches 0, productPurchase is removed from List 
	public void deleteProduct(Product product, int quantity) {
		ProductPurchase productPurchase = this.findByProduct(product);
		if (productPurchase != null) {
			productPurchase.substractQuantity(quantity);
			if(productPurchase.getQuantity() == 0) {
				productPurchaseList.remove(productPurchase);
			}
		} 
		this.setPrice();
	}
	
	
	public void checkout() {
		this.finished = true;

	}

}
