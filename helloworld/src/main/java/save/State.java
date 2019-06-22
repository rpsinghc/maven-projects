//generated file

package save;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

public abstract class State extends Operations{

   /**
    * All child-states of this state (may be empty).
    */
   public final State[] CHILDREN;

   protected final ArrayList<save.ActivityInstance> STARTED_ACTIVITIES=new ArrayList();

   protected final State BASE;

   /**
    * Contains all variables this state-machine accesses to.
    */
   public VariableContainer variables;

   /**
    * The event-notifier for all states.
    */
   protected Notifier notifier;

   protected boolean exited=false;

   /**
    * Contains the history states of the state-machine.
    */
   public HistoryContainer history;

   public static final EffectContainer effects=new EffectContainer();

   /**
    * The parent state of this state, may be <code>null</code>.
    */
   public State parent;

   /**
    * The service to start all threads for the delayed triggers.
    */
   protected ScheduledExecutorService ses=null;

   private final int REGION;

   public State(int reg,int r,State base){
      BASE=base;
      CHILDREN=new State[reg];
      REGION=r;
   }

   protected void do_(){
      Thread t=new Thread(){
         @Override
         public void run(){
            for(save.ActivityInstance j:STARTED_ACTIVITIES){
               j.await();
            }
            synchronized(BASE){
               if(!exited){
                  BASE.EVENT_();
               }
            }
         }
      };
      t.start();
   }

   public void entry(){
      exited=false;
      notifier.notifyEntry(this);
      for(State z:CHILDREN){
         if(z!=null){z.entry();}
      }
      startTimer();
      do_();
   }

   /**
    * To be overwritten in derived classes.
    */
   protected abstract void startTimer();

   public void exit(){
      exited=true;
      for(State z:CHILDREN){
         if(z!=null){z.exit();}
      }
      if(ses!=null){
         ses.shutdown();
      }
      for(save.ActivityInstance a:STARTED_ACTIVITIES){
         a.stop();
      }
      for(save.ActivityInstance a:STARTED_ACTIVITIES){
         a.await();
      }
      notifier.notifyExit(this);
   }

   public boolean join(long i,long state){
      return true;
   }

   public void removeSelf(){
      if(parent!=null){
         exit();
         parent.CHILDREN[REGION]=null;
      }
   }

   public State setState(State k){
      if(k.equals(CHILDREN[k.REGION])){
         if(!CHILDREN[k.REGION].exited){
            return CHILDREN[k.REGION];
         }
      }else if(CHILDREN[k.REGION]!=null){
         CHILDREN[k.REGION].exit();
      }
      CHILDREN[k.REGION]=k;
      k.variables=variables;
      k.parent=this;
      k.notifier=notifier;
      k.history=history;
      return k;
   }

   public void clearState(){
      for(int i=0;i<CHILDREN.length;i++){
         if(CHILDREN[i]!=null){
            CHILDREN[i]=null;
         }
      }
   }

   protected final boolean noBehaviour(){
      for(State s:CHILDREN){
         if(s!=null){return false;}
      }
      for(save.ActivityInstance a:STARTED_ACTIVITIES){
         if(a.runs()){return false;}
      }
      return true;
   }

   public boolean equals(State h){
      return h!=null ? h.getClass()==getClass() : false;
   }

   public abstract String getName();

   /**
    * Adds a state-listener (all states are affected).
    * @param nm a state-listener
    */
   public void addStateListener(StateListener nm){
      notifier.addStateListener(nm);
   }

   /**
    * Removes a state-listener (all states are affected).
    * @param nm a state-listener
    */
   public void removeStateListener(StateListener nm){
      notifier.removeStateListener(nm);
   }

   public boolean EVENT_(){
      boolean c=false;
      for(State s:CHILDREN){
         if(s!=null && !s.exited){
            c=c | s.EVENT_();
         }
      }
      return c;
   }

   public boolean EVENT_stop(){
      boolean c=false;
      for(State s:CHILDREN){
         if(s!=null && !s.exited){
            c=c | s.EVENT_stop();
         }
      }
      return c;
   }

   public boolean EVENT_calculate(){
      boolean c=false;
      for(State s:CHILDREN){
         if(s!=null && !s.exited){
            c=c | s.EVENT_calculate();
         }
      }
      return c;
   }
}