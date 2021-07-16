package ewallet.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileManager {

	public void createFolderFiles() throws IOException {
		File desktop = new File(System.getProperty("user.home") + File.separator +  "Desktop");
		File folder = new File(desktop, "ewallet");
		File userfile = new File(folder, "users.json");
		File transactionfile = new File(folder, "transactions.json");
		if (!folder.exists()) {
			folder.mkdir();		
			userfile.createNewFile();
			transactionfile.createNewFile();
		}
	}
	
	public ArrayList<JSONObject> readDataInput(String file) {
		JSONParser jsonParser = new JSONParser();
		ArrayList<JSONObject> dataList = new ArrayList<JSONObject>();
		
		JSONArray a;
		try {
			a = (JSONArray) jsonParser.parse(new FileReader(file));
			for (Object o : a) {
				JSONObject data = (JSONObject) o;
				dataList.add(data);
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}
	
	public JSONObject readInput(String file) {
		JSONParser jsonParser = new JSONParser();
		
		JSONObject a = null;
		try {
			a = (JSONObject) jsonParser.parse(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;		
	}
	/*
	private static User parseUserObject(Object object) {
		JSONObject userObj = (JSONObject) object;
		
		//Set User Email
		String email = (String) userObj.get("email");
		User.setUserEmail(email);
		
		//Set User Credits
		double credits = (double) userObj.get("balance");
		User.setUserCredit(credits);
		
		return thisUser;
	}
	*/
}
