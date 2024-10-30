/*    */ package com.google.a.e;
/*    */ 
/*    */ import com.google.a.a.b;
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
/*    */ @b(cl = true)
/*    */ final class h
/*    */ {
/*    */   static char[] c() {
/* 30 */     return b.get();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 38 */   private static final ThreadLocal<char[]> b = new ThreadLocal<char[]>()
/*    */     {
/*    */       protected char[] d()
/*    */       {
/* 42 */         return new char[1024];
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\e\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */