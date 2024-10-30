/*    */ package org.apache.poi.hssf.record;
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
/*    */ 
/*    */ 
/*    */ public final class AutoFilterInfoRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 157;
/*    */   private short _cEntries;
/*    */   
/*    */   public AutoFilterInfoRecord() {}
/*    */   
/*    */   public AutoFilterInfoRecord(RecordInputStream paramRecordInputStream) {
/* 44 */     this._cEntries = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setNumEntries(short paramShort) {
/* 55 */     this._cEntries = paramShort;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getNumEntries() {
/* 66 */     return this._cEntries;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 73 */     stringBuffer.append("[AUTOFILTERINFO]\n");
/* 74 */     stringBuffer.append("    .numEntries          = ").append(this._cEntries).append("\n");
/*    */     
/* 76 */     stringBuffer.append("[/AUTOFILTERINFO]\n");
/* 77 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 81 */     paramLittleEndianOutput.writeShort(this._cEntries);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 85 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 90 */     return 157;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AutoFilterInfoRecord clone() {
/* 96 */     return (AutoFilterInfoRecord)cloneViaReserialise();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\AutoFilterInfoRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */