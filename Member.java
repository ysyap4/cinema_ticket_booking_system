// Membership

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Member extends Customer{
	private boolean status;

	public Member(){
		status=false;
	}

	public boolean ValidateMembership()throws IOException{
		Scanner in=new Scanner(System.in);
				String ic,lname;
				boolean status=false;

					try {
					File file = new File("Membership.txt");
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					StringBuffer stringBuffer = new StringBuffer();
					String[] line=new String[80];
					int i=0,count;

					while ((line[i] = bufferedReader.readLine()) != null) {
						stringBuffer.append(line[i]);
					//	stringBuffer.append("\n");
					//	System.out.println(line[i]);
						i++;
					}
					count=i;

					System.out.println("Please sign up as member to get discount. \n1) Sign in  \n2) Sign up \n3) Continue as member");
					System.out.print("Enter your option: ");

					Scanner input = new Scanner(System.in);
					int c = input.nextInt();

					if(c ==1){

						System.out.print("Enter IC number:");
						ic=in.next();

					//	System.out.println(ic);
						i=0;

							while(ic!=line[i]&&count!=i){
								if(ic.equals(line[i])){
								status=true;
								System.out.println("\n\n Welcome, " + line[i-2]);
								break;
							}
								i++;
							}

						if(status==false){

							System.out.println("Your IC number is not registered. Please sign up first.");
							Member s=new Member();
							s.ValidateMembership();
						}

						//System.out.println("Status:" + status);

						fileReader.close();
					}

					else if(c==2){

						Member s = new Member();
						s.signup();
						s.ValidateMembership();
					}

					else{
						System.out.print("You choose to continue as member.");
					}

				//	System.out.println("Contents of file:");
				//	System.out.println(stringBuffer.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
		return status;
	}

}