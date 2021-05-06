package nLayeredSignUp_Login.business.abstracts;

import nLayeredSignUp_Login.entities.concretes.User;

public interface UserService {

	void register(User user);
	void signIn(User user);
	void update(User user);
	void delete(User user);
	User getByMail(String mail);
}
