/*     */ package org.junit.f;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import org.junit.b;
/*     */ import org.junit.c.b;
/*     */ import org.junit.c.c;
/*     */ import org.junit.c.e.c.e;
/*     */ import org.junit.e.h;
/*     */ import org.junit.e.l;
/*     */ import org.junit.f.a.c;
/*     */ import org.junit.f.a.d;
/*     */ import org.junit.f.a.e;
/*     */ import org.junit.f.a.f;
/*     */ import org.junit.f.a.g;
/*     */ import org.junit.f.a.k;
/*     */ import org.junit.f.a.l;
/*     */ import org.junit.f.a.m;
/*     */ import org.junit.g;
/*     */ import org.junit.g.c;
/*     */ import org.junit.g.e;
/*     */ import org.junit.h;
/*     */ import org.junit.j;
/*     */ import org.junit.runner.a.b;
/*     */ import org.junit.runner.a.c;
/*     */ import org.junit.runner.a.d;
/*     */ import org.junit.runner.a.e;
/*     */ import org.junit.runner.a.f;
/*     */ import org.junit.runner.a.g;
/*     */ import org.junit.runner.a.j;
/*     */ import org.junit.runner.b.c;
/*     */ import org.junit.runner.b.d;
/*     */ import org.junit.runner.c;
/*     */ import org.junit.runner.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class f<T>
/*     */   extends m
/*     */   implements c, f
/*     */ {
/*  68 */   private static final List<e> aQ = (List)Collections.singletonList(new c());
/*     */ 
/*     */   
/*  71 */   private final Lock c = new ReentrantLock();
/*     */   
/*     */   private final m a;
/*     */   
/*  75 */   private volatile List<T> aR = null;
/*     */   
/*  77 */   private volatile k a = new k(this) {
/*     */       public void a(Runnable param1Runnable) {
/*  79 */         param1Runnable.run();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void finished() {}
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   protected f(Class<?> paramClass) throws e {
/*  91 */     this.a = (k)a(paramClass);
/*  92 */     validate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected f(m paramm) throws e {
/* 101 */     this.a = (k)c.notNull(paramm);
/* 102 */     validate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected m a(Class<?> paramClass) {
/* 111 */     return new m(paramClass);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void t(List<Throwable> paramList) {
/* 148 */     a((Class)g.class, true, paramList);
/* 149 */     a((Class)b.class, true, paramList);
/* 150 */     G(paramList);
/* 151 */     F(paramList);
/*     */   }
/*     */   
/*     */   private void F(List<Throwable> paramList) {
/* 155 */     if (a().getJavaClass() != null) {
/* 156 */       for (e e : aQ) {
/* 157 */         paramList.addAll(e.b(a()));
/*     */       }
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
/*     */   protected void a(Class<? extends Annotation> paramClass, boolean paramBoolean, List<Throwable> paramList) {
/* 175 */     List list = a().a(paramClass);
/*     */     
/* 177 */     for (d d : list) {
/* 178 */       d.a(paramBoolean, paramList);
/*     */     }
/*     */   }
/*     */   
/*     */   private void G(List<Throwable> paramList) {
/* 183 */     org.junit.c.e.b.a.a.a(a(), paramList);
/* 184 */     org.junit.c.e.b.a.c.a(a(), paramList);
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
/*     */   protected l a(c paramc) {
/* 213 */     l l = b(paramc);
/* 214 */     if (!gw()) {
/* 215 */       l = c(l);
/* 216 */       l = d(l);
/* 217 */       l = e(l);
/* 218 */       l = f(l);
/*     */     } 
/* 220 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean gw() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial bt : ()Ljava/util/List;
/*     */     //   4: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   9: astore_1
/*     */     //   10: aload_1
/*     */     //   11: invokeinterface hasNext : ()Z
/*     */     //   16: ifeq -> 39
/*     */     //   19: aload_1
/*     */     //   20: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   25: astore_2
/*     */     //   26: aload_0
/*     */     //   27: aload_2
/*     */     //   28: invokevirtual I : (Ljava/lang/Object;)Z
/*     */     //   31: ifne -> 36
/*     */     //   34: iconst_0
/*     */     //   35: ireturn
/*     */     //   36: goto -> 10
/*     */     //   39: iconst_1
/*     */     //   40: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #224	-> 0
/*     */     //   #225	-> 26
/*     */     //   #226	-> 34
/*     */     //   #229	-> 39
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected l c(l paraml) {
/* 238 */     List list = this.a.a(g.class);
/*     */     
/* 240 */     return list.isEmpty() ? paraml : (l)new org.junit.c.e.c.f(paraml, list, null);
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
/*     */   protected l d(l paraml) {
/* 252 */     List list = this.a.a(b.class);
/*     */     
/* 254 */     return list.isEmpty() ? paraml : (l)new e(paraml, list, null);
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
/*     */   private l e(l paraml) {
/* 268 */     List<l> list = bs();
/* 269 */     return list.isEmpty() ? paraml : (l)new h(paraml, list, a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<l> bs() {
/* 278 */     a a = new a();
/* 279 */     this.a.b(null, h.class, l.class, a);
/* 280 */     this.a.a(null, h.class, l.class, a);
/* 281 */     return a.bu();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected l b(c paramc) {
/* 290 */     return new l(this, paramc)
/*     */       {
/*     */         public void io() {
/* 293 */           f.a(this.a, this.b);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final l f(l paraml) {
/* 302 */     return new l(this, paraml)
/*     */       {
/*     */         public void io() throws Throwable {
/*     */           try {
/* 306 */             this.a.io();
/*     */           } finally {
/* 308 */             Thread.interrupted();
/*     */           } 
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
/*     */   protected boolean I(T paramT) {
/* 322 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(c paramc) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield a : Lorg/junit/f/a/k;
/*     */     //   4: astore_2
/*     */     //   5: aload_0
/*     */     //   6: invokespecial bt : ()Ljava/util/List;
/*     */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   14: astore_3
/*     */     //   15: aload_3
/*     */     //   16: invokeinterface hasNext : ()Z
/*     */     //   21: ifeq -> 52
/*     */     //   24: aload_3
/*     */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   30: astore #4
/*     */     //   32: aload_2
/*     */     //   33: new org/junit/f/f$4
/*     */     //   36: dup
/*     */     //   37: aload_0
/*     */     //   38: aload #4
/*     */     //   40: aload_1
/*     */     //   41: invokespecial <init> : (Lorg/junit/f/f;Ljava/lang/Object;Lorg/junit/runner/b/c;)V
/*     */     //   44: invokeinterface a : (Ljava/lang/Runnable;)V
/*     */     //   49: goto -> 15
/*     */     //   52: aload_2
/*     */     //   53: invokeinterface finished : ()V
/*     */     //   58: goto -> 72
/*     */     //   61: astore #5
/*     */     //   63: aload_2
/*     */     //   64: invokeinterface finished : ()V
/*     */     //   69: aload #5
/*     */     //   71: athrow
/*     */     //   72: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #326	-> 0
/*     */     //   #328	-> 5
/*     */     //   #329	-> 32
/*     */     //   #336	-> 52
/*     */     //   #337	-> 58
/*     */     //   #336	-> 61
/*     */     //   #338	-> 72
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   5	52	61	finally
/*     */     //   61	63	61	finally
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getName() {
/* 344 */     return this.a.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final m a() {
/* 355 */     return (m)this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(l paraml, c paramc, c paramc1) {
/* 363 */     org.junit.c.e.a.a a = new org.junit.c.e.a.a(paramc1, paramc);
/* 364 */     a.iA();
/*     */     try {
/* 366 */       paraml.io();
/* 367 */     } catch (b b) {
/* 368 */       a.b(b);
/* 369 */     } catch (Throwable throwable) {
/* 370 */       a.l(throwable);
/*     */     } finally {
/* 372 */       a.iz();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Annotation[] b() {
/* 381 */     return this.a.getAnnotations();
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
/*     */   public c a() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual a : ()Lorg/junit/f/a/m;
/*     */     //   4: invokevirtual getJavaClass : ()Ljava/lang/Class;
/*     */     //   7: astore_1
/*     */     //   8: aload_1
/*     */     //   9: ifnull -> 26
/*     */     //   12: aload_1
/*     */     //   13: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   16: aload_0
/*     */     //   17: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   20: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   23: ifne -> 41
/*     */     //   26: aload_0
/*     */     //   27: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   30: aload_0
/*     */     //   31: invokevirtual b : ()[Ljava/lang/annotation/Annotation;
/*     */     //   34: invokestatic a : (Ljava/lang/String;[Ljava/lang/annotation/Annotation;)Lorg/junit/runner/c;
/*     */     //   37: astore_2
/*     */     //   38: goto -> 50
/*     */     //   41: aload_1
/*     */     //   42: aload_0
/*     */     //   43: invokevirtual b : ()[Ljava/lang/annotation/Annotation;
/*     */     //   46: invokestatic a : (Ljava/lang/Class;[Ljava/lang/annotation/Annotation;)Lorg/junit/runner/c;
/*     */     //   49: astore_2
/*     */     //   50: aload_0
/*     */     //   51: invokespecial bt : ()Ljava/util/List;
/*     */     //   54: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   59: astore_3
/*     */     //   60: aload_3
/*     */     //   61: invokeinterface hasNext : ()Z
/*     */     //   66: ifeq -> 90
/*     */     //   69: aload_3
/*     */     //   70: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   75: astore #4
/*     */     //   77: aload_2
/*     */     //   78: aload_0
/*     */     //   79: aload #4
/*     */     //   81: invokevirtual a : (Ljava/lang/Object;)Lorg/junit/runner/c;
/*     */     //   84: invokevirtual g : (Lorg/junit/runner/c;)V
/*     */     //   87: goto -> 60
/*     */     //   90: aload_2
/*     */     //   91: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #390	-> 0
/*     */     //   #394	-> 8
/*     */     //   #395	-> 26
/*     */     //   #397	-> 41
/*     */     //   #400	-> 50
/*     */     //   #401	-> 77
/*     */     //   #403	-> 90
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
/*     */   public void a(c paramc) {
/* 408 */     org.junit.c.e.a.a a = new org.junit.c.e.a.a(paramc, a());
/*     */     
/* 410 */     a.iC();
/*     */     try {
/* 412 */       l l = a(paramc);
/* 413 */       l.io();
/* 414 */     } catch (b b) {
/* 415 */       a.b(b);
/* 416 */     } catch (d d) {
/* 417 */       throw d;
/* 418 */     } catch (Throwable throwable) {
/* 419 */       a.l(throwable);
/*     */     } finally {
/* 421 */       a.iD();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(b paramb) throws e {
/* 430 */     this.c.lock();
/*     */     try {
/* 432 */       ArrayList<T> arrayList = new ArrayList<T>(bt());
/* 433 */       for (Iterator<T> iterator = arrayList.iterator(); iterator.hasNext(); ) {
/* 434 */         T t = iterator.next();
/* 435 */         if (a(paramb, t)) {
/*     */           try {
/* 437 */             paramb.I(t);
/* 438 */           } catch (e e) {
/* 439 */             iterator.remove();
/*     */           }  continue;
/*     */         } 
/* 442 */         iterator.remove();
/*     */       } 
/*     */       
/* 445 */       this.aR = Collections.unmodifiableList(arrayList);
/* 446 */       if (this.aR.isEmpty()) {
/* 447 */         throw new e();
/*     */       }
/*     */     } finally {
/* 450 */       this.c.unlock();
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
/*     */   
/*     */   public void a(j paramj) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial gx : ()Z
/*     */     //   4: ifeq -> 8
/*     */     //   7: return
/*     */     //   8: aload_0
/*     */     //   9: getfield c : Ljava/util/concurrent/locks/Lock;
/*     */     //   12: invokeinterface lock : ()V
/*     */     //   17: aload_0
/*     */     //   18: invokespecial bt : ()Ljava/util/List;
/*     */     //   21: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   26: astore_2
/*     */     //   27: aload_2
/*     */     //   28: invokeinterface hasNext : ()Z
/*     */     //   33: ifeq -> 51
/*     */     //   36: aload_2
/*     */     //   37: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   42: astore_3
/*     */     //   43: aload_1
/*     */     //   44: aload_3
/*     */     //   45: invokevirtual I : (Ljava/lang/Object;)V
/*     */     //   48: goto -> 27
/*     */     //   51: new java/util/ArrayList
/*     */     //   54: dup
/*     */     //   55: aload_0
/*     */     //   56: invokespecial bt : ()Ljava/util/List;
/*     */     //   59: invokespecial <init> : (Ljava/util/Collection;)V
/*     */     //   62: astore_2
/*     */     //   63: aload_2
/*     */     //   64: aload_0
/*     */     //   65: aload_1
/*     */     //   66: invokespecial a : (Lorg/junit/runner/a/j;)Ljava/util/Comparator;
/*     */     //   69: invokestatic sort : (Ljava/util/List;Ljava/util/Comparator;)V
/*     */     //   72: aload_0
/*     */     //   73: aload_2
/*     */     //   74: invokestatic unmodifiableList : (Ljava/util/List;)Ljava/util/List;
/*     */     //   77: putfield aR : Ljava/util/List;
/*     */     //   80: aload_0
/*     */     //   81: getfield c : Ljava/util/concurrent/locks/Lock;
/*     */     //   84: invokeinterface unlock : ()V
/*     */     //   89: goto -> 106
/*     */     //   92: astore #4
/*     */     //   94: aload_0
/*     */     //   95: getfield c : Ljava/util/concurrent/locks/Lock;
/*     */     //   98: invokeinterface unlock : ()V
/*     */     //   103: aload #4
/*     */     //   105: athrow
/*     */     //   106: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #455	-> 0
/*     */     //   #456	-> 7
/*     */     //   #459	-> 8
/*     */     //   #461	-> 17
/*     */     //   #462	-> 43
/*     */     //   #464	-> 51
/*     */     //   #465	-> 63
/*     */     //   #466	-> 72
/*     */     //   #468	-> 80
/*     */     //   #469	-> 89
/*     */     //   #468	-> 92
/*     */     //   #470	-> 106
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   17	80	92	finally
/*     */     //   92	94	92	finally
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
/*     */   public void a(g paramg) throws d {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial gx : ()Z
/*     */     //   4: ifeq -> 8
/*     */     //   7: return
/*     */     //   8: aload_0
/*     */     //   9: getfield c : Ljava/util/concurrent/locks/Lock;
/*     */     //   12: invokeinterface lock : ()V
/*     */     //   17: aload_0
/*     */     //   18: invokespecial bt : ()Ljava/util/List;
/*     */     //   21: astore_2
/*     */     //   22: new java/util/LinkedHashMap
/*     */     //   25: dup
/*     */     //   26: aload_2
/*     */     //   27: invokeinterface size : ()I
/*     */     //   32: invokespecial <init> : (I)V
/*     */     //   35: astore_3
/*     */     //   36: aload_2
/*     */     //   37: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   42: astore #4
/*     */     //   44: aload #4
/*     */     //   46: invokeinterface hasNext : ()Z
/*     */     //   51: ifeq -> 129
/*     */     //   54: aload #4
/*     */     //   56: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   61: astore #5
/*     */     //   63: aload_0
/*     */     //   64: aload #5
/*     */     //   66: invokevirtual a : (Ljava/lang/Object;)Lorg/junit/runner/c;
/*     */     //   69: astore #6
/*     */     //   71: aload_3
/*     */     //   72: aload #6
/*     */     //   74: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   79: checkcast java/util/List
/*     */     //   82: astore #7
/*     */     //   84: aload #7
/*     */     //   86: ifnonnull -> 110
/*     */     //   89: new java/util/ArrayList
/*     */     //   92: dup
/*     */     //   93: iconst_1
/*     */     //   94: invokespecial <init> : (I)V
/*     */     //   97: astore #7
/*     */     //   99: aload_3
/*     */     //   100: aload #6
/*     */     //   102: aload #7
/*     */     //   104: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   109: pop
/*     */     //   110: aload #7
/*     */     //   112: aload #5
/*     */     //   114: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   119: pop
/*     */     //   120: aload_1
/*     */     //   121: aload #5
/*     */     //   123: invokevirtual I : (Ljava/lang/Object;)V
/*     */     //   126: goto -> 44
/*     */     //   129: aload_1
/*     */     //   130: aload_3
/*     */     //   131: invokeinterface keySet : ()Ljava/util/Set;
/*     */     //   136: invokevirtual b : (Ljava/util/Collection;)Ljava/util/List;
/*     */     //   139: astore #4
/*     */     //   141: new java/util/ArrayList
/*     */     //   144: dup
/*     */     //   145: aload_2
/*     */     //   146: invokeinterface size : ()I
/*     */     //   151: invokespecial <init> : (I)V
/*     */     //   154: astore_2
/*     */     //   155: aload #4
/*     */     //   157: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   162: astore #5
/*     */     //   164: aload #5
/*     */     //   166: invokeinterface hasNext : ()Z
/*     */     //   171: ifeq -> 207
/*     */     //   174: aload #5
/*     */     //   176: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   181: checkcast org/junit/runner/c
/*     */     //   184: astore #6
/*     */     //   186: aload_2
/*     */     //   187: aload_3
/*     */     //   188: aload #6
/*     */     //   190: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   195: checkcast java/util/Collection
/*     */     //   198: invokeinterface addAll : (Ljava/util/Collection;)Z
/*     */     //   203: pop
/*     */     //   204: goto -> 164
/*     */     //   207: aload_0
/*     */     //   208: aload_2
/*     */     //   209: invokestatic unmodifiableList : (Ljava/util/List;)Ljava/util/List;
/*     */     //   212: putfield aR : Ljava/util/List;
/*     */     //   215: aload_0
/*     */     //   216: getfield c : Ljava/util/concurrent/locks/Lock;
/*     */     //   219: invokeinterface unlock : ()V
/*     */     //   224: goto -> 241
/*     */     //   227: astore #8
/*     */     //   229: aload_0
/*     */     //   230: getfield c : Ljava/util/concurrent/locks/Lock;
/*     */     //   233: invokeinterface unlock : ()V
/*     */     //   238: aload #8
/*     */     //   240: athrow
/*     */     //   241: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #478	-> 0
/*     */     //   #479	-> 7
/*     */     //   #482	-> 8
/*     */     //   #484	-> 17
/*     */     //   #487	-> 22
/*     */     //   #489	-> 36
/*     */     //   #490	-> 63
/*     */     //   #491	-> 71
/*     */     //   #492	-> 84
/*     */     //   #493	-> 89
/*     */     //   #494	-> 99
/*     */     //   #496	-> 110
/*     */     //   #497	-> 120
/*     */     //   #498	-> 126
/*     */     //   #500	-> 129
/*     */     //   #502	-> 141
/*     */     //   #503	-> 155
/*     */     //   #504	-> 186
/*     */     //   #506	-> 207
/*     */     //   #508	-> 215
/*     */     //   #509	-> 224
/*     */     //   #508	-> 227
/*     */     //   #510	-> 241
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   17	215	227	finally
/*     */     //   227	229	227	finally
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
/*     */   private boolean gx() {
/* 518 */     return (a().getAnnotation(j.class) != null);
/*     */   }
/*     */   
/*     */   private void validate() throws e {
/* 522 */     ArrayList<Throwable> arrayList = new ArrayList();
/* 523 */     t(arrayList);
/* 524 */     if (!arrayList.isEmpty()) {
/* 525 */       throw new f(this.a.getJavaClass(), arrayList);
/*     */     }
/*     */   }
/*     */   
/*     */   private List<T> bt() {
/* 530 */     if (this.aR == null) {
/* 531 */       this.c.lock();
/*     */       try {
/* 533 */         if (this.aR == null) {
/* 534 */           this.aR = Collections.unmodifiableList(new ArrayList<T>(getChildren()));
/*     */         }
/*     */       } finally {
/*     */         
/* 538 */         this.c.unlock();
/*     */       } 
/*     */     } 
/* 541 */     return this.aR;
/*     */   }
/*     */   
/*     */   private boolean a(b paramb, T paramT) {
/* 545 */     return paramb.b(a(paramT));
/*     */   }
/*     */   
/*     */   private Comparator<? super T> a(j paramj) {
/* 549 */     return new Comparator<T>(this, paramj) {
/*     */         public int compare(T param1T1, T param1T2) {
/* 551 */           return this.a.a(this.a.a(param1T1), this.a.a(param1T2));
/*     */         }
/*     */       };
/*     */   }
/*     */   protected abstract List<T> getChildren();
/*     */   protected abstract c a(T paramT);
/*     */   
/*     */   protected abstract void a(T paramT, c paramc);
/*     */   
/*     */   public void a(k paramk) {
/* 561 */     this.a = paramk;
/*     */   }
/*     */   
/*     */   private static class a implements g<l> {
/* 565 */     final List<g.a> entries = new ArrayList<g.a>();
/*     */     
/*     */     public void a(c<?> param1c, l param1l) {
/* 568 */       h h = (h)param1c.getAnnotation(h.class);
/* 569 */       this.entries.add(new g.a(param1l, 1, (h != null) ? Integer.valueOf(h.bT()) : null));
/*     */     }
/*     */ 
/*     */     
/*     */     public List<l> bu() {
/* 574 */       Collections.sort(this.entries, g.l);
/* 575 */       ArrayList<l> arrayList = new ArrayList(this.entries.size());
/* 576 */       for (g.a a1 : this.entries) {
/* 577 */         arrayList.add((l)a1.aL);
/*     */       }
/* 579 */       return arrayList;
/*     */     }
/*     */     
/*     */     private a() {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */