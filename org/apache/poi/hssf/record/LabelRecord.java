/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public final class LabelRecord
/*     */   extends Record
/*     */   implements Cloneable, CellValueRecordInterface
/*     */ {
/*  32 */   private static final POILogger logger = POILogFactory.getLogger(LabelRecord.class);
/*     */   
/*     */   public static final short sid = 516;
/*     */   
/*     */   private int field_1_row;
/*     */   
/*     */   private short field_2_column;
/*     */   
/*     */   private short field_3_xf_index;
/*     */   
/*     */   private short field_4_string_len;
/*     */   
/*     */   private byte field_5_unicode_flag;
/*     */   
/*     */   private String field_6_value;
/*     */ 
/*     */   
/*     */   public LabelRecord() {}
/*     */ 
/*     */   
/*     */   public LabelRecord(RecordInputStream paramRecordInputStream) {
/*  53 */     this.field_1_row = paramRecordInputStream.readUShort();
/*  54 */     this.field_2_column = paramRecordInputStream.readShort();
/*  55 */     this.field_3_xf_index = paramRecordInputStream.readShort();
/*  56 */     this.field_4_string_len = paramRecordInputStream.readShort();
/*  57 */     this.field_5_unicode_flag = paramRecordInputStream.readByte();
/*  58 */     if (this.field_4_string_len > 0) {
/*  59 */       if (isUnCompressedUnicode()) {
/*  60 */         this.field_6_value = paramRecordInputStream.readUnicodeLEString(this.field_4_string_len);
/*     */       } else {
/*  62 */         this.field_6_value = paramRecordInputStream.readCompressedUnicode(this.field_4_string_len);
/*     */       } 
/*     */     } else {
/*  65 */       this.field_6_value = "";
/*     */     } 
/*     */     
/*  68 */     if (paramRecordInputStream.remaining() > 0) {
/*  69 */       logger.log(3, new Object[] { "LabelRecord data remains: " + paramRecordInputStream.remaining() + " : " + HexDump.toHex(paramRecordInputStream.readRemainder()) });
/*     */     }
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
/*     */   public int getRow() {
/*  82 */     return this.field_1_row;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getColumn() {
/*  88 */     return this.field_2_column;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getXFIndex() {
/*  94 */     return this.field_3_xf_index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getStringLength() {
/* 103 */     return this.field_4_string_len;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUnCompressedUnicode() {
/* 112 */     return ((this.field_5_unicode_flag & 0x1) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValue() {
/* 123 */     return this.field_6_value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte) {
/* 131 */     throw new RecordFormatException("Label Records are supported READ ONLY...convert to LabelSST");
/*     */   }
/*     */   
/*     */   public int getRecordSize() {
/* 135 */     throw new RecordFormatException("Label Records are supported READ ONLY...convert to LabelSST");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 141 */     return 516;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 147 */     StringBuffer stringBuffer = new StringBuffer();
/* 148 */     stringBuffer.append("[LABEL]\n");
/* 149 */     stringBuffer.append("    .row       = ").append(HexDump.shortToHex(getRow())).append("\n");
/* 150 */     stringBuffer.append("    .column    = ").append(HexDump.shortToHex(getColumn())).append("\n");
/* 151 */     stringBuffer.append("    .xfindex   = ").append(HexDump.shortToHex(getXFIndex())).append("\n");
/* 152 */     stringBuffer.append("    .string_len= ").append(HexDump.shortToHex(this.field_4_string_len)).append("\n");
/* 153 */     stringBuffer.append("    .unicode_flag= ").append(HexDump.byteToHex(this.field_5_unicode_flag)).append("\n");
/* 154 */     stringBuffer.append("    .value       = ").append(getValue()).append("\n");
/* 155 */     stringBuffer.append("[/LABEL]\n");
/* 156 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColumn(short paramShort) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRow(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXFIndex(short paramShort) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LabelRecord clone() {
/* 185 */     LabelRecord labelRecord = new LabelRecord();
/* 186 */     labelRecord.field_1_row = this.field_1_row;
/* 187 */     labelRecord.field_2_column = this.field_2_column;
/* 188 */     labelRecord.field_3_xf_index = this.field_3_xf_index;
/* 189 */     labelRecord.field_4_string_len = this.field_4_string_len;
/* 190 */     labelRecord.field_5_unicode_flag = this.field_5_unicode_flag;
/* 191 */     labelRecord.field_6_value = this.field_6_value;
/* 192 */     return labelRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\LabelRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */