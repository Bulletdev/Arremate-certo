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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class IdentityPredicate<T>
/*    */   implements Serializable, Predicate<T>
/*    */ {
/*    */   private static final long serialVersionUID = -89901658494523293L;
/*    */   private final T iValue;
/*    */   
/*    */   public static <T> Predicate<T> identityPredicate(T paramT) {
/* 46 */     if (paramT == null) {
/* 47 */       return NullPredicate.nullPredicate();
/*    */     }
/* 49 */     return new IdentityPredicate<T>(paramT);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IdentityPredicate(T paramT) {
/* 60 */     this.iValue = paramT;
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
/* 71 */     return (this.iValue == paramT);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T getValue() {
/* 81 */     return this.iValue;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\IdentityPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */