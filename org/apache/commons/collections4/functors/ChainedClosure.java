/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import org.apache.commons.collections4.Closure;
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
/*     */ public class ChainedClosure<E>
/*     */   implements Serializable, Closure<E>
/*     */ {
/*     */   private static final long serialVersionUID = -3520677225766901240L;
/*     */   private final Closure<? super E>[] iClosures;
/*     */   
/*     */   public static <E> Closure<E> chainedClosure(Closure<? super E>... paramVarArgs) {
/*  48 */     FunctorUtils.validate((Closure<?>[])paramVarArgs);
/*  49 */     if (paramVarArgs.length == 0) {
/*  50 */       return NOPClosure.nopClosure();
/*     */     }
/*  52 */     return new ChainedClosure<E>(paramVarArgs);
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
/*     */   public static <E> Closure<E> chainedClosure(Collection<? extends Closure<? super E>> paramCollection) {
/*  68 */     if (paramCollection == null) {
/*  69 */       throw new NullPointerException("Closure collection must not be null");
/*     */     }
/*  71 */     if (paramCollection.size() == 0) {
/*  72 */       return NOPClosure.nopClosure();
/*     */     }
/*     */     
/*  75 */     Closure[] arrayOfClosure = new Closure[paramCollection.size()];
/*  76 */     byte b = 0;
/*  77 */     for (Closure<? super E> closure : paramCollection) {
/*  78 */       arrayOfClosure[b++] = closure;
/*     */     }
/*  80 */     FunctorUtils.validate((Closure<?>[])arrayOfClosure);
/*  81 */     return new ChainedClosure<E>(false, (Closure<? super E>[])arrayOfClosure);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ChainedClosure(boolean paramBoolean, Closure<? super E>... paramVarArgs) {
/*  92 */     this.iClosures = paramBoolean ? (Closure<? super E>[])FunctorUtils.<E>copy(paramVarArgs) : paramVarArgs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChainedClosure(Closure<? super E>... paramVarArgs) {
/* 102 */     this(true, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute(E paramE) {
/* 111 */     for (Closure<? super E> closure : this.iClosures) {
/* 112 */       closure.execute(paramE);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Closure<? super E>[] getClosures() {
/* 123 */     return (Closure<? super E>[])FunctorUtils.copy(this.iClosures);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\ChainedClosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */