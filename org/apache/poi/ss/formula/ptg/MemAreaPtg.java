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
/*    */ public final class MemAreaPtg
/*    */   extends OperandPtg
/*    */ {
/*    */   public static final short sid = 38;
/*    */   private static final int SIZE = 7;
/*    */   private final int field_1_reserved;
/*    */   private final int field_2_subex_len;
/*    */   
/*    */   public MemAreaPtg(int paramInt) {
/* 35 */     this.field_1_reserved = 0;
/* 36 */     this.field_2_subex_len = paramInt;
/*    */   }
/*    */   
/*    */   public MemAreaPtg(LittleEndianInput paramLittleEndianInput) {
/* 40 */     this.field_1_reserved = paramLittleEndianInput.readInt();
/* 41 */     this.field_2_subex_len = paramLittleEndianInput.readShort();
/*    */   }
/*    */   
/*    */   public int getLenRefSubexpression() {
/* 45 */     return this.field_2_subex_len;
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 49 */     paramLittleEndianOutput.writeByte(38 + getPtgClass());
/* 50 */     paramLittleEndianOutput.writeInt(this.field_1_reserved);
/* 51 */     paramLittleEndianOutput.writeShort(this.field_2_subex_len);
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 55 */     return 7;
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 59 */     return "";
/*    */   }
/*    */   
/*    */   public byte getDefaultOperandClass() {
/* 63 */     return 32;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/* 68 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 69 */     stringBuffer.append(getClass().getName()).append(" [len=");
/* 70 */     stringBuffer.append(this.field_2_subex_len);
/* 71 */     stringBuffer.append("]");
/* 72 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\MemAreaPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */