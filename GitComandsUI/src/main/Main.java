package main;

public class Main {

	public static void main(String[] args) {
		 User u = new User();
			System.out.println( u.getUserName("git config user.name"));
			System.out.println(  u.getUserEmail("git config user.email"));
			System.out.println(  u.getBranch("git branch"));

	    }
}
