/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
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
/*    */ public abstract class StandardRecord
/*    */   extends Record
/*    */ {
/*    */   protected abstract int getDataSize();
/*    */   
/*    */   public final int getRecordSize() {
/* 30 */     return 4 + getDataSize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int serialize(int paramInt, byte[] paramArrayOfbyte) {
/* 41 */     int i = getDataSize();
/* 42 */     int j = 4 + i;
/* 43 */     LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(paramArrayOfbyte, paramInt, j);
/* 44 */     littleEndianByteArrayOutputStream.writeShort(getSid());
/* 45 */     littleEndianByteArrayOutputStream.writeShort(i);
/* 46 */     serialize((LittleEndianOutput)littleEndianByteArrayOutputStream);
/* 47 */     if (littleEndianByteArrayOutputStream.getWriteIndex() - paramInt != j) {
/* 48 */       throw new IllegalStateException("Error in serialization of (" + getClass().getName() + "): " + "Incorrect number of bytes written - expected " + j + " but got " + (littleEndianByteArrayOutputStream.getWriteIndex() - paramInt));
/*    */     }
/*    */ 
/*    */     
/* 52 */     return j;
/*    */   }
/*    */   
/*    */   protected abstract void serialize(LittleEndianOutput paramLittleEndianOutput);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\StandardRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */