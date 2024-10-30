/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.b.y;
/*     */ import com.google.a.d.bH;
/*     */ import com.google.a.d.bt;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class w
/*     */ {
/*     */   public static <N> boolean a(s<N> params) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokeinterface v : ()Ljava/util/Set;
/*     */     //   6: invokeinterface size : ()I
/*     */     //   11: istore_1
/*     */     //   12: iload_1
/*     */     //   13: ifne -> 18
/*     */     //   16: iconst_0
/*     */     //   17: ireturn
/*     */     //   18: aload_0
/*     */     //   19: invokeinterface cX : ()Z
/*     */     //   24: ifne -> 44
/*     */     //   27: iload_1
/*     */     //   28: aload_0
/*     */     //   29: invokeinterface A : ()Ljava/util/Set;
/*     */     //   34: invokeinterface size : ()I
/*     */     //   39: if_icmplt -> 44
/*     */     //   42: iconst_1
/*     */     //   43: ireturn
/*     */     //   44: aload_0
/*     */     //   45: invokeinterface A : ()Ljava/util/Set;
/*     */     //   50: invokeinterface size : ()I
/*     */     //   55: invokestatic a : (I)Ljava/util/HashMap;
/*     */     //   58: astore_2
/*     */     //   59: aload_0
/*     */     //   60: invokeinterface A : ()Ljava/util/Set;
/*     */     //   65: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   70: astore_3
/*     */     //   71: aload_3
/*     */     //   72: invokeinterface hasNext : ()Z
/*     */     //   77: ifeq -> 104
/*     */     //   80: aload_3
/*     */     //   81: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   86: astore #4
/*     */     //   88: aload_0
/*     */     //   89: aload_2
/*     */     //   90: aload #4
/*     */     //   92: aconst_null
/*     */     //   93: invokestatic a : (Lcom/google/a/g/s;Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   96: ifeq -> 101
/*     */     //   99: iconst_1
/*     */     //   100: ireturn
/*     */     //   101: goto -> 71
/*     */     //   104: iconst_0
/*     */     //   105: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #60	-> 0
/*     */     //   #61	-> 12
/*     */     //   #62	-> 16
/*     */     //   #64	-> 18
/*     */     //   #65	-> 42
/*     */     //   #68	-> 44
/*     */     //   #69	-> 45
/*     */     //   #70	-> 59
/*     */     //   #71	-> 88
/*     */     //   #72	-> 99
/*     */     //   #74	-> 101
/*     */     //   #75	-> 104
/*     */   }
/*     */   
/*     */   public static boolean a(H<?, ?> paramH) {
/*  88 */     if (!paramH.cX() && paramH
/*  89 */       .db() && paramH
/*  90 */       .v().size() > paramH.a().v().size()) {
/*  91 */       return true;
/*     */     }
/*  93 */     return a(paramH.a());
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
/*     */   private static <N> boolean a(s<N> params, Map<Object, a> paramMap, N paramN1, N paramN2) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: aload_2
/*     */     //   2: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   7: checkcast com/google/a/g/w$a
/*     */     //   10: astore #4
/*     */     //   12: aload #4
/*     */     //   14: getstatic com/google/a/g/w$a.b : Lcom/google/a/g/w$a;
/*     */     //   17: if_acmpne -> 22
/*     */     //   20: iconst_0
/*     */     //   21: ireturn
/*     */     //   22: aload #4
/*     */     //   24: getstatic com/google/a/g/w$a.a : Lcom/google/a/g/w$a;
/*     */     //   27: if_acmpne -> 32
/*     */     //   30: iconst_1
/*     */     //   31: ireturn
/*     */     //   32: aload_1
/*     */     //   33: aload_2
/*     */     //   34: getstatic com/google/a/g/w$a.a : Lcom/google/a/g/w$a;
/*     */     //   37: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   42: pop
/*     */     //   43: aload_0
/*     */     //   44: aload_2
/*     */     //   45: invokeinterface f : (Ljava/lang/Object;)Ljava/util/Set;
/*     */     //   50: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   55: astore #5
/*     */     //   57: aload #5
/*     */     //   59: invokeinterface hasNext : ()Z
/*     */     //   64: ifeq -> 102
/*     */     //   67: aload #5
/*     */     //   69: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   74: astore #6
/*     */     //   76: aload_0
/*     */     //   77: aload #6
/*     */     //   79: aload_3
/*     */     //   80: invokestatic a : (Lcom/google/a/g/s;Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   83: ifeq -> 99
/*     */     //   86: aload_0
/*     */     //   87: aload_1
/*     */     //   88: aload #6
/*     */     //   90: aload_2
/*     */     //   91: invokestatic a : (Lcom/google/a/g/s;Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   94: ifeq -> 99
/*     */     //   97: iconst_1
/*     */     //   98: ireturn
/*     */     //   99: goto -> 57
/*     */     //   102: aload_1
/*     */     //   103: aload_2
/*     */     //   104: getstatic com/google/a/g/w$a.b : Lcom/google/a/g/w$a;
/*     */     //   107: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   112: pop
/*     */     //   113: iconst_0
/*     */     //   114: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #103	-> 0
/*     */     //   #104	-> 12
/*     */     //   #105	-> 20
/*     */     //   #107	-> 22
/*     */     //   #108	-> 30
/*     */     //   #111	-> 32
/*     */     //   #112	-> 43
/*     */     //   #113	-> 76
/*     */     //   #114	-> 91
/*     */     //   #115	-> 97
/*     */     //   #117	-> 99
/*     */     //   #118	-> 102
/*     */     //   #119	-> 113
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
/*     */   private static boolean a(s<?> params, Object paramObject1, Object paramObject2) {
/* 130 */     if (params.cX() || !y.equal(paramObject2, paramObject1)) {
/* 131 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 135 */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <N> s<N> a(s<N> params) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokestatic a : (Lcom/google/a/g/s;)Lcom/google/a/g/t;
/*     */     //   4: iconst_1
/*     */     //   5: invokevirtual a : (Z)Lcom/google/a/g/t;
/*     */     //   8: invokevirtual a : ()Lcom/google/a/g/E;
/*     */     //   11: astore_1
/*     */     //   12: aload_0
/*     */     //   13: invokeinterface cX : ()Z
/*     */     //   18: ifeq -> 99
/*     */     //   21: aload_0
/*     */     //   22: invokeinterface A : ()Ljava/util/Set;
/*     */     //   27: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   32: astore_2
/*     */     //   33: aload_2
/*     */     //   34: invokeinterface hasNext : ()Z
/*     */     //   39: ifeq -> 96
/*     */     //   42: aload_2
/*     */     //   43: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   48: astore_3
/*     */     //   49: aload_0
/*     */     //   50: aload_3
/*     */     //   51: invokestatic a : (Lcom/google/a/g/s;Ljava/lang/Object;)Ljava/util/Set;
/*     */     //   54: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   59: astore #4
/*     */     //   61: aload #4
/*     */     //   63: invokeinterface hasNext : ()Z
/*     */     //   68: ifeq -> 93
/*     */     //   71: aload #4
/*     */     //   73: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   78: astore #5
/*     */     //   80: aload_1
/*     */     //   81: aload_3
/*     */     //   82: aload #5
/*     */     //   84: invokeinterface g : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   89: pop
/*     */     //   90: goto -> 61
/*     */     //   93: goto -> 33
/*     */     //   96: goto -> 251
/*     */     //   99: new java/util/HashSet
/*     */     //   102: dup
/*     */     //   103: invokespecial <init> : ()V
/*     */     //   106: astore_2
/*     */     //   107: aload_0
/*     */     //   108: invokeinterface A : ()Ljava/util/Set;
/*     */     //   113: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   118: astore_3
/*     */     //   119: aload_3
/*     */     //   120: invokeinterface hasNext : ()Z
/*     */     //   125: ifeq -> 251
/*     */     //   128: aload_3
/*     */     //   129: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   134: astore #4
/*     */     //   136: aload_2
/*     */     //   137: aload #4
/*     */     //   139: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   144: ifne -> 248
/*     */     //   147: aload_0
/*     */     //   148: aload #4
/*     */     //   150: invokestatic a : (Lcom/google/a/g/s;Ljava/lang/Object;)Ljava/util/Set;
/*     */     //   153: astore #5
/*     */     //   155: aload_2
/*     */     //   156: aload #5
/*     */     //   158: invokeinterface addAll : (Ljava/util/Collection;)Z
/*     */     //   163: pop
/*     */     //   164: iconst_1
/*     */     //   165: istore #6
/*     */     //   167: aload #5
/*     */     //   169: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   174: astore #7
/*     */     //   176: aload #7
/*     */     //   178: invokeinterface hasNext : ()Z
/*     */     //   183: ifeq -> 248
/*     */     //   186: aload #7
/*     */     //   188: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   193: astore #8
/*     */     //   195: aload #5
/*     */     //   197: iload #6
/*     */     //   199: iinc #6, 1
/*     */     //   202: invokestatic d : (Ljava/lang/Iterable;I)Ljava/lang/Iterable;
/*     */     //   205: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   210: astore #9
/*     */     //   212: aload #9
/*     */     //   214: invokeinterface hasNext : ()Z
/*     */     //   219: ifeq -> 245
/*     */     //   222: aload #9
/*     */     //   224: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   229: astore #10
/*     */     //   231: aload_1
/*     */     //   232: aload #8
/*     */     //   234: aload #10
/*     */     //   236: invokeinterface g : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   241: pop
/*     */     //   242: goto -> 212
/*     */     //   245: goto -> 176
/*     */     //   248: goto -> 119
/*     */     //   251: aload_1
/*     */     //   252: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #149	-> 0
/*     */     //   #153	-> 12
/*     */     //   #155	-> 21
/*     */     //   #156	-> 49
/*     */     //   #157	-> 80
/*     */     //   #158	-> 90
/*     */     //   #159	-> 93
/*     */     //   #163	-> 99
/*     */     //   #164	-> 107
/*     */     //   #165	-> 136
/*     */     //   #166	-> 147
/*     */     //   #167	-> 155
/*     */     //   #168	-> 164
/*     */     //   #169	-> 167
/*     */     //   #170	-> 195
/*     */     //   #171	-> 231
/*     */     //   #172	-> 242
/*     */     //   #173	-> 245
/*     */     //   #175	-> 248
/*     */     //   #178	-> 251
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <N> Set<N> a(s<N> params, N paramN) {
/* 193 */     D.a(params.A().contains(paramN), "Node %s is not an element of this graph.", paramN);
/* 194 */     return (Set<N>)bt.a(R.<N>a(params).d(paramN));
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
/*     */   public static <N> s<N> b(s<N> params) {
/* 206 */     if (!params.cX()) {
/* 207 */       return params;
/*     */     }
/*     */     
/* 210 */     if (params instanceof b) {
/* 211 */       return b.a((b)params);
/*     */     }
/*     */     
/* 214 */     return new b<>(params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <N, V> V<N, V> a(V<N, V> paramV) {
/* 222 */     if (!paramV.cX()) {
/* 223 */       return paramV;
/*     */     }
/*     */     
/* 226 */     if (paramV instanceof d) {
/* 227 */       return d.a((d)paramV);
/*     */     }
/*     */     
/* 230 */     return new d<>(paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <N, E> H<N, E> a(H<N, E> paramH) {
/* 238 */     if (!paramH.cX()) {
/* 239 */       return paramH;
/*     */     }
/*     */     
/* 242 */     if (paramH instanceof c) {
/* 243 */       return c.a((c)paramH);
/*     */     }
/*     */     
/* 246 */     return new c<>(paramH);
/*     */   }
/*     */   
/*     */   static <N> n<N> a(n<N> paramn) {
/* 250 */     if (paramn.cZ()) {
/* 251 */       return n.a(paramn.C(), paramn.B());
/*     */     }
/* 253 */     return paramn;
/*     */   }
/*     */   
/*     */   private static class b<N>
/*     */     extends p<N>
/*     */   {
/*     */     private final s<N> a;
/*     */     
/*     */     b(s<N> param1s) {
/* 262 */       this.a = param1s;
/*     */     }
/*     */ 
/*     */     
/*     */     protected s<N> b() {
/* 267 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<N> e(N param1N) {
/* 272 */       return b().f(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<N> f(N param1N) {
/* 277 */       return b().e(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<n<N>> b(N param1N) {
/* 282 */       return new A<N>(this, this, param1N)
/*     */         {
/*     */           public Iterator<n<N>> iterator() {
/* 285 */             return bH.a(this.a
/* 286 */                 .b().b(this.ah).iterator(), new s<n<N>, n<N>>(this)
/*     */                 {
/*     */                   public n<N> b(n<N> param3n)
/*     */                   {
/* 290 */                     return n.a(this.a.a.b(), param3n.E(), param3n.D());
/*     */                   }
/*     */                 });
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public int n(N param1N) {
/* 299 */       return b().o(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public int o(N param1N) {
/* 304 */       return b().n(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean f(N param1N1, N param1N2) {
/* 309 */       return b().f(param1N2, param1N1);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean a(n<N> param1n) {
/* 314 */       return b().a(w.a(param1n));
/*     */     }
/*     */   }
/*     */   
/*     */   private static class d<N, V>
/*     */     extends r<N, V>
/*     */   {
/*     */     private final V<N, V> b;
/*     */     
/*     */     d(V<N, V> param1V) {
/* 324 */       this.b = param1V;
/*     */     }
/*     */ 
/*     */     
/*     */     protected V<N, V> a() {
/* 329 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<N> e(N param1N) {
/* 334 */       return a().f(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<N> f(N param1N) {
/* 339 */       return a().e(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public int n(N param1N) {
/* 344 */       return a().o(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public int o(N param1N) {
/* 349 */       return a().n(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean f(N param1N1, N param1N2) {
/* 354 */       return a().f(param1N2, param1N1);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean a(n<N> param1n) {
/* 359 */       return a().a(w.a(param1n));
/*     */     }
/*     */ 
/*     */     
/*     */     public Optional<V> b(N param1N1, N param1N2) {
/* 364 */       return a().b(param1N2, param1N1);
/*     */     }
/*     */ 
/*     */     
/*     */     public Optional<V> b(n<N> param1n) {
/* 369 */       return a().b(w.a(param1n));
/*     */     }
/*     */ 
/*     */     
/*     */     public V a(N param1N1, N param1N2, V param1V) {
/* 374 */       return a().a(param1N2, param1N1, param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public V a(n<N> param1n, V param1V) {
/* 379 */       return a().a(w.a(param1n), param1V);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class c<N, E> extends q<N, E> {
/*     */     private final H<N, E> b;
/*     */     
/*     */     c(H<N, E> param1H) {
/* 387 */       this.b = param1H;
/*     */     }
/*     */ 
/*     */     
/*     */     protected H<N, E> a() {
/* 392 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<N> e(N param1N) {
/* 397 */       return a().f(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<N> f(N param1N) {
/* 402 */       return a().e(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public int n(N param1N) {
/* 407 */       return a().o(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public int o(N param1N) {
/* 412 */       return a().n(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<E> h(N param1N) {
/* 417 */       return a().i(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<E> i(N param1N) {
/* 422 */       return a().h(param1N);
/*     */     }
/*     */ 
/*     */     
/*     */     public n<N> b(E param1E) {
/* 427 */       n<N> n = a().b(param1E);
/* 428 */       return n.a(this.b, n.E(), n.D());
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<E> a(N param1N1, N param1N2) {
/* 433 */       return a().a(param1N2, param1N1);
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<E> a(n<N> param1n) {
/* 438 */       return a().a(w.a(param1n));
/*     */     }
/*     */ 
/*     */     
/*     */     public Optional<E> a(N param1N1, N param1N2) {
/* 443 */       return a().a(param1N2, param1N1);
/*     */     }
/*     */ 
/*     */     
/*     */     public Optional<E> a(n<N> param1n) {
/* 448 */       return a().a(w.a(param1n));
/*     */     }
/*     */ 
/*     */     
/*     */     public E l(N param1N1, N param1N2) {
/* 453 */       return a().l(param1N2, param1N1);
/*     */     }
/*     */ 
/*     */     
/*     */     public E a(n<N> param1n) {
/* 458 */       return a().a(w.a(param1n));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean f(N param1N1, N param1N2) {
/* 463 */       return a().f(param1N2, param1N1);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean a(n<N> param1n) {
/* 468 */       return a().a(w.a(param1n));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <N> E<N> a(s<N> params, Iterable<? extends N> paramIterable) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: instanceof java/util/Collection
/*     */     //   4: ifeq -> 29
/*     */     //   7: aload_0
/*     */     //   8: invokestatic a : (Lcom/google/a/g/s;)Lcom/google/a/g/t;
/*     */     //   11: aload_1
/*     */     //   12: checkcast java/util/Collection
/*     */     //   15: invokeinterface size : ()I
/*     */     //   20: invokevirtual a : (I)Lcom/google/a/g/t;
/*     */     //   23: invokevirtual a : ()Lcom/google/a/g/E;
/*     */     //   26: goto -> 36
/*     */     //   29: aload_0
/*     */     //   30: invokestatic a : (Lcom/google/a/g/s;)Lcom/google/a/g/t;
/*     */     //   33: invokevirtual a : ()Lcom/google/a/g/E;
/*     */     //   36: astore_2
/*     */     //   37: aload_1
/*     */     //   38: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   43: astore_3
/*     */     //   44: aload_3
/*     */     //   45: invokeinterface hasNext : ()Z
/*     */     //   50: ifeq -> 73
/*     */     //   53: aload_3
/*     */     //   54: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   59: astore #4
/*     */     //   61: aload_2
/*     */     //   62: aload #4
/*     */     //   64: invokeinterface v : (Ljava/lang/Object;)Z
/*     */     //   69: pop
/*     */     //   70: goto -> 44
/*     */     //   73: aload_2
/*     */     //   74: invokeinterface A : ()Ljava/util/Set;
/*     */     //   79: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   84: astore_3
/*     */     //   85: aload_3
/*     */     //   86: invokeinterface hasNext : ()Z
/*     */     //   91: ifeq -> 169
/*     */     //   94: aload_3
/*     */     //   95: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   100: astore #4
/*     */     //   102: aload_0
/*     */     //   103: aload #4
/*     */     //   105: invokeinterface f : (Ljava/lang/Object;)Ljava/util/Set;
/*     */     //   110: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   115: astore #5
/*     */     //   117: aload #5
/*     */     //   119: invokeinterface hasNext : ()Z
/*     */     //   124: ifeq -> 166
/*     */     //   127: aload #5
/*     */     //   129: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   134: astore #6
/*     */     //   136: aload_2
/*     */     //   137: invokeinterface A : ()Ljava/util/Set;
/*     */     //   142: aload #6
/*     */     //   144: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   149: ifeq -> 163
/*     */     //   152: aload_2
/*     */     //   153: aload #4
/*     */     //   155: aload #6
/*     */     //   157: invokeinterface g : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   162: pop
/*     */     //   163: goto -> 117
/*     */     //   166: goto -> 85
/*     */     //   169: aload_2
/*     */     //   170: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #483	-> 0
/*     */     //   #484	-> 7
/*     */     //   #485	-> 29
/*     */     //   #486	-> 37
/*     */     //   #487	-> 61
/*     */     //   #488	-> 70
/*     */     //   #489	-> 73
/*     */     //   #490	-> 102
/*     */     //   #491	-> 136
/*     */     //   #492	-> 152
/*     */     //   #494	-> 163
/*     */     //   #495	-> 166
/*     */     //   #496	-> 169
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
/*     */ 
/*     */   
/*     */   public static <N, V> G<N, V> a(V<N, V> paramV, Iterable<? extends N> paramIterable) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: instanceof java/util/Collection
/*     */     //   4: ifeq -> 29
/*     */     //   7: aload_0
/*     */     //   8: invokestatic a : (Lcom/google/a/g/V;)Lcom/google/a/g/W;
/*     */     //   11: aload_1
/*     */     //   12: checkcast java/util/Collection
/*     */     //   15: invokeinterface size : ()I
/*     */     //   20: invokevirtual a : (I)Lcom/google/a/g/W;
/*     */     //   23: invokevirtual a : ()Lcom/google/a/g/G;
/*     */     //   26: goto -> 36
/*     */     //   29: aload_0
/*     */     //   30: invokestatic a : (Lcom/google/a/g/V;)Lcom/google/a/g/W;
/*     */     //   33: invokevirtual a : ()Lcom/google/a/g/G;
/*     */     //   36: astore_2
/*     */     //   37: aload_1
/*     */     //   38: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   43: astore_3
/*     */     //   44: aload_3
/*     */     //   45: invokeinterface hasNext : ()Z
/*     */     //   50: ifeq -> 73
/*     */     //   53: aload_3
/*     */     //   54: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   59: astore #4
/*     */     //   61: aload_2
/*     */     //   62: aload #4
/*     */     //   64: invokeinterface v : (Ljava/lang/Object;)Z
/*     */     //   69: pop
/*     */     //   70: goto -> 44
/*     */     //   73: aload_2
/*     */     //   74: invokeinterface A : ()Ljava/util/Set;
/*     */     //   79: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   84: astore_3
/*     */     //   85: aload_3
/*     */     //   86: invokeinterface hasNext : ()Z
/*     */     //   91: ifeq -> 180
/*     */     //   94: aload_3
/*     */     //   95: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   100: astore #4
/*     */     //   102: aload_0
/*     */     //   103: aload #4
/*     */     //   105: invokeinterface f : (Ljava/lang/Object;)Ljava/util/Set;
/*     */     //   110: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   115: astore #5
/*     */     //   117: aload #5
/*     */     //   119: invokeinterface hasNext : ()Z
/*     */     //   124: ifeq -> 177
/*     */     //   127: aload #5
/*     */     //   129: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   134: astore #6
/*     */     //   136: aload_2
/*     */     //   137: invokeinterface A : ()Ljava/util/Set;
/*     */     //   142: aload #6
/*     */     //   144: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   149: ifeq -> 174
/*     */     //   152: aload_2
/*     */     //   153: aload #4
/*     */     //   155: aload #6
/*     */     //   157: aload_0
/*     */     //   158: aload #4
/*     */     //   160: aload #6
/*     */     //   162: aconst_null
/*     */     //   163: invokeinterface a : (Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   168: invokeinterface b : (Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   173: pop
/*     */     //   174: goto -> 117
/*     */     //   177: goto -> 85
/*     */     //   180: aload_2
/*     */     //   181: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #510	-> 0
/*     */     //   #511	-> 7
/*     */     //   #512	-> 29
/*     */     //   #513	-> 37
/*     */     //   #514	-> 61
/*     */     //   #515	-> 70
/*     */     //   #516	-> 73
/*     */     //   #517	-> 102
/*     */     //   #518	-> 136
/*     */     //   #519	-> 152
/*     */     //   #520	-> 163
/*     */     //   #519	-> 168
/*     */     //   #522	-> 174
/*     */     //   #523	-> 177
/*     */     //   #524	-> 180
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
/*     */ 
/*     */   
/*     */   public static <N, E> F<N, E> a(H<N, E> paramH, Iterable<? extends N> paramIterable) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: instanceof java/util/Collection
/*     */     //   4: ifeq -> 29
/*     */     //   7: aload_0
/*     */     //   8: invokestatic a : (Lcom/google/a/g/H;)Lcom/google/a/g/I;
/*     */     //   11: aload_1
/*     */     //   12: checkcast java/util/Collection
/*     */     //   15: invokeinterface size : ()I
/*     */     //   20: invokevirtual a : (I)Lcom/google/a/g/I;
/*     */     //   23: invokevirtual a : ()Lcom/google/a/g/F;
/*     */     //   26: goto -> 36
/*     */     //   29: aload_0
/*     */     //   30: invokestatic a : (Lcom/google/a/g/H;)Lcom/google/a/g/I;
/*     */     //   33: invokevirtual a : ()Lcom/google/a/g/F;
/*     */     //   36: astore_2
/*     */     //   37: aload_1
/*     */     //   38: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   43: astore_3
/*     */     //   44: aload_3
/*     */     //   45: invokeinterface hasNext : ()Z
/*     */     //   50: ifeq -> 73
/*     */     //   53: aload_3
/*     */     //   54: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   59: astore #4
/*     */     //   61: aload_2
/*     */     //   62: aload #4
/*     */     //   64: invokeinterface v : (Ljava/lang/Object;)Z
/*     */     //   69: pop
/*     */     //   70: goto -> 44
/*     */     //   73: aload_2
/*     */     //   74: invokeinterface A : ()Ljava/util/Set;
/*     */     //   79: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   84: astore_3
/*     */     //   85: aload_3
/*     */     //   86: invokeinterface hasNext : ()Z
/*     */     //   91: ifeq -> 186
/*     */     //   94: aload_3
/*     */     //   95: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   100: astore #4
/*     */     //   102: aload_0
/*     */     //   103: aload #4
/*     */     //   105: invokeinterface i : (Ljava/lang/Object;)Ljava/util/Set;
/*     */     //   110: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   115: astore #5
/*     */     //   117: aload #5
/*     */     //   119: invokeinterface hasNext : ()Z
/*     */     //   124: ifeq -> 183
/*     */     //   127: aload #5
/*     */     //   129: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   134: astore #6
/*     */     //   136: aload_0
/*     */     //   137: aload #6
/*     */     //   139: invokeinterface b : (Ljava/lang/Object;)Lcom/google/a/g/n;
/*     */     //   144: aload #4
/*     */     //   146: invokevirtual A : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   149: astore #7
/*     */     //   151: aload_2
/*     */     //   152: invokeinterface A : ()Ljava/util/Set;
/*     */     //   157: aload #7
/*     */     //   159: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   164: ifeq -> 180
/*     */     //   167: aload_2
/*     */     //   168: aload #4
/*     */     //   170: aload #7
/*     */     //   172: aload #6
/*     */     //   174: invokeinterface c : (Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   179: pop
/*     */     //   180: goto -> 117
/*     */     //   183: goto -> 85
/*     */     //   186: aload_2
/*     */     //   187: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #538	-> 0
/*     */     //   #539	-> 7
/*     */     //   #540	-> 29
/*     */     //   #541	-> 37
/*     */     //   #542	-> 61
/*     */     //   #543	-> 70
/*     */     //   #544	-> 73
/*     */     //   #545	-> 102
/*     */     //   #546	-> 136
/*     */     //   #547	-> 151
/*     */     //   #548	-> 167
/*     */     //   #550	-> 180
/*     */     //   #551	-> 183
/*     */     //   #552	-> 186
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
/*     */ 
/*     */   
/*     */   public static <N> E<N> a(s<N> params) {
/* 557 */     E<N> e = t.<N>a(params).a(params.A().size()).a();
/* 558 */     for (N n : params.A()) {
/* 559 */       e.v(n);
/*     */     }
/* 561 */     for (n<N> n : params.v()) {
/* 562 */       e.g(n.D(), n.E());
/*     */     }
/* 564 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <N, V> G<N, V> a(V<N, V> paramV) {
/* 570 */     G<N, V> g = W.<N, V>a(paramV).a(paramV.A().size()).a();
/* 571 */     for (N n : paramV.A()) {
/* 572 */       g.v(n);
/*     */     }
/* 574 */     for (n<N> n : paramV.v()) {
/* 575 */       g.b(n
/* 576 */           .D(), n.E(), paramV.a(n.D(), n.E(), null));
/*     */     }
/* 578 */     return g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <N, E> F<N, E> a(H<N, E> paramH) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokestatic a : (Lcom/google/a/g/H;)Lcom/google/a/g/I;
/*     */     //   4: aload_0
/*     */     //   5: invokeinterface A : ()Ljava/util/Set;
/*     */     //   10: invokeinterface size : ()I
/*     */     //   15: invokevirtual a : (I)Lcom/google/a/g/I;
/*     */     //   18: aload_0
/*     */     //   19: invokeinterface v : ()Ljava/util/Set;
/*     */     //   24: invokeinterface size : ()I
/*     */     //   29: invokevirtual b : (I)Lcom/google/a/g/I;
/*     */     //   32: invokevirtual a : ()Lcom/google/a/g/F;
/*     */     //   35: astore_1
/*     */     //   36: aload_0
/*     */     //   37: invokeinterface A : ()Ljava/util/Set;
/*     */     //   42: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   47: astore_2
/*     */     //   48: aload_2
/*     */     //   49: invokeinterface hasNext : ()Z
/*     */     //   54: ifeq -> 75
/*     */     //   57: aload_2
/*     */     //   58: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   63: astore_3
/*     */     //   64: aload_1
/*     */     //   65: aload_3
/*     */     //   66: invokeinterface v : (Ljava/lang/Object;)Z
/*     */     //   71: pop
/*     */     //   72: goto -> 48
/*     */     //   75: aload_0
/*     */     //   76: invokeinterface v : ()Ljava/util/Set;
/*     */     //   81: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   86: astore_2
/*     */     //   87: aload_2
/*     */     //   88: invokeinterface hasNext : ()Z
/*     */     //   93: ifeq -> 133
/*     */     //   96: aload_2
/*     */     //   97: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   102: astore_3
/*     */     //   103: aload_0
/*     */     //   104: aload_3
/*     */     //   105: invokeinterface b : (Ljava/lang/Object;)Lcom/google/a/g/n;
/*     */     //   110: astore #4
/*     */     //   112: aload_1
/*     */     //   113: aload #4
/*     */     //   115: invokevirtual D : ()Ljava/lang/Object;
/*     */     //   118: aload #4
/*     */     //   120: invokevirtual E : ()Ljava/lang/Object;
/*     */     //   123: aload_3
/*     */     //   124: invokeinterface c : (Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   129: pop
/*     */     //   130: goto -> 87
/*     */     //   133: aload_1
/*     */     //   134: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #583	-> 0
/*     */     //   #584	-> 1
/*     */     //   #585	-> 5
/*     */     //   #586	-> 19
/*     */     //   #587	-> 32
/*     */     //   #588	-> 36
/*     */     //   #589	-> 64
/*     */     //   #590	-> 72
/*     */     //   #591	-> 75
/*     */     //   #592	-> 103
/*     */     //   #593	-> 112
/*     */     //   #594	-> 130
/*     */     //   #595	-> 133
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   static int F(int paramInt) {
/* 600 */     D.a((paramInt >= 0), "Not true that %s is non-negative.", paramInt);
/* 601 */     return paramInt;
/*     */   }
/*     */   
/*     */   @com.google.b.a.a
/*     */   static long b(long paramLong) {
/* 606 */     D.a((paramLong >= 0L), "Not true that %s is non-negative.", paramLong);
/* 607 */     return paramLong;
/*     */   }
/*     */   
/*     */   @com.google.b.a.a
/*     */   static int G(int paramInt) {
/* 612 */     D.a((paramInt > 0), "Not true that %s is positive.", paramInt);
/* 613 */     return paramInt;
/*     */   }
/*     */   
/*     */   @com.google.b.a.a
/*     */   static long c(long paramLong) {
/* 618 */     D.a((paramLong > 0L), "Not true that %s is positive.", paramLong);
/* 619 */     return paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private enum a
/*     */   {
/* 628 */     a,
/* 629 */     b;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */