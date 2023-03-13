package com.glearning.itapp.service;

import java.util.Random;

import com.glearning.itapp.model.Employee;

public class GenerateCredentials  implements GenerateCredentialsServices{

	private static final String CHARACTERS  = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
	
	@Override
	public String generateEmailAddress(Employee employee) {
		String Department = employee.getDepartment();
		
		if (Department=="Technical") {
			Department = "Tech";
		}
		else if(Department=="Human Resource") {
			Department = "Hr";
		}
		else if(Department=="Legal") {
			Department = "Legal";
		}
		else {
			Department = "Admin";
		}
		String EmailId = employee.getFirstName() + employee.getLastName() + "@" + Department + "." + employee.getCompany() + ".com"; 
		employee.setEmailAddress(EmailId);
		return EmailId;
	}

	@Override
	public String generatePassword(int length) {
		Random random = new Random();
        StringBuilder password = new StringBuilder();
        boolean hasNumber = false;
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasSpecialChar = false;

        while (password.length() < length) {
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);

            if (Character.isDigit(randomChar)) {
                hasNumber = true;
            } else if (Character.isLowerCase(randomChar)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(randomChar)) {
                hasUppercase = true;
            } else {
                hasSpecialChar = true;
            }

            password.append(randomChar);
        }

        if (!hasNumber) {
            password.setCharAt(random.nextInt(password.length()), (char) ('0' + random.nextInt(10)));
        }

        if (!hasLowercase) {
            password.setCharAt(random.nextInt(password.length()), (char) ('a' + random.nextInt(26)));
        }

        if (!hasUppercase) {
            password.setCharAt(random.nextInt(password.length()), (char) ('A' + random.nextInt(26)));
        }

        if (!hasSpecialChar) {
            password.setCharAt(random.nextInt(password.length()), "!@#$%^&*".charAt(random.nextInt("!@#$%^&*()_+".length())));
        }

        return password.toString();
        
	}

	@Override
	public void displayCredentials(Employee employee) {
		System.out.println("Dear Harshit your generated credentials are as follows");
		System.out.println("Email    ---> " + employee.getEmailAddress());
		System.out.println("Password ---> " + employee.getPassword());
		
		
		
	}

}
