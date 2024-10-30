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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NameCommentRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 2196;
/*     */   private final short field_1_record_type;
/*     */   private final short field_2_frt_cell_ref_flag;
/*     */   private final long field_3_reserved;
/*     */   private String field_6_name_text;
/*     */   private String field_7_comment_text;
/*     */   
/*     */   public NameCommentRecord(String paramString1, String paramString2) {
/*  42 */     this.field_1_record_type = 0;
/*  43 */     this.field_2_frt_cell_ref_flag = 0;
/*  44 */     this.field_3_reserved = 0L;
/*  45 */     this.field_6_name_text = paramString1;
/*  46 */     this.field_7_comment_text = paramString2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  51 */     int i = this.field_6_name_text.length();
/*  52 */     int j = this.field_7_comment_text.length();
/*     */     
/*  54 */     paramLittleEndianOutput.writeShort(this.field_1_record_type);
/*  55 */     paramLittleEndianOutput.writeShort(this.field_2_frt_cell_ref_flag);
/*  56 */     paramLittleEndianOutput.writeLong(this.field_3_reserved);
/*  57 */     paramLittleEndianOutput.writeShort(i);
/*  58 */     paramLittleEndianOutput.writeShort(j);
/*     */     
/*  60 */     boolean bool1 = StringUtil.hasMultibyte(this.field_6_name_text);
/*  61 */     paramLittleEndianOutput.writeByte(bool1 ? 1 : 0);
/*  62 */     if (bool1) {
/*  63 */       StringUtil.putUnicodeLE(this.field_6_name_text, paramLittleEndianOutput);
/*     */     } else {
/*  65 */       StringUtil.putCompressedUnicode(this.field_6_name_text, paramLittleEndianOutput);
/*     */     } 
/*  67 */     boolean bool2 = StringUtil.hasMultibyte(this.field_7_comment_text);
/*  68 */     paramLittleEndianOutput.writeByte(bool2 ? 1 : 0);
/*  69 */     if (bool2) {
/*  70 */       StringUtil.putUnicodeLE(this.field_7_comment_text, paramLittleEndianOutput);
/*     */     } else {
/*  72 */       StringUtil.putCompressedUnicode(this.field_7_comment_text, paramLittleEndianOutput);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/*  78 */     return 18 + (StringUtil.hasMultibyte(this.field_6_name_text) ? (this.field_6_name_text.length() * 2) : this.field_6_name_text.length()) + (StringUtil.hasMultibyte(this.field_7_comment_text) ? (this.field_7_comment_text.length() * 2) : this.field_7_comment_text.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameCommentRecord(RecordInputStream paramRecordInputStream) {
/*  87 */     RecordInputStream recordInputStream = paramRecordInputStream;
/*  88 */     this.field_1_record_type = recordInputStream.readShort();
/*  89 */     this.field_2_frt_cell_ref_flag = recordInputStream.readShort();
/*  90 */     this.field_3_reserved = recordInputStream.readLong();
/*  91 */     short s1 = recordInputStream.readShort();
/*  92 */     short s2 = recordInputStream.readShort();
/*     */     
/*  94 */     if (recordInputStream.readByte() == 0) {
/*  95 */       this.field_6_name_text = StringUtil.readCompressedUnicode(recordInputStream, s1);
/*     */     } else {
/*  97 */       this.field_6_name_text = StringUtil.readUnicodeLE(recordInputStream, s1);
/*     */     } 
/*  99 */     if (recordInputStream.readByte() == 0) {
/* 100 */       this.field_7_comment_text = StringUtil.readCompressedUnicode(recordInputStream, s2);
/*     */     } else {
/* 102 */       this.field_7_comment_text = StringUtil.readUnicodeLE(recordInputStream, s2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 111 */     return 2196;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 116 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 118 */     stringBuffer.append("[NAMECMT]\n");
/* 119 */     stringBuffer.append("    .record type            = ").append(HexDump.shortToHex(this.field_1_record_type)).append("\n");
/* 120 */     stringBuffer.append("    .frt cell ref flag      = ").append(HexDump.byteToHex(this.field_2_frt_cell_ref_flag)).append("\n");
/* 121 */     stringBuffer.append("    .reserved               = ").append(this.field_3_reserved).append("\n");
/* 122 */     stringBuffer.append("    .name length            = ").append(this.field_6_name_text.length()).append("\n");
/* 123 */     stringBuffer.append("    .comment length         = ").append(this.field_7_comment_text.length()).append("\n");
/* 124 */     stringBuffer.append("    .name                   = ").append(this.field_6_name_text).append("\n");
/* 125 */     stringBuffer.append("    .comment                = ").append(this.field_7_comment_text).append("\n");
/* 126 */     stringBuffer.append("[/NAMECMT]\n");
/*     */     
/* 128 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNameText() {
/* 135 */     return this.field_6_name_text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNameText(String paramString) {
/* 145 */     this.field_6_name_text = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCommentText() {
/* 152 */     return this.field_7_comment_text;
/*     */   }
/*     */   
/*     */   public void setCommentText(String paramString) {
/* 156 */     this.field_7_comment_text = paramString;
/*     */   }
/*     */   
/*     */   public short getRecordType() {
/* 160 */     return this.field_1_record_type;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\NameCommentRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */