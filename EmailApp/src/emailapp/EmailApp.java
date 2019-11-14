package emailapp;

/**
 * Email app from https://www.udemy.com/course/practice-java-by-building-projects/learn/lecture/8080710#overview
 * 
 *
 */
public class EmailApp {

	public static void main(String[] args) {
		Email em1 = new Email("Jim", "Fake");
		
		em1.setAlternateEmail("Mike", "Notreal");
	}

}
