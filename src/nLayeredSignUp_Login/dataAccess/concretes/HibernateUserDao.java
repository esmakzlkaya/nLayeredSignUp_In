package nLayeredSignUp_Login.dataAccess.concretes;

import java.util.List;
import nLayeredSignUp_Login.dataAccess.abstracts.UserDao;
import nLayeredSignUp_Login.entities.concretes.User;


public class HibernateUserDao implements UserDao{
	private List<User> users;
	
	public HibernateUserDao(List<User> users) {
		super();
		this.users = users;
	}

	public void register(User user) {
		
		users.add(user);
		System.out.println("Kullan�c� kay�t ba�ar�l� : " +user.getFirstName());
		
	}

	public void signIn(User user) {
		System.out.println("Kullan�c� giri� ba�ar�l� : " +user.getFirstName());
		
	}

	public void update(User user) {
		System.out.println("Kullan�c� g�ncelleme ba�ar�l� : " +user.getFirstName());
		
	}

	public void delete(User user) {
		System.out.println("Kullan�c� silme ba�ar�l� : " +user.getFirstName());
		
	}
	
	public User getByMail(String mail) {
		if(users!=null) {
		for(User user:users) {
			if(user.getMail()==mail) {
				return user;
			}
		}
		}
		return null;
	}

}
