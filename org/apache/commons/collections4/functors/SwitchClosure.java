/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ public class SwitchClosure<E>
/*     */   implements Serializable, Closure<E>
/*     */ {
/*     */   private static final long serialVersionUID = 3518477308466486130L;
/*     */   private final Predicate<? super E>[] iPredicates;
/*     */   private final Closure<? super E>[] iClosures;
/*     */   private final Closure<? super E> iDefault;
/*     */   
/*     */   public static <E> Closure<E> switchClosure(Predicate<? super E>[] paramArrayOfPredicate, Closure<? super E>[] paramArrayOfClosure, Closure<? super E> paramClosure) {
/*  60 */     FunctorUtils.validate((Predicate<?>[])paramArrayOfPredicate);
/*  61 */     FunctorUtils.validate((Closure<?>[])paramArrayOfClosure);
/*  62 */     if (paramArrayOfPredicate.length != paramArrayOfClosure.length) {
/*  63 */       throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
/*     */     }
/*  65 */     if (paramArrayOfPredicate.length == 0) {
/*  66 */       return (paramClosure == null) ? NOPClosure.<E>nopClosure() : (Closure)paramClosure;
/*     */     }
/*  68 */     return new SwitchClosure<E>(paramArrayOfPredicate, paramArrayOfClosure, paramClosure);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Closure<E> switchClosure(Map<Predicate<E>, Closure<E>> paramMap) {
/*  91 */     if (paramMap == null) {
/*  92 */       throw new NullPointerException("The predicate and closure map must not be null");
/*     */     }
/*     */     
/*  95 */     Closure<E> closure = paramMap.remove(null);
/*  96 */     int i = paramMap.size();
/*  97 */     if (i == 0) {
/*  98 */       return (closure == null) ? NOPClosure.<E>nopClosure() : closure;
/*     */     }
/* 100 */     Closure[] arrayOfClosure = new Closure[i];
/* 101 */     Predicate[] arrayOfPredicate = new Predicate[i];
/* 102 */     byte b = 0;
/* 103 */     for (Map.Entry<Predicate<E>, Closure<E>> entry : paramMap.entrySet()) {
/* 104 */       arrayOfPredicate[b] = (Predicate)entry.getKey();
/* 105 */       arrayOfClosure[b] = (Closure)entry.getValue();
/* 106 */       b++;
/*     */     } 
/* 108 */     return new SwitchClosure<E>(false, (Predicate<? super E>[])arrayOfPredicate, (Closure<? super E>[])arrayOfClosure, closure);
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
/*     */   private SwitchClosure(boolean paramBoolean, Predicate<? super E>[] paramArrayOfPredicate, Closure<? super E>[] paramArrayOfClosure, Closure<? super E> paramClosure) {
/* 123 */     this.iPredicates = paramBoolean ? (Predicate<? super E>[])FunctorUtils.<E>copy(paramArrayOfPredicate) : paramArrayOfPredicate;
/* 124 */     this.iClosures = paramBoolean ? (Closure<? super E>[])FunctorUtils.<E>copy(paramArrayOfClosure) : paramArrayOfClosure;
/* 125 */     this.iDefault = (paramClosure == null) ? NOPClosure.<E>nopClosure() : paramClosure;
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
/*     */   public SwitchClosure(Predicate<? super E>[] paramArrayOfPredicate, Closure<? super E>[] paramArrayOfClosure, Closure<? super E> paramClosure) {
/* 138 */     this(true, paramArrayOfPredicate, paramArrayOfClosure, paramClosure);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute(E paramE) {
/* 147 */     for (byte b = 0; b < this.iPredicates.length; b++) {
/* 148 */       if (this.iPredicates[b].evaluate(paramE) == true) {
/* 149 */         this.iClosures[b].execute(paramE);
/*     */         return;
/*     */       } 
/*     */     } 
/* 153 */     this.iDefault.execute(paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Predicate<? super E>[] getPredicates() {
/* 163 */     return (Predicate<? super E>[])FunctorUtils.copy(this.iPredicates);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Closure<? super E>[] getClosures() {
/* 173 */     return (Closure<? super E>[])FunctorUtils.copy(this.iClosures);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Closure<? super E> getDefaultClosure() {
/* 183 */     return this.iDefault;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\SwitchClosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */