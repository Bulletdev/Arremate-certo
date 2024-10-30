package org.apache.http;

import java.util.Iterator;

public interface HeaderIterator extends Iterator<Object> {
  boolean hasNext();
  
  Header nextHeader();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\HeaderIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */