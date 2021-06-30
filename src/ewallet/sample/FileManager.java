package ewallet.sample;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileManager {

	public ArrayList<User> readDataFile(String file) {
		JSONParser jsonParser = new JSONParser();
		ArrayList<User> userList = new ArrayList<User>();
		
		try (FileReader reader = new FileReader(file)) {
			
			Object obj = jsonParser.parse(reader);
			JSONArray jsonUserList = (JSONArray) obj;
			if (jsonUserList != null) {
				for (int i= 0; i<jsonUserList.size(); i++) {
					userList.add(parseUserObject(jsonUserList.get(i)));
				}
			}
						
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return userList;				
	}
	
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
	
	public ArrayList<String> readInput(String file) {
		JSONParser jsonParser = new JSONParser();
		ArrayList<String> dataList = new ArrayList<String>();
		
		try (FileReader reader = new FileReader(file)) {
			
			Object obj = jsonParser.parse(reader);
			JSONArray jsonDataList = (JSONArray) obj;
			if (jsonDataList != null) {
				
			}			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return dataList;
	}
	
	private static User parseUserObject(Object object) {
		JSONObject userObj = (JSONObject) object;
		User thisUser = new User();
		//Set User Email
		String email = (String) userObj.get("email");
		User.setUserEmail(email);
		
		//Set User Credits
		double credits = (double) userObj.get("balance");
		User.setUserCredit(credits);
		
		return thisUser;
	}
	
}
