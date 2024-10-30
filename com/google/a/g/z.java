/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
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
/*     */ @j(a = {"N", "V"})
/*     */ @a
/*     */ public final class z<N, V>
/*     */   extends P<N, V>
/*     */ {
/*     */   private z(V<N, V> paramV) {
/*  49 */     super(W.a(paramV), (Map<N, u<N, V>>)a(paramV), paramV.v().size());
/*     */   }
/*     */ 
/*     */   
/*     */   public static <N, V> z<N, V> a(V<N, V> paramV) {
/*  54 */     return (paramV instanceof z) ? 
/*  55 */       (z<N, V>)paramV : 
/*  56 */       new z<>(paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static <N, V> z<N, V> a(z<N, V> paramz) {
/*  66 */     return (z<N, V>)D.checkNotNull(paramz);
/*     */   }
/*     */ 
/*     */   
/*     */   public m<N> a() {
/*  71 */     return m.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public x<N> b() {
/*  76 */     return new x<>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <N, V> bj<N, u<N, V>> a(V<N, V> paramV) {
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
/*     */     //   36: invokestatic a : (Lcom/google/a/g/V;Ljava/lang/Object;)Lcom/google/a/g/u;
/*     */     //   39: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/a/d/bj$a;
/*     */     //   42: pop
/*     */     //   43: goto -> 16
/*     */     //   46: aload_1
/*     */     //   47: invokevirtual e : ()Lcom/google/a/d/bj;
/*     */     //   50: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #84	-> 0
/*     */     //   #85	-> 4
/*     */     //   #86	-> 32
/*     */     //   #87	-> 43
/*     */     //   #88	-> 46
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <N, V> u<N, V> a(V<N, V> paramV, N paramN) {
/*  93 */     s<N, V> s = new s<N, V>(paramV, paramN)
/*     */       {
/*     */         public V apply(N param1N)
/*     */         {
/*  97 */           return this.a.a(this.aj, param1N, null);
/*     */         }
/*     */       };
/* 100 */     return paramV.cX() ? 
/* 101 */       i.<N, V>a(paramN, paramV
/* 102 */         .b(paramN), s) : 
/* 103 */       S.<N, V>a(
/* 104 */         bW.a(paramV.d(paramN), s));
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
/*     */   public static class a<N, V>
/*     */   {
/*     */     private final G<N, V> a;
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
/*     */     a(W<N, V> param1W) {
/* 135 */       this
/* 136 */         .a = param1W.c().b(m.d()).a();
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
/*     */     public a<N, V> a(N param1N) {
/* 148 */       this.a.v(param1N);
/* 149 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<N, V> a(N param1N1, N param1N2, V param1V) {
/* 170 */       this.a.b(param1N1, param1N2, param1V);
/* 171 */       return this;
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
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<N, V> a(n<N> param1n, V param1V) {
/* 195 */       this.a.b(param1n, param1V);
/* 196 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public z<N, V> a() {
/* 204 */       return z.a(this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\z.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */