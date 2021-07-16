package ewallet.sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		FileManager fm = new FileManager();
		ArrayList<User> userList = new ArrayList<User>();
		String dirpath = System.getenv("user.home") + File.separator +  "Desktop";
		ArrayList<JSONObject> inputList = new ArrayList<JSONObject>();
		
		try {
			fm.createFolderFiles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		fm.createFolderFiles();
		inputList = fm.readInput(console.nextLine());
		
		if (inputList.contains("transferee")) {
			
		} else if (inputList.contains("transactions")) {
			
		} else {

		}
	}

}
