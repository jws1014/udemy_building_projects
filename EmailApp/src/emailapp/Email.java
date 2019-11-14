package emailapp;

import java.util.Random;
import java.util.Scanner;

/**
 * this is an email account
 */
public class Email {
    private String firstName = null;
    private String lastName = null;
    private String department = null;
    private String company = "company";
    private String password = null;
    private String email = null;
    private String alternateEmail = null;
    private int passwordLength = 8;
    private int mailCapacity = 500;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
        
        this.department = this.setDepartment();
        System.out.println("DEPARTMENT IS " + this.department);
        
        this.password = this.randomPassword(passwordLength);
        System.out.println("PASSWORD IS " + this.password);
        
        this.email = this.buildEmailAddress(this.firstName, this.lastName, this.company, this.department);
        System.out.println("EMAIL IS " + this.email);
    }

    private String setDepartment() {
        System.out.print("\nDEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        switch (depChoice) {
            case 1:
            	in.close();
                return "sales";
            case 2:
            	in.close();
                return "dev";
            case 3:
            	in.close();
                return "acct";
            default:
            	in.close();
                return "";
        }
    }
    
    private String buildEmailAddress(String f, String l, String c, String d) {
        // first.last@department.company.com
        return f.toLowerCase() + "." + l.toLowerCase() + "@" + d + "." + c + ".com";
    }

    private String randomPassword(int length) {
    	String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
        	int rnum = (int)(Math.random() * passwordSet.length());
        	password[i] = passwordSet.charAt(rnum);
        }
        return new String(password);
    }

    public void setMailCapacity(int cap) {
        this.mailCapacity = cap;
    }

    public void setAlternateEmail(String first, String last) {
        this.alternateEmail = buildEmailAddress(first, last, this.company, this.department);
        System.out.println("ALT EMAIL IS " + this.alternateEmail);
    }
    
    public void setPassword(String pass) {
        this.password = pass;
        System.out.println("NEW PASSWORD IS " + this.password);
    }

    public int getMailCapacity() {
        return this.mailCapacity;
    }
    
    public String getEmail() {
        return buildEmailAddress(firstName, lastName, company, department);
    }

    public String getAlternateEmail() {
        return this.alternateEmail;
    }
    
    public String getName() {
        return this.firstName + " " + this.lastName;
    }




}

