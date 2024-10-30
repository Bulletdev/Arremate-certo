/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GDuration
/*     */   implements Serializable, GDurationSpecification
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int _sign;
/*     */   private int _CY;
/*     */   private int _M;
/*     */   private int _D;
/*     */   private int _h;
/*     */   private int _m;
/*     */   private int _s;
/*     */   private BigDecimal _fs;
/*     */   private static final int SEEN_NOTHING = 0;
/*     */   private static final int SEEN_YEAR = 1;
/*     */   private static final int SEEN_MONTH = 2;
/*     */   private static final int SEEN_DAY = 3;
/*     */   private static final int SEEN_HOUR = 4;
/*     */   private static final int SEEN_MINUTE = 5;
/*     */   private static final int SEEN_SECOND = 6;
/*     */   
/*     */   public GDuration() {
/*  49 */     this._sign = 1;
/*  50 */     this._fs = GDate._zero;
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
/*     */   public GDuration(CharSequence paramCharSequence) {
/*  74 */     int i = paramCharSequence.length();
/*  75 */     byte b1 = 0;
/*  76 */     while (i > 0 && GDate.isSpace(paramCharSequence.charAt(i - 1)))
/*  77 */       i--; 
/*  78 */     while (b1 < i && GDate.isSpace(paramCharSequence.charAt(b1))) {
/*  79 */       b1++;
/*     */     }
/*  81 */     this._sign = 1;
/*  82 */     boolean bool = false;
/*     */     
/*  84 */     if (b1 < i && paramCharSequence.charAt(b1) == '-') {
/*     */       
/*  86 */       this._sign = -1;
/*  87 */       b1++;
/*     */     } 
/*     */     
/*  90 */     if (b1 >= i || paramCharSequence.charAt(b1) != 'P') {
/*  91 */       throw new IllegalArgumentException("duration must begin with P");
/*     */     }
/*  93 */     b1++;
/*     */     
/*  95 */     byte b2 = 0;
/*  96 */     this._fs = GDate._zero;
/*     */     
/*  98 */     for (; b1 < i; b1++) {
/*     */       
/* 100 */       char c = paramCharSequence.charAt(b1);
/* 101 */       if (c == 'T') {
/*     */         
/* 103 */         if (bool)
/* 104 */           throw new IllegalArgumentException("duration must have no more than one T'"); 
/* 105 */         if (b2 > 3)
/* 106 */           throw new IllegalArgumentException("T in duration must precede time fields"); 
/* 107 */         b2 = 3;
/* 108 */         bool = true;
/* 109 */         b1++;
/* 110 */         if (b1 >= i)
/* 111 */           throw new IllegalArgumentException("illegal duration"); 
/* 112 */         c = paramCharSequence.charAt(b1);
/*     */       } 
/* 114 */       if (!GDate.isDigit(c))
/* 115 */         throw new IllegalArgumentException("illegal duration at char[" + b1 + "]: '" + c + "'"); 
/* 116 */       int j = GDate.digitVal(c);
/*     */       
/*     */       while (true) {
/* 119 */         b1++;
/* 120 */         c = (b1 < i) ? paramCharSequence.charAt(b1) : Character.MIN_VALUE;
/* 121 */         if (!GDate.isDigit(c))
/*     */           break; 
/* 123 */         j = j * 10 + GDate.digitVal(c);
/*     */       } 
/* 125 */       if (c == '.') {
/*     */         
/* 127 */         byte b = b1; do {
/* 128 */           b++;
/* 129 */         } while (b < i && GDate.isDigit(c = paramCharSequence.charAt(b)));
/* 130 */         this._fs = new BigDecimal(paramCharSequence.subSequence(b1, b).toString());
/* 131 */         if (b >= i || c != 'S')
/* 132 */           throw new IllegalArgumentException("illegal duration"); 
/* 133 */         b1 = b;
/*     */       } 
/*     */       
/* 136 */       switch (b2) {
/*     */         
/*     */         case 0:
/* 139 */           if (c == 'Y') {
/*     */             
/* 141 */             b2 = 1;
/* 142 */             this._CY = j;
/*     */             break;
/*     */           } 
/*     */         case 1:
/* 146 */           if (c == 'M') {
/*     */             
/* 148 */             b2 = 2;
/* 149 */             this._M = j;
/*     */             break;
/*     */           } 
/*     */         case 2:
/* 153 */           if (c == 'D') {
/*     */             
/* 155 */             b2 = 3;
/* 156 */             this._D = j;
/*     */             break;
/*     */           } 
/*     */         case 3:
/* 160 */           if (c == 'H') {
/*     */             
/* 162 */             if (!bool)
/* 163 */               throw new IllegalArgumentException("time in duration must follow T"); 
/* 164 */             b2 = 4;
/* 165 */             this._h = j;
/*     */             break;
/*     */           } 
/*     */         case 4:
/* 169 */           if (c == 'M') {
/*     */             
/* 171 */             if (!bool)
/* 172 */               throw new IllegalArgumentException("time in duration must follow T"); 
/* 173 */             b2 = 5;
/* 174 */             this._m = j;
/*     */             break;
/*     */           } 
/*     */         case 5:
/* 178 */           if (c == 'S') {
/*     */             
/* 180 */             if (!bool)
/* 181 */               throw new IllegalArgumentException("time in duration must follow T"); 
/* 182 */             b2 = 6;
/* 183 */             this._s = j;
/*     */             break;
/*     */           } 
/*     */         default:
/* 187 */           throw new IllegalArgumentException("duration must specify Y M D T H M S in order");
/*     */       } 
/*     */     
/*     */     } 
/* 191 */     if (b2 == 0) {
/* 192 */       throw new IllegalArgumentException("duration must contain at least one number and its designator: " + paramCharSequence);
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
/*     */   public GDuration(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, BigDecimal paramBigDecimal) {
/* 212 */     if (paramInt1 != 1 && paramInt1 != -1)
/* 213 */       throw new IllegalArgumentException(); 
/* 214 */     this._sign = paramInt1;
/* 215 */     this._CY = paramInt2;
/* 216 */     this._M = paramInt3;
/* 217 */     this._D = paramInt4;
/* 218 */     this._h = paramInt5;
/* 219 */     this._m = paramInt6;
/* 220 */     this._s = paramInt7;
/* 221 */     this._fs = (paramBigDecimal == null) ? GDate._zero : paramBigDecimal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDuration(GDurationSpecification paramGDurationSpecification) {
/* 229 */     this._sign = paramGDurationSpecification.getSign();
/* 230 */     this._CY = paramGDurationSpecification.getYear();
/* 231 */     this._M = paramGDurationSpecification.getMonth();
/* 232 */     this._D = paramGDurationSpecification.getDay();
/* 233 */     this._h = paramGDurationSpecification.getHour();
/* 234 */     this._m = paramGDurationSpecification.getMinute();
/* 235 */     this._s = paramGDurationSpecification.getSecond();
/* 236 */     this._fs = paramGDurationSpecification.getFraction();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 245 */     return new GDuration(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isImmutable() {
/* 253 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSign() {
/* 261 */     return this._sign;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getYear() {
/* 267 */     return this._CY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMonth() {
/* 273 */     return this._M;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getDay() {
/* 279 */     return this._D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getHour() {
/* 285 */     return this._h;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMinute() {
/* 291 */     return this._m;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSecond() {
/* 297 */     return this._s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getFraction() {
/* 304 */     return this._fs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/* 312 */     return GDurationBuilder.isValidDuration(this);
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
/*     */   public final int compareToGDuration(GDurationSpecification paramGDurationSpecification) {
/* 328 */     return GDurationBuilder.compareDurations(this, paramGDurationSpecification);
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
/*     */   public String toString() {
/* 342 */     return GDurationBuilder.formatDuration(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDuration add(GDurationSpecification paramGDurationSpecification) {
/* 351 */     int i = this._sign * paramGDurationSpecification.getSign();
/* 352 */     return _add(paramGDurationSpecification, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDuration subtract(GDurationSpecification paramGDurationSpecification) {
/* 362 */     int i = -this._sign * paramGDurationSpecification.getSign();
/* 363 */     return _add(paramGDurationSpecification, i);
/*     */   }
/*     */ 
/*     */   
/*     */   private GDuration _add(GDurationSpecification paramGDurationSpecification, int paramInt) {
/* 368 */     GDuration gDuration = new GDuration(this);
/* 369 */     gDuration._CY += paramInt * paramGDurationSpecification.getYear();
/* 370 */     gDuration._M += paramInt * paramGDurationSpecification.getMonth();
/* 371 */     gDuration._D += paramInt * paramGDurationSpecification.getDay();
/* 372 */     gDuration._h += paramInt * paramGDurationSpecification.getHour();
/* 373 */     gDuration._m += paramInt * paramGDurationSpecification.getMinute();
/* 374 */     gDuration._s += paramInt * paramGDurationSpecification.getSecond();
/*     */     
/* 376 */     if (paramGDurationSpecification.getFraction().signum() == 0) {
/* 377 */       return gDuration;
/*     */     }
/* 379 */     if (gDuration._fs.signum() == 0 && paramInt == 1) {
/* 380 */       gDuration._fs = paramGDurationSpecification.getFraction();
/*     */     } else {
/* 382 */       gDuration._fs = (paramInt > 0) ? gDuration._fs.add(paramGDurationSpecification.getFraction()) : gDuration._fs.subtract(paramGDurationSpecification.getFraction());
/*     */     } 
/*     */     
/* 385 */     return gDuration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 394 */     if (paramObject == this)
/* 395 */       return true; 
/* 396 */     if (!(paramObject instanceof GDuration)) {
/* 397 */       return false;
/*     */     }
/* 399 */     GDuration gDuration = (GDuration)paramObject;
/* 400 */     return (this._sign == gDuration.getSign() && this._CY == gDuration.getYear() && this._M == gDuration.getMonth() && this._D == gDuration.getDay() && this._h == gDuration.getHour() && this._m == gDuration.getMinute() && this._s == gDuration.getSecond() && this._fs.equals(gDuration.getFraction()));
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
/*     */   public int hashCode() {
/* 412 */     return this._s + this._m * 67 + this._h * 3607 + this._D * 86407 + this._M * 2678407 + this._CY * 32140807 + this._sign * 11917049;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\GDuration.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */