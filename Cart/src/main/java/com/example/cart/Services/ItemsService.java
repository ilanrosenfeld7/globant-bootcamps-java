package com.example.cart.Services;

import com.example.cart.Resources.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.cart.Resources.Product;

@Service
@ConfigurationProperties(prefix="endpoint")
public class ItemsService {
	private RestTemplate restTemplate;
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ItemsService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;

	}

	public Product getItem(Long Id) {
		List<Product> products = Arrays.asList(this.getAllItems());
		Product prod = products.stream().filter(productFromList -> Id.equals(productFromList.getId())).findAny()
				.orElse(null);
		return prod;

	}

	public Product[] getAllItems() {
		Product[] products = restTemplate.getForObject("http://challenge.getsandbox.com/articles",
				Product[].class);
		return products;

	}

	public double getPriceById(Long productId) {
		Product prod = getItem(productId);
		return prod.getPrice();

	}

	public List<ProductPurchase> toEntity(List<ProductPurchaseDTO> listDTO) {
		List<ProductPurchase> productPurchaseList = new ArrayList();
		listDTO.forEach((p) -> {
			Product prod = this.getItem(p.getProductId());
			if (prod != null) {
				ProductPurchase productPurchase = new ProductPurchase(prod, p.getQuantity());
				productPurchaseList.add(productPurchase);
			}

		});
		return productPurchaseList;
	}

}