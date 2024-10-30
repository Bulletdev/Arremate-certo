/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.util.CellRangeAddress8Bit;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.SharedFormula;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SharedFormulaRecord
/*     */   extends SharedValueRecordBase
/*     */ {
/*     */   public static final short sid = 1212;
/*     */   private int field_5_reserved;
/*     */   private Formula field_7_parsed_expr;
/*     */   
/*     */   public SharedFormulaRecord() {
/*  47 */     this(new CellRangeAddress8Bit(0, 0, 0, 0));
/*     */   }
/*     */   private SharedFormulaRecord(CellRangeAddress8Bit paramCellRangeAddress8Bit) {
/*  50 */     super(paramCellRangeAddress8Bit);
/*  51 */     this.field_7_parsed_expr = Formula.create(Ptg.EMPTY_PTG_ARRAY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SharedFormulaRecord(RecordInputStream paramRecordInputStream) {
/*  58 */     super(paramRecordInputStream);
/*  59 */     this.field_5_reserved = paramRecordInputStream.readShort();
/*  60 */     short s = paramRecordInputStream.readShort();
/*  61 */     int i = paramRecordInputStream.available();
/*  62 */     this.field_7_parsed_expr = Formula.read(s, paramRecordInputStream, i);
/*     */   }
/*     */   
/*     */   protected void serializeExtraData(LittleEndianOutput paramLittleEndianOutput) {
/*  66 */     paramLittleEndianOutput.writeShort(this.field_5_reserved);
/*  67 */     this.field_7_parsed_expr.serialize(paramLittleEndianOutput);
/*     */   }
/*     */   
/*     */   protected int getExtraDataSize() {
/*  71 */     return 2 + this.field_7_parsed_expr.getEncodedSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  80 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  82 */     stringBuffer.append("[SHARED FORMULA (").append(HexDump.intToHex(1212)).append("]\n");
/*  83 */     stringBuffer.append("    .range      = ").append(getRange().toString()).append("\n");
/*  84 */     stringBuffer.append("    .reserved    = ").append(HexDump.shortToHex(this.field_5_reserved)).append("\n");
/*     */     
/*  86 */     Ptg[] arrayOfPtg = this.field_7_parsed_expr.getTokens();
/*  87 */     for (byte b = 0; b < arrayOfPtg.length; b++) {
/*  88 */       stringBuffer.append("Formula[").append(b).append("]");
/*  89 */       Ptg ptg = arrayOfPtg[b];
/*  90 */       stringBuffer.append(ptg.toString()).append(ptg.getRVAType()).append("\n");
/*     */     } 
/*     */     
/*  93 */     stringBuffer.append("[/SHARED FORMULA]\n");
/*  94 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public short getSid() {
/*  98 */     return 1212;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ptg[] getFormulaTokens(FormulaRecord paramFormulaRecord) {
/* 105 */     int i = paramFormulaRecord.getRow();
/* 106 */     short s = paramFormulaRecord.getColumn();
/*     */     
/* 108 */     if (!isInRange(i, s)) {
/* 109 */       throw new RuntimeException("Shared Formula Conversion: Coding Error");
/*     */     }
/*     */     
/* 112 */     SharedFormula sharedFormula = new SharedFormula(SpreadsheetVersion.EXCEL97);
/* 113 */     return sharedFormula.convertSharedFormulas(this.field_7_parsed_expr.getTokens(), i, s);
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 117 */     SharedFormulaRecord sharedFormulaRecord = new SharedFormulaRecord(getRange());
/* 118 */     sharedFormulaRecord.field_5_reserved = this.field_5_reserved;
/* 119 */     sharedFormulaRecord.field_7_parsed_expr = this.field_7_parsed_expr.copy();
/* 120 */     return sharedFormulaRecord;
/*     */   }
/*     */   public boolean isFormulaSame(SharedFormulaRecord paramSharedFormulaRecord) {
/* 123 */     return this.field_7_parsed_expr.isSame(paramSharedFormulaRecord.field_7_parsed_expr);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\SharedFormulaRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */