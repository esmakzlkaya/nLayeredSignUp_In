package nLayeredSignUp_Login.consoleUI;

import java.util.ArrayList;
import nLayeredSignUp_Login.business.concretes.UserManager;
import nLayeredSignUp_Login.core.authentication.GoogleAuthManagerAdapter;
import nLayeredSignUp_Login.dataAccess.concretes.HibernateUserDao;
import nLayeredSignUp_Login.entities.concretes.User;
import nLayeredSignUp_Login.googleAuth.GoogleAuthManager;



public class Main {

	public static void main(String[] args) {
		User user=new User(1,"Esma","Kýzýlkaya","esmakzlkaya@gmail.com","123456");
		ArrayList<User> users = new ArrayList<User>();
		//users.add(user);
		UserManager userManager=new UserManager(new HibernateUserDao(users));
		GoogleAuthManagerAdapter googleAuthManagerAdapter=new GoogleAuthManagerAdapter(new GoogleAuthManager());
		//userManager.register(user);
		//userManager.signIn(user);
		
		//googleAuthManagerAdapter.register(user);
		googleAuthManagerAdapter.login(user);
	}

}
