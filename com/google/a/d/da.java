/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.k.e;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ final class da<T>
/*     */ {
/*     */   private final int fg;
/*     */   private final Comparator<? super T> comparator;
/*     */   private final T[] n;
/*     */   private int bufferSize;
/*     */   private T V;
/*     */   
/*     */   public static <T extends Comparable<? super T>> da<T> a(int paramInt) {
/*  64 */     return b(paramInt, cj.e());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> da<T> b(int paramInt, Comparator<? super T> paramComparator) {
/*  74 */     return new da<>(paramComparator, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Comparable<? super T>> da<T> b(int paramInt) {
/*  85 */     return c(paramInt, cj.e());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> da<T> c(int paramInt, Comparator<? super T> paramComparator) {
/*  95 */     return new da<>(cj.<T>b(paramComparator).a(), paramInt);
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
/*     */   private da(Comparator<? super T> paramComparator, int paramInt) {
/* 116 */     this.comparator = (Comparator<? super T>)D.b(paramComparator, "comparator");
/* 117 */     this.fg = paramInt;
/* 118 */     D.a((paramInt >= 0), "k (%s) must be >= 0", paramInt);
/* 119 */     D.a((paramInt <= 1073741823), "k (%s) must be <= Integer.MAX_VALUE / 2", paramInt);
/* 120 */     this.n = (T[])new Object[e.t(paramInt, 2)];
/* 121 */     this.bufferSize = 0;
/* 122 */     this.V = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void p(T paramT) {
/* 130 */     if (this.fg == 0)
/*     */       return; 
/* 132 */     if (this.bufferSize == 0) {
/* 133 */       this.n[0] = paramT;
/* 134 */       this.V = paramT;
/* 135 */       this.bufferSize = 1;
/* 136 */     } else if (this.bufferSize < this.fg) {
/* 137 */       this.n[this.bufferSize++] = paramT;
/* 138 */       if (this.comparator.compare(paramT, this.V) > 0) {
/* 139 */         this.V = paramT;
/*     */       }
/* 141 */     } else if (this.comparator.compare(paramT, this.V) < 0) {
/*     */       
/* 143 */       this.n[this.bufferSize++] = paramT;
/* 144 */       if (this.bufferSize == 2 * this.fg) {
/* 145 */         fp();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fp() {
/* 155 */     int i = 0;
/* 156 */     int j = 2 * this.fg - 1;
/*     */     
/* 158 */     int k = 0;
/*     */ 
/*     */ 
/*     */     
/* 162 */     byte b = 0;
/* 163 */     int m = e.a(j - i, RoundingMode.CEILING) * 3;
/* 164 */     while (i < j) {
/* 165 */       int i1 = i + j + 1 >>> 1;
/*     */       
/* 167 */       int i2 = b(i, j, i1);
/*     */       
/* 169 */       if (i2 > this.fg) {
/* 170 */         j = i2 - 1;
/* 171 */       } else if (i2 < this.fg) {
/* 172 */         i = Math.max(i2, i + 1);
/* 173 */         k = i2;
/*     */       } else {
/*     */         break;
/*     */       } 
/* 177 */       b++;
/* 178 */       if (b >= m) {
/*     */         
/* 180 */         Arrays.sort(this.n, i, j, this.comparator);
/*     */         break;
/*     */       } 
/*     */     } 
/* 184 */     this.bufferSize = this.fg;
/*     */     
/* 186 */     this.V = this.n[k];
/* 187 */     for (int n = k + 1; n < this.fg; n++) {
/* 188 */       if (this.comparator.compare(this.n[n], this.V) > 0) {
/* 189 */         this.V = this.n[n];
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
/*     */   private int b(int paramInt1, int paramInt2, int paramInt3) {
/* 201 */     T t = this.n[paramInt3];
/* 202 */     this.n[paramInt3] = this.n[paramInt2];
/*     */     
/* 204 */     int i = paramInt1;
/* 205 */     for (int j = paramInt1; j < paramInt2; j++) {
/* 206 */       if (this.comparator.compare(this.n[j], t) < 0) {
/* 207 */         g(i, j);
/* 208 */         i++;
/*     */       } 
/*     */     } 
/* 211 */     this.n[paramInt2] = this.n[i];
/* 212 */     this.n[i] = t;
/* 213 */     return i;
/*     */   }
/*     */   
/*     */   private void g(int paramInt1, int paramInt2) {
/* 217 */     T t = this.n[paramInt1];
/* 218 */     this.n[paramInt1] = this.n[paramInt2];
/* 219 */     this.n[paramInt2] = t;
/*     */   }
/*     */   
/*     */   da<T> a(da<T> paramda) {
/* 223 */     for (byte b = 0; b < paramda.bufferSize; b++) {
/* 224 */       p(paramda.n[b]);
/*     */     }
/* 226 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void d(Iterable<? extends T> paramIterable) {
/* 237 */     b(paramIterable.iterator());
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
/*     */   public void b(Iterator<? extends T> paramIterator) {
/* 249 */     while (paramIterator.hasNext()) {
/* 250 */       p(paramIterator.next());
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
/*     */   public List<T> Y() {
/* 263 */     Arrays.sort(this.n, 0, this.bufferSize, this.comparator);
/* 264 */     if (this.bufferSize > this.fg) {
/* 265 */       Arrays.fill((Object[])this.n, this.fg, this.n.length, (Object)null);
/* 266 */       this.bufferSize = this.fg;
/* 267 */       this.V = this.n[this.fg - 1];
/*     */     } 
/*     */     
/* 270 */     return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.n, this.bufferSize)));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\da.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */