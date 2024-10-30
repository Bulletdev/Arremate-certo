/*    */ package org.h2.expression;
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
/*    */ abstract class Condition
/*    */   extends Expression
/*    */ {
/*    */   public int getType() {
/* 18 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getScale() {
/* 23 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getPrecision() {
/* 28 */     return 1L;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getDisplaySize() {
/* 33 */     return 5;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Condition.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */