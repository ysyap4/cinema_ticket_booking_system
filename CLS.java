import java.util.*;
import java.io.*;

public class CLS{
	public static void main(String[]args)throws IOException, InterruptedException{
		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
	}