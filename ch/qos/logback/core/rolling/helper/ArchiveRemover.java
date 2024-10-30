package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.spi.ContextAware;
import java.util.Date;
import java.util.concurrent.Future;

public interface ArchiveRemover extends ContextAware {
  void clean(Date paramDate);
  
  void setMaxHistory(int paramInt);
  
  void setTotalSizeCap(long paramLong);
  
  Future<?> cleanAsynchronously(Date paramDate);
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\ArchiveRemover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */