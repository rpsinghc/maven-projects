import java.util.concurrent.ForkJoinPool;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FibonacciComutationClient {
    public static final Log LOG = LogFactory.getLog(FibonacciComutationClient.class);
    public static void main(String args[]){
        //to calculate 20th element of Fibonacci-Series
        int number = 100; 
        int poolSize = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(poolSize);   
        long beforeTime = System.currentTimeMillis();
        LOG.info("Parallelism  => "+ pool.getParallelism());
        Integer result = (Integer) pool.invoke(new FibonacciComputation(number)); 
        LOG.info("Total Time in MilliSecond Taken ->  "+ (System.currentTimeMillis() - beforeTime));
        LOG.info(number +"the element of Fibonacci Number = "+result);
    }
}
