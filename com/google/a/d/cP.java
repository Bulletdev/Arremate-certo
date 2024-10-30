package com.google.a.d;

import com.google.a.a.a;
import com.google.a.a.c;
import com.google.b.a.f;
import java.util.Map;
import java.util.function.BiFunction;

@f("Use ImmutableRangeMap or TreeRangeMap")
@a
@c
public interface cp<K extends Comparable, V> {
  V a(K paramK);
  
  Map.Entry<cn<K>, V> a(K paramK);
  
  cn<K> b();
  
  void a(cn<K> paramcn, V paramV);
  
  void b(cn<K> paramcn, V paramV);
  
  void a(cp<K, V> paramcp);
  
  void clear();
  
  void b(cn<K> paramcn);
  
  void a(cn<K> paramcn, V paramV, BiFunction<? super V, ? super V, ? extends V> paramBiFunction);
  
  Map<cn<K>, V> D();
  
  Map<cn<K>, V> C();
  
  cp<K, V> a(cn<K> paramcn);
  
  boolean equals(Object paramObject);
  
  int hashCode();
  
  String toString();
}


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */