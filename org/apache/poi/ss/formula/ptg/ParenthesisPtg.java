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
/*    */ 
/*    */ public final class ParenthesisPtg
/*    */   extends ControlPtg
/*    */ {
/*    */   private static final int SIZE = 1;
/*    */   public static final byte sid = 21;
/* 37 */   public static final ControlPtg instance = new ParenthesisPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 44 */     paramLittleEndianOutput.writeByte(21 + getPtgClass());
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 48 */     return 1;
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 52 */     return "()";
/*    */   }
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 56 */     return "(" + paramArrayOfString[0] + ")";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\ParenthesisPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */