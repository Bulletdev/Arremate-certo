/*     */ package org.d.a;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import org.d.g;
/*     */ import org.d.i;
/*     */ import org.d.k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b<T>
/*     */   extends n<T>
/*     */ {
/*     */   public b(Iterable<k<? super T>> paramIterable) {
/*  18 */     super(paramIterable);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean E(Object paramObject) {
/*  23 */     return a(paramObject, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(g paramg) {
/*  28 */     a(paramg, "or");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> b<T> a(Iterable<k<? super T>> paramIterable) {
/*  39 */     return new b<T>(paramIterable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> b<T> a(k<? super T>... paramVarArgs) {
/*  50 */     return a(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> b<T> a(k<T> paramk, k<? super T> paramk1) {
/*  61 */     ArrayList<k<T>> arrayList = new ArrayList();
/*  62 */     arrayList.add(paramk);
/*  63 */     arrayList.add(paramk1);
/*  64 */     return a(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> b<T> a(k<T> paramk, k<? super T> paramk1, k<? super T> paramk2) {
/*  75 */     ArrayList<k<T>> arrayList = new ArrayList();
/*  76 */     arrayList.add(paramk);
/*  77 */     arrayList.add(paramk1);
/*  78 */     arrayList.add(paramk2);
/*  79 */     return a(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> b<T> a(k<T> paramk, k<? super T> paramk1, k<? super T> paramk2, k<? super T> paramk3) {
/*  90 */     ArrayList<k<T>> arrayList = new ArrayList();
/*  91 */     arrayList.add(paramk);
/*  92 */     arrayList.add(paramk1);
/*  93 */     arrayList.add(paramk2);
/*  94 */     arrayList.add(paramk3);
/*  95 */     return a(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> b<T> a(k<T> paramk, k<? super T> paramk1, k<? super T> paramk2, k<? super T> paramk3, k<? super T> paramk4) {
/* 106 */     ArrayList<k<T>> arrayList = new ArrayList();
/* 107 */     arrayList.add(paramk);
/* 108 */     arrayList.add(paramk1);
/* 109 */     arrayList.add(paramk2);
/* 110 */     arrayList.add(paramk3);
/* 111 */     arrayList.add(paramk4);
/* 112 */     return a(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> b<T> a(k<T> paramk, k<? super T> paramk1, k<? super T> paramk2, k<? super T> paramk3, k<? super T> paramk4, k<? super T> paramk5) {
/* 123 */     ArrayList<k<T>> arrayList = new ArrayList();
/* 124 */     arrayList.add(paramk);
/* 125 */     arrayList.add(paramk1);
/* 126 */     arrayList.add(paramk2);
/* 127 */     arrayList.add(paramk3);
/* 128 */     arrayList.add(paramk4);
/* 129 */     arrayList.add(paramk5);
/* 130 */     return a(arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */