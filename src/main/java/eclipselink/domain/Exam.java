package eclipselink.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.SecondaryTable;
import javax.validation.Constraint;

@Entity
public class Exam {

	@Id
	@GeneratedValue()
	private Long id;

	private String name;

//	@ManyToMany
//     	joinColumns={@JoinColumn(referencedColumnName="EX_ID")}, 
//		inverseJoinColumns={@JoinColumn(referencedColumnName="STUDENT_ID")}
//    		joinColumns={
//	@JoinColumn(name="Exam_ID", referencedColumnName="ID") }, 
//	inverseJoinColumns={
//		@JoinColumn(name="grades_ID", referencedColumnName="ID", table="Student") }
//    @MapKeyClass(Student.class)


    @OneToMany
//    @JoinTable(name="EXAM_GRADE")
	private Map<Student, Grade> grades = new HashMap<Student, Grade>();
//	private List<Student> students = new ArrayList<Student>();
	
	public Exam() {
		super();
	}
	public Exam(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
/*	
	public Map<Student, Grade> getGrades() {
		return grades;
	}
	public void setGrades(Map<Student, Grade> grades) {
		this.grades = grades;
	}
	@Override
	public String toString() {
		return name + " " + grades.toString();
	}
*/	
}
