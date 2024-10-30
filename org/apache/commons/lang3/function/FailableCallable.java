package org.apache.commons.lang3.function;

@FunctionalInterface
public interface FailableCallable<R, E extends Throwable> {
  R call() throws E;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableCallable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */