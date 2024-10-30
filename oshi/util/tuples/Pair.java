/*    */ package oshi.util.tuples;
/*    */ 
/*    */ import oshi.annotation.concurrent.ThreadSafe;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public class Pair<A, B>
/*    */ {
/*    */   private final A a;
/*    */   private final B b;
/*    */   
/*    */   public Pair(A paramA, B paramB) {
/* 51 */     this.a = paramA;
/* 52 */     this.b = paramB;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final A getA() {
/* 61 */     return this.a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final B getB() {
/* 70 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\tuples\Pair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */