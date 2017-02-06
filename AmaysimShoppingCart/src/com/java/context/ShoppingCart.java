package com.java.context;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.java.products.ProductCounter;
import com.java.products.Products;
import com.java.promos.PricingRules;

public class ShoppingCart {
 
	List<Products> listProducts;
	
	static int cnt_1GB;
	static int cnt_2GB;
	static int cnt_5GB;
	static int cnt_Datapack;
	static int cnt_promoCode;
	
	static double PRICE_ULT_1GB = 24.90;
	static double PRICE_ULT_2GB = 29.90; 
	static double PRICE_ULT_5GB = 44.90;
	static double PRICE_DATAPACK_1GB = 9.90;
	static double price;
	static double totalPrice;
	static double discount = 0.00;
	static double discountValue;
	
	public ShoppingCart(){
		this.listProducts = new ArrayList<Products>();
	}
	
	public void addProducts(Products products){
		this.listProducts.add(products);
	}
	
	public void calculatePrice(PricingRules pricingRules) throws ParseException{
		
		ProductCounter pcount = new ProductCounter();		
		
		cnt_1GB = pcount.countUlt1Gb(listProducts);
		cnt_2GB = pcount.countUlt2Gb(listProducts);
		cnt_5GB = pcount.countUlt5Gb(listProducts);
		cnt_Datapack = pcount.countDatapack(listProducts);
		cnt_promoCode = pcount.countPromoCode(listProducts);
		
		
		if(cnt_promoCode !=0) {
			discount = 0.10;
		}
		
		if(cnt_1GB == 3){
			price = pricingRules.doCalculatePromo(cnt_1GB, PRICE_ULT_1GB);
			discountValue = calculateQuantityWithPrice(price, cnt_5GB, cnt_2GB, cnt_Datapack, cnt_1GB) * discount;
			totalPrice = calculateQuantityWithPrice(price, cnt_5GB, cnt_2GB, cnt_Datapack, cnt_1GB) - discountValue;
			System.out.println("Expected Cart Total :" + totalPrice);
		}
		if(cnt_5GB > 3){
			price = pricingRules.doCalculatePromo(cnt_5GB, PRICE_ULT_5GB);
			discountValue = calculateQuantityWithPrice(price, cnt_5GB, cnt_2GB, cnt_Datapack, cnt_1GB) * discount;
			totalPrice = calculateQuantityWithPrice(price, cnt_5GB, cnt_2GB, cnt_Datapack, cnt_1GB) - discountValue;
			System.out.println("Expected Cart Total :" + totalPrice);
		}	
	}

	public void calculateOtherPromo(int cntPromoCode) throws ParseException {
		
		if(cntPromoCode != 0){
			discount = 0.10;
			discountValue = calculateQuantityWithPrice(price, cnt_5GB, cnt_2GB, cnt_Datapack, cnt_1GB) * discount;
			totalPrice = calculateQuantityWithPrice(price, cnt_5GB, cnt_2GB, cnt_Datapack, cnt_1GB) - discountValue;
		    System.out.println("Expected Cart Total :" + totalPrice);
		} else {
		    totalPrice = calculateQuantityWithPrice(price, cnt_5GB, cnt_2GB, cnt_Datapack, cnt_1GB);
		    System.out.println("Expected Cart Total :" + totalPrice);
			
		}
	}
	
	public void calculateQuantity() {
		
		StringBuilder sb = new StringBuilder();
		ProductCounter pcount = new ProductCounter();
		
		cnt_1GB = pcount.countUlt1Gb(listProducts);
		cnt_2GB = pcount.countUlt2Gb(listProducts);
		cnt_5GB = pcount.countUlt5Gb(listProducts);
		cnt_Datapack = pcount.countDatapack(listProducts);
        
		if(cnt_2GB != 0){
			cnt_Datapack = cnt_2GB;
		}
	    if(cnt_1GB != 0){
	    	sb.append("[" + cnt_1GB+" x 1GB] ");
	    }
	    if(cnt_2GB != 0){
	    	sb.append("[" + cnt_2GB+" x 2GB] ");
	    }
	    if(cnt_5GB != 0){
	    	sb.append("[" + cnt_5GB+" x 5GB] ");
	    }
	    if(cnt_Datapack != 0 && cnt_2GB != 0){
	    	sb.append("[" + cnt_Datapack+" x FREE 1GB DATAPACK]" );
	    } else {
	    	sb.append("[" + cnt_Datapack+" x 1GB DATAPACK]" );
	    }
	    
	    
        System.out.println("ITEMS ADDED: " + sb); 			
		
	}
	
	public double calculateQuantityWithPrice(double price, int cnt_5GB, int cnt_2GB, 
								int cnt_Datapack, int cnt_1GB) throws ParseException {
	       
		   DecimalFormat df = new DecimalFormat("0.00");
		   String formattedPrice;
		
		   if(cnt_1GB != 0 && cnt_1GB != 3){
				   price = price + (cnt_1GB * PRICE_ULT_1GB);
	       }
		   
		   if(cnt_5GB != 0 && cnt_5GB <= 3){
				   price  = price + (cnt_5GB * PRICE_ULT_5GB);
		   }
		   
		   if(cnt_2GB != 0){
			       cnt_Datapack = 0;
				   price = price +  (cnt_2GB * PRICE_ULT_2GB);
			   
		   }
		   
		   if(cnt_Datapack != 0){
				   price = price + (cnt_Datapack * PRICE_DATAPACK_1GB);
		   }
		   
		   formattedPrice = df.format(price);

		   return (Double)df.parse(formattedPrice);
	
	}

	public List<Products> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Products> listProducts) {
		this.listProducts = listProducts;
	}
	
	
	
}
