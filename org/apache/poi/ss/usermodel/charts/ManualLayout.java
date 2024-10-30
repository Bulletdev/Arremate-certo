package org.apache.poi.ss.usermodel.charts;

public interface ManualLayout {
  void setTarget(LayoutTarget paramLayoutTarget);
  
  LayoutTarget getTarget();
  
  void setXMode(LayoutMode paramLayoutMode);
  
  LayoutMode getXMode();
  
  void setYMode(LayoutMode paramLayoutMode);
  
  LayoutMode getYMode();
  
  double getX();
  
  void setX(double paramDouble);
  
  double getY();
  
  void setY(double paramDouble);
  
  void setWidthMode(LayoutMode paramLayoutMode);
  
  LayoutMode getWidthMode();
  
  void setHeightMode(LayoutMode paramLayoutMode);
  
  LayoutMode getHeightMode();
  
  void setWidthRatio(double paramDouble);
  
  double getWidthRatio();
  
  void setHeightRatio(double paramDouble);
  
  double getHeightRatio();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\charts\ManualLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */