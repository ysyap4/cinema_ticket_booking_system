import java.util.*;
import java.io.*;
public class Test{
	public static void main(String[]args) throws IOException{
			Scanner in=new Scanner(System.in);
			System.out.println("Enter row(A-H) and Seat number(1-10):");
			String crow=in.nextLine();
			int row=Character.getNumericValue(crow.charAt(0));
			row=row-10;
			int col=Character.getNumericValue(crow.charAt(1));
			System.out.println("R:"+row+"\nC:"+col);
			/*Scanner in=new Scanner(System.in);
			String s="Marvel's Captain America Civil War";
			String t=".txt";
			String f=s+t;
			File file = new File(f);
			PrintWriter fout = new PrintWriter(new FileWriter(file,true));
			Scanner fin=new Scanner(new File(f));
			int row=0,col=0;
					String [][]seat= new String[8][11];
							seat[0][0]="A";
							seat[1][0]="B";
							seat[2][0]="C";
							seat[3][0]="D";
							seat[4][0]="E";
							seat[5][0]="F";
							seat[6][0]="G";
							seat[7][0]="H";

							for(int r=0;r<8;r++){
								for(int c=1;c<11;c++){
									seat[r][c]="[ ]";
									}
								}

							int[] temp=new int[80];
							int n=0;
							while(fin.hasNextInt()){
									temp[n]=fin.nextInt();
									n++;
								}

							for(int i=0;i<n;i++){
								//System.out.println(temp[i]);
								if(i%2==0)row=temp[i];
								else {
									col=temp[i];
									seat[row][col]="[X]";
									}
							}

							for(int i=0;i<10;i++)System.out.print("   "+(i+1));
							System.out.println();
							for(int r=0;r<8;r++){
								for(int c=0;c<11;c++){
									System.out.print(seat[r][c]+" ");
								}
								System.out.println();
							}
							System.out.println("How many ticket?:");
							int noTicket=in.nextInt();

							int num=0;
							while(num<noTicket){
							System.out.println("Enter row(A-H):");
							char crow=in.next().charAt(0);
							System.out.println(crow);
							row = Character.getNumericValue(crow);
							row=row-10;
							System.out.println(row);
							System.out.println("Enter number of seat:");
							col=in.nextInt();

							if(seat[row][col]=="[X]"){
								System.out.println("The seat you entered has already been booked, please select a new seat");
								continue;
							}

							fout.write(" ");
							fout.write(String.valueOf(row+1));
							fout.write(" ");
							fout.write(String.valueOf(col));

							seat[row][col]="[X]";
							num++;
							}

							for(int i=0;i<10;i++)System.out.print("   "+(i+1));
									System.out.println();
									for(int r=0;r<8;r++){
										for(int c=0;c<11;c++){
											System.out.print(seat[r][c]+" ");
										}
										System.out.println();
					}

					fout.flush();
					fout.close();*/


		/*String s="E4";
		char first = s.charAt(0);
		char second = s.charAt(1);
		int v=Character.getNumericValue(second);
		System.out.println("Value:" + v);*/
		}
	}