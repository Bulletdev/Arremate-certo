/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ import org.apache.commons.collections4.Transformer;
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
/*     */ public class IfTransformer<I, O>
/*     */   implements Serializable, Transformer<I, O>
/*     */ {
/*     */   private static final long serialVersionUID = 8069309411242014252L;
/*     */   private final Predicate<? super I> iPredicate;
/*     */   private final Transformer<? super I, ? extends O> iTrueTransformer;
/*     */   private final Transformer<? super I, ? extends O> iFalseTransformer;
/*     */   
/*     */   public static <I, O> Transformer<I, O> ifTransformer(Predicate<? super I> paramPredicate, Transformer<? super I, ? extends O> paramTransformer1, Transformer<? super I, ? extends O> paramTransformer2) {
/*  60 */     if (paramPredicate == null) {
/*  61 */       throw new NullPointerException("Predicate must not be null");
/*     */     }
/*  63 */     if (paramTransformer1 == null || paramTransformer2 == null) {
/*  64 */       throw new NullPointerException("Transformers must not be null");
/*     */     }
/*     */     
/*  67 */     return new IfTransformer<I, O>(paramPredicate, paramTransformer1, paramTransformer2);
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
/*     */   public static <T> Transformer<T, T> ifTransformer(Predicate<? super T> paramPredicate, Transformer<? super T, ? extends T> paramTransformer) {
/*  86 */     if (paramPredicate == null) {
/*  87 */       throw new NullPointerException("Predicate must not be null");
/*     */     }
/*  89 */     if (paramTransformer == null) {
/*  90 */       throw new NullPointerException("Transformer must not be null");
/*     */     }
/*     */     
/*  93 */     return new IfTransformer<T, T>(paramPredicate, paramTransformer, (Transformer)NOPTransformer.nopTransformer());
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
/*     */   public IfTransformer(Predicate<? super I> paramPredicate, Transformer<? super I, ? extends O> paramTransformer1, Transformer<? super I, ? extends O> paramTransformer2) {
/* 109 */     this.iPredicate = paramPredicate;
/* 110 */     this.iTrueTransformer = paramTransformer1;
/* 111 */     this.iFalseTransformer = paramTransformer2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public O transform(I paramI) {
/* 121 */     if (this.iPredicate.evaluate(paramI)) {
/* 122 */       return (O)this.iTrueTransformer.transform(paramI);
/*     */     }
/* 124 */     return (O)this.iFalseTransformer.transform(paramI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Predicate<? super I> getPredicate() {
/* 134 */     return this.iPredicate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transformer<? super I, ? extends O> getTrueTransformer() {
/* 143 */     return this.iTrueTransformer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transformer<? super I, ? extends O> getFalseTransformer() {
/* 152 */     return this.iFalseTransformer;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\IfTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */