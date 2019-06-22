import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int n;
	int p;
	static ConcurrentLinkedDeque<Integer> a = new ConcurrentLinkedDeque();
   Fibonacci(int n,int p) { 
	   this.n = n;
	   this.p = p;
	 }
   
   protected Integer compute() {
     if (n <= 1)
       return n;
     Fibonacci f1 = new Fibonacci(n - 1,11);
     System.out.println("fork "+p+"  " + n);
    // f1.fork();
     Fibonacci f2 = new Fibonacci(n - 2,12);
     System.out.println("compute "+p+"  "+n);
     f2.fork();
     Integer one = f1.compute();
     Integer two = f2.join();
     a.add(one);
     a.add(two);
     return one + two;
   }
   
   static int sum =  0;
   public static void main(String[] args) throws Exception{
	   
	   ForkJoinPool fjp = ForkJoinPool.commonPool();
	   Fibonacci fib = new Fibonacci(20,0);
	   ForkJoinTask<Integer> o = fjp.submit(fib);
	   long s = System.currentTimeMillis();
	   while(!o.isDone()) {
		   System.out.println("Still processing..."+ sum++);
		   Thread.sleep(10);
		   
	   }
	   
	   
	   if(o.isCompletedNormally()) {
		   System.out.println(o.get());
		   
		   
		//System.out.println("\n"+a.parallelStream().mapToInt(x -> x).count());   
	   }
	   long e = System.currentTimeMillis();
	   System.out.println("total processing..."+ sum*10);
	   System.out.println("total processing..."+ (e - s));
	   
   }
}