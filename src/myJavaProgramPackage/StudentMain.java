package myJavaProgramPackage;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
