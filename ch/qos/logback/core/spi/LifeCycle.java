package ch.qos.logback.core.spi;

public interface LifeCycle {
  void start();
  
  void stop();
  
  boolean isStarted();
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\spi\LifeCycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */