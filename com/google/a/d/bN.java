/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ final class bn<K, V>
/*     */   extends bd<V>
/*     */ {
/*     */   private final bj<K, V> j;
/*     */   
/*     */   bn(bj<K, V> parambj) {
/*  40 */     this.j = parambj;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  45 */     return this.j.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public dj<V> b() {
/*  50 */     return new dj<V>(this) {
/*  51 */         final dj<Map.Entry<K, V>> b = bn.a(this.a).h().b();
/*     */ 
/*     */         
/*     */         public boolean hasNext() {
/*  55 */           return this.b.hasNext();
/*     */         }
/*     */ 
/*     */         
/*     */         public V next() {
/*  60 */           return (V)((Map.Entry)this.b.next()).getValue();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public Spliterator<V> spliterator() {
/*  67 */     return D.a(this.j.h().spliterator(), Map.Entry::getValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/*  72 */     return (paramObject != null && bH.contains(b(), paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cO() {
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public bh<V> c() {
/*  82 */     bh bh = this.j.h().c();
/*  83 */     return new aZ<V>(this, bh)
/*     */       {
/*     */         public V get(int param1Int) {
/*  86 */           return (V)((Map.Entry)this.h.get(param1Int)).getValue();
/*     */         }
/*     */ 
/*     */         
/*     */         bd<V> a() {
/*  91 */           return this.a;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   public void forEach(Consumer<? super V> paramConsumer) {
/*  99 */     D.checkNotNull(paramConsumer);
/* 100 */     this.j.forEach((paramObject1, paramObject2) -> paramConsumer.accept(paramObject2));
/*     */   }
/*     */   
/*     */   @c
/*     */   private static class a<V>
/*     */     implements Serializable {
/*     */     final bj<?, V> j;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(bj<?, V> param1bj) {
/* 110 */       this.j = param1bj;
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 114 */       return this.j.c();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */