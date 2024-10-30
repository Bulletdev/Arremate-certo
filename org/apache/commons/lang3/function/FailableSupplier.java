package org.apache.commons.lang3.function;

@FunctionalInterface
public interface FailableSupplier<R, E extends Throwable> {
  R get() throws E;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableSupplier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */