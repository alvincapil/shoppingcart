package com.java.promos;

import java.text.DecimalFormat;
import java.text.ParseException;

public class PricingUltLargePromo implements PricingRules{

	@Override
	public double doCalculatePromo(int quantity, double price) throws ParseException {

		double totalPrice;
		String formatTotalPrice;
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		price = price - 5;
		totalPrice = quantity * price;
		formatTotalPrice = df.format(totalPrice);
		
		return (double)df.parse(formatTotalPrice);

   }
}
