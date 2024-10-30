package org.apache.commons.lang3.builder;

@FunctionalInterface
public interface Diffable<T> {
  DiffResult<T> diff(T paramT);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\Diffable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */