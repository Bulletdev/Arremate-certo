/*     */ package org.apache.poi.ss.formula.ptg;
/*     */ 
/*     */ import org.apache.poi.ss.formula.constant.ConstantValueParser;
/*     */ import org.apache.poi.ss.formula.constant.ErrorConstant;
/*     */ import org.apache.poi.ss.util.NumberToTextConverter;
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ArrayPtg
/*     */   extends Ptg
/*     */ {
/*     */   public static final byte sid = 32;
/*     */   private static final int RESERVED_FIELD_LEN = 7;
/*     */   public static final int PLAIN_TOKEN_SIZE = 8;
/*     */   private final int _reserved0Int;
/*     */   private final int _reserved1Short;
/*     */   private final int _reserved2Byte;
/*     */   private final int _nColumns;
/*     */   private final int _nRows;
/*     */   private final Object[] _arrayValues;
/*     */   
/*     */   ArrayPtg(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Object[] paramArrayOfObject) {
/*  58 */     this._reserved0Int = paramInt1;
/*  59 */     this._reserved1Short = paramInt2;
/*  60 */     this._reserved2Byte = paramInt3;
/*  61 */     this._nColumns = paramInt4;
/*  62 */     this._nRows = paramInt5;
/*  63 */     this._arrayValues = (Object[])paramArrayOfObject.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayPtg(Object[][] paramArrayOfObject) {
/*  69 */     int i = (paramArrayOfObject[0]).length;
/*  70 */     int j = paramArrayOfObject.length;
/*     */     
/*  72 */     this._nColumns = (short)i;
/*  73 */     this._nRows = (short)j;
/*     */     
/*  75 */     Object[] arrayOfObject = new Object[this._nColumns * this._nRows];
/*  76 */     for (byte b = 0; b < j; b++) {
/*  77 */       Object[] arrayOfObject1 = paramArrayOfObject[b];
/*  78 */       for (byte b1 = 0; b1 < i; b1++) {
/*  79 */         arrayOfObject[getValueIndex(b1, b)] = arrayOfObject1[b1];
/*     */       }
/*     */     } 
/*     */     
/*  83 */     this._arrayValues = arrayOfObject;
/*  84 */     this._reserved0Int = 0;
/*  85 */     this._reserved1Short = 0;
/*  86 */     this._reserved2Byte = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[][] getTokenArrayValues() {
/*  92 */     if (this._arrayValues == null) {
/*  93 */       throw new IllegalStateException("array values not read yet");
/*     */     }
/*  95 */     Object[][] arrayOfObject = new Object[this._nRows][this._nColumns];
/*  96 */     for (byte b = 0; b < this._nRows; b++) {
/*  97 */       Object[] arrayOfObject1 = arrayOfObject[b];
/*  98 */       for (byte b1 = 0; b1 < this._nColumns; b1++) {
/*  99 */         arrayOfObject1[b1] = this._arrayValues[getValueIndex(b1, b)];
/*     */       }
/*     */     } 
/* 102 */     return arrayOfObject;
/*     */   }
/*     */   
/*     */   public boolean isBaseToken() {
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 110 */     StringBuffer stringBuffer = new StringBuffer("[ArrayPtg]\n");
/*     */     
/* 112 */     stringBuffer.append("nRows = ").append(getRowCount()).append("\n");
/* 113 */     stringBuffer.append("nCols = ").append(getColumnCount()).append("\n");
/* 114 */     if (this._arrayValues == null) {
/* 115 */       stringBuffer.append("  #values#uninitialised#\n");
/*     */     } else {
/* 117 */       stringBuffer.append("  ").append(toFormulaString());
/*     */     } 
/* 119 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getValueIndex(int paramInt1, int paramInt2) {
/* 127 */     if (paramInt1 < 0 || paramInt1 >= this._nColumns) {
/* 128 */       throw new IllegalArgumentException("Specified colIx (" + paramInt1 + ") is outside the allowed range (0.." + (this._nColumns - 1) + ")");
/*     */     }
/*     */     
/* 131 */     if (paramInt2 < 0 || paramInt2 >= this._nRows) {
/* 132 */       throw new IllegalArgumentException("Specified rowIx (" + paramInt2 + ") is outside the allowed range (0.." + (this._nRows - 1) + ")");
/*     */     }
/*     */     
/* 135 */     return paramInt2 * this._nColumns + paramInt1;
/*     */   }
/*     */   
/*     */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 139 */     paramLittleEndianOutput.writeByte(32 + getPtgClass());
/* 140 */     paramLittleEndianOutput.writeInt(this._reserved0Int);
/* 141 */     paramLittleEndianOutput.writeShort(this._reserved1Short);
/* 142 */     paramLittleEndianOutput.writeByte(this._reserved2Byte);
/*     */   }
/*     */ 
/*     */   
/*     */   public int writeTokenValueBytes(LittleEndianOutput paramLittleEndianOutput) {
/* 147 */     paramLittleEndianOutput.writeByte(this._nColumns - 1);
/* 148 */     paramLittleEndianOutput.writeShort(this._nRows - 1);
/* 149 */     ConstantValueParser.encode(paramLittleEndianOutput, this._arrayValues);
/* 150 */     return 3 + ConstantValueParser.getEncodedSize(this._arrayValues);
/*     */   }
/*     */   
/*     */   public int getRowCount() {
/* 154 */     return this._nRows;
/*     */   }
/*     */   
/*     */   public int getColumnCount() {
/* 158 */     return this._nColumns;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSize() {
/* 163 */     return 11 + ConstantValueParser.getEncodedSize(this._arrayValues);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toFormulaString() {
/* 170 */     StringBuffer stringBuffer = new StringBuffer();
/* 171 */     stringBuffer.append("{");
/* 172 */     for (byte b = 0; b < this._nRows; b++) {
/* 173 */       if (b > 0) {
/* 174 */         stringBuffer.append(";");
/*     */       }
/* 176 */       for (byte b1 = 0; b1 < this._nColumns; b1++) {
/* 177 */         if (b1 > 0) {
/* 178 */           stringBuffer.append(",");
/*     */         }
/* 180 */         Object object = this._arrayValues[getValueIndex(b1, b)];
/* 181 */         stringBuffer.append(getConstantText(object));
/*     */       } 
/*     */     } 
/* 184 */     stringBuffer.append("}");
/* 185 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getConstantText(Object paramObject) {
/* 190 */     if (paramObject == null) {
/* 191 */       throw new RuntimeException("Array item cannot be null");
/*     */     }
/* 193 */     if (paramObject instanceof String) {
/* 194 */       return "\"" + (String)paramObject + "\"";
/*     */     }
/* 196 */     if (paramObject instanceof Double) {
/* 197 */       return NumberToTextConverter.toText(((Double)paramObject).doubleValue());
/*     */     }
/* 199 */     if (paramObject instanceof Boolean) {
/* 200 */       return ((Boolean)paramObject).booleanValue() ? "TRUE" : "FALSE";
/*     */     }
/* 202 */     if (paramObject instanceof ErrorConstant) {
/* 203 */       return ((ErrorConstant)paramObject).getText();
/*     */     }
/* 205 */     throw new IllegalArgumentException("Unexpected constant class (" + paramObject.getClass().getName() + ")");
/*     */   }
/*     */   
/*     */   public byte getDefaultOperandClass() {
/* 209 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   static final class Initial
/*     */     extends Ptg
/*     */   {
/*     */     private final int _reserved0;
/*     */     
/*     */     private final int _reserved1;
/*     */     
/*     */     private final int _reserved2;
/*     */ 
/*     */     
/*     */     public Initial(LittleEndianInput param1LittleEndianInput) {
/* 224 */       this._reserved0 = param1LittleEndianInput.readInt();
/* 225 */       this._reserved1 = param1LittleEndianInput.readUShort();
/* 226 */       this._reserved2 = param1LittleEndianInput.readUByte();
/*     */     }
/*     */     private static RuntimeException invalid() {
/* 229 */       throw new IllegalStateException("This object is a partially initialised tArray, and cannot be used as a Ptg");
/*     */     }
/*     */     public byte getDefaultOperandClass() {
/* 232 */       throw invalid();
/*     */     }
/*     */     public int getSize() {
/* 235 */       return 8;
/*     */     }
/*     */     public boolean isBaseToken() {
/* 238 */       return false;
/*     */     }
/*     */     public String toFormulaString() {
/* 241 */       throw invalid();
/*     */     }
/*     */     public void write(LittleEndianOutput param1LittleEndianOutput) {
/* 244 */       throw invalid();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ArrayPtg finishReading(LittleEndianInput param1LittleEndianInput) {
/* 252 */       int i = param1LittleEndianInput.readUByte();
/* 253 */       short s = param1LittleEndianInput.readShort();
/*     */ 
/*     */ 
/*     */       
/* 257 */       i++;
/* 258 */       s = (short)(s + 1);
/*     */       
/* 260 */       int j = s * i;
/* 261 */       Object[] arrayOfObject = ConstantValueParser.parse(param1LittleEndianInput, j);
/*     */       
/* 263 */       ArrayPtg arrayPtg = new ArrayPtg(this._reserved0, this._reserved1, this._reserved2, i, s, arrayOfObject);
/* 264 */       arrayPtg.setClass(getPtgClass());
/* 265 */       return arrayPtg;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\ArrayPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */