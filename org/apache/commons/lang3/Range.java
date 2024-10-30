/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Range<T>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final Comparator<T> comparator;
/*     */   private transient int hashCode;
/*     */   private final T maximum;
/*     */   private final T minimum;
/*     */   private transient String toString;
/*     */   
/*     */   private enum ComparableComparator
/*     */     implements Comparator
/*     */   {
/*  38 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int compare(Object param1Object1, Object param1Object2) {
/*  48 */       return ((Comparable<Object>)param1Object1).compareTo(param1Object2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Comparable<T>> Range<T> between(T paramT1, T paramT2) {
/*  74 */     return between(paramT1, paramT2, null);
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
/*     */   public static <T> Range<T> between(T paramT1, T paramT2, Comparator<T> paramComparator) {
/*  95 */     return new Range<>(paramT1, paramT2, paramComparator);
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
/*     */   public static <T extends Comparable<T>> Range<T> is(T paramT) {
/* 112 */     return between(paramT, paramT, null);
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
/*     */   public static <T> Range<T> is(T paramT, Comparator<T> paramComparator) {
/* 130 */     return between(paramT, paramT, paramComparator);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Range(T paramT1, T paramT2, Comparator<T> paramComparator) {
/* 170 */     if (paramT1 == null || paramT2 == null) {
/* 171 */       throw new IllegalArgumentException("Elements in a range must not be null: element1=" + paramT1 + ", element2=" + paramT2);
/*     */     }
/*     */     
/* 174 */     if (paramComparator == null) {
/* 175 */       this.comparator = ComparableComparator.INSTANCE;
/*     */     } else {
/* 177 */       this.comparator = paramComparator;
/*     */     } 
/* 179 */     if (this.comparator.compare(paramT1, paramT2) < 1) {
/* 180 */       this.minimum = paramT1;
/* 181 */       this.maximum = paramT2;
/*     */     } else {
/* 183 */       this.minimum = paramT2;
/* 184 */       this.maximum = paramT1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(T paramT) {
/* 195 */     if (paramT == null) {
/* 196 */       return false;
/*     */     }
/* 198 */     return (this.comparator.compare(paramT, this.minimum) > -1 && this.comparator.compare(paramT, this.maximum) < 1);
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
/*     */   public boolean containsRange(Range<T> paramRange) {
/* 211 */     if (paramRange == null) {
/* 212 */       return false;
/*     */     }
/* 214 */     return (contains(paramRange.minimum) && 
/* 215 */       contains(paramRange.maximum));
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
/*     */   public int elementCompareTo(T paramT) {
/* 230 */     Validate.notNull(paramT, "Element is null", new Object[0]);
/* 231 */     if (isAfter(paramT))
/* 232 */       return -1; 
/* 233 */     if (isBefore(paramT)) {
/* 234 */       return 1;
/*     */     }
/* 236 */     return 0;
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
/*     */   public boolean equals(Object paramObject) {
/* 254 */     if (paramObject == this)
/* 255 */       return true; 
/* 256 */     if (paramObject == null || paramObject.getClass() != getClass()) {
/* 257 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 261 */     Range range = (Range)paramObject;
/* 262 */     return (this.minimum.equals(range.minimum) && this.maximum
/* 263 */       .equals(range.maximum));
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
/*     */   public Comparator<T> getComparator() {
/* 276 */     return this.comparator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getMaximum() {
/* 285 */     return this.maximum;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getMinimum() {
/* 294 */     return this.minimum;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 304 */     int i = this.hashCode;
/* 305 */     if (this.hashCode == 0) {
/* 306 */       i = 17;
/* 307 */       i = 37 * i + getClass().hashCode();
/* 308 */       i = 37 * i + this.minimum.hashCode();
/* 309 */       i = 37 * i + this.maximum.hashCode();
/* 310 */       this.hashCode = i;
/*     */     } 
/* 312 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Range<T> intersectionWith(Range<T> paramRange) {
/* 323 */     if (!isOverlappedBy(paramRange)) {
/* 324 */       throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", new Object[] { paramRange }));
/*     */     }
/*     */     
/* 327 */     if (equals(paramRange)) {
/* 328 */       return this;
/*     */     }
/* 330 */     T t1 = (getComparator().compare(this.minimum, paramRange.minimum) < 0) ? paramRange.minimum : this.minimum;
/* 331 */     T t2 = (getComparator().compare(this.maximum, paramRange.maximum) < 0) ? this.maximum : paramRange.maximum;
/* 332 */     return between(t1, t2, getComparator());
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
/*     */   public boolean isAfter(T paramT) {
/* 345 */     if (paramT == null) {
/* 346 */       return false;
/*     */     }
/* 348 */     return (this.comparator.compare(paramT, this.minimum) < 0);
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
/*     */   public boolean isAfterRange(Range<T> paramRange) {
/* 361 */     if (paramRange == null) {
/* 362 */       return false;
/*     */     }
/* 364 */     return isAfter(paramRange.maximum);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBefore(T paramT) {
/* 374 */     if (paramT == null) {
/* 375 */       return false;
/*     */     }
/* 377 */     return (this.comparator.compare(paramT, this.maximum) > 0);
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
/*     */   public boolean isBeforeRange(Range<T> paramRange) {
/* 390 */     if (paramRange == null) {
/* 391 */       return false;
/*     */     }
/* 393 */     return isBefore(paramRange.minimum);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEndedBy(T paramT) {
/* 403 */     if (paramT == null) {
/* 404 */       return false;
/*     */     }
/* 406 */     return (this.comparator.compare(paramT, this.maximum) == 0);
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
/*     */   public boolean isNaturalOrdering() {
/* 421 */     return (this.comparator == ComparableComparator.INSTANCE);
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
/*     */   public boolean isOverlappedBy(Range<T> paramRange) {
/* 437 */     if (paramRange == null) {
/* 438 */       return false;
/*     */     }
/* 440 */     return (paramRange.contains(this.minimum) || paramRange
/* 441 */       .contains(this.maximum) || 
/* 442 */       contains(paramRange.minimum));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStartedBy(T paramT) {
/* 452 */     if (paramT == null) {
/* 453 */       return false;
/*     */     }
/* 455 */     return (this.comparator.compare(paramT, this.minimum) == 0);
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
/*     */   public T fit(T paramT) {
/* 481 */     Validate.notNull(paramT, "element", new Object[0]);
/* 482 */     if (isAfter(paramT))
/* 483 */       return this.minimum; 
/* 484 */     if (isBefore(paramT)) {
/* 485 */       return this.maximum;
/*     */     }
/* 487 */     return paramT;
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
/*     */   public String toString() {
/* 500 */     if (this.toString == null) {
/* 501 */       this.toString = "[" + this.minimum + ".." + this.maximum + "]";
/*     */     }
/* 503 */     return this.toString;
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
/*     */   public String toString(String paramString) {
/* 519 */     return String.format(paramString, new Object[] { this.minimum, this.maximum, this.comparator });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\Range.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */