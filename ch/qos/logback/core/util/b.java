/*     */ package ch.qos.logback.core.util;
/*     */ 
/*     */ import java.text.DateFormatSymbols;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class b
/*     */ {
/*  26 */   DateFormatSymbols a = DateFormatSymbols.getInstance();
/*     */   
/*     */   String a(a parama) {
/*  29 */     int i = parama.dr;
/*  30 */     char c = parama.a;
/*  31 */     switch (parama.a) {
/*     */       case 'G':
/*     */       case 'z':
/*  34 */         return ".*";
/*     */       case 'M':
/*  36 */         if (i <= 2)
/*  37 */           return p(i); 
/*  38 */         if (i == 3) {
/*  39 */           return df();
/*     */         }
/*  41 */         return de();
/*     */       case 'D':
/*     */       case 'F':
/*     */       case 'H':
/*     */       case 'K':
/*     */       case 'S':
/*     */       case 'W':
/*     */       case 'd':
/*     */       case 'h':
/*     */       case 'k':
/*     */       case 'm':
/*     */       case 's':
/*     */       case 'w':
/*     */       case 'y':
/*  55 */         return p(i);
/*     */       case 'E':
/*  57 */         if (i >= 4) {
/*  58 */           return dc();
/*     */         }
/*  60 */         return dd();
/*     */       
/*     */       case 'a':
/*  63 */         return db();
/*     */       case 'Z':
/*  65 */         return "(\\+|-)\\d{4}";
/*     */       case '.':
/*  67 */         return "\\.";
/*     */       case '\\':
/*  69 */         throw new IllegalStateException("Forward slashes are not allowed");
/*     */       case '\'':
/*  71 */         if (i == 1) {
/*  72 */           return "";
/*     */         }
/*  74 */         throw new IllegalStateException("Too many single quotes");
/*     */     } 
/*  76 */     if (i == 1) {
/*  77 */       return "" + c;
/*     */     }
/*  79 */     return c + "{" + i + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String p(int paramInt) {
/*  85 */     return "\\d{" + paramInt + "}";
/*     */   }
/*     */   
/*     */   private String db() {
/*  89 */     return a(this.a.getAmPmStrings());
/*     */   }
/*     */   
/*     */   private String dc() {
/*  93 */     return a(this.a.getWeekdays());
/*     */   }
/*     */   
/*     */   private String dd() {
/*  97 */     return a(this.a.getShortWeekdays());
/*     */   }
/*     */   
/*     */   private String de() {
/* 101 */     return a(this.a.getMonths());
/*     */   }
/*     */   
/*     */   String df() {
/* 105 */     return a(this.a.getShortMonths());
/*     */   }
/*     */   
/*     */   private String a(String[] paramArrayOfString) {
/* 109 */     int[] arrayOfInt = a(paramArrayOfString);
/* 110 */     return ".{" + arrayOfInt[0] + "," + arrayOfInt[1] + "}";
/*     */   }
/*     */   
/*     */   static int[] a(String[] paramArrayOfString) {
/* 114 */     int i = Integer.MAX_VALUE;
/* 115 */     int j = 0;
/* 116 */     for (String str : paramArrayOfString) {
/* 117 */       int k = str.length();
/*     */       
/* 119 */       if (k != 0) {
/*     */         
/* 121 */         i = Math.min(i, k);
/* 122 */         j = Math.max(j, k);
/*     */       } 
/* 124 */     }  return new int[] { i, j };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */