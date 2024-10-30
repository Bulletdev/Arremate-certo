/*    */ package org.apache.commons.collections4.functors;
/*    */ 
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
/*    */ public class CloneTransformer<T>
/*    */   implements Transformer<T, T>
/*    */ {
/* 38 */   public static final Transformer INSTANCE = new CloneTransformer();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> Transformer<T, T> cloneTransformer() {
/* 49 */     return INSTANCE;
/*    */   }
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
/*    */   public T transform(T paramT) {
/* 67 */     if (paramT == null) {
/* 68 */       return null;
/*    */     }
/* 70 */     return (T)PrototypeFactory.<T>prototypeFactory(paramT).create();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\CloneTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */