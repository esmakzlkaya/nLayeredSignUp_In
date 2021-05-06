package nLayeredSignUp_Login.googleAuth;

import nLayeredSignUp_Login.entities.concretes.User;

public class GoogleAuthManager {

	public void register(User user) {
		System.out.println("Google ile kaydedildi : "+user.getFirstName());
	}
	
	public void login(User user) {
		System.out.println("Google ile giriþ yapýldý : "+user.getFirstName());
	}
}
