/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.c.a.h;
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.Consumer;
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
/*     */ 
/*     */ @b(ck = true, cl = true)
/*     */ class ct<K, V>
/*     */   extends ba<K, V>
/*     */ {
/*  44 */   static final ct<Object, Object> a = new ct(null, null, (Map.Entry<K, V>[])bj.a, 0, 0);
/*     */   static final double v = 1.2D;
/*     */   private final transient bk<K, V>[] a;
/*     */   private final transient bk<K, V>[] b;
/*     */   @d
/*     */   final transient Map.Entry<K, V>[] b;
/*     */   private final transient int mask;
/*     */   private final transient int hashCode;
/*     */   @com.google.b.a.a.b
/*     */   @h
/*     */   private transient ba<V, K> a;
/*     */   
/*     */   static <K, V> ba<K, V> a(Map.Entry<K, V>... paramVarArgs) {
/*  57 */     return b(paramVarArgs.length, paramVarArgs);
/*     */   }
/*     */   static <K, V> ba<K, V> b(int paramInt, Map.Entry<K, V>[] paramArrayOfEntry) {
/*     */     bk[] arrayOfBk3;
/*  61 */     D.c(paramInt, paramArrayOfEntry.length);
/*  62 */     int i = aY.a(paramInt, 1.2D);
/*  63 */     int j = i - 1;
/*  64 */     bk[] arrayOfBk1 = (bk[])bk.a(i);
/*  65 */     bk[] arrayOfBk2 = (bk[])bk.a(i);
/*     */     
/*  67 */     if (paramInt == paramArrayOfEntry.length) {
/*  68 */       Map.Entry<K, V>[] arrayOfEntry = paramArrayOfEntry;
/*     */     } else {
/*  70 */       arrayOfBk3 = bk.a(paramInt);
/*     */     } 
/*  72 */     int k = 0;
/*     */     
/*  74 */     for (byte b = 0; b < paramInt; b++) {
/*     */       
/*  76 */       Map.Entry<K, V> entry = paramArrayOfEntry[b];
/*  77 */       K k1 = entry.getKey();
/*  78 */       V v = entry.getValue();
/*  79 */       C.a(k1, v);
/*  80 */       int m = k1.hashCode();
/*  81 */       int n = v.hashCode();
/*  82 */       int i1 = aY.d(m) & j;
/*  83 */       int i2 = aY.d(n) & j;
/*     */       
/*  85 */       bk<?, ?> bk1 = arrayOfBk1[i1];
/*  86 */       int i3 = cv.b(k1, entry, bk1);
/*  87 */       bk<?, ?> bk2 = arrayOfBk2[i2];
/*  88 */       int i4 = a(v, entry, bk2);
/*  89 */       if (i3 > 8 || i4 > 8)
/*     */       {
/*  91 */         return bI.a(paramInt, paramArrayOfEntry);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  96 */       bk bk3 = (bk2 == null && bk1 == null) ? cv.<K, V>a(entry, k1, v) : new bk.a<>(k1, v, (bk)bk1, (bk)bk2);
/*     */       
/*  98 */       arrayOfBk1[i1] = bk3;
/*  99 */       arrayOfBk2[i2] = bk3;
/* 100 */       arrayOfBk3[b] = bk3;
/* 101 */       k += m ^ n;
/*     */     } 
/* 103 */     return new ct<>((bk<K, V>[])arrayOfBk1, (bk<K, V>[])arrayOfBk2, (Map.Entry<K, V>[])arrayOfBk3, j, k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ct(bk<K, V>[] paramArrayOfbk1, bk<K, V>[] paramArrayOfbk2, Map.Entry<K, V>[] paramArrayOfEntry, int paramInt1, int paramInt2) {
/* 112 */     this.a = (ba<V, K>)paramArrayOfbk1;
/* 113 */     this.b = (Map.Entry<K, V>[])paramArrayOfbk2;
/* 114 */     this.b = paramArrayOfEntry;
/* 115 */     this.mask = paramInt1;
/* 116 */     this.hashCode = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   private static int a(Object paramObject, Map.Entry<?, ?> paramEntry, bk<?, ?> parambk) {
/* 128 */     byte b = 0;
/* 129 */     for (; parambk != null; parambk = parambk.b()) {
/* 130 */       a(!paramObject.equals(parambk.getValue()), "value", paramEntry, parambk);
/* 131 */       b++;
/*     */     } 
/* 133 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/* 138 */     return (this.a == null) ? null : cv.<V>a(paramObject, (bk<?, V>[])this.a, this.mask);
/*     */   }
/*     */ 
/*     */   
/*     */   bt<Map.Entry<K, V>> i() {
/* 143 */     return isEmpty() ? 
/* 144 */       bt.<Map.Entry<K, V>>n() : 
/* 145 */       new bl.b<>(this, this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   bt<K> c() {
/* 150 */     return new bm<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void forEach(BiConsumer<? super K, ? super V> paramBiConsumer) {
/* 155 */     D.checkNotNull(paramBiConsumer);
/* 156 */     for (Map.Entry<K, V> entry : this.b) {
/* 157 */       paramBiConsumer.accept(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cR() {
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 168 */     return this.hashCode;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 173 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 178 */     return this.b.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ba<V, K> b() {
/* 185 */     if (isEmpty()) {
/* 186 */       return ba.a();
/*     */     }
/* 188 */     ba<V, K> ba1 = this.a;
/* 189 */     return (ba1 == null) ? (this.a = new a()) : ba1;
/*     */   }
/*     */   
/*     */   private final class a extends ba<V, K> {
/*     */     private a(ct this$0) {}
/*     */     
/*     */     public int size() {
/* 196 */       return b().size();
/*     */     }
/*     */ 
/*     */     
/*     */     public ba<K, V> b() {
/* 201 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public void forEach(BiConsumer<? super V, ? super K> param1BiConsumer) {
/* 206 */       D.checkNotNull(param1BiConsumer);
/* 207 */       this.b.forEach((param1Object1, param1Object2) -> param1BiConsumer.accept(param1Object2, param1Object1));
/*     */     }
/*     */ 
/*     */     
/*     */     public K get(Object param1Object) {
/* 212 */       if (param1Object == null || ct.a(this.b) == null) {
/* 213 */         return null;
/*     */       }
/* 215 */       int i = aY.d(param1Object.hashCode()) & ct.a(this.b);
/* 216 */       bk bk = ct.a(this.b)[i];
/* 217 */       for (; bk != null; 
/* 218 */         bk = bk.b()) {
/* 219 */         if (param1Object.equals(bk.getValue())) {
/* 220 */           return (K)bk.getKey();
/*     */         }
/*     */       } 
/* 223 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     bt<V> c() {
/* 228 */       return new bm<>(this);
/*     */     }
/*     */ 
/*     */     
/*     */     bt<Map.Entry<V, K>> i() {
/* 233 */       return new a(this);
/*     */     }
/*     */     
/*     */     final class a extends bl<V, K> { a(ct.a this$0) {}
/*     */       
/*     */       bj<V, K> g() {
/* 239 */         return this.a;
/*     */       }
/*     */ 
/*     */       
/*     */       boolean cR() {
/* 244 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public int hashCode() {
/* 249 */         return ct.b(this.a.b);
/*     */       }
/*     */ 
/*     */       
/*     */       public dj<Map.Entry<V, K>> b() {
/* 254 */         return c().b();
/*     */       }
/*     */ 
/*     */       
/*     */       public void forEach(Consumer<? super Map.Entry<V, K>> param2Consumer) {
/* 259 */         c().forEach(param2Consumer);
/*     */       }
/*     */ 
/*     */       
/*     */       bh<Map.Entry<V, K>> h() {
/* 264 */         return new aZ<Map.Entry<V, K>>(this)
/*     */           {
/*     */             public Map.Entry<V, K> b(int param3Int) {
/* 267 */               Map.Entry entry = this.a.a.b.b[param3Int];
/* 268 */               return bW.d((V)entry.getValue(), (K)entry.getKey());
/*     */             }
/*     */ 
/*     */             
/*     */             bd<Map.Entry<V, K>> a() {
/* 273 */               return this.a;
/*     */             }
/*     */           };
/*     */       } }
/*     */ 
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 281 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     Object writeReplace() {
/* 286 */       return new ct.b<>(this.b);
/*     */     } }
/*     */   
/*     */   private static class b<K, V> implements Serializable {
/*     */     private final ba<K, V> b;
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     b(ba<K, V> param1ba) {
/* 294 */       this.b = param1ba;
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 298 */       return this.b.b();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ct.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */