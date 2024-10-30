package ch.qos.logback.core.spi;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.status.Status;

public interface ContextAware {
  void setContext(Context paramContext);
  
  Context getContext();
  
  void addStatus(Status paramStatus);
  
  void addInfo(String paramString);
  
  void addInfo(String paramString, Throwable paramThrowable);
  
  void addWarn(String paramString);
  
  void addWarn(String paramString, Throwable paramThrowable);
  
  void addError(String paramString);
  
  void addError(String paramString, Throwable paramThrowable);
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\spi\ContextAware.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */