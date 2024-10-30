package org.apache.poi.ss.usermodel;

import java.awt.Dimension;

public interface Picture {
  void resize();
  
  void resize(double paramDouble);
  
  void resize(double paramDouble1, double paramDouble2);
  
  ClientAnchor getPreferredSize();
  
  ClientAnchor getPreferredSize(double paramDouble1, double paramDouble2);
  
  Dimension getImageDimension();
  
  PictureData getPictureData();
  
  ClientAnchor getClientAnchor();
  
  Sheet getSheet();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Picture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */