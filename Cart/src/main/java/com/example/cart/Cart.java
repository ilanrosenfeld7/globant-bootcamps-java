package com.example.cart;

import lombok.Data;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity

public class Cart {
	private @Id @GeneratedValue Long id;
	private ArrayList<Product> productList;
	private boolean finished = false;
	private double price;

	//There must be a higher level way of dealing with double sums in Java. Working on it. 
	public void sumProducts() {
		double sum = 0;
		for (int i = 0; i < productList.size(); i++) {
			Product product = productList.get(i);
			sum += product.getPrice();
		}
		this.price = sum;
	}

	public Cart() {
		super();
	}

	Cart(ArrayList<Product> productList) {
		this.productList = productList;
		sumProducts();
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	public void deleteProduct(Product product) {
		productList.remove(product);
	}

	public void checkout() {
		sumProducts();
	}

}
