/*     */ package org.apache.commons.collections4.bag;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.Bag;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ import org.apache.commons.collections4.collection.TransformedCollection;
/*     */ import org.apache.commons.collections4.set.TransformedSet;
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
/*     */ public class TransformedBag<E>
/*     */   extends TransformedCollection<E>
/*     */   implements Bag<E>
/*     */ {
/*     */   private static final long serialVersionUID = 5421170911299074185L;
/*     */   
/*     */   public static <E> Bag<E> transformingBag(Bag<E> paramBag, Transformer<? super E, ? extends E> paramTransformer) {
/*  58 */     return new TransformedBag<E>(paramBag, paramTransformer);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Bag<E> transformedBag(Bag<E> paramBag, Transformer<? super E, ? extends E> paramTransformer) {
/*  77 */     TransformedBag<E> transformedBag = new TransformedBag<E>(paramBag, paramTransformer);
/*  78 */     if (paramBag.size() > 0) {
/*     */       
/*  80 */       Object[] arrayOfObject = paramBag.toArray();
/*  81 */       paramBag.clear();
/*  82 */       for (Object object : arrayOfObject) {
/*  83 */         transformedBag.decorated().add(paramTransformer.transform(object));
/*     */       }
/*     */     } 
/*  86 */     return transformedBag;
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
/*     */   protected TransformedBag(Bag<E> paramBag, Transformer<? super E, ? extends E> paramTransformer) {
/* 101 */     super((Collection)paramBag, paramTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Bag<E> getBag() {
/* 110 */     return (Bag<E>)decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 115 */     return (paramObject == this || decorated().equals(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 120 */     return decorated().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCount(Object paramObject) {
/* 127 */     return getBag().getCount(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject, int paramInt) {
/* 132 */     return getBag().remove(paramObject, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE, int paramInt) {
/* 139 */     return getBag().add(transform(paramE), paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> uniqueSet() {
/* 144 */     Set set = getBag().uniqueSet();
/* 145 */     return (Set<E>)TransformedSet.transformingSet(set, this.transformer);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\TransformedBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */