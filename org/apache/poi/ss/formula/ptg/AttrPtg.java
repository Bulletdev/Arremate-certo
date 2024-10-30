/*     */ package org.apache.poi.ss.formula.ptg;
/*     */ 
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
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
/*     */ public final class AttrPtg
/*     */   extends ControlPtg
/*     */ {
/*     */   public static final byte sid = 25;
/*     */   private static final int SIZE = 4;
/*     */   private final byte _options;
/*     */   private final short _data;
/*     */   private final int[] _jumpTable;
/*     */   private final int _chooseFuncOffset;
/*  46 */   private static final BitField semiVolatile = BitFieldFactory.getInstance(1);
/*  47 */   private static final BitField optiIf = BitFieldFactory.getInstance(2);
/*  48 */   private static final BitField optiChoose = BitFieldFactory.getInstance(4);
/*  49 */   private static final BitField optiSkip = BitFieldFactory.getInstance(8);
/*  50 */   private static final BitField optiSum = BitFieldFactory.getInstance(16);
/*  51 */   private static final BitField baxcel = BitFieldFactory.getInstance(32);
/*  52 */   private static final BitField space = BitFieldFactory.getInstance(64);
/*     */   
/*  54 */   public static final AttrPtg SUM = new AttrPtg(16, 0, null, -1);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class SpaceType
/*     */   {
/*     */     public static final int SPACE_BEFORE = 0;
/*     */ 
/*     */     
/*     */     public static final int CR_BEFORE = 1;
/*     */     
/*     */     public static final int SPACE_BEFORE_OPEN_PAREN = 2;
/*     */     
/*     */     public static final int CR_BEFORE_OPEN_PAREN = 3;
/*     */     
/*     */     public static final int SPACE_BEFORE_CLOSE_PAREN = 4;
/*     */     
/*     */     public static final int CR_BEFORE_CLOSE_PAREN = 5;
/*     */     
/*     */     public static final int SPACE_AFTER_EQUALITY = 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public AttrPtg(LittleEndianInput paramLittleEndianInput) {
/*  78 */     this._options = paramLittleEndianInput.readByte();
/*  79 */     this._data = paramLittleEndianInput.readShort();
/*  80 */     if (isOptimizedChoose()) {
/*  81 */       short s = this._data;
/*  82 */       int[] arrayOfInt = new int[s];
/*  83 */       for (byte b = 0; b < arrayOfInt.length; b++) {
/*  84 */         arrayOfInt[b] = paramLittleEndianInput.readUShort();
/*     */       }
/*  86 */       this._jumpTable = arrayOfInt;
/*  87 */       this._chooseFuncOffset = paramLittleEndianInput.readUShort();
/*     */     } else {
/*  89 */       this._jumpTable = null;
/*  90 */       this._chooseFuncOffset = -1;
/*     */     } 
/*     */   }
/*     */   
/*     */   private AttrPtg(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
/*  95 */     this._options = (byte)paramInt1;
/*  96 */     this._data = (short)paramInt2;
/*  97 */     this._jumpTable = paramArrayOfint;
/*  98 */     this._chooseFuncOffset = paramInt3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AttrPtg createSpace(int paramInt1, int paramInt2) {
/* 106 */     int i = paramInt1 & 0xFF | paramInt2 << 8 & 0xFFFF;
/* 107 */     return new AttrPtg(space.set(0), i, null, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AttrPtg createIf(int paramInt) {
/* 115 */     return new AttrPtg(optiIf.set(0), paramInt, null, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AttrPtg createSkip(int paramInt) {
/* 122 */     return new AttrPtg(optiSkip.set(0), paramInt, null, -1);
/*     */   }
/*     */   
/*     */   public static AttrPtg getSumSingle() {
/* 126 */     return new AttrPtg(optiSum.set(0), 0, null, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSemiVolatile() {
/* 131 */     return semiVolatile.isSet(this._options);
/*     */   }
/*     */   
/*     */   public boolean isOptimizedIf() {
/* 135 */     return optiIf.isSet(this._options);
/*     */   }
/*     */   
/*     */   public boolean isOptimizedChoose() {
/* 139 */     return optiChoose.isSet(this._options);
/*     */   }
/*     */   
/*     */   public boolean isSum() {
/* 143 */     return optiSum.isSet(this._options);
/*     */   }
/*     */   public boolean isSkip() {
/* 146 */     return optiSkip.isSet(this._options);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isBaxcel() {
/* 151 */     return baxcel.isSet(this._options);
/*     */   }
/*     */   
/*     */   public boolean isSpace() {
/* 155 */     return space.isSet(this._options);
/*     */   }
/*     */   
/*     */   public short getData() {
/* 159 */     return this._data;
/*     */   }
/*     */   public int[] getJumpTable() {
/* 162 */     return (int[])this._jumpTable.clone();
/*     */   }
/*     */   public int getChooseFuncOffset() {
/* 165 */     if (this._jumpTable == null) {
/* 166 */       throw new IllegalStateException("Not tAttrChoose");
/*     */     }
/* 168 */     return this._chooseFuncOffset;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 172 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 173 */     stringBuffer.append(getClass().getName()).append(" [");
/*     */     
/* 175 */     if (isSemiVolatile()) {
/* 176 */       stringBuffer.append("volatile ");
/*     */     }
/* 178 */     if (isSpace()) {
/* 179 */       stringBuffer.append("space count=").append(this._data >> 8 & 0xFF);
/* 180 */       stringBuffer.append(" type=").append(this._data & 0xFF).append(" ");
/*     */     } 
/*     */     
/* 183 */     if (isOptimizedIf()) {
/* 184 */       stringBuffer.append("if dist=").append(this._data);
/* 185 */     } else if (isOptimizedChoose()) {
/* 186 */       stringBuffer.append("choose nCases=").append(this._data);
/* 187 */     } else if (isSkip()) {
/* 188 */       stringBuffer.append("skip dist=").append(this._data);
/* 189 */     } else if (isSum()) {
/* 190 */       stringBuffer.append("sum ");
/* 191 */     } else if (isBaxcel()) {
/* 192 */       stringBuffer.append("assign ");
/*     */     } 
/* 194 */     stringBuffer.append("]");
/* 195 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 199 */     paramLittleEndianOutput.writeByte(25 + getPtgClass());
/* 200 */     paramLittleEndianOutput.writeByte(this._options);
/* 201 */     paramLittleEndianOutput.writeShort(this._data);
/* 202 */     int[] arrayOfInt = this._jumpTable;
/* 203 */     if (arrayOfInt != null) {
/* 204 */       for (byte b = 0; b < arrayOfInt.length; b++) {
/* 205 */         paramLittleEndianOutput.writeShort(arrayOfInt[b]);
/*     */       }
/* 207 */       paramLittleEndianOutput.writeShort(this._chooseFuncOffset);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getSize() {
/* 212 */     if (this._jumpTable != null) {
/* 213 */       return 4 + (this._jumpTable.length + 1) * 2;
/*     */     }
/* 215 */     return 4;
/*     */   }
/*     */   
/*     */   public String toFormulaString(String[] paramArrayOfString) {
/* 219 */     if (space.isSet(this._options))
/* 220 */       return paramArrayOfString[0]; 
/* 221 */     if (optiIf.isSet(this._options))
/* 222 */       return toFormulaString() + "(" + paramArrayOfString[0] + ")"; 
/* 223 */     if (optiSkip.isSet(this._options)) {
/* 224 */       return toFormulaString() + paramArrayOfString[0];
/*     */     }
/* 226 */     return toFormulaString() + "(" + paramArrayOfString[0] + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfOperands() {
/* 232 */     return 1;
/*     */   }
/*     */   
/*     */   public int getType() {
/* 236 */     return -1;
/*     */   }
/*     */   
/*     */   public String toFormulaString() {
/* 240 */     if (semiVolatile.isSet(this._options)) {
/* 241 */       return "ATTR(semiVolatile)";
/*     */     }
/* 243 */     if (optiIf.isSet(this._options)) {
/* 244 */       return "IF";
/*     */     }
/* 246 */     if (optiChoose.isSet(this._options)) {
/* 247 */       return "CHOOSE";
/*     */     }
/* 249 */     if (optiSkip.isSet(this._options)) {
/* 250 */       return "";
/*     */     }
/* 252 */     if (optiSum.isSet(this._options)) {
/* 253 */       return "SUM";
/*     */     }
/* 255 */     if (baxcel.isSet(this._options)) {
/* 256 */       return "ATTR(baxcel)";
/*     */     }
/* 258 */     if (space.isSet(this._options)) {
/* 259 */       return "";
/*     */     }
/* 261 */     return "UNKNOWN ATTRIBUTE";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\AttrPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */