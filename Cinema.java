import java.util.*;
import java.io.*;

class Ticket extends Member{
	private int hall,movie,time,noTicket;
	private String[] seatNo=new String[80]; //seatNo used as array to hold multiple tickets for one person
	private double seatPrice;
	private static double totalSeatPrice;

	public Ticket(){
		movie=0;
		time=0;
		for(int i=0;i<80;i++)seatNo[i]=""; //assign value to the array
	}

	public Ticket(int m,int t){
		movie=m;
		time=t;
		for(int i=0;i<80;i++)seatNo[i]=""; //assign value to the array
	}

	public void setMovie(int m){
		movie=m;
	}

	public void setTime(int t){
		time=t;
	}

	public void setHall(int h){
		hall=h;
	}

	public int getNo(){
		return noTicket;
	}

	public static double getTotalSeatPrice()
	{
		return totalSeatPrice;
	}

	//use to get movie name
	public String getMovie(){
		switch(movie){
			case 1: return "Marvel's Captain America Civil War";
			case 2: return "XMen Apocalypse";
			case 3: return "The Jungle Book";
			default: return "Invalid Movie";
				}
			}
	//get time in string
	public String getTime(){
		switch(time){
			case 1: return "11:00am";
			case 2: return "2:00pm";
			case 3: return "8:00pm";
			default: return "Invalid Time";
			}
		}

	public int getHall(){
		return movie+(time-1);
		}

	//return the movie, time, hall, and number of seat
	public String toString(int i){

		totalSeatPrice += seatPrice;

		return 	"==============================================" +
				"\nMovie: " + this.getMovie() +
				"\nTime:  " + this.getTime() +
				"\nHall:  " + this.getHall() +
				"\nSeat:  " + seatNo[i] +
				"\nPrice:  RM" + seatPrice +
				"\n==============================================";
		}

	//used to book seats in the cinema
	public int bookSeat() throws IOException
		{

					Scanner in=new Scanner(System.in);
					String f1,f2=String.valueOf(time),f3=".txt";	//the filename is according to the selected movie and time
					f1=this.getMovie();
					String f=f1+f2+f3;
					File file = new File(f);	//create the file
					PrintWriter fout = new PrintWriter(new FileWriter(file,true));	//booked seats is sent here
					Scanner fin=new Scanner(new File(f));	//used for retrieving the booked seats

				try{
					int row=0,col=0;

							String [][]seat= new String[8][11];//declare double dimension array for the seats
									//assign the alphabet row for the first columns
									seat[0][0]="A";
									seat[1][0]="B";
									seat[2][0]="C";
									seat[3][0]="D";
									seat[4][0]="E";
									seat[5][0]="F";
									seat[6][0]="G";
									seat[7][0]="H";

									//every seat is assign as empty as first [ ]
									for(int r=0;r<8;r++){
										for(int c=1;c<11;c++){
											seat[r][c]="[ ]";
											}
										}

									int[] temp=new int[80];	//use to hold the data retrieve from file
									int n=0;
									while(fin.hasNextInt()){
											temp[n]=fin.nextInt();
											n++;
										}

									//here all the retrieved booked seats is assign to the seat that will be display
									for(int i=0;i<n;i++){
										//System.out.println(temp[i]);
										if(i%2==0)row=(temp[i]-1);
										else {
											col=temp[i];
											seat[row][col]="[X]";
											}
									}
									System.out.println("================= Movie Screen =================");
									System.out.println("|                                              |");
									//display the taken seats
									System.out.print("|  ");
									for(int i=0;i<10;i++)System.out.print("   "+(i+1));
									System.out.print("   |");
									System.out.println();
									for(int r=0;r<8;r++){
										System.out.print("|  ");
										for(int c=0;c<11;c++){
											System.out.print(seat[r][c]+" ");
										}
										System.out.print("  |");
										System.out.println();
									}
									System.out.println("|                                              |");
									System.out.println("------------------------------------------------");
									System.out.println("How many ticket? (Enter 0 to go back):");
									noTicket=in.nextInt();
									if(noTicket==0)return 0;	//return 0 if user choose to go back to the movie menu

									int num=0;
									while(num<noTicket){
											System.out.println("Enter row(A-H) and seat number(1-10):");
											String crow=in.next();
											row=Character.getNumericValue(crow.charAt(0));
											row=row-10;
											if ((((row==0)||(row==1))||(row==2))||(row==3))
											{
												seatPrice = 15.0;
											}
											else
											{
												seatPrice = 17.0;
											}

											if(crow.length()==2)
											col=Character.getNumericValue(crow.charAt(1));
											if(crow.length()==3)
			 								col=Character.getNumericValue(crow.charAt(1))+9;

											/*char crow=in.next().charAt(0);
											row = Character.getNumericValue(crow);
											row=row-10;
											System.out.println("Enter number of seat(1-10):");
											col=in.nextInt();
											*/
											//seatNo[num]=String.valueOf(crow)+String.valueOf(col);
											seatNo[num]=crow;

											//user is prompt to choose again if seat is taken
											if(seat[row][col]=="[X]"){
												System.out.println("The seat you entered has already been booked, please select a new seat");
												continue;
											}

											//booked seat is send to the file respectively
											fout.write(" ");
											fout.write(String.valueOf(row+1));
											fout.write(" ");
											fout.write(String.valueOf(col));

											seat[row][col]="[X]";
											num++;
									}

									//display booked seats
									System.out.println();
									System.out.println("================= Movie Screen =================");
									System.out.println("|                                              |");
									System.out.print("|  ");
									for(int i=0;i<10;i++)System.out.print("   "+(i+1));
											System.out.print("   |");
											System.out.println();
											for(int r=0;r<8;r++){
												System.out.print("|  ");
												for(int c=0;c<11;c++){
													System.out.print(seat[r][c]+" ");
												}
												System.out.print("  |");
												System.out.println();
											}
									System.out.println("|                                              |");
									System.out.println("------------------------------------------------");
									System.out.println("The seat(s) have been booked successfully.");
									System.out.println("The movie ticket(s) can be printed as below.");
									System.out.println();
									System.out.println();
									System.out.println("--------------- Movie Ticket -----------------");

						} catch (NumberFormatException e) {
							System.err.println("Caught NumberFormatException: "
											   + e.getMessage());

						} catch (ArithmeticException e) {
							System.err.println("Caught ArithmeticException: "
											   + e.getMessage());

						}finally {
							if (fout != null) {
								fout.flush();
								fout.close();
							}
							else {
								System.out.println("Invalid Selection");
							}
						}
						return 1;	//return 1 if user did not choose to go back to the movie menu
					}

	}



/*
class Seat{
	private int row,column;
	private String bSeat;

	public Seat(String s){
		bSeat=s
		}

	public void setRow(){
		char r = bSeat.charAt(0);
		switch(r){
			case 'A': row=0;
				break;
			case 'B': row=1;
				break;
			case 'C': row=2;
				break;
			case 'D': row=3;
				break;
			case 'E': row=4;
				break;
			case 'F': row=5;
				break;
			case 'G': row=6;
				break;
			case 'H': row=7;
				break;
			default: row=NULL;
				break;
			}
		}

	public void setColumn(){
		char c = bSeat.charAt(1);
		column = Character.getNumericalValue(c);
		}

	*/



public class Cinema extends Member{
	public static void main(String []args)throws IOException{
		boolean validate;
		double discount=0.9;
		Ticket test=new Ticket();
		validate=test.ValidateMembership();
		if(validate==true){

			discount=0.9;
		}
		int m,t,back=0;
		try{
		while(back==0){	//loop back to main menu while user ask to go back to movie menu
		Scanner in=new Scanner(System.in);
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("|  GALAXY DEFINITION SCREEN (GDC) CINEMA  |");
		System.out.println("-------------------------------------------");
		System.out.println();
		System.out.println("Select the movie:");
		System.out.println("1. Marvel's Captain America: Civil War");
		System.out.println("2. X-men Apocalypse");
		System.out.println("3. The JungleBook");
		System.out.println("0. Exit");
		System.out.print("Entry: ");
		m=in.nextInt();
		System.out.println();

		System.out.println("Select the time:");
		System.out.println("1. 11.00am");
		System.out.println("2. 2.00pm");
		System.out.println("3. 8.00pm");
		System.out.println("0. Return");
		System.out.print("Entry: ");
		t=in.nextInt();
		System.out.println();

		test.setMovie(m);
		test.setMovie(t);
		//Ticket test=new Ticket(m,t);

		back=test.bookSeat();

		for(int i=0;i<test.getNo();i++)
		{
			System.out.println(test.toString(i));
		}

		System.out.print("The total ticket price is RM");
		System.out.printf("%.2f", test.getTotalSeatPrice());
		System.out.println();

		int comboNumber;
		String comboName;
		double comboPrice;


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


		Price p = new Price(test.getTotalSeatPrice(), c.getTotalComboPrice(),discount);

		System.out.print("The OVERALL PRICE including ticket and snacks is RM");
		System.out.printf("%.2f", p.calculateTotalPrice());

		}


		}catch(NumberFormatException e){
			System.err.println("Caught NumberFormatException: "
											   + e.getMessage());
		}
	}
}