package ewallet.sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		FileManager fm = new FileManager();
		ArrayList<User> userList = new ArrayList<User>();
		String dirpath = System.getenv("user.home") + File.separator +  "Desktop";
		ArrayList<String> inputList = new ArrayList<String>();
		
		try {
			fm.createFolderFiles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String userFile = dirpath + File.separator + "users.json";
		userList = fm.readDataFile(userFile);
		
		inputList = fm.readInput(console.nextLine());
		String email;
		
		if (inputList.contains("transferee")) {
			
		} else if (inputList.contains("transactions")) {
			
		} else {

		}
	}

}
