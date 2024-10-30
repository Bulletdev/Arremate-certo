/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.apache.commons.collections4.Closure;
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
/*    */ 
/*    */ 
/*    */ public class TransformerClosure<E>
/*    */   implements Serializable, Closure<E>
/*    */ {
/*    */   private static final long serialVersionUID = -5194992589193388969L;
/*    */   private final Transformer<? super E, ?> iTransformer;
/*    */   
/*    */   public static <E> Closure<E> transformerClosure(Transformer<? super E, ?> paramTransformer) {
/* 49 */     if (paramTransformer == null) {
/* 50 */       return NOPClosure.nopClosure();
/*    */     }
/* 52 */     return new TransformerClosure<E>(paramTransformer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TransformerClosure(Transformer<? super E, ?> paramTransformer) {
/* 63 */     this.iTransformer = paramTransformer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void execute(E paramE) {
/* 72 */     this.iTransformer.transform(paramE);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Transformer<? super E, ?> getTransformer() {
/* 82 */     return this.iTransformer;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\TransformerClosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */