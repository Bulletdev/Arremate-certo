/*    */ package ch.qos.logback.core.status;
/*    */ 
/*    */ import java.io.PrintStream;
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
/*    */ public class OnErrorConsoleStatusListener
/*    */   extends OnPrintStreamStatusListenerBase
/*    */ {
/*    */   protected PrintStream getPrintStream() {
/* 28 */     return System.err;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\status\OnErrorConsoleStatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */