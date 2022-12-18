package com.crackware.erasmus.data.services;

import com.crackware.erasmus.data.model.Student;
/**
 * Interface which acts as a service for Student class
 */
public interface StudentService extends CrudService<Student, Long>, EmailService{

}
