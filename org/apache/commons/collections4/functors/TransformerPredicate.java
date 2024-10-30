/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.apache.commons.collections4.FunctorException;
/*    */ import org.apache.commons.collections4.Predicate;
/*    */ import org.apache.commons.collections4.Transformer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class TransformerPredicate<T>
/*    */   implements Serializable, Predicate<T>
/*    */ {
/*    */   private static final long serialVersionUID = -2407966402920578741L;
/*    */   private final Transformer<? super T, Boolean> iTransformer;
/*    */   
/*    */   public static <T> Predicate<T> transformerPredicate(Transformer<? super T, Boolean> paramTransformer) {
/* 48 */     if (paramTransformer == null) {
/* 49 */       throw new NullPointerException("The transformer to call must not be null");
/*    */     }
/* 51 */     return new TransformerPredicate<T>(paramTransformer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TransformerPredicate(Transformer<? super T, Boolean> paramTransformer) {
/* 62 */     this.iTransformer = paramTransformer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean evaluate(T paramT) {
/* 73 */     Boolean bool = (Boolean)this.iTransformer.transform(paramT);
/* 74 */     if (bool == null) {
/* 75 */       throw new FunctorException("Transformer must return an instanceof Boolean, it was a null object");
/*    */     }
/*    */     
/* 78 */     return bool.booleanValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Transformer<? super T, Boolean> getTransformer() {
/* 88 */     return this.iTransformer;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\TransformerPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */