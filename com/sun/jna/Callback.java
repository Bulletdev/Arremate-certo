/*    */ package com.sun.jna;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
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
/*    */ public interface Callback
/*    */ {
/*    */   public static final String METHOD_NAME = "callback";
/* 60 */   public static final List<String> FORBIDDEN_NAMES = Collections.unmodifiableList(
/* 61 */       Arrays.asList(new String[] { "hashCode", "equals", "toString" }));
/*    */   
/*    */   public static interface UncaughtExceptionHandler {
/*    */     void uncaughtException(Callback param1Callback, Throwable param1Throwable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */