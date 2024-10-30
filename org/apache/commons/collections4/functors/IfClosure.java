/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class IfClosure<E>
/*     */   implements Serializable, Closure<E>
/*     */ {
/*     */   private static final long serialVersionUID = 3518477308466486130L;
/*     */   private final Predicate<? super E> iPredicate;
/*     */   private final Closure<? super E> iTrueClosure;
/*     */   private final Closure<? super E> iFalseClosure;
/*     */   
/*     */   public static <E> Closure<E> ifClosure(Predicate<? super E> paramPredicate, Closure<? super E> paramClosure) {
/*  57 */     return ifClosure(paramPredicate, paramClosure, NOPClosure.nopClosure());
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Closure<E> ifClosure(Predicate<? super E> paramPredicate, Closure<? super E> paramClosure1, Closure<? super E> paramClosure2) {
/*  73 */     if (paramPredicate == null) {
/*  74 */       throw new NullPointerException("Predicate must not be null");
/*     */     }
/*  76 */     if (paramClosure1 == null || paramClosure2 == null) {
/*  77 */       throw new NullPointerException("Closures must not be null");
/*     */     }
/*  79 */     return new IfClosure<E>(paramPredicate, paramClosure1, paramClosure2);
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
/*     */ 
/*     */   
/*     */   public IfClosure(Predicate<? super E> paramPredicate, Closure<? super E> paramClosure) {
/*  94 */     this(paramPredicate, paramClosure, NOPClosure.nopClosure());
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
/*     */   
/*     */   public IfClosure(Predicate<? super E> paramPredicate, Closure<? super E> paramClosure1, Closure<? super E> paramClosure2) {
/* 108 */     this.iPredicate = paramPredicate;
/* 109 */     this.iTrueClosure = paramClosure1;
/* 110 */     this.iFalseClosure = paramClosure2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute(E paramE) {
/* 119 */     if (this.iPredicate.evaluate(paramE)) {
/* 120 */       this.iTrueClosure.execute(paramE);
/*     */     } else {
/* 122 */       this.iFalseClosure.execute(paramE);
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
/* 133 */     return this.iPredicate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Closure<? super E> getTrueClosure() {
/* 143 */     return this.iTrueClosure;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Closure<? super E> getFalseClosure() {
/* 153 */     return this.iFalseClosure;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\IfClosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */