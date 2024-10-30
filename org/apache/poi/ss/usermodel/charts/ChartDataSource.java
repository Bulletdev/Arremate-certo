package org.apache.poi.ss.usermodel.charts;

public interface ChartDataSource<T> {
  int getPointCount();
  
  T getPointAt(int paramInt);
  
  boolean isReference();
  
  boolean isNumeric();
  
  String getFormulaString();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\charts\ChartDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */