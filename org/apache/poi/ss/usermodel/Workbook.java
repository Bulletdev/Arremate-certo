package org.apache.poi.ss.usermodel;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;

public interface Workbook extends Closeable, Iterable<Sheet> {
  public static final int PICTURE_TYPE_EMF = 2;
  
  public static final int PICTURE_TYPE_WMF = 3;
  
  public static final int PICTURE_TYPE_PICT = 4;
  
  public static final int PICTURE_TYPE_JPEG = 5;
  
  public static final int PICTURE_TYPE_PNG = 6;
  
  public static final int PICTURE_TYPE_DIB = 7;
  
  public static final int SHEET_STATE_VISIBLE = 0;
  
  public static final int SHEET_STATE_HIDDEN = 1;
  
  public static final int SHEET_STATE_VERY_HIDDEN = 2;
  
  int getActiveSheetIndex();
  
  void setActiveSheet(int paramInt);
  
  int getFirstVisibleTab();
  
  void setFirstVisibleTab(int paramInt);
  
  void setSheetOrder(String paramString, int paramInt);
  
  void setSelectedTab(int paramInt);
  
  void setSheetName(int paramInt, String paramString);
  
  String getSheetName(int paramInt);
  
  int getSheetIndex(String paramString);
  
  int getSheetIndex(Sheet paramSheet);
  
  Sheet createSheet();
  
  Sheet createSheet(String paramString);
  
  Sheet cloneSheet(int paramInt);
  
  Iterator<Sheet> sheetIterator();
  
  int getNumberOfSheets();
  
  Sheet getSheetAt(int paramInt);
  
  Sheet getSheet(String paramString);
  
  void removeSheetAt(int paramInt);
  
  Font createFont();
  
  Font findFont(short paramShort1, short paramShort2, short paramShort3, String paramString, boolean paramBoolean1, boolean paramBoolean2, short paramShort4, byte paramByte);
  
  Font findFont(boolean paramBoolean1, short paramShort1, short paramShort2, String paramString, boolean paramBoolean2, boolean paramBoolean3, short paramShort3, byte paramByte);
  
  short getNumberOfFonts();
  
  Font getFontAt(short paramShort);
  
  CellStyle createCellStyle();
  
  int getNumCellStyles();
  
  CellStyle getCellStyleAt(int paramInt);
  
  void write(OutputStream paramOutputStream) throws IOException;
  
  void close() throws IOException;
  
  int getNumberOfNames();
  
  Name getName(String paramString);
  
  List<? extends Name> getNames(String paramString);
  
  List<? extends Name> getAllNames();
  
  Name getNameAt(int paramInt);
  
  Name createName();
  
  int getNameIndex(String paramString);
  
  void removeName(int paramInt);
  
  void removeName(String paramString);
  
  void removeName(Name paramName);
  
  int linkExternalWorkbook(String paramString, Workbook paramWorkbook);
  
  void setPrintArea(int paramInt, String paramString);
  
  void setPrintArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  String getPrintArea(int paramInt);
  
  void removePrintArea(int paramInt);
  
  Row.MissingCellPolicy getMissingCellPolicy();
  
  void setMissingCellPolicy(Row.MissingCellPolicy paramMissingCellPolicy);
  
  DataFormat createDataFormat();
  
  int addPicture(byte[] paramArrayOfbyte, int paramInt);
  
  List<? extends PictureData> getAllPictures();
  
  CreationHelper getCreationHelper();
  
  boolean isHidden();
  
  void setHidden(boolean paramBoolean);
  
  boolean isSheetHidden(int paramInt);
  
  boolean isSheetVeryHidden(int paramInt);
  
  void setSheetHidden(int paramInt, boolean paramBoolean);
  
  void setSheetHidden(int paramInt1, int paramInt2);
  
  void addToolPack(UDFFinder paramUDFFinder);
  
  void setForceFormulaRecalculation(boolean paramBoolean);
  
  boolean getForceFormulaRecalculation();
  
  SpreadsheetVersion getSpreadsheetVersion();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Workbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */