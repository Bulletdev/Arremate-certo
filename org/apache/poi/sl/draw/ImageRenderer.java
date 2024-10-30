package org.apache.poi.sl.draw;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public interface ImageRenderer {
  void loadImage(InputStream paramInputStream, String paramString) throws IOException;
  
  void loadImage(byte[] paramArrayOfbyte, String paramString) throws IOException;
  
  Dimension getDimension();
  
  void setAlpha(double paramDouble);
  
  BufferedImage getImage();
  
  BufferedImage getImage(Dimension paramDimension);
  
  boolean drawImage(Graphics2D paramGraphics2D, Rectangle2D paramRectangle2D);
  
  boolean drawImage(Graphics2D paramGraphics2D, Rectangle2D paramRectangle2D, Insets paramInsets);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\ImageRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */