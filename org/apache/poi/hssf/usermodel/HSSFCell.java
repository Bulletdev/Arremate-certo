/*      */ package org.apache.poi.hssf.usermodel;
/*      */ 
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import org.apache.poi.common.usermodel.HyperlinkType;
/*      */ import org.apache.poi.hssf.model.HSSFFormulaParser;
/*      */ import org.apache.poi.hssf.model.InternalWorkbook;
/*      */ import org.apache.poi.hssf.record.BlankRecord;
/*      */ import org.apache.poi.hssf.record.BoolErrRecord;
/*      */ import org.apache.poi.hssf.record.CellValueRecordInterface;
/*      */ import org.apache.poi.hssf.record.ExtendedFormatRecord;
/*      */ import org.apache.poi.hssf.record.FormulaRecord;
/*      */ import org.apache.poi.hssf.record.HyperlinkRecord;
/*      */ import org.apache.poi.hssf.record.LabelSSTRecord;
/*      */ import org.apache.poi.hssf.record.NumberRecord;
/*      */ import org.apache.poi.hssf.record.Record;
/*      */ import org.apache.poi.hssf.record.RecordBase;
/*      */ import org.apache.poi.hssf.record.aggregates.FormulaRecordAggregate;
/*      */ import org.apache.poi.hssf.record.common.UnicodeString;
/*      */ import org.apache.poi.ss.SpreadsheetVersion;
/*      */ import org.apache.poi.ss.formula.FormulaType;
/*      */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*      */ import org.apache.poi.ss.formula.ptg.ExpPtg;
/*      */ import org.apache.poi.ss.formula.ptg.Ptg;
/*      */ import org.apache.poi.ss.usermodel.Cell;
/*      */ import org.apache.poi.ss.usermodel.CellStyle;
/*      */ import org.apache.poi.ss.usermodel.CellType;
/*      */ import org.apache.poi.ss.usermodel.Comment;
/*      */ import org.apache.poi.ss.usermodel.FormulaError;
/*      */ import org.apache.poi.ss.usermodel.Hyperlink;
/*      */ import org.apache.poi.ss.usermodel.RichTextString;
/*      */ import org.apache.poi.ss.usermodel.Row;
/*      */ import org.apache.poi.ss.usermodel.Sheet;
/*      */ import org.apache.poi.ss.util.CellAddress;
/*      */ import org.apache.poi.ss.util.CellRangeAddress;
/*      */ import org.apache.poi.ss.util.CellReference;
/*      */ import org.apache.poi.ss.util.NumberToTextConverter;
/*      */ import org.apache.poi.util.LocaleUtil;
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
/*      */ public class HSSFCell
/*      */   implements Cell
/*      */ {
/*      */   private static final String FILE_FORMAT_NAME = "BIFF8";
/*   76 */   public static final int LAST_COLUMN_NUMBER = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
/*   77 */   private static final String LAST_COLUMN_NAME = SpreadsheetVersion.EXCEL97.getLastColumnName();
/*      */ 
/*      */   
/*      */   public static final short ENCODING_UNCHANGED = -1;
/*      */ 
/*      */   
/*      */   public static final short ENCODING_COMPRESSED_UNICODE = 0;
/*      */ 
/*      */   
/*      */   public static final short ENCODING_UTF_16 = 1;
/*      */ 
/*      */   
/*      */   private final HSSFWorkbook _book;
/*      */ 
/*      */   
/*      */   private final HSSFSheet _sheet;
/*      */ 
/*      */   
/*      */   private CellType _cellType;
/*      */ 
/*      */   
/*      */   private HSSFRichTextString _stringValue;
/*      */ 
/*      */   
/*      */   private CellValueRecordInterface _record;
/*      */ 
/*      */   
/*      */   private HSSFComment _comment;
/*      */ 
/*      */   
/*      */   protected HSSFCell(HSSFWorkbook paramHSSFWorkbook, HSSFSheet paramHSSFSheet, int paramInt, short paramShort) {
/*  108 */     checkBounds(paramShort);
/*  109 */     this._stringValue = null;
/*  110 */     this._book = paramHSSFWorkbook;
/*  111 */     this._sheet = paramHSSFSheet;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  116 */     short s = paramHSSFSheet.getSheet().getXFIndexForColAt(paramShort);
/*  117 */     setCellType(CellType.BLANK, false, paramInt, paramShort, s);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFSheet getSheet() {
/*  126 */     return this._sheet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFRow getRow() {
/*  135 */     int i = getRowIndex();
/*  136 */     return this._sheet.getRow(i);
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
/*      */   protected HSSFCell(HSSFWorkbook paramHSSFWorkbook, HSSFSheet paramHSSFSheet, int paramInt, short paramShort, CellType paramCellType) {
/*  153 */     checkBounds(paramShort);
/*  154 */     this._cellType = CellType._NONE;
/*  155 */     this._stringValue = null;
/*  156 */     this._book = paramHSSFWorkbook;
/*  157 */     this._sheet = paramHSSFSheet;
/*      */     
/*  159 */     short s = paramHSSFSheet.getSheet().getXFIndexForColAt(paramShort);
/*  160 */     setCellType(paramCellType, false, paramInt, paramShort, s);
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
/*      */   protected HSSFCell(HSSFWorkbook paramHSSFWorkbook, HSSFSheet paramHSSFSheet, CellValueRecordInterface paramCellValueRecordInterface) {
/*  172 */     this._record = paramCellValueRecordInterface;
/*  173 */     this._cellType = determineType(paramCellValueRecordInterface);
/*  174 */     this._stringValue = null;
/*  175 */     this._book = paramHSSFWorkbook;
/*  176 */     this._sheet = paramHSSFSheet;
/*  177 */     switch (this._cellType) {
/*      */       
/*      */       case EMAIL:
/*  180 */         this._stringValue = new HSSFRichTextString(paramHSSFWorkbook.getWorkbook(), (LabelSSTRecord)paramCellValueRecordInterface);
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case FILE:
/*  187 */         this._stringValue = new HSSFRichTextString(((FormulaRecordAggregate)paramCellValueRecordInterface).getStringValue());
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static CellType determineType(CellValueRecordInterface paramCellValueRecordInterface) {
/*      */     BoolErrRecord boolErrRecord;
/*  200 */     if (paramCellValueRecordInterface instanceof FormulaRecordAggregate) {
/*  201 */       return CellType.FORMULA;
/*      */     }
/*      */     
/*  204 */     Record record = (Record)paramCellValueRecordInterface;
/*  205 */     switch (record.getSid()) {
/*      */       case 515:
/*  207 */         return CellType.NUMERIC;
/*  208 */       case 513: return CellType.BLANK;
/*  209 */       case 253: return CellType.STRING;
/*      */       case 517:
/*  211 */         boolErrRecord = (BoolErrRecord)record;
/*      */         
/*  213 */         return boolErrRecord.isBoolean() ? CellType.BOOLEAN : CellType.ERROR;
/*      */     } 
/*      */ 
/*      */     
/*  217 */     throw new RuntimeException("Bad cell value rec (" + paramCellValueRecordInterface.getClass().getName() + ")");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected InternalWorkbook getBoundWorkbook() {
/*  224 */     return this._book.getWorkbook();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRowIndex() {
/*  232 */     return this._record.getRow();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateCellNum(short paramShort) {
/*  242 */     this._record.setColumn(paramShort);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getColumnIndex() {
/*  247 */     return this._record.getColumn() & 0xFFFF;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CellAddress getAddress() {
/*  255 */     return new CellAddress(this);
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
/*  272 */     setCellType(CellType.forInt(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellType(CellType paramCellType) {
/*  281 */     notifyFormulaChanging();
/*  282 */     if (isPartOfArrayFormulaGroup()) {
/*  283 */       notifyArrayFormulaChanging();
/*      */     }
/*  285 */     int i = this._record.getRow();
/*  286 */     short s1 = this._record.getColumn();
/*  287 */     short s2 = this._record.getXFIndex();
/*  288 */     setCellType(paramCellType, true, i, s1, s2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void setCellType(CellType paramCellType, boolean paramBoolean, int paramInt, short paramShort1, short paramShort2) {
/*      */     FormulaRecordAggregate formulaRecordAggregate;
/*      */     NumberRecord numberRecord;
/*      */     LabelSSTRecord labelSSTRecord;
/*      */     BlankRecord blankRecord;
/*      */     BoolErrRecord boolErrRecord1, boolErrRecord2;
/*  302 */     switch (paramCellType) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case FILE:
/*  308 */         if (paramCellType != this._cellType) {
/*  309 */           formulaRecordAggregate = this._sheet.getSheet().getRowsAggregate().createFormula(paramInt, paramShort1);
/*      */         } else {
/*  311 */           formulaRecordAggregate = (FormulaRecordAggregate)this._record;
/*  312 */           formulaRecordAggregate.setRow(paramInt);
/*  313 */           formulaRecordAggregate.setColumn(paramShort1);
/*      */         } 
/*  315 */         if (paramBoolean)
/*      */         {
/*  317 */           formulaRecordAggregate.getFormulaRecord().setValue(getNumericCellValue());
/*      */         }
/*  319 */         formulaRecordAggregate.setXFIndex(paramShort2);
/*  320 */         this._record = (CellValueRecordInterface)formulaRecordAggregate;
/*      */         break;
/*      */       
/*      */       case DOCUMENT:
/*  324 */         numberRecord = null;
/*      */         
/*  326 */         if (paramCellType != this._cellType) {
/*      */           
/*  328 */           numberRecord = new NumberRecord();
/*      */         }
/*      */         else {
/*      */           
/*  332 */           numberRecord = (NumberRecord)this._record;
/*      */         } 
/*  334 */         numberRecord.setColumn(paramShort1);
/*  335 */         if (paramBoolean)
/*      */         {
/*  337 */           numberRecord.setValue(getNumericCellValue());
/*      */         }
/*  339 */         numberRecord.setXFIndex(paramShort2);
/*  340 */         numberRecord.setRow(paramInt);
/*  341 */         this._record = (CellValueRecordInterface)numberRecord;
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case EMAIL:
/*  347 */         if (paramCellType == this._cellType) {
/*  348 */           labelSSTRecord = (LabelSSTRecord)this._record;
/*      */         } else {
/*  350 */           labelSSTRecord = new LabelSSTRecord();
/*  351 */           labelSSTRecord.setColumn(paramShort1);
/*  352 */           labelSSTRecord.setRow(paramInt);
/*  353 */           labelSSTRecord.setXFIndex(paramShort2);
/*      */         } 
/*  355 */         if (paramBoolean) {
/*  356 */           String str = convertCellValueToString();
/*  357 */           if (str == null) {
/*      */ 
/*      */             
/*  360 */             setCellType(CellType.BLANK, false, paramInt, paramShort1, paramShort2);
/*      */             return;
/*      */           } 
/*  363 */           int i = this._book.getWorkbook().addSSTString(new UnicodeString(str));
/*  364 */           labelSSTRecord.setSSTIndex(i);
/*  365 */           UnicodeString unicodeString = this._book.getWorkbook().getSSTString(i);
/*  366 */           this._stringValue = new HSSFRichTextString();
/*  367 */           this._stringValue.setUnicodeString(unicodeString);
/*      */         } 
/*      */         
/*  370 */         this._record = (CellValueRecordInterface)labelSSTRecord;
/*      */         break;
/*      */       
/*      */       case URL:
/*  374 */         blankRecord = null;
/*      */         
/*  376 */         if (paramCellType != this._cellType) {
/*      */           
/*  378 */           blankRecord = new BlankRecord();
/*      */         }
/*      */         else {
/*      */           
/*  382 */           blankRecord = (BlankRecord)this._record;
/*      */         } 
/*  384 */         blankRecord.setColumn(paramShort1);
/*      */ 
/*      */         
/*  387 */         blankRecord.setXFIndex(paramShort2);
/*  388 */         blankRecord.setRow(paramInt);
/*  389 */         this._record = (CellValueRecordInterface)blankRecord;
/*      */         break;
/*      */       
/*      */       case null:
/*  393 */         boolErrRecord1 = null;
/*      */         
/*  395 */         if (paramCellType != this._cellType) {
/*      */           
/*  397 */           boolErrRecord1 = new BoolErrRecord();
/*      */         }
/*      */         else {
/*      */           
/*  401 */           boolErrRecord1 = (BoolErrRecord)this._record;
/*      */         } 
/*  403 */         boolErrRecord1.setColumn(paramShort1);
/*  404 */         if (paramBoolean)
/*      */         {
/*  406 */           boolErrRecord1.setValue(convertCellValueToBoolean());
/*      */         }
/*  408 */         boolErrRecord1.setXFIndex(paramShort2);
/*  409 */         boolErrRecord1.setRow(paramInt);
/*  410 */         this._record = (CellValueRecordInterface)boolErrRecord1;
/*      */         break;
/*      */       
/*      */       case null:
/*  414 */         boolErrRecord2 = null;
/*      */         
/*  416 */         if (paramCellType != this._cellType) {
/*      */           
/*  418 */           boolErrRecord2 = new BoolErrRecord();
/*      */         }
/*      */         else {
/*      */           
/*  422 */           boolErrRecord2 = (BoolErrRecord)this._record;
/*      */         } 
/*  424 */         boolErrRecord2.setColumn(paramShort1);
/*  425 */         if (paramBoolean)
/*      */         {
/*  427 */           boolErrRecord2.setValue(FormulaError.VALUE.getCode());
/*      */         }
/*  429 */         boolErrRecord2.setXFIndex(paramShort2);
/*  430 */         boolErrRecord2.setRow(paramInt);
/*  431 */         this._record = (CellValueRecordInterface)boolErrRecord2;
/*      */         break;
/*      */       default:
/*  434 */         throw new IllegalStateException("Invalid cell type: " + paramCellType);
/*      */     } 
/*  436 */     if (paramCellType != this._cellType && this._cellType != CellType._NONE)
/*      */     {
/*      */       
/*  439 */       this._sheet.getSheet().replaceValueRecord(this._record);
/*      */     }
/*  441 */     this._cellType = paramCellType;
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
/*      */   public int getCellType() {
/*  454 */     return getCellTypeEnum().getCode();
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
/*      */   public CellType getCellTypeEnum() {
/*  466 */     return this._cellType;
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
/*      */   public void setCellValue(double paramDouble) {
/*  479 */     if (Double.isInfinite(paramDouble)) {
/*      */ 
/*      */       
/*  482 */       setCellErrorValue(FormulaError.DIV0.getCode());
/*  483 */     } else if (Double.isNaN(paramDouble)) {
/*      */ 
/*      */       
/*  486 */       setCellErrorValue(FormulaError.NUM.getCode());
/*      */     } else {
/*  488 */       int i = this._record.getRow();
/*  489 */       short s1 = this._record.getColumn();
/*  490 */       short s2 = this._record.getXFIndex();
/*      */       
/*  492 */       switch (this._cellType) {
/*      */         default:
/*  494 */           setCellType(CellType.NUMERIC, false, i, s1, s2);
/*      */         
/*      */         case DOCUMENT:
/*  497 */           ((NumberRecord)this._record).setValue(paramDouble); return;
/*      */         case FILE:
/*      */           break;
/*  500 */       }  ((FormulaRecordAggregate)this._record).setCachedDoubleResult(paramDouble);
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
/*      */   public void setCellValue(Date paramDate) {
/*  517 */     setCellValue(HSSFDateUtil.getExcelDate(paramDate, this._book.getWorkbook().isUsing1904DateWindowing()));
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
/*      */   public void setCellValue(Calendar paramCalendar) {
/*  537 */     setCellValue(HSSFDateUtil.getExcelDate(paramCalendar, this._book.getWorkbook().isUsing1904DateWindowing()));
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
/*      */   public void setCellValue(String paramString) {
/*  549 */     HSSFRichTextString hSSFRichTextString = (paramString == null) ? null : new HSSFRichTextString(paramString);
/*  550 */     setCellValue(hSSFRichTextString);
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
/*      */   public void setCellValue(RichTextString paramRichTextString) {
/*  564 */     int i = this._record.getRow();
/*  565 */     short s1 = this._record.getColumn();
/*  566 */     short s2 = this._record.getXFIndex();
/*  567 */     if (paramRichTextString == null) {
/*      */       
/*  569 */       notifyFormulaChanging();
/*  570 */       setCellType(CellType.BLANK, false, i, s1, s2);
/*      */       
/*      */       return;
/*      */     } 
/*  574 */     if (paramRichTextString.length() > SpreadsheetVersion.EXCEL97.getMaxTextLength()) {
/*  575 */       throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
/*      */     }
/*      */     
/*  578 */     if (this._cellType == CellType.FORMULA) {
/*      */ 
/*      */       
/*  581 */       FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate)this._record;
/*  582 */       formulaRecordAggregate.setCachedStringResult(paramRichTextString.getString());
/*      */       
/*  584 */       this._stringValue = new HSSFRichTextString(paramRichTextString.getString());
/*      */ 
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  593 */     if (this._cellType != CellType.STRING) {
/*  594 */       setCellType(CellType.STRING, false, i, s1, s2);
/*      */     }
/*  596 */     int j = 0;
/*      */     
/*  598 */     HSSFRichTextString hSSFRichTextString = (HSSFRichTextString)paramRichTextString;
/*  599 */     UnicodeString unicodeString = hSSFRichTextString.getUnicodeString();
/*  600 */     j = this._book.getWorkbook().addSSTString(unicodeString);
/*  601 */     ((LabelSSTRecord)this._record).setSSTIndex(j);
/*  602 */     this._stringValue = hSSFRichTextString;
/*  603 */     this._stringValue.setWorkbookReferences(this._book.getWorkbook(), (LabelSSTRecord)this._record);
/*  604 */     this._stringValue.setUnicodeString(this._book.getWorkbook().getSSTString(j));
/*      */   }
/*      */   
/*      */   public void setCellFormula(String paramString) {
/*  608 */     if (isPartOfArrayFormulaGroup()) {
/*  609 */       notifyArrayFormulaChanging();
/*      */     }
/*      */     
/*  612 */     int i = this._record.getRow();
/*  613 */     short s1 = this._record.getColumn();
/*  614 */     short s2 = this._record.getXFIndex();
/*      */     
/*  616 */     if (paramString == null) {
/*  617 */       notifyFormulaChanging();
/*  618 */       setCellType(CellType.BLANK, false, i, s1, s2);
/*      */       return;
/*      */     } 
/*  621 */     int j = this._book.getSheetIndex(this._sheet);
/*  622 */     Ptg[] arrayOfPtg = HSSFFormulaParser.parse(paramString, this._book, FormulaType.CELL, j);
/*  623 */     setCellType(CellType.FORMULA, false, i, s1, s2);
/*  624 */     FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate)this._record;
/*  625 */     FormulaRecord formulaRecord = formulaRecordAggregate.getFormulaRecord();
/*  626 */     formulaRecord.setOptions((short)2);
/*  627 */     formulaRecord.setValue(0.0D);
/*      */ 
/*      */     
/*  630 */     if (formulaRecordAggregate.getXFIndex() == 0) {
/*  631 */       formulaRecordAggregate.setXFIndex((short)15);
/*      */     }
/*  633 */     formulaRecordAggregate.setParsedExpression(arrayOfPtg);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void notifyFormulaChanging() {
/*  640 */     if (this._record instanceof FormulaRecordAggregate) {
/*  641 */       ((FormulaRecordAggregate)this._record).notifyFormulaChanging();
/*      */     }
/*      */   }
/*      */   
/*      */   public String getCellFormula() {
/*  646 */     if (!(this._record instanceof FormulaRecordAggregate)) {
/*  647 */       throw typeMismatch(CellType.FORMULA, this._cellType, true);
/*      */     }
/*  649 */     return HSSFFormulaParser.toFormulaString(this._book, ((FormulaRecordAggregate)this._record).getFormulaTokens());
/*      */   }
/*      */   
/*      */   private static RuntimeException typeMismatch(CellType paramCellType1, CellType paramCellType2, boolean paramBoolean) {
/*  653 */     String str = "Cannot get a " + paramCellType1 + " value from a " + paramCellType2 + " " + (paramBoolean ? "formula " : "") + "cell";
/*      */     
/*  655 */     return new IllegalStateException(str);
/*      */   }
/*      */   private static void checkFormulaCachedValueType(CellType paramCellType, FormulaRecord paramFormulaRecord) {
/*  658 */     CellType cellType = CellType.forInt(paramFormulaRecord.getCachedResultType());
/*  659 */     if (cellType != paramCellType) {
/*  660 */       throw typeMismatch(paramCellType, cellType, true);
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
/*      */   public double getNumericCellValue() {
/*  674 */     switch (this._cellType) {
/*      */       case URL:
/*  676 */         return 0.0D;
/*      */       case DOCUMENT:
/*  678 */         return ((NumberRecord)this._record).getValue();
/*      */       default:
/*  680 */         throw typeMismatch(CellType.NUMERIC, this._cellType, false);
/*      */       case FILE:
/*      */         break;
/*      */     } 
/*  684 */     FormulaRecord formulaRecord = ((FormulaRecordAggregate)this._record).getFormulaRecord();
/*  685 */     checkFormulaCachedValueType(CellType.NUMERIC, formulaRecord);
/*  686 */     return formulaRecord.getValue();
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
/*      */   public Date getDateCellValue() {
/*  698 */     if (this._cellType == CellType.BLANK) {
/*  699 */       return null;
/*      */     }
/*  701 */     double d = getNumericCellValue();
/*  702 */     if (this._book.getWorkbook().isUsing1904DateWindowing()) {
/*  703 */       return HSSFDateUtil.getJavaDate(d, true);
/*      */     }
/*  705 */     return HSSFDateUtil.getJavaDate(d, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStringCellValue() {
/*  715 */     HSSFRichTextString hSSFRichTextString = getRichStringCellValue();
/*  716 */     return hSSFRichTextString.getString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFRichTextString getRichStringCellValue() {
/*  726 */     switch (this._cellType) {
/*      */       case URL:
/*  728 */         return new HSSFRichTextString("");
/*      */       case EMAIL:
/*  730 */         return this._stringValue;
/*      */       default:
/*  732 */         throw typeMismatch(CellType.STRING, this._cellType, false);
/*      */       case FILE:
/*      */         break;
/*      */     } 
/*  736 */     FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate)this._record;
/*  737 */     checkFormulaCachedValueType(CellType.STRING, formulaRecordAggregate.getFormulaRecord());
/*  738 */     String str = formulaRecordAggregate.getStringValue();
/*  739 */     return new HSSFRichTextString((str == null) ? "" : str);
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
/*      */   public void setCellValue(boolean paramBoolean) {
/*  751 */     int i = this._record.getRow();
/*  752 */     short s1 = this._record.getColumn();
/*  753 */     short s2 = this._record.getXFIndex();
/*      */     
/*  755 */     switch (this._cellType) {
/*      */       default:
/*  757 */         setCellType(CellType.BOOLEAN, false, i, s1, s2);
/*      */       
/*      */       case null:
/*  760 */         ((BoolErrRecord)this._record).setValue(paramBoolean); return;
/*      */       case FILE:
/*      */         break;
/*  763 */     }  ((FormulaRecordAggregate)this._record).setCachedBooleanResult(paramBoolean);
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
/*      */   public void setCellErrorValue(byte paramByte) {
/*  779 */     FormulaError formulaError = FormulaError.forInt(paramByte);
/*  780 */     setCellErrorValue(formulaError);
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
/*  792 */     int i = this._record.getRow();
/*  793 */     short s1 = this._record.getColumn();
/*  794 */     short s2 = this._record.getXFIndex();
/*  795 */     switch (this._cellType) {
/*      */       default:
/*  797 */         setCellType(CellType.ERROR, false, i, s1, s2);
/*      */       
/*      */       case null:
/*  800 */         ((BoolErrRecord)this._record).setValue(paramFormulaError); return;
/*      */       case FILE:
/*      */         break;
/*  803 */     }  ((FormulaRecordAggregate)this._record).setCachedErrorResult(paramFormulaError.getCode());
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
/*      */   private boolean convertCellValueToBoolean() {
/*      */     int i;
/*      */     String str;
/*      */     FormulaRecord formulaRecord;
/*  819 */     switch (this._cellType) {
/*      */       case null:
/*  821 */         return ((BoolErrRecord)this._record).getBooleanValue();
/*      */       case EMAIL:
/*  823 */         i = ((LabelSSTRecord)this._record).getSSTIndex();
/*  824 */         str = this._book.getWorkbook().getSSTString(i).getString();
/*  825 */         return Boolean.valueOf(str).booleanValue();
/*      */       case DOCUMENT:
/*  827 */         return (((NumberRecord)this._record).getValue() != 0.0D);
/*      */ 
/*      */       
/*      */       case FILE:
/*  831 */         formulaRecord = ((FormulaRecordAggregate)this._record).getFormulaRecord();
/*  832 */         checkFormulaCachedValueType(CellType.BOOLEAN, formulaRecord);
/*  833 */         return formulaRecord.getCachedBooleanValue();
/*      */ 
/*      */       
/*      */       case URL:
/*      */       case null:
/*  838 */         return false;
/*      */     } 
/*  840 */     throw new RuntimeException("Unexpected cell type (" + this._cellType + ")");
/*      */   }
/*      */   private String convertCellValueToString() {
/*      */     int i;
/*  844 */     switch (this._cellType) {
/*      */       case URL:
/*  846 */         return "";
/*      */       case null:
/*  848 */         return ((BoolErrRecord)this._record).getBooleanValue() ? "TRUE" : "FALSE";
/*      */       case EMAIL:
/*  850 */         i = ((LabelSSTRecord)this._record).getSSTIndex();
/*  851 */         return this._book.getWorkbook().getSSTString(i).getString();
/*      */       case DOCUMENT:
/*  853 */         return NumberToTextConverter.toText(((NumberRecord)this._record).getValue());
/*      */       case null:
/*  855 */         return FormulaError.forInt(((BoolErrRecord)this._record).getErrorValue()).getString();
/*      */       
/*      */       case FILE:
/*      */         break;
/*      */       
/*      */       default:
/*  861 */         throw new IllegalStateException("Unexpected cell type (" + this._cellType + ")");
/*      */     } 
/*  863 */     FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate)this._record;
/*  864 */     FormulaRecord formulaRecord = formulaRecordAggregate.getFormulaRecord();
/*  865 */     switch (CellType.forInt(formulaRecord.getCachedResultType())) {
/*      */       case null:
/*  867 */         return formulaRecord.getCachedBooleanValue() ? "TRUE" : "FALSE";
/*      */       case EMAIL:
/*  869 */         return formulaRecordAggregate.getStringValue();
/*      */       case DOCUMENT:
/*  871 */         return NumberToTextConverter.toText(formulaRecord.getValue());
/*      */       case null:
/*  873 */         return FormulaError.forInt(formulaRecord.getCachedErrorValue()).getString();
/*      */     } 
/*  875 */     throw new IllegalStateException("Unexpected formula result type (" + this._cellType + ")");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBooleanCellValue() {
/*      */     FormulaRecord formulaRecord;
/*  887 */     switch (this._cellType) {
/*      */       case URL:
/*  889 */         return false;
/*      */       case null:
/*  891 */         return ((BoolErrRecord)this._record).getBooleanValue();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case FILE:
/*  897 */         formulaRecord = ((FormulaRecordAggregate)this._record).getFormulaRecord();
/*  898 */         checkFormulaCachedValueType(CellType.BOOLEAN, formulaRecord);
/*  899 */         return formulaRecord.getCachedBooleanValue();
/*      */     } 
/*      */     throw typeMismatch(CellType.BOOLEAN, this._cellType, false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte getErrorCellValue() {
/*      */     FormulaRecord formulaRecord;
/*  908 */     switch (this._cellType) {
/*      */       case null:
/*  910 */         return ((BoolErrRecord)this._record).getErrorValue();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case FILE:
/*  916 */         formulaRecord = ((FormulaRecordAggregate)this._record).getFormulaRecord();
/*  917 */         checkFormulaCachedValueType(CellType.ERROR, formulaRecord);
/*  918 */         return (byte)formulaRecord.getCachedErrorValue();
/*      */     } 
/*      */     throw typeMismatch(CellType.ERROR, this._cellType, false);
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
/*      */   public void setCellStyle(CellStyle paramCellStyle) {
/*  933 */     setCellStyle((HSSFCellStyle)paramCellStyle);
/*      */   }
/*      */   public void setCellStyle(HSSFCellStyle paramHSSFCellStyle) {
/*      */     short s;
/*  937 */     if (paramHSSFCellStyle == null) {
/*  938 */       this._record.setXFIndex((short)15);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  943 */     paramHSSFCellStyle.verifyBelongsToWorkbook(this._book);
/*      */ 
/*      */     
/*  946 */     if (paramHSSFCellStyle.getUserStyleName() != null) {
/*  947 */       s = applyUserCellStyle(paramHSSFCellStyle);
/*      */     } else {
/*  949 */       s = paramHSSFCellStyle.getIndex();
/*      */     } 
/*      */ 
/*      */     
/*  953 */     this._record.setXFIndex(s);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFCellStyle getCellStyle() {
/*  963 */     short s = this._record.getXFIndex();
/*  964 */     ExtendedFormatRecord extendedFormatRecord = this._book.getWorkbook().getExFormatAt(s);
/*  965 */     return new HSSFCellStyle(s, extendedFormatRecord, this._book);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected CellValueRecordInterface getCellValueRecord() {
/*  976 */     return this._record;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkBounds(int paramInt) {
/*  983 */     if (paramInt < 0 || paramInt > LAST_COLUMN_NUMBER) {
/*  984 */       throw new IllegalArgumentException("Invalid column index (" + paramInt + ").  Allowable column range for " + "BIFF8" + " is (0.." + LAST_COLUMN_NUMBER + ") or ('A'..'" + LAST_COLUMN_NAME + "')");
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
/*      */   public void setAsActiveCell() {
/*  996 */     int i = this._record.getRow();
/*  997 */     short s = this._record.getColumn();
/*  998 */     this._sheet.getSheet().setActiveCellRow(i);
/*  999 */     this._sheet.getSheet().setActiveCellCol(s);
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
/*      */   public String toString() {
/* 1015 */     switch (getCellTypeEnum()) {
/*      */       case URL:
/* 1017 */         return "";
/*      */       case null:
/* 1019 */         return getBooleanCellValue() ? "TRUE" : "FALSE";
/*      */       case null:
/* 1021 */         return ErrorEval.getText(((BoolErrRecord)this._record).getErrorValue());
/*      */       case FILE:
/* 1023 */         return getCellFormula();
/*      */       
/*      */       case DOCUMENT:
/* 1026 */         if (HSSFDateUtil.isCellDateFormatted(this)) {
/* 1027 */           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
/* 1028 */           simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
/* 1029 */           return simpleDateFormat.format(getDateCellValue());
/*      */         } 
/* 1031 */         return String.valueOf(getNumericCellValue());
/*      */       case EMAIL:
/* 1033 */         return getStringCellValue();
/*      */     } 
/* 1035 */     return "Unknown Cell Type: " + getCellTypeEnum();
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
/*      */   public void setCellComment(Comment paramComment) {
/* 1047 */     if (paramComment == null) {
/* 1048 */       removeCellComment();
/*      */       
/*      */       return;
/*      */     } 
/* 1052 */     paramComment.setRow(this._record.getRow());
/* 1053 */     paramComment.setColumn(this._record.getColumn());
/* 1054 */     this._comment = (HSSFComment)paramComment;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFComment getCellComment() {
/* 1063 */     if (this._comment == null) {
/* 1064 */       this._comment = this._sheet.findCellComment(this._record.getRow(), this._record.getColumn());
/*      */     }
/* 1066 */     return this._comment;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeCellComment() {
/* 1076 */     HSSFComment hSSFComment = this._sheet.findCellComment(this._record.getRow(), this._record.getColumn());
/* 1077 */     this._comment = null;
/* 1078 */     if (null == hSSFComment) {
/*      */       return;
/*      */     }
/* 1081 */     this._sheet.getDrawingPatriarch().removeShape(hSSFComment);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFHyperlink getHyperlink() {
/* 1089 */     return this._sheet.getHyperlink(this._record.getRow(), this._record.getColumn());
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
/* 1100 */     if (paramHyperlink == null) {
/* 1101 */       removeHyperlink();
/*      */       
/*      */       return;
/*      */     } 
/* 1105 */     HSSFHyperlink hSSFHyperlink = (HSSFHyperlink)paramHyperlink;
/*      */     
/* 1107 */     hSSFHyperlink.setFirstRow(this._record.getRow());
/* 1108 */     hSSFHyperlink.setLastRow(this._record.getRow());
/* 1109 */     hSSFHyperlink.setFirstColumn(this._record.getColumn());
/* 1110 */     hSSFHyperlink.setLastColumn(this._record.getColumn());
/*      */     
/* 1112 */     switch (hSSFHyperlink.getTypeEnum()) {
/*      */       case EMAIL:
/*      */       case URL:
/* 1115 */         hSSFHyperlink.setLabel("url");
/*      */         break;
/*      */       case FILE:
/* 1118 */         hSSFHyperlink.setLabel("file");
/*      */         break;
/*      */       case DOCUMENT:
/* 1121 */         hSSFHyperlink.setLabel("place");
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1127 */     List<HyperlinkRecord> list = this._sheet.getSheet().getRecords();
/* 1128 */     int i = list.size() - 1;
/* 1129 */     list.add(i, hSSFHyperlink.record);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeHyperlink() {
/* 1136 */     for (Iterator<RecordBase> iterator = this._sheet.getSheet().getRecords().iterator(); iterator.hasNext(); ) {
/* 1137 */       RecordBase recordBase = iterator.next();
/* 1138 */       if (recordBase instanceof HyperlinkRecord) {
/* 1139 */         HyperlinkRecord hyperlinkRecord = (HyperlinkRecord)recordBase;
/* 1140 */         if (hyperlinkRecord.getFirstColumn() == this._record.getColumn() && hyperlinkRecord.getFirstRow() == this._record.getRow()) {
/* 1141 */           iterator.remove();
/*      */           return;
/*      */         } 
/*      */       } 
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
/*      */   public int getCachedFormulaResultType() {
/* 1161 */     return getCachedFormulaResultTypeEnum().getCode();
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
/* 1175 */     if (this._cellType != CellType.FORMULA) {
/* 1176 */       throw new IllegalStateException("Only formula cells have cached results");
/*      */     }
/* 1178 */     int i = ((FormulaRecordAggregate)this._record).getFormulaRecord().getCachedResultType();
/* 1179 */     return CellType.forInt(i);
/*      */   }
/*      */   
/*      */   void setCellArrayFormula(CellRangeAddress paramCellRangeAddress) {
/* 1183 */     int i = this._record.getRow();
/* 1184 */     short s1 = this._record.getColumn();
/* 1185 */     short s2 = this._record.getXFIndex();
/* 1186 */     setCellType(CellType.FORMULA, false, i, s1, s2);
/*      */ 
/*      */     
/* 1189 */     Ptg[] arrayOfPtg = { (Ptg)new ExpPtg(paramCellRangeAddress.getFirstRow(), paramCellRangeAddress.getFirstColumn()) };
/* 1190 */     FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate)this._record;
/* 1191 */     formulaRecordAggregate.setParsedExpression(arrayOfPtg);
/*      */   }
/*      */   
/*      */   public CellRangeAddress getArrayFormulaRange() {
/* 1195 */     if (this._cellType != CellType.FORMULA) {
/* 1196 */       String str = (new CellReference(this)).formatAsString();
/* 1197 */       throw new IllegalStateException("Cell " + str + " is not part of an array formula.");
/*      */     } 
/*      */     
/* 1200 */     return ((FormulaRecordAggregate)this._record).getArrayFormulaRange();
/*      */   }
/*      */   
/*      */   public boolean isPartOfArrayFormulaGroup() {
/* 1204 */     if (this._cellType != CellType.FORMULA) {
/* 1205 */       return false;
/*      */     }
/* 1207 */     return ((FormulaRecordAggregate)this._record).isPartOfArrayFormula();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void notifyArrayFormulaChanging(String paramString) {
/* 1216 */     CellRangeAddress cellRangeAddress = getArrayFormulaRange();
/* 1217 */     if (cellRangeAddress.getNumberOfCells() > 1) {
/* 1218 */       throw new IllegalStateException(paramString);
/*      */     }
/*      */     
/* 1221 */     getRow().getSheet().removeArrayFormula(this);
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
/* 1239 */     CellReference cellReference = new CellReference(this);
/* 1240 */     String str = "Cell " + cellReference.formatAsString() + " is part of a multi-cell array formula. " + "You cannot change part of an array.";
/*      */     
/* 1242 */     notifyArrayFormulaChanging(str);
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
/*      */   private short applyUserCellStyle(HSSFCellStyle paramHSSFCellStyle) {
/* 1262 */     if (paramHSSFCellStyle.getUserStyleName() == null) {
/* 1263 */       throw new IllegalArgumentException("Expected user-defined style");
/*      */     }
/*      */     
/* 1266 */     InternalWorkbook internalWorkbook = this._book.getWorkbook();
/* 1267 */     short s1 = -1;
/* 1268 */     int i = internalWorkbook.getNumExFormats(); short s2;
/* 1269 */     for (s2 = 0; s2 < i; s2 = (short)(s2 + 1)) {
/* 1270 */       ExtendedFormatRecord extendedFormatRecord = internalWorkbook.getExFormatAt(s2);
/* 1271 */       if (extendedFormatRecord.getXFType() == 0 && extendedFormatRecord.getParentIndex() == paramHSSFCellStyle.getIndex()) {
/* 1272 */         s1 = s2;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 1277 */     if (s1 == -1) {
/* 1278 */       ExtendedFormatRecord extendedFormatRecord = internalWorkbook.createCellXF();
/* 1279 */       extendedFormatRecord.cloneStyleFrom(internalWorkbook.getExFormatAt(paramHSSFCellStyle.getIndex()));
/* 1280 */       extendedFormatRecord.setIndentionOptions((short)0);
/* 1281 */       extendedFormatRecord.setXFType((short)0);
/* 1282 */       extendedFormatRecord.setParentIndex(paramHSSFCellStyle.getIndex());
/* 1283 */       s2 = (short)i;
/*      */     } else {
/* 1285 */       s2 = s1;
/*      */     } 
/*      */     
/* 1288 */     return s2;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */