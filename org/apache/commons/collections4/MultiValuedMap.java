package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface MultiValuedMap<K, V> {
  int size();
  
  boolean isEmpty();
  
  boolean containsKey(Object paramObject);
  
  boolean containsValue(Object paramObject);
  
  boolean containsMapping(Object paramObject1, Object paramObject2);
  
  Collection<V> get(K paramK);
  
  boolean put(K paramK, V paramV);
  
  boolean putAll(K paramK, Iterable<? extends V> paramIterable);
  
  boolean putAll(Map<? extends K, ? extends V> paramMap);
  
  boolean putAll(MultiValuedMap<? extends K, ? extends V> paramMultiValuedMap);
  
  Collection<V> remove(Object paramObject);
  
  boolean removeMapping(Object paramObject1, Object paramObject2);
  
  void clear();
  
  Collection<Map.Entry<K, V>> entries();
  
  MultiSet<K> keys();
  
  Set<K> keySet();
  
  Collection<V> values();
  
  Map<K, Collection<V>> asMap();
  
  MapIterator<K, V> mapIterator();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\MultiValuedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */