/*      */ package org.apache.poi.xssf.usermodel;
/*      */ 
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import org.apache.poi.ss.SpreadsheetVersion;
/*      */ import org.apache.poi.ss.formula.FormulaParser;
/*      */ import org.apache.poi.ss.formula.FormulaRenderer;
/*      */ import org.apache.poi.ss.formula.FormulaType;
/*      */ import org.apache.poi.ss.formula.SharedFormula;
/*      */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*      */ import org.apache.poi.ss.formula.ptg.Ptg;
/*      */ import org.apache.poi.ss.usermodel.Cell;
/*      */ import org.apache.poi.ss.usermodel.CellCopyPolicy;
/*      */ import org.apache.poi.ss.usermodel.CellStyle;
/*      */ import org.apache.poi.ss.usermodel.CellType;
/*      */ import org.apache.poi.ss.usermodel.Comment;
/*      */ import org.apache.poi.ss.usermodel.DateUtil;
/*      */ import org.apache.poi.ss.usermodel.FormulaError;
/*      */ import org.apache.poi.ss.usermodel.Hyperlink;
/*      */ import org.apache.poi.ss.usermodel.RichTextString;
/*      */ import org.apache.poi.ss.usermodel.Row;
/*      */ import org.apache.poi.ss.usermodel.Sheet;
/*      */ import org.apache.poi.ss.util.CellAddress;
/*      */ import org.apache.poi.ss.util.CellRangeAddress;
/*      */ import org.apache.poi.ss.util.CellReference;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.LocaleUtil;
/*      */ import org.apache.poi.xssf.model.SharedStringsTable;
/*      */ import org.apache.poi.xssf.model.StylesTable;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class XSSFCell
/*      */   implements Cell
/*      */ {
/*      */   private static final String FALSE_AS_STRING = "0";
/*      */   private static final String TRUE_AS_STRING = "1";
/*      */   private static final String FALSE = "FALSE";
/*      */   private static final String TRUE = "TRUE";
/*      */   private CTCell _cell;
/*      */   private final XSSFRow _row;
/*      */   private int _cellNum;
/*      */   private SharedStringsTable _sharedStringSource;
/*      */   private StylesTable _stylesSource;
/*      */   
/*      */   protected XSSFCell(XSSFRow paramXSSFRow, CTCell paramCTCell) {
/*  111 */     this._cell = paramCTCell;
/*  112 */     this._row = paramXSSFRow;
/*  113 */     if (paramCTCell.getR() != null) {
/*  114 */       this._cellNum = (new CellReference(paramCTCell.getR())).getCol();
/*      */     } else {
/*  116 */       short s = paramXSSFRow.getLastCellNum();
/*  117 */       if (s != -1) {
/*  118 */         this._cellNum = paramXSSFRow.getCell(s - 1, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK).getColumnIndex() + 1;
/*      */       }
/*      */     } 
/*  121 */     this._sharedStringSource = paramXSSFRow.getSheet().getWorkbook().getSharedStringSource();
/*  122 */     this._stylesSource = paramXSSFRow.getSheet().getWorkbook().getStylesSource();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public void copyCellFrom(Cell paramCell, CellCopyPolicy paramCellCopyPolicy) {
/*  139 */     if (paramCellCopyPolicy.isCopyCellValue()) {
/*  140 */       if (paramCell != null) {
/*  141 */         CellType cellType = paramCell.getCellTypeEnum();
/*  142 */         if (cellType == CellType.FORMULA && !paramCellCopyPolicy.isCopyCellFormula())
/*      */         {
/*      */           
/*  145 */           cellType = paramCell.getCachedFormulaResultTypeEnum();
/*      */         }
/*  147 */         switch (cellType) {
/*      */           
/*      */           case NUMERIC:
/*  150 */             if (DateUtil.isCellDateFormatted(paramCell)) {
/*  151 */               setCellValue(paramCell.getDateCellValue());
/*      */               break;
/*      */             } 
/*  154 */             setCellValue(paramCell.getNumericCellValue());
/*      */             break;
/*      */           
/*      */           case STRING:
/*  158 */             setCellValue(paramCell.getStringCellValue());
/*      */             break;
/*      */           case FORMULA:
/*  161 */             setCellFormula(paramCell.getCellFormula());
/*      */             break;
/*      */           case BLANK:
/*  164 */             setBlank();
/*      */             break;
/*      */           case BOOLEAN:
/*  167 */             setCellValue(paramCell.getBooleanCellValue());
/*      */             break;
/*      */           case ERROR:
/*  170 */             setCellErrorValue(paramCell.getErrorCellValue());
/*      */             break;
/*      */           
/*      */           default:
/*  174 */             throw new IllegalArgumentException("Invalid cell type " + paramCell.getCellTypeEnum());
/*      */         } 
/*      */       } else {
/*  177 */         setBlank();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  182 */     if (paramCellCopyPolicy.isCopyCellStyle()) {
/*  183 */       if (paramCell != null) {
/*  184 */         setCellStyle(paramCell.getCellStyle());
/*      */       }
/*      */       else {
/*      */         
/*  188 */         setCellStyle(null);
/*      */       } 
/*      */     }
/*      */     
/*  192 */     if (paramCellCopyPolicy.isMergeHyperlink()) {
/*      */       
/*  194 */       Hyperlink hyperlink = paramCell.getHyperlink();
/*  195 */       if (hyperlink != null) {
/*  196 */         setHyperlink(new XSSFHyperlink(hyperlink));
/*      */       }
/*      */     }
/*  199 */     else if (paramCellCopyPolicy.isCopyHyperlink()) {
/*      */ 
/*      */       
/*  202 */       Hyperlink hyperlink = paramCell.getHyperlink();
/*  203 */       if (hyperlink == null) {
/*  204 */         setHyperlink(null);
/*      */       } else {
/*      */         
/*  207 */         setHyperlink(new XSSFHyperlink(hyperlink));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected SharedStringsTable getSharedStringSource() {
/*  216 */     return this._sharedStringSource;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected StylesTable getStylesSource() {
/*  223 */     return this._stylesSource;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFSheet getSheet() {
/*  233 */     return getRow().getSheet();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFRow getRow() {
/*  243 */     return this._row;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBooleanCellValue() {
/*  257 */     CellType cellType = getCellTypeEnum();
/*  258 */     switch (cellType) {
/*      */       case BLANK:
/*  260 */         return false;
/*      */       case BOOLEAN:
/*  262 */         return (this._cell.isSetV() && "1".equals(this._cell.getV()));
/*      */       
/*      */       case FORMULA:
/*  265 */         return (this._cell.isSetV() && "1".equals(this._cell.getV()));
/*      */     } 
/*  267 */     throw typeMismatch(CellType.BOOLEAN, cellType, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellValue(boolean paramBoolean) {
/*  280 */     this._cell.setT(STCellType.B);
/*  281 */     this._cell.setV(paramBoolean ? "1" : "0");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getNumericCellValue() {
/*  297 */     CellType cellType = getCellTypeEnum();
/*  298 */     switch (cellType) {
/*      */       case BLANK:
/*  300 */         return 0.0D;
/*      */       
/*      */       case NUMERIC:
/*      */       case FORMULA:
/*  304 */         if (this._cell.isSetV()) {
/*  305 */           String str = this._cell.getV();
/*  306 */           if (str.isEmpty()) return 0.0D; 
/*      */           try {
/*  308 */             return Double.parseDouble(str);
/*  309 */           } catch (NumberFormatException numberFormatException) {
/*  310 */             throw typeMismatch(CellType.NUMERIC, CellType.STRING, false);
/*      */           } 
/*      */         } 
/*  313 */         return 0.0D;
/*      */     } 
/*      */     
/*  316 */     throw typeMismatch(CellType.NUMERIC, cellType, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellValue(double paramDouble) {
/*  330 */     if (Double.isInfinite(paramDouble)) {
/*      */ 
/*      */       
/*  333 */       this._cell.setT(STCellType.E);
/*  334 */       this._cell.setV(FormulaError.DIV0.getString());
/*  335 */     } else if (Double.isNaN(paramDouble)) {
/*      */ 
/*      */       
/*  338 */       this._cell.setT(STCellType.E);
/*  339 */       this._cell.setV(FormulaError.NUM.getString());
/*      */     } else {
/*  341 */       this._cell.setT(STCellType.N);
/*  342 */       this._cell.setV(String.valueOf(paramDouble));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStringCellValue() {
/*  356 */     return getRichStringCellValue().getString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFRichTextString getRichStringCellValue() {
/*      */     XSSFRichTextString xSSFRichTextString;
/*  369 */     CellType cellType = getCellTypeEnum();
/*      */     
/*  371 */     switch (cellType) {
/*      */       case BLANK:
/*  373 */         xSSFRichTextString = new XSSFRichTextString("");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  406 */         xSSFRichTextString.setStylesTableReference(this._stylesSource);
/*  407 */         return xSSFRichTextString;case STRING: if (this._cell.getT() == STCellType.INLINE_STR) { if (this._cell.isSetIs()) { xSSFRichTextString = new XSSFRichTextString(this._cell.getIs()); } else if (this._cell.isSetV()) { xSSFRichTextString = new XSSFRichTextString(this._cell.getV()); } else { xSSFRichTextString = new XSSFRichTextString(""); }  } else if (this._cell.getT() == STCellType.STR) { xSSFRichTextString = new XSSFRichTextString(this._cell.isSetV() ? this._cell.getV() : ""); } else if (this._cell.isSetV()) { int i = Integer.parseInt(this._cell.getV()); xSSFRichTextString = new XSSFRichTextString(this._sharedStringSource.getEntryAt(i)); } else { xSSFRichTextString = new XSSFRichTextString(""); }  xSSFRichTextString.setStylesTableReference(this._stylesSource); return xSSFRichTextString;case FORMULA: checkFormulaCachedValueType(CellType.STRING, getBaseCellType(false)); xSSFRichTextString = new XSSFRichTextString(this._cell.isSetV() ? this._cell.getV() : ""); xSSFRichTextString.setStylesTableReference(this._stylesSource); return xSSFRichTextString;
/*      */     } 
/*      */     throw typeMismatch(CellType.STRING, cellType, false);
/*      */   } private static void checkFormulaCachedValueType(CellType paramCellType1, CellType paramCellType2) {
/*  411 */     if (paramCellType2 != paramCellType1) {
/*  412 */       throw typeMismatch(paramCellType1, paramCellType2, true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellValue(String paramString) {
/*  426 */     setCellValue((paramString == null) ? null : new XSSFRichTextString(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellValue(RichTextString paramRichTextString) {
/*  439 */     if (paramRichTextString == null || paramRichTextString.getString() == null) {
/*  440 */       setCellType(CellType.BLANK);
/*      */       
/*      */       return;
/*      */     } 
/*  444 */     if (paramRichTextString.length() > SpreadsheetVersion.EXCEL2007.getMaxTextLength()) {
/*  445 */       throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
/*      */     }
/*      */     
/*  448 */     CellType cellType = getCellTypeEnum();
/*  449 */     switch (cellType) {
/*      */       case FORMULA:
/*  451 */         this._cell.setV(paramRichTextString.getString());
/*  452 */         this._cell.setT(STCellType.STR);
/*      */         return;
/*      */     } 
/*  455 */     if (this._cell.getT() == STCellType.INLINE_STR) {
/*      */       
/*  457 */       this._cell.setV(paramRichTextString.getString());
/*      */     } else {
/*  459 */       this._cell.setT(STCellType.S);
/*  460 */       XSSFRichTextString xSSFRichTextString = (XSSFRichTextString)paramRichTextString;
/*  461 */       xSSFRichTextString.setStylesTableReference(this._stylesSource);
/*  462 */       int i = this._sharedStringSource.addEntry(xSSFRichTextString.getCTRst());
/*  463 */       this._cell.setV(Integer.toString(i));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCellFormula() {
/*  478 */     return getCellFormula(null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getCellFormula(XSSFEvaluationWorkbook paramXSSFEvaluationWorkbook) {
/*  489 */     CellType cellType = getCellTypeEnum();
/*  490 */     if (cellType != CellType.FORMULA) throw typeMismatch(CellType.FORMULA, cellType, false);
/*      */     
/*  492 */     CTCellFormula cTCellFormula = this._cell.getF();
/*  493 */     if (isPartOfArrayFormulaGroup() && cTCellFormula == null) {
/*  494 */       XSSFCell xSSFCell = getSheet().getFirstCellInArrayFormula(this);
/*  495 */       return xSSFCell.getCellFormula(paramXSSFEvaluationWorkbook);
/*      */     } 
/*  497 */     if (cTCellFormula.getT() == STCellFormulaType.SHARED) {
/*  498 */       return convertSharedFormula((int)cTCellFormula.getSi(), (paramXSSFEvaluationWorkbook == null) ? XSSFEvaluationWorkbook.create(getSheet().getWorkbook()) : paramXSSFEvaluationWorkbook);
/*      */     }
/*  500 */     return cTCellFormula.getStringValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String convertSharedFormula(int paramInt, XSSFEvaluationWorkbook paramXSSFEvaluationWorkbook) {
/*  510 */     XSSFSheet xSSFSheet = getSheet();
/*      */     
/*  512 */     CTCellFormula cTCellFormula = xSSFSheet.getSharedFormula(paramInt);
/*  513 */     if (cTCellFormula == null) throw new IllegalStateException("Master cell of a shared formula with sid=" + paramInt + " was not found");
/*      */ 
/*      */     
/*  516 */     String str1 = cTCellFormula.getStringValue();
/*      */     
/*  518 */     String str2 = cTCellFormula.getRef();
/*      */     
/*  520 */     CellRangeAddress cellRangeAddress = CellRangeAddress.valueOf(str2);
/*      */     
/*  522 */     int i = xSSFSheet.getWorkbook().getSheetIndex(xSSFSheet);
/*  523 */     SharedFormula sharedFormula = new SharedFormula(SpreadsheetVersion.EXCEL2007);
/*      */     
/*  525 */     Ptg[] arrayOfPtg1 = FormulaParser.parse(str1, paramXSSFEvaluationWorkbook, FormulaType.CELL, i, getRowIndex());
/*  526 */     Ptg[] arrayOfPtg2 = sharedFormula.convertSharedFormulas(arrayOfPtg1, getRowIndex() - cellRangeAddress.getFirstRow(), getColumnIndex() - cellRangeAddress.getFirstColumn());
/*      */     
/*  528 */     return FormulaRenderer.toFormulaString(paramXSSFEvaluationWorkbook, arrayOfPtg2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellFormula(String paramString) {
/*  546 */     if (isPartOfArrayFormulaGroup()) {
/*  547 */       notifyArrayFormulaChanging();
/*      */     }
/*  549 */     setFormula(paramString, FormulaType.CELL);
/*      */   }
/*      */   
/*      */   void setCellArrayFormula(String paramString, CellRangeAddress paramCellRangeAddress) {
/*  553 */     setFormula(paramString, FormulaType.ARRAY);
/*  554 */     CTCellFormula cTCellFormula = this._cell.getF();
/*  555 */     cTCellFormula.setT(STCellFormulaType.ARRAY);
/*  556 */     cTCellFormula.setRef(paramCellRangeAddress.formatAsString());
/*      */   }
/*      */   
/*      */   private void setFormula(String paramString, FormulaType paramFormulaType) {
/*  560 */     XSSFWorkbook xSSFWorkbook = this._row.getSheet().getWorkbook();
/*  561 */     if (paramString == null) {
/*  562 */       xSSFWorkbook.onDeleteFormula(this);
/*  563 */       if (this._cell.isSetF()) this._cell.unsetF();
/*      */       
/*      */       return;
/*      */     } 
/*  567 */     XSSFEvaluationWorkbook xSSFEvaluationWorkbook = XSSFEvaluationWorkbook.create(xSSFWorkbook);
/*      */     
/*  569 */     FormulaParser.parse(paramString, xSSFEvaluationWorkbook, paramFormulaType, xSSFWorkbook.getSheetIndex(getSheet()), getRowIndex());
/*      */     
/*  571 */     CTCellFormula cTCellFormula = CTCellFormula.Factory.newInstance();
/*  572 */     cTCellFormula.setStringValue(paramString);
/*  573 */     this._cell.setF(cTCellFormula);
/*  574 */     if (this._cell.isSetV()) this._cell.unsetV();
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getColumnIndex() {
/*  584 */     return this._cellNum;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRowIndex() {
/*  594 */     return this._row.getRowNum();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getReference() {
/*  603 */     String str = this._cell.getR();
/*  604 */     if (str == null) {
/*  605 */       return getAddress().formatAsString();
/*      */     }
/*  607 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CellAddress getAddress() {
/*  615 */     return new CellAddress(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFCellStyle getCellStyle() {
/*  625 */     XSSFCellStyle xSSFCellStyle = null;
/*  626 */     if (this._stylesSource.getNumCellStyles() > 0) {
/*  627 */       long l = this._cell.isSetS() ? this._cell.getS() : 0L;
/*  628 */       xSSFCellStyle = this._stylesSource.getStyleAt((int)l);
/*      */     } 
/*  630 */     return xSSFCellStyle;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellStyle(CellStyle paramCellStyle) {
/*  646 */     if (paramCellStyle == null) {
/*  647 */       if (this._cell.isSetS()) this._cell.unsetS(); 
/*      */     } else {
/*  649 */       XSSFCellStyle xSSFCellStyle = (XSSFCellStyle)paramCellStyle;
/*  650 */       xSSFCellStyle.verifyBelongsToStylesSource(this._stylesSource);
/*      */       
/*  652 */       long l = this._stylesSource.putStyle(xSSFCellStyle);
/*  653 */       this._cell.setS(l);
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean isFormulaCell() {
/*  658 */     if (this._cell.getF() != null || getSheet().isCellInArrayFormulaContext(this)) {
/*  659 */       return true;
/*      */     }
/*  661 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCellType() {
/*  675 */     return getCellTypeEnum().getCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal(since = "POI 3.15 beta 3")
/*      */   public CellType getCellTypeEnum() {
/*  689 */     if (isFormulaCell()) return CellType.FORMULA;
/*      */     
/*  691 */     return getBaseCellType(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCachedFormulaResultType() {
/*  707 */     return getCachedFormulaResultTypeEnum().getCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CellType getCachedFormulaResultTypeEnum() {
/*  721 */     if (!isFormulaCell()) {
/*  722 */       throw new IllegalStateException("Only formula cells have cached results");
/*      */     }
/*      */     
/*  725 */     return getBaseCellType(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CellType getBaseCellType(boolean paramBoolean) {
/*  732 */     switch (this._cell.getT().intValue()) {
/*      */       case 1:
/*  734 */         return CellType.BOOLEAN;
/*      */       case 2:
/*  736 */         if (!this._cell.isSetV() && paramBoolean)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  742 */           return CellType.BLANK;
/*      */         }
/*  744 */         return CellType.NUMERIC;
/*      */       case 3:
/*  746 */         return CellType.ERROR;
/*      */       case 4:
/*      */       case 5:
/*      */       case 6:
/*  750 */         return CellType.STRING;
/*      */     } 
/*  752 */     throw new IllegalStateException("Illegal cell type: " + this._cell.getT());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDateCellValue() {
/*  768 */     if (getCellTypeEnum() == CellType.BLANK) {
/*  769 */       return null;
/*      */     }
/*      */     
/*  772 */     double d = getNumericCellValue();
/*  773 */     boolean bool = getSheet().getWorkbook().isDate1904();
/*  774 */     return DateUtil.getJavaDate(d, bool);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellValue(Date paramDate) {
/*  787 */     if (paramDate == null) {
/*  788 */       setCellType(CellType.BLANK);
/*      */       
/*      */       return;
/*      */     } 
/*  792 */     boolean bool = getSheet().getWorkbook().isDate1904();
/*  793 */     setCellValue(DateUtil.getExcelDate(paramDate, bool));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellValue(Calendar paramCalendar) {
/*  814 */     if (paramCalendar == null) {
/*  815 */       setCellType(CellType.BLANK);
/*      */       
/*      */       return;
/*      */     } 
/*  819 */     boolean bool = getSheet().getWorkbook().isDate1904();
/*  820 */     setCellValue(DateUtil.getExcelDate(paramCalendar, bool));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getErrorCellString() throws IllegalStateException {
/*  831 */     CellType cellType = getBaseCellType(true);
/*  832 */     if (cellType != CellType.ERROR) throw typeMismatch(CellType.ERROR, cellType, false);
/*      */     
/*  834 */     return this._cell.getV();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte getErrorCellValue() throws IllegalStateException {
/*  849 */     String str = getErrorCellString();
/*  850 */     if (str == null) {
/*  851 */       return 0;
/*      */     }
/*      */     try {
/*  854 */       return FormulaError.forString(str).getCode();
/*  855 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  856 */       throw new IllegalStateException("Unexpected error code", illegalArgumentException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellErrorValue(byte paramByte) {
/*  871 */     FormulaError formulaError = FormulaError.forInt(paramByte);
/*  872 */     setCellErrorValue(formulaError);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellErrorValue(FormulaError paramFormulaError) {
/*  884 */     this._cell.setT(STCellType.E);
/*  885 */     this._cell.setV(paramFormulaError.getString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAsActiveCell() {
/*  893 */     getSheet().setActiveCell(getAddress());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void setBlank() {
/*  901 */     CTCell cTCell = CTCell.Factory.newInstance();
/*  902 */     cTCell.setR(this._cell.getR());
/*  903 */     if (this._cell.isSetS()) cTCell.setS(this._cell.getS()); 
/*  904 */     this._cell.set((XmlObject)cTCell);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setCellNum(int paramInt) {
/*  913 */     checkBounds(paramInt);
/*  914 */     this._cellNum = paramInt;
/*  915 */     String str = (new CellReference(getRowIndex(), getColumnIndex())).formatAsString();
/*  916 */     this._cell.setR(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellType(int paramInt) {
/*  933 */     setCellType(CellType.forInt(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellType(CellType paramCellType) {
/*      */     String str;
/*  942 */     CellType cellType = getCellTypeEnum();
/*      */     
/*  944 */     if (isPartOfArrayFormulaGroup()) {
/*  945 */       notifyArrayFormulaChanging();
/*      */     }
/*  947 */     if (cellType == CellType.FORMULA && paramCellType != CellType.FORMULA) {
/*  948 */       getSheet().getWorkbook().onDeleteFormula(this);
/*      */     }
/*      */     
/*  951 */     switch (paramCellType) {
/*      */       case NUMERIC:
/*  953 */         this._cell.setT(STCellType.N);
/*      */         break;
/*      */       case STRING:
/*  956 */         if (cellType != CellType.STRING) {
/*  957 */           String str1 = convertCellValueToString();
/*  958 */           XSSFRichTextString xSSFRichTextString = new XSSFRichTextString(str1);
/*  959 */           xSSFRichTextString.setStylesTableReference(this._stylesSource);
/*  960 */           int i = this._sharedStringSource.addEntry(xSSFRichTextString.getCTRst());
/*  961 */           this._cell.setV(Integer.toString(i));
/*      */         } 
/*  963 */         this._cell.setT(STCellType.S);
/*      */         break;
/*      */       case FORMULA:
/*  966 */         if (!this._cell.isSetF()) {
/*  967 */           CTCellFormula cTCellFormula = CTCellFormula.Factory.newInstance();
/*  968 */           cTCellFormula.setStringValue("0");
/*  969 */           this._cell.setF(cTCellFormula);
/*  970 */           if (this._cell.isSetT()) this._cell.unsetT(); 
/*      */         } 
/*      */         break;
/*      */       case BLANK:
/*  974 */         setBlank();
/*      */         break;
/*      */       case BOOLEAN:
/*  977 */         str = convertCellValueToBoolean() ? "1" : "0";
/*  978 */         this._cell.setT(STCellType.B);
/*  979 */         this._cell.setV(str);
/*      */         break;
/*      */       
/*      */       case ERROR:
/*  983 */         this._cell.setT(STCellType.E);
/*      */         break;
/*      */ 
/*      */       
/*      */       default:
/*  988 */         throw new IllegalArgumentException("Illegal cell type: " + paramCellType);
/*      */     } 
/*  990 */     if (paramCellType != CellType.FORMULA && this._cell.isSetF()) {
/*  991 */       this._cell.unsetF();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1005 */     switch (getCellTypeEnum()) {
/*      */       case NUMERIC:
/* 1007 */         if (DateUtil.isCellDateFormatted(this)) {
/* 1008 */           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
/* 1009 */           simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
/* 1010 */           return simpleDateFormat.format(getDateCellValue());
/*      */         } 
/* 1012 */         return Double.toString(getNumericCellValue());
/*      */       case STRING:
/* 1014 */         return getRichStringCellValue().toString();
/*      */       case FORMULA:
/* 1016 */         return getCellFormula();
/*      */       case BLANK:
/* 1018 */         return "";
/*      */       case BOOLEAN:
/* 1020 */         return getBooleanCellValue() ? "TRUE" : "FALSE";
/*      */       case ERROR:
/* 1022 */         return ErrorEval.getText(getErrorCellValue());
/*      */     } 
/* 1024 */     return "Unknown Cell Type: " + getCellTypeEnum();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getRawValue() {
/* 1041 */     return this._cell.getV();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static RuntimeException typeMismatch(CellType paramCellType1, CellType paramCellType2, boolean paramBoolean) {
/* 1049 */     String str = "Cannot get a " + paramCellType1 + " value from a " + paramCellType2 + " " + (paramBoolean ? "formula " : "") + "cell";
/* 1050 */     return new IllegalStateException(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkBounds(int paramInt) {
/* 1057 */     SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL2007;
/* 1058 */     int i = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
/* 1059 */     if (paramInt < 0 || paramInt > i) {
/* 1060 */       throw new IllegalArgumentException("Invalid column index (" + paramInt + ").  Allowable column range for " + spreadsheetVersion.name() + " is (0.." + i + ") or ('A'..'" + spreadsheetVersion.getLastColumnName() + "')");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFComment getCellComment() {
/* 1073 */     return getSheet().getCellComment(new CellAddress(this));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellComment(Comment paramComment) {
/* 1084 */     if (paramComment == null) {
/* 1085 */       removeCellComment();
/*      */       
/*      */       return;
/*      */     } 
/* 1089 */     paramComment.setAddress(getRowIndex(), getColumnIndex());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeCellComment() {
/* 1097 */     XSSFComment xSSFComment = getCellComment();
/* 1098 */     if (xSSFComment != null) {
/* 1099 */       CellAddress cellAddress = new CellAddress(getReference());
/* 1100 */       XSSFSheet xSSFSheet = getSheet();
/* 1101 */       xSSFSheet.getCommentsTable(false).removeComment(cellAddress);
/* 1102 */       xSSFSheet.getVMLDrawing(false).removeCommentShape(getRowIndex(), getColumnIndex());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFHyperlink getHyperlink() {
/* 1113 */     return getSheet().getHyperlink(this._row.getRowNum(), this._cellNum);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHyperlink(Hyperlink paramHyperlink) {
/* 1124 */     if (paramHyperlink == null) {
/* 1125 */       removeHyperlink();
/*      */       
/*      */       return;
/*      */     } 
/* 1129 */     XSSFHyperlink xSSFHyperlink = (XSSFHyperlink)paramHyperlink;
/*      */ 
/*      */     
/* 1132 */     xSSFHyperlink.setCellReference((new CellReference(this._row.getRowNum(), this._cellNum)).formatAsString());
/*      */ 
/*      */     
/* 1135 */     getSheet().addHyperlink(xSSFHyperlink);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeHyperlink() {
/* 1143 */     getSheet().removeHyperlink(this._row.getRowNum(), this._cellNum);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public CTCell getCTCell() {
/* 1154 */     return this._cell;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public void setCTCell(CTCell paramCTCell) {
/* 1164 */     this._cell = paramCTCell;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean convertCellValueToBoolean() {
/*      */     int i;
/*      */     XSSFRichTextString xSSFRichTextString;
/*      */     String str;
/* 1176 */     CellType cellType = getCellTypeEnum();
/*      */     
/* 1178 */     if (cellType == CellType.FORMULA) {
/* 1179 */       cellType = getBaseCellType(false);
/*      */     }
/*      */     
/* 1182 */     switch (cellType) {
/*      */       case BOOLEAN:
/* 1184 */         return "1".equals(this._cell.getV());
/*      */       case STRING:
/* 1186 */         i = Integer.parseInt(this._cell.getV());
/* 1187 */         xSSFRichTextString = new XSSFRichTextString(this._sharedStringSource.getEntryAt(i));
/* 1188 */         str = xSSFRichTextString.getString();
/* 1189 */         return Boolean.parseBoolean(str);
/*      */       case NUMERIC:
/* 1191 */         return (Double.parseDouble(this._cell.getV()) != 0.0D);
/*      */ 
/*      */       
/*      */       case BLANK:
/*      */       case ERROR:
/* 1196 */         return false;
/*      */     } 
/*      */     
/* 1199 */     throw new RuntimeException("Unexpected cell type (" + cellType + ")");
/*      */   }
/*      */   private String convertCellValueToString() {
/*      */     int i;
/*      */     XSSFRichTextString xSSFRichTextString;
/* 1204 */     CellType cellType = getCellTypeEnum();
/*      */     
/* 1206 */     switch (cellType) {
/*      */       case BLANK:
/* 1208 */         return "";
/*      */       case BOOLEAN:
/* 1210 */         return "1".equals(this._cell.getV()) ? "TRUE" : "FALSE";
/*      */       case STRING:
/* 1212 */         i = Integer.parseInt(this._cell.getV());
/* 1213 */         xSSFRichTextString = new XSSFRichTextString(this._sharedStringSource.getEntryAt(i));
/* 1214 */         return xSSFRichTextString.getString();
/*      */       case NUMERIC:
/*      */       case ERROR:
/* 1217 */         return this._cell.getV();
/*      */       
/*      */       case FORMULA:
/*      */         break;
/*      */       
/*      */       default:
/* 1223 */         throw new IllegalStateException("Unexpected cell type (" + cellType + ")");
/*      */     } 
/* 1225 */     cellType = getBaseCellType(false);
/* 1226 */     String str = this._cell.getV();
/* 1227 */     switch (cellType) {
/*      */       case BOOLEAN:
/* 1229 */         if ("1".equals(str)) {
/* 1230 */           return "TRUE";
/*      */         }
/* 1232 */         if ("0".equals(str)) {
/* 1233 */           return "FALSE";
/*      */         }
/* 1235 */         throw new IllegalStateException("Unexpected boolean cached formula value '" + str + "'.");
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case NUMERIC:
/*      */       case STRING:
/*      */       case ERROR:
/* 1243 */         return str;
/*      */     } 
/*      */     
/* 1246 */     throw new IllegalStateException("Unexpected formula result type (" + cellType + ")");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CellRangeAddress getArrayFormulaRange() {
/* 1253 */     XSSFCell xSSFCell = getSheet().getFirstCellInArrayFormula(this);
/* 1254 */     if (xSSFCell == null) {
/* 1255 */       throw new IllegalStateException("Cell " + getReference() + " is not part of an array formula.");
/*      */     }
/*      */     
/* 1258 */     String str = xSSFCell._cell.getF().getRef();
/* 1259 */     return CellRangeAddress.valueOf(str);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isPartOfArrayFormulaGroup() {
/* 1264 */     return getSheet().isCellInArrayFormulaContext(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void notifyArrayFormulaChanging(String paramString) {
/* 1273 */     if (isPartOfArrayFormulaGroup()) {
/* 1274 */       CellRangeAddress cellRangeAddress = getArrayFormulaRange();
/* 1275 */       if (cellRangeAddress.getNumberOfCells() > 1) {
/* 1276 */         throw new IllegalStateException(paramString);
/*      */       }
/*      */       
/* 1279 */       getRow().getSheet().removeArrayFormula(this);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void notifyArrayFormulaChanging() {
/* 1298 */     CellReference cellReference = new CellReference(this);
/* 1299 */     String str = "Cell " + cellReference.formatAsString() + " is part of a multi-cell array formula. " + "You cannot change part of an array.";
/*      */     
/* 1301 */     notifyArrayFormulaChanging(str);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */