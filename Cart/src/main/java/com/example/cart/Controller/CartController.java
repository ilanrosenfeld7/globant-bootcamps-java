package com.example.cart.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.cart.Resources.ProductPurchase;
import com.example.cart.Resources.ProductPurchaseDTO;
import com.example.cart.Services.CartService;
import com.example.cart.Services.ItemsService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
class CartController {
	private final CartService cartService;
	private final ItemsService itemsService;

	CartController(CartService cartService, ItemsService itemsService) {
		this.cartService = cartService;
		this.itemsService = itemsService;

	}

	@GetMapping("/carts/{cartId}")
	ResponseEntity getCartById(@PathVariable Long cartId) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartService.getCart(cartId));
	}

	@GetMapping("/carts/{cartId}/products/{productId}/quantity/{quantity}")
	ResponseEntity addNewProduct(@PathVariable Long cartId, @PathVariable Long productId, @PathVariable int quantity) {
		if (cartService.addProduct(cartId, productId, quantity)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	};

	@DeleteMapping("/carts/{cartId}/products/{productId}/quantity/{quantity}")
	ResponseEntity deleteProduct(@PathVariable Long cartId, @PathVariable Long productId, @PathVariable int quantity) {
		if (cartService.deleteProduct(cartId, productId, quantity)) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	};

	@PostMapping("/carts")
	ResponseEntity createNewCart(@RequestBody List<ProductPurchaseDTO> purchaseDTO) {
		ArrayList<ProductPurchase> purchase = (ArrayList<ProductPurchase>) itemsService.toEntity(purchaseDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addNewCart(purchase));

	};

	// Deletes Cart
	@DeleteMapping("/carts/{id}")
	ResponseEntity deleteCart(@PathVariable Long id) {
		if (cartService.deleteCart(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}