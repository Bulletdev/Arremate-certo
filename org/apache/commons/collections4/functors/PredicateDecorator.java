package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;

public interface PredicateDecorator<T> extends Predicate<T> {
  Predicate<? super T>[] getPredicates();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\PredicateDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */