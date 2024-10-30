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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public class Triplet<A, B, C>
/*    */ {
/*    */   private final A a;
/*    */   private final B b;
/*    */   private final C c;
/*    */   
/*    */   public Triplet(A paramA, B paramB, C paramC) {
/* 56 */     this.a = paramA;
/* 57 */     this.b = paramB;
/* 58 */     this.c = paramC;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final A getA() {
/* 67 */     return this.a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final B getB() {
/* 76 */     return this.b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final C getC() {
/* 85 */     return this.c;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\tuples\Triplet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */