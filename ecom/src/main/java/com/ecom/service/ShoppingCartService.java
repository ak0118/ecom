package com.ecom.service;

import com.ecom.beans.Item;
import com.ecom.beans.Response;
import com.ecom.entity.ShoppingCart;

public interface ShoppingCartService {
	public Response getShoppingCartDetails(String cartId);
	public Response updategetShoppingCartDetails(ShoppingCart item);
	public Response insertItemsList(ShoppingCart cart);
}
