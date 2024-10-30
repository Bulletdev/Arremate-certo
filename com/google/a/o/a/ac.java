/*    */ package com.google.a.o.a;
/*    */ 
/*    */ import java.util.concurrent.locks.LockSupport;
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
/*    */ final class ac
/*    */ {
/*    */   static final long bB = 2147483647999999999L;
/*    */   
/*    */   static void a(Object paramObject, long paramLong) {
/* 35 */     LockSupport.parkNanos(paramObject, Math.min(paramLong, 2147483647999999999L));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\ac.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */