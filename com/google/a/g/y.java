/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.d.bW;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @j(a = {"N", "E"})
/*     */ @a
/*     */ public final class y<N, E>
/*     */   extends O<N, E>
/*     */ {
/*     */   private y(H<N, E> paramH) {
/*  52 */     super(
/*  53 */         I.a(paramH), b(paramH), c(paramH));
/*     */   }
/*     */ 
/*     */   
/*     */   public static <N, E> y<N, E> a(H<N, E> paramH) {
/*  58 */     return (paramH instanceof y) ? 
/*  59 */       (y<N, E>)paramH : 
/*  60 */       new y<>(paramH);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static <N, E> y<N, E> a(y<N, E> paramy) {
/*  70 */     return (y<N, E>)D.checkNotNull(paramy);
/*     */   }
/*     */ 
/*     */   
/*     */   public x<N> b() {
/*  75 */     return new x<>(super.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <N, E> Map<N, J<N, E>> b(H<N, E> paramH) {
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
/*     */     //   36: invokestatic a : (Lcom/google/a/g/H;Ljava/lang/Object;)Lcom/google/a/g/J;
/*     */     //   39: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/a/d/bj$a;
/*     */     //   42: pop
/*     */     //   43: goto -> 16
/*     */     //   46: aload_1
/*     */     //   47: invokevirtual e : ()Lcom/google/a/d/bj;
/*     */     //   50: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #82	-> 0
/*     */     //   #83	-> 4
/*     */     //   #84	-> 32
/*     */     //   #85	-> 43
/*     */     //   #86	-> 46
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <N, E> Map<E, N> c(H<N, E> paramH) {
/*     */     // Byte code:
/*     */     //   0: invokestatic a : ()Lcom/google/a/d/bj$a;
/*     */     //   3: astore_1
/*     */     //   4: aload_0
/*     */     //   5: invokeinterface v : ()Ljava/util/Set;
/*     */     //   10: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   15: astore_2
/*     */     //   16: aload_2
/*     */     //   17: invokeinterface hasNext : ()Z
/*     */     //   22: ifeq -> 51
/*     */     //   25: aload_2
/*     */     //   26: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   31: astore_3
/*     */     //   32: aload_1
/*     */     //   33: aload_3
/*     */     //   34: aload_0
/*     */     //   35: aload_3
/*     */     //   36: invokeinterface b : (Ljava/lang/Object;)Lcom/google/a/g/n;
/*     */     //   41: invokevirtual D : ()Ljava/lang/Object;
/*     */     //   44: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/a/d/bj$a;
/*     */     //   47: pop
/*     */     //   48: goto -> 16
/*     */     //   51: aload_1
/*     */     //   52: invokevirtual e : ()Lcom/google/a/d/bj;
/*     */     //   55: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #93	-> 0
/*     */     //   #94	-> 4
/*     */     //   #95	-> 32
/*     */     //   #96	-> 48
/*     */     //   #97	-> 51
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <N, E> J<N, E> a(H<N, E> paramH, N paramN) {
/* 101 */     if (paramH.cX()) {
/* 102 */       Map<E, N> map1 = bW.a(paramH.h(paramN), a(paramH));
/* 103 */       Map<E, N> map2 = bW.a(paramH.i(paramN), b(paramH));
/* 104 */       int i = paramH.a(paramN, paramN).size();
/* 105 */       return paramH.db() ? 
/* 106 */         j.<N, E>a(map1, map2, i) : 
/* 107 */         k.<N, E>a(map1, map2, i);
/*     */     } 
/*     */     
/* 110 */     Map<E, N> map = bW.a(paramH.b(paramN), a(paramH, paramN));
/* 111 */     return paramH.db() ? 
/* 112 */       T.<N, E>a(map) : 
/* 113 */       U.<N, E>a(map);
/*     */   }
/*     */ 
/*     */   
/*     */   private static <N, E> s<E, N> a(H<N, E> paramH) {
/* 118 */     return new s<E, N>(paramH)
/*     */       {
/*     */         public N apply(E param1E) {
/* 121 */           return this.a.b(param1E).B();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static <N, E> s<E, N> b(H<N, E> paramH) {
/* 127 */     return new s<E, N>(paramH)
/*     */       {
/*     */         public N apply(E param1E) {
/* 130 */           return this.a.b(param1E).C();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static <N, E> s<E, N> a(H<N, E> paramH, N paramN) {
/* 136 */     return new s<E, N>(paramH, paramN)
/*     */       {
/*     */         public N apply(E param1E) {
/* 139 */           return this.a.b(param1E).A(this.aj);
/*     */         }
/*     */       };
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
/*     */   public static class a<N, E>
/*     */   {
/*     */     private final F<N, E> a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     a(I<N, E> param1I) {
/* 172 */       this.a = param1I.a();
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
/*     */     public a<N, E> a(N param1N) {
/* 184 */       this.a.v(param1N);
/* 185 */       return this;
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
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<N, E> a(N param1N1, N param1N2, E param1E) {
/* 211 */       this.a.c(param1N1, param1N2, param1E);
/* 212 */       return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<N, E> a(n<N> param1n, E param1E) {
/* 242 */       this.a.a(param1n, param1E);
/* 243 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public y<N, E> a() {
/* 251 */       return y.a(this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\y.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */