import java.util.concurrent.*;
public class GitKrakenTwo {
	public static void main(String[]args) throws Exception{
		long startTime = System.nanoTime();
		ExecutorService exe = Executors.newFixedThreadPool(1000);
		Callable<Integer> callable = () -> {
			int total = 0;
			for(int i=0; i<1000000; i++)
				total++;
			return total;
		};

		Future<Integer>[] futures = new Future[1000];
		int result = 0;
		for(int i=0; i<1000; i++)
			futures[i] = exe.submit(callable);
		for(int i=0; i<1000; i++)
			result+=futures[i].get();

		System.out.println("Result from Future: "+result);
		exe.shutdown();
		long duration = System.nanoTime()-startTime;
		System.out.println("Duration: "+duration/1000000000.0+" seconds");

		startTime = System.nanoTime();
		int newTotal = 0;
		for(int i=0; i<1000000000; i++)
			newTotal++;

		duration = System.nanoTime()-startTime;
		System.out.println("Duration: "+duration/1000000000.0+" seconds");
		System.out.println("Completed");
	}
}