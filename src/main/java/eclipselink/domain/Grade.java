package eclipselink.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grade {
	@Id
	@GeneratedValue
	private Long id;
	
	private int grade;

	public Grade() {}
	public Grade(int grade) {
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return Integer.toString(grade);
	}

}
