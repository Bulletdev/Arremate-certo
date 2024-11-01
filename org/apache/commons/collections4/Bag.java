package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface Bag<E> extends Collection<E> {
  int getCount(Object paramObject);
  
  boolean add(E paramE);
  
  boolean add(E paramE, int paramInt);
  
  boolean remove(Object paramObject);
  
  boolean remove(Object paramObject, int paramInt);
  
  Set<E> uniqueSet();
  
  int size();
  
  boolean containsAll(Collection<?> paramCollection);
  
  boolean removeAll(Collection<?> paramCollection);
  
  boolean retainAll(Collection<?> paramCollection);
  
  Iterator<E> iterator();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\Bag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */