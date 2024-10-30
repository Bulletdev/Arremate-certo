/*      */ package org.apache.poi.hssf.usermodel;
/*      */ 
/*      */ import java.io.PrintWriter;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.TreeMap;
/*      */ import java.util.TreeSet;
/*      */ import org.apache.poi.ddf.EscherRecord;
/*      */ import org.apache.poi.hssf.model.DrawingManager2;
/*      */ import org.apache.poi.hssf.model.HSSFFormulaParser;
/*      */ import org.apache.poi.hssf.model.InternalSheet;
/*      */ import org.apache.poi.hssf.model.InternalWorkbook;
/*      */ import org.apache.poi.hssf.record.AutoFilterInfoRecord;
/*      */ import org.apache.poi.hssf.record.CellValueRecordInterface;
/*      */ import org.apache.poi.hssf.record.DVRecord;
/*      */ import org.apache.poi.hssf.record.DrawingRecord;
/*      */ import org.apache.poi.hssf.record.EscherAggregate;
/*      */ import org.apache.poi.hssf.record.ExtendedFormatRecord;
/*      */ import org.apache.poi.hssf.record.HyperlinkRecord;
/*      */ import org.apache.poi.hssf.record.NameRecord;
/*      */ import org.apache.poi.hssf.record.Record;
/*      */ import org.apache.poi.hssf.record.RecordBase;
/*      */ import org.apache.poi.hssf.record.RowRecord;
/*      */ import org.apache.poi.hssf.record.SCLRecord;
/*      */ import org.apache.poi.hssf.record.WSBoolRecord;
/*      */ import org.apache.poi.hssf.record.aggregates.DataValidityTable;
/*      */ import org.apache.poi.hssf.record.aggregates.FormulaRecordAggregate;
/*      */ import org.apache.poi.hssf.record.aggregates.RecordAggregate;
/*      */ import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
/*      */ import org.apache.poi.hssf.usermodel.helpers.HSSFRowShifter;
/*      */ import org.apache.poi.ss.SpreadsheetVersion;
/*      */ import org.apache.poi.ss.formula.FormulaShifter;
/*      */ import org.apache.poi.ss.formula.FormulaType;
/*      */ import org.apache.poi.ss.formula.ptg.Area3DPtg;
/*      */ import org.apache.poi.ss.formula.ptg.MemFuncPtg;
/*      */ import org.apache.poi.ss.formula.ptg.Ptg;
/*      */ import org.apache.poi.ss.formula.ptg.UnionPtg;
/*      */ import org.apache.poi.ss.usermodel.AutoFilter;
/*      */ import org.apache.poi.ss.usermodel.Cell;
/*      */ import org.apache.poi.ss.usermodel.CellRange;
/*      */ import org.apache.poi.ss.usermodel.CellStyle;
/*      */ import org.apache.poi.ss.usermodel.CellType;
/*      */ import org.apache.poi.ss.usermodel.Comment;
/*      */ import org.apache.poi.ss.usermodel.DataValidation;
/*      */ import org.apache.poi.ss.usermodel.DataValidationHelper;
/*      */ import org.apache.poi.ss.usermodel.Drawing;
/*      */ import org.apache.poi.ss.usermodel.Footer;
/*      */ import org.apache.poi.ss.usermodel.Header;
/*      */ import org.apache.poi.ss.usermodel.Hyperlink;
/*      */ import org.apache.poi.ss.usermodel.PrintSetup;
/*      */ import org.apache.poi.ss.usermodel.Row;
/*      */ import org.apache.poi.ss.usermodel.Sheet;
/*      */ import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
/*      */ import org.apache.poi.ss.usermodel.Workbook;
/*      */ import org.apache.poi.ss.util.CellAddress;
/*      */ import org.apache.poi.ss.util.CellRangeAddress;
/*      */ import org.apache.poi.ss.util.CellRangeAddressBase;
/*      */ import org.apache.poi.ss.util.CellRangeAddressList;
/*      */ import org.apache.poi.ss.util.CellReference;
/*      */ import org.apache.poi.ss.util.PaneInformation;
/*      */ import org.apache.poi.ss.util.SSCellRange;
/*      */ import org.apache.poi.ss.util.SheetUtil;
/*      */ import org.apache.poi.util.Configurator;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
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
/*      */ public final class HSSFSheet
/*      */   implements Sheet
/*      */ {
/*   84 */   private static final POILogger log = POILogFactory.getLogger(HSSFSheet.class);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int DEBUG = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final float PX_DEFAULT = 32.0F;
/*      */ 
/*      */ 
/*      */   
/*      */   private static final float PX_MODIFIED = 36.56F;
/*      */ 
/*      */ 
/*      */   
/*  102 */   public static final int INITIAL_CAPACITY = Configurator.getIntValue("HSSFSheet.RowInitialCapacity", 20);
/*      */ 
/*      */   
/*      */   private final InternalSheet _sheet;
/*      */ 
/*      */   
/*      */   private final TreeMap<Integer, HSSFRow> _rows;
/*      */ 
/*      */   
/*      */   protected final InternalWorkbook _book;
/*      */ 
/*      */   
/*      */   protected final HSSFWorkbook _workbook;
/*      */ 
/*      */   
/*      */   private HSSFPatriarch _patriarch;
/*      */ 
/*      */   
/*      */   private int _firstrow;
/*      */   
/*      */   private int _lastrow;
/*      */ 
/*      */   
/*      */   protected HSSFSheet(HSSFWorkbook paramHSSFWorkbook) {
/*  126 */     this._sheet = InternalSheet.createSheet();
/*  127 */     this._rows = new TreeMap<Integer, HSSFRow>();
/*  128 */     this._workbook = paramHSSFWorkbook;
/*  129 */     this._book = paramHSSFWorkbook.getWorkbook();
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
/*      */   protected HSSFSheet(HSSFWorkbook paramHSSFWorkbook, InternalSheet paramInternalSheet) {
/*  141 */     this._sheet = paramInternalSheet;
/*  142 */     this._rows = new TreeMap<Integer, HSSFRow>();
/*  143 */     this._workbook = paramHSSFWorkbook;
/*  144 */     this._book = paramHSSFWorkbook.getWorkbook();
/*  145 */     setPropertiesFromSheet(paramInternalSheet);
/*      */   }
/*      */   
/*      */   HSSFSheet cloneSheet(HSSFWorkbook paramHSSFWorkbook) {
/*  149 */     getDrawingPatriarch();
/*  150 */     HSSFSheet hSSFSheet = new HSSFSheet(paramHSSFWorkbook, this._sheet.cloneSheet());
/*  151 */     int i = hSSFSheet._sheet.findFirstRecordLocBySid((short)236);
/*  152 */     DrawingRecord drawingRecord = (DrawingRecord)hSSFSheet._sheet.findFirstRecordBySid((short)236);
/*  153 */     if (null != drawingRecord) {
/*  154 */       hSSFSheet._sheet.getRecords().remove(drawingRecord);
/*      */     }
/*  156 */     if (getDrawingPatriarch() != null) {
/*  157 */       HSSFPatriarch hSSFPatriarch = HSSFPatriarch.createPatriarch(getDrawingPatriarch(), hSSFSheet);
/*  158 */       hSSFSheet._sheet.getRecords().add(i, hSSFPatriarch.getBoundAggregate());
/*  159 */       hSSFSheet._patriarch = hSSFPatriarch;
/*      */     } 
/*  161 */     return hSSFSheet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void preSerialize() {
/*  168 */     if (this._patriarch != null) {
/*  169 */       this._patriarch.preSerialize();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFWorkbook getWorkbook() {
/*  180 */     return this._workbook;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void setPropertiesFromSheet(InternalSheet paramInternalSheet) {
/*  187 */     RowRecord rowRecord = paramInternalSheet.getNextRow();
/*      */     
/*  189 */     while (rowRecord != null) {
/*  190 */       createRowFromRecord(rowRecord);
/*      */       
/*  192 */       rowRecord = paramInternalSheet.getNextRow();
/*      */     } 
/*      */     
/*  195 */     Iterator<CellValueRecordInterface> iterator = paramInternalSheet.getCellValueIterator();
/*  196 */     long l = System.currentTimeMillis();
/*      */     
/*  198 */     if (log.check(1)) {
/*  199 */       log.log(1, new Object[] { "Time at start of cell creating in HSSF sheet = ", Long.valueOf(l) });
/*      */     }
/*      */     
/*  202 */     HSSFRow hSSFRow = null;
/*      */ 
/*      */     
/*  205 */     while (iterator.hasNext()) {
/*  206 */       CellValueRecordInterface cellValueRecordInterface = iterator.next();
/*      */       
/*  208 */       long l1 = System.currentTimeMillis();
/*  209 */       HSSFRow hSSFRow1 = hSSFRow;
/*      */       
/*  211 */       if (hSSFRow1 == null || hSSFRow1.getRowNum() != cellValueRecordInterface.getRow()) {
/*  212 */         hSSFRow1 = getRow(cellValueRecordInterface.getRow());
/*  213 */         hSSFRow = hSSFRow1;
/*  214 */         if (hSSFRow1 == null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  224 */           RowRecord rowRecord1 = new RowRecord(cellValueRecordInterface.getRow());
/*  225 */           paramInternalSheet.addRow(rowRecord1);
/*  226 */           hSSFRow1 = createRowFromRecord(rowRecord1);
/*      */         } 
/*      */       } 
/*  229 */       if (log.check(1)) {
/*  230 */         if (cellValueRecordInterface instanceof Record) {
/*  231 */           log.log(1, new Object[] { "record id = " + Integer.toHexString(((Record)cellValueRecordInterface).getSid()) });
/*      */         } else {
/*  233 */           log.log(1, new Object[] { "record = " + cellValueRecordInterface });
/*      */         } 
/*      */       }
/*  236 */       hSSFRow1.createCellFromRecord(cellValueRecordInterface);
/*  237 */       if (log.check(1)) {
/*  238 */         log.log(1, new Object[] { "record took ", Long.valueOf(System.currentTimeMillis() - l1) });
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  243 */     if (log.check(1)) {
/*  244 */       log.log(1, new Object[] { "total sheet cell creation took ", Long.valueOf(System.currentTimeMillis() - l) });
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
/*      */   public HSSFRow createRow(int paramInt) {
/*  259 */     HSSFRow hSSFRow = new HSSFRow(this._workbook, this, paramInt);
/*      */     
/*  261 */     hSSFRow.setHeight(getDefaultRowHeight());
/*  262 */     hSSFRow.getRowRecord().setBadFontHeight(false);
/*      */     
/*  264 */     addRow(hSSFRow, true);
/*  265 */     return hSSFRow;
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
/*      */   private HSSFRow createRowFromRecord(RowRecord paramRowRecord) {
/*  277 */     HSSFRow hSSFRow = new HSSFRow(this._workbook, this, paramRowRecord);
/*      */     
/*  279 */     addRow(hSSFRow, false);
/*  280 */     return hSSFRow;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeRow(Row paramRow) {
/*  290 */     HSSFRow hSSFRow = (HSSFRow)paramRow;
/*  291 */     if (paramRow.getSheet() != this) {
/*  292 */       throw new IllegalArgumentException("Specified row does not belong to this sheet");
/*      */     }
/*  294 */     for (Cell cell : paramRow) {
/*  295 */       HSSFCell hSSFCell = (HSSFCell)cell;
/*  296 */       if (hSSFCell.isPartOfArrayFormulaGroup()) {
/*  297 */         String str = "Row[rownum=" + paramRow.getRowNum() + "] contains cell(s) included in a multi-cell array formula. You cannot change part of an array.";
/*  298 */         hSSFCell.notifyArrayFormulaChanging(str);
/*      */       } 
/*      */     } 
/*      */     
/*  302 */     if (this._rows.size() > 0) {
/*  303 */       Integer integer = Integer.valueOf(paramRow.getRowNum());
/*  304 */       HSSFRow hSSFRow1 = this._rows.remove(integer);
/*  305 */       if (hSSFRow1 != paramRow)
/*      */       {
/*  307 */         throw new IllegalArgumentException("Specified row does not belong to this sheet");
/*      */       }
/*  309 */       if (hSSFRow.getRowNum() == getLastRowNum()) {
/*  310 */         this._lastrow = findLastRow(this._lastrow);
/*      */       }
/*  312 */       if (hSSFRow.getRowNum() == getFirstRowNum()) {
/*  313 */         this._firstrow = findFirstRow(this._firstrow);
/*      */       }
/*  315 */       this._sheet.removeRow(hSSFRow.getRowRecord());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int findLastRow(int paramInt) {
/*  323 */     if (paramInt < 1) {
/*  324 */       return 0;
/*      */     }
/*  326 */     int i = paramInt - 1;
/*  327 */     HSSFRow hSSFRow = getRow(i);
/*      */     
/*  329 */     while (hSSFRow == null && i > 0) {
/*  330 */       hSSFRow = getRow(--i);
/*      */     }
/*  332 */     if (hSSFRow == null) {
/*  333 */       return 0;
/*      */     }
/*  335 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int findFirstRow(int paramInt) {
/*  343 */     int i = paramInt + 1;
/*  344 */     HSSFRow hSSFRow = getRow(i);
/*      */     
/*  346 */     while (hSSFRow == null && i <= getLastRowNum()) {
/*  347 */       hSSFRow = getRow(++i);
/*      */     }
/*      */     
/*  350 */     if (i > getLastRowNum()) {
/*  351 */       return 0;
/*      */     }
/*  353 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addRow(HSSFRow paramHSSFRow, boolean paramBoolean) {
/*  363 */     this._rows.put(Integer.valueOf(paramHSSFRow.getRowNum()), paramHSSFRow);
/*  364 */     if (paramBoolean) {
/*  365 */       this._sheet.addRow(paramHSSFRow.getRowRecord());
/*      */     }
/*  367 */     boolean bool = (this._rows.size() == 1) ? true : false;
/*  368 */     if (paramHSSFRow.getRowNum() > getLastRowNum() || bool) {
/*  369 */       this._lastrow = paramHSSFRow.getRowNum();
/*      */     }
/*  371 */     if (paramHSSFRow.getRowNum() < getFirstRowNum() || bool) {
/*  372 */       this._firstrow = paramHSSFRow.getRowNum();
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
/*      */   public HSSFRow getRow(int paramInt) {
/*  385 */     return this._rows.get(Integer.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPhysicalNumberOfRows() {
/*  393 */     return this._rows.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFirstRowNum() {
/*  403 */     return this._firstrow;
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
/*      */   public int getLastRowNum() {
/*  421 */     return this._lastrow;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<HSSFDataValidation> getDataValidations() {
/*  426 */     DataValidityTable dataValidityTable = this._sheet.getOrCreateDataValidityTable();
/*  427 */     final ArrayList<HSSFDataValidation> hssfValidations = new ArrayList();
/*  428 */     RecordAggregate.RecordVisitor recordVisitor = new RecordAggregate.RecordVisitor() {
/*  429 */         private HSSFEvaluationWorkbook book = HSSFEvaluationWorkbook.create(HSSFSheet.this.getWorkbook());
/*      */ 
/*      */         
/*      */         public void visitRecord(Record param1Record) {
/*  433 */           if (!(param1Record instanceof DVRecord)) {
/*      */             return;
/*      */           }
/*  436 */           DVRecord dVRecord = (DVRecord)param1Record;
/*  437 */           CellRangeAddressList cellRangeAddressList = dVRecord.getCellRangeAddress().copy();
/*  438 */           DVConstraint dVConstraint = DVConstraint.createDVConstraint(dVRecord, this.book);
/*  439 */           HSSFDataValidation hSSFDataValidation = new HSSFDataValidation(cellRangeAddressList, dVConstraint);
/*  440 */           hSSFDataValidation.setErrorStyle(dVRecord.getErrorStyle());
/*  441 */           hSSFDataValidation.setEmptyCellAllowed(dVRecord.getEmptyCellAllowed());
/*  442 */           hSSFDataValidation.setSuppressDropDownArrow(dVRecord.getSuppressDropdownArrow());
/*  443 */           hSSFDataValidation.createPromptBox(dVRecord.getPromptTitle(), dVRecord.getPromptText());
/*  444 */           hSSFDataValidation.setShowPromptBox(dVRecord.getShowPromptOnCellSelected());
/*  445 */           hSSFDataValidation.createErrorBox(dVRecord.getErrorTitle(), dVRecord.getErrorText());
/*  446 */           hSSFDataValidation.setShowErrorBox(dVRecord.getShowErrorOnInvalidValue());
/*  447 */           hssfValidations.add(hSSFDataValidation);
/*      */         }
/*      */       };
/*  450 */     dataValidityTable.visitContainedRecords(recordVisitor);
/*  451 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addValidationData(DataValidation paramDataValidation) {
/*  461 */     if (paramDataValidation == null) {
/*  462 */       throw new IllegalArgumentException("objValidation must not be null");
/*      */     }
/*  464 */     HSSFDataValidation hSSFDataValidation = (HSSFDataValidation)paramDataValidation;
/*  465 */     DataValidityTable dataValidityTable = this._sheet.getOrCreateDataValidityTable();
/*      */     
/*  467 */     DVRecord dVRecord = hSSFDataValidation.createDVRecord(this);
/*  468 */     dataValidityTable.addDataValidation(dVRecord);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setColumnHidden(int paramInt, boolean paramBoolean) {
/*  479 */     this._sheet.setColumnHidden(paramInt, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isColumnHidden(int paramInt) {
/*  490 */     return this._sheet.isColumnHidden(paramInt);
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
/*      */   public void setColumnWidth(int paramInt1, int paramInt2) {
/*  533 */     this._sheet.setColumnWidth(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getColumnWidth(int paramInt) {
/*  544 */     return this._sheet.getColumnWidth(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getColumnWidthInPixels(int paramInt) {
/*  549 */     int i = getColumnWidth(paramInt);
/*  550 */     int j = getDefaultColumnWidth() * 256;
/*  551 */     float f = (i == j) ? 32.0F : 36.56F;
/*      */     
/*  553 */     return i / f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDefaultColumnWidth() {
/*  564 */     return this._sheet.getDefaultColumnWidth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultColumnWidth(int paramInt) {
/*  575 */     this._sheet.setDefaultColumnWidth(paramInt);
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
/*      */   public short getDefaultRowHeight() {
/*  587 */     return this._sheet.getDefaultRowHeight();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getDefaultRowHeightInPoints() {
/*  598 */     return this._sheet.getDefaultRowHeight() / 20.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultRowHeight(short paramShort) {
/*  609 */     this._sheet.setDefaultRowHeight(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultRowHeightInPoints(float paramFloat) {
/*  620 */     this._sheet.setDefaultRowHeight((short)(int)(paramFloat * 20.0F));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFCellStyle getColumnStyle(int paramInt) {
/*  630 */     short s = this._sheet.getXFIndexForColAt((short)paramInt);
/*      */     
/*  632 */     if (s == 15)
/*      */     {
/*  634 */       return null;
/*      */     }
/*      */     
/*  637 */     ExtendedFormatRecord extendedFormatRecord = this._book.getExFormatAt(s);
/*  638 */     return new HSSFCellStyle(s, extendedFormatRecord, this._book);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isGridsPrinted() {
/*  647 */     return this._sheet.isGridsPrinted();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGridsPrinted(boolean paramBoolean) {
/*  656 */     this._sheet.setGridsPrinted(paramBoolean);
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
/*      */   public int addMergedRegion(CellRangeAddress paramCellRangeAddress) {
/*  670 */     return addMergedRegion(paramCellRangeAddress, true);
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
/*      */   public int addMergedRegionUnsafe(CellRangeAddress paramCellRangeAddress) {
/*  688 */     return addMergedRegion(paramCellRangeAddress, false);
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
/*      */   public void validateMergedRegions() {
/*  700 */     checkForMergedRegionsIntersectingArrayFormulas();
/*  701 */     checkForIntersectingMergedRegions();
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
/*      */   private int addMergedRegion(CellRangeAddress paramCellRangeAddress, boolean paramBoolean) {
/*  715 */     if (paramCellRangeAddress.getNumberOfCells() < 2) {
/*  716 */       throw new IllegalArgumentException("Merged region " + paramCellRangeAddress.formatAsString() + " must contain 2 or more cells");
/*      */     }
/*  718 */     paramCellRangeAddress.validate(SpreadsheetVersion.EXCEL97);
/*      */     
/*  720 */     if (paramBoolean) {
/*      */ 
/*      */       
/*  723 */       validateArrayFormulas(paramCellRangeAddress);
/*      */ 
/*      */ 
/*      */       
/*  727 */       validateMergedRegions(paramCellRangeAddress);
/*      */     } 
/*      */     
/*  730 */     return this._sheet.addMergedRegion(paramCellRangeAddress.getFirstRow(), paramCellRangeAddress.getFirstColumn(), paramCellRangeAddress.getLastRow(), paramCellRangeAddress.getLastColumn());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void validateArrayFormulas(CellRangeAddress paramCellRangeAddress) {
/*  739 */     int i = paramCellRangeAddress.getFirstRow();
/*  740 */     int j = paramCellRangeAddress.getFirstColumn();
/*  741 */     int k = paramCellRangeAddress.getLastRow();
/*  742 */     int m = paramCellRangeAddress.getLastColumn();
/*  743 */     for (int n = i; n <= k; n++) {
/*  744 */       HSSFRow hSSFRow = getRow(n);
/*  745 */       if (hSSFRow != null)
/*      */       {
/*  747 */         for (int i1 = j; i1 <= m; i1++) {
/*  748 */           HSSFCell hSSFCell = hSSFRow.getCell(i1);
/*  749 */           if (hSSFCell != null)
/*      */           {
/*  751 */             if (hSSFCell.isPartOfArrayFormulaGroup()) {
/*  752 */               CellRangeAddress cellRangeAddress = hSSFCell.getArrayFormulaRange();
/*  753 */               if (cellRangeAddress.getNumberOfCells() > 1 && paramCellRangeAddress.intersects((CellRangeAddressBase)cellRangeAddress)) {
/*  754 */                 String str = "The range " + paramCellRangeAddress.formatAsString() + " intersects with a multi-cell array formula. " + "You cannot merge cells of an array.";
/*      */                 
/*  756 */                 throw new IllegalStateException(str);
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkForMergedRegionsIntersectingArrayFormulas() {
/*  770 */     for (CellRangeAddress cellRangeAddress : getMergedRegions()) {
/*  771 */       validateArrayFormulas(cellRangeAddress);
/*      */     }
/*      */   }
/*      */   
/*      */   private void validateMergedRegions(CellRangeAddress paramCellRangeAddress) {
/*  776 */     for (CellRangeAddress cellRangeAddress : getMergedRegions()) {
/*  777 */       if (cellRangeAddress.intersects((CellRangeAddressBase)paramCellRangeAddress)) {
/*  778 */         throw new IllegalStateException("Cannot add merged region " + paramCellRangeAddress.formatAsString() + " to sheet because it overlaps with an existing merged region (" + cellRangeAddress.formatAsString() + ").");
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
/*      */   private void checkForIntersectingMergedRegions() {
/*  790 */     List<CellRangeAddress> list = getMergedRegions();
/*  791 */     int i = list.size();
/*  792 */     for (byte b = 0; b < i; b++) {
/*  793 */       CellRangeAddress cellRangeAddress = list.get(b);
/*  794 */       for (CellRangeAddress cellRangeAddress1 : list.subList(b + 1, list.size())) {
/*  795 */         if (cellRangeAddress.intersects((CellRangeAddressBase)cellRangeAddress1)) {
/*  796 */           String str = "The range " + cellRangeAddress.formatAsString() + " intersects with another merged region " + cellRangeAddress1.formatAsString() + " in this sheet";
/*      */ 
/*      */           
/*  799 */           throw new IllegalStateException(str);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForceFormulaRecalculation(boolean paramBoolean) {
/*  823 */     this._sheet.setUncalced(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getForceFormulaRecalculation() {
/*  834 */     return this._sheet.getUncalced();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVerticallyCenter(boolean paramBoolean) {
/*  845 */     this._sheet.getPageSettings().getVCenter().setVCenter(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getVerticallyCenter() {
/*  853 */     return this._sheet.getPageSettings().getVCenter().getVCenter();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHorizontallyCenter(boolean paramBoolean) {
/*  863 */     this._sheet.getPageSettings().getHCenter().setHCenter(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getHorizontallyCenter() {
/*  871 */     return this._sheet.getPageSettings().getHCenter().getHCenter();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRightToLeft(boolean paramBoolean) {
/*  881 */     this._sheet.getWindowTwo().setArabic(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRightToLeft() {
/*  891 */     return this._sheet.getWindowTwo().getArabic();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMergedRegion(int paramInt) {
/*  901 */     this._sheet.removeMergedRegion(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMergedRegions(Collection<Integer> paramCollection) {
/*  911 */     for (Iterator<Integer> iterator = (new TreeSet(paramCollection)).descendingSet().iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  912 */       this._sheet.removeMergedRegion(i); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumMergedRegions() {
/*  923 */     return this._sheet.getNumMergedRegions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CellRangeAddress getMergedRegion(int paramInt) {
/*  931 */     return this._sheet.getMergedRegionAt(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<CellRangeAddress> getMergedRegions() {
/*  939 */     ArrayList<CellRangeAddress> arrayList = new ArrayList();
/*  940 */     int i = this._sheet.getNumMergedRegions();
/*  941 */     for (byte b = 0; b < i; b++) {
/*  942 */       arrayList.add(this._sheet.getMergedRegionAt(b));
/*      */     }
/*  944 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Row> rowIterator() {
/*  955 */     return this._rows.values().iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Row> iterator() {
/*  965 */     return rowIterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   InternalSheet getSheet() {
/*  976 */     return this._sheet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAlternativeExpression(boolean paramBoolean) {
/*  985 */     WSBoolRecord wSBoolRecord = (WSBoolRecord)this._sheet.findFirstRecordBySid((short)129);
/*      */ 
/*      */     
/*  988 */     wSBoolRecord.setAlternateExpression(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAlternativeFormula(boolean paramBoolean) {
/*  997 */     WSBoolRecord wSBoolRecord = (WSBoolRecord)this._sheet.findFirstRecordBySid((short)129);
/*      */ 
/*      */     
/* 1000 */     wSBoolRecord.setAlternateFormula(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAutobreaks(boolean paramBoolean) {
/* 1010 */     WSBoolRecord wSBoolRecord = (WSBoolRecord)this._sheet.findFirstRecordBySid((short)129);
/*      */ 
/*      */     
/* 1013 */     wSBoolRecord.setAutobreaks(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDialog(boolean paramBoolean) {
/* 1022 */     WSBoolRecord wSBoolRecord = (WSBoolRecord)this._sheet.findFirstRecordBySid((short)129);
/*      */ 
/*      */     
/* 1025 */     wSBoolRecord.setDialog(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayGuts(boolean paramBoolean) {
/* 1035 */     WSBoolRecord wSBoolRecord = (WSBoolRecord)this._sheet.findFirstRecordBySid((short)129);
/*      */ 
/*      */     
/* 1038 */     wSBoolRecord.setDisplayGuts(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFitToPage(boolean paramBoolean) {
/* 1048 */     WSBoolRecord wSBoolRecord = (WSBoolRecord)this._sheet.findFirstRecordBySid((short)129);
/*      */ 
/*      */     
/* 1051 */     wSBoolRecord.setFitToPage(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRowSumsBelow(boolean paramBoolean) {
/* 1061 */     WSBoolRecord wSBoolRecord = (WSBoolRecord)this._sheet.findFirstRecordBySid((short)129);
/*      */ 
/*      */     
/* 1064 */     wSBoolRecord.setRowSumsBelow(paramBoolean);
/*      */     
/* 1066 */     wSBoolRecord.setAlternateExpression(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRowSumsRight(boolean paramBoolean) {
/* 1076 */     WSBoolRecord wSBoolRecord = (WSBoolRecord)this._sheet.findFirstRecordBySid((short)129);
/*      */ 
/*      */     
/* 1079 */     wSBoolRecord.setRowSumsRight(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAlternateExpression() {
/* 1088 */     return ((WSBoolRecord)this._sheet.findFirstRecordBySid((short)129)).getAlternateExpression();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAlternateFormula() {
/* 1098 */     return ((WSBoolRecord)this._sheet.findFirstRecordBySid((short)129)).getAlternateFormula();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAutobreaks() {
/* 1109 */     return ((WSBoolRecord)this._sheet.findFirstRecordBySid((short)129)).getAutobreaks();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDialog() {
/* 1119 */     return ((WSBoolRecord)this._sheet.findFirstRecordBySid((short)129)).getDialog();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisplayGuts() {
/* 1130 */     return ((WSBoolRecord)this._sheet.findFirstRecordBySid((short)129)).getDisplayGuts();
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
/*      */   public boolean isDisplayZeros() {
/* 1146 */     return this._sheet.getWindowTwo().getDisplayZeros();
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
/*      */   public void setDisplayZeros(boolean paramBoolean) {
/* 1160 */     this._sheet.getWindowTwo().setDisplayZeros(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getFitToPage() {
/* 1170 */     return ((WSBoolRecord)this._sheet.findFirstRecordBySid((short)129)).getFitToPage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getRowSumsBelow() {
/* 1181 */     return ((WSBoolRecord)this._sheet.findFirstRecordBySid((short)129)).getRowSumsBelow();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getRowSumsRight() {
/* 1192 */     return ((WSBoolRecord)this._sheet.findFirstRecordBySid((short)129)).getRowSumsRight();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPrintGridlines() {
/* 1203 */     return getSheet().getPrintGridlines().getPrintGridlines();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrintGridlines(boolean paramBoolean) {
/* 1214 */     getSheet().getPrintGridlines().setPrintGridlines(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPrintRowAndColumnHeadings() {
/* 1224 */     return getSheet().getPrintHeaders().getPrintHeaders();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrintRowAndColumnHeadings(boolean paramBoolean) {
/* 1235 */     getSheet().getPrintHeaders().setPrintHeaders(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFPrintSetup getPrintSetup() {
/* 1245 */     return new HSSFPrintSetup(this._sheet.getPageSettings().getPrintSetup());
/*      */   }
/*      */ 
/*      */   
/*      */   public HSSFHeader getHeader() {
/* 1250 */     return new HSSFHeader(this._sheet.getPageSettings());
/*      */   }
/*      */ 
/*      */   
/*      */   public HSSFFooter getFooter() {
/* 1255 */     return new HSSFFooter(this._sheet.getPageSettings());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSelected() {
/* 1265 */     return getSheet().getWindowTwo().getSelected();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSelected(boolean paramBoolean) {
/* 1275 */     getSheet().getWindowTwo().setSelected(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isActive() {
/* 1282 */     return getSheet().getWindowTwo().isActive();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActive(boolean paramBoolean) {
/* 1291 */     getSheet().getWindowTwo().setActive(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getMargin(short paramShort) {
/* 1302 */     switch (paramShort) {
/*      */       case 5:
/* 1304 */         return this._sheet.getPageSettings().getPrintSetup().getFooterMargin();
/*      */       case 4:
/* 1306 */         return this._sheet.getPageSettings().getPrintSetup().getHeaderMargin();
/*      */     } 
/* 1308 */     return this._sheet.getPageSettings().getMargin(paramShort);
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
/*      */   public void setMargin(short paramShort, double paramDouble) {
/* 1320 */     switch (paramShort) {
/*      */       case 5:
/* 1322 */         this._sheet.getPageSettings().getPrintSetup().setFooterMargin(paramDouble);
/*      */         return;
/*      */       case 4:
/* 1325 */         this._sheet.getPageSettings().getPrintSetup().setHeaderMargin(paramDouble);
/*      */         return;
/*      */     } 
/* 1328 */     this._sheet.getPageSettings().setMargin(paramShort, paramDouble);
/*      */   }
/*      */ 
/*      */   
/*      */   private WorksheetProtectionBlock getProtectionBlock() {
/* 1333 */     return this._sheet.getProtectionBlock();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getProtect() {
/* 1343 */     return getProtectionBlock().isSheetProtected();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getPassword() {
/* 1350 */     return (short)getProtectionBlock().getPasswordHash();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getObjectProtect() {
/* 1359 */     return getProtectionBlock().isObjectProtected();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getScenarioProtect() {
/* 1369 */     return getProtectionBlock().isScenarioProtected();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void protectSheet(String paramString) {
/* 1379 */     getProtectionBlock().protectSheet(paramString, true, true);
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
/*      */   public void setZoom(int paramInt1, int paramInt2) {
/* 1392 */     if (paramInt1 < 1 || paramInt1 > 65535)
/* 1393 */       throw new IllegalArgumentException("Numerator must be greater than 0 and less than 65536"); 
/* 1394 */     if (paramInt2 < 1 || paramInt2 > 65535) {
/* 1395 */       throw new IllegalArgumentException("Denominator must be greater than 0 and less than 65536");
/*      */     }
/* 1397 */     SCLRecord sCLRecord = new SCLRecord();
/* 1398 */     sCLRecord.setNumerator((short)paramInt1);
/* 1399 */     sCLRecord.setDenominator((short)paramInt2);
/* 1400 */     getSheet().setSCLRecord(sCLRecord);
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
/*      */   
/*      */   public void setZoom(int paramInt) {
/* 1422 */     setZoom(paramInt, 100);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getTopRow() {
/* 1433 */     return this._sheet.getTopRow();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getLeftCol() {
/* 1444 */     return this._sheet.getLeftCol();
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
/*      */   public void showInPane(int paramInt1, int paramInt2) {
/* 1456 */     int i = SpreadsheetVersion.EXCEL97.getLastRowIndex();
/* 1457 */     if (paramInt1 > i) throw new IllegalArgumentException("Maximum row number is " + i);
/*      */     
/* 1459 */     showInPane((short)paramInt1, (short)paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void showInPane(short paramShort1, short paramShort2) {
/* 1469 */     this._sheet.setTopRow(paramShort1);
/* 1470 */     this._sheet.setLeftCol(paramShort2);
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
/*      */   protected void shiftMerged(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 1483 */     HSSFRowShifter hSSFRowShifter = new HSSFRowShifter(this);
/* 1484 */     hSSFRowShifter.shiftMergedRegions(paramInt1, paramInt2, paramInt3);
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
/*      */   public void shiftRows(int paramInt1, int paramInt2, int paramInt3) {
/* 1503 */     shiftRows(paramInt1, paramInt2, paramInt3, false, false);
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
/*      */   
/*      */   public void shiftRows(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
/* 1525 */     shiftRows(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int clip(int paramInt) {
/* 1534 */     return Math.min(Math.max(0, paramInt), SpreadsheetVersion.EXCEL97.getLastRowIndex());
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
/*      */ 
/*      */   
/*      */   public void shiftRows(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*      */     int i;
/*      */     byte b;
/* 1559 */     if (paramInt2 < paramInt1) {
/* 1560 */       throw new IllegalArgumentException("startRow must be less than or equal to endRow. To shift rows up, use n<0.");
/*      */     }
/* 1562 */     if (paramInt3 < 0) {
/* 1563 */       i = paramInt1;
/* 1564 */       b = 1;
/* 1565 */     } else if (paramInt3 > 0) {
/* 1566 */       i = paramInt2;
/* 1567 */       b = -1;
/*      */     } else {
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/* 1573 */     HSSFRowShifter hSSFRowShifter = new HSSFRowShifter(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1582 */     if (paramBoolean3) {
/* 1583 */       HSSFPatriarch hSSFPatriarch = createDrawingPatriarch();
/* 1584 */       for (HSSFShape hSSFShape : hSSFPatriarch.getChildren()) {
/* 1585 */         if (!(hSSFShape instanceof HSSFComment)) {
/*      */           continue;
/*      */         }
/* 1588 */         HSSFComment hSSFComment = (HSSFComment)hSSFShape;
/* 1589 */         int i1 = hSSFComment.getRow();
/* 1590 */         if (paramInt1 <= i1 && i1 <= paramInt2) {
/* 1591 */           hSSFComment.setRow(clip(i1 + paramInt3));
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1597 */     hSSFRowShifter.shiftMergedRegions(paramInt1, paramInt2, paramInt3);
/*      */ 
/*      */     
/* 1600 */     this._sheet.getPageSettings().shiftRowBreaks(paramInt1, paramInt2, paramInt3);
/*      */ 
/*      */     
/* 1603 */     int j = paramInt1 + paramInt3;
/* 1604 */     int k = paramInt2 + paramInt3;
/* 1605 */     for (HSSFHyperlink hSSFHyperlink : getHyperlinkList()) {
/*      */       
/* 1607 */       int i1 = hSSFHyperlink.getFirstRow();
/* 1608 */       int i2 = hSSFHyperlink.getLastRow();
/* 1609 */       if (j <= i1 && i1 <= k && k <= i2 && i2 <= k)
/*      */       {
/* 1611 */         removeHyperlink(hSSFHyperlink);
/*      */       }
/*      */     } 
/*      */     int m;
/* 1615 */     for (m = i; m >= paramInt1 && m <= paramInt2 && m >= 0 && m < 65536; m += b) {
/* 1616 */       HSSFRow hSSFRow1 = getRow(m);
/*      */ 
/*      */ 
/*      */       
/* 1620 */       if (hSSFRow1 != null) notifyRowShifting(hSSFRow1);
/*      */       
/* 1622 */       HSSFRow hSSFRow2 = getRow(m + paramInt3);
/* 1623 */       if (hSSFRow2 == null) {
/* 1624 */         hSSFRow2 = createRow(m + paramInt3);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1632 */       hSSFRow2.removeAllCells();
/*      */ 
/*      */ 
/*      */       
/* 1636 */       if (hSSFRow1 != null) {
/*      */ 
/*      */         
/* 1639 */         if (paramBoolean1) {
/* 1640 */           hSSFRow2.setHeight(hSSFRow1.getHeight());
/*      */         }
/* 1642 */         if (paramBoolean2) {
/* 1643 */           hSSFRow1.setHeight((short)255);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1648 */         for (Iterator<Cell> iterator = hSSFRow1.cellIterator(); iterator.hasNext(); ) {
/* 1649 */           HSSFCell hSSFCell = (HSSFCell)iterator.next();
/* 1650 */           HSSFHyperlink hSSFHyperlink = hSSFCell.getHyperlink();
/* 1651 */           hSSFRow1.removeCell(hSSFCell);
/* 1652 */           CellValueRecordInterface cellValueRecordInterface = hSSFCell.getCellValueRecord();
/* 1653 */           cellValueRecordInterface.setRow(m + paramInt3);
/* 1654 */           hSSFRow2.createCellFromRecord(cellValueRecordInterface);
/* 1655 */           this._sheet.addValueRecord(m + paramInt3, cellValueRecordInterface);
/*      */           
/* 1657 */           if (hSSFHyperlink != null) {
/* 1658 */             hSSFHyperlink.setFirstRow(hSSFHyperlink.getFirstRow() + paramInt3);
/* 1659 */             hSSFHyperlink.setLastRow(hSSFHyperlink.getLastRow() + paramInt3);
/*      */           } 
/*      */         } 
/*      */         
/* 1663 */         hSSFRow1.removeAllCells();
/*      */       } 
/*      */     } 
/*      */     
/* 1667 */     if (paramInt3 > 0) {
/*      */       
/* 1669 */       if (paramInt1 == this._firstrow) {
/*      */         
/* 1671 */         this._firstrow = Math.max(paramInt1 + paramInt3, 0);
/* 1672 */         for (m = paramInt1 + 1; m < paramInt1 + paramInt3; m++) {
/* 1673 */           if (getRow(m) != null) {
/* 1674 */             this._firstrow = m;
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/* 1679 */       if (paramInt2 + paramInt3 > this._lastrow) {
/* 1680 */         this._lastrow = Math.min(paramInt2 + paramInt3, SpreadsheetVersion.EXCEL97.getLastRowIndex());
/*      */       }
/*      */     } else {
/*      */       
/* 1684 */       if (paramInt1 + paramInt3 < this._firstrow) {
/* 1685 */         this._firstrow = Math.max(paramInt1 + paramInt3, 0);
/*      */       }
/* 1687 */       if (paramInt2 == this._lastrow) {
/*      */         
/* 1689 */         this._lastrow = Math.min(paramInt2 + paramInt3, SpreadsheetVersion.EXCEL97.getLastRowIndex());
/* 1690 */         for (m = paramInt2 - 1; m > paramInt2 + paramInt3; m++) {
/* 1691 */           if (getRow(m) != null) {
/* 1692 */             this._lastrow = m;
/*      */ 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1701 */     m = this._workbook.getSheetIndex(this);
/* 1702 */     String str = this._workbook.getSheetName(m);
/* 1703 */     short s = this._book.checkExternSheet(m);
/* 1704 */     FormulaShifter formulaShifter = FormulaShifter.createForRowShift(s, str, paramInt1, paramInt2, paramInt3, SpreadsheetVersion.EXCEL97);
/*      */     
/* 1706 */     this._sheet.updateFormulasAfterCellShift(formulaShifter, s);
/*      */     
/* 1708 */     int n = this._workbook.getNumberOfSheets();
/* 1709 */     for (byte b1 = 0; b1 < n; b1++) {
/* 1710 */       InternalSheet internalSheet = this._workbook.getSheetAt(b1).getSheet();
/* 1711 */       if (internalSheet != this._sheet) {
/*      */ 
/*      */         
/* 1714 */         short s1 = this._book.checkExternSheet(b1);
/* 1715 */         internalSheet.updateFormulasAfterCellShift(formulaShifter, s1);
/*      */       } 
/* 1717 */     }  this._workbook.getWorkbook().updateNamesAfterCellShift(formulaShifter);
/*      */   }
/*      */   
/*      */   protected void insertChartRecords(List<Record> paramList) {
/* 1721 */     int i = this._sheet.findFirstRecordLocBySid((short)574);
/* 1722 */     this._sheet.getRecords().addAll(i, paramList);
/*      */   }
/*      */   
/*      */   private void notifyRowShifting(HSSFRow paramHSSFRow) {
/* 1726 */     String str = "Row[rownum=" + paramHSSFRow.getRowNum() + "] contains cell(s) included in a multi-cell array formula. " + "You cannot change part of an array.";
/*      */     
/* 1728 */     for (Cell cell : paramHSSFRow) {
/* 1729 */       HSSFCell hSSFCell = (HSSFCell)cell;
/* 1730 */       if (hSSFCell.isPartOfArrayFormulaGroup()) {
/* 1731 */         hSSFCell.notifyArrayFormulaChanging(str);
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
/*      */   public void createFreezePane(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1748 */     validateColumn(paramInt1);
/* 1749 */     validateRow(paramInt2);
/* 1750 */     if (paramInt3 < paramInt1)
/* 1751 */       throw new IllegalArgumentException("leftmostColumn parameter must not be less than colSplit parameter"); 
/* 1752 */     if (paramInt4 < paramInt2)
/* 1753 */       throw new IllegalArgumentException("topRow parameter must not be less than leftmostColumn parameter"); 
/* 1754 */     getSheet().createFreezePane(paramInt1, paramInt2, paramInt4, paramInt3);
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
/*      */   public void createFreezePane(int paramInt1, int paramInt2) {
/* 1767 */     createFreezePane(paramInt1, paramInt2, paramInt1, paramInt2);
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
/*      */   public void createSplitPane(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1786 */     getSheet().createSplitPane(paramInt1, paramInt2, paramInt4, paramInt3, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PaneInformation getPaneInformation() {
/* 1796 */     return getSheet().getPaneInformation();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayGridlines(boolean paramBoolean) {
/* 1806 */     this._sheet.setDisplayGridlines(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisplayGridlines() {
/* 1816 */     return this._sheet.isDisplayGridlines();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayFormulas(boolean paramBoolean) {
/* 1826 */     this._sheet.setDisplayFormulas(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisplayFormulas() {
/* 1836 */     return this._sheet.isDisplayFormulas();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayRowColHeadings(boolean paramBoolean) {
/* 1846 */     this._sheet.setDisplayRowColHeadings(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisplayRowColHeadings() {
/* 1856 */     return this._sheet.isDisplayRowColHeadings();
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
/*      */   public void setRowBreak(int paramInt) {
/* 1872 */     validateRow(paramInt);
/* 1873 */     this._sheet.getPageSettings().setRowBreak(paramInt, (short)0, (short)255);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRowBroken(int paramInt) {
/* 1881 */     return this._sheet.getPageSettings().isRowBroken(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeRowBreak(int paramInt) {
/* 1889 */     this._sheet.getPageSettings().removeRowBreak(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] getRowBreaks() {
/* 1898 */     return this._sheet.getPageSettings().getRowBreaks();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] getColumnBreaks() {
/* 1907 */     return this._sheet.getPageSettings().getColumnBreaks();
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
/*      */   public void setColumnBreak(int paramInt) {
/* 1924 */     validateColumn((short)paramInt);
/* 1925 */     this._sheet.getPageSettings().setColumnBreak((short)paramInt, (short)0, (short)SpreadsheetVersion.EXCEL97.getLastRowIndex());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isColumnBroken(int paramInt) {
/* 1936 */     return this._sheet.getPageSettings().isColumnBroken(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeColumnBreak(int paramInt) {
/* 1946 */     this._sheet.getPageSettings().removeColumnBreak(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void validateRow(int paramInt) {
/* 1955 */     int i = SpreadsheetVersion.EXCEL97.getLastRowIndex();
/* 1956 */     if (paramInt > i) throw new IllegalArgumentException("Maximum row number is " + i); 
/* 1957 */     if (paramInt < 0) throw new IllegalArgumentException("Minumum row number is 0");
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void validateColumn(int paramInt) {
/* 1966 */     int i = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
/* 1967 */     if (paramInt > i) throw new IllegalArgumentException("Maximum column number is " + i); 
/* 1968 */     if (paramInt < 0) throw new IllegalArgumentException("Minimum column number is 0");
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void dumpDrawingRecords(boolean paramBoolean, PrintWriter paramPrintWriter) {
/* 1976 */     this._sheet.aggregateDrawingRecords(this._book.getDrawingManager(), false);
/*      */     
/* 1978 */     EscherAggregate escherAggregate = (EscherAggregate)getSheet().findFirstRecordBySid((short)9876);
/* 1979 */     List list = escherAggregate.getEscherRecords();
/* 1980 */     for (EscherRecord escherRecord : list) {
/* 1981 */       if (paramBoolean) {
/* 1982 */         paramPrintWriter.println(escherRecord.toString()); continue;
/*      */       } 
/* 1984 */       escherRecord.display(paramPrintWriter, 0);
/*      */     } 
/*      */     
/* 1987 */     paramPrintWriter.flush();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EscherAggregate getDrawingEscherAggregate() {
/* 1995 */     this._book.findDrawingGroup();
/*      */ 
/*      */ 
/*      */     
/* 1999 */     if (this._book.getDrawingManager() == null) {
/* 2000 */       return null;
/*      */     }
/*      */     
/* 2003 */     int i = this._sheet.aggregateDrawingRecords(this._book.getDrawingManager(), false);
/*      */ 
/*      */     
/* 2006 */     if (i == -1)
/*      */     {
/* 2008 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 2012 */     return (EscherAggregate)this._sheet.findFirstRecordBySid((short)9876);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFPatriarch getDrawingPatriarch() {
/* 2022 */     this._patriarch = getPatriarch(false);
/* 2023 */     return this._patriarch;
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
/*      */   public HSSFPatriarch createDrawingPatriarch() {
/* 2036 */     this._patriarch = getPatriarch(true);
/* 2037 */     return this._patriarch;
/*      */   }
/*      */   
/*      */   private HSSFPatriarch getPatriarch(boolean paramBoolean) {
/* 2041 */     if (this._patriarch != null) {
/* 2042 */       return this._patriarch;
/*      */     }
/* 2044 */     DrawingManager2 drawingManager2 = this._book.findDrawingGroup();
/* 2045 */     if (null == drawingManager2) {
/* 2046 */       if (!paramBoolean) {
/* 2047 */         return null;
/*      */       }
/* 2049 */       this._book.createDrawingGroup();
/* 2050 */       drawingManager2 = this._book.getDrawingManager();
/*      */     } 
/*      */     
/* 2053 */     EscherAggregate escherAggregate = (EscherAggregate)this._sheet.findFirstRecordBySid((short)9876);
/* 2054 */     if (null == escherAggregate) {
/* 2055 */       int i = this._sheet.aggregateDrawingRecords(drawingManager2, false);
/* 2056 */       if (-1 == i) {
/* 2057 */         if (paramBoolean) {
/* 2058 */           i = this._sheet.aggregateDrawingRecords(drawingManager2, true);
/* 2059 */           escherAggregate = this._sheet.getRecords().get(i);
/* 2060 */           HSSFPatriarch hSSFPatriarch = new HSSFPatriarch(this, escherAggregate);
/* 2061 */           hSSFPatriarch.afterCreate();
/* 2062 */           return hSSFPatriarch;
/*      */         } 
/* 2064 */         return null;
/*      */       } 
/*      */       
/* 2067 */       escherAggregate = this._sheet.getRecords().get(i);
/*      */     } 
/* 2069 */     return new HSSFPatriarch(this, escherAggregate);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setColumnGroupCollapsed(int paramInt, boolean paramBoolean) {
/* 2080 */     this._sheet.setColumnGroupCollapsed(paramInt, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void groupColumn(int paramInt1, int paramInt2) {
/* 2091 */     this._sheet.groupColumnRange(paramInt1, paramInt2, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void ungroupColumn(int paramInt1, int paramInt2) {
/* 2096 */     this._sheet.groupColumnRange(paramInt1, paramInt2, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void groupRow(int paramInt1, int paramInt2) {
/* 2107 */     this._sheet.groupRowRange(paramInt1, paramInt2, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void ungroupRow(int paramInt1, int paramInt2) {
/* 2112 */     this._sheet.groupRowRange(paramInt1, paramInt2, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRowGroupCollapsed(int paramInt, boolean paramBoolean) {
/* 2117 */     if (paramBoolean) {
/* 2118 */       this._sheet.getRowsAggregate().collapseRow(paramInt);
/*      */     } else {
/* 2120 */       this._sheet.getRowsAggregate().expandRow(paramInt);
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
/*      */   public void setDefaultColumnStyle(int paramInt, CellStyle paramCellStyle) {
/* 2132 */     this._sheet.setDefaultColumnStyle(paramInt, ((HSSFCellStyle)paramCellStyle).getIndex());
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
/*      */   public void autoSizeColumn(int paramInt) {
/* 2146 */     autoSizeColumn(paramInt, false);
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
/*      */   public void autoSizeColumn(int paramInt, boolean paramBoolean) {
/* 2164 */     double d = SheetUtil.getColumnWidth(this, paramInt, paramBoolean);
/*      */     
/* 2166 */     if (d != -1.0D) {
/* 2167 */       d *= 256.0D;
/* 2168 */       char c = '＀';
/* 2169 */       if (d > c) {
/* 2170 */         d = c;
/*      */       }
/* 2172 */       setColumnWidth(paramInt, (int)d);
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
/*      */   public HSSFComment getCellComment(int paramInt1, int paramInt2) {
/* 2185 */     return findCellComment(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFComment getCellComment(CellAddress paramCellAddress) {
/* 2195 */     return findCellComment(paramCellAddress.getRow(), paramCellAddress.getColumn());
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
/*      */   public HSSFHyperlink getHyperlink(int paramInt1, int paramInt2) {
/* 2207 */     for (RecordBase recordBase : this._sheet.getRecords()) {
/* 2208 */       if (recordBase instanceof HyperlinkRecord) {
/* 2209 */         HyperlinkRecord hyperlinkRecord = (HyperlinkRecord)recordBase;
/* 2210 */         if (hyperlinkRecord.getFirstColumn() == paramInt2 && hyperlinkRecord.getFirstRow() == paramInt1) {
/* 2211 */           return new HSSFHyperlink(hyperlinkRecord);
/*      */         }
/*      */       } 
/*      */     } 
/* 2215 */     return null;
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
/*      */   public HSSFHyperlink getHyperlink(CellAddress paramCellAddress) {
/* 2227 */     return getHyperlink(paramCellAddress.getRow(), paramCellAddress.getColumn());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<HSSFHyperlink> getHyperlinkList() {
/* 2237 */     ArrayList<HSSFHyperlink> arrayList = new ArrayList();
/* 2238 */     for (RecordBase recordBase : this._sheet.getRecords()) {
/* 2239 */       if (recordBase instanceof HyperlinkRecord) {
/* 2240 */         HyperlinkRecord hyperlinkRecord = (HyperlinkRecord)recordBase;
/* 2241 */         arrayList.add(new HSSFHyperlink(hyperlinkRecord));
/*      */       } 
/*      */     } 
/* 2244 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removeHyperlink(HSSFHyperlink paramHSSFHyperlink) {
/* 2254 */     removeHyperlink(paramHSSFHyperlink.record);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removeHyperlink(HyperlinkRecord paramHyperlinkRecord) {
/* 2263 */     for (Iterator<RecordBase> iterator = this._sheet.getRecords().iterator(); iterator.hasNext(); ) {
/* 2264 */       RecordBase recordBase = iterator.next();
/* 2265 */       if (recordBase instanceof HyperlinkRecord) {
/* 2266 */         HyperlinkRecord hyperlinkRecord = (HyperlinkRecord)recordBase;
/* 2267 */         if (paramHyperlinkRecord == hyperlinkRecord) {
/* 2268 */           iterator.remove();
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFSheetConditionalFormatting getSheetConditionalFormatting() {
/* 2278 */     return new HSSFSheetConditionalFormatting(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSheetName() {
/* 2289 */     HSSFWorkbook hSSFWorkbook = getWorkbook();
/* 2290 */     int i = hSSFWorkbook.getSheetIndex(this);
/* 2291 */     return hSSFWorkbook.getSheetName(i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CellRange<HSSFCell> getCellRange(CellRangeAddress paramCellRangeAddress) {
/* 2298 */     int i = paramCellRangeAddress.getFirstRow();
/* 2299 */     int j = paramCellRangeAddress.getFirstColumn();
/* 2300 */     int k = paramCellRangeAddress.getLastRow();
/* 2301 */     int m = paramCellRangeAddress.getLastColumn();
/* 2302 */     int n = k - i + 1;
/* 2303 */     int i1 = m - j + 1;
/* 2304 */     ArrayList<HSSFCell> arrayList = new ArrayList(n * i1);
/* 2305 */     for (int i2 = i; i2 <= k; i2++) {
/* 2306 */       for (int i3 = j; i3 <= m; i3++) {
/* 2307 */         HSSFRow hSSFRow = getRow(i2);
/* 2308 */         if (hSSFRow == null) {
/* 2309 */           hSSFRow = createRow(i2);
/*      */         }
/* 2311 */         HSSFCell hSSFCell = hSSFRow.getCell(i3);
/* 2312 */         if (hSSFCell == null) {
/* 2313 */           hSSFCell = hSSFRow.createCell(i3);
/*      */         }
/* 2315 */         arrayList.add(hSSFCell);
/*      */       } 
/*      */     } 
/* 2318 */     return (CellRange<HSSFCell>)SSCellRange.create(i, j, n, i1, arrayList, HSSFCell.class);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public CellRange<HSSFCell> setArrayFormula(String paramString, CellRangeAddress paramCellRangeAddress) {
/* 2324 */     int i = this._workbook.getSheetIndex(this);
/* 2325 */     Ptg[] arrayOfPtg = HSSFFormulaParser.parse(paramString, this._workbook, FormulaType.ARRAY, i);
/* 2326 */     CellRange<HSSFCell> cellRange = getCellRange(paramCellRangeAddress);
/*      */     
/* 2328 */     for (HSSFCell hSSFCell1 : cellRange) {
/* 2329 */       hSSFCell1.setCellArrayFormula(paramCellRangeAddress);
/*      */     }
/* 2331 */     HSSFCell hSSFCell = (HSSFCell)cellRange.getTopLeftCell();
/* 2332 */     FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate)hSSFCell.getCellValueRecord();
/* 2333 */     formulaRecordAggregate.setArrayFormula(paramCellRangeAddress, arrayOfPtg);
/* 2334 */     return cellRange;
/*      */   }
/*      */ 
/*      */   
/*      */   public CellRange<HSSFCell> removeArrayFormula(Cell paramCell) {
/* 2339 */     if (paramCell.getSheet() != this) {
/* 2340 */       throw new IllegalArgumentException("Specified cell does not belong to this sheet.");
/*      */     }
/* 2342 */     CellValueRecordInterface cellValueRecordInterface = ((HSSFCell)paramCell).getCellValueRecord();
/* 2343 */     if (!(cellValueRecordInterface instanceof FormulaRecordAggregate)) {
/* 2344 */       String str = (new CellReference(paramCell)).formatAsString();
/* 2345 */       throw new IllegalArgumentException("Cell " + str + " is not part of an array formula.");
/*      */     } 
/* 2347 */     FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate)cellValueRecordInterface;
/* 2348 */     CellRangeAddress cellRangeAddress = formulaRecordAggregate.removeArrayFormula(paramCell.getRowIndex(), paramCell.getColumnIndex());
/*      */     
/* 2350 */     CellRange<HSSFCell> cellRange = getCellRange(cellRangeAddress);
/*      */     
/* 2352 */     for (Cell cell : cellRange) {
/* 2353 */       cell.setCellType(CellType.BLANK);
/*      */     }
/* 2355 */     return cellRange;
/*      */   }
/*      */ 
/*      */   
/*      */   public DataValidationHelper getDataValidationHelper() {
/* 2360 */     return new HSSFDataValidationHelper(this);
/*      */   }
/*      */ 
/*      */   
/*      */   public HSSFAutoFilter setAutoFilter(CellRangeAddress paramCellRangeAddress) {
/* 2365 */     InternalWorkbook internalWorkbook = this._workbook.getWorkbook();
/* 2366 */     int i = this._workbook.getSheetIndex(this);
/*      */     
/* 2368 */     NameRecord nameRecord = internalWorkbook.getSpecificBuiltinRecord((byte)13, i + 1);
/*      */     
/* 2370 */     if (nameRecord == null) {
/* 2371 */       nameRecord = internalWorkbook.createBuiltInName((byte)13, i + 1);
/*      */     }
/*      */     
/* 2374 */     int j = paramCellRangeAddress.getFirstRow();
/*      */ 
/*      */     
/* 2377 */     if (j == -1) {
/* 2378 */       j = 0;
/*      */     }
/*      */ 
/*      */     
/* 2382 */     Area3DPtg area3DPtg = new Area3DPtg(j, paramCellRangeAddress.getLastRow(), paramCellRangeAddress.getFirstColumn(), paramCellRangeAddress.getLastColumn(), false, false, false, false, i);
/*      */ 
/*      */     
/* 2385 */     nameRecord.setNameDefinition(new Ptg[] { (Ptg)area3DPtg });
/*      */     
/* 2387 */     AutoFilterInfoRecord autoFilterInfoRecord = new AutoFilterInfoRecord();
/*      */     
/* 2389 */     int k = 1 + paramCellRangeAddress.getLastColumn() - paramCellRangeAddress.getFirstColumn();
/* 2390 */     autoFilterInfoRecord.setNumEntries((short)k);
/* 2391 */     int m = this._sheet.findFirstRecordLocBySid((short)512);
/* 2392 */     this._sheet.getRecords().add(m, autoFilterInfoRecord);
/*      */ 
/*      */     
/* 2395 */     HSSFPatriarch hSSFPatriarch = createDrawingPatriarch();
/* 2396 */     int n = paramCellRangeAddress.getFirstColumn();
/* 2397 */     int i1 = paramCellRangeAddress.getLastColumn();
/* 2398 */     for (int i2 = n; i2 <= i1; i2++) {
/* 2399 */       hSSFPatriarch.createComboBox(new HSSFClientAnchor(0, 0, 0, 0, (short)i2, j, (short)(i2 + 1), j + 1));
/*      */     }
/*      */ 
/*      */     
/* 2403 */     return new HSSFAutoFilter(this);
/*      */   }
/*      */   
/*      */   protected HSSFComment findCellComment(int paramInt1, int paramInt2) {
/* 2407 */     HSSFPatriarch hSSFPatriarch = getDrawingPatriarch();
/* 2408 */     if (null == hSSFPatriarch) {
/* 2409 */       hSSFPatriarch = createDrawingPatriarch();
/*      */     }
/* 2411 */     return lookForComment(hSSFPatriarch, paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */   private HSSFComment lookForComment(HSSFShapeContainer paramHSSFShapeContainer, int paramInt1, int paramInt2) {
/* 2415 */     for (HSSFShape hSSFShape1 : paramHSSFShapeContainer.getChildren()) {
/* 2416 */       HSSFShape hSSFShape2 = hSSFShape1;
/* 2417 */       if (hSSFShape2 instanceof HSSFShapeGroup) {
/* 2418 */         HSSFComment hSSFComment = lookForComment((HSSFShapeContainer)hSSFShape2, paramInt1, paramInt2);
/* 2419 */         if (null != hSSFComment) {
/* 2420 */           return hSSFComment;
/*      */         }
/*      */         continue;
/*      */       } 
/* 2424 */       if (hSSFShape2 instanceof HSSFComment) {
/* 2425 */         HSSFComment hSSFComment = (HSSFComment)hSSFShape2;
/* 2426 */         if (hSSFComment.hasPosition() && hSSFComment.getColumn() == paramInt2 && hSSFComment.getRow() == paramInt1) {
/* 2427 */           return hSSFComment;
/*      */         }
/*      */       } 
/*      */     } 
/* 2431 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<CellAddress, HSSFComment> getCellComments() {
/* 2441 */     HSSFPatriarch hSSFPatriarch = getDrawingPatriarch();
/* 2442 */     if (null == hSSFPatriarch) {
/* 2443 */       hSSFPatriarch = createDrawingPatriarch();
/*      */     }
/*      */     
/* 2446 */     TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
/* 2447 */     findCellCommentLocations(hSSFPatriarch, (Map)treeMap);
/* 2448 */     return (Map)treeMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void findCellCommentLocations(HSSFShapeContainer paramHSSFShapeContainer, Map<CellAddress, HSSFComment> paramMap) {
/* 2457 */     for (HSSFShape hSSFShape1 : paramHSSFShapeContainer.getChildren()) {
/* 2458 */       HSSFShape hSSFShape2 = hSSFShape1;
/* 2459 */       if (hSSFShape2 instanceof HSSFShapeGroup) {
/* 2460 */         findCellCommentLocations((HSSFShapeGroup)hSSFShape2, paramMap);
/*      */         continue;
/*      */       } 
/* 2463 */       if (hSSFShape2 instanceof HSSFComment) {
/* 2464 */         HSSFComment hSSFComment = (HSSFComment)hSSFShape2;
/* 2465 */         if (hSSFComment.hasPosition()) {
/* 2466 */           paramMap.put(new CellAddress(hSSFComment.getRow(), hSSFComment.getColumn()), hSSFComment);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public CellRangeAddress getRepeatingRows() {
/* 2474 */     return getRepeatingRowsOrColums(true);
/*      */   }
/*      */ 
/*      */   
/*      */   public CellRangeAddress getRepeatingColumns() {
/* 2479 */     return getRepeatingRowsOrColums(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRepeatingRows(CellRangeAddress paramCellRangeAddress) {
/* 2484 */     CellRangeAddress cellRangeAddress = getRepeatingColumns();
/* 2485 */     setRepeatingRowsAndColumns(paramCellRangeAddress, cellRangeAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRepeatingColumns(CellRangeAddress paramCellRangeAddress) {
/* 2490 */     CellRangeAddress cellRangeAddress = getRepeatingRows();
/* 2491 */     setRepeatingRowsAndColumns(cellRangeAddress, paramCellRangeAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setRepeatingRowsAndColumns(CellRangeAddress paramCellRangeAddress1, CellRangeAddress paramCellRangeAddress2) {
/* 2497 */     int i = this._workbook.getSheetIndex(this);
/* 2498 */     int j = SpreadsheetVersion.EXCEL97.getLastRowIndex();
/* 2499 */     int k = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
/*      */     
/* 2501 */     int m = -1;
/* 2502 */     int n = -1;
/* 2503 */     int i1 = -1;
/* 2504 */     int i2 = -1;
/*      */     
/* 2506 */     if (paramCellRangeAddress1 != null) {
/* 2507 */       i1 = paramCellRangeAddress1.getFirstRow();
/* 2508 */       i2 = paramCellRangeAddress1.getLastRow();
/* 2509 */       if ((i1 == -1 && i2 != -1) || i1 > i2 || i1 < 0 || i1 > j || i2 < 0 || i2 > j)
/*      */       {
/*      */         
/* 2512 */         throw new IllegalArgumentException("Invalid row range specification");
/*      */       }
/*      */     } 
/* 2515 */     if (paramCellRangeAddress2 != null) {
/* 2516 */       m = paramCellRangeAddress2.getFirstColumn();
/* 2517 */       n = paramCellRangeAddress2.getLastColumn();
/* 2518 */       if ((m == -1 && n != -1) || m > n || m < 0 || m > k || n < 0 || n > k)
/*      */       {
/*      */         
/* 2521 */         throw new IllegalArgumentException("Invalid column range specification");
/*      */       }
/*      */     } 
/*      */     
/* 2525 */     short s = this._workbook.getWorkbook().checkExternSheet(i);
/*      */ 
/*      */     
/* 2528 */     boolean bool1 = (paramCellRangeAddress1 != null && paramCellRangeAddress2 != null) ? true : false;
/* 2529 */     boolean bool2 = (paramCellRangeAddress1 == null && paramCellRangeAddress2 == null) ? true : false;
/*      */     
/* 2531 */     HSSFName hSSFName = this._workbook.getBuiltInName((byte)7, i);
/*      */     
/* 2533 */     if (bool2) {
/* 2534 */       if (hSSFName != null) {
/* 2535 */         this._workbook.removeName(hSSFName);
/*      */       }
/*      */       return;
/*      */     } 
/* 2539 */     if (hSSFName == null) {
/* 2540 */       hSSFName = this._workbook.createBuiltInName((byte)7, i);
/*      */     }
/*      */ 
/*      */     
/* 2544 */     ArrayList<MemFuncPtg> arrayList = new ArrayList();
/* 2545 */     if (bool1) {
/* 2546 */       byte b = 23;
/* 2547 */       arrayList.add(new MemFuncPtg(23));
/*      */     } 
/* 2549 */     if (paramCellRangeAddress2 != null) {
/* 2550 */       Area3DPtg area3DPtg = new Area3DPtg(0, j, m, n, false, false, false, false, s);
/*      */       
/* 2552 */       arrayList.add(area3DPtg);
/*      */     } 
/* 2554 */     if (paramCellRangeAddress1 != null) {
/* 2555 */       Area3DPtg area3DPtg = new Area3DPtg(i1, i2, 0, k, false, false, false, false, s);
/*      */       
/* 2557 */       arrayList.add(area3DPtg);
/*      */     } 
/* 2559 */     if (bool1) {
/* 2560 */       arrayList.add(UnionPtg.instance);
/*      */     }
/*      */     
/* 2563 */     Ptg[] arrayOfPtg = new Ptg[arrayList.size()];
/* 2564 */     arrayList.toArray(arrayOfPtg);
/* 2565 */     hSSFName.setNameDefinition(arrayOfPtg);
/*      */     
/* 2567 */     HSSFPrintSetup hSSFPrintSetup = getPrintSetup();
/* 2568 */     hSSFPrintSetup.setValidSettings(false);
/* 2569 */     setActive(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private CellRangeAddress getRepeatingRowsOrColums(boolean paramBoolean) {
/* 2574 */     NameRecord nameRecord = getBuiltinNameRecord((byte)7);
/* 2575 */     if (nameRecord == null) {
/* 2576 */       return null;
/*      */     }
/*      */     
/* 2579 */     Ptg[] arrayOfPtg = nameRecord.getNameDefinition();
/* 2580 */     if (arrayOfPtg == null) {
/* 2581 */       return null;
/*      */     }
/*      */     
/* 2584 */     int i = SpreadsheetVersion.EXCEL97.getLastRowIndex();
/* 2585 */     int j = SpreadsheetVersion.EXCEL97.getLastColumnIndex();
/*      */     
/* 2587 */     for (Ptg ptg : arrayOfPtg) {
/*      */       
/* 2589 */       if (ptg instanceof Area3DPtg) {
/* 2590 */         Area3DPtg area3DPtg = (Area3DPtg)ptg;
/*      */         
/* 2592 */         if (area3DPtg.getFirstColumn() == 0 && area3DPtg.getLastColumn() == j) {
/*      */           
/* 2594 */           if (paramBoolean) {
/* 2595 */             return new CellRangeAddress(area3DPtg.getFirstRow(), area3DPtg.getLastRow(), -1, -1);
/*      */           }
/*      */         }
/* 2598 */         else if (area3DPtg.getFirstRow() == 0 && area3DPtg.getLastRow() == i) {
/*      */           
/* 2600 */           if (!paramBoolean) {
/* 2601 */             return new CellRangeAddress(-1, -1, area3DPtg.getFirstColumn(), area3DPtg.getLastColumn());
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2610 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private NameRecord getBuiltinNameRecord(byte paramByte) {
/* 2615 */     int i = this._workbook.getSheetIndex(this);
/* 2616 */     int j = this._workbook.findExistingBuiltinNameRecordIdx(i, paramByte);
/*      */     
/* 2618 */     if (j == -1) {
/* 2619 */       return null;
/*      */     }
/* 2621 */     return this._workbook.getNameRecord(j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getColumnOutlineLevel(int paramInt) {
/* 2631 */     return this._sheet.getColumnOutlineLevel(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CellAddress getActiveCell() {
/* 2639 */     int i = this._sheet.getActiveCellRow();
/* 2640 */     short s = this._sheet.getActiveCellCol();
/* 2641 */     return new CellAddress(i, s);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActiveCell(CellAddress paramCellAddress) {
/* 2649 */     int i = paramCellAddress.getRow();
/* 2650 */     short s = (short)paramCellAddress.getColumn();
/* 2651 */     this._sheet.setActiveCellRow(i);
/* 2652 */     this._sheet.setActiveCellCol(s);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */