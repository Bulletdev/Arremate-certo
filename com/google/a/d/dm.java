/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import java.io.Serializable;
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
/*    */ @b(ck = true)
/*    */ final class dm
/*    */   extends cj<Object>
/*    */   implements Serializable
/*    */ {
/* 25 */   static final dm a = new dm();
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   public int compare(Object paramObject1, Object paramObject2) {
/* 29 */     return paramObject1.toString().compareTo(paramObject2.toString());
/*    */   }
/*    */ 
/*    */   
/*    */   private Object readResolve() {
/* 34 */     return a;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 39 */     return "Ordering.usingToString()";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\dm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */