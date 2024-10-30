/*     */ package org.junit.f;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.List;
/*     */ import org.junit.e.f;
/*     */ import org.junit.e.l;
/*     */ import org.junit.f.a.d;
/*     */ import org.junit.f.a.l;
/*     */ import org.junit.runner.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class g
/*     */ {
/*  22 */   private final IdentityHashMap<Object, Integer> a = new IdentityHashMap<Object, Integer>();
/*  23 */   private final List<l> aS = new ArrayList<l>();
/*  24 */   private final List<f> aT = new ArrayList<f>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void d(Object paramObject, int paramInt) {
/*  30 */     this.a.put(paramObject, Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public void a(f paramf) {
/*  34 */     this.aT.add(paramf);
/*     */   }
/*     */   
/*     */   public void a(l paraml) {
/*  38 */     this.aS.add(paraml);
/*     */   }
/*     */   
/*  41 */   static final Comparator<a> l = new Comparator<a>() {
/*     */       public int a(g.a param1a1, g.a param1a2) {
/*  43 */         int i = compareInt(param1a1.order, param1a2.order);
/*  44 */         return (i != 0) ? i : (param1a1.type - param1a2.type);
/*     */       }
/*     */       
/*     */       private int compareInt(int param1Int1, int param1Int2) {
/*  48 */         return (param1Int1 < param1Int2) ? 1 : ((param1Int1 == param1Int2) ? 0 : -1);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<a> bv() {
/*  56 */     ArrayList<a> arrayList = new ArrayList(this.aT.size() + this.aS.size());
/*     */     
/*  58 */     for (f f : this.aT) {
/*  59 */       arrayList.add(new a(f, 0, this.a.get(f)));
/*     */     }
/*  61 */     for (l l : this.aS) {
/*  62 */       arrayList.add(new a(l, 1, this.a.get(l)));
/*     */     }
/*  64 */     Collections.sort(arrayList, l);
/*  65 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public l a(d paramd, c paramc, Object paramObject, l paraml) {
/*  73 */     if (this.aT.isEmpty() && this.aS.isEmpty()) {
/*  74 */       return paraml;
/*     */     }
/*  76 */     l l1 = paraml;
/*  77 */     for (a a : bv()) {
/*  78 */       if (a.type == 1) {
/*  79 */         l1 = ((l)a.aL).a(l1, paramc); continue;
/*     */       } 
/*  81 */       l1 = ((f)a.aL).a(l1, paramd, paramObject);
/*     */     } 
/*     */     
/*  84 */     return l1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List<Object> bw() {
/*  92 */     ArrayList<Object> arrayList = new ArrayList();
/*  93 */     for (a a : bv()) {
/*  94 */       arrayList.add(a.aL);
/*     */     }
/*  96 */     return arrayList;
/*     */   }
/*     */   
/*     */   static class a
/*     */   {
/*     */     static final int iR = 1;
/*     */     static final int iS = 0;
/*     */     final Object aL;
/*     */     final int type;
/*     */     final int order;
/*     */     
/*     */     a(Object param1Object, int param1Int, Integer param1Integer) {
/* 108 */       this.aL = param1Object;
/* 109 */       this.type = param1Int;
/* 110 */       this.order = (param1Integer != null) ? param1Integer.intValue() : -1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */