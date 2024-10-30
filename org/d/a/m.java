/*    */ package org.d.a;
/*    */ 
/*    */ import org.d.b;
/*    */ import org.d.g;
/*    */ import org.d.i;
/*    */ import org.d.k;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class m<T>
/*    */   extends b<T>
/*    */ {
/*    */   private final T object;
/*    */   
/*    */   public m(T paramT) {
/* 18 */     this.object = paramT;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean E(Object paramObject) {
/* 23 */     return (paramObject == this.object);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(g paramg) {
/* 28 */     paramg.a("sameInstance(").a(this.object).a(")");
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
/*    */   @i
/*    */   public static <T> k<T> e(T paramT) {
/* 42 */     return (k<T>)new m<T>(paramT);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @i
/*    */   public static <T> k<T> f(T paramT) {
/* 54 */     return (k<T>)new m<T>(paramT);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\m.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */