/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.util.HexDump;
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
/*    */ public final class ContinueRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 60;
/*    */   private byte[] _data;
/*    */   
/*    */   public ContinueRecord(byte[] paramArrayOfbyte) {
/* 36 */     this._data = paramArrayOfbyte;
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 40 */     return this._data.length;
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 44 */     paramLittleEndianOutput.write(this._data);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] getData() {
/* 52 */     return this._data;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 58 */     stringBuffer.append("[CONTINUE RECORD]\n");
/* 59 */     stringBuffer.append("    .data = ").append(HexDump.toHex(this._data)).append("\n");
/* 60 */     stringBuffer.append("[/CONTINUE RECORD]\n");
/* 61 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 65 */     return 60;
/*    */   }
/*    */   
/*    */   public ContinueRecord(RecordInputStream paramRecordInputStream) {
/* 69 */     this._data = paramRecordInputStream.readRemainder();
/*    */   }
/*    */ 
/*    */   
/*    */   public ContinueRecord clone() {
/* 74 */     return new ContinueRecord(this._data);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ContinueRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */