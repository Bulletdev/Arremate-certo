/*    */ package org.apache.poi.hssf.record.chart;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import org.apache.poi.hssf.record.RecordInputStream;
/*    */ import org.apache.poi.hssf.record.StandardRecord;
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
/*    */ public final class SeriesListRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 4118;
/*    */   private short[] field_1_seriesNumbers;
/*    */   
/*    */   public SeriesListRecord(short[] paramArrayOfshort) {
/* 39 */     this.field_1_seriesNumbers = (paramArrayOfshort == null) ? null : (short[])paramArrayOfshort.clone();
/*    */   }
/*    */   
/*    */   public SeriesListRecord(RecordInputStream paramRecordInputStream) {
/* 43 */     int i = paramRecordInputStream.readUShort();
/* 44 */     short[] arrayOfShort = new short[i];
/* 45 */     for (byte b = 0; b < i; b++) {
/* 46 */       arrayOfShort[b] = paramRecordInputStream.readShort();
/*    */     }
/*    */     
/* 49 */     this.field_1_seriesNumbers = arrayOfShort;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 53 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 55 */     stringBuffer.append("[SERIESLIST]\n");
/* 56 */     stringBuffer.append("    .seriesNumbers= ").append(" (").append(Arrays.toString(getSeriesNumbers())).append(" )");
/* 57 */     stringBuffer.append("\n");
/*    */     
/* 59 */     stringBuffer.append("[/SERIESLIST]\n");
/* 60 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 65 */     int i = this.field_1_seriesNumbers.length;
/* 66 */     paramLittleEndianOutput.writeShort(i);
/* 67 */     for (byte b = 0; b < i; b++) {
/* 68 */       paramLittleEndianOutput.writeShort(this.field_1_seriesNumbers[b]);
/*    */     }
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 73 */     return this.field_1_seriesNumbers.length * 2 + 2;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 77 */     return 4118;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 81 */     return new SeriesListRecord(this.field_1_seriesNumbers);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short[] getSeriesNumbers() {
/* 88 */     return this.field_1_seriesNumbers;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\SeriesListRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */