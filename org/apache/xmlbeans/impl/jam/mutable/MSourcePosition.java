package org.apache.xmlbeans.impl.jam.mutable;

import java.net.URI;
import org.apache.xmlbeans.impl.jam.JSourcePosition;

public interface MSourcePosition extends JSourcePosition {
  void setColumn(int paramInt);
  
  void setLine(int paramInt);
  
  void setSourceURI(URI paramURI);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\mutable\MSourcePosition.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */