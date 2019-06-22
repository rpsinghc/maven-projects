//generated file

package save;

import java.util.HashSet;

/**
 * 
 */
public interface Notifier{

    /**
     *
     * @param s
     */
    public void notifyEntry(State s);

    /**
     *
     * @param s
     */
    public void notifyExit(State s);

    /**
     *
     * @param s
     * @param ev
     */
    public void notifyEvent(State s,String ev);

    /**
     *
     * @param nm
     */
    public void addStateListener(StateListener nm);

    /**
     *
     * @param nm
     */
    public void removeStateListener(StateListener nm);
}

/**
 * A basic implementation of the interface above.
 */
final class NotifierImpl implements Notifier{

    private final HashSet<StateListener> LISTENER=new HashSet();

    public void notifyEntry(State s){
        for(StateListener sl:LISTENER){
            sl.stateEntered(s);
        }
    }

    public void notifyExit(State g){
        for(StateListener sl:LISTENER){
            sl.stateExited(g);
        }
    }

    public void notifyEvent(State s,String h){
        for(StateListener sl:LISTENER){
            sl.eventHandled(s,h);
        }
    }

    public void addStateListener(StateListener nm){
        LISTENER.add(nm);
    }

    public void removeStateListener(StateListener nm){
        LISTENER.remove(nm);
    }
}
