package ch.qos.logback.core;

import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.FilterAttachable;
import ch.qos.logback.core.spi.LifeCycle;

public interface Appender<E> extends ContextAware, FilterAttachable<E>, LifeCycle {
  String getName();
  
  void doAppend(E paramE) throws LogbackException;
  
  void setName(String paramString);
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\Appender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */