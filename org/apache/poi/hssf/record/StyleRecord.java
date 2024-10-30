/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
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
/*     */ public final class StyleRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 659;
/*  34 */   private static final BitField styleIndexMask = BitFieldFactory.getInstance(4095);
/*  35 */   private static final BitField isBuiltinFlag = BitFieldFactory.getInstance(32768);
/*     */ 
/*     */   
/*     */   private int field_1_xf_index;
/*     */ 
/*     */   
/*     */   private int field_2_builtin_style;
/*     */ 
/*     */   
/*     */   private int field_3_outline_style_level;
/*     */   
/*     */   private boolean field_3_stringHasMultibyte;
/*     */   
/*     */   private String field_4_name;
/*     */ 
/*     */   
/*     */   public StyleRecord() {
/*  52 */     this.field_1_xf_index = isBuiltinFlag.set(0);
/*     */   }
/*     */   
/*     */   public StyleRecord(RecordInputStream paramRecordInputStream) {
/*  56 */     this.field_1_xf_index = paramRecordInputStream.readShort();
/*  57 */     if (isBuiltin()) {
/*  58 */       this.field_2_builtin_style = paramRecordInputStream.readByte();
/*  59 */       this.field_3_outline_style_level = paramRecordInputStream.readByte();
/*     */     } else {
/*  61 */       short s = paramRecordInputStream.readShort();
/*     */       
/*  63 */       if (paramRecordInputStream.remaining() < 1) {
/*     */ 
/*     */         
/*  66 */         if (s != 0) {
/*  67 */           throw new RecordFormatException("Ran out of data reading style record");
/*     */         }
/*     */         
/*  70 */         this.field_4_name = "";
/*     */       } else {
/*     */         
/*  73 */         this.field_3_stringHasMultibyte = (paramRecordInputStream.readByte() != 0);
/*  74 */         if (this.field_3_stringHasMultibyte) {
/*  75 */           this.field_4_name = StringUtil.readUnicodeLE(paramRecordInputStream, s);
/*     */         } else {
/*  77 */           this.field_4_name = StringUtil.readCompressedUnicode(paramRecordInputStream, s);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXFIndex(int paramInt) {
/*  88 */     this.field_1_xf_index = styleIndexMask.setValue(this.field_1_xf_index, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getXFIndex() {
/*  97 */     return styleIndexMask.getValue(this.field_1_xf_index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 105 */     this.field_4_name = paramString;
/* 106 */     this.field_3_stringHasMultibyte = StringUtil.hasMultibyte(paramString);
/* 107 */     this.field_1_xf_index = isBuiltinFlag.clear(this.field_1_xf_index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuiltinStyle(int paramInt) {
/* 116 */     this.field_1_xf_index = isBuiltinFlag.set(this.field_1_xf_index);
/* 117 */     this.field_2_builtin_style = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutlineStyleLevel(int paramInt) {
/* 124 */     this.field_3_outline_style_level = paramInt & 0xFF;
/*     */   }
/*     */   
/*     */   public boolean isBuiltin() {
/* 128 */     return isBuiltinFlag.isSet(this.field_1_xf_index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 136 */     return this.field_4_name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 143 */     stringBuilder.append("[STYLE]\n");
/* 144 */     stringBuilder.append("    .xf_index_raw =").append(HexDump.shortToHex(this.field_1_xf_index)).append("\n");
/* 145 */     stringBuilder.append("        .type     =").append(isBuiltin() ? "built-in" : "user-defined").append("\n");
/* 146 */     stringBuilder.append("        .xf_index =").append(HexDump.shortToHex(getXFIndex())).append("\n");
/* 147 */     if (isBuiltin()) {
/* 148 */       stringBuilder.append("    .builtin_style=").append(HexDump.byteToHex(this.field_2_builtin_style)).append("\n");
/* 149 */       stringBuilder.append("    .outline_level=").append(HexDump.byteToHex(this.field_3_outline_style_level)).append("\n");
/*     */     } else {
/* 151 */       stringBuilder.append("    .name        =").append(getName()).append("\n");
/*     */     } 
/* 153 */     stringBuilder.append("[/STYLE]\n");
/* 154 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 160 */     if (isBuiltin()) {
/* 161 */       return 4;
/*     */     }
/* 163 */     return 5 + this.field_4_name.length() * (this.field_3_stringHasMultibyte ? 2 : 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 170 */     paramLittleEndianOutput.writeShort(this.field_1_xf_index);
/* 171 */     if (isBuiltin()) {
/* 172 */       paramLittleEndianOutput.writeByte(this.field_2_builtin_style);
/* 173 */       paramLittleEndianOutput.writeByte(this.field_3_outline_style_level);
/*     */     } else {
/* 175 */       paramLittleEndianOutput.writeShort(this.field_4_name.length());
/* 176 */       paramLittleEndianOutput.writeByte(this.field_3_stringHasMultibyte ? 1 : 0);
/* 177 */       if (this.field_3_stringHasMultibyte) {
/* 178 */         StringUtil.putUnicodeLE(getName(), paramLittleEndianOutput);
/*     */       } else {
/* 180 */         StringUtil.putCompressedUnicode(getName(), paramLittleEndianOutput);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 187 */     return 659;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\StyleRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */