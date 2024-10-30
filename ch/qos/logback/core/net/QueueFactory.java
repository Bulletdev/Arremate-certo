/*    */ package ch.qos.logback.core.net;
/*    */ 
/*    */ import java.util.concurrent.LinkedBlockingDeque;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QueueFactory
/*    */ {
/*    */   public <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int paramInt) {
/* 36 */     boolean bool = (paramInt < 1) ? true : paramInt;
/* 37 */     return new LinkedBlockingDeque<E>(bool);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\QueueFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */