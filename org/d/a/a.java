/*     */ package org.d.a;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import org.d.g;
/*     */ import org.d.h;
/*     */ import org.d.i;
/*     */ import org.d.k;
/*     */ import org.d.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a<T>
/*     */   extends h<T>
/*     */ {
/*     */   private final Iterable<k<? super T>> h;
/*     */   
/*     */   public a(Iterable<k<? super T>> paramIterable) {
/*  21 */     this.h = paramIterable;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(Object paramObject, g paramg) {
/*  26 */     for (k<? super T> k : this.h) {
/*  27 */       if (!k.E(paramObject)) {
/*  28 */         paramg.a((m)k).a(" ");
/*  29 */         k.a(paramObject, paramg);
/*  30 */         return false;
/*     */       } 
/*     */     } 
/*  33 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(g paramg) {
/*  38 */     paramg.b("(", " and ", ")", this.h);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> k<T> a(Iterable<k<? super T>> paramIterable) {
/*  49 */     return (k<T>)new a<T>(paramIterable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> k<T> a(k<? super T>... paramVarArgs) {
/*  60 */     return a(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> k<T> a(k<? super T> paramk1, k<? super T> paramk2) {
/*  71 */     ArrayList<k<? super T>> arrayList = new ArrayList(2);
/*  72 */     arrayList.add(paramk1);
/*  73 */     arrayList.add(paramk2);
/*  74 */     return a(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> k<T> a(k<? super T> paramk1, k<? super T> paramk2, k<? super T> paramk3) {
/*  85 */     ArrayList<k<? super T>> arrayList = new ArrayList(3);
/*  86 */     arrayList.add(paramk1);
/*  87 */     arrayList.add(paramk2);
/*  88 */     arrayList.add(paramk3);
/*  89 */     return a(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> k<T> a(k<? super T> paramk1, k<? super T> paramk2, k<? super T> paramk3, k<? super T> paramk4) {
/* 100 */     ArrayList<k<? super T>> arrayList = new ArrayList(4);
/* 101 */     arrayList.add(paramk1);
/* 102 */     arrayList.add(paramk2);
/* 103 */     arrayList.add(paramk3);
/* 104 */     arrayList.add(paramk4);
/* 105 */     return a(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> k<T> a(k<? super T> paramk1, k<? super T> paramk2, k<? super T> paramk3, k<? super T> paramk4, k<? super T> paramk5) {
/* 116 */     ArrayList<k<? super T>> arrayList = new ArrayList(5);
/* 117 */     arrayList.add(paramk1);
/* 118 */     arrayList.add(paramk2);
/* 119 */     arrayList.add(paramk3);
/* 120 */     arrayList.add(paramk4);
/* 121 */     arrayList.add(paramk5);
/* 122 */     return a(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @i
/*     */   public static <T> k<T> a(k<? super T> paramk1, k<? super T> paramk2, k<? super T> paramk3, k<? super T> paramk4, k<? super T> paramk5, k<? super T> paramk6) {
/* 133 */     ArrayList<k<? super T>> arrayList = new ArrayList(6);
/* 134 */     arrayList.add(paramk1);
/* 135 */     arrayList.add(paramk2);
/* 136 */     arrayList.add(paramk3);
/* 137 */     arrayList.add(paramk4);
/* 138 */     arrayList.add(paramk5);
/* 139 */     arrayList.add(paramk6);
/* 140 */     return a(arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */