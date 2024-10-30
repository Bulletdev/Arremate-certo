/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.hssf.record.common.UnicodeString;
/*    */ import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
/*    */ import org.apache.poi.util.IntMapper;
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
/*    */ final class SSTSerializer
/*    */ {
/*    */   private final int _numStrings;
/*    */   private final int _numUniqueStrings;
/*    */   private final IntMapper<UnicodeString> strings;
/*    */   private final int[] bucketAbsoluteOffsets;
/*    */   private final int[] bucketRelativeOffsets;
/*    */   
/*    */   public SSTSerializer(IntMapper<UnicodeString> paramIntMapper, int paramInt1, int paramInt2) {
/* 44 */     this.strings = paramIntMapper;
/* 45 */     this._numStrings = paramInt1;
/* 46 */     this._numUniqueStrings = paramInt2;
/*    */     
/* 48 */     int i = ExtSSTRecord.getNumberOfInfoRecsForStrings(paramIntMapper.size());
/* 49 */     this.bucketAbsoluteOffsets = new int[i];
/* 50 */     this.bucketRelativeOffsets = new int[i];
/*    */   }
/*    */   
/*    */   public void serialize(ContinuableRecordOutput paramContinuableRecordOutput) {
/* 54 */     paramContinuableRecordOutput.writeInt(this._numStrings);
/* 55 */     paramContinuableRecordOutput.writeInt(this._numUniqueStrings);
/*    */     
/* 57 */     for (byte b = 0; b < this.strings.size(); b++) {
/*    */       
/* 59 */       if (b % 8 == 0) {
/*    */         
/* 61 */         int i = paramContinuableRecordOutput.getTotalSize();
/* 62 */         int j = b / 8;
/* 63 */         if (j < 128) {
/*    */           
/* 65 */           this.bucketAbsoluteOffsets[j] = i;
/* 66 */           this.bucketRelativeOffsets[j] = i;
/*    */         } 
/*    */       } 
/* 69 */       UnicodeString unicodeString = getUnicodeString(b);
/* 70 */       unicodeString.serialize(paramContinuableRecordOutput);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private UnicodeString getUnicodeString(int paramInt) {
/* 77 */     return getUnicodeString(this.strings, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   private static UnicodeString getUnicodeString(IntMapper<UnicodeString> paramIntMapper, int paramInt) {
/* 82 */     return (UnicodeString)paramIntMapper.get(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] getBucketAbsoluteOffsets() {
/* 87 */     return this.bucketAbsoluteOffsets;
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] getBucketRelativeOffsets() {
/* 92 */     return this.bucketRelativeOffsets;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\SSTSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */