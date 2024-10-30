/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
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
/*     */ public final class CFRuleRecord
/*     */   extends CFRuleBase
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 433;
/*     */   
/*     */   private CFRuleRecord(byte paramByte1, byte paramByte2) {
/*  39 */     super(paramByte1, paramByte2);
/*  40 */     setDefaults();
/*     */   }
/*     */   
/*     */   private CFRuleRecord(byte paramByte1, byte paramByte2, Ptg[] paramArrayOfPtg1, Ptg[] paramArrayOfPtg2) {
/*  44 */     super(paramByte1, paramByte2, paramArrayOfPtg1, paramArrayOfPtg2);
/*  45 */     setDefaults();
/*     */   }
/*     */   
/*     */   private void setDefaults() {
/*  49 */     this.formatting_options = modificationBits.setValue(this.formatting_options, -1);
/*     */     
/*  51 */     this.formatting_options = fmtBlockBits.setValue(this.formatting_options, 0);
/*  52 */     this.formatting_options = undocumented.clear(this.formatting_options);
/*     */     
/*  54 */     this.formatting_not_used = -32766;
/*  55 */     this._fontFormatting = null;
/*  56 */     this._borderFormatting = null;
/*  57 */     this._patternFormatting = null;
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
/*     */   public static CFRuleRecord create(HSSFSheet paramHSSFSheet, String paramString) {
/*  69 */     Ptg[] arrayOfPtg = parseFormula(paramString, paramHSSFSheet);
/*  70 */     return new CFRuleRecord((byte)2, (byte)0, arrayOfPtg, null);
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
/*     */   public static CFRuleRecord create(HSSFSheet paramHSSFSheet, byte paramByte, String paramString1, String paramString2) {
/*  85 */     Ptg[] arrayOfPtg1 = parseFormula(paramString1, paramHSSFSheet);
/*  86 */     Ptg[] arrayOfPtg2 = parseFormula(paramString2, paramHSSFSheet);
/*  87 */     return new CFRuleRecord((byte)1, paramByte, arrayOfPtg1, arrayOfPtg2);
/*     */   }
/*     */   
/*     */   public CFRuleRecord(RecordInputStream paramRecordInputStream) {
/*  91 */     setConditionType(paramRecordInputStream.readByte());
/*  92 */     setComparisonOperation(paramRecordInputStream.readByte());
/*  93 */     int i = paramRecordInputStream.readUShort();
/*  94 */     int j = paramRecordInputStream.readUShort();
/*  95 */     readFormatOptions(paramRecordInputStream);
/*     */ 
/*     */     
/*  98 */     setFormula1(Formula.read(i, paramRecordInputStream));
/*  99 */     setFormula2(Formula.read(j, paramRecordInputStream));
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 104 */     return 433;
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
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 116 */     int i = getFormulaSize(getFormula1());
/* 117 */     int j = getFormulaSize(getFormula2());
/*     */     
/* 119 */     paramLittleEndianOutput.writeByte(getConditionType());
/* 120 */     paramLittleEndianOutput.writeByte(getComparisonOperation());
/* 121 */     paramLittleEndianOutput.writeShort(i);
/* 122 */     paramLittleEndianOutput.writeShort(j);
/*     */     
/* 124 */     serializeFormattingBlock(paramLittleEndianOutput);
/*     */     
/* 126 */     getFormula1().serializeTokens(paramLittleEndianOutput);
/* 127 */     getFormula2().serializeTokens(paramLittleEndianOutput);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 132 */     return 6 + getFormattingBlockSize() + getFormulaSize(getFormula1()) + getFormulaSize(getFormula2());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 139 */     StringBuffer stringBuffer = new StringBuffer();
/* 140 */     stringBuffer.append("[CFRULE]\n");
/* 141 */     stringBuffer.append("    .condition_type   =").append(getConditionType()).append("\n");
/* 142 */     stringBuffer.append("    OPTION FLAGS=0x").append(Integer.toHexString(getOptions())).append("\n");
/* 143 */     if (containsFontFormattingBlock()) {
/* 144 */       stringBuffer.append(this._fontFormatting.toString()).append("\n");
/*     */     }
/* 146 */     if (containsBorderFormattingBlock()) {
/* 147 */       stringBuffer.append(this._borderFormatting.toString()).append("\n");
/*     */     }
/* 149 */     if (containsPatternFormattingBlock()) {
/* 150 */       stringBuffer.append(this._patternFormatting.toString()).append("\n");
/*     */     }
/* 152 */     stringBuffer.append("    Formula 1 =").append(Arrays.toString((Object[])getFormula1().getTokens())).append("\n");
/* 153 */     stringBuffer.append("    Formula 2 =").append(Arrays.toString((Object[])getFormula2().getTokens())).append("\n");
/* 154 */     stringBuffer.append("[/CFRULE]\n");
/* 155 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public CFRuleRecord clone() {
/* 160 */     CFRuleRecord cFRuleRecord = new CFRuleRecord(getConditionType(), getComparisonOperation());
/* 161 */     copyTo(cFRuleRecord);
/* 162 */     return cFRuleRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CFRuleRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */