package org.apache.poi.ss.usermodel.charts;

public interface ChartAxis {
  long getId();
  
  AxisPosition getPosition();
  
  void setPosition(AxisPosition paramAxisPosition);
  
  String getNumberFormat();
  
  void setNumberFormat(String paramString);
  
  boolean isSetLogBase();
  
  void setLogBase(double paramDouble);
  
  double getLogBase();
  
  boolean isSetMinimum();
  
  double getMinimum();
  
  void setMinimum(double paramDouble);
  
  boolean isSetMaximum();
  
  double getMaximum();
  
  void setMaximum(double paramDouble);
  
  AxisOrientation getOrientation();
  
  void setOrientation(AxisOrientation paramAxisOrientation);
  
  void setCrosses(AxisCrosses paramAxisCrosses);
  
  AxisCrosses getCrosses();
  
  void crossAxis(ChartAxis paramChartAxis);
  
  boolean isVisible();
  
  void setVisible(boolean paramBoolean);
  
  AxisTickMark getMajorTickMark();
  
  void setMajorTickMark(AxisTickMark paramAxisTickMark);
  
  AxisTickMark getMinorTickMark();
  
  void setMinorTickMark(AxisTickMark paramAxisTickMark);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\charts\ChartAxis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */