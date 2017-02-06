package com.java.context;

import java.text.ParseException;

import com.java.products.ProductCounter;
import com.java.products.Products;
import com.java.promos.PricingUltLargePromo;
import com.java.promos.PricingUltSmallPromo;

public class RunShoppingCart {
	
	public static void main (String args[]) throws ParseException {
		 
		 Products item1 = new Products("Unlimited 1GB", 24.90, "");
		 Products item2 = new Products("Unlimited 1GB", 24.90, "");
		 Products item3 = new Products("Unlimited 1GB", 24.90, "");
		 Products item4 = new Products("Unlimited 2GB", 29.90, "");
		 Products item5 = new Products("Unlimited 5GB", 44.90, "");
		 Products item6 = new Products("Unlimited 5GB", 44.90, "");
		 
	     ShoppingCart shopCart = new ShoppingCart();
	     ProductCounter count = new ProductCounter();
	     
	     shopCart.addProducts(item1);
	     shopCart.addProducts(item2);
	     shopCart.addProducts(item3);
	     shopCart.addProducts(item4);
	     shopCart.addProducts(item5);
	     shopCart.addProducts(item6);
	     shopCart.calculateQuantity();
	     
	     if(count.countUlt1Gb(shopCart.getListProducts()) == 3){
	    	 shopCart.calculatePrice(new PricingUltSmallPromo());
	     }
	     else if(count.countUlt5Gb(shopCart.getListProducts()) > 3) {
	    	 shopCart.calculatePrice(new PricingUltLargePromo());
	     }
	     else{
	    	 shopCart.calculateOtherPromo(count.countPromoCode(shopCart.getListProducts()));
	     }
	}

}
