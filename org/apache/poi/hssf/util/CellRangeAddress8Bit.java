/*    */ package org.apache.poi.hssf.util;
/*    */ 
/*    */ import org.apache.poi.ss.util.CellRangeAddressBase;
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
/*    */ public final class CellRangeAddress8Bit
/*    */   extends CellRangeAddressBase
/*    */ {
/*    */   public static final int ENCODED_SIZE = 6;
/*    */   
/*    */   public CellRangeAddress8Bit(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 34 */     super(paramInt1, paramInt2, paramInt3, paramInt4);
/*    */   }
/*    */   
/*    */   public CellRangeAddress8Bit(LittleEndianInput paramLittleEndianInput) {
/* 38 */     super(readUShortAndCheck(paramLittleEndianInput), paramLittleEndianInput.readUShort(), paramLittleEndianInput.readUByte(), paramLittleEndianInput.readUByte());
/*    */   }
/*    */   
/*    */   private static int readUShortAndCheck(LittleEndianInput paramLittleEndianInput) {
/* 42 */     if (paramLittleEndianInput.available() < 6)
/*    */     {
/* 44 */       throw new RuntimeException("Ran out of data reading CellRangeAddress");
/*    */     }
/* 46 */     return paramLittleEndianInput.readUShort();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 50 */     paramLittleEndianOutput.writeShort(getFirstRow());
/* 51 */     paramLittleEndianOutput.writeShort(getLastRow());
/* 52 */     paramLittleEndianOutput.writeByte(getFirstColumn());
/* 53 */     paramLittleEndianOutput.writeByte(getLastColumn());
/*    */   }
/*    */   
/*    */   public CellRangeAddress8Bit copy() {
/* 57 */     return new CellRangeAddress8Bit(getFirstRow(), getLastRow(), getFirstColumn(), getLastColumn());
/*    */   }
/*    */   
/*    */   public static int getEncodedSize(int paramInt) {
/* 61 */     return paramInt * 6;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\util\CellRangeAddress8Bit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */