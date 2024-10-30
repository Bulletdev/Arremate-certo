/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.util.CellRangeAddress8Bit;
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
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
/*     */ public final class ArrayRecord
/*     */   extends SharedValueRecordBase
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 545;
/*     */   private static final int OPT_ALWAYS_RECALCULATE = 1;
/*     */   private static final int OPT_CALCULATE_ON_OPEN = 2;
/*     */   private int _options;
/*     */   private int _field3notUsed;
/*     */   private Formula _formula;
/*     */   
/*     */   public ArrayRecord(RecordInputStream paramRecordInputStream) {
/*  42 */     super(paramRecordInputStream);
/*  43 */     this._options = paramRecordInputStream.readUShort();
/*  44 */     this._field3notUsed = paramRecordInputStream.readInt();
/*  45 */     int i = paramRecordInputStream.readUShort();
/*  46 */     int j = paramRecordInputStream.available();
/*  47 */     this._formula = Formula.read(i, paramRecordInputStream, j);
/*     */   }
/*     */   
/*     */   public ArrayRecord(Formula paramFormula, CellRangeAddress8Bit paramCellRangeAddress8Bit) {
/*  51 */     super(paramCellRangeAddress8Bit);
/*  52 */     this._options = 0;
/*  53 */     this._field3notUsed = 0;
/*  54 */     this._formula = paramFormula;
/*     */   }
/*     */   
/*     */   public boolean isAlwaysRecalculate() {
/*  58 */     return ((this._options & 0x1) != 0);
/*     */   }
/*     */   public boolean isCalculateOnOpen() {
/*  61 */     return ((this._options & 0x2) != 0);
/*     */   }
/*     */   
/*     */   public Ptg[] getFormulaTokens() {
/*  65 */     return this._formula.getTokens();
/*     */   }
/*     */   
/*     */   protected int getExtraDataSize() {
/*  69 */     return 6 + this._formula.getEncodedSize();
/*     */   }
/*     */   protected void serializeExtraData(LittleEndianOutput paramLittleEndianOutput) {
/*  72 */     paramLittleEndianOutput.writeShort(this._options);
/*  73 */     paramLittleEndianOutput.writeInt(this._field3notUsed);
/*  74 */     this._formula.serialize(paramLittleEndianOutput);
/*     */   }
/*     */   
/*     */   public short getSid() {
/*  78 */     return 545;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  82 */     StringBuffer stringBuffer = new StringBuffer();
/*  83 */     stringBuffer.append(getClass().getName()).append(" [ARRAY]\n");
/*  84 */     stringBuffer.append(" range=").append(getRange().toString()).append("\n");
/*  85 */     stringBuffer.append(" options=").append(HexDump.shortToHex(this._options)).append("\n");
/*  86 */     stringBuffer.append(" notUsed=").append(HexDump.intToHex(this._field3notUsed)).append("\n");
/*  87 */     stringBuffer.append(" formula:").append("\n");
/*  88 */     Ptg[] arrayOfPtg = this._formula.getTokens();
/*  89 */     for (byte b = 0; b < arrayOfPtg.length; b++) {
/*  90 */       Ptg ptg = arrayOfPtg[b];
/*  91 */       stringBuffer.append(ptg.toString()).append(ptg.getRVAType()).append("\n");
/*     */     } 
/*  93 */     stringBuffer.append("]");
/*  94 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayRecord clone() {
/*  99 */     ArrayRecord arrayRecord = new ArrayRecord(this._formula.copy(), getRange());
/*     */ 
/*     */     
/* 102 */     arrayRecord._options = this._options;
/* 103 */     arrayRecord._field3notUsed = this._field3notUsed;
/*     */     
/* 105 */     return arrayRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ArrayRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */