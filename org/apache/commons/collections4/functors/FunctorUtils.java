/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import org.apache.commons.collections4.Closure;
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
/*     */ class FunctorUtils
/*     */ {
/*     */   static <T> Predicate<T>[] copy(Predicate<? super T>... paramVarArgs) {
/*  50 */     if (paramVarArgs == null) {
/*  51 */       return null;
/*     */     }
/*  53 */     return (Predicate<T>[])paramVarArgs.clone();
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
/*     */   static <T> Predicate<T> coerce(Predicate<? super T> paramPredicate) {
/*  70 */     return (Predicate)paramPredicate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void validate(Predicate<?>... paramVarArgs) {
/*  79 */     if (paramVarArgs == null) {
/*  80 */       throw new NullPointerException("The predicate array must not be null");
/*     */     }
/*  82 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*  83 */       if (paramVarArgs[b] == null) {
/*  84 */         throw new NullPointerException("The predicate array must not contain a null predicate, index " + b + " was null");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <T> Predicate<? super T>[] validate(Collection<? extends Predicate<? super T>> paramCollection) {
/*  97 */     if (paramCollection == null) {
/*  98 */       throw new NullPointerException("The predicate collection must not be null");
/*     */     }
/*     */ 
/*     */     
/* 102 */     Predicate[] arrayOfPredicate = new Predicate[paramCollection.size()];
/* 103 */     byte b = 0;
/* 104 */     for (Predicate<? super T> predicate : paramCollection) {
/* 105 */       arrayOfPredicate[b] = predicate;
/* 106 */       if (arrayOfPredicate[b] == null) {
/* 107 */         throw new NullPointerException("The predicate collection must not contain a null predicate, index " + b + " was null");
/*     */       }
/*     */       
/* 110 */       b++;
/*     */     } 
/* 112 */     return (Predicate<? super T>[])arrayOfPredicate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <E> Closure<E>[] copy(Closure<? super E>... paramVarArgs) {
/* 123 */     if (paramVarArgs == null) {
/* 124 */       return null;
/*     */     }
/* 126 */     return (Closure<E>[])paramVarArgs.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void validate(Closure<?>... paramVarArgs) {
/* 135 */     if (paramVarArgs == null) {
/* 136 */       throw new NullPointerException("The closure array must not be null");
/*     */     }
/* 138 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 139 */       if (paramVarArgs[b] == null) {
/* 140 */         throw new NullPointerException("The closure array must not contain a null closure, index " + b + " was null");
/*     */       }
/*     */     } 
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
/*     */   static <T> Closure<T> coerce(Closure<? super T> paramClosure) {
/* 158 */     return (Closure)paramClosure;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <I, O> Transformer<I, O>[] copy(Transformer<? super I, ? extends O>... paramVarArgs) {
/* 169 */     if (paramVarArgs == null) {
/* 170 */       return null;
/*     */     }
/* 172 */     return (Transformer<I, O>[])paramVarArgs.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void validate(Transformer<?, ?>... paramVarArgs) {
/* 181 */     if (paramVarArgs == null) {
/* 182 */       throw new NullPointerException("The transformer array must not be null");
/*     */     }
/* 184 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 185 */       if (paramVarArgs[b] == null) {
/* 186 */         throw new NullPointerException("The transformer array must not contain a null transformer, index " + b + " was null");
/*     */       }
/*     */     } 
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
/*     */   static <I, O> Transformer<I, O> coerce(Transformer<? super I, ? extends O> paramTransformer) {
/* 204 */     return (Transformer)paramTransformer;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\FunctorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */