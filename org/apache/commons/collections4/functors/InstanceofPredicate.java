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
/*    */ public final class InstanceofPredicate
/*    */   implements Serializable, Predicate<Object>
/*    */ {
/*    */   private static final long serialVersionUID = -6682656911025165584L;
/*    */   private final Class<?> iType;
/*    */   
/*    */   public static Predicate<Object> instanceOfPredicate(Class<?> paramClass) {
/* 46 */     if (paramClass == null) {
/* 47 */       throw new NullPointerException("The type to check instanceof must not be null");
/*    */     }
/* 49 */     return new InstanceofPredicate(paramClass);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InstanceofPredicate(Class<?> paramClass) {
/* 60 */     this.iType = paramClass;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean evaluate(Object paramObject) {
/* 70 */     return this.iType.isInstance(paramObject);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?> getType() {
/* 80 */     return this.iType;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\InstanceofPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */