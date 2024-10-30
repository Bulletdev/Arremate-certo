/*     */ package org.apache.poi.hssf.record;
/*     */ 
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
/*     */ public final class FormatRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 1054;
/*     */   private final int field_1_index_code;
/*     */   private final boolean field_3_hasMultibyte;
/*     */   private final String field_4_formatstring;
/*     */   
/*     */   private FormatRecord(FormatRecord paramFormatRecord) {
/*  38 */     this.field_1_index_code = paramFormatRecord.field_1_index_code;
/*  39 */     this.field_3_hasMultibyte = paramFormatRecord.field_3_hasMultibyte;
/*  40 */     this.field_4_formatstring = paramFormatRecord.field_4_formatstring;
/*     */   }
/*     */   
/*     */   public FormatRecord(int paramInt, String paramString) {
/*  44 */     this.field_1_index_code = paramInt;
/*  45 */     this.field_4_formatstring = paramString;
/*  46 */     this.field_3_hasMultibyte = StringUtil.hasMultibyte(paramString);
/*     */   }
/*     */   
/*     */   public FormatRecord(RecordInputStream paramRecordInputStream) {
/*  50 */     this.field_1_index_code = paramRecordInputStream.readShort();
/*  51 */     int i = paramRecordInputStream.readUShort();
/*  52 */     this.field_3_hasMultibyte = ((paramRecordInputStream.readByte() & 0x1) != 0);
/*     */     
/*  54 */     if (this.field_3_hasMultibyte) {
/*  55 */       this.field_4_formatstring = paramRecordInputStream.readUnicodeLEString(i);
/*     */     } else {
/*  57 */       this.field_4_formatstring = paramRecordInputStream.readCompressedUnicode(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIndexCode() {
/*  68 */     return this.field_1_index_code;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormatString() {
/*  77 */     return this.field_4_formatstring;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  81 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  83 */     stringBuffer.append("[FORMAT]\n");
/*  84 */     stringBuffer.append("    .indexcode       = ").append(HexDump.shortToHex(getIndexCode())).append("\n");
/*  85 */     stringBuffer.append("    .isUnicode       = ").append(this.field_3_hasMultibyte).append("\n");
/*  86 */     stringBuffer.append("    .formatstring    = ").append(getFormatString()).append("\n");
/*  87 */     stringBuffer.append("[/FORMAT]\n");
/*  88 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  92 */     String str = getFormatString();
/*  93 */     paramLittleEndianOutput.writeShort(getIndexCode());
/*  94 */     paramLittleEndianOutput.writeShort(str.length());
/*  95 */     paramLittleEndianOutput.writeByte(this.field_3_hasMultibyte ? 1 : 0);
/*     */     
/*  97 */     if (this.field_3_hasMultibyte) {
/*  98 */       StringUtil.putUnicodeLE(str, paramLittleEndianOutput);
/*     */     } else {
/* 100 */       StringUtil.putCompressedUnicode(str, paramLittleEndianOutput);
/*     */     } 
/*     */   }
/*     */   protected int getDataSize() {
/* 104 */     return 5 + getFormatString().length() * (this.field_3_hasMultibyte ? 2 : 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 109 */     return 1054;
/*     */   }
/*     */ 
/*     */   
/*     */   public FormatRecord clone() {
/* 114 */     return new FormatRecord(this);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FormatRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */