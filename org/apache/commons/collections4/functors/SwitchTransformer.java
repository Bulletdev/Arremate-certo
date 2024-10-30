/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
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
/*     */ public class SwitchTransformer<I, O>
/*     */   implements Serializable, Transformer<I, O>
/*     */ {
/*     */   private static final long serialVersionUID = -6404460890903469332L;
/*     */   private final Predicate<? super I>[] iPredicates;
/*     */   private final Transformer<? super I, ? extends O>[] iTransformers;
/*     */   private final Transformer<? super I, ? extends O> iDefault;
/*     */   
/*     */   public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] paramArrayOfPredicate, Transformer<? super I, ? extends O>[] paramArrayOfTransformer, Transformer<? super I, ? extends O> paramTransformer) {
/*  60 */     FunctorUtils.validate((Predicate<?>[])paramArrayOfPredicate);
/*  61 */     FunctorUtils.validate((Transformer<?, ?>[])paramArrayOfTransformer);
/*  62 */     if (paramArrayOfPredicate.length != paramArrayOfTransformer.length) {
/*  63 */       throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
/*     */     }
/*  65 */     if (paramArrayOfPredicate.length == 0) {
/*  66 */       return (paramTransformer == null) ? ConstantTransformer.<I, O>nullTransformer() : (Transformer)paramTransformer;
/*     */     }
/*     */     
/*  69 */     return new SwitchTransformer<I, O>(paramArrayOfPredicate, paramArrayOfTransformer, paramTransformer);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <I, O> Transformer<I, O> switchTransformer(Map<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> paramMap) {
/*  95 */     if (paramMap == null) {
/*  96 */       throw new NullPointerException("The predicate and transformer map must not be null");
/*     */     }
/*  98 */     if (paramMap.size() == 0) {
/*  99 */       return ConstantTransformer.nullTransformer();
/*     */     }
/*     */     
/* 102 */     Transformer<I, O> transformer = (Transformer)paramMap.remove(null);
/* 103 */     int i = paramMap.size();
/* 104 */     if (i == 0) {
/* 105 */       return (transformer == null) ? ConstantTransformer.<I, O>nullTransformer() : transformer;
/*     */     }
/*     */     
/* 108 */     Transformer[] arrayOfTransformer = new Transformer[i];
/* 109 */     Predicate[] arrayOfPredicate = new Predicate[i];
/* 110 */     byte b = 0;
/*     */     
/* 112 */     for (Map.Entry<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> entry : paramMap.entrySet()) {
/* 113 */       arrayOfPredicate[b] = (Predicate)entry.getKey();
/* 114 */       arrayOfTransformer[b] = (Transformer)entry.getValue();
/* 115 */       b++;
/*     */     } 
/* 117 */     return new SwitchTransformer<I, O>(false, (Predicate<? super I>[])arrayOfPredicate, (Transformer<? super I, ? extends O>[])arrayOfTransformer, transformer);
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
/*     */   private SwitchTransformer(boolean paramBoolean, Predicate<? super I>[] paramArrayOfPredicate, Transformer<? super I, ? extends O>[] paramArrayOfTransformer, Transformer<? super I, ? extends O> paramTransformer) {
/* 133 */     this.iPredicates = paramBoolean ? (Predicate<? super I>[])FunctorUtils.<I>copy(paramArrayOfPredicate) : paramArrayOfPredicate;
/* 134 */     this.iTransformers = paramBoolean ? (Transformer<? super I, ? extends O>[])FunctorUtils.<I, O>copy(paramArrayOfTransformer) : paramArrayOfTransformer;
/* 135 */     this.iDefault = (paramTransformer == null) ? ConstantTransformer.<I, O>nullTransformer() : paramTransformer;
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
/*     */   public SwitchTransformer(Predicate<? super I>[] paramArrayOfPredicate, Transformer<? super I, ? extends O>[] paramArrayOfTransformer, Transformer<? super I, ? extends O> paramTransformer) {
/* 150 */     this(true, paramArrayOfPredicate, paramArrayOfTransformer, paramTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public O transform(I paramI) {
/* 161 */     for (byte b = 0; b < this.iPredicates.length; b++) {
/* 162 */       if (this.iPredicates[b].evaluate(paramI) == true) {
/* 163 */         return (O)this.iTransformers[b].transform(paramI);
/*     */       }
/*     */     } 
/* 166 */     return (O)this.iDefault.transform(paramI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Predicate<? super I>[] getPredicates() {
/* 176 */     return (Predicate<? super I>[])FunctorUtils.copy(this.iPredicates);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transformer<? super I, ? extends O>[] getTransformers() {
/* 186 */     return (Transformer<? super I, ? extends O>[])FunctorUtils.copy(this.iTransformers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transformer<? super I, ? extends O> getDefaultTransformer() {
/* 196 */     return this.iDefault;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\SwitchTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */