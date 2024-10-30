/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.apache.poi.hssf.record.cont.ContinuableRecord;
/*     */ import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
/*     */ import org.apache.poi.util.LittleEndianOutput;
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
/*     */ public final class ExtSSTRecord
/*     */   extends ContinuableRecord
/*     */ {
/*     */   public static final short sid = 255;
/*     */   public static final int DEFAULT_BUCKET_SIZE = 8;
/*     */   public static final int MAX_BUCKETS = 128;
/*     */   private short _stringsPerBucket;
/*     */   private InfoSubRecord[] _sstInfos;
/*     */   
/*     */   public static final class InfoSubRecord
/*     */   {
/*     */     public static final int ENCODED_SIZE = 8;
/*     */     private int field_1_stream_pos;
/*     */     private int field_2_bucket_sst_offset;
/*     */     private short field_3_zero;
/*     */     
/*     */     public InfoSubRecord(int param1Int1, int param1Int2) {
/*  56 */       this.field_1_stream_pos = param1Int1;
/*  57 */       this.field_2_bucket_sst_offset = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public InfoSubRecord(RecordInputStream param1RecordInputStream) {
/*  62 */       this.field_1_stream_pos = param1RecordInputStream.readInt();
/*  63 */       this.field_2_bucket_sst_offset = param1RecordInputStream.readShort();
/*  64 */       this.field_3_zero = param1RecordInputStream.readShort();
/*     */     }
/*     */     
/*     */     public int getStreamPos() {
/*  68 */       return this.field_1_stream_pos;
/*     */     }
/*     */     
/*     */     public int getBucketSSTOffset() {
/*  72 */       return this.field_2_bucket_sst_offset;
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/*  76 */       param1LittleEndianOutput.writeInt(this.field_1_stream_pos);
/*  77 */       param1LittleEndianOutput.writeShort(this.field_2_bucket_sst_offset);
/*  78 */       param1LittleEndianOutput.writeShort(this.field_3_zero);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtSSTRecord() {
/*  88 */     this._stringsPerBucket = 8;
/*  89 */     this._sstInfos = new InfoSubRecord[0];
/*     */   }
/*     */   
/*     */   public ExtSSTRecord(RecordInputStream paramRecordInputStream) {
/*  93 */     this._stringsPerBucket = paramRecordInputStream.readShort();
/*     */     
/*  95 */     int i = paramRecordInputStream.remaining() / 8;
/*  96 */     ArrayList<InfoSubRecord> arrayList = new ArrayList(i);
/*     */     
/*  98 */     while (paramRecordInputStream.available() > 0) {
/*  99 */       InfoSubRecord infoSubRecord = new InfoSubRecord(paramRecordInputStream);
/* 100 */       arrayList.add(infoSubRecord);
/*     */       
/* 102 */       if (paramRecordInputStream.available() == 0 && paramRecordInputStream.hasNextRecord() && paramRecordInputStream.getNextSid() == 60) {
/* 103 */         paramRecordInputStream.nextRecord();
/*     */       }
/*     */     } 
/* 106 */     this._sstInfos = arrayList.<InfoSubRecord>toArray(new InfoSubRecord[arrayList.size()]);
/*     */   }
/*     */   
/*     */   public void setNumStringsPerBucket(short paramShort) {
/* 110 */     this._stringsPerBucket = paramShort;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 116 */     stringBuffer.append("[EXTSST]\n");
/* 117 */     stringBuffer.append("    .dsst           = ").append(Integer.toHexString(this._stringsPerBucket)).append("\n");
/*     */ 
/*     */     
/* 120 */     stringBuffer.append("    .numInfoRecords = ").append(this._sstInfos.length).append("\n");
/*     */     
/* 122 */     for (byte b = 0; b < this._sstInfos.length; b++) {
/*     */       
/* 124 */       stringBuffer.append("    .inforecord     = ").append(b).append("\n");
/* 125 */       stringBuffer.append("    .streampos      = ").append(Integer.toHexString(this._sstInfos[b].getStreamPos())).append("\n");
/*     */ 
/*     */       
/* 128 */       stringBuffer.append("    .sstoffset      = ").append(Integer.toHexString(this._sstInfos[b].getBucketSSTOffset())).append("\n");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 133 */     stringBuffer.append("[/EXTSST]\n");
/* 134 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(ContinuableRecordOutput paramContinuableRecordOutput) {
/* 138 */     paramContinuableRecordOutput.writeShort(this._stringsPerBucket);
/* 139 */     for (byte b = 0; b < this._sstInfos.length; b++)
/* 140 */       this._sstInfos[b].serialize((LittleEndianOutput)paramContinuableRecordOutput); 
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 144 */     return 2 + 8 * this._sstInfos.length;
/*     */   }
/*     */   
/*     */   protected InfoSubRecord[] getInfoSubRecords() {
/* 148 */     return this._sstInfos;
/*     */   }
/*     */   
/*     */   public static final int getNumberOfInfoRecsForStrings(int paramInt) {
/* 152 */     int i = paramInt / 8;
/* 153 */     if (paramInt % 8 != 0) {
/* 154 */       i++;
/*     */     }
/*     */     
/* 157 */     if (i > 128)
/* 158 */       i = 128; 
/* 159 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int getRecordSizeForStrings(int paramInt) {
/* 170 */     return 6 + getNumberOfInfoRecsForStrings(paramInt) * 8;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 174 */     return 255;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBucketOffsets(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/* 179 */     this._sstInfos = new InfoSubRecord[paramArrayOfint1.length];
/* 180 */     for (byte b = 0; b < paramArrayOfint1.length; b++)
/* 181 */       this._sstInfos[b] = new InfoSubRecord(paramArrayOfint1[b], paramArrayOfint2[b]); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ExtSSTRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */