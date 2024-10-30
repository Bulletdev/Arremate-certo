/*     */ package org.d.a;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.d.g;
/*     */ import org.d.i;
/*     */ import org.d.k;
/*     */ import org.d.m;
/*     */ import org.d.o;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class h<T>
/*     */   extends o<Iterable<? super T>>
/*     */ {
/*     */   private final k<? super T> d;
/*     */   
/*     */   public h(k<? super T> paramk) {
/*  18 */     this.d = paramk;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean a(Iterable<? super T> paramIterable, g paramg) {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_3
/*     */     //   2: aload_1
/*     */     //   3: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   8: astore #4
/*     */     //   10: aload #4
/*     */     //   12: invokeinterface hasNext : ()Z
/*     */     //   17: ifeq -> 75
/*     */     //   20: aload #4
/*     */     //   22: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   27: astore #5
/*     */     //   29: aload_0
/*     */     //   30: getfield d : Lorg/d/k;
/*     */     //   33: aload #5
/*     */     //   35: invokeinterface E : (Ljava/lang/Object;)Z
/*     */     //   40: ifeq -> 45
/*     */     //   43: iconst_1
/*     */     //   44: ireturn
/*     */     //   45: iload_3
/*     */     //   46: ifeq -> 58
/*     */     //   49: aload_2
/*     */     //   50: ldc ', '
/*     */     //   52: invokeinterface a : (Ljava/lang/String;)Lorg/d/g;
/*     */     //   57: pop
/*     */     //   58: aload_0
/*     */     //   59: getfield d : Lorg/d/k;
/*     */     //   62: aload #5
/*     */     //   64: aload_2
/*     */     //   65: invokeinterface a : (Ljava/lang/Object;Lorg/d/g;)V
/*     */     //   70: iconst_1
/*     */     //   71: istore_3
/*     */     //   72: goto -> 10
/*     */     //   75: iconst_0
/*     */     //   76: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #23	-> 0
/*     */     //   #24	-> 2
/*     */     //   #25	-> 29
/*     */     //   #26	-> 43
/*     */     //   #28	-> 45
/*     */     //   #29	-> 49
/*     */     //   #31	-> 58
/*     */     //   #32	-> 70
/*     */     //   #34	-> 75
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(g paramg) {
/*  39 */     paramg.a("a collection containing ").a((m)this.d);
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
/*     */   @i
/*     */   public static <T> k<Iterable<? super T>> c(k<? super T> paramk) {
/*  59 */     return (k)new h<T>(paramk);
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
/*     */   @i
/*     */   public static <T> k<Iterable<? super T>> b(T paramT) {
/*  77 */     return (k<Iterable<? super T>>)new h(i.c(paramT));
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
/*     */   @i
/*     */   public static <T> k<Iterable<T>> b(k<? super T>... paramVarArgs) {
/*  94 */     ArrayList<k<? super Iterable<T>>> arrayList = new ArrayList(paramVarArgs.length);
/*     */     
/*  96 */     for (k<? super T> k1 : paramVarArgs)
/*     */     {
/*  98 */       arrayList.add(new h<T>(k1));
/*     */     }
/*     */     
/* 101 */     return a.a(arrayList);
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
/*     */   @i
/*     */   public static <T> k<Iterable<T>> a(T... paramVarArgs) {
/* 118 */     ArrayList<k<? super Iterable<T>>> arrayList = new ArrayList(paramVarArgs.length);
/* 119 */     for (T t : paramVarArgs) {
/* 120 */       arrayList.add(b(t));
/*     */     }
/*     */     
/* 123 */     return a.a(arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */