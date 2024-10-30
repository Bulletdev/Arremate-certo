package ch.qos.logback.core.rolling;

import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.rolling.helper.CompressionMode;
import ch.qos.logback.core.spi.LifeCycle;

public interface RollingPolicy extends LifeCycle {
  void rollover() throws RolloverFailure;
  
  String getActiveFileName();
  
  CompressionMode getCompressionMode();
  
  void setParent(FileAppender<?> paramFileAppender);
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\RollingPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */