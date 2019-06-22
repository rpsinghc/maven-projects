
import java.util.concurrent.RecursiveTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * @author arun.pandey
 */
public class FibonacciComputation extends RecursiveTask<Integer> {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7568145901293709626L;
	public static final Log LOG = LogFactory.getLog(FibonacciComputation.class);
    private final int number;
    public FibonacciComputation(int number) { 
        this.number = number; 
    }
    @Override
    public Integer compute() {
        if (number <= 1)
        return number;
        FibonacciComputation f1 = new FibonacciComputation(number - 1);
        f1.fork();
        LOG.info("Current Therad Name = "+Thread.currentThread().getName());
        FibonacciComputation f2 = new FibonacciComputation(number - 2);
        return f2.compute() + (Integer)f1.join();
    }
}