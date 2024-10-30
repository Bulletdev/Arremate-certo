package ch.qos.logback.classic.selector;

import ch.qos.logback.classic.LoggerContext;
import java.util.List;

public interface ContextSelector {
  LoggerContext getLoggerContext();
  
  LoggerContext getLoggerContext(String paramString);
  
  LoggerContext getDefaultLoggerContext();
  
  LoggerContext detachLoggerContext(String paramString);
  
  List<String> getContextNames();
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\selector\ContextSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */