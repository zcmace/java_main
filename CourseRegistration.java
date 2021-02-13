package java_main;

import java.util.Scanner;

public class CourseRegistration {
	public static void showMenu() {
		System.out.println("1: Add a student to the course");
		System.out.println("2: Check to see if a student is registered in the course");
		System.out.println("3: Remove a student from the course");
		System.out.println("4: Show the student list if it is not empty");
		System.out.println("5: Show the waitlist if it is not empty");
		System.out.println("6: Exit the program");

	}

	public static void main(String[] args) {
		Course course = new Course("Computer Science", 101, 20, 20);
		Scanner input = new Scanner(System.in);
		boolean leave = false;
		while (leave != true) {
			showMenu();

			switch (input.next().trim()) {
			case "1":
				System.out.println("Please enter Student name");
				String n = input.next();
				System.out.println("please enter student id");
				int id = input.nextInt();
				course.addStudent(new Student(n, id));
				System.out.println("The student had been added");
				break;
			case "2":
				System.out.println("please enter the student's id");
				int num = input.nextInt();
				if (course.findStudent(num) == null) {
					System.out.println("The student is not in the course");
				} else {
					System.out.println(course.findStudent(num).name + " is in the course!");

				}

				break;

			case "3":
				System.out.println("Please enter the student's id number");
				int idnum = input.nextInt();
				course.removeStudent(idnum);
				System.out.println("The student has been removed from the class");
				break;

			case "4":
				System.out.println("The students currently enrolled are:");
				for (int i = 0; i < course.MaxStudents; i++) {
					if (course.students[i] != null) {

						System.out.println(course.students[i].toString());
						System.out.println();

					}
				}
				break;
			case "5":
				System.out.println("The students currently in the waitlist are:");
				for (int i = 0; i < course.MaxWaitlist; i++) {
					if (course.Waitlist[i] != null) {
						System.out.println(course.Waitlist[i].toString());
						System.out.println();

					}
				}
				break;
			case "6": 
				leave = true;
				System.out.println("Thank you for using the program!");
				break;

			default:
				System.out.println("please enter a number 1-5");
			}

		}
	}

}

class Student extends Person {
	public Student(String name, int id) {
		this.name = name;
		this.id = id;

	}

	public int getID() {
		return this.id;

	}

	public boolean equals(Student s) {
		if (s.id == this.id)
			return true;
		else
			return false;

	}
}

class Instructor extends Person {
	public Instructor(String name, int id) {

	}

}

class Person {
	String name;
	int id;

	public String toString() {
		return name + ", " + id;
	}
}

class Course {
	String name;
	int CourseCode;
	Instructor I;
	int MaxStudents;
	int NumberOfStudents;
	Student[] students;
	int MaxWaitlist;
	int NumberInWaitlist;
	Student[] Waitlist;

	public Course(String name, int code, int MaxStudents, int MaxWaitlist) {
		this.name = name;
		this.CourseCode = code;
		this.MaxStudents = MaxStudents;
		this.MaxWaitlist = MaxWaitlist;
		this.students = new Student[MaxStudents];
		this.Waitlist = new Student[MaxWaitlist];

	}

	public void setInstructor(Instructor I) {
		this.I = I;

	}

	public Instructor getInstructor() {
		return this.I;

	}

	public Student findStudent(int id) {
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] == null)
				continue;
			if (this.students[i].id == id)
				return this.students[i];
		}

		return null;

	}

	public Student findStudentWait(int id) {
		for (int i = 0; i < this.Waitlist.length; i++) {
			if (this.Waitlist[i] == null)
				continue;
			if (this.Waitlist[i].id == id)
				return this.Waitlist[i];
		}

		return null;

	}

	public void addStudent(Student s) {
		boolean added = false;
		if (this.findStudent(s.id) == null && this.findStudentWait(s.id) == null) {
			for (int i = 0; i < this.students.length; i++) {
				if (added == true)
					continue;
				else if (this.students[i] == (null)) {

					this.students[i] = s;
					added = true;
				}
			}
			for (int i = 0; i < this.Waitlist.length; i++) {
				if (added == true)
					continue;
				else if (this.Waitlist[i] == (null)) {

					this.Waitlist[i] = s;
					added = true;
				}
			}

		} else
			System.out.println("This student is already in this class or is in the waitlist");

	}

	public void removeStudent(int id) {
		if (this.findStudent(id) == null) {
			System.out.println("This student is not in the class");
		} else {
			int index = 0;
			for (int i = 0; i < this.students.length; i++) {
				if (id == students[i].id) {
					students[i] = null;
					index = i;
				}
			}
			for (int i = 0; i < this.Waitlist.length; i++) {
				if (this.Waitlist[i] != null) {
					this.students[index] = Waitlist[i];
					Waitlist[i] = null;
					reorganizeWaitlist();

				}
			}

		}
	}

	public void reorganizeWaitlist() {
		int tempcount = 0;
		Student[] temp = new Student[this.MaxWaitlist];
		for (int i = 0; i < this.Waitlist.length; i++) {
			if (this.Waitlist[i] != null) {
				temp[tempcount] = Waitlist[i];
				tempcount++;
			}
		}
	}

}
