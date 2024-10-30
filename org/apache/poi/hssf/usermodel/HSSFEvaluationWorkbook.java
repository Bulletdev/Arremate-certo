/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.model.InternalWorkbook;
/*     */ import org.apache.poi.hssf.record.NameRecord;
/*     */ import org.apache.poi.hssf.record.aggregates.FormulaRecordAggregate;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.formula.EvaluationCell;
/*     */ import org.apache.poi.ss.formula.EvaluationName;
/*     */ import org.apache.poi.ss.formula.EvaluationSheet;
/*     */ import org.apache.poi.ss.formula.EvaluationWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaParsingWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
/*     */ import org.apache.poi.ss.formula.SheetIdentifier;
/*     */ import org.apache.poi.ss.formula.SheetRangeIdentifier;
/*     */ import org.apache.poi.ss.formula.ptg.Area3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.NamePtg;
/*     */ import org.apache.poi.ss.formula.ptg.NameXPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.ptg.Ref3DPtg;
/*     */ import org.apache.poi.ss.formula.udf.UDFFinder;
/*     */ import org.apache.poi.ss.usermodel.Table;
/*     */ import org.apache.poi.ss.util.AreaReference;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ @Internal
/*     */ public final class HSSFEvaluationWorkbook
/*     */   implements EvaluationWorkbook, FormulaParsingWorkbook, FormulaRenderingWorkbook
/*     */ {
/*  53 */   private static POILogger logger = POILogFactory.getLogger(HSSFEvaluationWorkbook.class);
/*     */   private final HSSFWorkbook _uBook;
/*     */   private final InternalWorkbook _iBook;
/*     */   
/*     */   public static HSSFEvaluationWorkbook create(HSSFWorkbook paramHSSFWorkbook) {
/*  58 */     if (paramHSSFWorkbook == null) {
/*  59 */       return null;
/*     */     }
/*  61 */     return new HSSFEvaluationWorkbook(paramHSSFWorkbook);
/*     */   }
/*     */   
/*     */   private HSSFEvaluationWorkbook(HSSFWorkbook paramHSSFWorkbook) {
/*  65 */     this._uBook = paramHSSFWorkbook;
/*  66 */     this._iBook = paramHSSFWorkbook.getWorkbook();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearAllCachedResultValues() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFName createName() {
/*  79 */     return this._uBook.createName();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getExternalSheetIndex(String paramString) {
/*  84 */     int i = this._uBook.getSheetIndex(paramString);
/*  85 */     return this._iBook.checkExternSheet(i);
/*     */   }
/*     */   
/*     */   public int getExternalSheetIndex(String paramString1, String paramString2) {
/*  89 */     return this._iBook.getExternalSheetIndex(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Ptg get3DReferencePtg(CellReference paramCellReference, SheetIdentifier paramSheetIdentifier) {
/*  94 */     int i = getSheetExtIx(paramSheetIdentifier);
/*  95 */     return (Ptg)new Ref3DPtg(paramCellReference, i);
/*     */   }
/*     */   
/*     */   public Ptg get3DReferencePtg(AreaReference paramAreaReference, SheetIdentifier paramSheetIdentifier) {
/*  99 */     int i = getSheetExtIx(paramSheetIdentifier);
/* 100 */     return (Ptg)new Area3DPtg(paramAreaReference, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameXPtg getNameXPtg(String paramString, SheetIdentifier paramSheetIdentifier) {
/* 107 */     int i = getSheetExtIx(paramSheetIdentifier);
/* 108 */     return this._iBook.getNameXPtg(paramString, i, this._uBook.getUDFFinder());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EvaluationName getName(String paramString, int paramInt) {
/* 119 */     for (byte b = 0; b < this._iBook.getNumNames(); b++) {
/* 120 */       NameRecord nameRecord = this._iBook.getNameRecord(b);
/* 121 */       if (nameRecord.getSheetNumber() == paramInt + 1 && paramString.equalsIgnoreCase(nameRecord.getNameText())) {
/* 122 */         return new Name(nameRecord, b);
/*     */       }
/*     */     } 
/* 125 */     return (paramInt == -1) ? null : getName(paramString, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSheetIndex(EvaluationSheet paramEvaluationSheet) {
/* 130 */     HSSFSheet hSSFSheet = ((HSSFEvaluationSheet)paramEvaluationSheet).getHSSFSheet();
/* 131 */     return this._uBook.getSheetIndex(hSSFSheet);
/*     */   }
/*     */   
/*     */   public int getSheetIndex(String paramString) {
/* 135 */     return this._uBook.getSheetIndex(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSheetName(int paramInt) {
/* 140 */     return this._uBook.getSheetName(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EvaluationSheet getSheet(int paramInt) {
/* 146 */     return new HSSFEvaluationSheet(this._uBook.getSheetAt(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int convertFromExternSheetIndex(int paramInt) {
/* 151 */     return this._iBook.getFirstSheetIndexFromExternSheetIndex(paramInt);
/*     */   }
/*     */   
/*     */   public EvaluationWorkbook.ExternalSheet getExternalSheet(int paramInt) {
/*     */     EvaluationWorkbook.ExternalSheetRange externalSheetRange;
/* 156 */     EvaluationWorkbook.ExternalSheet externalSheet = this._iBook.getExternalSheet(paramInt);
/* 157 */     if (externalSheet == null) {
/*     */       
/* 159 */       int i = convertFromExternSheetIndex(paramInt);
/* 160 */       if (i == -1)
/*     */       {
/* 162 */         return null;
/*     */       }
/* 164 */       if (i == -2)
/*     */       {
/* 166 */         return null;
/*     */       }
/*     */ 
/*     */       
/* 170 */       String str = getSheetName(i);
/*     */ 
/*     */       
/* 173 */       int j = this._iBook.getLastSheetIndexFromExternSheetIndex(paramInt);
/* 174 */       if (j == i) {
/* 175 */         externalSheet = new EvaluationWorkbook.ExternalSheet(null, str);
/*     */       } else {
/* 177 */         String str1 = getSheetName(j);
/* 178 */         externalSheetRange = new EvaluationWorkbook.ExternalSheetRange(null, str, str1);
/*     */       } 
/*     */     } 
/* 181 */     return (EvaluationWorkbook.ExternalSheet)externalSheetRange;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EvaluationWorkbook.ExternalSheet getExternalSheet(String paramString1, String paramString2, int paramInt) {
/* 189 */     throw new IllegalStateException("XSSF-style external references are not supported for HSSF");
/*     */   }
/*     */ 
/*     */   
/*     */   public EvaluationWorkbook.ExternalName getExternalName(int paramInt1, int paramInt2) {
/* 194 */     return this._iBook.getExternalName(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EvaluationWorkbook.ExternalName getExternalName(String paramString1, String paramString2, int paramInt) {
/* 202 */     throw new IllegalStateException("XSSF-style external names are not supported for HSSF");
/*     */   }
/*     */ 
/*     */   
/*     */   public String resolveNameXText(NameXPtg paramNameXPtg) {
/* 207 */     return this._iBook.resolveNameXText(paramNameXPtg.getSheetRefIndex(), paramNameXPtg.getNameIndex());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSheetFirstNameByExternSheet(int paramInt) {
/* 212 */     return this._iBook.findSheetFirstNameFromExternSheet(paramInt);
/*     */   }
/*     */   
/*     */   public String getSheetLastNameByExternSheet(int paramInt) {
/* 216 */     return this._iBook.findSheetLastNameFromExternSheet(paramInt);
/*     */   }
/*     */   
/*     */   public String getNameText(NamePtg paramNamePtg) {
/* 220 */     return this._iBook.getNameRecord(paramNamePtg.getIndex()).getNameText();
/*     */   }
/*     */   
/*     */   public EvaluationName getName(NamePtg paramNamePtg) {
/* 224 */     int i = paramNamePtg.getIndex();
/* 225 */     return new Name(this._iBook.getNameRecord(i), i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Ptg[] getFormulaTokens(EvaluationCell paramEvaluationCell) {
/* 231 */     HSSFCell hSSFCell = ((HSSFEvaluationCell)paramEvaluationCell).getHSSFCell();
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
/* 245 */     FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate)hSSFCell.getCellValueRecord();
/* 246 */     return formulaRecordAggregate.getFormulaTokens();
/*     */   }
/*     */ 
/*     */   
/*     */   public UDFFinder getUDFFinder() {
/* 251 */     return this._uBook.getUDFFinder();
/*     */   }
/*     */   
/*     */   private static final class Name implements EvaluationName {
/*     */     private final NameRecord _nameRecord;
/*     */     private final int _index;
/*     */     
/*     */     public Name(NameRecord param1NameRecord, int param1Int) {
/* 259 */       this._nameRecord = param1NameRecord;
/* 260 */       this._index = param1Int;
/*     */     }
/*     */     public Ptg[] getNameDefinition() {
/* 263 */       return this._nameRecord.getNameDefinition();
/*     */     }
/*     */     public String getNameText() {
/* 266 */       return this._nameRecord.getNameText();
/*     */     }
/*     */     public boolean hasFormula() {
/* 269 */       return this._nameRecord.hasFormula();
/*     */     }
/*     */     public boolean isFunctionName() {
/* 272 */       return this._nameRecord.isFunctionName();
/*     */     }
/*     */     public boolean isRange() {
/* 275 */       return this._nameRecord.hasFormula();
/*     */     }
/*     */     public NamePtg createPtg() {
/* 278 */       return new NamePtg(this._index);
/*     */     }
/*     */   }
/*     */   
/*     */   private int getSheetExtIx(SheetIdentifier paramSheetIdentifier) {
/*     */     int i;
/* 284 */     if (paramSheetIdentifier == null) {
/* 285 */       i = -1;
/*     */     } else {
/* 287 */       String str1 = paramSheetIdentifier.getBookName();
/* 288 */       String str2 = paramSheetIdentifier.getSheetIdentifier().getName();
/* 289 */       String str3 = str2;
/*     */       
/* 291 */       if (paramSheetIdentifier instanceof SheetRangeIdentifier) {
/* 292 */         str3 = ((SheetRangeIdentifier)paramSheetIdentifier).getLastSheetIdentifier().getName();
/*     */       }
/*     */       
/* 295 */       if (str1 == null) {
/* 296 */         int j = this._uBook.getSheetIndex(str2);
/* 297 */         int k = this._uBook.getSheetIndex(str3);
/* 298 */         i = this._iBook.checkExternSheet(j, k);
/*     */       } else {
/* 300 */         i = this._iBook.getExternalSheetIndex(str1, str2, str3);
/*     */       } 
/*     */     } 
/* 303 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public SpreadsheetVersion getSpreadsheetVersion() {
/* 308 */     return SpreadsheetVersion.EXCEL97;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Table getTable(String paramString) {
/* 316 */     throw new IllegalStateException("XSSF-style tables are not supported for HSSF");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFEvaluationWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */