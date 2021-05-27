package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.beans.Item;
import com.ecom.beans.Response;
import com.ecom.entity.ShoppingCart;
import com.ecom.serviceImpl.ShoppingCartServiceImpl;

@RestController
@RequestMapping("/driver")
public class ShoppingCartController {

	@Autowired ShoppingCartServiceImpl cartService;
	
	@GetMapping(value= {"","/"})
	public Response getShoppingCartDetails(@RequestHeader String cartId) {
		return cartService.getShoppingCartDetails(cartId);
	}
	
	@PutMapping(value= {"","/"})
	public Response updategetShoppingCartDetails(@RequestBody ShoppingCart cart) {
		return cartService.updategetShoppingCartDetails(cart);
	}
	
	@PostMapping(value= {"","/"})
	public Response insertItemsList(@RequestBody ShoppingCart cart) {
		return cartService.insertItemsList(cart);
	}
}
