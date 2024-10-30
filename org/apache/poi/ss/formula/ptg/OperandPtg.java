/*    */ package org.apache.poi.ss.formula.ptg;
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
/*    */ public abstract class OperandPtg
/*    */   extends Ptg
/*    */   implements Cloneable
/*    */ {
/*    */   public final boolean isBaseToken() {
/* 29 */     return false;
/*    */   }
/*    */   public final OperandPtg copy() {
/*    */     try {
/* 33 */       return (OperandPtg)clone();
/* 34 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 35 */       throw new RuntimeException(cloneNotSupportedException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\OperandPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */