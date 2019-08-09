package assignment4;

import java.util.Scanner;

class Student{
	private String name;
	private int phone;
	private int rollNumber;
	private int year;
	
	public Student (String name, int phone, int rollNumber, int year) {
		this.name = name;
		this.phone = phone;
		this.rollNumber = rollNumber;
		this.year = year;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}

class StudentResultProcessing extends Student{
	String[] marks;
	
	public StudentResultProcessing (String name, int phone, int roll, int year, int[] marks) {
		super(name, phone, roll, year);
		this.marks = results(roll, marks);
	}
	
	String[] results (int roll, int[] marks) {
		String[] res = new String[marks.length];
		for (int i = 0; i < marks.length; i++) {
			if (marks[i] < 65) {
				res[i] = "fail";
			} else {
				res[i] = "pass";
			}
		}
		return res;
	}
	
	void display() {
		System.out.println("Student name: " + super.getName());
		System.out.println("Phone number: " + super.getPhone());
		System.out.println("Roll number: " + super.getRollNumber());
		System.out.println("Class: " + super.getYear());
		System.out.println("Results:");
		
		for (int i = 0; i < marks.length; i++) {
			System.out.println("Subject " + (i+1) + ": " + marks[i]);
		}
	}
}

public class Assignment4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		StudentResultProcessing[] students = new StudentResultProcessing[3];
		String name;
		int phone, roll, year;
		int [] marks = new int[3];
		for (int i = 0; i < students.length; i++) {
			System.out.print("Enter student name: ");
			name = sc.next();
			System.out.print("Enter student phone number: ");
			phone = sc.nextInt();
			System.out.print("Enter student roll number: ");
			roll = sc.nextInt();
			System.out.print("Enter student class: ");
			year = sc.nextInt();
			for(int j=0; j< 3; j++) {
				System.out.print("Enter student grade " + (j+1) + ": ");
				marks[j] = sc.nextInt();
			}
			students[i] = new StudentResultProcessing(name, phone, roll, year, marks);
			System.out.println();
		}
		sc.close();
		for(int i=0; i< students.length; i++) {
			students[i].display();
			System.out.println();
		}
	}
}
