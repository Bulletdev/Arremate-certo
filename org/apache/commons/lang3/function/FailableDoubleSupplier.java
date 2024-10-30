package org.apache.commons.lang3.function;

@FunctionalInterface
public interface FailableDoubleSupplier<E extends Throwable> {
  double getAsDouble() throws E;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableDoubleSupplier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */