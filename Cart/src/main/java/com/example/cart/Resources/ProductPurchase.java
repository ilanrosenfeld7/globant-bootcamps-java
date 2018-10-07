package com.example.cart.Resources;

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

import lombok.Data;

@Data
@Entity
public class ProductPurchase {

	private @Id @GeneratedValue Long Id;
	@Transient
	private Product product;
	private int quantity;

	public ProductPurchase() {
		super();
	}

	public ProductPurchase(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public void addQuantity(int n) {
		this.quantity += n;
	}

	public void substractQuantity(int n) {
		if ((this.quantity - n) < 0) {
			this.quantity = 0;
		} else {
			this.quantity -= n;
		}
	}
}
