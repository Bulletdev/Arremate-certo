/*    */ package ch.qos.logback.classic.spi;
/*    */ 
/*    */ import ch.qos.logback.classic.Logger;
/*    */ import java.util.Comparator;
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
/*    */ public class LoggerComparator
/*    */   implements Comparator<Logger>
/*    */ {
/*    */   public int compare(Logger paramLogger1, Logger paramLogger2) {
/* 23 */     if (paramLogger1.getName().equals(paramLogger2.getName())) {
/* 24 */       return 0;
/*    */     }
/* 26 */     if (paramLogger1.getName().equals("ROOT")) {
/* 27 */       return -1;
/*    */     }
/* 29 */     if (paramLogger2.getName().equals("ROOT")) {
/* 30 */       return 1;
/*    */     }
/* 32 */     return paramLogger1.getName().compareTo(paramLogger2.getName());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\LoggerComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */