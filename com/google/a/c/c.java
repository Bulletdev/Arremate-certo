package com.google.a.c;

import com.google.a.a.b;
import com.google.a.d.bj;
import com.google.b.a.f;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@f("Use CacheBuilder.newBuilder().build()")
@b
public interface c<K, V> {
  V i(@com.google.b.a.c("K") Object paramObject);
  
  V a(K paramK, Callable<? extends V> paramCallable) throws ExecutionException;
  
  bj<K, V> a(Iterable<?> paramIterable);
  
  void put(K paramK, V paramV);
  
  void putAll(Map<? extends K, ? extends V> paramMap);
  
  void d(@com.google.b.a.c("K") Object paramObject);
  
  void a(Iterable<?> paramIterable);
  
  void eA();
  
  long size();
  
  g a();
  
  ConcurrentMap<K, V> a();
  
  void ey();
}


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */