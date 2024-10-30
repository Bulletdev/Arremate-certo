/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.constant.ConstantValueParser;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ExternalNameRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 35;
/*     */   private static final int OPT_BUILTIN_NAME = 1;
/*     */   private static final int OPT_AUTOMATIC_LINK = 2;
/*     */   private static final int OPT_PICTURE_LINK = 4;
/*     */   private static final int OPT_STD_DOCUMENT_NAME = 8;
/*     */   private static final int OPT_OLE_LINK = 16;
/*     */   private static final int OPT_ICONIFIED_PICTURE_LINK = 32768;
/*     */   private short field_1_option_flag;
/*     */   private short field_2_ixals;
/*     */   private short field_3_not_used;
/*     */   private String field_4_name;
/*     */   private Formula field_5_name_definition;
/*     */   private Object[] _ddeValues;
/*     */   private int _nColumns;
/*     */   private int _nRows;
/*     */   
/*     */   public boolean isBuiltInName() {
/*  67 */     return ((this.field_1_option_flag & 0x1) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutomaticLink() {
/*  75 */     return ((this.field_1_option_flag & 0x2) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPicureLink() {
/*  83 */     return ((this.field_1_option_flag & 0x4) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStdDocumentNameIdentifier() {
/*  91 */     return ((this.field_1_option_flag & 0x8) != 0);
/*     */   }
/*     */   public boolean isOLELink() {
/*  94 */     return ((this.field_1_option_flag & 0x10) != 0);
/*     */   }
/*     */   public boolean isIconifiedPictureLink() {
/*  97 */     return ((this.field_1_option_flag & 0x8000) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 103 */     return this.field_4_name;
/*     */   }
/*     */   
/*     */   public void setText(String paramString) {
/* 107 */     this.field_4_name = paramString;
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
/*     */   public short getIx() {
/* 119 */     return this.field_2_ixals;
/*     */   }
/*     */   
/*     */   public void setIx(short paramShort) {
/* 123 */     this.field_2_ixals = paramShort;
/*     */   }
/*     */   
/*     */   public Ptg[] getParsedExpression() {
/* 127 */     return Formula.getTokens(this.field_5_name_definition);
/*     */   }
/*     */   public void setParsedExpression(Ptg[] paramArrayOfPtg) {
/* 130 */     this.field_5_name_definition = Formula.create(paramArrayOfPtg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 136 */     int i = 6;
/* 137 */     i += StringUtil.getEncodedSize(this.field_4_name) - 1;
/*     */     
/* 139 */     if (!isOLELink() && !isStdDocumentNameIdentifier()) {
/* 140 */       if (isAutomaticLink()) {
/* 141 */         if (this._ddeValues != null) {
/* 142 */           i += 3;
/* 143 */           i += ConstantValueParser.getEncodedSize(this._ddeValues);
/*     */         } 
/*     */       } else {
/* 146 */         i += this.field_5_name_definition.getEncodedSize();
/*     */       } 
/*     */     }
/* 149 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 154 */     paramLittleEndianOutput.writeShort(this.field_1_option_flag);
/* 155 */     paramLittleEndianOutput.writeShort(this.field_2_ixals);
/* 156 */     paramLittleEndianOutput.writeShort(this.field_3_not_used);
/*     */     
/* 158 */     paramLittleEndianOutput.writeByte(this.field_4_name.length());
/* 159 */     StringUtil.writeUnicodeStringFlagAndData(paramLittleEndianOutput, this.field_4_name);
/*     */     
/* 161 */     if (!isOLELink() && !isStdDocumentNameIdentifier()) {
/* 162 */       if (isAutomaticLink()) {
/* 163 */         if (this._ddeValues != null) {
/* 164 */           paramLittleEndianOutput.writeByte(this._nColumns - 1);
/* 165 */           paramLittleEndianOutput.writeShort(this._nRows - 1);
/* 166 */           ConstantValueParser.encode(paramLittleEndianOutput, this._ddeValues);
/*     */         } 
/*     */       } else {
/* 169 */         this.field_5_name_definition.serialize(paramLittleEndianOutput);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public ExternalNameRecord() {
/* 175 */     this.field_2_ixals = 0;
/*     */   }
/*     */   
/*     */   public ExternalNameRecord(RecordInputStream paramRecordInputStream) {
/* 179 */     this.field_1_option_flag = paramRecordInputStream.readShort();
/* 180 */     this.field_2_ixals = paramRecordInputStream.readShort();
/* 181 */     this.field_3_not_used = paramRecordInputStream.readShort();
/*     */     
/* 183 */     int i = paramRecordInputStream.readUByte();
/* 184 */     this.field_4_name = StringUtil.readUnicodeString(paramRecordInputStream, i);
/*     */ 
/*     */ 
/*     */     
/* 188 */     if (!isOLELink() && !isStdDocumentNameIdentifier())
/*     */     {
/*     */       
/* 191 */       if (isAutomaticLink()) {
/* 192 */         if (paramRecordInputStream.available() > 0) {
/*     */           
/* 194 */           int j = paramRecordInputStream.readUByte() + 1;
/* 195 */           int k = paramRecordInputStream.readShort() + 1;
/*     */           
/* 197 */           int m = k * j;
/* 198 */           this._ddeValues = ConstantValueParser.parse(paramRecordInputStream, m);
/* 199 */           this._nColumns = j;
/* 200 */           this._nRows = k;
/*     */         } 
/*     */       } else {
/*     */         
/* 204 */         int j = paramRecordInputStream.readUShort();
/* 205 */         this.field_5_name_definition = Formula.read(j, paramRecordInputStream);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 212 */     return 35;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 217 */     StringBuffer stringBuffer = new StringBuffer();
/* 218 */     stringBuffer.append("[EXTERNALNAME]\n");
/* 219 */     stringBuffer.append("    .options      = ").append(this.field_1_option_flag).append("\n");
/* 220 */     stringBuffer.append("    .ix      = ").append(this.field_2_ixals).append("\n");
/* 221 */     stringBuffer.append("    .name    = ").append(this.field_4_name).append("\n");
/* 222 */     if (this.field_5_name_definition != null) {
/* 223 */       Ptg[] arrayOfPtg = this.field_5_name_definition.getTokens();
/* 224 */       for (Ptg ptg : arrayOfPtg) {
/* 225 */         stringBuffer.append(ptg.toString()).append(ptg.getRVAType()).append("\n");
/*     */       }
/*     */     } 
/* 228 */     stringBuffer.append("[/EXTERNALNAME]\n");
/* 229 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ExternalNameRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */