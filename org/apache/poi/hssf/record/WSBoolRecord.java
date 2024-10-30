/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
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
/*     */ public final class WSBoolRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 129;
/*     */   private byte field_1_wsbool;
/*     */   private byte field_2_wsbool;
/*  36 */   private static final BitField autobreaks = BitFieldFactory.getInstance(1);
/*     */ 
/*     */   
/*  39 */   private static final BitField dialog = BitFieldFactory.getInstance(16);
/*  40 */   private static final BitField applystyles = BitFieldFactory.getInstance(32);
/*  41 */   private static final BitField rowsumsbelow = BitFieldFactory.getInstance(64);
/*  42 */   private static final BitField rowsumsright = BitFieldFactory.getInstance(128);
/*  43 */   private static final BitField fittopage = BitFieldFactory.getInstance(1);
/*     */ 
/*     */   
/*  46 */   private static final BitField displayguts = BitFieldFactory.getInstance(6);
/*     */ 
/*     */   
/*  49 */   private static final BitField alternateexpression = BitFieldFactory.getInstance(64);
/*  50 */   private static final BitField alternateformula = BitFieldFactory.getInstance(128);
/*     */ 
/*     */ 
/*     */   
/*     */   public WSBoolRecord() {}
/*     */ 
/*     */   
/*     */   public WSBoolRecord(RecordInputStream paramRecordInputStream) {
/*  58 */     byte[] arrayOfByte = paramRecordInputStream.readRemainder();
/*  59 */     this.field_1_wsbool = arrayOfByte[1];
/*     */     
/*  61 */     this.field_2_wsbool = arrayOfByte[0];
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
/*     */   public void setWSBool1(byte paramByte) {
/*  77 */     this.field_1_wsbool = paramByte;
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
/*     */   public void setAutobreaks(boolean paramBoolean) {
/*  89 */     this.field_1_wsbool = autobreaks.setByteBoolean(this.field_1_wsbool, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDialog(boolean paramBoolean) {
/*  99 */     this.field_1_wsbool = dialog.setByteBoolean(this.field_1_wsbool, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowSumsBelow(boolean paramBoolean) {
/* 109 */     this.field_1_wsbool = rowsumsbelow.setByteBoolean(this.field_1_wsbool, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowSumsRight(boolean paramBoolean) {
/* 119 */     this.field_1_wsbool = rowsumsright.setByteBoolean(this.field_1_wsbool, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWSBool2(byte paramByte) {
/* 130 */     this.field_2_wsbool = paramByte;
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
/*     */   public void setFitToPage(boolean paramBoolean) {
/* 142 */     this.field_2_wsbool = fittopage.setByteBoolean(this.field_2_wsbool, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayGuts(boolean paramBoolean) {
/* 153 */     this.field_2_wsbool = displayguts.setByteBoolean(this.field_2_wsbool, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlternateExpression(boolean paramBoolean) {
/* 163 */     this.field_2_wsbool = alternateexpression.setByteBoolean(this.field_2_wsbool, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlternateFormula(boolean paramBoolean) {
/* 174 */     this.field_2_wsbool = alternateformula.setByteBoolean(this.field_2_wsbool, paramBoolean);
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
/*     */   public byte getWSBool1() {
/* 186 */     return this.field_1_wsbool;
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
/*     */   public boolean getAutobreaks() {
/* 198 */     return autobreaks.isSet(this.field_1_wsbool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDialog() {
/* 208 */     return dialog.isSet(this.field_1_wsbool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getRowSumsBelow() {
/* 218 */     return rowsumsbelow.isSet(this.field_1_wsbool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getRowSumsRight() {
/* 228 */     return rowsumsright.isSet(this.field_1_wsbool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getWSBool2() {
/* 239 */     return this.field_2_wsbool;
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
/*     */   public boolean getFitToPage() {
/* 251 */     return fittopage.isSet(this.field_2_wsbool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDisplayGuts() {
/* 262 */     return displayguts.isSet(this.field_2_wsbool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAlternateExpression() {
/* 272 */     return alternateexpression.isSet(this.field_2_wsbool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAlternateFormula() {
/* 282 */     return alternateformula.isSet(this.field_2_wsbool);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 288 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 290 */     stringBuffer.append("[WSBOOL]\n");
/* 291 */     stringBuffer.append("    .wsbool1        = ").append(Integer.toHexString(getWSBool1())).append("\n");
/*     */     
/* 293 */     stringBuffer.append("        .autobreaks = ").append(getAutobreaks()).append("\n");
/*     */     
/* 295 */     stringBuffer.append("        .dialog     = ").append(getDialog()).append("\n");
/*     */     
/* 297 */     stringBuffer.append("        .rowsumsbelw= ").append(getRowSumsBelow()).append("\n");
/*     */     
/* 299 */     stringBuffer.append("        .rowsumsrigt= ").append(getRowSumsRight()).append("\n");
/*     */     
/* 301 */     stringBuffer.append("    .wsbool2        = ").append(Integer.toHexString(getWSBool2())).append("\n");
/*     */     
/* 303 */     stringBuffer.append("        .fittopage  = ").append(getFitToPage()).append("\n");
/*     */     
/* 305 */     stringBuffer.append("        .displayguts= ").append(getDisplayGuts()).append("\n");
/*     */     
/* 307 */     stringBuffer.append("        .alternateex= ").append(getAlternateExpression()).append("\n");
/*     */     
/* 309 */     stringBuffer.append("        .alternatefo= ").append(getAlternateFormula()).append("\n");
/*     */     
/* 311 */     stringBuffer.append("[/WSBOOL]\n");
/* 312 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 316 */     paramLittleEndianOutput.writeByte(getWSBool2());
/* 317 */     paramLittleEndianOutput.writeByte(getWSBool1());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 321 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 326 */     return 129;
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 330 */     WSBoolRecord wSBoolRecord = new WSBoolRecord();
/* 331 */     wSBoolRecord.field_1_wsbool = this.field_1_wsbool;
/* 332 */     wSBoolRecord.field_2_wsbool = this.field_2_wsbool;
/* 333 */     return wSBoolRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\WSBoolRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */