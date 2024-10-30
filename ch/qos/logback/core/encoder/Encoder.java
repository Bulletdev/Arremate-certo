package ch.qos.logback.core.encoder;

import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;

public interface Encoder<E> extends ContextAware, LifeCycle {
  byte[] headerBytes();
  
  byte[] encode(E paramE);
  
  byte[] footerBytes();
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\encoder\Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */