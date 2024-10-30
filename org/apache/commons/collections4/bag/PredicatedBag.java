/*     */ package org.apache.commons.collections4.bag;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.Bag;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ import org.apache.commons.collections4.collection.PredicatedCollection;
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
/*     */ public class PredicatedBag<E>
/*     */   extends PredicatedCollection<E>
/*     */   implements Bag<E>
/*     */ {
/*     */   private static final long serialVersionUID = -2575833140344736876L;
/*     */   
/*     */   public static <E> PredicatedBag<E> predicatedBag(Bag<E> paramBag, Predicate<? super E> paramPredicate) {
/*  63 */     return new PredicatedBag<E>(paramBag, paramPredicate);
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
/*     */   protected PredicatedBag(Bag<E> paramBag, Predicate<? super E> paramPredicate) {
/*  79 */     super((Collection)paramBag, paramPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Bag<E> decorated() {
/*  89 */     return (Bag<E>)super.decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  94 */     return (paramObject == this || decorated().equals(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  99 */     return decorated().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE, int paramInt) {
/* 106 */     validate(paramE);
/* 107 */     return decorated().add(paramE, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject, int paramInt) {
/* 112 */     return decorated().remove(paramObject, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> uniqueSet() {
/* 117 */     return decorated().uniqueSet();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCount(Object paramObject) {
/* 122 */     return decorated().getCount(paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\PredicatedBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */