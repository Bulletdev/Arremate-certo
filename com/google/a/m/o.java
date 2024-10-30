/*    */ package com.google.a.m;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.b.L;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
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
/*    */ @b(cl = true)
/*    */ final class o
/*    */ {
/* 23 */   private static final Logger logger = Logger.getLogger(o.class.getName());
/*    */   
/*    */   static void ez() {
/* 26 */     String str = "guava.gwt.emergency_reenable_rpc";
/*    */     
/* 28 */     if (!Boolean.parseBoolean(System.getProperty(str, "false"))) {
/* 29 */       throw new UnsupportedOperationException(
/* 30 */           L.a("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", new Object[] { str, "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ" }));
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 38 */     logger.log(Level.WARNING, "Later in 2020, we will remove GWT-RPC support for Guava types. You are seeing this warning because you are sending a Guava type over GWT-RPC, which will break. You can identify which type by looking at the class name in the attached stack trace.", new Throwable());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */