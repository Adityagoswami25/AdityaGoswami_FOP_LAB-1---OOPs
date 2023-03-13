package com.glearning.itapp.service;

import com.glearning.itapp.model.Employee;

public interface GenerateCredentialsServices {

	public String generateEmailAddress(Employee employee);
	public String generatePassword(int length);
	public void displayCredentials(Employee employee);

}
