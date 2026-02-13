package com.rajkiran.acharyya.HospitalManagementSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalManagementSystemApplication implements CommandLineRunner {
		public static void main (String[]args){
		try {
			SpringApplication.run(HospitalManagementSystemApplication.class, args);
		}catch (Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
		public void run (String...args){
		System.out.println("Server is running");
	}
}
