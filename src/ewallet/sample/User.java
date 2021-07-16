package ewallet.sample;

import org.json.simple.JSONObject;

public class User {
	static String email = new String();
	static double credits;
	
	public User(String email, double credits) {
		this.email = email;
		this.credits = credits;
	}
	
	public static String getUserEmail() {
		return email;		
	}
	
	public static double getUserCredit(String email) {
		return credits;
	}
	
	public static void setUserEmail(String newEmail) {
		email = newEmail;
	}
	
	public static void setUserCredit(double newCredits) {
		credits = newCredits;
	}
	
	public static JSONObject newUser(String email) {
		JSONObject user = new JSONObject();
		user.put("email", email);
		user.put("balance", 10000.0);
		return user;
		
	}

}
