/*     */ package org.apache.xmlbeans.impl.regex;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class RangeToken
/*     */   extends Token
/*     */   implements Serializable
/*     */ {
/*     */   int[] ranges;
/*     */   boolean sorted;
/*     */   boolean compacted;
/*  26 */   RangeToken icaseCache = null;
/*  27 */   int[] map = null; int nonMapIndex;
/*     */   private static final int MAPSIZE = 256;
/*     */   
/*     */   RangeToken(int paramInt) {
/*  31 */     super(paramInt);
/*  32 */     setSorted(false);
/*     */   }
/*     */   
/*     */   protected void addRange(int paramInt1, int paramInt2) {
/*     */     int i, j;
/*  37 */     this.icaseCache = null;
/*     */ 
/*     */     
/*  40 */     if (paramInt1 <= paramInt2) {
/*  41 */       i = paramInt1;
/*  42 */       j = paramInt2;
/*     */     } else {
/*  44 */       i = paramInt2;
/*  45 */       j = paramInt1;
/*     */     } 
/*     */     
/*  48 */     int k = 0;
/*  49 */     if (this.ranges == null) {
/*  50 */       this.ranges = new int[2];
/*  51 */       this.ranges[0] = i;
/*  52 */       this.ranges[1] = j;
/*  53 */       setSorted(true);
/*     */     } else {
/*  55 */       k = this.ranges.length;
/*  56 */       if (this.ranges[k - 1] + 1 == i) {
/*  57 */         this.ranges[k - 1] = j;
/*     */         return;
/*     */       } 
/*  60 */       int[] arrayOfInt = new int[k + 2];
/*  61 */       System.arraycopy(this.ranges, 0, arrayOfInt, 0, k);
/*  62 */       this.ranges = arrayOfInt;
/*  63 */       if (this.ranges[k - 1] >= i)
/*  64 */         setSorted(false); 
/*  65 */       this.ranges[k++] = i;
/*  66 */       this.ranges[k] = j;
/*  67 */       if (!this.sorted)
/*  68 */         sortRanges(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private final boolean isSorted() {
/*  73 */     return this.sorted;
/*     */   }
/*     */   private final void setSorted(boolean paramBoolean) {
/*  76 */     this.sorted = paramBoolean;
/*  77 */     if (!paramBoolean) this.compacted = false; 
/*     */   }
/*     */   private final boolean isCompacted() {
/*  80 */     return this.compacted;
/*     */   }
/*     */   private final void setCompacted() {
/*  83 */     this.compacted = true;
/*     */   }
/*     */   
/*     */   protected void sortRanges() {
/*  87 */     if (isSorted())
/*     */       return; 
/*  89 */     if (this.ranges == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     for (int i = this.ranges.length - 4; i >= 0; i -= 2) {
/*  97 */       for (byte b = 0; b <= i; b += 2) {
/*  98 */         if (this.ranges[b] > this.ranges[b + 2] || (this.ranges[b] == this.ranges[b + 2] && this.ranges[b + 1] > this.ranges[b + 3])) {
/*     */ 
/*     */           
/* 101 */           int j = this.ranges[b + 2];
/* 102 */           this.ranges[b + 2] = this.ranges[b];
/* 103 */           this.ranges[b] = j;
/* 104 */           j = this.ranges[b + 3];
/* 105 */           this.ranges[b + 3] = this.ranges[b + 1];
/* 106 */           this.ranges[b + 1] = j;
/*     */         } 
/*     */       } 
/*     */     } 
/* 110 */     setSorted(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void compactRanges() {
/* 117 */     boolean bool = false;
/* 118 */     if (this.ranges == null || this.ranges.length <= 2)
/*     */       return; 
/* 120 */     if (isCompacted())
/*     */       return; 
/* 122 */     byte b1 = 0;
/* 123 */     byte b2 = 0;
/*     */     
/* 125 */     while (b2 < this.ranges.length) {
/* 126 */       if (b1 != b2) {
/* 127 */         this.ranges[b1] = this.ranges[b2++];
/* 128 */         this.ranges[b1 + 1] = this.ranges[b2++];
/*     */       } else {
/* 130 */         b2 += 2;
/* 131 */       }  int i = this.ranges[b1 + 1];
/* 132 */       while (b2 < this.ranges.length && 
/* 133 */         i + 1 >= this.ranges[b2]) {
/*     */         
/* 135 */         if (i + 1 == this.ranges[b2]) {
/* 136 */           if (bool) {
/* 137 */             System.err.println("Token#compactRanges(): Compaction: [" + this.ranges[b1] + ", " + this.ranges[b1 + 1] + "], [" + this.ranges[b2] + ", " + this.ranges[b2 + 1] + "] -> [" + this.ranges[b1] + ", " + this.ranges[b2 + 1] + "]");
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 144 */           this.ranges[b1 + 1] = this.ranges[b2 + 1];
/* 145 */           i = this.ranges[b1 + 1];
/* 146 */           b2 += 2; continue;
/* 147 */         }  if (i >= this.ranges[b2 + 1]) {
/* 148 */           if (bool) {
/* 149 */             System.err.println("Token#compactRanges(): Compaction: [" + this.ranges[b1] + ", " + this.ranges[b1 + 1] + "], [" + this.ranges[b2] + ", " + this.ranges[b2 + 1] + "] -> [" + this.ranges[b1] + ", " + this.ranges[b1 + 1] + "]");
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 156 */           b2 += 2; continue;
/* 157 */         }  if (i < this.ranges[b2 + 1]) {
/* 158 */           if (bool) {
/* 159 */             System.err.println("Token#compactRanges(): Compaction: [" + this.ranges[b1] + ", " + this.ranges[b1 + 1] + "], [" + this.ranges[b2] + ", " + this.ranges[b2 + 1] + "] -> [" + this.ranges[b1] + ", " + this.ranges[b2 + 1] + "]");
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 166 */           this.ranges[b1 + 1] = this.ranges[b2 + 1];
/* 167 */           i = this.ranges[b1 + 1];
/* 168 */           b2 += 2; continue;
/*     */         } 
/* 170 */         throw new RuntimeException("Token#compactRanges(): Internel Error: [" + this.ranges[b1] + "," + this.ranges[b1 + 1] + "] [" + this.ranges[b2] + "," + this.ranges[b2 + 1] + "]");
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       b1 += 2;
/*     */     } 
/*     */     
/* 180 */     if (b1 != this.ranges.length) {
/* 181 */       int[] arrayOfInt = new int[b1];
/* 182 */       System.arraycopy(this.ranges, 0, arrayOfInt, 0, b1);
/* 183 */       this.ranges = arrayOfInt;
/*     */     } 
/* 185 */     setCompacted();
/*     */   }
/*     */   
/*     */   protected void mergeRanges(Token paramToken) {
/* 189 */     RangeToken rangeToken = (RangeToken)paramToken;
/* 190 */     sortRanges();
/* 191 */     rangeToken.sortRanges();
/* 192 */     if (rangeToken.ranges == null)
/*     */       return; 
/* 194 */     this.icaseCache = null;
/* 195 */     setSorted(true);
/* 196 */     if (this.ranges == null) {
/* 197 */       this.ranges = new int[rangeToken.ranges.length];
/* 198 */       System.arraycopy(rangeToken.ranges, 0, this.ranges, 0, rangeToken.ranges.length);
/*     */       return;
/*     */     } 
/* 201 */     int[] arrayOfInt = new int[this.ranges.length + rangeToken.ranges.length];
/* 202 */     for (byte b1 = 0, b2 = 0, b3 = 0; b1 < this.ranges.length || b2 < rangeToken.ranges.length; ) {
/* 203 */       if (b1 >= this.ranges.length) {
/* 204 */         arrayOfInt[b3++] = rangeToken.ranges[b2++];
/* 205 */         arrayOfInt[b3++] = rangeToken.ranges[b2++]; continue;
/* 206 */       }  if (b2 >= rangeToken.ranges.length) {
/* 207 */         arrayOfInt[b3++] = this.ranges[b1++];
/* 208 */         arrayOfInt[b3++] = this.ranges[b1++]; continue;
/* 209 */       }  if (rangeToken.ranges[b2] < this.ranges[b1] || (rangeToken.ranges[b2] == this.ranges[b1] && rangeToken.ranges[b2 + 1] < this.ranges[b1 + 1])) {
/*     */         
/* 211 */         arrayOfInt[b3++] = rangeToken.ranges[b2++];
/* 212 */         arrayOfInt[b3++] = rangeToken.ranges[b2++]; continue;
/*     */       } 
/* 214 */       arrayOfInt[b3++] = this.ranges[b1++];
/* 215 */       arrayOfInt[b3++] = this.ranges[b1++];
/*     */     } 
/*     */     
/* 218 */     this.ranges = arrayOfInt;
/*     */   }
/*     */   
/*     */   protected void subtractRanges(Token paramToken) {
/* 222 */     if (paramToken.type == 5) {
/* 223 */       intersectRanges(paramToken);
/*     */       return;
/*     */     } 
/* 226 */     RangeToken rangeToken = (RangeToken)paramToken;
/* 227 */     if (rangeToken.ranges == null || this.ranges == null)
/*     */       return; 
/* 229 */     this.icaseCache = null;
/* 230 */     sortRanges();
/* 231 */     compactRanges();
/* 232 */     rangeToken.sortRanges();
/* 233 */     rangeToken.compactRanges();
/*     */ 
/*     */ 
/*     */     
/* 237 */     int[] arrayOfInt = new int[this.ranges.length + rangeToken.ranges.length];
/* 238 */     byte b1 = 0, b2 = 0, b3 = 0;
/* 239 */     while (b2 < this.ranges.length && b3 < rangeToken.ranges.length) {
/* 240 */       int i = this.ranges[b2];
/* 241 */       int j = this.ranges[b2 + 1];
/* 242 */       int k = rangeToken.ranges[b3];
/* 243 */       int m = rangeToken.ranges[b3 + 1];
/* 244 */       if (j < k) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 249 */         arrayOfInt[b1++] = this.ranges[b2++];
/* 250 */         arrayOfInt[b1++] = this.ranges[b2++]; continue;
/* 251 */       }  if (j >= k && i <= m) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 258 */         if (k <= i && j <= m) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 263 */           b2 += 2; continue;
/* 264 */         }  if (k <= i) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 269 */           this.ranges[b2] = m + 1;
/* 270 */           b3 += 2; continue;
/* 271 */         }  if (j <= m) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 276 */           arrayOfInt[b1++] = i;
/* 277 */           arrayOfInt[b1++] = k - 1;
/* 278 */           b2 += 2;
/*     */ 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 284 */         arrayOfInt[b1++] = i;
/* 285 */         arrayOfInt[b1++] = k - 1;
/* 286 */         this.ranges[b2] = m + 1;
/* 287 */         b3 += 2; continue;
/*     */       } 
/* 289 */       if (m < i) {
/*     */ 
/*     */ 
/*     */         
/* 293 */         b3 += 2; continue;
/*     */       } 
/* 295 */       throw new RuntimeException("Token#subtractRanges(): Internal Error: [" + this.ranges[b2] + "," + this.ranges[b2 + 1] + "] - [" + rangeToken.ranges[b3] + "," + rangeToken.ranges[b3 + 1] + "]");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 302 */     while (b2 < this.ranges.length) {
/* 303 */       arrayOfInt[b1++] = this.ranges[b2++];
/* 304 */       arrayOfInt[b1++] = this.ranges[b2++];
/*     */     } 
/* 306 */     this.ranges = new int[b1];
/* 307 */     System.arraycopy(arrayOfInt, 0, this.ranges, 0, b1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void intersectRanges(Token paramToken) {
/* 315 */     RangeToken rangeToken = (RangeToken)paramToken;
/* 316 */     if (rangeToken.ranges == null || this.ranges == null)
/*     */       return; 
/* 318 */     this.icaseCache = null;
/* 319 */     sortRanges();
/* 320 */     compactRanges();
/* 321 */     rangeToken.sortRanges();
/* 322 */     rangeToken.compactRanges();
/*     */     
/* 324 */     int[] arrayOfInt = new int[this.ranges.length + rangeToken.ranges.length];
/* 325 */     byte b1 = 0, b2 = 0, b3 = 0;
/* 326 */     while (b2 < this.ranges.length && b3 < rangeToken.ranges.length) {
/* 327 */       int i = this.ranges[b2];
/* 328 */       int j = this.ranges[b2 + 1];
/* 329 */       int k = rangeToken.ranges[b3];
/* 330 */       int m = rangeToken.ranges[b3 + 1];
/* 331 */       if (j < k) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 336 */         b2 += 2; continue;
/* 337 */       }  if (j >= k && i <= m) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 344 */         if (k <= k && j <= m) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 349 */           arrayOfInt[b1++] = i;
/* 350 */           arrayOfInt[b1++] = j;
/* 351 */           b2 += 2; continue;
/* 352 */         }  if (k <= i) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 357 */           arrayOfInt[b1++] = i;
/* 358 */           arrayOfInt[b1++] = m;
/* 359 */           this.ranges[b2] = m + 1;
/* 360 */           b3 += 2; continue;
/* 361 */         }  if (j <= m) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 366 */           arrayOfInt[b1++] = k;
/* 367 */           arrayOfInt[b1++] = j;
/* 368 */           b2 += 2;
/*     */ 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 374 */         arrayOfInt[b1++] = k;
/* 375 */         arrayOfInt[b1++] = m;
/* 376 */         this.ranges[b2] = m + 1; continue;
/*     */       } 
/* 378 */       if (m < i) {
/*     */ 
/*     */ 
/*     */         
/* 382 */         b3 += 2; continue;
/*     */       } 
/* 384 */       throw new RuntimeException("Token#intersectRanges(): Internal Error: [" + this.ranges[b2] + "," + this.ranges[b2 + 1] + "] & [" + rangeToken.ranges[b3] + "," + rangeToken.ranges[b3 + 1] + "]");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 392 */     while (b2 < this.ranges.length) {
/* 393 */       arrayOfInt[b1++] = this.ranges[b2++];
/* 394 */       arrayOfInt[b1++] = this.ranges[b2++];
/*     */     } 
/* 396 */     this.ranges = new int[b1];
/* 397 */     System.arraycopy(arrayOfInt, 0, this.ranges, 0, b1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Token complementRanges(Token paramToken) {
/* 406 */     if (paramToken.type != 4 && paramToken.type != 5)
/* 407 */       throw new IllegalArgumentException("Token#complementRanges(): must be RANGE: " + paramToken.type); 
/* 408 */     RangeToken rangeToken1 = (RangeToken)paramToken;
/* 409 */     rangeToken1.sortRanges();
/* 410 */     rangeToken1.compactRanges();
/* 411 */     int i = rangeToken1.ranges.length + 2;
/* 412 */     if (rangeToken1.ranges[0] == 0)
/* 413 */       i -= 2; 
/* 414 */     int j = rangeToken1.ranges[rangeToken1.ranges.length - 1];
/* 415 */     if (j == 1114111)
/* 416 */       i -= 2; 
/* 417 */     RangeToken rangeToken2 = Token.createRange();
/* 418 */     rangeToken2.ranges = new int[i];
/* 419 */     byte b1 = 0;
/* 420 */     if (rangeToken1.ranges[0] > 0) {
/* 421 */       rangeToken2.ranges[b1++] = 0;
/* 422 */       rangeToken2.ranges[b1++] = rangeToken1.ranges[0] - 1;
/*     */     } 
/* 424 */     for (byte b2 = 1; b2 < rangeToken1.ranges.length - 2; b2 += 2) {
/* 425 */       rangeToken2.ranges[b1++] = rangeToken1.ranges[b2] + 1;
/* 426 */       rangeToken2.ranges[b1++] = rangeToken1.ranges[b2 + 1] - 1;
/*     */     } 
/* 428 */     if (j != 1114111) {
/* 429 */       rangeToken2.ranges[b1++] = j + 1;
/* 430 */       rangeToken2.ranges[b1] = 1114111;
/*     */     } 
/* 432 */     rangeToken2.setCompacted();
/* 433 */     return rangeToken2;
/*     */   }
/*     */   
/*     */   synchronized RangeToken getCaseInsensitiveToken() {
/* 437 */     if (this.icaseCache != null) {
/* 438 */       return this.icaseCache;
/*     */     }
/* 440 */     RangeToken rangeToken1 = (this.type == 4) ? Token.createRange() : Token.createNRange();
/* 441 */     for (byte b1 = 0; b1 < this.ranges.length; b1 += 2) {
/* 442 */       for (int i = this.ranges[b1]; i <= this.ranges[b1 + 1]; i++) {
/* 443 */         if (i > 65535) {
/* 444 */           rangeToken1.addRange(i, i);
/*     */         } else {
/* 446 */           char c = Character.toUpperCase((char)i);
/* 447 */           rangeToken1.addRange(c, c);
/*     */         } 
/*     */       } 
/*     */     } 
/* 451 */     RangeToken rangeToken2 = (this.type == 4) ? Token.createRange() : Token.createNRange();
/* 452 */     for (byte b2 = 0; b2 < rangeToken1.ranges.length; b2 += 2) {
/* 453 */       for (int i = rangeToken1.ranges[b2]; i <= rangeToken1.ranges[b2 + 1]; i++) {
/* 454 */         if (i > 65535) {
/* 455 */           rangeToken2.addRange(i, i);
/*     */         } else {
/* 457 */           char c = Character.toUpperCase((char)i);
/* 458 */           rangeToken2.addRange(c, c);
/*     */         } 
/*     */       } 
/*     */     } 
/* 462 */     rangeToken2.mergeRanges(rangeToken1);
/* 463 */     rangeToken2.mergeRanges(this);
/* 464 */     rangeToken2.compactRanges();
/*     */     
/* 466 */     this.icaseCache = rangeToken2;
/* 467 */     return rangeToken2;
/*     */   }
/*     */   
/*     */   void dumpRanges() {
/* 471 */     System.err.print("RANGE: ");
/* 472 */     if (this.ranges == null)
/* 473 */       System.err.println(" NULL"); 
/* 474 */     for (byte b = 0; b < this.ranges.length; b += 2) {
/* 475 */       System.err.print("[" + this.ranges[b] + "," + this.ranges[b + 1] + "] ");
/*     */     }
/* 477 */     System.err.println("");
/*     */   }
/*     */   boolean match(int paramInt) {
/*     */     boolean bool;
/* 481 */     if (this.map == null) createMap();
/*     */     
/* 483 */     if (this.type == 4) {
/* 484 */       if (paramInt < 256)
/* 485 */         return ((this.map[paramInt / 32] & 1 << (paramInt & 0x1F)) != 0); 
/* 486 */       bool = false;
/* 487 */       for (int i = this.nonMapIndex; i < this.ranges.length; i += 2) {
/* 488 */         if (this.ranges[i] <= paramInt && paramInt <= this.ranges[i + 1])
/* 489 */           return true; 
/*     */       } 
/*     */     } else {
/* 492 */       if (paramInt < 256)
/* 493 */         return ((this.map[paramInt / 32] & 1 << (paramInt & 0x1F)) == 0); 
/* 494 */       bool = true;
/* 495 */       for (int i = this.nonMapIndex; i < this.ranges.length; i += 2) {
/* 496 */         if (this.ranges[i] <= paramInt && paramInt <= this.ranges[i + 1])
/* 497 */           return false; 
/*     */       } 
/*     */     } 
/* 500 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   private void createMap() {
/* 505 */     byte b1 = 8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 511 */     int[] arrayOfInt = new int[b1];
/* 512 */     int i = this.ranges.length; byte b2;
/* 513 */     for (b2 = 0; b2 < b1; ) { arrayOfInt[b2] = 0; b2++; }
/* 514 */      for (b2 = 0; b2 < this.ranges.length; b2 += 2) {
/* 515 */       int j = this.ranges[b2];
/* 516 */       int k = this.ranges[b2 + 1];
/* 517 */       if (j < 256) {
/* 518 */         for (int m = j; m <= k && m < 256; m++)
/* 519 */           arrayOfInt[m / 32] = arrayOfInt[m / 32] | 1 << (m & 0x1F); 
/*     */       } else {
/* 521 */         i = b2;
/*     */         break;
/*     */       } 
/* 524 */       if (k >= 256) {
/* 525 */         i = b2;
/*     */         break;
/*     */       } 
/*     */     } 
/* 529 */     this.nonMapIndex = i;
/* 530 */     this.map = arrayOfInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString(int paramInt) {
/*     */     String str;
/* 536 */     if (this.type == 4) {
/* 537 */       if (this == Token.token_dot) {
/* 538 */         str = ".";
/* 539 */       } else if (this == Token.token_0to9) {
/* 540 */         str = "\\d";
/* 541 */       } else if (this == Token.token_wordchars) {
/* 542 */         str = "\\w";
/* 543 */       } else if (this == Token.token_spaces) {
/* 544 */         str = "\\s";
/*     */       } else {
/* 546 */         StringBuffer stringBuffer = new StringBuffer();
/* 547 */         stringBuffer.append("[");
/* 548 */         for (byte b = 0; b < this.ranges.length; b += 2) {
/* 549 */           if ((paramInt & 0x400) != 0 && b > 0) stringBuffer.append(","); 
/* 550 */           if (this.ranges[b] == this.ranges[b + 1]) {
/* 551 */             stringBuffer.append(escapeCharInCharClass(this.ranges[b]));
/*     */           } else {
/* 553 */             stringBuffer.append(escapeCharInCharClass(this.ranges[b]));
/* 554 */             stringBuffer.append('-');
/* 555 */             stringBuffer.append(escapeCharInCharClass(this.ranges[b + 1]));
/*     */           } 
/*     */         } 
/* 558 */         stringBuffer.append("]");
/* 559 */         str = stringBuffer.toString();
/*     */       }
/*     */     
/* 562 */     } else if (this == Token.token_not_0to9) {
/* 563 */       str = "\\D";
/* 564 */     } else if (this == Token.token_not_wordchars) {
/* 565 */       str = "\\W";
/* 566 */     } else if (this == Token.token_not_spaces) {
/* 567 */       str = "\\S";
/*     */     } else {
/* 569 */       StringBuffer stringBuffer = new StringBuffer();
/* 570 */       stringBuffer.append("[^");
/* 571 */       for (byte b = 0; b < this.ranges.length; b += 2) {
/* 572 */         if ((paramInt & 0x400) != 0 && b > 0) stringBuffer.append(","); 
/* 573 */         if (this.ranges[b] == this.ranges[b + 1]) {
/* 574 */           stringBuffer.append(escapeCharInCharClass(this.ranges[b]));
/*     */         } else {
/* 576 */           stringBuffer.append(escapeCharInCharClass(this.ranges[b]));
/* 577 */           stringBuffer.append('-');
/* 578 */           stringBuffer.append(escapeCharInCharClass(this.ranges[b + 1]));
/*     */         } 
/*     */       } 
/* 581 */       stringBuffer.append("]");
/* 582 */       str = stringBuffer.toString();
/*     */     } 
/*     */     
/* 585 */     return str;
/*     */   }
/*     */   
/*     */   private static String escapeCharInCharClass(int paramInt) {
/*     */     String str;
/* 590 */     switch (paramInt) { case 44: case 45: case 91: case 92:
/*     */       case 93:
/*     */       case 94:
/* 593 */         str = "\\" + (char)paramInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 611 */         return str;case 12: str = "\\f"; return str;case 10: str = "\\n"; return str;case 13: str = "\\r"; return str;case 9: str = "\\t"; return str;case 27: str = "\\e"; return str; }  if (paramInt < 32) { String str1 = "0" + Integer.toHexString(paramInt); str = "\\x" + str1.substring(str1.length() - 2, str1.length()); } else if (paramInt >= 65536) { String str1 = "0" + Integer.toHexString(paramInt); str = "\\v" + str1.substring(str1.length() - 6, str1.length()); } else { str = "" + (char)paramInt; }  return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\regex\RangeToken.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */