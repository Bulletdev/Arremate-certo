/*    */ package com.a.c;
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
/*    */ public class d
/*    */   extends RuntimeException
/*    */ {
/* 41 */   private String iY = null;
/* 42 */   private int index = 0;
/*    */   
/*    */   public d(String paramString, int paramInt) {
/* 45 */     this.iY = paramString;
/* 46 */     this.index = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 53 */     return this.iY;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getIndex() {
/* 61 */     return this.index;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 68 */     return "(" + this.index + ") " + this.iY;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\c\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */