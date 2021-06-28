package ewallet.sample;

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
