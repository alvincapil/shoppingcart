package com.java.products;

public class Products {
	
	 private String productName;
	 private double price;
     private String promoCode;
	 
	 public Products(String productName, double price, String promoCode){
		  this.productName = productName;
		  this.price = price;
		  this.promoCode = promoCode;
	 }
	
	 public String getProductName(){
		 return productName;
	 }
	 
	 public double getPrice(){
		 return price;
	 }
	 
	 public String getPromoCode(){
		 return promoCode;
	 }

}
