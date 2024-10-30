/*     */ package org.apache.commons.collections4.multiset;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.MultiSet;
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
/*     */ 
/*     */ public class PredicatedMultiSet<E>
/*     */   extends PredicatedCollection<E>
/*     */   implements MultiSet<E>
/*     */ {
/*     */   private static final long serialVersionUID = 20150629L;
/*     */   
/*     */   public static <E> PredicatedMultiSet<E> predicatedMultiSet(MultiSet<E> paramMultiSet, Predicate<? super E> paramPredicate) {
/*  64 */     return new PredicatedMultiSet<E>(paramMultiSet, paramPredicate);
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
/*     */   protected PredicatedMultiSet(MultiSet<E> paramMultiSet, Predicate<? super E> paramPredicate) {
/*  80 */     super((Collection)paramMultiSet, paramPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MultiSet<E> decorated() {
/*  90 */     return (MultiSet<E>)super.decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  95 */     return (paramObject == this || decorated().equals(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 100 */     return decorated().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int add(E paramE, int paramInt) {
/* 107 */     validate(paramE);
/* 108 */     return decorated().add(paramE, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int remove(Object paramObject, int paramInt) {
/* 113 */     return decorated().remove(paramObject, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCount(Object paramObject) {
/* 118 */     return decorated().getCount(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int setCount(E paramE, int paramInt) {
/* 123 */     validate(paramE);
/* 124 */     return decorated().setCount(paramE, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> uniqueSet() {
/* 129 */     return decorated().uniqueSet();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<MultiSet.Entry<E>> entrySet() {
/* 134 */     return decorated().entrySet();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multiset\PredicatedMultiSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */