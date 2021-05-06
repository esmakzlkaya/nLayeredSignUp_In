package nLayeredSignUp_Login.business.concretes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nLayeredSignUp_Login.business.abstracts.UserService;
import nLayeredSignUp_Login.dataAccess.concretes.HibernateUserDao;
import nLayeredSignUp_Login.entities.concretes.User;


public class UserManager implements UserService{
	private HibernateUserDao dao;
	
	public UserManager(HibernateUserDao dao) {
		this.dao = dao;
	}

	public void register(User user) {
		if(!checkIfMailValid(user.getMail())) {
			System.out.println("Girilen email adresi ge�ersiz.");
		}
		if(!checkPassword(user.getPassword())) {
			System.out.println("Parola en az 6 karakterden olu�mal�d�r.");
		}
		if(!checkIfMailAvailable(user.getMail())) {
			System.out.println("Bu email zaten kullan�lmakta.");
		}if(!checkIfNameAndSurnameValid(user.getFirstName(),user.getLastName())) {
			System.out.println("�sim/Soyisim en az 2 karakterden olu�mal�d�r.");
		}
		dao.register(user);
		sendValidationMail(user);
		
		
	}

	private void sendValidationMail(User user) {
		System.out.println("Say�n "+user.getFirstName()+" "+user.getLastName()+" sisteme kayd�n�z� tamamlamak i�in l�tfen bu maili do�rulay�n�z. L�tfen Evet/Hay�r cevaplay�n�z.");
		Scanner input=new Scanner(System.in);
		String response=input.next();
		if(response.matches("Evet")) {
			clickValidationLink(user);
		}else {
			System.out.println("�yeli�iniz tamamlanamad�.");
		}
	}

	private void clickValidationLink(User user) {
		System.out.println("Tebrikler �yeli�iniz ba�ar�yla tamamland� " + user.getFirstName()+" "+user.getLastName());
	}

	private boolean checkIfNameAndSurnameValid(String firstName, String lastName) {
		if(firstName.length()<2||lastName.length()<2) {
			return false;
		}
		return true;
	}

	private boolean checkIfMailAvailable(String mail) {
		if(getByMail(mail)!=null) {
			return false;
		}
		return true;
	}

	private boolean checkPassword(String password) {
		if(password.length()<6) {
			return false;
		}
		return true;
	}

	private boolean checkIfMailValid(String mail) {
		String regexString = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		boolean result=true;
		Pattern pattern=Pattern.compile(regexString,Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(mail);
		if(!matcher.matches()) {
			result=false;
		}
		return result;	
	}

	public void signIn(User user) {
		if(checkUserProfiles(user.getMail(),user.getPassword()))
		{
			dao.signIn(user);
		}else {
			System.out.println("Kullan�c� bilgileri hatal�.");
		}
	}

	private boolean checkUserProfiles(String mail,String password) {
		if((!checkIfMailAvailable(mail)&&(getByMail(mail).getPassword()==password)))
		{
			return true;
		}
		return false;
	}

	public void update(User user) {
		if(!checkIfMailValid(user.getMail())) {
			System.out.println("Girilen email adresi ge�ersiz.");
		}
		if(!checkPassword(user.getPassword())) {
			System.out.println("Parola en az 6 karakterden olu�mal�d�r.");
		}
		if(!checkIfMailAvailable(user.getMail())) {
			System.out.println("Bu email zaten kullan�lmakta.");
		}if(!checkIfNameAndSurnameValid(user.getFirstName(),user.getLastName())) {
			System.out.println("�sim/Soyisim en az 2 karakterden olu�mal�d�r.");
		}
		dao.update(user);
		
	}

	public void delete(User user) {
		dao.delete(user);
		
	}

	public User getByMail(String mail) {
		return dao.getByMail(mail);
	}

}
