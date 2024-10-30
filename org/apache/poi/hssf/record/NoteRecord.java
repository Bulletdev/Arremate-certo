/*     */ package org.apache.poi.hssf.record;
/*     */ 
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
/*     */ public final class NoteRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 28;
/*  29 */   public static final NoteRecord[] EMPTY_ARRAY = new NoteRecord[0];
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short NOTE_HIDDEN = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final short NOTE_VISIBLE = 2;
/*     */ 
/*     */ 
/*     */   
/*  41 */   private static final Byte DEFAULT_PADDING = Byte.valueOf((byte)0);
/*     */ 
/*     */   
/*     */   private int field_1_row;
/*     */ 
/*     */   
/*     */   private int field_2_col;
/*     */ 
/*     */   
/*     */   private short field_3_flags;
/*     */   
/*     */   private int field_4_shapeid;
/*     */   
/*     */   private boolean field_5_hasMultibyte;
/*     */   
/*     */   private String field_6_author;
/*     */   
/*     */   private Byte field_7_padding;
/*     */ 
/*     */   
/*     */   public NoteRecord() {
/*  62 */     this.field_6_author = "";
/*  63 */     this.field_3_flags = 0;
/*  64 */     this.field_7_padding = DEFAULT_PADDING;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  71 */     return 28;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NoteRecord(RecordInputStream paramRecordInputStream) {
/*  80 */     this.field_1_row = paramRecordInputStream.readUShort();
/*  81 */     this.field_2_col = paramRecordInputStream.readShort();
/*  82 */     this.field_3_flags = paramRecordInputStream.readShort();
/*  83 */     this.field_4_shapeid = paramRecordInputStream.readUShort();
/*  84 */     short s = paramRecordInputStream.readShort();
/*  85 */     this.field_5_hasMultibyte = (paramRecordInputStream.readByte() != 0);
/*  86 */     if (this.field_5_hasMultibyte) {
/*  87 */       this.field_6_author = StringUtil.readUnicodeLE(paramRecordInputStream, s);
/*     */     } else {
/*  89 */       this.field_6_author = StringUtil.readCompressedUnicode(paramRecordInputStream, s);
/*     */     } 
/*  91 */     if (paramRecordInputStream.available() == 1) {
/*  92 */       this.field_7_padding = Byte.valueOf(paramRecordInputStream.readByte());
/*  93 */     } else if (paramRecordInputStream.available() == 2 && s == 0) {
/*     */       
/*  95 */       this.field_7_padding = Byte.valueOf(paramRecordInputStream.readByte());
/*  96 */       paramRecordInputStream.readByte();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 101 */     paramLittleEndianOutput.writeShort(this.field_1_row);
/* 102 */     paramLittleEndianOutput.writeShort(this.field_2_col);
/* 103 */     paramLittleEndianOutput.writeShort(this.field_3_flags);
/* 104 */     paramLittleEndianOutput.writeShort(this.field_4_shapeid);
/* 105 */     paramLittleEndianOutput.writeShort(this.field_6_author.length());
/* 106 */     paramLittleEndianOutput.writeByte(this.field_5_hasMultibyte ? 1 : 0);
/* 107 */     if (this.field_5_hasMultibyte) {
/* 108 */       StringUtil.putUnicodeLE(this.field_6_author, paramLittleEndianOutput);
/*     */     } else {
/* 110 */       StringUtil.putCompressedUnicode(this.field_6_author, paramLittleEndianOutput);
/*     */     } 
/* 112 */     if (this.field_7_padding != null) {
/* 113 */       paramLittleEndianOutput.writeByte(this.field_7_padding.intValue());
/*     */     }
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 118 */     return 11 + this.field_6_author.length() * (this.field_5_hasMultibyte ? 2 : 1) + ((this.field_7_padding == null) ? 0 : 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 128 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 130 */     stringBuffer.append("[NOTE]\n");
/* 131 */     stringBuffer.append("    .row    = ").append(this.field_1_row).append("\n");
/* 132 */     stringBuffer.append("    .col    = ").append(this.field_2_col).append("\n");
/* 133 */     stringBuffer.append("    .flags  = ").append(this.field_3_flags).append("\n");
/* 134 */     stringBuffer.append("    .shapeid= ").append(this.field_4_shapeid).append("\n");
/* 135 */     stringBuffer.append("    .author = ").append(this.field_6_author).append("\n");
/* 136 */     stringBuffer.append("[/NOTE]\n");
/* 137 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRow() {
/* 146 */     return this.field_1_row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRow(int paramInt) {
/* 155 */     this.field_1_row = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumn() {
/* 164 */     return this.field_2_col;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColumn(int paramInt) {
/* 173 */     this.field_2_col = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFlags() {
/* 184 */     return this.field_3_flags;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFlags(short paramShort) {
/* 195 */     this.field_3_flags = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean authorIsMultibyte() {
/* 204 */     return this.field_5_hasMultibyte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getShapeId() {
/* 213 */     return this.field_4_shapeid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShapeId(int paramInt) {
/* 222 */     this.field_4_shapeid = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthor() {
/* 231 */     return this.field_6_author;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuthor(String paramString) {
/* 240 */     this.field_6_author = paramString;
/* 241 */     this.field_5_hasMultibyte = StringUtil.hasMultibyte(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public NoteRecord clone() {
/* 246 */     NoteRecord noteRecord = new NoteRecord();
/* 247 */     noteRecord.field_1_row = this.field_1_row;
/* 248 */     noteRecord.field_2_col = this.field_2_col;
/* 249 */     noteRecord.field_3_flags = this.field_3_flags;
/* 250 */     noteRecord.field_4_shapeid = this.field_4_shapeid;
/* 251 */     noteRecord.field_6_author = this.field_6_author;
/* 252 */     return noteRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\NoteRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */