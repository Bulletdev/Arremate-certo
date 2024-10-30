/*     */ package org.apache.commons.collections4.multiset;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.MultiSet;
/*     */ import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
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
/*     */ public abstract class AbstractMultiSetDecorator<E>
/*     */   extends AbstractCollectionDecorator<E>
/*     */   implements MultiSet<E>
/*     */ {
/*     */   private static final long serialVersionUID = 20150610L;
/*     */   
/*     */   protected AbstractMultiSetDecorator() {}
/*     */   
/*     */   protected AbstractMultiSetDecorator(MultiSet<E> paramMultiSet) {
/*  52 */     super((Collection)paramMultiSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MultiSet<E> decorated() {
/*  62 */     return (MultiSet<E>)super.decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  67 */     return (paramObject == this || decorated().equals(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  72 */     return decorated().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCount(Object paramObject) {
/*  79 */     return decorated().getCount(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int setCount(E paramE, int paramInt) {
/*  84 */     return decorated().setCount(paramE, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int add(E paramE, int paramInt) {
/*  89 */     return decorated().add(paramE, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int remove(Object paramObject, int paramInt) {
/*  94 */     return decorated().remove(paramObject, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> uniqueSet() {
/*  99 */     return decorated().uniqueSet();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<MultiSet.Entry<E>> entrySet() {
/* 104 */     return decorated().entrySet();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multiset\AbstractMultiSetDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */