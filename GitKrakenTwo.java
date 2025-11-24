public class GitKrakenTwo {
	public static void main(String[]args){
		long startTime = System.nanoTime();

		long duration = System.nanoTime()-startTime;
		System.out.println("Duration: "+duration/1000000000.0+" seconds");
	}
}