/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PermutationIterator<E>
/*     */   implements Iterator<List<E>>
/*     */ {
/*     */   private int[] keys;
/*     */   private Map<Integer, E> objectMap;
/*     */   private boolean[] direction;
/*     */   private List<E> nextPermutation;
/*     */   
/*     */   public PermutationIterator(Collection<? extends E> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial <init> : ()V
/*     */     //   4: aload_1
/*     */     //   5: ifnonnull -> 18
/*     */     //   8: new java/lang/NullPointerException
/*     */     //   11: dup
/*     */     //   12: ldc 'The collection must not be null'
/*     */     //   14: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   17: athrow
/*     */     //   18: aload_0
/*     */     //   19: aload_1
/*     */     //   20: invokeinterface size : ()I
/*     */     //   25: newarray int
/*     */     //   27: putfield keys : [I
/*     */     //   30: aload_0
/*     */     //   31: aload_1
/*     */     //   32: invokeinterface size : ()I
/*     */     //   37: newarray boolean
/*     */     //   39: putfield direction : [Z
/*     */     //   42: aload_0
/*     */     //   43: getfield direction : [Z
/*     */     //   46: iconst_0
/*     */     //   47: invokestatic fill : ([ZZ)V
/*     */     //   50: iconst_1
/*     */     //   51: istore_2
/*     */     //   52: aload_0
/*     */     //   53: new java/util/HashMap
/*     */     //   56: dup
/*     */     //   57: invokespecial <init> : ()V
/*     */     //   60: putfield objectMap : Ljava/util/Map;
/*     */     //   63: aload_1
/*     */     //   64: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   69: astore_3
/*     */     //   70: aload_3
/*     */     //   71: invokeinterface hasNext : ()Z
/*     */     //   76: ifeq -> 118
/*     */     //   79: aload_3
/*     */     //   80: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   85: astore #4
/*     */     //   87: aload_0
/*     */     //   88: getfield objectMap : Ljava/util/Map;
/*     */     //   91: iload_2
/*     */     //   92: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   95: aload #4
/*     */     //   97: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   102: pop
/*     */     //   103: aload_0
/*     */     //   104: getfield keys : [I
/*     */     //   107: iload_2
/*     */     //   108: iconst_1
/*     */     //   109: isub
/*     */     //   110: iload_2
/*     */     //   111: iastore
/*     */     //   112: iinc #2, 1
/*     */     //   115: goto -> 70
/*     */     //   118: aload_0
/*     */     //   119: new java/util/ArrayList
/*     */     //   122: dup
/*     */     //   123: aload_1
/*     */     //   124: invokespecial <init> : (Ljava/util/Collection;)V
/*     */     //   127: putfield nextPermutation : Ljava/util/List;
/*     */     //   130: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #76	-> 0
/*     */     //   #77	-> 4
/*     */     //   #78	-> 8
/*     */     //   #81	-> 18
/*     */     //   #82	-> 30
/*     */     //   #83	-> 42
/*     */     //   #84	-> 50
/*     */     //   #85	-> 52
/*     */     //   #86	-> 63
/*     */     //   #87	-> 87
/*     */     //   #88	-> 103
/*     */     //   #89	-> 112
/*     */     //   #90	-> 115
/*     */     //   #91	-> 118
/*     */     //   #92	-> 130
/*     */   }
/*     */   
/*     */   public boolean hasNext() {
/*  99 */     return (this.nextPermutation != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<E> next() {
/* 108 */     if (!hasNext()) {
/* 109 */       throw new NoSuchElementException();
/*     */     }
/*     */ 
/*     */     
/* 113 */     byte b = -1;
/* 114 */     int i = -1; byte b1;
/* 115 */     for (b1 = 0; b1 < this.keys.length; b1++) {
/* 116 */       if ((this.direction[b1] && b1 < this.keys.length - 1 && this.keys[b1] > this.keys[b1 + 1]) || (!this.direction[b1] && b1 > 0 && this.keys[b1] > this.keys[b1 - 1]))
/*     */       {
/* 118 */         if (this.keys[b1] > i) {
/* 119 */           i = this.keys[b1];
/* 120 */           b = b1;
/*     */         } 
/*     */       }
/*     */     } 
/* 124 */     if (i == -1) {
/* 125 */       List<E> list1 = this.nextPermutation;
/* 126 */       this.nextPermutation = null;
/* 127 */       return list1;
/*     */     } 
/*     */ 
/*     */     
/* 131 */     b1 = this.direction[b] ? 1 : -1;
/* 132 */     int j = this.keys[b];
/* 133 */     this.keys[b] = this.keys[b + b1];
/* 134 */     this.keys[b + b1] = j;
/* 135 */     boolean bool = this.direction[b];
/* 136 */     this.direction[b] = this.direction[b + b1];
/* 137 */     this.direction[b + b1] = bool;
/*     */ 
/*     */     
/* 140 */     ArrayList<E> arrayList = new ArrayList();
/* 141 */     for (byte b2 = 0; b2 < this.keys.length; b2++) {
/* 142 */       if (this.keys[b2] > i) {
/* 143 */         this.direction[b2] = !this.direction[b2];
/*     */       }
/* 145 */       arrayList.add(this.objectMap.get(Integer.valueOf(this.keys[b2])));
/*     */     } 
/* 147 */     List<E> list = this.nextPermutation;
/* 148 */     this.nextPermutation = arrayList;
/* 149 */     return list;
/*     */   }
/*     */   
/*     */   public void remove() {
/* 153 */     throw new UnsupportedOperationException("remove() is not supported");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\PermutationIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */