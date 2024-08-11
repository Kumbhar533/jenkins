package myJavaProgramPackage;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Student {

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

	public class StudentMain {

		public static void main(String[] args) {

			System.out.println("This is  main class");

			ExecutorService executorService = Executors.newSingleThreadExecutor();

			Callable<Student> call = () -> {

				Student student = new Student(UUID.randomUUID(), "Nilesh", "Willingdon college", 15986l);
				Thread.sleep(1000);
				return student;

			};

			Future<Student> future = executorService.submit(call);

			boolean task = true;
			try {

				while (task) {

					if (future.isDone()) {
						Student student = future.get();
						task = false;
						System.out.println(student);
						System.out.println("Task done");

					} else {
						System.out.println("Waiting for comletion");
					}

				}

			} catch (Exception e) {
				e.getMessage();
			}

		}

	}
}
