package studentdatabaseapp;

import java.util.HashSet;
import java.util.Scanner;

public class StudentDatabaseApp implements Constants {
	
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		Scanner in = new Scanner(System.in);
		
		// ask # of students to add
		System.out.print("\nNumber of students to add: ");
		int studentNum = in.nextInt();
		
		// enter name and year for each student
		for (int i=0; i<studentNum; i++) {
			boolean valid = true;
			do {
				System.out.print("\nEnter student name: ");
				String name = in.next();
				System.out.print("\nEnter student year: ");
				String year = in.next();
				
				if (year.equalsIgnoreCase(Constants.Year.FRESHMAN.toString())) {
					students.add(new Student(name, Constants.Year.FRESHMAN));
				}
				else if (year.equalsIgnoreCase(Constants.Year.SOPHOMORE.toString())) {
					students.add(new Student(name, Constants.Year.SOPHOMORE));
				}
				else if (year.equalsIgnoreCase(Constants.Year.JUNIOR.toString())) {
					students.add(new Student(name, Constants.Year.JUNIOR));
				}
				else if (year.equalsIgnoreCase(Constants.Year.SENIOR.toString())) {
					students.add(new Student(name, Constants.Year.SENIOR));
				}
				else {
					System.out.println("PLEASE ENTER A VALID YEAR");
					valid = false;
				}
			} while (!valid);
		}
		
		boolean running = true;
		while (running) {
			System.out.println("type: exit to quit program");
			System.out.println("type: balance to view student balance");
			System.out.println("type: pay to pay student balance");
			System.out.println("type: status to see status of student");
			// can quit program
			String command = in.next();
			if (command.equalsIgnoreCase("exit")) {
				running = false;
				break;
			}
			
			// can view balance of student
			if (command.equalsIgnoreCase("balance")) {
				System.out.print("\nEnter the student's name: ");
				String name = in.next();
				System.out.println("Selected balance of student " + name);
			}
			
			// can pay tuition of student
			if (command.equalsIgnoreCase("pay")) {
				System.out.print("\nEnter the student's name: ");
				String name = in.next();
				System.out.println("Selected to pay for student " + name);
			}
			
			// see status of student: name, id, courses, balance
			if (command.equalsIgnoreCase("status")) {
				System.out.print("\nEnter the student's name: ");
				String name = in.next();
				System.out.println("Selected status for student " + name);
			}
		}
	}
}
