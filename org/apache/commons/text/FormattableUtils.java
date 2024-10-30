/*     */ package org.apache.commons.text;
/*     */ 
/*     */ import java.util.Formattable;
/*     */ import java.util.Formatter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormattableUtils
/*     */ {
/*     */   private static final String SIMPLEST_FORMAT = "%s";
/*     */   
/*     */   public static String toString(Formattable paramFormattable) {
/*  64 */     return String.format("%s", new Object[] { paramFormattable });
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
/*     */   public static Formatter append(CharSequence paramCharSequence, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3) {
/*  81 */     return append(paramCharSequence, paramFormatter, paramInt1, paramInt2, paramInt3, ' ', null);
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
/*     */   public static Formatter append(CharSequence paramCharSequence, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3, char paramChar) {
/*  98 */     return append(paramCharSequence, paramFormatter, paramInt1, paramInt2, paramInt3, paramChar, null);
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
/*     */   public static Formatter append(CharSequence paramCharSequence1, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence2) {
/* 116 */     return append(paramCharSequence1, paramFormatter, paramInt1, paramInt2, paramInt3, ' ', paramCharSequence2);
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
/*     */   public static Formatter append(CharSequence paramCharSequence1, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3, char paramChar, CharSequence paramCharSequence2) {
/* 134 */     if (paramCharSequence2 != null && paramInt3 >= 0 && paramCharSequence2.length() > paramInt3)
/* 135 */       throw new IllegalArgumentException(
/* 136 */           String.format("Specified ellipsis '%s' exceeds precision of %s", new Object[] {
/*     */               
/* 138 */               paramCharSequence2, Integer.valueOf(paramInt3)
/*     */             })); 
/* 140 */     StringBuilder stringBuilder = new StringBuilder(paramCharSequence1);
/* 141 */     if (paramInt3 >= 0 && paramInt3 < paramCharSequence1.length()) {
/*     */       CharSequence charSequence;
/* 143 */       if (paramCharSequence2 == null) {
/* 144 */         charSequence = "";
/*     */       } else {
/* 146 */         charSequence = paramCharSequence2;
/*     */       } 
/* 148 */       stringBuilder.replace(paramInt3 - charSequence.length(), paramCharSequence1.length(), charSequence.toString());
/*     */     } 
/* 150 */     boolean bool = ((paramInt1 & 0x1) == 1) ? true : false;
/* 151 */     for (int i = stringBuilder.length(); i < paramInt2; i++) {
/* 152 */       stringBuilder.insert(bool ? i : 0, paramChar);
/*     */     }
/* 154 */     paramFormatter.format(stringBuilder.toString(), new Object[0]);
/* 155 */     return paramFormatter;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\FormattableUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */