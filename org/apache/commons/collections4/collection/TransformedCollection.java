/*     */ package org.apache.commons.collections4.collection;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransformedCollection<E>
/*     */   extends AbstractCollectionDecorator<E>
/*     */ {
/*     */   private static final long serialVersionUID = 8692300188161871514L;
/*     */   protected final Transformer<? super E, ? extends E> transformer;
/*     */   
/*     */   public static <E> TransformedCollection<E> transformingCollection(Collection<E> paramCollection, Transformer<? super E, ? extends E> paramTransformer) {
/*  63 */     return new TransformedCollection<E>(paramCollection, paramTransformer);
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
/*     */   public static <E> TransformedCollection<E> transformedCollection(Collection<E> paramCollection, Transformer<? super E, ? extends E> paramTransformer) {
/*  84 */     TransformedCollection<E> transformedCollection = new TransformedCollection<E>(paramCollection, paramTransformer);
/*     */     
/*  86 */     if (paramCollection.size() > 0) {
/*     */       
/*  88 */       Object[] arrayOfObject = paramCollection.toArray();
/*  89 */       paramCollection.clear();
/*  90 */       for (Object object : arrayOfObject) {
/*  91 */         transformedCollection.decorated().add(paramTransformer.transform(object));
/*     */       }
/*     */     } 
/*  94 */     return transformedCollection;
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
/*     */   protected TransformedCollection(Collection<E> paramCollection, Transformer<? super E, ? extends E> paramTransformer) {
/* 109 */     super(paramCollection);
/* 110 */     if (paramTransformer == null) {
/* 111 */       throw new NullPointerException("Transformer must not be null");
/*     */     }
/* 113 */     this.transformer = paramTransformer;
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
/*     */   protected E transform(E paramE) {
/* 125 */     return (E)this.transformer.transform(paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<E> transform(Collection<? extends E> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: new java/util/ArrayList
/*     */     //   3: dup
/*     */     //   4: aload_1
/*     */     //   5: invokeinterface size : ()I
/*     */     //   10: invokespecial <init> : (I)V
/*     */     //   13: astore_2
/*     */     //   14: aload_1
/*     */     //   15: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   20: astore_3
/*     */     //   21: aload_3
/*     */     //   22: invokeinterface hasNext : ()Z
/*     */     //   27: ifeq -> 54
/*     */     //   30: aload_3
/*     */     //   31: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   36: astore #4
/*     */     //   38: aload_2
/*     */     //   39: aload_0
/*     */     //   40: aload #4
/*     */     //   42: invokevirtual transform : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   45: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   50: pop
/*     */     //   51: goto -> 21
/*     */     //   54: aload_2
/*     */     //   55: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #137	-> 0
/*     */     //   #138	-> 14
/*     */     //   #139	-> 38
/*     */     //   #140	-> 51
/*     */     //   #141	-> 54
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 147 */     return decorated().add(transform(paramE));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 152 */     return decorated().addAll(transform(paramCollection));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\collection\TransformedCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */