package nLayeredSignUp_Login.core.authentication;

import nLayeredSignUp_Login.entities.concretes.User;

public interface AuthService {

	void register(User user);
	void login(User user);
}
