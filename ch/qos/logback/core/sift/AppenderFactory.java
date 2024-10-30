package ch.qos.logback.core.sift;

import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.spi.JoranException;

public interface AppenderFactory<E> {
  Appender<E> buildAppender(Context paramContext, String paramString) throws JoranException;
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\sift\AppenderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */