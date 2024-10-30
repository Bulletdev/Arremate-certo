package org.apache.poi.ss.usermodel;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.poi.util.Removal;

public interface Sheet extends Iterable<Row> {
  public static final short LeftMargin = 0;
  
  public static final short RightMargin = 1;
  
  public static final short TopMargin = 2;
  
  public static final short BottomMargin = 3;
  
  public static final short HeaderMargin = 4;
  
  public static final short FooterMargin = 5;
  
  public static final byte PANE_LOWER_RIGHT = 0;
  
  public static final byte PANE_UPPER_RIGHT = 1;
  
  public static final byte PANE_LOWER_LEFT = 2;
  
  public static final byte PANE_UPPER_LEFT = 3;
  
  Row createRow(int paramInt);
  
  void removeRow(Row paramRow);
  
  Row getRow(int paramInt);
  
  int getPhysicalNumberOfRows();
  
  int getFirstRowNum();
  
  int getLastRowNum();
  
  void setColumnHidden(int paramInt, boolean paramBoolean);
  
  boolean isColumnHidden(int paramInt);
  
  void setRightToLeft(boolean paramBoolean);
  
  boolean isRightToLeft();
  
  void setColumnWidth(int paramInt1, int paramInt2);
  
  int getColumnWidth(int paramInt);
  
  float getColumnWidthInPixels(int paramInt);
  
  void setDefaultColumnWidth(int paramInt);
  
  int getDefaultColumnWidth();
  
  short getDefaultRowHeight();
  
  float getDefaultRowHeightInPoints();
  
  void setDefaultRowHeight(short paramShort);
  
  void setDefaultRowHeightInPoints(float paramFloat);
  
  CellStyle getColumnStyle(int paramInt);
  
  int addMergedRegion(CellRangeAddress paramCellRangeAddress);
  
  int addMergedRegionUnsafe(CellRangeAddress paramCellRangeAddress);
  
  void validateMergedRegions();
  
  void setVerticallyCenter(boolean paramBoolean);
  
  void setHorizontallyCenter(boolean paramBoolean);
  
  boolean getHorizontallyCenter();
  
  boolean getVerticallyCenter();
  
  void removeMergedRegion(int paramInt);
  
  void removeMergedRegions(Collection<Integer> paramCollection);
  
  int getNumMergedRegions();
  
  CellRangeAddress getMergedRegion(int paramInt);
  
  List<CellRangeAddress> getMergedRegions();
  
  Iterator<Row> rowIterator();
  
  void setForceFormulaRecalculation(boolean paramBoolean);
  
  boolean getForceFormulaRecalculation();
  
  void setAutobreaks(boolean paramBoolean);
  
  void setDisplayGuts(boolean paramBoolean);
  
  void setDisplayZeros(boolean paramBoolean);
  
  boolean isDisplayZeros();
  
  void setFitToPage(boolean paramBoolean);
  
  void setRowSumsBelow(boolean paramBoolean);
  
  void setRowSumsRight(boolean paramBoolean);
  
  boolean getAutobreaks();
  
  boolean getDisplayGuts();
  
  boolean getFitToPage();
  
  boolean getRowSumsBelow();
  
  boolean getRowSumsRight();
  
  boolean isPrintGridlines();
  
  void setPrintGridlines(boolean paramBoolean);
  
  boolean isPrintRowAndColumnHeadings();
  
  void setPrintRowAndColumnHeadings(boolean paramBoolean);
  
  PrintSetup getPrintSetup();
  
  Header getHeader();
  
  Footer getFooter();
  
  void setSelected(boolean paramBoolean);
  
  double getMargin(short paramShort);
  
  void setMargin(short paramShort, double paramDouble);
  
  boolean getProtect();
  
  void protectSheet(String paramString);
  
  boolean getScenarioProtect();
  
  @Removal(version = "3.16")
  @Deprecated
  void setZoom(int paramInt1, int paramInt2);
  
  void setZoom(int paramInt);
  
  short getTopRow();
  
  short getLeftCol();
  
  void showInPane(int paramInt1, int paramInt2);
  
  void shiftRows(int paramInt1, int paramInt2, int paramInt3);
  
  void shiftRows(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2);
  
  void createFreezePane(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  void createFreezePane(int paramInt1, int paramInt2);
  
  void createSplitPane(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  PaneInformation getPaneInformation();
  
  void setDisplayGridlines(boolean paramBoolean);
  
  boolean isDisplayGridlines();
  
  void setDisplayFormulas(boolean paramBoolean);
  
  boolean isDisplayFormulas();
  
  void setDisplayRowColHeadings(boolean paramBoolean);
  
  boolean isDisplayRowColHeadings();
  
  void setRowBreak(int paramInt);
  
  boolean isRowBroken(int paramInt);
  
  void removeRowBreak(int paramInt);
  
  int[] getRowBreaks();
  
  int[] getColumnBreaks();
  
  void setColumnBreak(int paramInt);
  
  boolean isColumnBroken(int paramInt);
  
  void removeColumnBreak(int paramInt);
  
  void setColumnGroupCollapsed(int paramInt, boolean paramBoolean);
  
  void groupColumn(int paramInt1, int paramInt2);
  
  void ungroupColumn(int paramInt1, int paramInt2);
  
  void groupRow(int paramInt1, int paramInt2);
  
  void ungroupRow(int paramInt1, int paramInt2);
  
  void setRowGroupCollapsed(int paramInt, boolean paramBoolean);
  
  void setDefaultColumnStyle(int paramInt, CellStyle paramCellStyle);
  
  void autoSizeColumn(int paramInt);
  
  void autoSizeColumn(int paramInt, boolean paramBoolean);
  
  @Deprecated
  Comment getCellComment(int paramInt1, int paramInt2);
  
  Comment getCellComment(CellAddress paramCellAddress);
  
  Map<CellAddress, ? extends Comment> getCellComments();
  
  Drawing getDrawingPatriarch();
  
  Drawing createDrawingPatriarch();
  
  Workbook getWorkbook();
  
  String getSheetName();
  
  boolean isSelected();
  
  CellRange<? extends Cell> setArrayFormula(String paramString, CellRangeAddress paramCellRangeAddress);
  
  CellRange<? extends Cell> removeArrayFormula(Cell paramCell);
  
  DataValidationHelper getDataValidationHelper();
  
  List<? extends DataValidation> getDataValidations();
  
  void addValidationData(DataValidation paramDataValidation);
  
  AutoFilter setAutoFilter(CellRangeAddress paramCellRangeAddress);
  
  SheetConditionalFormatting getSheetConditionalFormatting();
  
  CellRangeAddress getRepeatingRows();
  
  CellRangeAddress getRepeatingColumns();
  
  void setRepeatingRows(CellRangeAddress paramCellRangeAddress);
  
  void setRepeatingColumns(CellRangeAddress paramCellRangeAddress);
  
  int getColumnOutlineLevel(int paramInt);
  
  Hyperlink getHyperlink(int paramInt1, int paramInt2);
  
  Hyperlink getHyperlink(CellAddress paramCellAddress);
  
  List<? extends Hyperlink> getHyperlinkList();
  
  CellAddress getActiveCell();
  
  void setActiveCell(CellAddress paramCellAddress);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Sheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */