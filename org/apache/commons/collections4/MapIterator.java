package org.apache.commons.collections4;

import java.util.Iterator;

public interface MapIterator<K, V> extends Iterator<K> {
  boolean hasNext();
  
  K next();
  
  K getKey();
  
  V getValue();
  
  void remove();
  
  V setValue(V paramV);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\MapIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */