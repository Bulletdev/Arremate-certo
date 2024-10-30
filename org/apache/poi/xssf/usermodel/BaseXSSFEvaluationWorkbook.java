/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.formula.EvaluationName;
/*     */ import org.apache.poi.ss.formula.EvaluationWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaParser;
/*     */ import org.apache.poi.ss.formula.FormulaParsingWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaType;
/*     */ import org.apache.poi.ss.formula.SheetIdentifier;
/*     */ import org.apache.poi.ss.formula.functions.FreeRefFunction;
/*     */ import org.apache.poi.ss.formula.ptg.Area3DPxg;
/*     */ import org.apache.poi.ss.formula.ptg.NamePtg;
/*     */ import org.apache.poi.ss.formula.ptg.NameXPtg;
/*     */ import org.apache.poi.ss.formula.ptg.NameXPxg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.ptg.Ref3DPxg;
/*     */ import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
/*     */ import org.apache.poi.ss.formula.udf.UDFFinder;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.usermodel.Table;
/*     */ import org.apache.poi.ss.util.AreaReference;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.NotImplemented;
/*     */ import org.apache.poi.xssf.model.ExternalLinksTable;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
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
/*     */ public abstract class BaseXSSFEvaluationWorkbook
/*     */   implements EvaluationWorkbook, FormulaParsingWorkbook, FormulaRenderingWorkbook
/*     */ {
/*     */   protected final XSSFWorkbook _uBook;
/*  59 */   private Map<String, XSSFTable> _tableCache = null;
/*     */ 
/*     */   
/*     */   protected BaseXSSFEvaluationWorkbook(XSSFWorkbook paramXSSFWorkbook) {
/*  63 */     this._uBook = paramXSSFWorkbook;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearAllCachedResultValues() {
/*  71 */     this._tableCache = null;
/*     */   }
/*     */   
/*     */   private int convertFromExternalSheetIndex(int paramInt) {
/*  75 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int convertFromExternSheetIndex(int paramInt) {
/*  83 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int convertToExternalSheetIndex(int paramInt) {
/*  92 */     return paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getExternalSheetIndex(String paramString) {
/*  97 */     int i = this._uBook.getSheetIndex(paramString);
/*  98 */     return convertToExternalSheetIndex(i);
/*     */   }
/*     */ 
/*     */   
/*     */   private int resolveBookIndex(String paramString) {
/* 103 */     if (paramString.startsWith("[") && paramString.endsWith("]")) {
/* 104 */       paramString = paramString.substring(1, paramString.length() - 2);
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 109 */       return Integer.parseInt(paramString);
/* 110 */     } catch (NumberFormatException numberFormatException) {
/*     */ 
/*     */       
/* 113 */       List<ExternalLinksTable> list = this._uBook.getExternalLinksTable();
/* 114 */       int i = findExternalLinkIndex(paramString, list);
/* 115 */       if (i != -1) return i;
/*     */ 
/*     */       
/* 118 */       if (paramString.startsWith("'file:///") && paramString.endsWith("'")) {
/* 119 */         String str = paramString.substring(paramString.lastIndexOf('/') + 1);
/* 120 */         str = str.substring(0, str.length() - 1);
/*     */ 
/*     */         
/* 123 */         i = findExternalLinkIndex(str, list);
/* 124 */         if (i != -1) return i;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 129 */         FakeExternalLinksTable fakeExternalLinksTable = new FakeExternalLinksTable(str);
/* 130 */         list.add(fakeExternalLinksTable);
/* 131 */         return list.size();
/*     */       } 
/*     */ 
/*     */       
/* 135 */       throw new RuntimeException("Book not linked for filename " + paramString);
/*     */     } 
/*     */   }
/*     */   private int findExternalLinkIndex(String paramString, List<ExternalLinksTable> paramList) {
/* 139 */     byte b = 0;
/* 140 */     for (ExternalLinksTable externalLinksTable : paramList) {
/* 141 */       if (externalLinksTable.getLinkedFileName().equals(paramString)) {
/* 142 */         return b + 1;
/*     */       }
/* 144 */       b++;
/*     */     } 
/* 146 */     return -1;
/*     */   }
/*     */   
/*     */   private static class FakeExternalLinksTable extends ExternalLinksTable {
/*     */     private FakeExternalLinksTable(String param1String) {
/* 151 */       this.fileName = param1String;
/*     */     }
/*     */     private final String fileName;
/*     */     public String getLinkedFileName() {
/* 155 */       return this.fileName;
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
/*     */   public EvaluationName getName(String paramString, int paramInt) {
/* 170 */     for (byte b = 0; b < this._uBook.getNumberOfNames(); b++) {
/* 171 */       XSSFName xSSFName = this._uBook.getNameAt(b);
/* 172 */       String str = xSSFName.getNameName();
/* 173 */       int i = xSSFName.getSheetIndex();
/* 174 */       if (paramString.equalsIgnoreCase(str) && (i == -1 || i == paramInt))
/*     */       {
/* 176 */         return new Name(xSSFName, b, this);
/*     */       }
/*     */     } 
/* 179 */     return (paramInt == -1) ? null : getName(paramString, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSheetName(int paramInt) {
/* 184 */     return this._uBook.getSheetName(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public EvaluationWorkbook.ExternalName getExternalName(int paramInt1, int paramInt2) {
/* 189 */     throw new IllegalStateException("HSSF-style external references are not supported for XSSF");
/*     */   }
/*     */ 
/*     */   
/*     */   public EvaluationWorkbook.ExternalName getExternalName(String paramString1, String paramString2, int paramInt) {
/* 194 */     if (paramInt > 0) {
/*     */       
/* 196 */       int j = paramInt - 1;
/* 197 */       ExternalLinksTable externalLinksTable = this._uBook.getExternalLinksTable().get(j);
/*     */       
/* 199 */       for (org.apache.poi.ss.usermodel.Name name : externalLinksTable.getDefinedNames()) {
/* 200 */         if (name.getNameName().equals(paramString1)) {
/*     */ 
/*     */           
/* 203 */           int k = name.getSheetIndex() + 1;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 208 */           return new EvaluationWorkbook.ExternalName(paramString1, -1, k);
/*     */         } 
/*     */       } 
/* 211 */       throw new IllegalArgumentException("Name '" + paramString1 + "' not found in " + "reference to " + externalLinksTable.getLinkedFileName());
/*     */     } 
/*     */ 
/*     */     
/* 215 */     int i = this._uBook.getNameIndex(paramString1);
/* 216 */     return new EvaluationWorkbook.ExternalName(paramString1, i, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameXPxg getNameXPtg(String paramString, SheetIdentifier paramSheetIdentifier) {
/* 227 */     IndexedUDFFinder indexedUDFFinder = (IndexedUDFFinder)getUDFFinder();
/* 228 */     FreeRefFunction freeRefFunction = indexedUDFFinder.findFunction(paramString);
/* 229 */     if (freeRefFunction != null) {
/* 230 */       return new NameXPxg(null, paramString);
/*     */     }
/*     */ 
/*     */     
/* 234 */     if (paramSheetIdentifier == null) {
/* 235 */       if (!this._uBook.getNames(paramString).isEmpty()) {
/* 236 */         return new NameXPxg(null, paramString);
/*     */       }
/* 238 */       return null;
/*     */     } 
/* 240 */     if (paramSheetIdentifier._sheetIdentifier == null) {
/*     */       
/* 242 */       int i = resolveBookIndex(paramSheetIdentifier._bookName);
/* 243 */       return new NameXPxg(i, null, paramString);
/*     */     } 
/*     */ 
/*     */     
/* 247 */     String str = paramSheetIdentifier._sheetIdentifier.getName();
/*     */     
/* 249 */     if (paramSheetIdentifier._bookName != null) {
/* 250 */       int i = resolveBookIndex(paramSheetIdentifier._bookName);
/* 251 */       return new NameXPxg(i, str, paramString);
/*     */     } 
/* 253 */     return new NameXPxg(str, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Ptg get3DReferencePtg(CellReference paramCellReference, SheetIdentifier paramSheetIdentifier) {
/* 258 */     if (paramSheetIdentifier._bookName != null) {
/* 259 */       int i = resolveBookIndex(paramSheetIdentifier._bookName);
/* 260 */       return (Ptg)new Ref3DPxg(i, paramSheetIdentifier, paramCellReference);
/*     */     } 
/* 262 */     return (Ptg)new Ref3DPxg(paramSheetIdentifier, paramCellReference);
/*     */   }
/*     */ 
/*     */   
/*     */   public Ptg get3DReferencePtg(AreaReference paramAreaReference, SheetIdentifier paramSheetIdentifier) {
/* 267 */     if (paramSheetIdentifier._bookName != null) {
/* 268 */       int i = resolveBookIndex(paramSheetIdentifier._bookName);
/* 269 */       return (Ptg)new Area3DPxg(i, paramSheetIdentifier, paramAreaReference);
/*     */     } 
/* 271 */     return (Ptg)new Area3DPxg(paramSheetIdentifier, paramAreaReference);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String resolveNameXText(NameXPtg paramNameXPtg) {
/* 277 */     int i = paramNameXPtg.getNameIndex();
/* 278 */     String str = null;
/*     */ 
/*     */     
/* 281 */     IndexedUDFFinder indexedUDFFinder = (IndexedUDFFinder)getUDFFinder();
/* 282 */     str = indexedUDFFinder.getFunctionName(i);
/* 283 */     if (str != null) return str;
/*     */ 
/*     */     
/* 286 */     XSSFName xSSFName = this._uBook.getNameAt(i);
/* 287 */     if (xSSFName != null) {
/* 288 */       str = xSSFName.getNameName();
/*     */     }
/*     */     
/* 291 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public EvaluationWorkbook.ExternalSheet getExternalSheet(int paramInt) {
/* 296 */     throw new IllegalStateException("HSSF-style external references are not supported for XSSF");
/*     */   }
/*     */   
/*     */   public EvaluationWorkbook.ExternalSheet getExternalSheet(String paramString1, String paramString2, int paramInt) {
/*     */     String str;
/* 301 */     if (paramInt > 0) {
/*     */       
/* 303 */       int i = paramInt - 1;
/* 304 */       ExternalLinksTable externalLinksTable = this._uBook.getExternalLinksTable().get(i);
/* 305 */       str = externalLinksTable.getLinkedFileName();
/*     */     } else {
/*     */       
/* 308 */       str = null;
/*     */     } 
/*     */     
/* 311 */     if (paramString2 == null || paramString1.equals(paramString2)) {
/* 312 */       return new EvaluationWorkbook.ExternalSheet(str, paramString1);
/*     */     }
/* 314 */     return (EvaluationWorkbook.ExternalSheet)new EvaluationWorkbook.ExternalSheetRange(str, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   @NotImplemented
/*     */   public int getExternalSheetIndex(String paramString1, String paramString2) {
/* 320 */     throw new RuntimeException("not implemented yet");
/*     */   }
/*     */   
/*     */   public int getSheetIndex(String paramString) {
/* 324 */     return this._uBook.getSheetIndex(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSheetFirstNameByExternSheet(int paramInt) {
/* 329 */     int i = convertFromExternalSheetIndex(paramInt);
/* 330 */     return this._uBook.getSheetName(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSheetLastNameByExternSheet(int paramInt) {
/* 335 */     return getSheetFirstNameByExternSheet(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getNameText(NamePtg paramNamePtg) {
/* 340 */     return this._uBook.getNameAt(paramNamePtg.getIndex()).getNameName();
/*     */   }
/*     */   
/*     */   public EvaluationName getName(NamePtg paramNamePtg) {
/* 344 */     int i = paramNamePtg.getIndex();
/* 345 */     return new Name(this._uBook.getNameAt(i), i, this);
/*     */   }
/*     */   
/*     */   public XSSFName createName() {
/* 349 */     return this._uBook.createName();
/*     */   }
/*     */   
/*     */   private static String caseInsensitive(String paramString) {
/* 353 */     return paramString.toUpperCase(Locale.ROOT);
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
/*     */   private Map<String, XSSFTable> getTableCache() {
/* 368 */     if (this._tableCache != null) {
/* 369 */       return this._tableCache;
/*     */     }
/*     */     
/* 372 */     this._tableCache = new HashMap<String, XSSFTable>();
/*     */     
/* 374 */     for (Sheet sheet : this._uBook) {
/* 375 */       for (XSSFTable xSSFTable : ((XSSFSheet)sheet).getTables()) {
/* 376 */         String str = caseInsensitive(xSSFTable.getName());
/* 377 */         this._tableCache.put(str, xSSFTable);
/*     */       } 
/*     */     } 
/* 380 */     return this._tableCache;
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
/*     */   public XSSFTable getTable(String paramString) {
/* 395 */     if (paramString == null) return null; 
/* 396 */     String str = caseInsensitive(paramString);
/* 397 */     return getTableCache().get(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public UDFFinder getUDFFinder() {
/* 402 */     return this._uBook.getUDFFinder();
/*     */   }
/*     */ 
/*     */   
/*     */   public SpreadsheetVersion getSpreadsheetVersion() {
/* 407 */     return SpreadsheetVersion.EXCEL2007;
/*     */   }
/*     */   
/*     */   private static final class Name
/*     */     implements EvaluationName {
/*     */     private final XSSFName _nameRecord;
/*     */     private final int _index;
/*     */     private final FormulaParsingWorkbook _fpBook;
/*     */     
/*     */     public Name(XSSFName param1XSSFName, int param1Int, FormulaParsingWorkbook param1FormulaParsingWorkbook) {
/* 417 */       this._nameRecord = param1XSSFName;
/* 418 */       this._index = param1Int;
/* 419 */       this._fpBook = param1FormulaParsingWorkbook;
/*     */     }
/*     */ 
/*     */     
/*     */     public Ptg[] getNameDefinition() {
/* 424 */       return FormulaParser.parse(this._nameRecord.getRefersToFormula(), this._fpBook, FormulaType.NAMEDRANGE, this._nameRecord.getSheetIndex());
/*     */     }
/*     */     
/*     */     public String getNameText() {
/* 428 */       return this._nameRecord.getNameName();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasFormula() {
/* 433 */       CTDefinedName cTDefinedName = this._nameRecord.getCTName();
/* 434 */       String str = cTDefinedName.getStringValue();
/* 435 */       return (!cTDefinedName.getFunction() && str != null && str.length() > 0);
/*     */     }
/*     */     
/*     */     public boolean isFunctionName() {
/* 439 */       return this._nameRecord.isFunctionName();
/*     */     }
/*     */     
/*     */     public boolean isRange() {
/* 443 */       return hasFormula();
/*     */     }
/*     */     public NamePtg createPtg() {
/* 446 */       return new NamePtg(this._index);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\BaseXSSFEvaluationWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */