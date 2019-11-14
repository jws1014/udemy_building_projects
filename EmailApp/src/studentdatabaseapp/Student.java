package studentdatabaseapp;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Student implements Constants {
	String name;
	Constants.Year year;
	int uid; // uid = 5 digit unique id with first number being grade
	double balance;
	HashSet<Constants.Courses> courses = new HashSet<Constants.Courses>();
	
	public Student(String name, Constants.Year senior) {
		this.name = name;
		this.year = senior;
		System.out.println("STUDENT CREATED: " + this.name + " " + this.year);
		
		// generate unique id
		this.uid = this.generateUID();
		System.out.println("UID IS " + this.uid);
		
		// choose courses to enroll in
		this.enroll();
	}
	
	// generate uid
	private int generateUID() {
		int uid = -1;
		switch (this.year) {
			case FRESHMAN:
				uid = 1;
				break;
			case SOPHOMORE:
				uid = 2;
				break;
			case JUNIOR:
				uid = 3;
				break;
			case SENIOR:
				uid = 4;
				break;
		}
		
		Random rand = new Random();
		uid *= 10000;
		for (int i=0; i<4; i++) {
			int num = rand.nextInt();
			switch (i) {
				case 0:
					uid += num * 1000;
					break;
				case 1:
					uid += num * 100;
					break;
				case 2: 
					uid += num * 10;
					break;
				case 3:
					uid += num;
					break;
			}
		}
		
		return uid;
	}
	
	// enroll in courses
	private void enroll() {
		System.out.println("\nCOURSE CODES ARE: \n" + 
				Constants.Courses.HISTORY101.toString() + " = 1\n" +
				Constants.Courses.MATHEMATICS101.toString() + " = 2\n" +
				Constants.Courses.ENGLISH101.toString() + " = 3\n" +
				Constants.Courses.CHEMISTRY101.toString() + " = 4\n" +
				Constants.Courses.COMPUTERSCIENCE101.toString() + " = 5\n"
		);
		System.out.print("TYPE A COURSE CODE TO ENROLL IN A COURSE: ");
		Scanner in = new Scanner(System.in);
		int crsCode = in.nextInt();
		
		switch (crsCode) {
			case 1:
				this.enrollHelper(Constants.Courses.HISTORY101);
				break;
			case 2:
				this.enrollHelper(Constants.Courses.MATHEMATICS101);
				break;
			case 3:
				this.enrollHelper(Constants.Courses.ENGLISH101);
				break;
			case 4:
				this.enrollHelper(Constants.Courses.CHEMISTRY101);
				break;
			case 5:
				this.enrollHelper(Constants.Courses.COMPUTERSCIENCE101);
				break;
			default:
				System.out.println("INVALID COURSE CODE");
				break;
		}
	}
	
	private void enrollHelper(Constants.Courses course) {
		boolean status = this.courses.add(course);
		if (!status) System.out.println("FAILED TO ADD "+ course.toString() + ", ALREADY ENROLLED");
		else System.out.println("ENROLLED IN " + course.toString());
	}
	
	// pay balance
	public void payBalance(double credit) {
		this.balance += credit;
	}
	
	// get balance
	public double getBalance() {
		System.out.println("BALANCE IS " + this.balance);
		return this.balance;
	}
	
	// get status
	public String getStatus() {
		String status = 
				"Name: " + this.name +
				", UID: " + this.uid +
				", Courses: " + this.courses.toString() +
				", Balance: " + this.balance;
		
		return status;
	}
}
