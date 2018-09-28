package demo;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	private Map<Long, ShoppingCart> cartsRepository = new HashMap<>();

	public ShoppingCartServiceImpl() {
	}

	public void create(ShoppingCart cart) {
		cartsRepository.put(cart.getId(), cart);
	}

	public void delete(Long id) {
		cartsRepository.remove(id);
	}

	public ShoppingCart getById(Long id) {
		return cartsRepository.get(id);

	}

	public ShoppingCart addItem(Long id, Item item) {
		ShoppingCart cart = cartsRepository.get(id);
		cart.getItems().add(item);
		cartsRepository.put(cart.getId(), cart);
		return cart;
	}

	public ShoppingCart removeItem(Long id, Long itemId) {
		ShoppingCart cart = cartsRepository.get(id);
		cart.getItems().remove(itemId.intValue());
		cartsRepository.put(cart.getId()-1, cart);
		return cart;
	}

	@Override
	public Item getItem(Long id, Long itemId) {
		return cartsRepository.get(id).getItems().get(itemId.intValue() - 1);
	}

}
