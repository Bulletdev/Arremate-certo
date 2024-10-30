/*     */ package org.apache.commons.text.similarity;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.Function;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IntersectionSimilarity<T>
/*     */   implements SimilarityScore<IntersectionResult>
/*     */ {
/*     */   private final Function<CharSequence, Collection<T>> converter;
/*     */   
/*     */   private static class BagCount
/*     */   {
/*     */     private BagCount() {}
/*     */     
/*  51 */     int count = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class TinyBag
/*     */   {
/*     */     private final Map<T, IntersectionSimilarity.BagCount> map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     TinyBag(int param1Int) {
/*  70 */       this.map = new HashMap<>(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void add(T param1T) {
/*  79 */       IntersectionSimilarity.BagCount bagCount = this.map.get(param1T);
/*  80 */       if (bagCount == null) {
/*  81 */         this.map.put(param1T, new IntersectionSimilarity.BagCount());
/*     */       } else {
/*  83 */         bagCount.count++;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int getCount(Object param1Object) {
/*  95 */       IntersectionSimilarity.BagCount bagCount = this.map.get(param1Object);
/*  96 */       if (bagCount != null) {
/*  97 */         return bagCount.count;
/*     */       }
/*  99 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Set<Map.Entry<T, IntersectionSimilarity.BagCount>> entrySet() {
/* 108 */       return this.map.entrySet();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int uniqueElementSize() {
/* 117 */       return this.map.size();
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
/*     */   public IntersectionSimilarity(Function<CharSequence, Collection<T>> paramFunction) {
/* 132 */     if (paramFunction == null) {
/* 133 */       throw new IllegalArgumentException("Converter must not be null");
/*     */     }
/* 135 */     this.converter = paramFunction;
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
/*     */   public IntersectionResult apply(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*     */     int k;
/* 148 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 149 */       throw new IllegalArgumentException("Input cannot be null");
/*     */     }
/*     */ 
/*     */     
/* 153 */     Collection<T> collection1 = this.converter.apply(paramCharSequence1);
/* 154 */     Collection<T> collection2 = this.converter.apply(paramCharSequence2);
/* 155 */     int i = collection1.size();
/* 156 */     int j = collection2.size();
/*     */ 
/*     */     
/* 159 */     if (Math.min(i, j) == 0)
/*     */     {
/* 161 */       return new IntersectionResult(i, j, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 166 */     if (collection1 instanceof Set && collection2 instanceof Set) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       k = (i < j) ? getIntersection((Set)collection1, (Set)collection2) : getIntersection((Set)collection2, (Set)collection1);
/*     */     } else {
/*     */       
/* 174 */       TinyBag tinyBag1 = toBag(collection1);
/* 175 */       TinyBag tinyBag2 = toBag(collection2);
/*     */ 
/*     */ 
/*     */       
/* 179 */       k = (tinyBag1.uniqueElementSize() < tinyBag2.uniqueElementSize()) ? getIntersection(tinyBag1, tinyBag2) : getIntersection(tinyBag2, tinyBag1);
/*     */     } 
/*     */     
/* 182 */     return new IntersectionResult(i, j, k);
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
/*     */   private TinyBag toBag(Collection<T> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: new org/apache/commons/text/similarity/IntersectionSimilarity$TinyBag
/*     */     //   3: dup
/*     */     //   4: aload_0
/*     */     //   5: aload_1
/*     */     //   6: invokeinterface size : ()I
/*     */     //   11: invokespecial <init> : (Lorg/apache/commons/text/similarity/IntersectionSimilarity;I)V
/*     */     //   14: astore_2
/*     */     //   15: aload_1
/*     */     //   16: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   21: astore_3
/*     */     //   22: aload_3
/*     */     //   23: invokeinterface hasNext : ()Z
/*     */     //   28: ifeq -> 48
/*     */     //   31: aload_3
/*     */     //   32: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   37: astore #4
/*     */     //   39: aload_2
/*     */     //   40: aload #4
/*     */     //   42: invokevirtual add : (Ljava/lang/Object;)V
/*     */     //   45: goto -> 22
/*     */     //   48: aload_2
/*     */     //   49: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #193	-> 0
/*     */     //   #194	-> 15
/*     */     //   #195	-> 39
/*     */     //   #196	-> 45
/*     */     //   #197	-> 48
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
/*     */   private static <T> int getIntersection(Set<T> paramSet1, Set<T> paramSet2) {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_2
/*     */     //   2: aload_0
/*     */     //   3: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   8: astore_3
/*     */     //   9: aload_3
/*     */     //   10: invokeinterface hasNext : ()Z
/*     */     //   15: ifeq -> 43
/*     */     //   18: aload_3
/*     */     //   19: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   24: astore #4
/*     */     //   26: aload_1
/*     */     //   27: aload #4
/*     */     //   29: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   34: ifeq -> 40
/*     */     //   37: iinc #2, 1
/*     */     //   40: goto -> 9
/*     */     //   43: iload_2
/*     */     //   44: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #210	-> 0
/*     */     //   #211	-> 2
/*     */     //   #212	-> 26
/*     */     //   #213	-> 37
/*     */     //   #215	-> 40
/*     */     //   #216	-> 43
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
/*     */   private int getIntersection(TinyBag paramTinyBag1, TinyBag paramTinyBag2) {
/* 228 */     int i = 0;
/* 229 */     for (Map.Entry<T, BagCount> entry : paramTinyBag1.entrySet()) {
/* 230 */       Object object = entry.getKey();
/* 231 */       int j = ((BagCount)entry.getValue()).count;
/*     */       
/* 233 */       i += Math.min(j, paramTinyBag2.getCount(object));
/*     */     } 
/* 235 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\IntersectionSimilarity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */