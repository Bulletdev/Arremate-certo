/*     */ package com.google.a.l;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class g
/*     */   extends i
/*     */ {
/*  57 */   private static final char[] g = new char[] { '+' };
/*     */ 
/*     */   
/*  60 */   private static final char[] h = "0123456789ABCDEF".toCharArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean plusForSpace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean[] c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g(String paramString, boolean paramBoolean) {
/*  88 */     D.checkNotNull(paramString);
/*     */     
/*  90 */     if (paramString.matches(".*[0-9A-Za-z].*")) {
/*  91 */       throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
/*     */     }
/*     */     
/*  94 */     paramString = String.valueOf(paramString).concat("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
/*     */ 
/*     */     
/*  97 */     if (paramBoolean && paramString.contains(" ")) {
/*  98 */       throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
/*     */     }
/*     */     
/* 101 */     this.plusForSpace = paramBoolean;
/* 102 */     this.c = a(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean[] a(String paramString) {
/* 111 */     int j = -1;
/* 112 */     char[] arrayOfChar = paramString.toCharArray();
/* 113 */     for (char c : arrayOfChar) {
/* 114 */       j = Math.max(c, j);
/*     */     }
/* 116 */     boolean[] arrayOfBoolean = new boolean[j + 1];
/* 117 */     for (char c : arrayOfChar) {
/* 118 */       arrayOfBoolean[c] = true;
/*     */     }
/* 120 */     return arrayOfBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 129 */     D.checkNotNull(paramCharSequence);
/* 130 */     for (; paramInt1 < paramInt2; paramInt1++) {
/* 131 */       char c = paramCharSequence.charAt(paramInt1);
/* 132 */       if (c >= this.c.length || !this.c[c]) {
/*     */         break;
/*     */       }
/*     */     } 
/* 136 */     return paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String escape(String paramString) {
/* 145 */     D.checkNotNull(paramString);
/* 146 */     int j = paramString.length();
/* 147 */     for (byte b = 0; b < j; b++) {
/* 148 */       char c = paramString.charAt(b);
/* 149 */       if (c >= this.c.length || !this.c[c]) {
/* 150 */         return h(paramString, b);
/*     */       }
/*     */     } 
/* 153 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected char[] a(int paramInt) {
/* 161 */     if (paramInt < this.c.length && this.c[paramInt])
/* 162 */       return null; 
/* 163 */     if (paramInt == 32 && this.plusForSpace)
/* 164 */       return g; 
/* 165 */     if (paramInt <= 127) {
/*     */ 
/*     */       
/* 168 */       char[] arrayOfChar = new char[3];
/* 169 */       arrayOfChar[0] = '%';
/* 170 */       arrayOfChar[2] = h[paramInt & 0xF];
/* 171 */       arrayOfChar[1] = h[paramInt >>> 4];
/* 172 */       return arrayOfChar;
/* 173 */     }  if (paramInt <= 2047) {
/*     */ 
/*     */       
/* 176 */       char[] arrayOfChar = new char[6];
/* 177 */       arrayOfChar[0] = '%';
/* 178 */       arrayOfChar[3] = '%';
/* 179 */       arrayOfChar[5] = h[paramInt & 0xF];
/* 180 */       paramInt >>>= 4;
/* 181 */       arrayOfChar[4] = h[0x8 | paramInt & 0x3];
/* 182 */       paramInt >>>= 2;
/* 183 */       arrayOfChar[2] = h[paramInt & 0xF];
/* 184 */       paramInt >>>= 4;
/* 185 */       arrayOfChar[1] = h[0xC | paramInt];
/* 186 */       return arrayOfChar;
/* 187 */     }  if (paramInt <= 65535) {
/*     */ 
/*     */       
/* 190 */       char[] arrayOfChar = new char[9];
/* 191 */       arrayOfChar[0] = '%';
/* 192 */       arrayOfChar[1] = 'E';
/* 193 */       arrayOfChar[3] = '%';
/* 194 */       arrayOfChar[6] = '%';
/* 195 */       arrayOfChar[8] = h[paramInt & 0xF];
/* 196 */       paramInt >>>= 4;
/* 197 */       arrayOfChar[7] = h[0x8 | paramInt & 0x3];
/* 198 */       paramInt >>>= 2;
/* 199 */       arrayOfChar[5] = h[paramInt & 0xF];
/* 200 */       paramInt >>>= 4;
/* 201 */       arrayOfChar[4] = h[0x8 | paramInt & 0x3];
/* 202 */       paramInt >>>= 2;
/* 203 */       arrayOfChar[2] = h[paramInt];
/* 204 */       return arrayOfChar;
/* 205 */     }  if (paramInt <= 1114111) {
/* 206 */       char[] arrayOfChar = new char[12];
/*     */ 
/*     */       
/* 209 */       arrayOfChar[0] = '%';
/* 210 */       arrayOfChar[1] = 'F';
/* 211 */       arrayOfChar[3] = '%';
/* 212 */       arrayOfChar[6] = '%';
/* 213 */       arrayOfChar[9] = '%';
/* 214 */       arrayOfChar[11] = h[paramInt & 0xF];
/* 215 */       paramInt >>>= 4;
/* 216 */       arrayOfChar[10] = h[0x8 | paramInt & 0x3];
/* 217 */       paramInt >>>= 2;
/* 218 */       arrayOfChar[8] = h[paramInt & 0xF];
/* 219 */       paramInt >>>= 4;
/* 220 */       arrayOfChar[7] = h[0x8 | paramInt & 0x3];
/* 221 */       paramInt >>>= 2;
/* 222 */       arrayOfChar[5] = h[paramInt & 0xF];
/* 223 */       paramInt >>>= 4;
/* 224 */       arrayOfChar[4] = h[0x8 | paramInt & 0x3];
/* 225 */       paramInt >>>= 2;
/* 226 */       arrayOfChar[2] = h[paramInt & 0x7];
/* 227 */       return arrayOfChar;
/*     */     } 
/*     */     
/* 230 */     int j = paramInt; throw new IllegalArgumentException((new StringBuilder(43)).append("Invalid unicode character value ").append(j).toString());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\l\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */