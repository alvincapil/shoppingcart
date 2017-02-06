package com.java.products;

import java.util.List;

public class ProductCounter {
	
	private int cnt_1GB;
	private int cnt_2GB;
	private int cnt_5GB;
	private int cnt_Datapack;
	private int cnt_PromoCode;
	
	public int countUlt1Gb (List<Products> listProducts){
		for(Products product: listProducts){
			if("Unlimited 1GB".equalsIgnoreCase(product.getProductName())){
				    cnt_1GB++;
			}
		}
          return cnt_1GB;        		
	}

	public int countUlt2Gb (List<Products> listProducts){
		for(Products product: listProducts){
			if("Unlimited 2GB".equalsIgnoreCase(product.getProductName())){
				    cnt_2GB++;
			}
		}
          return cnt_2GB;        		
	}
	
	public int countUlt5Gb (List<Products> listProducts){
		for(Products product: listProducts){
			if("Unlimited 5GB".equalsIgnoreCase(product.getProductName())){
				    cnt_5GB++;
			}
		}
          return cnt_5GB;        		
	}
	
	public int countDatapack (List<Products> listProducts){
		for(Products product: listProducts){
			if("1 GB Data-pack".equalsIgnoreCase(product.getProductName())){
				cnt_Datapack++;
			}
		}
          return cnt_Datapack;        		
	}	
	
	public int countPromoCode (List<Products> listProducts){
		for(Products product: listProducts){
			if("I<3AMAYSIM".equalsIgnoreCase(product.getPromoCode())){
				    cnt_PromoCode++;
			}
		}
          return cnt_PromoCode;        		
	}
}
