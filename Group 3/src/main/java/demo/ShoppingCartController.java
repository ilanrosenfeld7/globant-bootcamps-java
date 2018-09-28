package demo;


import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;
	private final AtomicLong idCounter = new AtomicLong();



    @Autowired
    public void setShoppingCartService(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

	@RequestMapping("/cart/{id}/items")
    public ShoppingCart getItems(@PathVariable Long id) {
    	return shoppingCartService.getById(id);

    }
	
	@RequestMapping(value = "/cart/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
    	 shoppingCartService.delete(id);
    }
	
	@RequestMapping(value = "/carts", method = RequestMethod.POST)
	public ShoppingCart create(@RequestParam("items") String items){
		ObjectMapper objectMapper = new ObjectMapper();
        ShoppingCart cart = new ShoppingCart();
		try {
			cart = objectMapper.readValue(items,ShoppingCart.class);
			cart.setId(idCounter.incrementAndGet());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		shoppingCartService.create(cart);
		return cart;
		
	}
	@RequestMapping(value = "/cart/{id}/item", method = RequestMethod.PUT)
	public ShoppingCart addItem(@RequestParam("item") String jsonItem, @PathVariable Long id){
		ObjectMapper objectMapper = new ObjectMapper();
		Item item = new Item();
		try {
			item = objectMapper.readValue(jsonItem,Item.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return shoppingCartService.addItem(id, item);

	}
    
	@RequestMapping(value = "/cart/{id}/item/{itemId}", method = RequestMethod.DELETE)
	public ShoppingCart removeItem(@PathVariable Long id, @PathVariable Long itemId){
		return shoppingCartService.removeItem(id, itemId);	
	}
	
	@RequestMapping(value = "/cart/{id}/item/{itemId}", method = RequestMethod.GET)
	public Item getItem(@PathVariable Long id, @PathVariable Long itemId){
		return shoppingCartService.getItem(id, itemId);	
	}


    
}
