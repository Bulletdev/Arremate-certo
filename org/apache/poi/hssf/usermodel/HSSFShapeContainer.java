package org.apache.poi.hssf.usermodel;

import java.util.List;

public interface HSSFShapeContainer extends Iterable<HSSFShape> {
  List<HSSFShape> getChildren();
  
  void addShape(HSSFShape paramHSSFShape);
  
  void setCoordinates(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  void clear();
  
  int getX1();
  
  int getY1();
  
  int getX2();
  
  int getY2();
  
  boolean removeShape(HSSFShape paramHSSFShape);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFShapeContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */