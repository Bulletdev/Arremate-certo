package ch.qos.logback.classic.spi;

public interface IThrowableProxy {
  String getMessage();
  
  String getClassName();
  
  StackTraceElementProxy[] getStackTraceElementProxyArray();
  
  int getCommonFrames();
  
  IThrowableProxy getCause();
  
  IThrowableProxy[] getSuppressed();
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\IThrowableProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */