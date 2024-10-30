package org.apache.commons.collections4;

import java.util.Map;

public interface Put<K, V> {
  void clear();
  
  Object put(K paramK, V paramV);
  
  void putAll(Map<? extends K, ? extends V> paramMap);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\Put.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */