/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.k.e;
/*     */ import java.util.AbstractList;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.RandomAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ final class z<E>
/*     */   extends AbstractList<List<E>>
/*     */   implements RandomAccess
/*     */ {
/*     */   private final transient bh<List<E>> c;
/*     */   private final transient int[] C;
/*     */   
/*     */   static <E> List<List<E>> e(List<? extends List<? extends E>> paramList) {
/*  39 */     bh.a<bh<?>> a = new bh.a(paramList.size());
/*  40 */     for (List<?> list : paramList) {
/*  41 */       bh<?> bh1 = bh.a(list);
/*  42 */       if (bh1.isEmpty()) {
/*  43 */         return bh.e();
/*     */       }
/*  45 */       a.a(bh1);
/*     */     } 
/*  47 */     return new z<>((bh)a.g());
/*     */   }
/*     */   
/*     */   z(bh<List<E>> parambh) {
/*  51 */     this.c = parambh;
/*  52 */     int[] arrayOfInt = new int[parambh.size() + 1];
/*  53 */     arrayOfInt[parambh.size()] = 1;
/*     */     try {
/*  55 */       for (int i = parambh.size() - 1; i >= 0; i--) {
/*  56 */         arrayOfInt[i] = e.t(arrayOfInt[i + 1], ((List)parambh.get(i)).size());
/*     */       }
/*  58 */     } catch (ArithmeticException arithmeticException) {
/*  59 */       throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
/*     */     } 
/*     */     
/*  62 */     this.C = arrayOfInt;
/*     */   }
/*     */   
/*     */   private int d(int paramInt1, int paramInt2) {
/*  66 */     return paramInt1 / this.C[paramInt2 + 1] % ((List)this.c.get(paramInt2)).size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int indexOf(Object paramObject) {
/*  71 */     if (!(paramObject instanceof List)) {
/*  72 */       return -1;
/*     */     }
/*  74 */     List list = (List)paramObject;
/*  75 */     if (list.size() != this.c.size()) {
/*  76 */       return -1;
/*     */     }
/*  78 */     ListIterator listIterator = list.listIterator();
/*  79 */     int i = 0;
/*  80 */     while (listIterator.hasNext()) {
/*  81 */       int j = listIterator.nextIndex();
/*  82 */       int k = ((List)this.c.get(j)).indexOf(listIterator.next());
/*  83 */       if (k == -1) {
/*  84 */         return -1;
/*     */       }
/*  86 */       i += k * this.C[j + 1];
/*     */     } 
/*  88 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int lastIndexOf(Object paramObject) {
/*  93 */     if (!(paramObject instanceof List)) {
/*  94 */       return -1;
/*     */     }
/*  96 */     List list = (List)paramObject;
/*  97 */     if (list.size() != this.c.size()) {
/*  98 */       return -1;
/*     */     }
/* 100 */     ListIterator listIterator = list.listIterator();
/* 101 */     int i = 0;
/* 102 */     while (listIterator.hasNext()) {
/* 103 */       int j = listIterator.nextIndex();
/* 104 */       int k = ((List)this.c.get(j)).lastIndexOf(listIterator.next());
/* 105 */       if (k == -1) {
/* 106 */         return -1;
/*     */       }
/* 108 */       i += k * this.C[j + 1];
/*     */     } 
/* 110 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public bh<E> a(final int index) {
/* 115 */     D.b(index, size());
/* 116 */     return new bh<E>(this)
/*     */       {
/*     */         public int size()
/*     */         {
/* 120 */           return z.a(this.a).size();
/*     */         }
/*     */ 
/*     */         
/*     */         public E get(int param1Int) {
/* 125 */           D.b(param1Int, size());
/* 126 */           int i = z.a(this.a, index, param1Int);
/* 127 */           return ((List<E>)z.a(this.a).get(param1Int)).get(i);
/*     */         }
/*     */ 
/*     */         
/*     */         boolean cO() {
/* 132 */           return true;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 139 */     return this.C[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 144 */     if (!(paramObject instanceof List)) {
/* 145 */       return false;
/*     */     }
/* 147 */     List list = (List)paramObject;
/* 148 */     if (list.size() != this.c.size()) {
/* 149 */       return false;
/*     */     }
/* 151 */     byte b = 0;
/* 152 */     for (Object object : list) {
/* 153 */       if (!((List)this.c.get(b)).contains(object)) {
/* 154 */         return false;
/*     */       }
/* 156 */       b++;
/*     */     } 
/* 158 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\z.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */