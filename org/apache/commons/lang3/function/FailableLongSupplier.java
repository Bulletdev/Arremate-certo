package org.apache.commons.lang3.function;

@FunctionalInterface
public interface FailableLongSupplier<E extends Throwable> {
  long getAsLong() throws E;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableLongSupplier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */