/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.b.u;
/*     */ import com.google.a.d.bW;
/*     */ import com.google.a.d.bj;
/*     */ import com.google.b.a.j;
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
/*     */ @j(a = {"N"})
/*     */ @a
/*     */ public class x<N>
/*     */   extends p<N>
/*     */ {
/*     */   private final h<N> b;
/*     */   
/*     */   x(h<N> paramh) {
/*  53 */     this.b = paramh;
/*     */   }
/*     */ 
/*     */   
/*     */   public static <N> x<N> a(s<N> params) {
/*  58 */     return (params instanceof x) ? 
/*  59 */       (x<N>)params : 
/*  60 */       new x<>(new P<>(
/*     */           
/*  62 */           t.a(params), (Map<N, u<N, ?>>)a(params), params.v().size()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static <N> x<N> a(x<N> paramx) {
/*  72 */     return (x<N>)D.checkNotNull(paramx);
/*     */   }
/*     */ 
/*     */   
/*     */   public m<N> a() {
/*  77 */     return m.d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <N> bj<N, u<N, v.a>> a(s<N> params) {
/*     */     // Byte code:
/*     */     //   0: invokestatic a : ()Lcom/google/a/d/bj$a;
/*     */     //   3: astore_1
/*     */     //   4: aload_0
/*     */     //   5: invokeinterface A : ()Ljava/util/Set;
/*     */     //   10: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   15: astore_2
/*     */     //   16: aload_2
/*     */     //   17: invokeinterface hasNext : ()Z
/*     */     //   22: ifeq -> 46
/*     */     //   25: aload_2
/*     */     //   26: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   31: astore_3
/*     */     //   32: aload_1
/*     */     //   33: aload_3
/*     */     //   34: aload_0
/*     */     //   35: aload_3
/*     */     //   36: invokestatic a : (Lcom/google/a/g/s;Ljava/lang/Object;)Lcom/google/a/g/u;
/*     */     //   39: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/a/d/bj$a;
/*     */     //   42: pop
/*     */     //   43: goto -> 16
/*     */     //   46: aload_1
/*     */     //   47: invokevirtual e : ()Lcom/google/a/d/bj;
/*     */     //   50: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #85	-> 0
/*     */     //   #86	-> 4
/*     */     //   #87	-> 32
/*     */     //   #88	-> 43
/*     */     //   #89	-> 46
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <N> u<N, v.a> a(s<N> params, N paramN) {
/*  95 */     s<N, v.a> s1 = u.a(v.a.a);
/*  96 */     return params.cX() ? 
/*  97 */       i.<N, v.a>a(paramN, params.b(paramN), s1) : 
/*  98 */       S.<N, v.a>a(
/*  99 */         bW.a(params.d(paramN), s1));
/*     */   }
/*     */ 
/*     */   
/*     */   protected h<N> a() {
/* 104 */     return this.b;
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
/*     */   public static class a<N>
/*     */   {
/*     */     private final E<N> a;
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
/*     */     a(t<N> param1t) {
/* 135 */       this.a = param1t.c().b(m.d()).a();
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
/*     */     public a<N> a(N param1N) {
/* 147 */       this.a.v(param1N);
/* 148 */       return this;
/*     */     }
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
/*     */     @com.google.b.a.a
/*     */     public a<N> a(N param1N1, N param1N2) {
/* 166 */       this.a.g(param1N1, param1N2);
/* 167 */       return this;
/*     */     }
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
/*     */     @com.google.b.a.a
/*     */     public a<N> a(n<N> param1n) {
/* 189 */       this.a.c(param1n);
/* 190 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public x<N> a() {
/* 197 */       return x.a(this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */