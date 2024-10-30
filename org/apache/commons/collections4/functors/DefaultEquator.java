/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.apache.commons.collections4.Equator;
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
/*    */ public class DefaultEquator<T>
/*    */   implements Serializable, Equator<T>
/*    */ {
/*    */   private static final long serialVersionUID = 825802648423525485L;
/* 37 */   public static final DefaultEquator INSTANCE = new DefaultEquator();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final int HASHCODE_NULL = -1;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> DefaultEquator<T> defaultEquator() {
/* 52 */     return INSTANCE;
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
/*    */   public boolean equate(T paramT1, T paramT2) {
/* 66 */     return (paramT1 == paramT2 || (paramT1 != null && paramT1.equals(paramT2)));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hash(T paramT) {
/* 76 */     return (paramT == null) ? -1 : paramT.hashCode();
/*    */   }
/*    */   
/*    */   private Object readResolve() {
/* 80 */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\DefaultEquator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */