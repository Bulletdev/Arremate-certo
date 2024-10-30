/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.util.HexDump;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FtCblsSubRecord
/*    */   extends SubRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 12;
/*    */   private static final int ENCODED_SIZE = 20;
/*    */   private byte[] reserved;
/*    */   
/*    */   public FtCblsSubRecord() {
/* 42 */     this.reserved = new byte[20];
/*    */   }
/*    */   
/*    */   public FtCblsSubRecord(LittleEndianInput paramLittleEndianInput, int paramInt) {
/* 46 */     if (paramInt != 20) {
/* 47 */       throw new RecordFormatException("Unexpected size (" + paramInt + ")");
/*    */     }
/*    */     
/* 50 */     byte[] arrayOfByte = new byte[paramInt];
/* 51 */     paramLittleEndianInput.readFully(arrayOfByte);
/* 52 */     this.reserved = arrayOfByte;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 63 */     stringBuffer.append("[FtCbls ]").append("\n");
/* 64 */     stringBuffer.append("  size     = ").append(getDataSize()).append("\n");
/* 65 */     stringBuffer.append("  reserved = ").append(HexDump.toHex(this.reserved)).append("\n");
/* 66 */     stringBuffer.append("[/FtCbls ]").append("\n");
/* 67 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 76 */     paramLittleEndianOutput.writeShort(12);
/* 77 */     paramLittleEndianOutput.writeShort(this.reserved.length);
/* 78 */     paramLittleEndianOutput.write(this.reserved);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 82 */     return this.reserved.length;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 90 */     return 12;
/*    */   }
/*    */ 
/*    */   
/*    */   public FtCblsSubRecord clone() {
/* 95 */     FtCblsSubRecord ftCblsSubRecord = new FtCblsSubRecord();
/* 96 */     byte[] arrayOfByte = new byte[this.reserved.length];
/* 97 */     System.arraycopy(this.reserved, 0, arrayOfByte, 0, arrayOfByte.length);
/* 98 */     ftCblsSubRecord.reserved = arrayOfByte;
/* 99 */     return ftCblsSubRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FtCblsSubRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */