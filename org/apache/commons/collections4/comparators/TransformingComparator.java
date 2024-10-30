/*     */ package org.apache.commons.collections4.comparators;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ import org.apache.commons.collections4.ComparatorUtils;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransformingComparator<I, O>
/*     */   implements Serializable, Comparator<I>
/*     */ {
/*     */   private static final long serialVersionUID = 3456940356043606220L;
/*     */   private final Comparator<O> decorated;
/*     */   private final Transformer<? super I, ? extends O> transformer;
/*     */   
/*     */   public TransformingComparator(Transformer<? super I, ? extends O> paramTransformer) {
/*  57 */     this(paramTransformer, ComparatorUtils.NATURAL_COMPARATOR);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TransformingComparator(Transformer<? super I, ? extends O> paramTransformer, Comparator<O> paramComparator) {
/*  68 */     this.decorated = paramComparator;
/*  69 */     this.transformer = paramTransformer;
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
/*     */   public int compare(I paramI1, I paramI2) {
/*  82 */     Object object1 = this.transformer.transform(paramI1);
/*  83 */     Object object2 = this.transformer.transform(paramI2);
/*  84 */     return this.decorated.compare((O)object1, (O)object2);
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
/*     */   public int hashCode() {
/*  96 */     int i = 17;
/*  97 */     i = i * 37 + ((this.decorated == null) ? 0 : this.decorated.hashCode());
/*  98 */     i = i * 37 + ((this.transformer == null) ? 0 : this.transformer.hashCode());
/*  99 */     return i;
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
/*     */   public boolean equals(Object paramObject) {
/* 116 */     if (this == paramObject) {
/* 117 */       return true;
/*     */     }
/* 119 */     if (null == paramObject) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (paramObject.getClass().equals(getClass())) {
/* 123 */       TransformingComparator transformingComparator = (TransformingComparator)paramObject;
/* 124 */       return (((null == this.decorated) ? (null == transformingComparator.decorated) : this.decorated.equals(transformingComparator.decorated)) && ((null == this.transformer) ? (null == transformingComparator.transformer) : this.transformer.equals(transformingComparator.transformer)));
/*     */     } 
/*     */     
/* 127 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\comparators\TransformingComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */