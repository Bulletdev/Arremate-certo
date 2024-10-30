/*     */ package org.apache.commons.collections4.set;
/*     */ 
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ import org.apache.commons.collections4.collection.TransformedCollection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransformedSet<E>
/*     */   extends TransformedCollection<E>
/*     */   implements Set<E>
/*     */ {
/*     */   private static final long serialVersionUID = 306127383500410386L;
/*     */   
/*     */   public static <E> TransformedSet<E> transformingSet(Set<E> paramSet, Transformer<? super E, ? extends E> paramTransformer) {
/*  58 */     return new TransformedSet<E>(paramSet, paramTransformer);
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
/*     */   public static <E> Set<E> transformedSet(Set<E> paramSet, Transformer<? super E, ? extends E> paramTransformer) {
/*  77 */     TransformedSet<E> transformedSet = new TransformedSet<E>(paramSet, paramTransformer);
/*  78 */     if (paramSet.size() > 0) {
/*     */       
/*  80 */       Object[] arrayOfObject = paramSet.toArray();
/*  81 */       paramSet.clear();
/*  82 */       for (Object object : arrayOfObject) {
/*  83 */         transformedSet.decorated().add(paramTransformer.transform(object));
/*     */       }
/*     */     } 
/*  86 */     return transformedSet;
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
/*     */   protected TransformedSet(Set<E> paramSet, Transformer<? super E, ? extends E> paramTransformer) {
/* 101 */     super(paramSet, paramTransformer);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 106 */     return (paramObject == this || decorated().equals(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 111 */     return decorated().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\TransformedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */