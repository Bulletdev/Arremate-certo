/*     */ package org.junit.e;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.junit.f.a.l;
/*     */ import org.junit.runner.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class g
/*     */   implements l
/*     */ {
/*  59 */   private static final g a = new g(Collections.emptyList());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<l> aK;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static g a() {
/*  71 */     return a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static g a(l paraml) {
/*  82 */     return a().b(paraml);
/*     */   }
/*     */   
/*     */   private g(List<l> paramList) {
/*  86 */     this.aK = paramList;
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
/*     */   public g b(l paraml) {
/*  98 */     if (paraml == null) {
/*  99 */       throw new NullPointerException("The enclosed rule must not be null");
/*     */     }
/* 101 */     ArrayList<l> arrayList = new ArrayList();
/* 102 */     arrayList.add(paraml);
/* 103 */     arrayList.addAll(this.aK);
/* 104 */     return new g(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public l a(l paraml, c paramc) {
/* 111 */     return new h(paraml, this.aK, paramc);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */