package org.apache.commons.collections4;

import java.util.Collection;

public interface BoundedCollection<E> extends Collection<E> {
  boolean isFull();
  
  int maxSize();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\BoundedCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */