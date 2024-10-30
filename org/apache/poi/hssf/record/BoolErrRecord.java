/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.FormulaError;
/*     */ import org.apache.poi.util.HexDump;
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
/*     */ public final class BoolErrRecord
/*     */   extends CellRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 517;
/*     */   private int _value;
/*     */   private boolean _isError;
/*     */   
/*     */   public BoolErrRecord() {}
/*     */   
/*     */   public BoolErrRecord(RecordInputStream paramRecordInputStream) {
/*  47 */     super(paramRecordInputStream);
/*  48 */     switch (paramRecordInputStream.remaining()) {
/*     */       case 2:
/*  50 */         this._value = paramRecordInputStream.readByte();
/*     */         break;
/*     */       case 3:
/*  53 */         this._value = paramRecordInputStream.readUShort();
/*     */         break;
/*     */       default:
/*  56 */         throw new RecordFormatException("Unexpected size (" + paramRecordInputStream.remaining() + ") for BOOLERR record.");
/*     */     } 
/*     */     
/*  59 */     int i = paramRecordInputStream.readUByte();
/*  60 */     switch (i) {
/*     */       case 0:
/*  62 */         this._isError = false;
/*     */         return;
/*     */       case 1:
/*  65 */         this._isError = true;
/*     */         return;
/*     */     } 
/*  68 */     throw new RecordFormatException("Unexpected isError flag (" + i + ") for BOOLERR record.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(boolean paramBoolean) {
/*  79 */     this._value = paramBoolean ? 1 : 0;
/*  80 */     this._isError = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(byte paramByte) {
/*  91 */     setValue(FormulaError.forInt(paramByte));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(FormulaError paramFormulaError) {
/* 102 */     switch (paramFormulaError) {
/*     */       case NULL:
/*     */       case DIV0:
/*     */       case VALUE:
/*     */       case REF:
/*     */       case NAME:
/*     */       case NUM:
/*     */       case NA:
/* 110 */         this._value = paramFormulaError.getCode();
/* 111 */         this._isError = true;
/*     */         return;
/*     */     } 
/* 114 */     throw new IllegalArgumentException("Error Value can only be 0,7,15,23,29,36 or 42. It cannot be " + paramFormulaError.getCode() + " (" + paramFormulaError + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBooleanValue() {
/* 124 */     return (this._value != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getErrorValue() {
/* 133 */     return (byte)this._value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBoolean() {
/* 142 */     return !this._isError;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isError() {
/* 151 */     return this._isError;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getRecordName() {
/* 156 */     return "BOOLERR";
/*     */   }
/*     */   
/*     */   protected void appendValueText(StringBuilder paramStringBuilder) {
/* 160 */     if (isBoolean()) {
/* 161 */       paramStringBuilder.append("  .boolVal = ");
/* 162 */       paramStringBuilder.append(getBooleanValue());
/*     */     } else {
/* 164 */       paramStringBuilder.append("  .errCode = ");
/* 165 */       paramStringBuilder.append(FormulaError.forInt(getErrorValue()).getString());
/* 166 */       paramStringBuilder.append(" (").append(HexDump.byteToHex(getErrorValue())).append(")");
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void serializeValue(LittleEndianOutput paramLittleEndianOutput) {
/* 171 */     paramLittleEndianOutput.writeByte(this._value);
/* 172 */     paramLittleEndianOutput.writeByte(this._isError ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getValueDataSize() {
/* 177 */     return 2;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 181 */     return 517;
/*     */   }
/*     */ 
/*     */   
/*     */   public BoolErrRecord clone() {
/* 186 */     BoolErrRecord boolErrRecord = new BoolErrRecord();
/* 187 */     copyBaseFields(boolErrRecord);
/* 188 */     boolErrRecord._value = this._value;
/* 189 */     boolErrRecord._isError = this._isError;
/* 190 */     return boolErrRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\BoolErrRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */