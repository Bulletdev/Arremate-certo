/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.util.LittleEndianOutput;
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
/*    */ public abstract class ValueOperatorPtg
/*    */   extends OperationPtg
/*    */ {
/*    */   public final boolean isBaseToken() {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public final byte getDefaultOperandClass() {
/* 39 */     return 32;
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 43 */     paramLittleEndianOutput.writeByte(getSid());
/*    */   }
/*    */   
/*    */   protected abstract byte getSid();
/*    */   
/*    */   public final int getSize() {
/* 49 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toFormulaString() {
/* 54 */     throw new RuntimeException("toFormulaString(String[] operands) should be used for subclasses of OperationPtgs");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\ValueOperatorPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */