/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.z;
/*     */ import com.google.b.a.f;
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
/*     */ @f
/*     */ @a
/*     */ public final class t<N>
/*     */   extends d<N>
/*     */ {
/*     */   private t(boolean paramBoolean) {
/*  71 */     super(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public static t<Object> a() {
/*  76 */     return new t(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static t<Object> b() {
/*  81 */     return new t(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <N> t<N> a(s<N> params) {
/*  92 */     return (new t(params.cX()))
/*  93 */       .a(params.cY())
/*  94 */       .a(params.b())
/*  95 */       .b(params.a());
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
/*     */   public <N1 extends N> x.a<N1> a() {
/* 109 */     t<N1> t1 = d();
/* 110 */     return new x.a<>(t1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t<N> a(boolean paramBoolean) {
/* 121 */     this.aU = paramBoolean;
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t<N> a(int paramInt) {
/* 131 */     this.b = z.a(Integer.valueOf(w.F(paramInt)));
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <N1 extends N> t<N1> a(m<N1> paramm) {
/* 141 */     t<N1> t1 = d();
/* 142 */     t1.a = (m<N>)D.checkNotNull(paramm);
/* 143 */     return t1;
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
/*     */   public <N1 extends N> t<N1> b(m<N1> paramm) {
/* 160 */     D.a((paramm
/* 161 */         .a() == m.a.b || paramm
/* 162 */         .a() == m.a.c), "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", paramm);
/*     */ 
/*     */ 
/*     */     
/* 166 */     t<N1> t1 = d();
/* 167 */     t1.b = (z<Integer>)D.checkNotNull(paramm);
/* 168 */     return t1;
/*     */   }
/*     */ 
/*     */   
/*     */   public <N1 extends N> E<N1> a() {
/* 173 */     return new L<>(this);
/*     */   }
/*     */   
/*     */   t<N> c() {
/* 177 */     t<N> t1 = new t(this.aT);
/* 178 */     t1.aU = this.aU;
/* 179 */     t1.a = this.a;
/* 180 */     t1.b = this.b;
/* 181 */     t1.b = this.b;
/* 182 */     return t1;
/*     */   }
/*     */ 
/*     */   
/*     */   private <N1 extends N> t<N1> d() {
/* 187 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */