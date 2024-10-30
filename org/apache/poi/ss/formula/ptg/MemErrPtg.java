/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
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
/*    */ 
/*    */ public final class MemErrPtg
/*    */   extends OperandPtg
/*    */ {
/*    */   public static final short sid = 39;
/*    */   private static final int SIZE = 7;
/*    */   private int field_1_reserved;
/*    */   private short field_2_subex_len;
/*    */   
/*    */   public MemErrPtg(LittleEndianInput paramLittleEndianInput) {
/* 36 */     this.field_1_reserved = paramLittleEndianInput.readInt();
/* 37 */     this.field_2_subex_len = paramLittleEndianInput.readShort();
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 41 */     paramLittleEndianOutput.writeByte(39 + getPtgClass());
/* 42 */     paramLittleEndianOutput.writeInt(this.field_1_reserved);
/* 43 */     paramLittleEndianOutput.writeShort(this.field_2_subex_len);
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 47 */     return 7;
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 51 */     return "ERR#";
/*    */   }
/*    */   
/*    */   public byte getDefaultOperandClass() {
/* 55 */     return 32;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\MemErrPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */