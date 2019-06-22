//generated file

package save;

/**
 *
 */
public interface StateListener{

    /**
     *
     * @param s
     */
    public void stateEntered(State s);

    /**
     *
     * @param s
     */
    public void stateExited(State s);

    /**
     *
     * @param s
     * @param ev
     */
    public void eventHandled(State s,String ev);
}
