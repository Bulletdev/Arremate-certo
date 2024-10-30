/*    */ package com.google.a.o.a;
/*    */ 
/*    */ import com.google.a.a.c;
/*    */ import com.google.a.a.d;
/*    */ import java.util.Locale;
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
/*    */ @c
/*    */ public final class at
/*    */ {
/*    */   public static Thread.UncaughtExceptionHandler a() {
/* 52 */     return new a(Runtime.getRuntime());
/*    */   }
/*    */   
/*    */   @d
/*    */   static final class a implements Thread.UncaughtExceptionHandler {
/* 57 */     private static final Logger logger = Logger.getLogger(a.class.getName());
/*    */     
/*    */     private final Runtime a;
/*    */     
/*    */     a(Runtime param1Runtime) {
/* 62 */       this.a = param1Runtime;
/*    */     }
/*    */ 
/*    */     
/*    */     public void uncaughtException(Thread param1Thread, Throwable param1Throwable) {
/*    */       try {
/* 68 */         logger.log(Level.SEVERE, 
/* 69 */             String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", new Object[] { param1Thread }), param1Throwable);
/* 70 */       } catch (Throwable throwable) {
/*    */ 
/*    */         
/* 73 */         System.err.println(param1Throwable.getMessage());
/* 74 */         System.err.println(throwable.getMessage());
/*    */       } finally {
/* 76 */         this.a.exit(1);
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\at.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */