/*     */ package org.apache.http.client.utils;
/*     */ 
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class Rfc3492Idn
/*     */   implements Idn
/*     */ {
/*     */   private static final int base = 36;
/*     */   private static final int tmin = 1;
/*     */   private static final int tmax = 26;
/*     */   private static final int skew = 38;
/*     */   private static final int damp = 700;
/*     */   private static final int initial_bias = 72;
/*     */   private static final int initial_n = 128;
/*     */   private static final char delimiter = '-';
/*     */   private static final String ACE_PREFIX = "xn--";
/*     */   
/*     */   private int adapt(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  55 */     int i = paramInt1;
/*  56 */     if (paramBoolean) {
/*  57 */       i /= 700;
/*     */     } else {
/*  59 */       i /= 2;
/*     */     } 
/*  61 */     i += i / paramInt2;
/*  62 */     int j = 0;
/*  63 */     while (i > 455) {
/*  64 */       i /= 35;
/*  65 */       j += 36;
/*     */     } 
/*  67 */     return j + 36 * i / (i + 38);
/*     */   }
/*     */   
/*     */   private int digit(char paramChar) {
/*  71 */     if (paramChar >= 'A' && paramChar <= 'Z') {
/*  72 */       return paramChar - 65;
/*     */     }
/*  74 */     if (paramChar >= 'a' && paramChar <= 'z') {
/*  75 */       return paramChar - 97;
/*     */     }
/*  77 */     if (paramChar >= '0' && paramChar <= '9') {
/*  78 */       return paramChar - 48 + 26;
/*     */     }
/*  80 */     throw new IllegalArgumentException("illegal digit: " + paramChar);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toUnicode(String paramString) {
/*  85 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/*  86 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, ".");
/*  87 */     while (stringTokenizer.hasMoreTokens()) {
/*  88 */       String str = stringTokenizer.nextToken();
/*  89 */       if (stringBuilder.length() > 0) {
/*  90 */         stringBuilder.append('.');
/*     */       }
/*  92 */       if (str.startsWith("xn--")) {
/*  93 */         str = decode(str.substring(4));
/*     */       }
/*  95 */       stringBuilder.append(str);
/*     */     } 
/*  97 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   protected String decode(String paramString) {
/* 101 */     String str = paramString;
/* 102 */     int i = 128;
/* 103 */     int j = 0;
/* 104 */     int k = 72;
/* 105 */     StringBuilder stringBuilder = new StringBuilder(str.length());
/* 106 */     int m = str.lastIndexOf('-');
/* 107 */     if (m != -1) {
/* 108 */       stringBuilder.append(str.subSequence(0, m));
/* 109 */       str = str.substring(m + 1);
/*     */     } 
/*     */     
/* 112 */     while (!str.isEmpty()) {
/* 113 */       int n = j;
/* 114 */       int i1 = 1;
/* 115 */       byte b = 36;
/* 116 */       for (; !str.isEmpty(); b += 36) {
/*     */         int i3;
/*     */         
/* 119 */         char c = str.charAt(0);
/* 120 */         str = str.substring(1);
/* 121 */         int i2 = digit(c);
/* 122 */         j += i2 * i1;
/*     */         
/* 124 */         if (b <= k + 1) {
/* 125 */           i3 = 1;
/* 126 */         } else if (b >= k + 26) {
/* 127 */           i3 = 26;
/*     */         } else {
/* 129 */           i3 = b - k;
/*     */         } 
/* 131 */         if (i2 < i3) {
/*     */           break;
/*     */         }
/* 134 */         i1 *= 36 - i3;
/*     */       } 
/* 136 */       k = adapt(j - n, stringBuilder.length() + 1, (n == 0));
/* 137 */       i += j / (stringBuilder.length() + 1);
/* 138 */       j %= stringBuilder.length() + 1;
/*     */       
/* 140 */       stringBuilder.insert(j, (char)i);
/* 141 */       j++;
/*     */     } 
/* 143 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\clien\\utils\Rfc3492Idn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */