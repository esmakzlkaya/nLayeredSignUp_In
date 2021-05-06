package nLayeredSignUp_Login.dataAccess.abstracts;

import nLayeredSignUp_Login.entities.concretes.User;

public interface UserDao {

	void register(User user);
	void signIn(User user);
	void update(User user);
	void delete(User user);
	User getByMail(String mail);
}
