package com.google.a.c;

import com.google.a.a.b;
import com.google.a.b.s;
import com.google.a.d.bj;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@b
public interface j<K, V> extends s<K, V>, c<K, V> {
  V get(K paramK) throws ExecutionException;
  
  V h(K paramK);
  
  bj<K, V> b(Iterable<? extends K> paramIterable) throws ExecutionException;
  
  @Deprecated
  V apply(K paramK);
  
  void e(K paramK);
  
  ConcurrentMap<K, V> a();
}


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */