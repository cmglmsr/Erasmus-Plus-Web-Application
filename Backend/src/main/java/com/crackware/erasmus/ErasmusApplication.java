package com.crackware.erasmus;

import com.crackware.erasmus.data.model.Student;
import com.crackware.erasmus.data.repositories.StudentRepository;
import com.crackware.erasmus.data.security.WebSecurityConfig;
import com.crackware.erasmus.data.services.SchoolService;
import com.crackware.erasmus.data.services.helper.SchoolsHelper;
import com.crackware.erasmus.web.controller.SchoolsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

@SpringBootApplication
/**
 * Class which is used to run Spring application
 */
public class ErasmusApplication {
	public static void main(String[] args) {
		SpringApplication.run(ErasmusApplication.class, args);
	}

}
