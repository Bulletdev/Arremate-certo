package org.apache.poi.sl.usermodel;

public interface TableShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends PlaceableShape<S, P>, Shape<S, P> {
  int getNumberOfColumns();
  
  int getNumberOfRows();
  
  TableCell<S, P> getCell(int paramInt1, int paramInt2);
  
  double getColumnWidth(int paramInt);
  
  void setColumnWidth(int paramInt, double paramDouble);
  
  double getRowHeight(int paramInt);
  
  void setRowHeight(int paramInt, double paramDouble);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\TableShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */