//generated file

package save;

public class Activity{

    private ActionContainer first=new ActionContainer(),last=first;

    /**
     * Returns a new executable instance of this activity.
     * @return
     */
    public ActivityInstance getInstance(){
        return new ActivityInstance(first);
    }

    /**
     * Adds a new action to the activity.
     * @param a an action
     */
    public void addAction(Action a){
        if(a==null){return;}
        if(first.action==null){
            first.action=a;
        }else{
            last.next=new ActionContainer();
            last=last.next;
            last.action=a;
        }
    }
    
    /**
     * Adds and returns a new interruptible action that sleeps for a given time.
     * @param i the time to sleep
     * @return
     */
    public Action addInterruptibleSleep(long i){
        if(i<=0){return null;}
        Action a=new Action(){
            @Override
            public void execute(){
            }
        };
        if(first.action==null){
            first.action=a;
            first.sleep=i;
        }else{
            last.next=new ActionContainer();
            last=last.next;
            last.action=a;
            last.sleep=i;
        }
        return a;
    }

    /**
     * Adds a whole activity to the action. An activity cannot be removed as a whole,
     * only its actions.
     * @param a an activity
     */
    public void addAction(Activity a){
        if(a==null){return;}
        if(first.action==null){
            first=a.first;
        }else{
            last.next=a.first;
        }
    }

    /**
     * Removes all actions from the activity that are the same as the given action.
     * @param g an action
     */
    public void removeAction(Action g){
        ActionContainer k=first.next,j=first;
        if(first.action==null){
            return;
        }else if(first.action==g){
            if(first.next!=null){
                first=first.next;
            }else{
                first.action=null;
            }
        }
        while(k!=null && k!=first){
            if(k.action==g){
                j.next=k.next;
            }else{
                j=k;
            }
            k=k.next;
        }
    }

    /**
     * Executes the activity.
     */
    public void execute(){
        if(first.action==null){
            return;
        }
        ActionContainer j=first;
        while(j!=null){
            j.action.execute();
            j=j.next;
        }
    }
}

