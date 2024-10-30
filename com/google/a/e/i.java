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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class i
/*     */   extends f
/*     */ {
/*     */   private static final int fn = 32;
/*     */   
/*     */   protected abstract char[] a(int paramInt);
/*     */   
/*     */   public String escape(String paramString) {
/* 102 */     D.checkNotNull(paramString);
/* 103 */     int j = paramString.length();
/* 104 */     int k = a(paramString, 0, j);
/* 105 */     return (k == j) ? paramString : h(paramString, k);
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
/*     */   protected int a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 131 */     int j = paramInt1;
/* 132 */     while (j < paramInt2) {
/* 133 */       int k = b(paramCharSequence, j, paramInt2);
/* 134 */       if (k < 0 || a(k) != null) {
/*     */         break;
/*     */       }
/* 137 */       j += Character.isSupplementaryCodePoint(k) ? 2 : 1;
/*     */     } 
/* 139 */     return j;
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
/*     */   protected final String h(String paramString, int paramInt) {
/* 158 */     int j = paramString.length();
/*     */ 
/*     */     
/* 161 */     char[] arrayOfChar = h.c();
/* 162 */     int k = 0;
/* 163 */     int m = 0;
/*     */     
/* 165 */     while (paramInt < j) {
/* 166 */       int i1 = b(paramString, paramInt, j);
/* 167 */       if (i1 < 0) {
/* 168 */         throw new IllegalArgumentException("Trailing high surrogate at end of input");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 173 */       char[] arrayOfChar1 = a(i1);
/* 174 */       int i2 = paramInt + (Character.isSupplementaryCodePoint(i1) ? 2 : 1);
/* 175 */       if (arrayOfChar1 != null) {
/* 176 */         int i3 = paramInt - m;
/*     */ 
/*     */ 
/*     */         
/* 180 */         int i4 = k + i3 + arrayOfChar1.length;
/* 181 */         if (arrayOfChar.length < i4) {
/* 182 */           int i5 = i4 + j - paramInt + 32;
/* 183 */           arrayOfChar = a(arrayOfChar, k, i5);
/*     */         } 
/*     */         
/* 186 */         if (i3 > 0) {
/* 187 */           paramString.getChars(m, paramInt, arrayOfChar, k);
/* 188 */           k += i3;
/*     */         } 
/* 190 */         if (arrayOfChar1.length > 0) {
/* 191 */           System.arraycopy(arrayOfChar1, 0, arrayOfChar, k, arrayOfChar1.length);
/* 192 */           k += arrayOfChar1.length;
/*     */         } 
/*     */         
/* 195 */         m = i2;
/*     */       } 
/* 197 */       paramInt = a(paramString, i2, j);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 202 */     int n = j - m;
/* 203 */     if (n > 0) {
/* 204 */       int i1 = k + n;
/* 205 */       if (arrayOfChar.length < i1) {
/* 206 */         arrayOfChar = a(arrayOfChar, k, i1);
/*     */       }
/* 208 */       paramString.getChars(m, j, arrayOfChar, k);
/* 209 */       k = i1;
/*     */     } 
/* 211 */     return new String(arrayOfChar, 0, k);
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
/*     */   protected static int b(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 246 */     D.checkNotNull(paramCharSequence);
/* 247 */     if (paramInt1 < paramInt2) {
/* 248 */       char c = paramCharSequence.charAt(paramInt1++);
/* 249 */       if (c < '?' || c > '?')
/*     */       {
/* 251 */         return c; } 
/* 252 */       if (c <= '?') {
/*     */         
/* 254 */         if (paramInt1 == paramInt2) {
/* 255 */           return -c;
/*     */         }
/*     */         
/* 258 */         char c2 = paramCharSequence.charAt(paramInt1);
/* 259 */         if (Character.isLowSurrogate(c2)) {
/* 260 */           return Character.toCodePoint(c, c2);
/*     */         }
/* 262 */         char c3 = c2; int k = paramInt1; String str1 = String.valueOf(paramCharSequence); throw new IllegalArgumentException((new StringBuilder(89 + String.valueOf(str1).length())).append("Expected low surrogate but got char '").append(c2).append("' with value ").append(c3).append(" at index ").append(k).append(" in '").append(str1).append("'").toString());
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 273 */       char c1 = c; int j = paramInt1 - 1; String str = String.valueOf(paramCharSequence); throw new IllegalArgumentException((new StringBuilder(88 + String.valueOf(str).length())).append("Unexpected low surrogate character '").append(c).append("' with value ").append(c1).append(" at index ").append(j).append(" in '").append(str).append("'").toString());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 285 */     throw new IndexOutOfBoundsException("Index exceeds specified range");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static char[] a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 293 */     if (paramInt2 < 0) {
/* 294 */       throw new AssertionError("Cannot increase internal buffer any further");
/*     */     }
/* 296 */     char[] arrayOfChar = new char[paramInt2];
/* 297 */     if (paramInt1 > 0) {
/* 298 */       System.arraycopy(paramArrayOfchar, 0, arrayOfChar, 0, paramInt1);
/*     */     }
/* 300 */     return arrayOfChar;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\e\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */