/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import java.util.function.BiConsumer;
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
/*     */ 
/*     */ @b(ck = true, cl = true)
/*     */ final class cv<K, V>
/*     */   extends bj<K, V>
/*     */ {
/*  43 */   static final bj<Object, Object> l = new cv((Map.Entry<K, V>[])bj.a, null, 0);
/*     */ 
/*     */   
/*     */   @d
/*     */   static final double v = 1.2D;
/*     */ 
/*     */   
/*     */   @d
/*     */   static final double s = 0.001D;
/*     */ 
/*     */   
/*     */   @d
/*     */   static final int ea = 8;
/*     */ 
/*     */   
/*     */   @d
/*     */   final transient Map.Entry<K, V>[] b;
/*     */ 
/*     */   
/*     */   private final transient bk<K, V>[] c;
/*     */ 
/*     */   
/*     */   private final transient int mask;
/*     */ 
/*     */   
/*     */   private static final long serialVersionUID = 0L;
/*     */ 
/*     */ 
/*     */   
/*     */   static <K, V> bj<K, V> a(Map.Entry<K, V>... paramVarArgs) {
/*  73 */     return b(paramVarArgs.length, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <K, V> bj<K, V> b(int paramInt, Map.Entry<K, V>[] paramArrayOfEntry) {
/*     */     bk[] arrayOfBk1;
/*  82 */     D.c(paramInt, paramArrayOfEntry.length);
/*  83 */     if (paramInt == 0) {
/*  84 */       return (cv)l;
/*     */     }
/*     */     
/*  87 */     if (paramInt == paramArrayOfEntry.length) {
/*  88 */       Map.Entry<K, V>[] arrayOfEntry = paramArrayOfEntry;
/*     */     } else {
/*  90 */       arrayOfBk1 = bk.a(paramInt);
/*     */     } 
/*  92 */     int i = aY.a(paramInt, 1.2D);
/*  93 */     bk[] arrayOfBk2 = (bk[])bk.a(i);
/*  94 */     int j = i - 1;
/*  95 */     for (byte b = 0; b < paramInt; b++) {
/*  96 */       Map.Entry<K, V> entry = paramArrayOfEntry[b];
/*  97 */       K k = entry.getKey();
/*  98 */       V v = entry.getValue();
/*  99 */       C.a(k, v);
/* 100 */       int m = aY.d(k.hashCode()) & j;
/* 101 */       bk<K, V> bk1 = arrayOfBk2[m];
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 106 */       bk<?, ?> bk2 = (bk1 == null) ? a(entry, k, v) : new bk.b<>(k, v, bk1);
/* 107 */       arrayOfBk2[m] = bk2;
/* 108 */       arrayOfBk1[b] = bk2;
/* 109 */       int n = b(k, bk2, bk1);
/* 110 */       if (n > 8)
/*     */       {
/*     */         
/* 113 */         return bJ.a(paramInt, paramArrayOfEntry);
/*     */       }
/*     */     } 
/* 116 */     return new cv<>((Map.Entry<K, V>[])arrayOfBk1, (bk<K, V>[])arrayOfBk2, j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static <K, V> bk<K, V> a(Map.Entry<K, V> paramEntry, K paramK, V paramV) {
/* 122 */     boolean bool = (paramEntry instanceof bk && ((bk)paramEntry).isReusable()) ? true : false;
/* 123 */     return bool ? (bk<K, V>)paramEntry : new bk<>(paramK, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   static <K, V> bk<K, V> a(Map.Entry<K, V> paramEntry) {
/* 128 */     return a(paramEntry, paramEntry.getKey(), paramEntry.getValue());
/*     */   }
/*     */   
/*     */   private cv(Map.Entry<K, V>[] paramArrayOfEntry, bk<K, V>[] paramArrayOfbk, int paramInt) {
/* 132 */     this.b = paramArrayOfEntry;
/* 133 */     this.c = paramArrayOfbk;
/* 134 */     this.mask = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   static int b(Object paramObject, Map.Entry<?, ?> paramEntry, bk<?, ?> parambk) {
/* 144 */     byte b = 0;
/* 145 */     for (; parambk != null; parambk = parambk.a()) {
/* 146 */       a(!paramObject.equals(parambk.getKey()), "key", paramEntry, parambk);
/* 147 */       b++;
/*     */     } 
/* 149 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/* 154 */     return a(paramObject, (bk<?, V>[])this.c, this.mask);
/*     */   }
/*     */ 
/*     */   
/*     */   static <V> V a(Object paramObject, bk<?, V>[] paramArrayOfbk, int paramInt) {
/* 159 */     if (paramObject == null || paramArrayOfbk == null) {
/* 160 */       return null;
/*     */     }
/* 162 */     int i = aY.d(paramObject.hashCode()) & paramInt;
/* 163 */     bk<?, V> bk1 = paramArrayOfbk[i];
/* 164 */     for (; bk1 != null; 
/* 165 */       bk1 = bk1.a()) {
/* 166 */       Object object = bk1.getKey();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 174 */       if (paramObject.equals(object)) {
/* 175 */         return bk1.getValue();
/*     */       }
/*     */     } 
/* 178 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void forEach(BiConsumer<? super K, ? super V> paramBiConsumer) {
/* 183 */     D.checkNotNull(paramBiConsumer);
/* 184 */     for (Map.Entry<K, V> entry : this.b) {
/* 185 */       paramBiConsumer.accept(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 191 */     return this.b.length;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 196 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   bt<Map.Entry<K, V>> i() {
/* 201 */     return new bl.b<>(this, this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   bt<K> c() {
/* 206 */     return new a<>(this);
/*     */   }
/*     */   
/*     */   @b(cl = true)
/*     */   private static final class a<K> extends bD<K> {
/*     */     private final cv<K, ?> a;
/*     */     
/*     */     a(cv<K, ?> param1cv) {
/* 214 */       this.a = param1cv;
/*     */     }
/*     */ 
/*     */     
/*     */     K get(int param1Int) {
/* 219 */       return this.a.b[param1Int].getKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 224 */       return this.a.containsKey(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 229 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 234 */       return this.a.size();
/*     */     }
/*     */     
/*     */     @c
/*     */     private static class a<K>
/*     */       implements Serializable {
/*     */       final bj<K, ?> j;
/*     */       private static final long serialVersionUID = 0L;
/*     */       
/*     */       a(bj<K, ?> param2bj) {
/* 244 */         this.j = param2bj;
/*     */       }
/*     */       
/*     */       Object readResolve() {
/* 248 */         return this.j.j();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   bd<V> b() {
/* 257 */     return new b<>(this);
/*     */   }
/*     */   
/*     */   @b(cl = true)
/*     */   private static final class b<K, V> extends bh<V> {
/*     */     final cv<K, V> a;
/*     */     
/*     */     b(cv<K, V> param1cv) {
/* 265 */       this.a = param1cv;
/*     */     }
/*     */ 
/*     */     
/*     */     public V get(int param1Int) {
/* 270 */       return this.a.b[param1Int].getValue();
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 275 */       return this.a.size();
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 280 */       return true;
/*     */     }
/*     */     
/*     */     @c
/*     */     private static class a<V>
/*     */       implements Serializable {
/*     */       final bj<?, V> j;
/*     */       private static final long serialVersionUID = 0L;
/*     */       
/*     */       a(bj<?, V> param2bj) {
/* 290 */         this.j = param2bj;
/*     */       }
/*     */       
/*     */       Object readResolve() {
/* 294 */         return this.j.c();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cv.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */