/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.hssf.record.common.UnicodeString;
/*     */ import org.apache.poi.hssf.record.cont.ContinuableRecord;
/*     */ import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
/*     */ import org.apache.poi.util.IntMapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SSTRecord
/*     */   extends ContinuableRecord
/*     */ {
/*     */   public static final short sid = 252;
/*  41 */   private static final UnicodeString EMPTY_STRING = new UnicodeString("");
/*     */ 
/*     */   
/*     */   static final int STD_RECORD_OVERHEAD = 4;
/*     */ 
/*     */   
/*     */   static final int SST_RECORD_OVERHEAD = 12;
/*     */ 
/*     */   
/*     */   static final int MAX_DATA_SPACE = 8216;
/*     */ 
/*     */   
/*     */   private int field_1_num_strings;
/*     */ 
/*     */   
/*     */   private int field_2_num_unique_strings;
/*     */ 
/*     */   
/*     */   private IntMapper<UnicodeString> field_3_strings;
/*     */   
/*     */   private SSTDeserializer deserializer;
/*     */   
/*     */   int[] bucketAbsoluteOffsets;
/*     */   
/*     */   int[] bucketRelativeOffsets;
/*     */ 
/*     */   
/*     */   public SSTRecord() {
/*  69 */     this.field_1_num_strings = 0;
/*  70 */     this.field_2_num_unique_strings = 0;
/*  71 */     this.field_3_strings = new IntMapper();
/*  72 */     this.deserializer = new SSTDeserializer(this.field_3_strings);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addString(UnicodeString paramUnicodeString) {
/*     */     int i;
/*  84 */     this.field_1_num_strings++;
/*  85 */     UnicodeString unicodeString = (paramUnicodeString == null) ? EMPTY_STRING : paramUnicodeString;
/*     */ 
/*     */     
/*  88 */     int j = this.field_3_strings.getIndex(unicodeString);
/*     */     
/*  90 */     if (j != -1) {
/*  91 */       i = j;
/*     */     }
/*     */     else {
/*     */       
/*  95 */       i = this.field_3_strings.size();
/*  96 */       this.field_2_num_unique_strings++;
/*  97 */       SSTDeserializer.addToStringTable(this.field_3_strings, unicodeString);
/*     */     } 
/*  99 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumStrings() {
/* 107 */     return this.field_1_num_strings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumUniqueStrings() {
/* 115 */     return this.field_2_num_unique_strings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnicodeString getString(int paramInt) {
/* 128 */     return (UnicodeString)this.field_3_strings.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 138 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 140 */     stringBuffer.append("[SST]\n");
/* 141 */     stringBuffer.append("    .numstrings     = ").append(Integer.toHexString(getNumStrings())).append("\n");
/*     */     
/* 143 */     stringBuffer.append("    .uniquestrings  = ").append(Integer.toHexString(getNumUniqueStrings())).append("\n");
/*     */     
/* 145 */     for (byte b = 0; b < this.field_3_strings.size(); b++) {
/*     */       
/* 147 */       UnicodeString unicodeString = (UnicodeString)this.field_3_strings.get(b);
/* 148 */       stringBuffer.append("    .string_" + b + "      = ").append(unicodeString.getDebugInfo()).append("\n");
/*     */     } 
/*     */     
/* 151 */     stringBuffer.append("[/SST]\n");
/* 152 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 156 */     return 252;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SSTRecord(RecordInputStream paramRecordInputStream) {
/* 241 */     this.field_1_num_strings = paramRecordInputStream.readInt();
/* 242 */     this.field_2_num_unique_strings = paramRecordInputStream.readInt();
/* 243 */     this.field_3_strings = new IntMapper();
/*     */     
/* 245 */     this.deserializer = new SSTDeserializer(this.field_3_strings);
/*     */ 
/*     */     
/* 248 */     if (this.field_1_num_strings == 0) {
/* 249 */       this.field_2_num_unique_strings = 0;
/*     */       return;
/*     */     } 
/* 252 */     this.deserializer.manufactureStrings(this.field_2_num_unique_strings, paramRecordInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Iterator<UnicodeString> getStrings() {
/* 262 */     return this.field_3_strings.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int countStrings() {
/* 269 */     return this.field_3_strings.size();
/*     */   }
/*     */   
/*     */   protected void serialize(ContinuableRecordOutput paramContinuableRecordOutput) {
/* 273 */     SSTSerializer sSTSerializer = new SSTSerializer(this.field_3_strings, getNumStrings(), getNumUniqueStrings());
/* 274 */     sSTSerializer.serialize(paramContinuableRecordOutput);
/* 275 */     this.bucketAbsoluteOffsets = sSTSerializer.getBucketAbsoluteOffsets();
/* 276 */     this.bucketRelativeOffsets = sSTSerializer.getBucketRelativeOffsets();
/*     */   }
/*     */   
/*     */   SSTDeserializer getDeserializer() {
/* 280 */     return this.deserializer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtSSTRecord createExtSSTRecord(int paramInt) {
/* 297 */     if (this.bucketAbsoluteOffsets == null || this.bucketRelativeOffsets == null) {
/* 298 */       throw new IllegalStateException("SST record has not yet been serialized.");
/*     */     }
/*     */     
/* 301 */     ExtSSTRecord extSSTRecord = new ExtSSTRecord();
/* 302 */     extSSTRecord.setNumStringsPerBucket((short)8);
/* 303 */     int[] arrayOfInt1 = (int[])this.bucketAbsoluteOffsets.clone();
/* 304 */     int[] arrayOfInt2 = (int[])this.bucketRelativeOffsets.clone();
/* 305 */     for (byte b = 0; b < arrayOfInt1.length; b++) {
/* 306 */       arrayOfInt1[b] = arrayOfInt1[b] + paramInt;
/*     */     }
/* 308 */     extSSTRecord.setBucketOffsets(arrayOfInt1, arrayOfInt2);
/* 309 */     return extSSTRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int calcExtSSTRecordSize() {
/* 319 */     return ExtSSTRecord.getRecordSizeForStrings(this.field_3_strings.size());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\SSTRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */