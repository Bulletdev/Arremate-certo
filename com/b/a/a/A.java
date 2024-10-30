/*    */ package com.b.a.a;
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
/*    */ class a
/*    */ {
/*    */   private final String ja;
/*    */   private final int gT;
/*    */   private transient String jb;
/*    */   
/*    */   a(String paramString, int paramInt) {
/* 31 */     this.ja = paramString;
/* 32 */     this.gT = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   String dD() {
/* 38 */     return this.ja;
/*    */   }
/*    */ 
/*    */   
/*    */   int getPort() {
/* 43 */     return this.gT;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 50 */     if (this.jb == null)
/*    */     {
/* 52 */       this.jb = String.format("%s:%d", new Object[] { this.ja, Integer.valueOf(this.gT) });
/*    */     }
/*    */     
/* 55 */     return this.jb;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */