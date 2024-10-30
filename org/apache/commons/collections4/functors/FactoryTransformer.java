/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.apache.commons.collections4.Factory;
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
/*    */ public class FactoryTransformer<I, O>
/*    */   implements Serializable, Transformer<I, O>
/*    */ {
/*    */   private static final long serialVersionUID = -6817674502475353160L;
/*    */   private final Factory<? extends O> iFactory;
/*    */   
/*    */   public static <I, O> Transformer<I, O> factoryTransformer(Factory<? extends O> paramFactory) {
/* 48 */     if (paramFactory == null) {
/* 49 */       throw new NullPointerException("Factory must not be null");
/*    */     }
/* 51 */     return new FactoryTransformer<I, O>(paramFactory);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FactoryTransformer(Factory<? extends O> paramFactory) {
/* 62 */     this.iFactory = paramFactory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public O transform(I paramI) {
/* 73 */     return (O)this.iFactory.create();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Factory<? extends O> getFactory() {
/* 83 */     return this.iFactory;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\FactoryTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */