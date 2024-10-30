package org.apache.commons.collections4;

import java.util.Set;

public interface BidiMap<K, V> extends IterableMap<K, V> {
  V put(K paramK, V paramV);
  
  K getKey(Object paramObject);
  
  K removeValue(Object paramObject);
  
  BidiMap<V, K> inverseBidiMap();
  
  Set<V> values();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\BidiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */