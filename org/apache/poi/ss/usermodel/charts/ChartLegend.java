package org.apache.poi.ss.usermodel.charts;

public interface ChartLegend extends ManuallyPositionable {
  LegendPosition getPosition();
  
  void setPosition(LegendPosition paramLegendPosition);
  
  boolean isOverlay();
  
  void setOverlay(boolean paramBoolean);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\charts\ChartLegend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */