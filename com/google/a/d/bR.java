/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import com.google.b.a.f;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.function.BiFunction;
/*     */ import java.util.function.Function;
/*     */ import java.util.stream.Collector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @c
/*     */ public class br<K extends Comparable<?>, V>
/*     */   implements cp<K, V>, Serializable
/*     */ {
/*  49 */   private static final br<Comparable<?>, Object> a = new br(
/*  50 */       bh.e(), bh.e());
/*     */ 
/*     */   
/*     */   private final transient bh<cn<K>> j;
/*     */ 
/*     */   
/*     */   private final transient bh<V> k;
/*     */   
/*     */   private static final long serialVersionUID = 0L;
/*     */ 
/*     */   
/*     */   public static <T, K extends Comparable<? super K>, V> Collector<T, ?, br<K, V>> c(Function<? super T, cn<K>> paramFunction, Function<? super T, ? extends V> paramFunction1) {
/*  62 */     return B.c(paramFunction, paramFunction1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K extends Comparable<?>, V> br<K, V> a() {
/*  68 */     return (br)a;
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K extends Comparable<?>, V> br<K, V> a(cn<K> paramcn, V paramV) {
/*  73 */     return new br<>(bh.a(paramcn), bh.a(paramV));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K extends Comparable<?>, V> br<K, V> a(cp<K, ? extends V> paramcp) {
/*  79 */     if (paramcp instanceof br) {
/*  80 */       return (br)paramcp;
/*     */     }
/*  82 */     Map<cn<K>, ? extends V> map = paramcp.D();
/*  83 */     bh.a<cn> a = new bh.a(map.size());
/*  84 */     bh.a<V> a1 = new bh.a(map.size());
/*  85 */     for (Map.Entry<cn<K>, ? extends V> entry : map.entrySet()) {
/*  86 */       a.a((cn)entry.getKey());
/*  87 */       a1.a(entry.getValue());
/*     */     } 
/*  89 */     return new br<>((bh)a.g(), a1.g());
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K extends Comparable<?>, V> a<K, V> a() {
/*  94 */     return new a<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @f
/*     */   public static final class a<K extends Comparable<?>, V>
/*     */   {
/* 107 */     private final List<Map.Entry<cn<K>, V>> entries = bS.a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(cn<K> param1cn, V param1V) {
/* 117 */       D.checkNotNull(param1cn);
/* 118 */       D.checkNotNull(param1V);
/* 119 */       D.a(!param1cn.isEmpty(), "Range must not be empty, but was %s", param1cn);
/* 120 */       this.entries.add(bW.d(param1cn, param1V));
/* 121 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(cp<K, ? extends V> param1cp) {
/* 127 */       for (Map.Entry entry : param1cp.D().entrySet()) {
/* 128 */         a((cn<K>)entry.getKey(), (V)entry.getValue());
/*     */       }
/* 130 */       return this;
/*     */     }
/*     */     
/*     */     @com.google.b.a.a
/*     */     a<K, V> a(a<K, V> param1a) {
/* 135 */       this.entries.addAll(param1a.entries);
/* 136 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public br<K, V> b() {
/* 146 */       Collections.sort(this.entries, cn.<Comparable<?>>k().i());
/* 147 */       bh.a<cn> a1 = new bh.a(this.entries.size());
/* 148 */       bh.a<V> a2 = new bh.a(this.entries.size());
/* 149 */       for (byte b = 0; b < this.entries.size(); b++) {
/* 150 */         cn cn = (cn)((Map.Entry)this.entries.get(b)).getKey();
/* 151 */         if (b > 0) {
/* 152 */           cn cn1 = (cn)((Map.Entry)this.entries.get(b - 1)).getKey();
/* 153 */           if (cn.c(cn1) && !cn.a(cn1).isEmpty()) {
/* 154 */             String str1 = String.valueOf(cn1), str2 = String.valueOf(cn); throw new IllegalArgumentException((new StringBuilder(47 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Overlapping ranges: range ").append(str1).append(" overlaps with entry ").append(str2).toString());
/*     */           } 
/*     */         } 
/*     */         
/* 158 */         a1.a(cn);
/* 159 */         a2.a(((Map.Entry)this.entries.get(b)).getValue());
/*     */       } 
/* 161 */       return new br<>((bh)a1.g(), a2.g());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   br(bh<cn<K>> parambh, bh<V> parambh1) {
/* 169 */     this.j = parambh;
/* 170 */     this.k = parambh1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V a(K paramK) {
/* 176 */     int i = cN.a(this.j, 
/*     */         
/* 178 */         (s)cn.g(), 
/* 179 */         T.a(paramK), (cN.b)cN.b.a, (cN.a)cN.a.a);
/*     */ 
/*     */     
/* 182 */     if (i == -1) {
/* 183 */       return null;
/*     */     }
/* 185 */     cn<K> cn = this.j.get(i);
/* 186 */     return cn.a(paramK) ? this.k.get(i) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map.Entry<cn<K>, V> a(K paramK) {
/* 193 */     int i = cN.a(this.j, 
/*     */         
/* 195 */         (s)cn.g(), 
/* 196 */         T.a(paramK), (cN.b)cN.b.a, (cN.a)cN.a.a);
/*     */ 
/*     */     
/* 199 */     if (i == -1) {
/* 200 */       return null;
/*     */     }
/* 202 */     cn<K> cn = this.j.get(i);
/* 203 */     return cn.a(paramK) ? bW.<cn<K>, V>d(cn, this.k.get(i)) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public cn<K> b() {
/* 209 */     if (this.j.isEmpty()) {
/* 210 */       throw new NoSuchElementException();
/*     */     }
/* 212 */     cn cn1 = this.j.get(0);
/* 213 */     cn cn2 = this.j.get(this.j.size() - 1);
/* 214 */     return cn.a(cn1.a, cn2.b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void a(cn<K> paramcn, V paramV) {
/* 226 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void b(cn<K> paramcn, V paramV) {
/* 238 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void a(cp<K, V> paramcp) {
/* 250 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void clear() {
/* 262 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void b(cn<K> paramcn) {
/* 274 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void a(cn<K> paramcn, V paramV, BiFunction<? super V, ? super V, ? extends V> paramBiFunction) {
/* 289 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public bj<cn<K>, V> i() {
/* 294 */     if (this.j.isEmpty()) {
/* 295 */       return bj.f();
/*     */     }
/*     */     
/* 298 */     cz<cn<K>> cz = new cz<>(this.j, (Comparator)cn.k());
/* 299 */     return new bw<>(cz, this.k);
/*     */   }
/*     */ 
/*     */   
/*     */   public bj<cn<K>, V> j() {
/* 304 */     if (this.j.isEmpty()) {
/* 305 */       return bj.f();
/*     */     }
/*     */     
/* 308 */     cz<cn<K>> cz = new cz(this.j.f(), cn.<Comparable<?>>k().a());
/* 309 */     return new bw<>(cz, this.k.f());
/*     */   }
/*     */ 
/*     */   
/*     */   public br<K, V> a(cn<K> paramcn) {
/* 314 */     if (((cn)D.checkNotNull(paramcn)).isEmpty())
/* 315 */       return a(); 
/* 316 */     if (this.j.isEmpty() || paramcn.b(b())) {
/* 317 */       return this;
/*     */     }
/*     */     
/* 320 */     int i = cN.a(this.j, 
/*     */         
/* 322 */         cn.h(), paramcn.a, cN.b.d, cN.a.b);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 327 */     int j = cN.a(this.j, 
/*     */         
/* 329 */         cn.g(), paramcn.b, (cN.b)cN.b.a, cN.a.b);
/*     */ 
/*     */ 
/*     */     
/* 333 */     if (i >= j) {
/* 334 */       return a();
/*     */     }
/* 336 */     int k = i;
/* 337 */     int m = j - i;
/* 338 */     bh<cn<K>> bh1 = new bh<cn<K>>(this, m, k, paramcn)
/*     */       {
/*     */         public int size()
/*     */         {
/* 342 */           return this.ey;
/*     */         }
/*     */ 
/*     */         
/*     */         public cn<K> a(int param1Int) {
/* 347 */           D.b(param1Int, this.ey);
/* 348 */           if (param1Int == 0 || param1Int == this.ey - 1) {
/* 349 */             return ((cn<K>)br.a(this.b).get(param1Int + this.ez)).a(this.a);
/*     */           }
/* 351 */           return br.a(this.b).get(param1Int + this.ez);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         boolean cO() {
/* 357 */           return true;
/*     */         }
/*     */       };
/* 360 */     br br1 = this;
/* 361 */     return new br<K, V>(this, bh1, this.k.a(i, j), paramcn, br1)
/*     */       {
/*     */         public br<K, V> a(cn<K> param1cn) {
/* 364 */           if (this.a.c(param1cn)) {
/* 365 */             return this.c.a(param1cn.a(this.a));
/*     */           }
/* 367 */           return br.a();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 375 */     return i().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 380 */     if (paramObject instanceof cp) {
/* 381 */       cp cp1 = (cp)paramObject;
/* 382 */       return i().equals(cp1.D());
/*     */     } 
/* 384 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 389 */     return i().toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class b<K extends Comparable<?>, V>
/*     */     implements Serializable
/*     */   {
/*     */     private final bj<cn<K>, V> k;
/*     */     
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     b(bj<cn<K>, V> param1bj) {
/* 401 */       this.k = param1bj;
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 405 */       if (this.k.isEmpty()) {
/* 406 */         return br.a();
/*     */       }
/* 408 */       return v();
/*     */     }
/*     */ 
/*     */     
/*     */     Object v() {
/* 413 */       br.a<Comparable<?>, Object> a = new br.a<>();
/* 414 */       for (dj<Map.Entry> dj = this.k.h().b(); dj.hasNext(); ) { Map.Entry entry = dj.next();
/* 415 */         a.a((cn<Comparable<?>>)entry.getKey(), entry.getValue()); }
/*     */       
/* 417 */       return a.b();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Object writeReplace() {
/* 424 */     return new b<>(i());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\br.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */