/*     */ package oshi.util.tuples;
/*     */ 
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public class Quintet<A, B, C, D, E>
/*     */ {
/*     */   private final A a;
/*     */   private final B b;
/*     */   private final C c;
/*     */   private final D d;
/*     */   private final E e;
/*     */   
/*     */   public Quintet(A paramA, B paramB, C paramC, D paramD, E paramE) {
/*  66 */     this.a = paramA;
/*  67 */     this.b = paramB;
/*  68 */     this.c = paramC;
/*  69 */     this.d = paramD;
/*  70 */     this.e = paramE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final A getA() {
/*  79 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final B getB() {
/*  88 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final C getC() {
/*  97 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final D getD() {
/* 106 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final E getE() {
/* 115 */     return this.e;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\tuples\Quintet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */