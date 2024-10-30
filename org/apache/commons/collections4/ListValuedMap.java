package org.apache.commons.collections4;

import java.util.List;

public interface ListValuedMap<K, V> extends MultiValuedMap<K, V> {
  List<V> get(K paramK);
  
  List<V> remove(Object paramObject);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\ListValuedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */