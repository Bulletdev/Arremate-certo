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
/*    */ public final class DrawingRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 236;
/* 27 */   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*    */   
/*    */   private byte[] recordData;
/*    */   private byte[] contd;
/*    */   
/*    */   public DrawingRecord() {
/* 33 */     this.recordData = EMPTY_BYTE_ARRAY;
/*    */   }
/*    */   
/*    */   public DrawingRecord(RecordInputStream paramRecordInputStream) {
/* 37 */     this.recordData = paramRecordInputStream.readRemainder();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public void processContinueRecord(byte[] paramArrayOfbyte) {
/* 46 */     this.contd = paramArrayOfbyte;
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 50 */     paramLittleEndianOutput.write(this.recordData);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 54 */     return this.recordData.length;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 58 */     return 236;
/*    */   }
/*    */   
/*    */   public byte[] getRecordData() {
/* 62 */     return this.recordData;
/*    */   }
/*    */   
/*    */   public void setData(byte[] paramArrayOfbyte) {
/* 66 */     if (paramArrayOfbyte == null) {
/* 67 */       throw new IllegalArgumentException("data must not be null");
/*    */     }
/* 69 */     this.recordData = paramArrayOfbyte;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DrawingRecord clone() {
/* 78 */     DrawingRecord drawingRecord = new DrawingRecord();
/* 79 */     drawingRecord.recordData = (byte[])this.recordData.clone();
/* 80 */     if (this.contd != null)
/*    */     {
/* 82 */       drawingRecord.contd = (byte[])this.contd.clone();
/*    */     }
/*    */     
/* 85 */     return drawingRecord;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 90 */     return "DrawingRecord[" + this.recordData.length + "]";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DrawingRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */