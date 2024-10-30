package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.spi.ContextAware;

public interface Configurator extends ContextAware {
  void configure(LoggerContext paramLoggerContext);
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\Configurator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */