package com.java.promos;

import java.text.DecimalFormat;
import java.text.ParseException;

public class PricingUltSmallPromo implements PricingRules{

	@Override
	public double doCalculatePromo(int quantity, double price) 
			throws ParseException {
		
		double totalPrice;
		String formatTotalPrice;
		
		DecimalFormat df = new DecimalFormat("0.00");
	
		totalPrice = 2 * price;
		formatTotalPrice = df.format(totalPrice);
		return (Double)df.parse(formatTotalPrice);
		
	}

}
