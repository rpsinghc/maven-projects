//generated file

package save.basestate;

import save.State;

public class AtomicState_Running extends State{

   @Override
   public void entry(){
      super.entry();
   }

   @Override
   public boolean EVENT_stop(){
      if(super.EVENT_stop()){return true;}
      {
         State m1,m2,m3;
         m3=null;
         m2=parent;
         m1=new save.basestate.AtomicState_Stop(0,BASE);
         m2=m2.setState(m1);
         if(m3==null && m2==m1){
            m3=m2;
         }
         if(m3!=null){m3.entry();}
      }
      notifier.notifyEvent(this,"stop");
      return true;
   }

   @Override
   protected void startTimer(){
   }

   public AtomicState_Running(int reg,State bs){
      super(1,reg,bs);
   }

   @Override
   public String getName(){
      return "Running";
   }
}
