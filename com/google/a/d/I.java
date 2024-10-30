/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
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
/*     */ @b
/*     */ abstract class i<E>
/*     */   extends AbstractCollection<E>
/*     */   implements cc<E>
/*     */ {
/*     */   @com.google.b.a.a.b
/*     */   private transient Set<E> i;
/*     */   @com.google.b.a.a.b
/*     */   private transient Set<cc.a<E>> entrySet;
/*     */   
/*     */   public boolean isEmpty() {
/*  50 */     return entrySet().isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/*  55 */     return (b(paramObject) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final boolean add(E paramE) {
/*  62 */     add(paramE, 1);
/*  63 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public int add(E paramE, int paramInt) {
/*  69 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final boolean remove(Object paramObject) {
/*  75 */     return (remove(paramObject, 1) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public int remove(Object paramObject, int paramInt) {
/*  81 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public int setCount(E paramE, int paramInt) {
/*  87 */     return cd.a(this, paramE, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public boolean a(E paramE, int paramInt1, int paramInt2) {
/*  93 */     return cd.a(this, paramE, paramInt1, paramInt2);
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
/*     */   @com.google.b.a.a
/*     */   public final boolean addAll(Collection<? extends E> paramCollection) {
/* 107 */     return cd.a(this, paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final boolean removeAll(Collection<?> paramCollection) {
/* 113 */     return cd.b(this, paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final boolean retainAll(Collection<?> paramCollection) {
/* 119 */     return cd.c(this, paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void clear();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<E> d() {
/* 131 */     Set<E> set = this.i;
/* 132 */     if (set == null) {
/* 133 */       this.i = set = e();
/*     */     }
/* 135 */     return set;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Set<E> e() {
/* 143 */     return new a(this);
/*     */   }
/*     */   
/*     */   abstract Iterator<E> e();
/*     */   
/*     */   class a extends cd.c<E> {
/*     */     cc<E> c() {
/* 150 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<E> iterator() {
/* 155 */       return this.a.e();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     a(i this$0) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<cc.a<E>> entrySet() {
/* 165 */     Set<cc.a<E>> set = this.entrySet;
/* 166 */     if (set == null) {
/* 167 */       this.entrySet = set = createEntrySet();
/*     */     }
/* 169 */     return set;
/*     */   }
/*     */   
/*     */   class b extends cd.d<E> {
/*     */     b(i this$0) {}
/*     */     
/*     */     cc<E> c() {
/* 176 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<cc.a<E>> iterator() {
/* 181 */       return this.a.c();
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 186 */       return this.a.ah();
/*     */     }
/*     */   }
/*     */   
/*     */   Set<cc.a<E>> createEntrySet() {
/* 191 */     return new b(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract Iterator<cc.a<E>> c();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract int ah();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 208 */     return cd.a(this, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 218 */     return entrySet().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 229 */     return entrySet().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */