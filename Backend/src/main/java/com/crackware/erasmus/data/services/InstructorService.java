package com.crackware.erasmus.data.services;
import com.crackware.erasmus.data.model.Instructor;
import org.springframework.stereotype.Service;


import java.util.List;
/**
 * Interface which acts as a service for Instructor class
 */
public interface InstructorService extends CrudService<Instructor, Long>, EmailService {
}
