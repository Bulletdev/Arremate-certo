package org.apache.commons.collections4;

public interface OrderedMapIterator<K, V> extends MapIterator<K, V>, OrderedIterator<K> {
  boolean hasPrevious();
  
  K previous();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\OrderedMapIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */