/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.p;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Spliterator;
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
/*     */ 
/*     */ 
/*     */ @c
/*     */ public final class ce<B>
/*     */   extends aC<Class<? extends B>, B>
/*     */   implements A<B>, Serializable
/*     */ {
/*     */   private final Map<Class<? extends B>, B> F;
/*     */   
/*     */   public static <B> ce<B> a() {
/*  53 */     return new ce<>(new HashMap<>());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <B> ce<B> a(Map<Class<? extends B>, B> paramMap) {
/*  62 */     return new ce<>(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ce(Map<Class<? extends B>, B> paramMap) {
/*  68 */     this.F = (Map<Class<? extends B>, B>)D.checkNotNull(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Map<Class<? extends B>, B> s() {
/*  73 */     return this.F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <B> Map.Entry<Class<? extends B>, B> h(Map.Entry<Class<? extends B>, B> paramEntry) {
/*  81 */     return new aD<Class<? extends B>, B>(paramEntry)
/*     */       {
/*     */         protected Map.Entry<Class<? extends B>, B> a() {
/*  84 */           return this.f;
/*     */         }
/*     */ 
/*     */         
/*     */         public B setValue(B param1B) {
/*  89 */           return super.setValue((B)ce.d(getKey(), param1B));
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
/*  96 */     return new aK<Map.Entry<Class<? extends B>, B>>(this)
/*     */       {
/*     */         protected Set<Map.Entry<Class<? extends B>, B>> a()
/*     */         {
/* 100 */           return this.a.s().entrySet();
/*     */         }
/*     */ 
/*     */         
/*     */         public Spliterator<Map.Entry<Class<? extends B>, B>> spliterator() {
/* 105 */           return D.a(
/* 106 */               a().spliterator(), param1Entry -> ce.i(param1Entry));
/*     */         }
/*     */ 
/*     */         
/*     */         public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
/* 111 */           return new db<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>>(this, 
/* 112 */               a().iterator())
/*     */             {
/*     */               Map.Entry<Class<? extends B>, B> f(Map.Entry<Class<? extends B>, B> param2Entry) {
/* 115 */                 return ce.i(param2Entry);
/*     */               }
/*     */             };
/*     */         }
/*     */ 
/*     */         
/*     */         public Object[] toArray() {
/* 122 */           return c();
/*     */         }
/*     */ 
/*     */         
/*     */         public <T> T[] toArray(T[] param1ArrayOfT) {
/* 127 */           return (T[])a((Object[])param1ArrayOfT);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public B c(Class<? extends B> paramClass, B paramB) {
/* 135 */     return super.put(paramClass, b((Class)paramClass, paramB));
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends Class<? extends B>, ? extends B> paramMap) {
/* 140 */     LinkedHashMap<Class<? extends B>, B> linkedHashMap = new LinkedHashMap<>(paramMap);
/* 141 */     for (Map.Entry<Class<? extends B>, B> entry : linkedHashMap.entrySet()) {
/* 142 */       b((Class)entry.getKey(), entry.getValue());
/*     */     }
/* 144 */     super.putAll(linkedHashMap);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public <T extends B> T a(Class<T> paramClass, T paramT) {
/* 150 */     return b(paramClass, c(paramClass, (B)paramT));
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends B> T b(Class<T> paramClass) {
/* 155 */     return b(paramClass, get(paramClass));
/*     */   }
/*     */   
/*     */   @com.google.b.a.a
/*     */   private static <B, T extends B> T b(Class<T> paramClass, B paramB) {
/* 160 */     return p.wrap(paramClass).cast(paramB);
/*     */   }
/*     */   
/*     */   private Object writeReplace() {
/* 164 */     return new a<>(s());
/*     */   }
/*     */   
/*     */   private static final class a<B> implements Serializable {
/*     */     private final Map<Class<? extends B>, B> H;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(Map<Class<? extends B>, B> param1Map) {
/* 172 */       this.H = param1Map;
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 176 */       return ce.a(this.H);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ce.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */