/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.AreaEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.RefEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
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
/*     */ public final class Offset
/*     */   implements Function
/*     */ {
/*     */   private static final int LAST_VALID_ROW_INDEX = 65535;
/*     */   private static final int LAST_VALID_COLUMN_INDEX = 255;
/*     */   
/*     */   static final class LinearOffsetRange
/*     */   {
/*     */     private final int _offset;
/*     */     private final int _length;
/*     */     
/*     */     public LinearOffsetRange(int param1Int1, int param1Int2) {
/*  59 */       if (param1Int2 == 0)
/*     */       {
/*  61 */         throw new RuntimeException("length may not be zero");
/*     */       }
/*  63 */       this._offset = param1Int1;
/*  64 */       this._length = param1Int2;
/*     */     }
/*     */     
/*     */     public short getFirstIndex() {
/*  68 */       return (short)this._offset;
/*     */     }
/*     */     public short getLastIndex() {
/*  71 */       return (short)(this._offset + this._length - 1);
/*     */     }
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
/*     */     public LinearOffsetRange normaliseAndTranslate(int param1Int) {
/*  86 */       if (this._length > 0) {
/*  87 */         if (param1Int == 0) {
/*  88 */           return this;
/*     */         }
/*  90 */         return new LinearOffsetRange(param1Int + this._offset, this._length);
/*     */       } 
/*  92 */       return new LinearOffsetRange(param1Int + this._offset + this._length + 1, -this._length);
/*     */     }
/*     */     
/*     */     public boolean isOutOfBounds(int param1Int1, int param1Int2) {
/*  96 */       if (this._offset < param1Int1) {
/*  97 */         return true;
/*     */       }
/*  99 */       if (getLastIndex() > param1Int2) {
/* 100 */         return true;
/*     */       }
/* 102 */       return false;
/*     */     }
/*     */     public String toString() {
/* 105 */       StringBuffer stringBuffer = new StringBuffer(64);
/* 106 */       stringBuffer.append(getClass().getName()).append(" [");
/* 107 */       stringBuffer.append(this._offset).append("...").append(getLastIndex());
/* 108 */       stringBuffer.append("]");
/* 109 */       return stringBuffer.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class BaseRef
/*     */   {
/*     */     private final int _firstRowIndex;
/*     */     
/*     */     private final int _firstColumnIndex;
/*     */     private final int _width;
/*     */     private final int _height;
/*     */     private final RefEval _refEval;
/*     */     private final AreaEval _areaEval;
/*     */     
/*     */     public BaseRef(RefEval param1RefEval) {
/* 125 */       this._refEval = param1RefEval;
/* 126 */       this._areaEval = null;
/* 127 */       this._firstRowIndex = param1RefEval.getRow();
/* 128 */       this._firstColumnIndex = param1RefEval.getColumn();
/* 129 */       this._height = 1;
/* 130 */       this._width = 1;
/*     */     }
/*     */     
/*     */     public BaseRef(AreaEval param1AreaEval) {
/* 134 */       this._refEval = null;
/* 135 */       this._areaEval = param1AreaEval;
/* 136 */       this._firstRowIndex = param1AreaEval.getFirstRow();
/* 137 */       this._firstColumnIndex = param1AreaEval.getFirstColumn();
/* 138 */       this._height = param1AreaEval.getLastRow() - param1AreaEval.getFirstRow() + 1;
/* 139 */       this._width = param1AreaEval.getLastColumn() - param1AreaEval.getFirstColumn() + 1;
/*     */     }
/*     */     
/*     */     public int getWidth() {
/* 143 */       return this._width;
/*     */     }
/*     */     public int getHeight() {
/* 146 */       return this._height;
/*     */     }
/*     */     public int getFirstRowIndex() {
/* 149 */       return this._firstRowIndex;
/*     */     }
/*     */     public int getFirstColumnIndex() {
/* 152 */       return this._firstColumnIndex;
/*     */     }
/*     */ 
/*     */     
/*     */     public AreaEval offset(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 157 */       if (this._refEval == null) {
/* 158 */         return this._areaEval.offset(param1Int1, param1Int2, param1Int3, param1Int4);
/*     */       }
/* 160 */       return this._refEval.offset(param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 166 */     if (paramArrayOfValueEval.length < 3 || paramArrayOfValueEval.length > 5) {
/* 167 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */     
/*     */     try {
/* 171 */       BaseRef baseRef = evaluateBaseRef(paramArrayOfValueEval[0]);
/* 172 */       int i = evaluateIntArg(paramArrayOfValueEval[1], paramInt1, paramInt2);
/* 173 */       int j = evaluateIntArg(paramArrayOfValueEval[2], paramInt1, paramInt2);
/* 174 */       int k = baseRef.getHeight();
/* 175 */       int m = baseRef.getWidth();
/*     */ 
/*     */       
/* 178 */       switch (paramArrayOfValueEval.length) {
/*     */         case 5:
/* 180 */           if (!(paramArrayOfValueEval[4] instanceof org.apache.poi.ss.formula.eval.MissingArgEval)) {
/* 181 */             m = evaluateIntArg(paramArrayOfValueEval[4], paramInt1, paramInt2);
/*     */           }
/*     */         
/*     */         case 4:
/* 185 */           if (!(paramArrayOfValueEval[3] instanceof org.apache.poi.ss.formula.eval.MissingArgEval)) {
/* 186 */             k = evaluateIntArg(paramArrayOfValueEval[3], paramInt1, paramInt2);
/*     */           }
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 195 */       if (k == 0 || m == 0) {
/* 196 */         return (ValueEval)ErrorEval.REF_INVALID;
/*     */       }
/* 198 */       LinearOffsetRange linearOffsetRange1 = new LinearOffsetRange(i, k);
/* 199 */       LinearOffsetRange linearOffsetRange2 = new LinearOffsetRange(j, m);
/* 200 */       return (ValueEval)createOffset(baseRef, linearOffsetRange1, linearOffsetRange2);
/* 201 */     } catch (EvaluationException evaluationException) {
/* 202 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static AreaEval createOffset(BaseRef paramBaseRef, LinearOffsetRange paramLinearOffsetRange1, LinearOffsetRange paramLinearOffsetRange2) throws EvaluationException {
/* 208 */     LinearOffsetRange linearOffsetRange1 = paramLinearOffsetRange1.normaliseAndTranslate(paramBaseRef.getFirstRowIndex());
/* 209 */     LinearOffsetRange linearOffsetRange2 = paramLinearOffsetRange2.normaliseAndTranslate(paramBaseRef.getFirstColumnIndex());
/*     */     
/* 211 */     if (linearOffsetRange1.isOutOfBounds(0, 65535)) {
/* 212 */       throw new EvaluationException(ErrorEval.REF_INVALID);
/*     */     }
/* 214 */     if (linearOffsetRange2.isOutOfBounds(0, 255)) {
/* 215 */       throw new EvaluationException(ErrorEval.REF_INVALID);
/*     */     }
/* 217 */     return paramBaseRef.offset(paramLinearOffsetRange1.getFirstIndex(), paramLinearOffsetRange1.getLastIndex(), paramLinearOffsetRange2.getFirstIndex(), paramLinearOffsetRange2.getLastIndex());
/*     */   }
/*     */ 
/*     */   
/*     */   private static BaseRef evaluateBaseRef(ValueEval paramValueEval) throws EvaluationException {
/* 222 */     if (paramValueEval instanceof RefEval) {
/* 223 */       return new BaseRef((RefEval)paramValueEval);
/*     */     }
/* 225 */     if (paramValueEval instanceof AreaEval) {
/* 226 */       return new BaseRef((AreaEval)paramValueEval);
/*     */     }
/* 228 */     if (paramValueEval instanceof ErrorEval) {
/* 229 */       throw new EvaluationException((ErrorEval)paramValueEval);
/*     */     }
/* 231 */     throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int evaluateIntArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 238 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 239 */     return OperandResolver.coerceValueToInt(valueEval);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Offset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */