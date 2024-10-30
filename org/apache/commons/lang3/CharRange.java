/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
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
/*     */ final class CharRange
/*     */   implements Serializable, Iterable<Character>
/*     */ {
/*     */   private static final long serialVersionUID = 8270183163158333422L;
/*     */   private final char start;
/*     */   private final char end;
/*     */   private final boolean negated;
/*     */   private transient String iToString;
/*     */   
/*     */   private CharRange(char paramChar1, char paramChar2, boolean paramBoolean) {
/*  68 */     if (paramChar1 > paramChar2) {
/*  69 */       char c = paramChar1;
/*  70 */       paramChar1 = paramChar2;
/*  71 */       paramChar2 = c;
/*     */     } 
/*     */     
/*  74 */     this.start = paramChar1;
/*  75 */     this.end = paramChar2;
/*  76 */     this.negated = paramBoolean;
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
/*     */   public static CharRange is(char paramChar) {
/*  88 */     return new CharRange(paramChar, paramChar, false);
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
/*     */   public static CharRange isNot(char paramChar) {
/* 100 */     return new CharRange(paramChar, paramChar, true);
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
/*     */   public static CharRange isIn(char paramChar1, char paramChar2) {
/* 113 */     return new CharRange(paramChar1, paramChar2, false);
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
/*     */   public static CharRange isNotIn(char paramChar1, char paramChar2) {
/* 126 */     return new CharRange(paramChar1, paramChar2, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getStart() {
/* 137 */     return this.start;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getEnd() {
/* 146 */     return this.end;
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
/*     */   public boolean isNegated() {
/* 158 */     return this.negated;
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
/*     */   public boolean contains(char paramChar) {
/* 170 */     return (((paramChar >= this.start && paramChar <= this.end)) != this.negated);
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
/*     */   public boolean contains(CharRange paramCharRange) {
/* 182 */     Validate.notNull(paramCharRange, "The Range must not be null", new Object[0]);
/* 183 */     if (this.negated) {
/* 184 */       if (paramCharRange.negated) {
/* 185 */         return (this.start >= paramCharRange.start && this.end <= paramCharRange.end);
/*     */       }
/* 187 */       return (paramCharRange.end < this.start || paramCharRange.start > this.end);
/*     */     } 
/* 189 */     if (paramCharRange.negated) {
/* 190 */       return (this.start == '\000' && this.end == Character.MAX_VALUE);
/*     */     }
/* 192 */     return (this.start <= paramCharRange.start && this.end >= paramCharRange.end);
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
/*     */   public boolean equals(Object paramObject) {
/* 206 */     if (paramObject == this) {
/* 207 */       return true;
/*     */     }
/* 209 */     if (!(paramObject instanceof CharRange)) {
/* 210 */       return false;
/*     */     }
/* 212 */     CharRange charRange = (CharRange)paramObject;
/* 213 */     return (this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 223 */     return 83 + this.start + 7 * this.end + (this.negated ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 233 */     if (this.iToString == null) {
/* 234 */       StringBuilder stringBuilder = new StringBuilder(4);
/* 235 */       if (isNegated()) {
/* 236 */         stringBuilder.append('^');
/*     */       }
/* 238 */       stringBuilder.append(this.start);
/* 239 */       if (this.start != this.end) {
/* 240 */         stringBuilder.append('-');
/* 241 */         stringBuilder.append(this.end);
/*     */       } 
/* 243 */       this.iToString = stringBuilder.toString();
/*     */     } 
/* 245 */     return this.iToString;
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
/*     */   public Iterator<Character> iterator() {
/* 259 */     return new CharacterIterator(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class CharacterIterator
/*     */     implements Iterator<Character>
/*     */   {
/*     */     private char current;
/*     */ 
/*     */     
/*     */     private final CharRange range;
/*     */ 
/*     */     
/*     */     private boolean hasNext;
/*     */ 
/*     */ 
/*     */     
/*     */     private CharacterIterator(CharRange param1CharRange) {
/* 279 */       this.range = param1CharRange;
/* 280 */       this.hasNext = true;
/*     */       
/* 282 */       if (this.range.negated) {
/* 283 */         if (this.range.start == '\000') {
/* 284 */           if (this.range.end == Character.MAX_VALUE) {
/*     */             
/* 286 */             this.hasNext = false;
/*     */           } else {
/* 288 */             this.current = (char)(this.range.end + 1);
/*     */           } 
/*     */         } else {
/* 291 */           this.current = Character.MIN_VALUE;
/*     */         } 
/*     */       } else {
/* 294 */         this.current = this.range.start;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void prepareNext() {
/* 302 */       if (this.range.negated) {
/* 303 */         if (this.current == Character.MAX_VALUE) {
/* 304 */           this.hasNext = false;
/* 305 */         } else if (this.current + 1 == this.range.start) {
/* 306 */           if (this.range.end == Character.MAX_VALUE) {
/* 307 */             this.hasNext = false;
/*     */           } else {
/* 309 */             this.current = (char)(this.range.end + 1);
/*     */           } 
/*     */         } else {
/* 312 */           this.current = (char)(this.current + 1);
/*     */         } 
/* 314 */       } else if (this.current < this.range.end) {
/* 315 */         this.current = (char)(this.current + 1);
/*     */       } else {
/* 317 */         this.hasNext = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 328 */       return this.hasNext;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Character next() {
/* 338 */       if (!this.hasNext) {
/* 339 */         throw new NoSuchElementException();
/*     */       }
/* 341 */       char c = this.current;
/* 342 */       prepareNext();
/* 343 */       return Character.valueOf(c);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 354 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\CharRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */