package org.apache.poi.xdgf.usermodel.section.geometry;

import java.awt.geom.Path2D;
import org.apache.poi.xdgf.usermodel.XDGFShape;

public interface GeometryRow {
  void setupMaster(GeometryRow paramGeometryRow);
  
  void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\GeometryRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */