/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public final class StringValueTransformer<T>
/*    */   implements Serializable, Transformer<T, String>
/*    */ {
/*    */   private static final long serialVersionUID = 7511110693171758606L;
/* 36 */   private static final Transformer<Object, String> INSTANCE = new StringValueTransformer();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> Transformer<T, String> stringValueTransformer() {
/* 47 */     return (Transformer)INSTANCE;
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
/*    */   public String transform(T paramT) {
/* 64 */     return String.valueOf(paramT);
/*    */   }
/*    */   
/*    */   private Object readResolve() {
/* 68 */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\StringValueTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */