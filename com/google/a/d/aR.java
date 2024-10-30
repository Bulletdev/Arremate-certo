/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.y;
/*     */ import com.google.b.a.a;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class ar<E>
/*     */   extends aI
/*     */   implements Collection<E>
/*     */ {
/*     */   public Iterator<E> iterator() {
/*  60 */     return a().iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  65 */     return a().size();
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/*  71 */     return a().removeAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  76 */     return a().isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/*  81 */     return a().contains(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean add(E paramE) {
/*  87 */     return a().add(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean remove(Object paramObject) {
/*  93 */     return a().remove(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/*  98 */     return a().containsAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 104 */     return a().addAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 110 */     return a().retainAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 115 */     a().clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 120 */     return a().toArray();
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/* 126 */     return a().toArray(paramArrayOfT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean g(Object paramObject) {
/* 137 */     return bH.contains(iterator(), paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean a(Collection<?> paramCollection) {
/* 148 */     return E.a(this, paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean b(Collection<? extends E> paramCollection) {
/* 158 */     return bH.addAll(this, paramCollection.iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean h(Object paramObject) {
/* 169 */     Iterator<E> iterator = iterator();
/* 170 */     while (iterator.hasNext()) {
/* 171 */       if (y.equal(iterator.next(), paramObject)) {
/* 172 */         iterator.remove();
/* 173 */         return true;
/*     */       } 
/*     */     } 
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean c(Collection<?> paramCollection) {
/* 187 */     return bH.a(iterator(), paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean d(Collection<?> paramCollection) {
/* 198 */     return bH.b(iterator(), paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fb() {
/* 209 */     bH.a(iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean cS() {
/* 220 */     return !iterator().hasNext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String dk() {
/* 231 */     return E.a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object[] c() {
/* 242 */     Object[] arrayOfObject = new Object[size()];
/* 243 */     return toArray(arrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected <T> T[] a(T[] paramArrayOfT) {
/* 254 */     return ci.a(this, paramArrayOfT);
/*     */   }
/*     */   
/*     */   protected abstract Collection<E> a();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */