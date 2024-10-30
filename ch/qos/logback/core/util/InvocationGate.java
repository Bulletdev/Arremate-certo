package ch.qos.logback.core.util;

public interface InvocationGate {
  public static final long TIME_UNAVAILABLE = -1L;
  
  boolean isTooSoon(long paramLong);
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\InvocationGate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */