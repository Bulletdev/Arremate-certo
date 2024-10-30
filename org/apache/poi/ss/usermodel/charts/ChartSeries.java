package org.apache.poi.ss.usermodel.charts;

import org.apache.poi.ss.util.CellReference;

public interface ChartSeries {
  void setTitle(String paramString);
  
  void setTitle(CellReference paramCellReference);
  
  String getTitleString();
  
  CellReference getTitleCellReference();
  
  TitleType getTitleType();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\charts\ChartSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */