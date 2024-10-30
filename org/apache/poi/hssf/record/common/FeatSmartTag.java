/*    */ package org.apache.poi.hssf.record.common;
/*    */ 
/*    */ import org.apache.poi.hssf.record.RecordInputStream;
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
/*    */ public final class FeatSmartTag
/*    */   implements SharedFeature
/*    */ {
/*    */   private byte[] data;
/*    */   
/*    */   public FeatSmartTag() {
/* 41 */     this.data = new byte[0];
/*    */   }
/*    */   
/*    */   public FeatSmartTag(RecordInputStream paramRecordInputStream) {
/* 45 */     this.data = paramRecordInputStream.readRemainder();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 49 */     StringBuffer stringBuffer = new StringBuffer();
/* 50 */     stringBuffer.append(" [FEATURE SMART TAGS]\n");
/* 51 */     stringBuffer.append(" [/FEATURE SMART TAGS]\n");
/* 52 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public int getDataSize() {
/* 56 */     return this.data.length;
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 60 */     paramLittleEndianOutput.write(this.data);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\common\FeatSmartTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */