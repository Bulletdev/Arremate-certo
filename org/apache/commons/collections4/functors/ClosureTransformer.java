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
/*    */ public class ClosureTransformer<T>
/*    */   implements Serializable, Transformer<T, T>
/*    */ {
/*    */   private static final long serialVersionUID = 478466901448617286L;
/*    */   private final Closure<? super T> iClosure;
/*    */   
/*    */   public static <T> Transformer<T, T> closureTransformer(Closure<? super T> paramClosure) {
/* 48 */     if (paramClosure == null) {
/* 49 */       throw new NullPointerException("Closure must not be null");
/*    */     }
/* 51 */     return new ClosureTransformer<T>(paramClosure);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ClosureTransformer(Closure<? super T> paramClosure) {
/* 62 */     this.iClosure = paramClosure;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T transform(T paramT) {
/* 72 */     this.iClosure.execute(paramT);
/* 73 */     return paramT;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Closure<? super T> getClosure() {
/* 83 */     return this.iClosure;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\ClosureTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */