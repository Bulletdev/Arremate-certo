package org.apache.commons.collections4;

import java.util.Set;

public interface SetValuedMap<K, V> extends MultiValuedMap<K, V> {
  Set<V> get(K paramK);
  
  Set<V> remove(Object paramObject);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\SetValuedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */