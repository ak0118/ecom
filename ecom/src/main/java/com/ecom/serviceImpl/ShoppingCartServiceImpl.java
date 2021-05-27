package com.ecom.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.beans.Item;
import com.ecom.beans.Response;
import com.ecom.entity.ShoppingCart;
import com.ecom.reposImpl.ShoppingCartRepositoryImpl;
import com.ecom.service.ShoppingCartService;
import com.ecom.util.Utility;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired ShoppingCartRepositoryImpl cartRepo;
	
	@Override
	public Response getShoppingCartDetails(String cartId) {
		try {
			Response res = Utility.success.apply(cartId, "Successfully fetched cart details");
			res.setPayload(Utility.getPayload.apply(cartRepo.findItemsListByCartId(cartId)));
			return res;
		}catch(Exception e) {
			e.printStackTrace();
			return Utility.failure.apply(cartId, e.getMessage());
		}
	}
	
	
	@Override
	public Response updategetShoppingCartDetails(ShoppingCart cart) {
		try {
//			fetched driver data from sql
			cartRepo.updateCartItems(cart.getItem(),cart.getCartId());
			return Utility.success.apply(cart.getCartId(), "Successfully Updated cart items");
		}catch(Exception e) {
			e.printStackTrace();
			return Utility.failure.apply(cart.getCartId(), e.getMessage());
		}
	}
	
	@Override
	public Response insertItemsList(ShoppingCart cart) {
		try {
			cart.setOtp(Utility.generateOtp.get()); // OTP can be used for validating phone no. Msg can be sent via AWS SNS
			cartRepo.save(cart);
			Response res = Utility.success.apply(cart.getCartId(), "Successfully registered with us");
			res.setPayload(Utility.getPayload.apply(cart));
			return res;
		}catch(NullPointerException e) {
			e.printStackTrace();
			return Utility.failure.apply(cart.getPhNo(), e.getMessage());
		}
	}

}
