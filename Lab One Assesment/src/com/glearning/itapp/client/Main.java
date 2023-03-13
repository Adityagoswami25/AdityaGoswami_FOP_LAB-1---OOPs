package com.glearning.itapp.client;

import java.util.Scanner;

import com.glearning.itapp.model.Employee;
import com.glearning.itapp.service.GenerateCredentials;

public class Main {

	static int length = 8;
	public static void main(String[] args) {
		
		
		GenerateCredentials generateCredentials = new GenerateCredentials();
		Employee employee = new Employee("harshit", "choudary");
		employee.setCompany("greatlearning");
		
		System.out.println("Please enter the department from the following");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		Scanner sc = new Scanner(System.in);
		
		int option = sc.nextInt();
		
		switch(option){
		case 1:
			employee.setDepartment("Technical");
			generateCredentials.generateEmailAddress(employee);
			break;
		case 2:
			employee.setDepartment("Admin");
			generateCredentials.generateEmailAddress(employee);
			break;
		case 3:
			employee.setDepartment("Human Resource");
			generateCredentials.generateEmailAddress(employee);
			break;
		case 4:
			employee.setDepartment("Legal");
			generateCredentials.generateEmailAddress(employee);
			break;
		default:
			System.out.println("Invalid Option");
			break;
		}
		
			
		
		
		employee.setPassword(generateCredentials.generatePassword(length)); 
		generateCredentials.displayCredentials(employee);
	}
}
