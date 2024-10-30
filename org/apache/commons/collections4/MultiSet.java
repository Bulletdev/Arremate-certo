package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface MultiSet<E> extends Collection<E> {
  int getCount(Object paramObject);
  
  int setCount(E paramE, int paramInt);
  
  boolean add(E paramE);
  
  int add(E paramE, int paramInt);
  
  boolean remove(Object paramObject);
  
  int remove(Object paramObject, int paramInt);
  
  Set<E> uniqueSet();
  
  Set<Entry<E>> entrySet();
  
  Iterator<E> iterator();
  
  int size();
  
  boolean containsAll(Collection<?> paramCollection);
  
  boolean removeAll(Collection<?> paramCollection);
  
  boolean retainAll(Collection<?> paramCollection);
  
  boolean equals(Object paramObject);
  
  int hashCode();
  
  public static interface Entry<E> {
    E getElement();
    
    int getCount();
    
    boolean equals(Object param1Object);
    
    int hashCode();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\MultiSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */