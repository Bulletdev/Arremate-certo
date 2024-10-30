/*     */ package org.apache.poi.ss.formula.ptg;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.LittleEndianByteArrayOutputStream;
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
/*     */ public abstract class Ptg
/*     */ {
/*  44 */   public static final Ptg[] EMPTY_PTG_ARRAY = new Ptg[0];
/*     */   
/*     */   public static final byte CLASS_REF = 0;
/*     */   public static final byte CLASS_VALUE = 32;
/*     */   public static final byte CLASS_ARRAY = 64;
/*     */   
/*     */   public static Ptg[] readTokens(int paramInt, LittleEndianInput paramLittleEndianInput) {
/*  51 */     ArrayList<Ptg> arrayList = new ArrayList(4 + paramInt / 2);
/*  52 */     int i = 0;
/*  53 */     boolean bool = false;
/*  54 */     while (i < paramInt) {
/*  55 */       Ptg ptg = createPtg(paramLittleEndianInput);
/*  56 */       if (ptg instanceof ArrayPtg.Initial) {
/*  57 */         bool = true;
/*     */       }
/*  59 */       i += ptg.getSize();
/*  60 */       arrayList.add(ptg);
/*     */     } 
/*  62 */     if (i != paramInt) {
/*  63 */       throw new RuntimeException("Ptg array size mismatch");
/*     */     }
/*  65 */     if (bool) {
/*  66 */       Ptg[] arrayOfPtg = toPtgArray(arrayList);
/*  67 */       for (byte b = 0; b < arrayOfPtg.length; b++) {
/*  68 */         if (arrayOfPtg[b] instanceof ArrayPtg.Initial) {
/*  69 */           arrayOfPtg[b] = ((ArrayPtg.Initial)arrayOfPtg[b]).finishReading(paramLittleEndianInput);
/*     */         }
/*     */       } 
/*  72 */       return arrayOfPtg;
/*     */     } 
/*  74 */     return toPtgArray(arrayList);
/*     */   }
/*     */   
/*     */   public static Ptg createPtg(LittleEndianInput paramLittleEndianInput) {
/*  78 */     byte b = paramLittleEndianInput.readByte();
/*     */     
/*  80 */     if (b < 32) {
/*  81 */       return createBasePtg(b, paramLittleEndianInput);
/*     */     }
/*     */     
/*  84 */     Ptg ptg = createClassifiedPtg(b, paramLittleEndianInput);
/*     */     
/*  86 */     if (b >= 96) {
/*  87 */       ptg.setClass((byte)64);
/*  88 */     } else if (b >= 64) {
/*  89 */       ptg.setClass((byte)32);
/*     */     } else {
/*  91 */       ptg.setClass((byte)0);
/*     */     } 
/*  93 */     return ptg;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Ptg createClassifiedPtg(byte paramByte, LittleEndianInput paramLittleEndianInput) {
/*  98 */     int i = paramByte & 0x1F | 0x20;
/*     */     
/* 100 */     switch (i) { case 32:
/* 101 */         return new ArrayPtg.Initial(paramLittleEndianInput);
/* 102 */       case 33: return FuncPtg.create(paramLittleEndianInput);
/* 103 */       case 34: return FuncVarPtg.create(paramLittleEndianInput);
/* 104 */       case 35: return new NamePtg(paramLittleEndianInput);
/* 105 */       case 36: return new RefPtg(paramLittleEndianInput);
/* 106 */       case 37: return new AreaPtg(paramLittleEndianInput);
/* 107 */       case 38: return new MemAreaPtg(paramLittleEndianInput);
/* 108 */       case 39: return new MemErrPtg(paramLittleEndianInput);
/* 109 */       case 41: return new MemFuncPtg(paramLittleEndianInput);
/* 110 */       case 42: return new RefErrorPtg(paramLittleEndianInput);
/* 111 */       case 43: return new AreaErrPtg(paramLittleEndianInput);
/* 112 */       case 44: return new RefNPtg(paramLittleEndianInput);
/* 113 */       case 45: return new AreaNPtg(paramLittleEndianInput);
/*     */       case 57:
/* 115 */         return new NameXPtg(paramLittleEndianInput);
/* 116 */       case 58: return new Ref3DPtg(paramLittleEndianInput);
/* 117 */       case 59: return new Area3DPtg(paramLittleEndianInput);
/* 118 */       case 60: return new DeletedRef3DPtg(paramLittleEndianInput);
/* 119 */       case 61: return new DeletedArea3DPtg(paramLittleEndianInput); }
/*     */     
/* 121 */     throw new UnsupportedOperationException(" Unknown Ptg in Formula: 0x" + Integer.toHexString(paramByte) + " (" + paramByte + ")");
/*     */   }
/*     */ 
/*     */   
/*     */   private static Ptg createBasePtg(byte paramByte, LittleEndianInput paramLittleEndianInput) {
/* 126 */     switch (paramByte) { case 0:
/* 127 */         return new UnknownPtg(paramByte);
/* 128 */       case 1: return new ExpPtg(paramLittleEndianInput);
/* 129 */       case 2: return new TblPtg(paramLittleEndianInput);
/* 130 */       case 3: return AddPtg.instance;
/* 131 */       case 4: return SubtractPtg.instance;
/* 132 */       case 5: return MultiplyPtg.instance;
/* 133 */       case 6: return DividePtg.instance;
/* 134 */       case 7: return PowerPtg.instance;
/* 135 */       case 8: return ConcatPtg.instance;
/* 136 */       case 9: return LessThanPtg.instance;
/* 137 */       case 10: return LessEqualPtg.instance;
/* 138 */       case 11: return EqualPtg.instance;
/* 139 */       case 12: return GreaterEqualPtg.instance;
/* 140 */       case 13: return GreaterThanPtg.instance;
/* 141 */       case 14: return NotEqualPtg.instance;
/* 142 */       case 15: return IntersectionPtg.instance;
/* 143 */       case 16: return UnionPtg.instance;
/* 144 */       case 17: return RangePtg.instance;
/* 145 */       case 18: return UnaryPlusPtg.instance;
/* 146 */       case 19: return UnaryMinusPtg.instance;
/* 147 */       case 20: return PercentPtg.instance;
/* 148 */       case 21: return ParenthesisPtg.instance;
/* 149 */       case 22: return MissingArgPtg.instance;
/*     */       case 23:
/* 151 */         return new StringPtg(paramLittleEndianInput);
/* 152 */       case 25: return new AttrPtg(paramLittleEndianInput);
/* 153 */       case 28: return ErrPtg.read(paramLittleEndianInput);
/* 154 */       case 29: return BoolPtg.read(paramLittleEndianInput);
/* 155 */       case 30: return new IntPtg(paramLittleEndianInput);
/* 156 */       case 31: return new NumberPtg(paramLittleEndianInput); }
/*     */     
/* 158 */     throw new RuntimeException("Unexpected base token id (" + paramByte + ")");
/*     */   }
/*     */   
/*     */   private static Ptg[] toPtgArray(List<Ptg> paramList) {
/* 162 */     if (paramList.isEmpty()) {
/* 163 */       return EMPTY_PTG_ARRAY;
/*     */     }
/* 165 */     Ptg[] arrayOfPtg = new Ptg[paramList.size()];
/* 166 */     paramList.toArray(arrayOfPtg);
/* 167 */     return arrayOfPtg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getEncodedSize(Ptg[] paramArrayOfPtg) {
/* 175 */     int i = 0;
/* 176 */     for (Ptg ptg : paramArrayOfPtg) {
/* 177 */       i += ptg.getSize();
/*     */     }
/* 179 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getEncodedSizeWithoutArrayData(Ptg[] paramArrayOfPtg) {
/* 186 */     int i = 0;
/* 187 */     for (Ptg ptg : paramArrayOfPtg) {
/* 188 */       if (ptg instanceof ArrayPtg) {
/* 189 */         i += true;
/*     */       } else {
/* 191 */         i += ptg.getSize();
/*     */       } 
/*     */     } 
/* 194 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int serializePtgs(Ptg[] paramArrayOfPtg, byte[] paramArrayOfbyte, int paramInt) {
/* 204 */     LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(paramArrayOfbyte, paramInt);
/*     */     
/* 206 */     ArrayList<Ptg> arrayList = null;
/*     */     
/* 208 */     for (Ptg ptg : paramArrayOfPtg) {
/* 209 */       ptg.write((LittleEndianOutput)littleEndianByteArrayOutputStream);
/* 210 */       if (ptg instanceof ArrayPtg) {
/* 211 */         if (arrayList == null) {
/* 212 */           arrayList = new ArrayList(5);
/*     */         }
/* 214 */         arrayList.add(ptg);
/*     */       } 
/*     */     } 
/* 217 */     if (arrayList != null) {
/* 218 */       for (Ptg ptg : arrayList) {
/* 219 */         ArrayPtg arrayPtg = (ArrayPtg)ptg;
/* 220 */         arrayPtg.writeTokenValueBytes((LittleEndianOutput)littleEndianByteArrayOutputStream);
/*     */       } 
/*     */     }
/* 223 */     return littleEndianByteArrayOutputStream.getWriteIndex() - paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getSize();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void write(LittleEndianOutput paramLittleEndianOutput);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String toFormulaString();
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 244 */     return getClass().toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 251 */   private byte ptgClass = 0;
/*     */   
/*     */   public final void setClass(byte paramByte) {
/* 254 */     if (isBaseToken()) {
/* 255 */       throw new RuntimeException("setClass should not be called on a base token");
/*     */     }
/* 257 */     this.ptgClass = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte getPtgClass() {
/* 264 */     return this.ptgClass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final char getRVAType() {
/* 272 */     if (isBaseToken()) {
/* 273 */       return '.';
/*     */     }
/* 275 */     switch (this.ptgClass) { case 0:
/* 276 */         return 'R';
/* 277 */       case 32: return 'V';
/* 278 */       case 64: return 'A'; }
/*     */     
/* 280 */     throw new RuntimeException("Unknown operand class (" + this.ptgClass + ")");
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract byte getDefaultOperandClass();
/*     */ 
/*     */   
/*     */   public abstract boolean isBaseToken();
/*     */ 
/*     */   
/*     */   public static boolean doesFormulaReferToDeletedCell(Ptg[] paramArrayOfPtg) {
/* 291 */     for (Ptg ptg : paramArrayOfPtg) {
/* 292 */       if (isDeletedCellRef(ptg)) {
/* 293 */         return true;
/*     */       }
/*     */     } 
/* 296 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean isDeletedCellRef(Ptg paramPtg) {
/* 300 */     if (paramPtg == ErrPtg.REF_INVALID) {
/* 301 */       return true;
/*     */     }
/* 303 */     if (paramPtg instanceof DeletedArea3DPtg) {
/* 304 */       return true;
/*     */     }
/* 306 */     if (paramPtg instanceof DeletedRef3DPtg) {
/* 307 */       return true;
/*     */     }
/* 309 */     if (paramPtg instanceof AreaErrPtg) {
/* 310 */       return true;
/*     */     }
/* 312 */     if (paramPtg instanceof RefErrorPtg) {
/* 313 */       return true;
/*     */     }
/* 315 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\Ptg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */