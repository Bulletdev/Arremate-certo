package org.apache.http.pool;

public interface PoolEntryCallback<T, C> {
  void process(PoolEntry<T, C> paramPoolEntry);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\pool\PoolEntryCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */