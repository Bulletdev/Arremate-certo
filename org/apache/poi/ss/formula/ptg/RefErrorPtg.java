/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.FormulaError;
/*    */ import org.apache.poi.util.LittleEndianInput;
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
/*    */ public final class RefErrorPtg
/*    */   extends OperandPtg
/*    */ {
/*    */   private static final int SIZE = 5;
/*    */   public static final byte sid = 42;
/*    */   private int field_1_reserved;
/*    */   
/*    */   public RefErrorPtg() {
/* 35 */     this.field_1_reserved = 0;
/*    */   }
/*    */   public RefErrorPtg(LittleEndianInput paramLittleEndianInput) {
/* 38 */     this.field_1_reserved = paramLittleEndianInput.readInt();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 42 */     return getClass().getName();
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 46 */     paramLittleEndianOutput.writeByte(42 + getPtgClass());
/* 47 */     paramLittleEndianOutput.writeInt(this.field_1_reserved);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize() {
/* 52 */     return 5;
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 56 */     return FormulaError.REF.getString();
/*    */   }
/*    */   
/*    */   public byte getDefaultOperandClass() {
/* 60 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\RefErrorPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */