/*     */ package org.apache.commons.collections4.functors;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ForClosure<E>
/*     */   implements Closure<E>
/*     */ {
/*     */   private final int iCount;
/*     */   private final Closure<? super E> iClosure;
/*     */   
/*     */   public static <E> Closure<E> forClosure(int paramInt, Closure<? super E> paramClosure) {
/*  52 */     if (paramInt <= 0 || paramClosure == null) {
/*  53 */       return NOPClosure.nopClosure();
/*     */     }
/*  55 */     if (paramInt == 1) {
/*  56 */       return (Closure)paramClosure;
/*     */     }
/*  58 */     return new ForClosure<E>(paramInt, paramClosure);
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
/*     */   public ForClosure(int paramInt, Closure<? super E> paramClosure) {
/*  70 */     this.iCount = paramInt;
/*  71 */     this.iClosure = paramClosure;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute(E paramE) {
/*  81 */     for (byte b = 0; b < this.iCount; b++) {
/*  82 */       this.iClosure.execute(paramE);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Closure<? super E> getClosure() {
/*  93 */     return this.iClosure;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCount() {
/* 103 */     return this.iCount;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\ForClosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */