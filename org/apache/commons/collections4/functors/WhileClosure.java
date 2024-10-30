/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import org.apache.commons.collections4.Closure;
/*     */ import org.apache.commons.collections4.Predicate;
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
/*     */ public class WhileClosure<E>
/*     */   implements Closure<E>
/*     */ {
/*     */   private final Predicate<? super E> iPredicate;
/*     */   private final Closure<? super E> iClosure;
/*     */   private final boolean iDoLoop;
/*     */   
/*     */   public static <E> Closure<E> whileClosure(Predicate<? super E> paramPredicate, Closure<? super E> paramClosure, boolean paramBoolean) {
/*  55 */     if (paramPredicate == null) {
/*  56 */       throw new NullPointerException("Predicate must not be null");
/*     */     }
/*  58 */     if (paramClosure == null) {
/*  59 */       throw new NullPointerException("Closure must not be null");
/*     */     }
/*  61 */     return new WhileClosure<E>(paramPredicate, paramClosure, paramBoolean);
/*     */   }
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
/*     */   public WhileClosure(Predicate<? super E> paramPredicate, Closure<? super E> paramClosure, boolean paramBoolean) {
/*  74 */     this.iPredicate = paramPredicate;
/*  75 */     this.iClosure = paramClosure;
/*  76 */     this.iDoLoop = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute(E paramE) {
/*  86 */     if (this.iDoLoop) {
/*  87 */       this.iClosure.execute(paramE);
/*     */     }
/*  89 */     while (this.iPredicate.evaluate(paramE)) {
/*  90 */       this.iClosure.execute(paramE);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Predicate<? super E> getPredicate() {
/* 101 */     return this.iPredicate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Closure<? super E> getClosure() {
/* 111 */     return this.iClosure;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDoLoop() {
/* 121 */     return this.iDoLoop;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\WhileClosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */