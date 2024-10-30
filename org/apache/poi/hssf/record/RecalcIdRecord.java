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
/*    */ public final class RecalcIdRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 449;
/*    */   private final int _reserved0;
/*    */   private int _engineId;
/*    */   
/*    */   public RecalcIdRecord() {
/* 48 */     this._reserved0 = 0;
/* 49 */     this._engineId = 0;
/*    */   }
/*    */   
/*    */   public RecalcIdRecord(RecordInputStream paramRecordInputStream) {
/* 53 */     paramRecordInputStream.readUShort();
/* 54 */     this._reserved0 = paramRecordInputStream.readUShort();
/* 55 */     this._engineId = paramRecordInputStream.readInt();
/*    */   }
/*    */   
/*    */   public boolean isNeeded() {
/* 59 */     return true;
/*    */   }
/*    */   
/*    */   public void setEngineId(int paramInt) {
/* 63 */     this._engineId = paramInt;
/*    */   }
/*    */   
/*    */   public int getEngineId() {
/* 67 */     return this._engineId;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 73 */     stringBuffer.append("[RECALCID]\n");
/* 74 */     stringBuffer.append("    .reserved = ").append(HexDump.shortToHex(this._reserved0)).append("\n");
/* 75 */     stringBuffer.append("    .engineId = ").append(HexDump.intToHex(this._engineId)).append("\n");
/* 76 */     stringBuffer.append("[/RECALCID]\n");
/* 77 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 81 */     paramLittleEndianOutput.writeShort(449);
/* 82 */     paramLittleEndianOutput.writeShort(this._reserved0);
/* 83 */     paramLittleEndianOutput.writeInt(this._engineId);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 87 */     return 8;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 91 */     return 449;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\RecalcIdRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */