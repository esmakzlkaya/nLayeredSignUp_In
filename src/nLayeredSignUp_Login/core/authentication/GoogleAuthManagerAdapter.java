package nLayeredSignUp_Login.core.authentication;

import nLayeredSignUp_Login.entities.concretes.User;
import nLayeredSignUp_Login.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService {

	private GoogleAuthManager googleAuthManager;
	
	public GoogleAuthManagerAdapter(GoogleAuthManager googleAuthManager) {
		super();
		this.googleAuthManager = googleAuthManager;
	}

	@Override
	public void register(User user) {
		googleAuthManager.register(user);
		
	}

	@Override
	public void login(User user) {
		googleAuthManager.login(user);
		
	}

}
