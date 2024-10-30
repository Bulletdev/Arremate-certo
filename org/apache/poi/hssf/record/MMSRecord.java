/*     */ package org.apache.poi.hssf.record;
/*     */ 
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
/*     */ public final class MMSRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 193;
/*     */   private byte field_1_addMenuCount;
/*     */   private byte field_2_delMenuCount;
/*     */   
/*     */   public MMSRecord() {}
/*     */   
/*     */   public MMSRecord(RecordInputStream paramRecordInputStream) {
/*  46 */     if (paramRecordInputStream.remaining() == 0) {
/*     */       return;
/*     */     }
/*     */     
/*  50 */     this.field_1_addMenuCount = paramRecordInputStream.readByte();
/*  51 */     this.field_2_delMenuCount = paramRecordInputStream.readByte();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddMenuCount(byte paramByte) {
/*  61 */     this.field_1_addMenuCount = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDelMenuCount(byte paramByte) {
/*  71 */     this.field_2_delMenuCount = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getAddMenuCount() {
/*  81 */     return this.field_1_addMenuCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getDelMenuCount() {
/*  91 */     return this.field_2_delMenuCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  98 */     stringBuffer.append("[MMS]\n");
/*  99 */     stringBuffer.append("    .addMenu        = ").append(Integer.toHexString(getAddMenuCount())).append("\n");
/*     */     
/* 101 */     stringBuffer.append("    .delMenu        = ").append(Integer.toHexString(getDelMenuCount())).append("\n");
/*     */     
/* 103 */     stringBuffer.append("[/MMS]\n");
/* 104 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 108 */     paramLittleEndianOutput.writeByte(getAddMenuCount());
/* 109 */     paramLittleEndianOutput.writeByte(getDelMenuCount());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 113 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 118 */     return 193;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\MMSRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */