package myJavaProgramPackage;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StudentMain {

	public static void main(String[] args) {

		System.out.println("This is  main class");

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Callable<String> call = () -> {

			System.out.println("work started");
			Thread.sleep(1000);
			return "done";

		};

		Future<String> future = executorService.submit(call);

		boolean task = true;
		try {

			while (task) {

				if (future.isDone()) {
					String student = future.get();
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
