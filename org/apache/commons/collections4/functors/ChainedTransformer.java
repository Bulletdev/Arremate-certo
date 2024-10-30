/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
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
/*     */ public class ChainedTransformer<T>
/*     */   implements Serializable, Transformer<T, T>
/*     */ {
/*     */   private static final long serialVersionUID = 3514945074733160196L;
/*     */   private final Transformer<? super T, ? extends T>[] iTransformers;
/*     */   
/*     */   public static <T> Transformer<T, T> chainedTransformer(Transformer<? super T, ? extends T>... paramVarArgs) {
/*  51 */     FunctorUtils.validate((Transformer<?, ?>[])paramVarArgs);
/*  52 */     if (paramVarArgs.length == 0) {
/*  53 */       return NOPTransformer.nopTransformer();
/*     */     }
/*  55 */     return new ChainedTransformer<T>(paramVarArgs);
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
/*     */   public static <T> Transformer<T, T> chainedTransformer(Collection<? extends Transformer<? super T, ? extends T>> paramCollection) {
/*  72 */     if (paramCollection == null) {
/*  73 */       throw new NullPointerException("Transformer collection must not be null");
/*     */     }
/*  75 */     if (paramCollection.size() == 0) {
/*  76 */       return NOPTransformer.nopTransformer();
/*     */     }
/*     */     
/*  79 */     Transformer[] arrayOfTransformer = paramCollection.<Transformer>toArray(new Transformer[paramCollection.size()]);
/*  80 */     FunctorUtils.validate((Transformer<?, ?>[])arrayOfTransformer);
/*  81 */     return new ChainedTransformer<T>(false, (Transformer<? super T, ? extends T>[])arrayOfTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ChainedTransformer(boolean paramBoolean, Transformer<? super T, ? extends T>[] paramArrayOfTransformer) {
/*  92 */     this.iTransformers = paramBoolean ? (Transformer<? super T, ? extends T>[])FunctorUtils.<T, T>copy(paramArrayOfTransformer) : paramArrayOfTransformer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChainedTransformer(Transformer<? super T, ? extends T>... paramVarArgs) {
/* 102 */     this(true, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T transform(T paramT) {
/* 112 */     for (Transformer<? super T, ? extends T> transformer : this.iTransformers) {
/* 113 */       paramT = (T)transformer.transform(paramT);
/*     */     }
/* 115 */     return paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Transformer<? super T, ? extends T>[] getTransformers() {
/* 125 */     return (Transformer<? super T, ? extends T>[])FunctorUtils.copy(this.iTransformers);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\ChainedTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */