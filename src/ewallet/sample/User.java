package ewallet.sample;

public class User {
	static String email = new String();
	static double credits;
	
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
	
	public static void newUser(String mail) {
		email = mail;
		credits = 10000.0;
	}

}
