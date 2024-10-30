package org.apache.commons.collections4;

public interface OrderedBidiMap<K, V> extends BidiMap<K, V>, OrderedMap<K, V> {
  OrderedBidiMap<V, K> inverseBidiMap();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\OrderedBidiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */