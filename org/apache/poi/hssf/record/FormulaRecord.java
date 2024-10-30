/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
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
/*     */ public final class FormulaRecord
/*     */   extends CellRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 6;
/*  39 */   private static int FIXED_SIZE = 14;
/*     */   
/*  41 */   private static final BitField alwaysCalc = BitFieldFactory.getInstance(1);
/*  42 */   private static final BitField calcOnLoad = BitFieldFactory.getInstance(2);
/*  43 */   private static final BitField sharedFormula = BitFieldFactory.getInstance(8);
/*     */   
/*     */   private double field_4_value;
/*     */   
/*     */   private short field_5_options;
/*     */   
/*     */   private int field_6_zero;
/*     */   
/*     */   private Formula field_8_parsed_expr;
/*     */   private SpecialCachedValue specialCachedValue;
/*     */   
/*     */   static final class SpecialCachedValue
/*     */   {
/*     */     private static final long BIT_MARKER = -281474976710656L;
/*     */     private static final int VARIABLE_DATA_LENGTH = 6;
/*     */     private static final int DATA_INDEX = 2;
/*     */     public static final int STRING = 0;
/*     */     public static final int BOOLEAN = 1;
/*     */     public static final int ERROR_CODE = 2;
/*     */     public static final int EMPTY = 3;
/*     */     private final byte[] _variableData;
/*     */     
/*     */     private SpecialCachedValue(byte[] param1ArrayOfbyte) {
/*  66 */       this._variableData = param1ArrayOfbyte;
/*     */     }
/*     */     public int getTypeCode() {
/*  69 */       return this._variableData[0];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static SpecialCachedValue create(long param1Long) {
/*  77 */       if ((0xFFFF000000000000L & param1Long) != -281474976710656L) {
/*  78 */         return null;
/*     */       }
/*     */       
/*  81 */       byte[] arrayOfByte = new byte[6];
/*  82 */       long l = param1Long;
/*  83 */       for (byte b = 0; b < 6; b++) {
/*  84 */         arrayOfByte[b] = (byte)(int)l;
/*  85 */         l >>= 8L;
/*     */       } 
/*  87 */       switch (arrayOfByte[0]) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 0:
/*     */         case 1:
/*     */         case 2:
/*     */         case 3:
/*  96 */           return new SpecialCachedValue(arrayOfByte);
/*     */       } 
/*     */       throw new RecordFormatException("Bad special value code (" + arrayOfByte[0] + ")"); } public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/*  99 */       param1LittleEndianOutput.write(this._variableData);
/* 100 */       param1LittleEndianOutput.writeShort(65535);
/*     */     }
/*     */     public String formatDebugString() {
/* 103 */       return formatValue() + ' ' + HexDump.toHex(this._variableData);
/*     */     }
/*     */     private String formatValue() {
/* 106 */       int i = getTypeCode();
/* 107 */       switch (i) { case 0:
/* 108 */           return "<string>";
/* 109 */         case 1: return (getDataValue() == 0) ? "FALSE" : "TRUE";
/* 110 */         case 2: return ErrorEval.getText(getDataValue());
/* 111 */         case 3: return "<empty>"; }
/*     */       
/* 113 */       return "#error(type=" + i + ")#";
/*     */     }
/*     */     private int getDataValue() {
/* 116 */       return this._variableData[2];
/*     */     }
/*     */     public static SpecialCachedValue createCachedEmptyValue() {
/* 119 */       return create(3, 0);
/*     */     }
/*     */     public static SpecialCachedValue createForString() {
/* 122 */       return create(0, 0);
/*     */     }
/*     */     public static SpecialCachedValue createCachedBoolean(boolean param1Boolean) {
/* 125 */       return create(1, param1Boolean ? 1 : 0);
/*     */     }
/*     */     public static SpecialCachedValue createCachedErrorCode(int param1Int) {
/* 128 */       return create(2, param1Int);
/*     */     }
/*     */     private static SpecialCachedValue create(int param1Int1, int param1Int2) {
/* 131 */       byte[] arrayOfByte = { (byte)param1Int1, 0, (byte)param1Int2, 0, 0, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       return new SpecialCachedValue(arrayOfByte);
/*     */     }
/*     */     
/*     */     public String toString() {
/* 143 */       StringBuffer stringBuffer = new StringBuffer(64);
/* 144 */       stringBuffer.append(getClass().getName());
/* 145 */       stringBuffer.append('[').append(formatValue()).append(']');
/* 146 */       return stringBuffer.toString();
/*     */     }
/*     */     public int getValueType() {
/* 149 */       int i = getTypeCode();
/* 150 */       switch (i) { case 0:
/* 151 */           return CellType.STRING.getCode();
/* 152 */         case 1: return CellType.BOOLEAN.getCode();
/* 153 */         case 2: return CellType.ERROR.getCode();
/* 154 */         case 3: return CellType.STRING.getCode(); }
/*     */       
/* 156 */       throw new IllegalStateException("Unexpected type id (" + i + ")");
/*     */     }
/*     */     public boolean getBooleanValue() {
/* 159 */       if (getTypeCode() != 1) {
/* 160 */         throw new IllegalStateException("Not a boolean cached value - " + formatValue());
/*     */       }
/* 162 */       return (getDataValue() != 0);
/*     */     }
/*     */     public int getErrorValue() {
/* 165 */       if (getTypeCode() != 2) {
/* 166 */         throw new IllegalStateException("Not an error cached value - " + formatValue());
/*     */       }
/* 168 */       return getDataValue();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormulaRecord() {
/* 190 */     this.field_8_parsed_expr = Formula.create(Ptg.EMPTY_PTG_ARRAY);
/*     */   }
/*     */   
/*     */   public FormulaRecord(RecordInputStream paramRecordInputStream) {
/* 194 */     super(paramRecordInputStream);
/* 195 */     RecordInputStream recordInputStream = paramRecordInputStream;
/* 196 */     long l = recordInputStream.readLong();
/* 197 */     this.field_5_options = recordInputStream.readShort();
/* 198 */     this.specialCachedValue = SpecialCachedValue.create(l);
/* 199 */     if (this.specialCachedValue == null) {
/* 200 */       this.field_4_value = Double.longBitsToDouble(l);
/*     */     }
/*     */     
/* 203 */     this.field_6_zero = recordInputStream.readInt();
/*     */     
/* 205 */     short s = recordInputStream.readShort();
/* 206 */     int i = recordInputStream.available();
/* 207 */     this.field_8_parsed_expr = Formula.read(s, recordInputStream, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(double paramDouble) {
/* 216 */     this.field_4_value = paramDouble;
/* 217 */     this.specialCachedValue = null;
/*     */   }
/*     */   
/*     */   public void setCachedResultTypeEmptyString() {
/* 221 */     this.specialCachedValue = SpecialCachedValue.createCachedEmptyValue();
/*     */   }
/*     */   public void setCachedResultTypeString() {
/* 224 */     this.specialCachedValue = SpecialCachedValue.createForString();
/*     */   }
/*     */   public void setCachedResultErrorCode(int paramInt) {
/* 227 */     this.specialCachedValue = SpecialCachedValue.createCachedErrorCode(paramInt);
/*     */   }
/*     */   public void setCachedResultBoolean(boolean paramBoolean) {
/* 230 */     this.specialCachedValue = SpecialCachedValue.createCachedBoolean(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasCachedResultString() {
/* 238 */     if (this.specialCachedValue == null) {
/* 239 */       return false;
/*     */     }
/* 241 */     return (this.specialCachedValue.getTypeCode() == 0);
/*     */   }
/*     */   
/*     */   public int getCachedResultType() {
/* 245 */     if (this.specialCachedValue == null) {
/* 246 */       return CellType.NUMERIC.getCode();
/*     */     }
/* 248 */     return this.specialCachedValue.getValueType();
/*     */   }
/*     */   
/*     */   public boolean getCachedBooleanValue() {
/* 252 */     return this.specialCachedValue.getBooleanValue();
/*     */   }
/*     */   public int getCachedErrorValue() {
/* 255 */     return this.specialCachedValue.getErrorValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/* 265 */     this.field_5_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getValue() {
/* 274 */     return this.field_4_value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 283 */     return this.field_5_options;
/*     */   }
/*     */   
/*     */   public boolean isSharedFormula() {
/* 287 */     return sharedFormula.isSet(this.field_5_options);
/*     */   }
/*     */   public void setSharedFormula(boolean paramBoolean) {
/* 290 */     this.field_5_options = sharedFormula.setShortBoolean(this.field_5_options, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAlwaysCalc() {
/* 295 */     return alwaysCalc.isSet(this.field_5_options);
/*     */   }
/*     */   public void setAlwaysCalc(boolean paramBoolean) {
/* 298 */     this.field_5_options = alwaysCalc.setShortBoolean(this.field_5_options, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCalcOnLoad() {
/* 303 */     return calcOnLoad.isSet(this.field_5_options);
/*     */   }
/*     */   public void setCalcOnLoad(boolean paramBoolean) {
/* 306 */     this.field_5_options = calcOnLoad.setShortBoolean(this.field_5_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ptg[] getParsedExpression() {
/* 314 */     return this.field_8_parsed_expr.getTokens();
/*     */   }
/*     */   
/*     */   public Formula getFormula() {
/* 318 */     return this.field_8_parsed_expr;
/*     */   }
/*     */   
/*     */   public void setParsedExpression(Ptg[] paramArrayOfPtg) {
/* 322 */     this.field_8_parsed_expr = Formula.create(paramArrayOfPtg);
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 327 */     return 6;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getValueDataSize() {
/* 332 */     return FIXED_SIZE + this.field_8_parsed_expr.getEncodedSize();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void serializeValue(LittleEndianOutput paramLittleEndianOutput) {
/* 337 */     if (this.specialCachedValue == null) {
/* 338 */       paramLittleEndianOutput.writeDouble(this.field_4_value);
/*     */     } else {
/* 340 */       this.specialCachedValue.serialize(paramLittleEndianOutput);
/*     */     } 
/*     */     
/* 343 */     paramLittleEndianOutput.writeShort(getOptions());
/*     */     
/* 345 */     paramLittleEndianOutput.writeInt(this.field_6_zero);
/* 346 */     this.field_8_parsed_expr.serialize(paramLittleEndianOutput);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getRecordName() {
/* 351 */     return "FORMULA";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendValueText(StringBuilder paramStringBuilder) {
/* 356 */     paramStringBuilder.append("  .value\t = ");
/* 357 */     if (this.specialCachedValue == null) {
/* 358 */       paramStringBuilder.append(this.field_4_value).append("\n");
/*     */     } else {
/* 360 */       paramStringBuilder.append(this.specialCachedValue.formatDebugString()).append("\n");
/*     */     } 
/* 362 */     paramStringBuilder.append("  .options   = ").append(HexDump.shortToHex(getOptions())).append("\n");
/* 363 */     paramStringBuilder.append("    .alwaysCalc= ").append(isAlwaysCalc()).append("\n");
/* 364 */     paramStringBuilder.append("    .calcOnLoad= ").append(isCalcOnLoad()).append("\n");
/* 365 */     paramStringBuilder.append("    .shared    = ").append(isSharedFormula()).append("\n");
/* 366 */     paramStringBuilder.append("  .zero      = ").append(HexDump.intToHex(this.field_6_zero)).append("\n");
/*     */     
/* 368 */     Ptg[] arrayOfPtg = this.field_8_parsed_expr.getTokens();
/* 369 */     for (byte b = 0; b < arrayOfPtg.length; b++) {
/* 370 */       if (b > 0) {
/* 371 */         paramStringBuilder.append("\n");
/*     */       }
/* 373 */       paramStringBuilder.append("    Ptg[").append(b).append("]=");
/* 374 */       Ptg ptg = arrayOfPtg[b];
/* 375 */       paramStringBuilder.append(ptg.toString()).append(ptg.getRVAType());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public FormulaRecord clone() {
/* 381 */     FormulaRecord formulaRecord = new FormulaRecord();
/* 382 */     copyBaseFields(formulaRecord);
/* 383 */     formulaRecord.field_4_value = this.field_4_value;
/* 384 */     formulaRecord.field_5_options = this.field_5_options;
/* 385 */     formulaRecord.field_6_zero = this.field_6_zero;
/* 386 */     formulaRecord.field_8_parsed_expr = this.field_8_parsed_expr;
/* 387 */     formulaRecord.specialCachedValue = this.specialCachedValue;
/* 388 */     return formulaRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FormulaRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */