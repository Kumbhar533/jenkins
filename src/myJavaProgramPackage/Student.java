
package myJavaProgramPackage;

import java.util.UUID;

public class Student {

	private UUID id;

	private String name;

	private String collegeName;

	private Long fees;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Long getFees() {
		return fees;
	}

	public void setFees(Long fees) {
		this.fees = fees;
	}

	public Student(UUID id, String name, String collegeName, Long fees) {
		super();
		this.id = id;
		this.name = name;
		this.collegeName = collegeName;
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", collegeName=" + collegeName + ", fees=" + fees + "]";
	}

}
