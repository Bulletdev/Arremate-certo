package org.apache.xmlbeans.impl.common;

import javax.xml.namespace.b;
import javax.xml.stream.Location;
import org.apache.xmlbeans.XmlCursor;

public interface ValidatorListener {
  public static final int BEGIN = 1;
  
  public static final int END = 2;
  
  public static final int TEXT = 3;
  
  public static final int ATTR = 4;
  
  public static final int ENDATTRS = 5;
  
  void nextEvent(int paramInt, Event paramEvent);
  
  public static interface Event extends PrefixResolver {
    public static final int PRESERVE = 1;
    
    public static final int REPLACE = 2;
    
    public static final int COLLAPSE = 3;
    
    XmlCursor getLocationAsCursor();
    
    Location getLocation();
    
    String getXsiType();
    
    String getXsiNil();
    
    String getXsiLoc();
    
    String getXsiNoLoc();
    
    b getName();
    
    String getText();
    
    String getText(int param1Int);
    
    boolean textIsWhitespace();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\ValidatorListener.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */