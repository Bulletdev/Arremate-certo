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
/*    */ public final class AreaErrPtg
/*    */   extends OperandPtg
/*    */ {
/*    */   public static final byte sid = 43;
/*    */   private final int unused1;
/*    */   private final int unused2;
/*    */   
/*    */   public AreaErrPtg() {
/* 35 */     this.unused1 = 0;
/* 36 */     this.unused2 = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public AreaErrPtg(LittleEndianInput paramLittleEndianInput) {
/* 41 */     this.unused1 = paramLittleEndianInput.readInt();
/* 42 */     this.unused2 = paramLittleEndianInput.readInt();
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 46 */     paramLittleEndianOutput.writeByte(43 + getPtgClass());
/* 47 */     paramLittleEndianOutput.writeInt(this.unused1);
/* 48 */     paramLittleEndianOutput.writeInt(this.unused2);
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 52 */     return FormulaError.REF.getString();
/*    */   }
/*    */   
/*    */   public byte getDefaultOperandClass() {
/* 56 */     return 0;
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 60 */     return 9;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\AreaErrPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */