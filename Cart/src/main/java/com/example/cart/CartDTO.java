package com.example.cart;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class CartDTO {
	private @Id @GeneratedValue Long id;
	private double price;

	public CartDTO() {
		super();
	}

	public CartDTO(double price) {
		super();
		this.price = price;
	}

}
