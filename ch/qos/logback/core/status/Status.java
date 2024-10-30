package ch.qos.logback.core.status;

import java.util.Iterator;

public interface Status {
  public static final int INFO = 0;
  
  public static final int WARN = 1;
  
  public static final int ERROR = 2;
  
  int getLevel();
  
  int getEffectiveLevel();
  
  Object getOrigin();
  
  String getMessage();
  
  Throwable getThrowable();
  
  Long getDate();
  
  boolean hasChildren();
  
  void add(Status paramStatus);
  
  boolean remove(Status paramStatus);
  
  Iterator<Status> iterator();
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\status\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */