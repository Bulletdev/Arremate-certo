/*     */ package org.apache.poi.hssf.record.aggregates;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.model.RecordStream;
/*     */ import org.apache.poi.hssf.record.CFHeader12Record;
/*     */ import org.apache.poi.hssf.record.CFHeaderBase;
/*     */ import org.apache.poi.hssf.record.CFHeaderRecord;
/*     */ import org.apache.poi.hssf.record.CFRule12Record;
/*     */ import org.apache.poi.hssf.record.CFRuleBase;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.ss.formula.FormulaShifter;
/*     */ import org.apache.poi.ss.formula.ptg.AreaPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.RecordFormatException;
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
/*     */ public final class CFRecordsAggregate
/*     */   extends RecordAggregate
/*     */ {
/*     */   private static final int MAX_97_2003_CONDTIONAL_FORMAT_RULES = 3;
/*  51 */   private static final POILogger logger = POILogFactory.getLogger(CFRecordsAggregate.class);
/*     */   
/*     */   private final CFHeaderBase header;
/*     */   
/*     */   private final List<CFRuleBase> rules;
/*     */ 
/*     */   
/*     */   private CFRecordsAggregate(CFHeaderBase paramCFHeaderBase, CFRuleBase[] paramArrayOfCFRuleBase) {
/*  59 */     if (paramCFHeaderBase == null) {
/*  60 */       throw new IllegalArgumentException("header must not be null");
/*     */     }
/*  62 */     if (paramArrayOfCFRuleBase == null) {
/*  63 */       throw new IllegalArgumentException("rules must not be null");
/*     */     }
/*  65 */     if (paramArrayOfCFRuleBase.length > 3) {
/*  66 */       logger.log(5, new Object[] { "Excel versions before 2007 require that No more than 3 rules may be specified, " + paramArrayOfCFRuleBase.length + " were found," + " this file will cause problems with old Excel versions" });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  71 */     if (paramArrayOfCFRuleBase.length != paramCFHeaderBase.getNumberOfConditionalFormats()) {
/*  72 */       throw new RecordFormatException("Mismatch number of rules");
/*     */     }
/*  74 */     this.header = paramCFHeaderBase;
/*  75 */     this.rules = new ArrayList<CFRuleBase>(paramArrayOfCFRuleBase.length);
/*  76 */     for (CFRuleBase cFRuleBase : paramArrayOfCFRuleBase) {
/*  77 */       checkRuleType(cFRuleBase);
/*  78 */       this.rules.add(cFRuleBase);
/*     */     } 
/*     */   }
/*     */   
/*     */   public CFRecordsAggregate(CellRangeAddress[] paramArrayOfCellRangeAddress, CFRuleBase[] paramArrayOfCFRuleBase) {
/*  83 */     this(createHeader(paramArrayOfCellRangeAddress, paramArrayOfCFRuleBase), paramArrayOfCFRuleBase);
/*     */   }
/*     */   private static CFHeaderBase createHeader(CellRangeAddress[] paramArrayOfCellRangeAddress, CFRuleBase[] paramArrayOfCFRuleBase) {
/*     */     CFHeader12Record cFHeader12Record;
/*  87 */     if (paramArrayOfCFRuleBase.length == 0 || paramArrayOfCFRuleBase[0] instanceof org.apache.poi.hssf.record.CFRuleRecord) {
/*  88 */       CFHeaderRecord cFHeaderRecord = new CFHeaderRecord(paramArrayOfCellRangeAddress, paramArrayOfCFRuleBase.length);
/*     */     } else {
/*  90 */       cFHeader12Record = new CFHeader12Record(paramArrayOfCellRangeAddress, paramArrayOfCFRuleBase.length);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  95 */     cFHeader12Record.setNeedRecalculation(true);
/*     */     
/*  97 */     return (CFHeaderBase)cFHeader12Record;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CFRecordsAggregate createCFAggregate(RecordStream paramRecordStream) {
/* 106 */     Record record = paramRecordStream.getNext();
/* 107 */     if (record.getSid() != 432 && record.getSid() != 2169)
/*     */     {
/* 109 */       throw new IllegalStateException("next record sid was " + record.getSid() + " instead of " + 'ư' + " or " + 'ࡹ' + " as expected");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 114 */     CFHeaderBase cFHeaderBase = (CFHeaderBase)record;
/* 115 */     int i = cFHeaderBase.getNumberOfConditionalFormats();
/*     */     
/* 117 */     CFRuleBase[] arrayOfCFRuleBase = new CFRuleBase[i];
/* 118 */     for (byte b = 0; b < arrayOfCFRuleBase.length; b++) {
/* 119 */       arrayOfCFRuleBase[b] = (CFRuleBase)paramRecordStream.getNext();
/*     */     }
/*     */     
/* 122 */     return new CFRecordsAggregate(cFHeaderBase, arrayOfCFRuleBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CFRecordsAggregate cloneCFAggregate() {
/* 129 */     CFRuleBase[] arrayOfCFRuleBase = new CFRuleBase[this.rules.size()];
/* 130 */     for (byte b = 0; b < arrayOfCFRuleBase.length; b++) {
/* 131 */       arrayOfCFRuleBase[b] = getRule(b).clone();
/*     */     }
/* 133 */     return new CFRecordsAggregate(this.header.clone(), arrayOfCFRuleBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CFHeaderBase getHeader() {
/* 140 */     return this.header;
/*     */   }
/*     */   
/*     */   private void checkRuleIndex(int paramInt) {
/* 144 */     if (paramInt < 0 || paramInt >= this.rules.size()) {
/* 145 */       throw new IllegalArgumentException("Bad rule record index (" + paramInt + ") nRules=" + this.rules.size());
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkRuleType(CFRuleBase paramCFRuleBase) {
/* 150 */     if (this.header instanceof CFHeaderRecord && paramCFRuleBase instanceof org.apache.poi.hssf.record.CFRuleRecord) {
/*     */       return;
/*     */     }
/*     */     
/* 154 */     if (this.header instanceof CFHeader12Record && paramCFRuleBase instanceof CFRule12Record) {
/*     */       return;
/*     */     }
/*     */     
/* 158 */     throw new IllegalArgumentException("Header and Rule must both be CF or both be CF12, can't mix");
/*     */   }
/*     */   
/*     */   public CFRuleBase getRule(int paramInt) {
/* 162 */     checkRuleIndex(paramInt);
/* 163 */     return this.rules.get(paramInt);
/*     */   }
/*     */   public void setRule(int paramInt, CFRuleBase paramCFRuleBase) {
/* 166 */     if (paramCFRuleBase == null) {
/* 167 */       throw new IllegalArgumentException("r must not be null");
/*     */     }
/* 169 */     checkRuleIndex(paramInt);
/* 170 */     checkRuleType(paramCFRuleBase);
/* 171 */     this.rules.set(paramInt, paramCFRuleBase);
/*     */   }
/*     */   public void addRule(CFRuleBase paramCFRuleBase) {
/* 174 */     if (paramCFRuleBase == null) {
/* 175 */       throw new IllegalArgumentException("r must not be null");
/*     */     }
/* 177 */     if (this.rules.size() >= 3) {
/* 178 */       logger.log(5, new Object[] { "Excel versions before 2007 cannot cope with any more than 3 - this file will cause problems with old Excel versions" });
/*     */     }
/*     */ 
/*     */     
/* 182 */     checkRuleType(paramCFRuleBase);
/* 183 */     this.rules.add(paramCFRuleBase);
/* 184 */     this.header.setNumberOfConditionalFormats(this.rules.size());
/*     */   }
/*     */   public int getNumberOfRules() {
/* 187 */     return this.rules.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 194 */     StringBuilder stringBuilder = new StringBuilder();
/* 195 */     String str = "CF";
/* 196 */     if (this.header instanceof CFHeader12Record) {
/* 197 */       str = "CF12";
/*     */     }
/*     */     
/* 200 */     stringBuilder.append("[").append(str).append("]\n");
/* 201 */     if (this.header != null) {
/* 202 */       stringBuilder.append(this.header.toString());
/*     */     }
/* 204 */     for (CFRuleBase cFRuleBase : this.rules) {
/* 205 */       stringBuilder.append(cFRuleBase.toString());
/*     */     }
/* 207 */     stringBuilder.append("[/").append(str).append("]\n");
/* 208 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 212 */     paramRecordVisitor.visitRecord((Record)this.header);
/* 213 */     for (CFRuleBase cFRuleBase : this.rules) {
/* 214 */       paramRecordVisitor.visitRecord((Record)cFRuleBase);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean updateFormulasAfterCellShift(FormulaShifter paramFormulaShifter, int paramInt) {
/* 222 */     CellRangeAddress[] arrayOfCellRangeAddress = this.header.getCellRanges();
/* 223 */     boolean bool = false;
/* 224 */     ArrayList<CellRangeAddress> arrayList = new ArrayList();
/* 225 */     for (CellRangeAddress cellRangeAddress1 : arrayOfCellRangeAddress) {
/* 226 */       CellRangeAddress cellRangeAddress2 = shiftRange(paramFormulaShifter, cellRangeAddress1, paramInt);
/* 227 */       if (cellRangeAddress2 == null) {
/* 228 */         bool = true;
/*     */       } else {
/*     */         
/* 231 */         arrayList.add(cellRangeAddress2);
/* 232 */         if (cellRangeAddress2 != cellRangeAddress1) {
/* 233 */           bool = true;
/*     */         }
/*     */       } 
/*     */     } 
/* 237 */     if (bool) {
/* 238 */       int i = arrayList.size();
/* 239 */       if (i == 0) {
/* 240 */         return false;
/*     */       }
/* 242 */       CellRangeAddress[] arrayOfCellRangeAddress1 = new CellRangeAddress[i];
/* 243 */       arrayList.toArray(arrayOfCellRangeAddress1);
/* 244 */       this.header.setCellRanges(arrayOfCellRangeAddress1);
/*     */     } 
/*     */     
/* 247 */     for (CFRuleBase cFRuleBase : this.rules) {
/*     */       
/* 249 */       Ptg[] arrayOfPtg = cFRuleBase.getParsedExpression1();
/* 250 */       if (arrayOfPtg != null && paramFormulaShifter.adjustFormula(arrayOfPtg, paramInt)) {
/* 251 */         cFRuleBase.setParsedExpression1(arrayOfPtg);
/*     */       }
/* 253 */       arrayOfPtg = cFRuleBase.getParsedExpression2();
/* 254 */       if (arrayOfPtg != null && paramFormulaShifter.adjustFormula(arrayOfPtg, paramInt)) {
/* 255 */         cFRuleBase.setParsedExpression2(arrayOfPtg);
/*     */       }
/* 257 */       if (cFRuleBase instanceof CFRule12Record) {
/* 258 */         CFRule12Record cFRule12Record = (CFRule12Record)cFRuleBase;
/* 259 */         arrayOfPtg = cFRule12Record.getParsedExpressionScale();
/* 260 */         if (arrayOfPtg != null && paramFormulaShifter.adjustFormula(arrayOfPtg, paramInt)) {
/* 261 */           cFRule12Record.setParsedExpressionScale(arrayOfPtg);
/*     */         }
/*     */       } 
/*     */     } 
/* 265 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static CellRangeAddress shiftRange(FormulaShifter paramFormulaShifter, CellRangeAddress paramCellRangeAddress, int paramInt) {
/* 270 */     AreaPtg areaPtg = new AreaPtg(paramCellRangeAddress.getFirstRow(), paramCellRangeAddress.getLastRow(), paramCellRangeAddress.getFirstColumn(), paramCellRangeAddress.getLastColumn(), false, false, false, false);
/* 271 */     Ptg[] arrayOfPtg = { (Ptg)areaPtg };
/*     */     
/* 273 */     if (!paramFormulaShifter.adjustFormula(arrayOfPtg, paramInt)) {
/* 274 */       return paramCellRangeAddress;
/*     */     }
/* 276 */     Ptg ptg = arrayOfPtg[0];
/* 277 */     if (ptg instanceof AreaPtg) {
/* 278 */       AreaPtg areaPtg1 = (AreaPtg)ptg;
/* 279 */       return new CellRangeAddress(areaPtg1.getFirstRow(), areaPtg1.getLastRow(), areaPtg1.getFirstColumn(), areaPtg1.getLastColumn());
/*     */     } 
/* 281 */     if (ptg instanceof org.apache.poi.ss.formula.ptg.AreaErrPtg) {
/* 282 */       return null;
/*     */     }
/* 284 */     throw new IllegalStateException("Unexpected shifted ptg class (" + ptg.getClass().getName() + ")");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\CFRecordsAggregate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */