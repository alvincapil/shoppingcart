package com.java.promos;

import java.text.ParseException;

public interface PricingRules {
	
	public double doCalculatePromo(int quantity, double price) 
			throws ParseException;
}
