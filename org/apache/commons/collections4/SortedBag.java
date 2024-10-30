package org.apache.commons.collections4;

import java.util.Comparator;

public interface SortedBag<E> extends Bag<E> {
  Comparator<? super E> comparator();
  
  E first();
  
  E last();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\SortedBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */