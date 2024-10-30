package org.apache.poi.ss.usermodel;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Removal;

public interface Cell {
  @Removal(version = "4.0")
  public static final int CELL_TYPE_NUMERIC = 0;
  
  @Removal(version = "4.0")
  public static final int CELL_TYPE_STRING = 1;
  
  @Removal(version = "4.0")
  public static final int CELL_TYPE_FORMULA = 2;
  
  @Removal(version = "4.0")
  public static final int CELL_TYPE_BLANK = 3;
  
  @Removal(version = "4.0")
  public static final int CELL_TYPE_BOOLEAN = 4;
  
  @Removal(version = "4.0")
  public static final int CELL_TYPE_ERROR = 5;
  
  int getColumnIndex();
  
  int getRowIndex();
  
  Sheet getSheet();
  
  Row getRow();
  
  @Removal(version = "4.0")
  void setCellType(int paramInt);
  
  void setCellType(CellType paramCellType);
  
  int getCellType();
  
  @Removal(version = "4.2")
  CellType getCellTypeEnum();
  
  int getCachedFormulaResultType();
  
  CellType getCachedFormulaResultTypeEnum();
  
  void setCellValue(double paramDouble);
  
  void setCellValue(Date paramDate);
  
  void setCellValue(Calendar paramCalendar);
  
  void setCellValue(RichTextString paramRichTextString);
  
  void setCellValue(String paramString);
  
  void setCellFormula(String paramString) throws FormulaParseException;
  
  String getCellFormula();
  
  double getNumericCellValue();
  
  Date getDateCellValue();
  
  RichTextString getRichStringCellValue();
  
  String getStringCellValue();
  
  void setCellValue(boolean paramBoolean);
  
  void setCellErrorValue(byte paramByte);
  
  boolean getBooleanCellValue();
  
  byte getErrorCellValue();
  
  void setCellStyle(CellStyle paramCellStyle);
  
  CellStyle getCellStyle();
  
  void setAsActiveCell();
  
  CellAddress getAddress();
  
  void setCellComment(Comment paramComment);
  
  Comment getCellComment();
  
  void removeCellComment();
  
  Hyperlink getHyperlink();
  
  void setHyperlink(Hyperlink paramHyperlink);
  
  void removeHyperlink();
  
  CellRangeAddress getArrayFormulaRange();
  
  boolean isPartOfArrayFormulaGroup();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Cell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */