package org.apache.commons.collections4;

import java.util.Iterator;

public interface OrderedIterator<E> extends Iterator<E> {
  boolean hasPrevious();
  
  E previous();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\OrderedIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */