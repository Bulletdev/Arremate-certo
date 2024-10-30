package ch.qos.logback.core.rolling;

import ch.qos.logback.core.spi.LifeCycle;
import java.io.File;

public interface TriggeringPolicy<E> extends LifeCycle {
  boolean isTriggeringEvent(File paramFile, E paramE);
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\TriggeringPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */