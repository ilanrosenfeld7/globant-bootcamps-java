package demo;

public interface ShoppingCartService {
	ShoppingCart getById(Long id);
	void create(ShoppingCart cart);
	void delete(Long id);
	ShoppingCart addItem(Long id, Item item);
	ShoppingCart removeItem(Long id, Long itemId);
	Item getItem(Long id, Long itemId);
}
