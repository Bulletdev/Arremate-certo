package org.apache.commons.collections4;

public interface OrderedMap<K, V> extends IterableMap<K, V> {
  OrderedMapIterator<K, V> mapIterator();
  
  K firstKey();
  
  K lastKey();
  
  K nextKey(K paramK);
  
  K previousKey(K paramK);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\OrderedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */