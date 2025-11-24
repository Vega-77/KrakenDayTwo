import java.util.concurrent.*;
public class GitKrakenTwo {
	public static void main(String[]args) throws Exception{
		ExecutorService exe = Executors.newFixedThreadPool(1000);
		Callable<Integer> callable = () -> {
			int total = 0;
			for(int i=0; i<1000000; i++)
				total++;
			return total;
		};

		Future<Integer> future = exe.submit(callable);
		int result = future.get();
		System.out.println("Result from Future: "+result);
		exe.shutdown();
	}
}