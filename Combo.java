import java.util.*;
import java.io.*;

public class Combo
{
	private int comboNumber, order;
	private String comboName;
	private double comboPrice;
	private static double totalComboPrice=0;
	
	public Combo()
	{}
	
	public Combo(int a, String b, double c)
	{	
		comboNumber = a;
		comboName = b;
		comboPrice = c;
	}
	
	public void setComboNumber(int x)
	{
		comboNumber = x;
	}
	
	public int getComboNumber()
	{
		return comboNumber;
	}
	
	public void setComboName(String x)
	{
		comboName = x;
	}
	
	public String getComboName()
	{
		return comboName;
	}
	
	public void setComboPrice(double x)
	{
		comboPrice = x;
	}
	
	public double getComboPrice()
	{
		return comboPrice;
	}
	
	public void determineCombo(int cn)
	{
		if (cn==1)
		{
			comboNumber = 1;
			comboName = "Popcorn + Soft Drink";
			comboPrice = 8.5;
		}
		else if (cn==2)
		{
			comboNumber = 2;
			comboName = "Hotdog Sandwich + Soft Drink";
			comboPrice = 7.7;
		}
		else if (cn==3)
		{
			comboNumber = 3;
			comboName = "Potato Chips + Soft Drink";
			comboPrice = 7.1;			
		}
		else if (cn==4)
		{
			comboNumber = 4;
			comboName = "Popcorn + Hotdog Sandwich + 2 Soft Drinks";
			comboPrice = 14.6;
		}
		else if (cn==5)
		{
			comboNumber = 5;
			comboName = "Hotdog Sandwich + Potato Chips + 2 Soft Drinks";
			comboPrice = 13.8;
		}
		else if (cn==6)
		{
			comboNumber = 6;
			comboName = "Popcorn + Potato Chips + 2 Soft Drinks";
			comboPrice = 14.2;
		}
	}
	
	public void displayCombo()
	{
		System.out.println();
		System.out.println("Thank you for buying the snack combo. The selected snack combo is displayed as below: ");
		System.out.println("Combo number: " + getComboNumber());
		System.out.println("Combo name: " + getComboName());
		System.out.print("Combo price: RM ");
		System.out.printf("%.2f", getComboPrice());
		System.out.println();
		System.out.println();
		totalComboPrice += comboPrice;
	}
	
	public static void displayTotalComboPrice()
	{
		System.out.println("Thank you.");
		System.out.print("The total combo price is RM ");
		System.out.printf("%.2f", getTotalComboPrice());
		System.out.println();
		System.out.println();
	}
	
	public static double getTotalComboPrice()
	{
		return totalComboPrice;
	}
	
	public static void main (String [] args)
	{
		int comboNumber;
		String comboName;
		double comboPrice;
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t\t\t------------------");
		System.out.println("\t\t\t| GDC Combo Menu |");
		System.out.println("\t\t\t------------------");
		System.out.println();
		System.out.println("\t\tCombo\t\t\t\t\tPrice (RM)");
		System.out.println();
		System.out.println("1. Popcorn + Soft Drink\t\t\t\t\t8.50");
		System.out.println("2. Hotdog Sandwich + Soft Drink\t\t\t\t7.70");
		System.out.println("3. Potato Chips + Soft Drink\t\t\t\t7.10");
		System.out.println("4. Popcorn + Hotdog Sandwich + 2 Soft Drinks\t\t14.60");
		System.out.println("5. Hotdog Sandwich + Potato Chips + 2 Soft Drinks\t13.80");
		System.out.println("6. Popcorn + Potato Chips + 2 Soft Drinks\t\t14.20");
		System.out.println("0. Skip to proceed payment");
		System.out.println();
		System.out.print("Entry: ");
		comboNumber = in.nextInt();
		
		Combo c = new Combo();
		
		while(comboNumber!=0)
		{
			c.determineCombo(comboNumber);
			c.displayCombo();
			System.out.println("Add on combo? Enter the next combo, otherwise press 0 to proceed.");
			System.out.print("Entry: ");
			comboNumber = in.nextInt();
			System.out.println();
		}
		
		c.displayTotalComboPrice();
	}
	
}

