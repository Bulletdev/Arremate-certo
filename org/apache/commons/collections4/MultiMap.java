package org.apache.commons.collections4;

import java.util.Collection;

@Deprecated
public interface MultiMap<K, V> extends IterableMap<K, Object> {
  boolean removeMapping(K paramK, V paramV);
  
  int size();
  
  Object get(Object paramObject);
  
  boolean containsValue(Object paramObject);
  
  Object put(K paramK, Object paramObject);
  
  Object remove(Object paramObject);
  
  Collection<Object> values();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\MultiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */