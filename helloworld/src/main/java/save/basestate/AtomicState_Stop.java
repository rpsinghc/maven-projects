//generated file

package save.basestate;

import save.State;

public class AtomicState_Stop extends State{

   @Override
   public void entry(){
      super.entry();
   }

   @Override
   protected void startTimer(){
   }

   public AtomicState_Stop(int reg,State bs){
      super(1,reg,bs);
   }

   @Override
   public String getName(){
      return "Stop";
   }
}
