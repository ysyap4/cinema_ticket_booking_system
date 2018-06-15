//Customer info

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Customer {

	private String fname;
	private String lname;
	private String icNo;
	private String telNo;
	private char gender;

	public Customer(){

		fname = " ";
		lname = " ";
		icNo = " ";
		telNo = " ";
		gender = ' ';
	}

	public Customer(String fname, String lname, String icNo, String telNo, char gender){

		this.fname = fname;
		this.lname = lname;
		this.icNo = icNo;
		this.telNo = telNo;
		this.gender = gender;
	}

	public String getFirstName(){ return fname; }
	public String getLastName(){ return lname; }
	public String getIcNo(){ return icNo; }
	public String getTelNo(){ return telNo; }

	public void signup() {

		try{

			File file = new File("Membership.txt");

			if(!file.exists()){ file.createNewFile();
			}

			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			Scanner input = new Scanner(System.in);

			System.out.print("Please enter First name : ");
			String fn = input.nextLine();
			pw.println(fn);

			System.out.print("Please enter Last name : ");
			String ln = input.nextLine();
			pw.println(ln);

			System.out.print("Please enter IC Number (without '-' ) : ");
			String ic = input.nextLine();
			pw.println(ic);

			System.out.print("Please enter Mobile Phone Number (without '-' ) : ");
			String tel = input.nextLine();
			pw.println(tel);

			System.out.print("Please enter character for gender.\n(Press M = Male) or (Press F = Female) : ");
			char g = input.next().charAt(0);
			pw.println(g);
			pw.println("\n");
			pw.close();

			Customer m = new Customer(fn,ln,ic,tel,g);
			m.display();

		}catch(IOException ioe){

			System.out.println("Exception occured: ");
			ioe.printStackTrace();
		}
	}

	public double memberDisc (boolean s){

	double disc;

	if(s==true) disc = 0.90;
	else{
		disc = 1;
	}

	return disc;
	}

	public void display(){

		System.out.println("\n\t\t Thank you for registering as a Member.\n");
		System.out.println("\t\t Here is your details for your member card : \n");
		System.out.println("\n\t\t _____________________________________________\n");
		System.out.println("\t\t _____________________________________________\n");
		System.out.println("\t\t       Name      	  : " + getFirstName() + " " + getLastName());
		System.out.println("\t\t       IC Number 	  : " + getIcNo());
		System.out.println("\n\t\t _____________________________________________\n");
		System.out.println(" \t\t _____________________________________________\n");
	}
}

/*
public class Customer {

	public static void main(String[] args){



	}
}

*/