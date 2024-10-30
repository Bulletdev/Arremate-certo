package org.apache.commons.lang3.function;

@FunctionalInterface
public interface FailableBooleanSupplier<E extends Throwable> {
  boolean getAsBoolean() throws E;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableBooleanSupplier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */