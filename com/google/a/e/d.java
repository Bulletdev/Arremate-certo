/*     */ package com.google.a.e;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @b
/*     */ public abstract class d
/*     */   extends f
/*     */ {
/*     */   private static final int fl = 2;
/*     */   
/*     */   public String escape(String paramString) {
/*  57 */     D.checkNotNull(paramString);
/*     */     
/*  59 */     int i = paramString.length();
/*  60 */     for (byte b = 0; b < i; b++) {
/*  61 */       if (a(paramString.charAt(b)) != null) {
/*  62 */         return h(paramString, b);
/*     */       }
/*     */     } 
/*  65 */     return paramString;
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
/*     */   protected abstract char[] a(char paramChar);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String h(String paramString, int paramInt) {
/*  97 */     int i = paramString.length();
/*     */ 
/*     */     
/* 100 */     char[] arrayOfChar = h.c();
/* 101 */     int j = arrayOfChar.length;
/* 102 */     int k = 0;
/* 103 */     int m = 0;
/*     */ 
/*     */ 
/*     */     
/* 107 */     for (; paramInt < i; paramInt++) {
/*     */ 
/*     */       
/* 110 */       char[] arrayOfChar1 = a(paramString.charAt(paramInt));
/*     */ 
/*     */       
/* 113 */       if (arrayOfChar1 != null) {
/*     */ 
/*     */ 
/*     */         
/* 117 */         int i1 = arrayOfChar1.length;
/* 118 */         int i2 = paramInt - m;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 123 */         int i3 = k + i2 + i1;
/* 124 */         if (j < i3) {
/* 125 */           j = i3 + 2 * (i - paramInt);
/* 126 */           arrayOfChar = a(arrayOfChar, k, j);
/*     */         } 
/*     */ 
/*     */         
/* 130 */         if (i2 > 0) {
/* 131 */           paramString.getChars(m, paramInt, arrayOfChar, k);
/* 132 */           k += i2;
/*     */         } 
/*     */ 
/*     */         
/* 136 */         if (i1 > 0) {
/* 137 */           System.arraycopy(arrayOfChar1, 0, arrayOfChar, k, i1);
/* 138 */           k += i1;
/*     */         } 
/* 140 */         m = paramInt + 1;
/*     */       } 
/*     */     } 
/*     */     
/* 144 */     int n = i - m;
/* 145 */     if (n > 0) {
/* 146 */       int i1 = k + n;
/* 147 */       if (j < i1)
/*     */       {
/*     */         
/* 150 */         arrayOfChar = a(arrayOfChar, k, i1);
/*     */       }
/* 152 */       paramString.getChars(m, i, arrayOfChar, k);
/* 153 */       k = i1;
/*     */     } 
/* 155 */     return new String(arrayOfChar, 0, k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static char[] a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 163 */     if (paramInt2 < 0) {
/* 164 */       throw new AssertionError("Cannot increase internal buffer any further");
/*     */     }
/* 166 */     char[] arrayOfChar = new char[paramInt2];
/* 167 */     if (paramInt1 > 0) {
/* 168 */       System.arraycopy(paramArrayOfchar, 0, arrayOfChar, 0, paramInt1);
/*     */     }
/* 170 */     return arrayOfChar;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\e\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */