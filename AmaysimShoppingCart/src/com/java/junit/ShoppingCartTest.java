package com.java.junit;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.java.context.ShoppingCart;
import com.java.promos.PricingUltLargePromo;
import com.java.promos.PricingUltSmallPromo;

public class ShoppingCartTest {
   
	double price;
	
	@Test
	public void testCalculatePromoUltSmall() throws ParseException {
	    
		PricingUltSmallPromo pricing = new PricingUltSmallPromo();
		int qty = 3;

		if (qty == 3) {
			price = pricing.doCalculatePromo(qty, 24.9);
			assertEquals("49.8", String.valueOf(price));
		} 
	}
	
	@Test
	public void testCalculatePromoUltLarge() throws ParseException {
		
		PricingUltLargePromo pricing = new PricingUltLargePromo();
		int qty = 5;
		
		if(qty > 3) {
			price = pricing.doCalculatePromo(qty, 44.9);
			assertEquals("199.5", String.valueOf(price));
		}
	}

	@Test
	public void testCalculateOtherPromo() throws ParseException {
	
		ShoppingCart pricing = new ShoppingCart();
		
        int cnt_5GB = 1;
        int cnt_2GB = 1;
        int cnt_Datapack = 0;
        int cnt_1GB = 1;

        price = pricing.calculateQuantityWithPrice(price, cnt_5GB, cnt_2GB, cnt_Datapack, cnt_1GB);
		assertEquals("99.7", String.valueOf(price));
		
		
	}
}
