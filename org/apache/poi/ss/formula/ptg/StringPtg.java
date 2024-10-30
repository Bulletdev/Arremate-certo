/*     */ package org.apache.poi.ss.formula.ptg;
/*     */ 
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StringPtg
/*     */   extends ScalarConstantPtg
/*     */ {
/*     */   public static final byte sid = 23;
/*     */   private static final char FORMULA_DELIMITER = '"';
/*     */   private final boolean _is16bitUnicode;
/*     */   private final String field_3_string;
/*     */   
/*     */   public StringPtg(LittleEndianInput paramLittleEndianInput) {
/*  46 */     int i = paramLittleEndianInput.readUByte();
/*  47 */     this._is16bitUnicode = ((paramLittleEndianInput.readByte() & 0x1) != 0);
/*  48 */     if (this._is16bitUnicode) {
/*  49 */       this.field_3_string = StringUtil.readUnicodeLE(paramLittleEndianInput, i);
/*     */     } else {
/*  51 */       this.field_3_string = StringUtil.readCompressedUnicode(paramLittleEndianInput, i);
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
/*     */   public StringPtg(String paramString) {
/*  64 */     if (paramString.length() > 255) {
/*  65 */       throw new IllegalArgumentException("String literals in formulas can't be bigger than 255 characters ASCII");
/*     */     }
/*     */     
/*  68 */     this._is16bitUnicode = StringUtil.hasMultibyte(paramString);
/*  69 */     this.field_3_string = paramString;
/*     */   }
/*     */   
/*     */   public String getValue() {
/*  73 */     return this.field_3_string;
/*     */   }
/*     */   
/*     */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/*  77 */     paramLittleEndianOutput.writeByte(23 + getPtgClass());
/*  78 */     paramLittleEndianOutput.writeByte(this.field_3_string.length());
/*  79 */     paramLittleEndianOutput.writeByte(this._is16bitUnicode ? 1 : 0);
/*  80 */     if (this._is16bitUnicode) {
/*  81 */       StringUtil.putUnicodeLE(this.field_3_string, paramLittleEndianOutput);
/*     */     } else {
/*  83 */       StringUtil.putCompressedUnicode(this.field_3_string, paramLittleEndianOutput);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getSize() {
/*  88 */     return 3 + this.field_3_string.length() * (this._is16bitUnicode ? 2 : 1);
/*     */   }
/*     */   
/*     */   public String toFormulaString() {
/*  92 */     String str = this.field_3_string;
/*  93 */     int i = str.length();
/*  94 */     StringBuffer stringBuffer = new StringBuffer(i + 4);
/*  95 */     stringBuffer.append('"');
/*     */     
/*  97 */     for (byte b = 0; b < i; b++) {
/*  98 */       char c = str.charAt(b);
/*  99 */       if (c == '"') {
/* 100 */         stringBuffer.append('"');
/*     */       }
/* 102 */       stringBuffer.append(c);
/*     */     } 
/*     */     
/* 105 */     stringBuffer.append('"');
/* 106 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\StringPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */