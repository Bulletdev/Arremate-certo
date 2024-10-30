package org.apache.poi.poifs.dev;

import java.util.Iterator;

public interface POIFSViewable {
  Object[] getViewableArray();
  
  Iterator<Object> getViewableIterator();
  
  boolean preferArray();
  
  String getShortDescription();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\dev\POIFSViewable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */