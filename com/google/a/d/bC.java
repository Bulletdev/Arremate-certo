/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.p;
/*     */ import com.google.b.a.j;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
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
/*     */ @j(a = {"B"})
/*     */ @c
/*     */ public final class bc<B>
/*     */   extends aC<Class<? extends B>, B>
/*     */   implements A<B>, Serializable
/*     */ {
/*  41 */   private static final bc<Object> a = new bc(
/*  42 */       bj.f());
/*     */ 
/*     */ 
/*     */   
/*     */   private final bj<Class<? extends B>, B> h;
/*     */ 
/*     */ 
/*     */   
/*     */   public static <B> bc<B> a() {
/*  51 */     return (bc)a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <B, T extends B> bc<B> a(Class<T> paramClass, T paramT) {
/*  60 */     bj<Class<T>, T> bj1 = bj.a(paramClass, paramT);
/*  61 */     return new bc<>(bj1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <B> a<B> a() {
/*  69 */     return new a<>();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class a<B>
/*     */   {
/*  90 */     private final bj.a<Class<? extends B>, B> a = bj.a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public <T extends B> a<B> a(Class<T> param1Class, T param1T) {
/*  98 */       this.a.a(param1Class, (B)param1T);
/*  99 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public <T extends B> a<B> a(Map<? extends Class<? extends T>, ? extends T> param1Map) {
/* 111 */       for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : param1Map.entrySet()) {
/* 112 */         Class<? extends B> clazz = (Class)entry.getKey();
/* 113 */         Object object = entry.getValue();
/* 114 */         this.a.a(clazz, b((Class)clazz, object));
/*     */       } 
/* 116 */       return this;
/*     */     }
/*     */     
/*     */     private static <B, T extends B> T b(Class<T> param1Class, B param1B) {
/* 120 */       return p.wrap(param1Class).cast(param1B);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public bc<B> b() {
/* 130 */       bj<Class<? extends B>, B> bj = this.a.e();
/* 131 */       if (bj.isEmpty()) {
/* 132 */         return bc.a();
/*     */       }
/* 134 */       return new bc<>(bj);
/*     */     }
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <B, S extends B> bc<B> a(Map<? extends Class<? extends S>, ? extends S> paramMap) {
/* 152 */     if (paramMap instanceof bc)
/*     */     {
/* 154 */       return (bc)paramMap;
/*     */     }
/*     */     
/* 157 */     return (new a<>()).<S>a(paramMap).b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private bc(bj<Class<? extends B>, B> parambj) {
/* 163 */     this.h = parambj;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Map<Class<? extends B>, B> s() {
/* 168 */     return this.h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends B> T b(Class<T> paramClass) {
/* 174 */     return (T)this.h.get(D.checkNotNull(paramClass));
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
/*     */   public <T extends B> T a(Class<T> paramClass, T paramT) {
/* 187 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   Object readResolve() {
/* 191 */     return isEmpty() ? a() : this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */