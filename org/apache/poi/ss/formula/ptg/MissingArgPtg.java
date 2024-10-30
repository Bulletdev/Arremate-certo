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
/*    */ public final class MissingArgPtg
/*    */   extends ScalarConstantPtg
/*    */ {
/*    */   private static final int SIZE = 1;
/*    */   public static final byte sid = 22;
/* 34 */   public static final Ptg instance = new MissingArgPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 41 */     paramLittleEndianOutput.writeByte(22 + getPtgClass());
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 45 */     return 1;
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 49 */     return " ";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\MissingArgPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */