package org.apache.commons.collections4;

import java.util.Comparator;
import java.util.SortedMap;

public interface SortedBidiMap<K, V> extends SortedMap<K, V>, OrderedBidiMap<K, V> {
  SortedBidiMap<V, K> inverseBidiMap();
  
  Comparator<? super V> valueComparator();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\SortedBidiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */