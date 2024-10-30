package org.apache.commons.collections4;

public interface BoundedMap<K, V> extends IterableMap<K, V> {
  boolean isFull();
  
  int maxSize();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\BoundedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */