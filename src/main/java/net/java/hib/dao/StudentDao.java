package net.java.hib.dao;


import java.util.List;




import org.hibernate.Session;
import org.hibernate.Transaction;

import net.java.hib.model.Student;
import net.java.hib.util.HibernateUtil;

public class StudentDao {
	
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction(); 
			
			session.save(student);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			
			
			}
		}
	}
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction(); 
			
			session.saveOrUpdate(student);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			
			
			}
		}
	}
	public Student getStudentById(long id) {
		Transaction transaction = null;
		Student student= null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction(); 
			
			student = session.get(Student.class, id);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			
			
			}
		}
		return student;
	}
	@SuppressWarnings("unchecked")
	public List<Student>getAllStudents() {
		Transaction transaction = null;
		List<Student> students = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction(); 
			
			students = session.createQuery("from student").list();   
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			
			
			}
		}
		return students;
	}
	public void deleteStudent(long id) {
		Transaction transaction = null;
		Student student= null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction(); 
		
			student = session.get(Student.class, id);
			session.delete(student);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			
			
			}
		}
	
	}
	
	
	
	}
