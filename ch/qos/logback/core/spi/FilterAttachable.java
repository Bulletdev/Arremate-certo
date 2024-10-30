package ch.qos.logback.core.spi;

import ch.qos.logback.core.filter.Filter;
import java.util.List;

public interface FilterAttachable<E> {
  void addFilter(Filter<E> paramFilter);
  
  void clearAllFilters();
  
  List<Filter<E>> getCopyOfAttachedFiltersList();
  
  FilterReply getFilterChainDecision(E paramE);
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\spi\FilterAttachable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */