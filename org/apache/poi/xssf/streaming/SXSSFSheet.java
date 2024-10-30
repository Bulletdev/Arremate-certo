/*      */ package org.apache.poi.xssf.streaming;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import org.apache.poi.ss.SpreadsheetVersion;
/*      */ import org.apache.poi.ss.usermodel.AutoFilter;
/*      */ import org.apache.poi.ss.usermodel.Cell;
/*      */ import org.apache.poi.ss.usermodel.CellRange;
/*      */ import org.apache.poi.ss.usermodel.CellStyle;
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
/*      */ import org.apache.poi.ss.util.PaneInformation;
/*      */ import org.apache.poi.ss.util.SheetUtil;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.NotImplemented;
/*      */ import org.apache.poi.util.Removal;
/*      */ import org.apache.poi.xssf.usermodel.XSSFColor;
/*      */ import org.apache.poi.xssf.usermodel.XSSFComment;
/*      */ import org.apache.poi.xssf.usermodel.XSSFDataValidation;
/*      */ import org.apache.poi.xssf.usermodel.XSSFHyperlink;
/*      */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SXSSFSheet
/*      */   implements Sheet
/*      */ {
/*      */   final XSSFSheet _sh;
/*      */   private final SXSSFWorkbook _workbook;
/*   66 */   private final TreeMap<Integer, SXSSFRow> _rows = new TreeMap<Integer, SXSSFRow>();
/*      */   private final SheetDataWriter _writer;
/*   68 */   private int _randomAccessWindowSize = 100;
/*      */   private final AutoSizeColumnTracker _autoSizeColumnTracker;
/*   70 */   private int outlineLevelRow = 0;
/*   71 */   private int lastFlushedRowNumber = -1;
/*      */   private boolean allFlushed = false;
/*      */   
/*      */   public SXSSFSheet(SXSSFWorkbook paramSXSSFWorkbook, XSSFSheet paramXSSFSheet) throws IOException {
/*   75 */     this._workbook = paramSXSSFWorkbook;
/*   76 */     this._sh = paramXSSFSheet;
/*   77 */     this._writer = paramSXSSFWorkbook.createSheetDataWriter();
/*   78 */     setRandomAccessWindowSize(this._workbook.getRandomAccessWindowSize());
/*   79 */     this._autoSizeColumnTracker = new AutoSizeColumnTracker(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   SheetDataWriter getSheetDataWriter() {
/*   87 */     return this._writer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStream getWorksheetXMLInputStream() throws IOException {
/*   94 */     flushRows(0);
/*   95 */     this._writer.close();
/*   96 */     return this._writer.getWorksheetXMLInputStream();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Row> iterator() {
/*  103 */     return rowIterator();
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
/*      */   public SXSSFRow createRow(int paramInt) {
/*  118 */     int i = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
/*  119 */     if (paramInt < 0 || paramInt > i) {
/*  120 */       throw new IllegalArgumentException("Invalid row number (" + paramInt + ") outside allowable range (0.." + i + ")");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  125 */     if (paramInt <= this._writer.getLastFlushedRow()) {
/*  126 */       throw new IllegalArgumentException("Attempting to write a row[" + paramInt + "] " + "in the range [0," + this._writer.getLastFlushedRow() + "] that is already written to disk.");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  132 */     if (this._sh.getPhysicalNumberOfRows() > 0 && paramInt <= this._sh.getLastRowNum()) {
/*  133 */       throw new IllegalArgumentException("Attempting to write a row[" + paramInt + "] " + "in the range [0," + this._sh.getLastRowNum() + "] that is already written to disk.");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  138 */     SXSSFRow sXSSFRow = new SXSSFRow(this);
/*  139 */     this._rows.put(Integer.valueOf(paramInt), sXSSFRow);
/*  140 */     this.allFlushed = false;
/*  141 */     if (this._randomAccessWindowSize >= 0 && this._rows.size() > this._randomAccessWindowSize) {
/*      */       
/*      */       try {
/*      */         
/*  145 */         flushRows(this._randomAccessWindowSize);
/*      */       }
/*  147 */       catch (IOException iOException) {
/*      */         
/*  149 */         throw new RuntimeException(iOException);
/*      */       } 
/*      */     }
/*  152 */     return sXSSFRow;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeRow(Row paramRow) {
/*  163 */     if (paramRow.getSheet() != this) {
/*  164 */       throw new IllegalArgumentException("Specified row does not belong to this sheet");
/*      */     }
/*      */     
/*  167 */     for (Iterator<Map.Entry> iterator = this._rows.entrySet().iterator(); iterator.hasNext(); ) {
/*      */       
/*  169 */       Map.Entry entry = iterator.next();
/*  170 */       if (entry.getValue() == paramRow) {
/*      */         
/*  172 */         iterator.remove();
/*      */         return;
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
/*      */   public SXSSFRow getRow(int paramInt) {
/*  188 */     return this._rows.get(Integer.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPhysicalNumberOfRows() {
/*  199 */     return this._rows.size() + this._writer.getNumberOfFlushedRows();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFirstRowNum() {
/*  210 */     if (this._writer.getNumberOfFlushedRows() > 0)
/*  211 */       return this._writer.getLowestIndexOfFlushedRows(); 
/*  212 */     return (this._rows.size() == 0) ? 0 : ((Integer)this._rows.firstKey()).intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLastRowNum() {
/*  223 */     return (this._rows.size() == 0) ? 0 : ((Integer)this._rows.lastKey()).intValue();
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
/*      */   public void setColumnHidden(int paramInt, boolean paramBoolean) {
/*  235 */     this._sh.setColumnHidden(paramInt, paramBoolean);
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
/*      */   public boolean isColumnHidden(int paramInt) {
/*  247 */     return this._sh.isColumnHidden(paramInt);
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
/*      */   public void setColumnWidth(int paramInt1, int paramInt2) {
/*  264 */     this._sh.setColumnWidth(paramInt1, paramInt2);
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
/*  275 */     return this._sh.getColumnWidth(paramInt);
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
/*      */   public float getColumnWidthInPixels(int paramInt) {
/*  288 */     return this._sh.getColumnWidthInPixels(paramInt);
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
/*      */   public void setDefaultColumnWidth(int paramInt) {
/*  300 */     this._sh.setDefaultColumnWidth(paramInt);
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
/*      */   public int getDefaultColumnWidth() {
/*  312 */     return this._sh.getDefaultColumnWidth();
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
/*      */   public short getDefaultRowHeight() {
/*  325 */     return this._sh.getDefaultRowHeight();
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
/*      */   public float getDefaultRowHeightInPoints() {
/*  337 */     return this._sh.getDefaultRowHeightInPoints();
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
/*      */   public void setDefaultRowHeight(short paramShort) {
/*  349 */     this._sh.setDefaultRowHeight(paramShort);
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
/*  360 */     this._sh.setDefaultRowHeightInPoints(paramFloat);
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
/*      */   public CellStyle getColumnStyle(int paramInt) {
/*  372 */     return this._sh.getColumnStyle(paramInt);
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
/*      */   public int addMergedRegion(CellRangeAddress paramCellRangeAddress) {
/*  390 */     return this._sh.addMergedRegion(paramCellRangeAddress);
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
/*      */   public int addMergedRegionUnsafe(CellRangeAddress paramCellRangeAddress) {
/*  402 */     return this._sh.addMergedRegionUnsafe(paramCellRangeAddress);
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
/*  414 */     this._sh.validateMergedRegions();
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
/*  425 */     this._sh.setVerticallyCenter(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHorizontallyCenter(boolean paramBoolean) {
/*  436 */     this._sh.setHorizontallyCenter(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getHorizontallyCenter() {
/*  445 */     return this._sh.getHorizontallyCenter();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getVerticallyCenter() {
/*  454 */     return this._sh.getVerticallyCenter();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMergedRegion(int paramInt) {
/*  465 */     this._sh.removeMergedRegion(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMergedRegions(Collection<Integer> paramCollection) {
/*  476 */     this._sh.removeMergedRegions(paramCollection);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumMergedRegions() {
/*  487 */     return this._sh.getNumMergedRegions();
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
/*      */   public CellRangeAddress getMergedRegion(int paramInt) {
/*  500 */     return this._sh.getMergedRegion(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<CellRangeAddress> getMergedRegions() {
/*  511 */     return this._sh.getMergedRegions();
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
/*      */   public Iterator<Row> rowIterator() {
/*  524 */     return this._rows.values().iterator();
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
/*      */   public void setAutobreaks(boolean paramBoolean) {
/*  536 */     this._sh.setAutobreaks(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayGuts(boolean paramBoolean) {
/*  547 */     this._sh.setDisplayGuts(paramBoolean);
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
/*      */   public void setDisplayZeros(boolean paramBoolean) {
/*  559 */     this._sh.setDisplayZeros(paramBoolean);
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
/*      */   public boolean isDisplayZeros() {
/*  572 */     return this._sh.isDisplayZeros();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRightToLeft(boolean paramBoolean) {
/*  583 */     this._sh.setRightToLeft(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRightToLeft() {
/*  594 */     return this._sh.isRightToLeft();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFitToPage(boolean paramBoolean) {
/*  605 */     this._sh.setFitToPage(paramBoolean);
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
/*      */   public void setRowSumsBelow(boolean paramBoolean) {
/*  624 */     this._sh.setRowSumsBelow(paramBoolean);
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
/*      */   public void setRowSumsRight(boolean paramBoolean) {
/*  643 */     this._sh.setRowSumsRight(paramBoolean);
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
/*  654 */     return this._sh.getAutobreaks();
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
/*      */   public boolean getDisplayGuts() {
/*  666 */     return this._sh.getDisplayGuts();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getFitToPage() {
/*  677 */     return this._sh.getFitToPage();
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
/*      */   public boolean getRowSumsBelow() {
/*  696 */     return this._sh.getRowSumsBelow();
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
/*      */   public boolean getRowSumsRight() {
/*  715 */     return this._sh.getRowSumsRight();
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
/*  726 */     return this._sh.isPrintGridlines();
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
/*  737 */     this._sh.setPrintGridlines(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPrintRowAndColumnHeadings() {
/*  748 */     return this._sh.isPrintRowAndColumnHeadings();
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
/*  759 */     this._sh.setPrintRowAndColumnHeadings(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PrintSetup getPrintSetup() {
/*  770 */     return (PrintSetup)this._sh.getPrintSetup();
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
/*      */   public Header getHeader() {
/*  783 */     return this._sh.getHeader();
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
/*      */   public Footer getFooter() {
/*  796 */     return this._sh.getFooter();
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
/*      */   public void setSelected(boolean paramBoolean) {
/*  810 */     this._sh.setSelected(paramBoolean);
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
/*      */   public double getMargin(short paramShort) {
/*  822 */     return this._sh.getMargin(paramShort);
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
/*  834 */     this._sh.setMargin(paramShort, paramDouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getProtect() {
/*  845 */     return this._sh.getProtect();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void protectSheet(String paramString) {
/*  855 */     this._sh.protectSheet(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getScenarioProtect() {
/*  866 */     return this._sh.getScenarioProtect();
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
/*      */   @Removal(version = "3.16")
/*      */   public void setZoom(int paramInt1, int paramInt2) {
/*  882 */     this._sh.setZoom(paramInt1, paramInt2);
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
/*      */   public void setZoom(int paramInt) {
/*  906 */     this._sh.setZoom(paramInt);
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
/*      */   public short getTopRow() {
/*  918 */     return this._sh.getTopRow();
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
/*      */   public short getLeftCol() {
/*  930 */     return this._sh.getLeftCol();
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
/*      */   public void showInPane(int paramInt1, int paramInt2) {
/*  943 */     this._sh.showInPane(paramInt1, paramInt2);
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
/*      */   public void setForceFormulaRecalculation(boolean paramBoolean) {
/*  955 */     this._sh.setForceFormulaRecalculation(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getForceFormulaRecalculation() {
/*  964 */     return this._sh.getForceFormulaRecalculation();
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
/*      */   @NotImplemented
/*      */   public void shiftRows(int paramInt1, int paramInt2, int paramInt3) {
/*  987 */     throw new RuntimeException("NotImplemented");
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
/*      */   @NotImplemented
/*      */   public void shiftRows(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
/* 1012 */     throw new RuntimeException("NotImplemented");
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
/*      */   public void createFreezePane(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1025 */     this._sh.createFreezePane(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void createFreezePane(int paramInt1, int paramInt2) {
/* 1036 */     this._sh.createFreezePane(paramInt1, paramInt2);
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
/* 1055 */     this._sh.createSplitPane(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PaneInformation getPaneInformation() {
/* 1066 */     return this._sh.getPaneInformation();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayGridlines(boolean paramBoolean) {
/* 1077 */     this._sh.setDisplayGridlines(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisplayGridlines() {
/* 1088 */     return this._sh.isDisplayGridlines();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayFormulas(boolean paramBoolean) {
/* 1099 */     this._sh.setDisplayFormulas(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisplayFormulas() {
/* 1110 */     return this._sh.isDisplayFormulas();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayRowColHeadings(boolean paramBoolean) {
/* 1121 */     this._sh.setDisplayRowColHeadings(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisplayRowColHeadings() {
/* 1131 */     return this._sh.isDisplayRowColHeadings();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRowBreak(int paramInt) {
/* 1141 */     this._sh.setRowBreak(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRowBroken(int paramInt) {
/* 1152 */     return this._sh.isRowBroken(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeRowBreak(int paramInt) {
/* 1162 */     this._sh.removeRowBreak(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] getRowBreaks() {
/* 1172 */     return this._sh.getRowBreaks();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] getColumnBreaks() {
/* 1182 */     return this._sh.getColumnBreaks();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setColumnBreak(int paramInt) {
/* 1192 */     this._sh.setColumnBreak(paramInt);
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
/* 1203 */     return this._sh.isColumnBroken(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeColumnBreak(int paramInt) {
/* 1213 */     this._sh.removeColumnBreak(paramInt);
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
/*      */   public void setColumnGroupCollapsed(int paramInt, boolean paramBoolean) {
/* 1225 */     this._sh.setColumnGroupCollapsed(paramInt, paramBoolean);
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
/*      */   public void groupColumn(int paramInt1, int paramInt2) {
/* 1237 */     this._sh.groupColumn(paramInt1, paramInt2);
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
/*      */   public void ungroupColumn(int paramInt1, int paramInt2) {
/* 1249 */     this._sh.ungroupColumn(paramInt1, paramInt2);
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
/*      */   public void groupRow(int paramInt1, int paramInt2) {
/* 1292 */     for (SXSSFRow sXSSFRow : this._rows.subMap(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1)).values()) {
/* 1293 */       int i = sXSSFRow.getOutlineLevel() + 1;
/* 1294 */       sXSSFRow.setOutlineLevel(i);
/*      */       
/* 1296 */       if (i > this.outlineLevelRow) this.outlineLevelRow = i;
/*      */     
/*      */     } 
/* 1299 */     setWorksheetOutlineLevelRow();
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
/*      */   public void setRowOutlineLevel(int paramInt1, int paramInt2) {
/* 1318 */     SXSSFRow sXSSFRow = this._rows.get(Integer.valueOf(paramInt1));
/* 1319 */     sXSSFRow.setOutlineLevel(paramInt2);
/* 1320 */     if (paramInt2 > 0 && paramInt2 > this.outlineLevelRow) {
/* 1321 */       this.outlineLevelRow = paramInt2;
/* 1322 */       setWorksheetOutlineLevelRow();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void setWorksheetOutlineLevelRow() {
/* 1327 */     CTWorksheet cTWorksheet = this._sh.getCTWorksheet();
/* 1328 */     CTSheetFormatPr cTSheetFormatPr = cTWorksheet.isSetSheetFormatPr() ? cTWorksheet.getSheetFormatPr() : cTWorksheet.addNewSheetFormatPr();
/*      */ 
/*      */     
/* 1331 */     if (this.outlineLevelRow > 0) cTSheetFormatPr.setOutlineLevelRow((short)this.outlineLevelRow);
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ungroupRow(int paramInt1, int paramInt2) {
/* 1343 */     this._sh.ungroupRow(paramInt1, paramInt2);
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
/*      */   public void setRowGroupCollapsed(int paramInt, boolean paramBoolean) {
/* 1358 */     if (paramBoolean) {
/* 1359 */       collapseRow(paramInt);
/*      */     } else {
/*      */       
/* 1362 */       throw new RuntimeException("Unable to expand row: Not Implemented");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void collapseRow(int paramInt) {
/* 1370 */     SXSSFRow sXSSFRow1 = getRow(paramInt);
/* 1371 */     if (sXSSFRow1 == null) {
/* 1372 */       throw new IllegalArgumentException("Invalid row number(" + paramInt + "). Row does not exist.");
/*      */     }
/* 1374 */     int i = findStartOfRowOutlineGroup(paramInt);
/*      */ 
/*      */     
/* 1377 */     int j = writeHidden(sXSSFRow1, i, true);
/* 1378 */     SXSSFRow sXSSFRow2 = getRow(j);
/* 1379 */     if (sXSSFRow2 != null) {
/* 1380 */       sXSSFRow2.setCollapsed(Boolean.valueOf(true));
/*      */     } else {
/* 1382 */       SXSSFRow sXSSFRow = createRow(j);
/* 1383 */       sXSSFRow.setCollapsed(Boolean.valueOf(true));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int findStartOfRowOutlineGroup(int paramInt) {
/* 1393 */     SXSSFRow sXSSFRow = getRow(paramInt);
/* 1394 */     int i = sXSSFRow.getOutlineLevel();
/* 1395 */     if (i == 0) {
/* 1396 */       throw new IllegalArgumentException("Outline level is zero for the row (" + paramInt + ").");
/*      */     }
/* 1398 */     int j = paramInt;
/* 1399 */     while (getRow(j) != null) {
/* 1400 */       if (getRow(j).getOutlineLevel() < i)
/* 1401 */         return j + 1; 
/* 1402 */       j--;
/*      */     } 
/* 1404 */     return j + 1;
/*      */   }
/*      */   
/*      */   private int writeHidden(SXSSFRow paramSXSSFRow, int paramInt, boolean paramBoolean) {
/* 1408 */     int i = paramSXSSFRow.getOutlineLevel();
/* 1409 */     SXSSFRow sXSSFRow = getRow(paramInt);
/*      */     
/* 1411 */     while (sXSSFRow != null && sXSSFRow.getOutlineLevel() >= i) {
/* 1412 */       sXSSFRow.setHidden(Boolean.valueOf(paramBoolean));
/* 1413 */       paramInt++;
/* 1414 */       sXSSFRow = getRow(paramInt);
/*      */     } 
/* 1416 */     return paramInt;
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
/*      */   public void setDefaultColumnStyle(int paramInt, CellStyle paramCellStyle) {
/* 1428 */     this._sh.setDefaultColumnStyle(paramInt, paramCellStyle);
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
/*      */   public void trackColumnForAutoSizing(int paramInt) {
/* 1444 */     this._autoSizeColumnTracker.trackColumn(paramInt);
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
/*      */   public void trackColumnsForAutoSizing(Collection<Integer> paramCollection) {
/* 1457 */     this._autoSizeColumnTracker.trackColumns(paramCollection);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void trackAllColumnsForAutoSizing() {
/* 1467 */     this._autoSizeColumnTracker.trackAllColumns();
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
/*      */   public boolean untrackColumnForAutoSizing(int paramInt) {
/* 1483 */     return this._autoSizeColumnTracker.untrackColumn(paramInt);
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
/*      */   public boolean untrackColumnsForAutoSizing(Collection<Integer> paramCollection) {
/* 1497 */     return this._autoSizeColumnTracker.untrackColumns(paramCollection);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void untrackAllColumnsForAutoSizing() {
/* 1507 */     this._autoSizeColumnTracker.untrackAllColumns();
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
/*      */   public boolean isColumnTrackedForAutoSizing(int paramInt) {
/* 1519 */     return this._autoSizeColumnTracker.isColumnTracked(paramInt);
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
/*      */   public Set<Integer> getTrackedColumnsForAutoSizing() {
/* 1532 */     return this._autoSizeColumnTracker.getTrackedColumns();
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
/*      */   public void autoSizeColumn(int paramInt) {
/* 1560 */     autoSizeColumn(paramInt, false);
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
/*      */   public void autoSizeColumn(int paramInt, boolean paramBoolean) {
/*      */     int i;
/*      */     try {
/* 1603 */       i = this._autoSizeColumnTracker.getBestFitColumnWidth(paramInt, paramBoolean);
/*      */     }
/* 1605 */     catch (IllegalStateException illegalStateException) {
/* 1606 */       throw new IllegalStateException("Could not auto-size column. Make sure the column was tracked prior to auto-sizing the column.", illegalStateException);
/*      */     } 
/*      */ 
/*      */     
/* 1610 */     int j = (int)(256.0D * SheetUtil.getColumnWidth(this, paramInt, paramBoolean));
/*      */ 
/*      */ 
/*      */     
/* 1614 */     int k = Math.max(i, j);
/*      */     
/* 1616 */     if (k > 0) {
/* 1617 */       char c = '＀';
/* 1618 */       int m = Math.min(k, 65280);
/* 1619 */       setColumnWidth(paramInt, m);
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
/*      */   public XSSFComment getCellComment(int paramInt1, int paramInt2) {
/* 1632 */     return getCellComment(new CellAddress(paramInt1, paramInt2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFComment getCellComment(CellAddress paramCellAddress) {
/* 1643 */     return this._sh.getCellComment(paramCellAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<CellAddress, XSSFComment> getCellComments() {
/* 1653 */     return this._sh.getCellComments();
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
/*      */   public XSSFHyperlink getHyperlink(int paramInt1, int paramInt2) {
/* 1665 */     return this._sh.getHyperlink(paramInt1, paramInt2);
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
/*      */   public XSSFHyperlink getHyperlink(CellAddress paramCellAddress) {
/* 1677 */     return this._sh.getHyperlink(paramCellAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XSSFHyperlink> getHyperlinkList() {
/* 1687 */     return this._sh.getHyperlinkList();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Drawing getDrawingPatriarch() {
/* 1696 */     return (Drawing)this._sh.getDrawingPatriarch();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Drawing createDrawingPatriarch() {
/* 1707 */     return (Drawing)this._sh.createDrawingPatriarch();
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
/*      */   public SXSSFWorkbook getWorkbook() {
/* 1719 */     return this._workbook;
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
/* 1730 */     return this._sh.getSheetName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSelected() {
/* 1740 */     return this._sh.isSelected();
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
/*      */   public CellRange<? extends Cell> setArrayFormula(String paramString, CellRangeAddress paramCellRangeAddress) {
/* 1754 */     return this._sh.setArrayFormula(paramString, paramCellRangeAddress);
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
/*      */   public CellRange<? extends Cell> removeArrayFormula(Cell paramCell) {
/* 1766 */     return this._sh.removeArrayFormula(paramCell);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public DataValidationHelper getDataValidationHelper() {
/* 1772 */     return this._sh.getDataValidationHelper();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XSSFDataValidation> getDataValidations() {
/* 1778 */     return this._sh.getDataValidations();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addValidationData(DataValidation paramDataValidation) {
/* 1788 */     this._sh.addValidationData(paramDataValidation);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AutoFilter setAutoFilter(CellRangeAddress paramCellRangeAddress) {
/* 1799 */     return (AutoFilter)this._sh.setAutoFilter(paramCellRangeAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public SheetConditionalFormatting getSheetConditionalFormatting() {
/* 1804 */     return (SheetConditionalFormatting)this._sh.getSheetConditionalFormatting();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public CellRangeAddress getRepeatingRows() {
/* 1810 */     return this._sh.getRepeatingRows();
/*      */   }
/*      */ 
/*      */   
/*      */   public CellRangeAddress getRepeatingColumns() {
/* 1815 */     return this._sh.getRepeatingColumns();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRepeatingRows(CellRangeAddress paramCellRangeAddress) {
/* 1820 */     this._sh.setRepeatingRows(paramCellRangeAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRepeatingColumns(CellRangeAddress paramCellRangeAddress) {
/* 1825 */     this._sh.setRepeatingColumns(paramCellRangeAddress);
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
/*      */   public void setRandomAccessWindowSize(int paramInt) {
/* 1845 */     if (paramInt == 0 || paramInt < -1) {
/* 1846 */       throw new IllegalArgumentException("RandomAccessWindowSize must be either -1 or a positive integer");
/*      */     }
/* 1848 */     this._randomAccessWindowSize = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean areAllRowsFlushed() {
/* 1855 */     return this.allFlushed;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLastFlushedRowNum() {
/* 1861 */     return this.lastFlushedRowNumber;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void flushRows(int paramInt) throws IOException {
/* 1871 */     for (; this._rows.size() > paramInt; flushOneRow());
/* 1872 */     if (paramInt == 0) this.allFlushed = true;
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void flushRows() throws IOException {
/* 1882 */     flushRows(0);
/*      */   }
/*      */ 
/*      */   
/*      */   private void flushOneRow() throws IOException {
/* 1887 */     Integer integer = this._rows.firstKey();
/* 1888 */     if (integer != null) {
/* 1889 */       int i = integer.intValue();
/* 1890 */       SXSSFRow sXSSFRow = this._rows.get(integer);
/*      */       
/* 1892 */       this._autoSizeColumnTracker.updateColumnWidths(sXSSFRow);
/* 1893 */       this._writer.writeRow(i, sXSSFRow);
/* 1894 */       this._rows.remove(integer);
/* 1895 */       this.lastFlushedRowNumber = i;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void changeRowNum(SXSSFRow paramSXSSFRow, int paramInt) {
/* 1901 */     removeRow(paramSXSSFRow);
/* 1902 */     this._rows.put(Integer.valueOf(paramInt), paramSXSSFRow);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getRowNum(SXSSFRow paramSXSSFRow) {
/* 1907 */     for (Map.Entry<Integer, SXSSFRow> entry : this._rows.entrySet()) {
/*      */ 
/*      */       
/* 1910 */       if (entry.getValue() == paramSXSSFRow)
/* 1911 */         return ((Integer)entry.getKey()).intValue(); 
/*      */     } 
/* 1913 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean dispose() throws IOException {
/* 1921 */     if (!this.allFlushed) flushRows(); 
/* 1922 */     return this._writer.dispose();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getColumnOutlineLevel(int paramInt) {
/* 1927 */     return this._sh.getColumnOutlineLevel(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CellAddress getActiveCell() {
/* 1935 */     return this._sh.getActiveCell();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActiveCell(CellAddress paramCellAddress) {
/* 1943 */     this._sh.setActiveCell(paramCellAddress);
/*      */   }
/*      */   
/*      */   public XSSFColor getTabColor() {
/* 1947 */     return this._sh.getTabColor();
/*      */   }
/*      */   
/*      */   public void setTabColor(XSSFColor paramXSSFColor) {
/* 1951 */     this._sh.setTabColor(paramXSSFColor);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\SXSSFSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */