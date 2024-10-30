/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.d.bS;
/*     */ import com.google.a.d.bd;
/*     */ import com.google.a.d.bh;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true)
/*     */ abstract class s<V, C>
/*     */   extends i<V, C>
/*     */ {
/*     */   private List<b<V>> values;
/*     */   
/*     */   s(bd<? extends U<? extends V>> parambd, boolean paramBoolean) {
/*  42 */     super(parambd, paramBoolean, true);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  47 */     List<b<V>> list = (List<b<V>>)(parambd.isEmpty() ? bh.e() : bS.a(parambd.size()));
/*     */ 
/*     */     
/*  50 */     for (byte b = 0; b < parambd.size(); b++) {
/*  51 */       list.add(null);
/*     */     }
/*     */     
/*  54 */     this.values = list;
/*     */   }
/*     */ 
/*     */   
/*     */   final void c(int paramInt, V paramV) {
/*  59 */     List<b<V>> list = this.values;
/*  60 */     if (list != null) {
/*  61 */       list.set(paramInt, new b<>(paramV));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   final void fQ() {
/*  67 */     List<b<V>> list = this.values;
/*  68 */     if (list != null) {
/*  69 */       c(b(list));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void a(i.a parama) {
/*  75 */     super.a(parama);
/*  76 */     this.values = null;
/*     */   }
/*     */ 
/*     */   
/*     */   abstract C b(List<b<V>> paramList);
/*     */   
/*     */   static final class a<V>
/*     */     extends s<V, List<V>>
/*     */   {
/*     */     a(bd<? extends U<? extends V>> param1bd, boolean param1Boolean) {
/*  86 */       super(param1bd, param1Boolean);
/*  87 */       init();
/*     */     }
/*     */ 
/*     */     
/*     */     public List<V> h(List<s.b<V>> param1List) {
/*  92 */       ArrayList<V> arrayList = bS.a(param1List.size());
/*  93 */       for (s.b<V> b : param1List) {
/*  94 */         arrayList.add((b != null) ? b.value : null);
/*     */       }
/*  96 */       return Collections.unmodifiableList(arrayList);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class b<V>
/*     */   {
/*     */     V value;
/*     */     
/*     */     b(V param1V) {
/* 105 */       this.value = param1V;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */