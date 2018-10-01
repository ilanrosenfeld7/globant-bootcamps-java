package com.example.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;

@RestController
class CartController {

	private final CartRepository repositoryC;
	private final ProductRepository repositoryP;

	CartController(CartRepository repositoryC, ProductRepository repositoryP) {
		this.repositoryC = repositoryC;
		this.repositoryP = repositoryP;
	}

	// Retrieves all products

	@GetMapping("/products")
	List<Product> allProducts() {
		return repositoryP.findAll();
	}

	// Not yet implemented. Add product to Cart
	@PostMapping("/cart/{cartId}/products/{productId}")
	HttpStatus addNewProduct(@PathVariable Long cartId, @PathVariable Long productId) {
		return HttpStatus.ACCEPTED;
	};

	// Not yet implemented. Create new Cart.
	@PostMapping("/cart")
	HttpStatus createNewCart() {
		return HttpStatus.ACCEPTED;
	};

	// Retrieves single item

	@GetMapping("/products/{id}")
	ResponseEntity getProduct(@PathVariable Long id) {
		if (repositoryP.existsById(id)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(repositoryP.findById(id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// Deletes Cart
	@DeleteMapping("/cart/{id}")
	HttpStatus deleteCart(@PathVariable Long id) {
		if (repositoryC.existsById(id)) {
			repositoryC.deleteById(id);
			return HttpStatus.ACCEPTED;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}
}