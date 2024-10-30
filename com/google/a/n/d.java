/*     */ package com.google.a.n;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.d.aC;
/*     */ import com.google.a.d.bj;
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
/*     */ @a
/*     */ public final class d<B>
/*     */   extends aC<m<? extends B>, B>
/*     */   implements l<B>
/*     */ {
/*     */   private final bj<m<? extends B>, B> h;
/*     */   
/*     */   public static <B> d<B> a() {
/*  36 */     return new d<>(bj.f());
/*     */   }
/*     */ 
/*     */   
/*     */   public static <B> a<B> a() {
/*  41 */     return new a<>();
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
/*     */   @a
/*     */   public static final class a<B>
/*     */   {
/*  63 */     private final bj.a<m<? extends B>, B> a = bj.a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public <T extends B> a<B> a(Class<T> param1Class, T param1T) {
/*  73 */       this.a.a(m.a(param1Class), param1T);
/*  74 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public <T extends B> a<B> a(m<T> param1m, T param1T) {
/*  83 */       this.a.a(param1m.h(), param1T);
/*  84 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public d<B> b() {
/*  93 */       return new d<>(this.a.e());
/*     */     }
/*     */     
/*     */     private a() {}
/*     */   }
/*     */   
/*     */   private d(bj<m<? extends B>, B> parambj) {
/* 100 */     this.h = parambj;
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends B> T a(m<T> paramm) {
/* 105 */     return b(paramm.h());
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends B> T b(Class<T> paramClass) {
/* 110 */     return b(m.a(paramClass));
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
/*     */   public <T extends B> T a(m<T> paramm, T paramT) {
/* 123 */     throw new UnsupportedOperationException();
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
/* 136 */     throw new UnsupportedOperationException();
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
/* 149 */     throw new UnsupportedOperationException();
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
/* 161 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Map<m<? extends B>, B> s() {
/* 166 */     return (Map<m<? extends B>, B>)this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   private <T extends B> T b(m<T> paramm) {
/* 171 */     return (T)this.h.get(paramm);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */