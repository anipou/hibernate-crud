package net.java.hib;

import java.util.List;

import net.java.hib.dao.StudentDao;
import net.java.hib.model.Student;

public class App{
	public static void main(String[] args) {
		
		StudentDao studentDao= new StudentDao();
		Student student= new Student("Anish","Sharma","a.s@gmail.com");
		studentDao.saveStudent(student);
		
		student.setFirstName("Anish");
		studentDao.updateStudent(student); 
		
		Student student2= studentDao.getStudentById(student.getId());
		List<Student> students= studentDao.getAllStudents();
		students.forEach(student1 -> System.out.println(student1.getId()));
		
		studentDao.deleteStudent(student.getId());
		
	}
}
