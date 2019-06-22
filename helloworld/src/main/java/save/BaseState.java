package save;

/**
 * The base state of the state machine.
 */
public class BaseState extends save.State{

   public BaseState(){
      super(1,-1,null);
      notifier=new NotifierImpl();
      variables=new VariableContainer();
      history=new HistoryContainer();
      CHILDREN[0]=null;
   }

   @Override
   public void entry(){
      synchronized(this){
         super.entry();
      }
   }

   @Override
   protected void do_(){
   }

   @Override
   public boolean EVENT_stop(){
      synchronized(this){
         return super.EVENT_stop();
      }
   }

   @Override
   public boolean EVENT_calculate(){
      synchronized(this){
         return super.EVENT_calculate();
      }
   }

   @Override
   public String getName(){
      return "BaseState";
   }

   @Override
   protected void startTimer(){
   }
}
