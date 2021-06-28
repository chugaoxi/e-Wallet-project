package ewallet.sample;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		FileManager fm = new FileManager();
		ArrayList<User> userList = new ArrayList<>();
		
		userList = fm.readDataFile(console.toString());
		
		
	}

}
