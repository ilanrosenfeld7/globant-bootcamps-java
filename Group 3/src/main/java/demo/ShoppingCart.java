package demo;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "id" })
public class ShoppingCart {
	private List<Item> items;
	private Long id;

	public ShoppingCart() {
		
	}
	
	public ShoppingCart(Long id,Collection<Item> collection) {
		this.items = items;
		this.id = id;
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
