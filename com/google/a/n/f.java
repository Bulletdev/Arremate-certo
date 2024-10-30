/*     */ package com.google.a.n;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.d.aC;
/*     */ import com.google.a.d.aD;
/*     */ import com.google.a.d.aK;
/*     */ import com.google.a.d.bH;
/*     */ import com.google.a.d.bW;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public final class f<B>
/*     */   extends aC<m<? extends B>, B>
/*     */   implements l<B>
/*     */ {
/*  42 */   private final Map<m<? extends B>, B> H = bW.a();
/*     */ 
/*     */   
/*     */   public <T extends B> T b(Class<T> paramClass) {
/*  46 */     return b(m.a(paramClass));
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends B> T a(m<T> paramm) {
/*  51 */     return b(paramm.h());
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public <T extends B> T a(Class<T> paramClass, T paramT) {
/*  57 */     return c(m.a(paramClass), paramT);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public <T extends B> T a(m<T> paramm, T paramT) {
/*  63 */     return c(paramm.h(), paramT);
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
/*     */   @com.google.b.a.a
/*     */   public B b(m<? extends B> paramm, B paramB) {
/*  76 */     throw new UnsupportedOperationException("Please use putInstance() instead.");
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
/*     */   public void putAll(Map<? extends m<? extends B>, ? extends B> paramMap) {
/*  88 */     throw new UnsupportedOperationException("Please use putInstance() instead.");
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<m<? extends B>, B>> entrySet() {
/*  93 */     return a.e(super.entrySet());
/*     */   }
/*     */ 
/*     */   
/*     */   protected Map<m<? extends B>, B> s() {
/*  98 */     return this.H;
/*     */   }
/*     */ 
/*     */   
/*     */   private <T extends B> T c(m<T> paramm, T paramT) {
/* 103 */     return (T)this.H.put(paramm, (B)paramT);
/*     */   }
/*     */ 
/*     */   
/*     */   private <T extends B> T b(m<T> paramm) {
/* 108 */     return (T)this.H.get(paramm);
/*     */   }
/*     */   
/*     */   private static final class a<K, V>
/*     */     extends aD<K, V> {
/*     */     private final Map.Entry<K, V> a;
/*     */     
/*     */     static <K, V> Set<Map.Entry<K, V>> e(Set<Map.Entry<K, V>> param1Set) {
/* 116 */       return (Set<Map.Entry<K, V>>)new aK<Map.Entry<K, V>>(param1Set)
/*     */         {
/*     */           protected Set<Map.Entry<K, V>> a() {
/* 119 */             return this.B;
/*     */           }
/*     */ 
/*     */           
/*     */           public Iterator<Map.Entry<K, V>> iterator() {
/* 124 */             return f.a.j(super.iterator());
/*     */           }
/*     */ 
/*     */           
/*     */           public Object[] toArray() {
/* 129 */             return c();
/*     */           }
/*     */ 
/*     */           
/*     */           public <T> T[] toArray(T[] param2ArrayOfT) {
/* 134 */             return (T[])a((Object[])param2ArrayOfT);
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     private static <K, V> Iterator<Map.Entry<K, V>> i(Iterator<Map.Entry<K, V>> param1Iterator) {
/* 140 */       return bH.a(param1Iterator, new s<Map.Entry<K, V>, Map.Entry<K, V>>()
/*     */           {
/*     */             
/*     */             public Map.Entry<K, V> e(Map.Entry<K, V> param2Entry)
/*     */             {
/* 145 */               return (Map.Entry)new f.a<>(param2Entry);
/*     */             }
/*     */           });
/*     */     }
/*     */     
/*     */     private a(Map.Entry<K, V> param1Entry) {
/* 151 */       this.a = (Map.Entry<K, V>)D.checkNotNull(param1Entry);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Map.Entry<K, V> a() {
/* 156 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 161 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */