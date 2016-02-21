package eclipselink.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import eclipselink.domain.Student;
import eclipselink.domain.Grade;
import eclipselink.domain.Exam;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createExam();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listExams();

		System.out.println(".. done");
	}




	private void createExam() {
			Exam exam = new Exam("Java");
			
			Student stud1 = new Student("Jakab Gipsz");
			manager.persist(stud1);
			
			Grade grade1 = new Grade(85);
			manager.persist(grade1);
			
			Student stud2 = new Student("Captain Nemo");
			manager.persist(stud2);
			
			Grade grade2 = new Grade(90);
			manager.persist(grade2);
			
			Map<Student, Grade> grades = new HashMap<Student, Grade>();
			grades.put(stud1, grade1);
			grades.put(stud2, grade2);
//			exam.setGrades(grades);
			manager.persist(exam);

	}


	private void listExams() {
		List<Exam> resultList = manager.createQuery("Select d From Exam d", Exam.class).getResultList();
		System.out.println("num of exams:" + resultList.size());
		for (Exam next : resultList) {
			System.out.println("next exam: " + next);
		}
	}


}
