package com.globant.shoppingCartService.services;

import java.util.ArrayList;
import java.util.List;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import com.globant.cartService.entities.Item;
import com.globant.cartService.entities.ShoppingCart;
import com.globant.cartService.entities.User;
import com.globant.cartService.exceptions.CartNotFoundException;
import com.globant.cartService.repositories.ItemRepository;
import com.globant.cartService.repositories.ShoppingCartRepository;
import com.globant.cartService.services.ItemService;
import com.globant.cartService.services.ShoppingCartService;

public class ShoppingCartServiceTest extends EasyMockSupport {
	@TestSubject
	ShoppingCartService shoppingCartService;
	private ShoppingCartRepository shoppingCartRepository;
	private ItemRepository itemRepository;
	private ItemService itemService;

@Before
public void setUp(){
	shoppingCartRepository = createMock(ShoppingCartRepository.class);
	itemRepository = createMock(ItemRepository.class);
	itemService = createMock(ItemService.class);
	this.shoppingCartService = new ShoppingCartService(shoppingCartRepository, itemService, itemRepository);
}
	@Test
	public void create() throws CartNotFoundException {
		resetAll();
		User user= new User(1);
		Item item= new Item();
		item.setId(1L);
		List<Item> list = new ArrayList<Item>() {{add(item);}};
		ShoppingCart cart = new ShoppingCart("pending",list,user);
		ShoppingCart expected = new ShoppingCart("pending",list,user);
		expected.setCartId(1L);
		expect(itemRepository.saveAll(cart.getItems())).andReturn(list);
		expect(shoppingCartRepository.save(cart)).andReturn(expected);
		replayAll();
		ShoppingCart result = shoppingCartService.create(cart);

		assertEquals(result, expected);
	}
	


}