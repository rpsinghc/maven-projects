//generated file

package save;

public class ActivityInstance{

    private ActionContainer first;
    private boolean stop,run;
    Thread t;

    /**
     *
     * @param f
     */
    ActivityInstance(ActionContainer f){
        first=f;
    }

    /**
     * Starts the activity in a separate thread.
     */
    public void start(){
        run=true;
        stop=false;
        t=new Thread(){
            @Override
            public void run(){
                if(first.action!=null){
                    ActionContainer j=first;
                    while(j!=null){
                        if(stop){
                            break;
                        }
                        j.action.execute();
                        if(j.sleep>0){
                            synchronized(t){
                                try{
                                    t.wait(j.sleep);
                                }catch(InterruptedException e){
                                }
                            }
                        }
                        j=j.next;
                    }
                }
                endrun();
            }
        };
        t.start();
    }

    /**
     * Returns whether the activity still runs.
     * @return <code>true</code> if it is running
     */
    public boolean runs(){
        return run;
    }

    /**
     * Waits until the activity ended.
     */
    public synchronized void await(){
        while(run){
            try{
                wait();
            }catch(InterruptedException j){
            }
        }
    }

    private synchronized void endrun(){
        run=false;
        stop=true;
        notifyAll();
    }

    /**
     * Stops the activity.
     */
    public void stop(){
        stop=true;
        if(t!=null){
            synchronized(t){
                t.notify();
            }
        }
    }
}
