package com.crackware.erasmus;

import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.repositories.StudentRepository;
import com.crackware.erasmus.data.security.WebSecurityConfig;
import com.crackware.erasmus.data.services.helper.SchoolsHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErasmusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErasmusApplication.class, args);
	}

}
