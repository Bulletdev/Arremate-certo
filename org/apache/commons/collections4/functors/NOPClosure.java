/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.apache.commons.collections4.Closure;
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
/*    */ public final class NOPClosure<E>
/*    */   implements Serializable, Closure<E>
/*    */ {
/*    */   private static final long serialVersionUID = 3518477308466486130L;
/* 36 */   public static final Closure INSTANCE = new NOPClosure();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <E> Closure<E> nopClosure() {
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
/*    */   public void execute(E paramE) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Object readResolve() {
/* 67 */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\NOPClosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */