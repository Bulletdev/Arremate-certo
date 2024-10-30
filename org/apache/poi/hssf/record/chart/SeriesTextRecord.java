/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public final class SeriesTextRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 4109;
/*     */   private static final int MAX_LEN = 255;
/*     */   private int field_1_id;
/*     */   private boolean is16bit;
/*     */   private String field_4_text;
/*     */   
/*     */   public SeriesTextRecord() {
/*  40 */     this.field_4_text = "";
/*  41 */     this.is16bit = false;
/*     */   }
/*     */   
/*     */   public SeriesTextRecord(RecordInputStream paramRecordInputStream) {
/*  45 */     this.field_1_id = paramRecordInputStream.readUShort();
/*  46 */     int i = paramRecordInputStream.readUByte();
/*  47 */     this.is16bit = ((paramRecordInputStream.readUByte() & 0x1) != 0);
/*  48 */     if (this.is16bit) {
/*  49 */       this.field_4_text = paramRecordInputStream.readUnicodeLEString(i);
/*     */     } else {
/*  51 */       this.field_4_text = paramRecordInputStream.readCompressedUnicode(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String toString() {
/*  56 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  58 */     stringBuffer.append("[SERIESTEXT]\n");
/*  59 */     stringBuffer.append("  .id     =").append(HexDump.shortToHex(getId())).append('\n');
/*  60 */     stringBuffer.append("  .textLen=").append(this.field_4_text.length()).append('\n');
/*  61 */     stringBuffer.append("  .is16bit=").append(this.is16bit).append('\n');
/*  62 */     stringBuffer.append("  .text   =").append(" (").append(getText()).append(" )").append('\n');
/*  63 */     stringBuffer.append("[/SERIESTEXT]\n");
/*  64 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  69 */     paramLittleEndianOutput.writeShort(this.field_1_id);
/*  70 */     paramLittleEndianOutput.writeByte(this.field_4_text.length());
/*  71 */     if (this.is16bit) {
/*     */       
/*  73 */       paramLittleEndianOutput.writeByte(1);
/*  74 */       StringUtil.putUnicodeLE(this.field_4_text, paramLittleEndianOutput);
/*     */     } else {
/*     */       
/*  77 */       paramLittleEndianOutput.writeByte(0);
/*  78 */       StringUtil.putCompressedUnicode(this.field_4_text, paramLittleEndianOutput);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  83 */     return 4 + this.field_4_text.length() * (this.is16bit ? 2 : 1);
/*     */   }
/*     */   
/*     */   public short getSid() {
/*  87 */     return 4109;
/*     */   }
/*     */   
/*     */   public Object clone() {
/*  91 */     SeriesTextRecord seriesTextRecord = new SeriesTextRecord();
/*     */     
/*  93 */     seriesTextRecord.field_1_id = this.field_1_id;
/*  94 */     seriesTextRecord.is16bit = this.is16bit;
/*  95 */     seriesTextRecord.field_4_text = this.field_4_text;
/*  96 */     return seriesTextRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getId() {
/* 103 */     return this.field_1_id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setId(int paramInt) {
/* 110 */     this.field_1_id = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 117 */     return this.field_4_text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(String paramString) {
/* 124 */     if (paramString.length() > 255) {
/* 125 */       throw new IllegalArgumentException("Text is too long (" + paramString.length() + ">" + 'ÿ' + ")");
/*     */     }
/*     */     
/* 128 */     this.field_4_text = paramString;
/* 129 */     this.is16bit = StringUtil.hasMultibyte(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\SeriesTextRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */