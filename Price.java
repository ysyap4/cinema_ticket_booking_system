import java.util.*;
import java.io.*;


public class Price
{
	private double ticketPrice;
	private double comboPrice;
	private double membershipDiscount;
	private double totalPrice;
	
	public Price()
	{}
	
	public Price(double a, double b, double c)
	{
		ticketPrice = a;
		comboPrice = b;
		membershipDiscount = c;
	}
	
	public double calculateTotalPrice()
	{
		totalPrice = (ticketPrice*membershipDiscount) + comboPrice;
		
		return totalPrice;
	}
	
	
	public static void main(String [] args)
	{

		
	}
}