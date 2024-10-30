/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.commons.collections4.Predicate;
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
/*     */ public final class TransformedPredicate<T>
/*     */   implements Serializable, PredicateDecorator<T>
/*     */ {
/*     */   private static final long serialVersionUID = -5596090919668315834L;
/*     */   private final Transformer<? super T, ? extends T> iTransformer;
/*     */   private final Predicate<? super T> iPredicate;
/*     */   
/*     */   public static <T> Predicate<T> transformedPredicate(Transformer<? super T, ? extends T> paramTransformer, Predicate<? super T> paramPredicate) {
/*  53 */     if (paramTransformer == null) {
/*  54 */       throw new NullPointerException("The transformer to call must not be null");
/*     */     }
/*  56 */     if (paramPredicate == null) {
/*  57 */       throw new NullPointerException("The predicate to call must not be null");
/*     */     }
/*  59 */     return new TransformedPredicate<T>(paramTransformer, paramPredicate);
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
/*     */   public TransformedPredicate(Transformer<? super T, ? extends T> paramTransformer, Predicate<? super T> paramPredicate) {
/*  71 */     this.iTransformer = paramTransformer;
/*  72 */     this.iPredicate = paramPredicate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean evaluate(T paramT) {
/*  83 */     Object object = this.iTransformer.transform(paramT);
/*  84 */     return this.iPredicate.evaluate(object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Predicate<? super T>[] getPredicates() {
/*  95 */     return (Predicate<? super T>[])new Predicate[] { this.iPredicate };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transformer<? super T, ? extends T> getTransformer() {
/* 104 */     return this.iTransformer;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\TransformedPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */