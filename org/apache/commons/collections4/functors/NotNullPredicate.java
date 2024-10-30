/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.apache.commons.collections4.Predicate;
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
/*    */ public final class NotNullPredicate<T>
/*    */   implements Serializable, Predicate<T>
/*    */ {
/*    */   private static final long serialVersionUID = 7533784454832764388L;
/* 36 */   public static final Predicate INSTANCE = new NotNullPredicate();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> Predicate<T> notNullPredicate() {
/* 47 */     return INSTANCE;
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
/*    */   public boolean evaluate(T paramT) {
/* 64 */     return (paramT != null);
/*    */   }
/*    */   
/*    */   private Object readResolve() {
/* 68 */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\NotNullPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */