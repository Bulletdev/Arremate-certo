/*    */ package com.google.a.d;
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
/*    */ @b
/*    */ public enum x
/*    */ {
/* 29 */   a(false),
/* 30 */   b(true);
/*    */   
/*    */   final boolean aB;
/*    */   
/*    */   x(boolean paramBoolean) {
/* 35 */     this.aB = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   static x a(boolean paramBoolean) {
/* 40 */     return paramBoolean ? b : (x)a;
/*    */   }
/*    */   
/*    */   x a() {
/* 44 */     return a(!this.aB);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */