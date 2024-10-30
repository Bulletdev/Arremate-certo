package ch.qos.logback.core;

import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.spi.PropertyContainer;
import ch.qos.logback.core.status.StatusManager;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public interface Context extends PropertyContainer {
  StatusManager getStatusManager();
  
  Object getObject(String paramString);
  
  void putObject(String paramString, Object paramObject);
  
  String getProperty(String paramString);
  
  void putProperty(String paramString1, String paramString2);
  
  Map<String, String> getCopyOfPropertyMap();
  
  String getName();
  
  void setName(String paramString);
  
  long getBirthTime();
  
  Object getConfigurationLock();
  
  ScheduledExecutorService getScheduledExecutorService();
  
  ExecutorService getExecutorService();
  
  void register(LifeCycle paramLifeCycle);
  
  void addScheduledFuture(ScheduledFuture<?> paramScheduledFuture);
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\Context.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */