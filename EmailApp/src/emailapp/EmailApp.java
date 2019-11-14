package emailapp;

/**
 * Email app from https://www.udemy.com/course/practice-java-by-building-projects/learn/lecture/8080710#overview
 * @author Johnny
 *
 */
public class EmailApp {

	public static void main(String[] args) {
		Email em1 = new Email("John", "Schlim");
		
		em1.setAlternateEmail("katie", "Jarvis");
	}

}
