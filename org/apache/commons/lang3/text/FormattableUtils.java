/*     */ package org.apache.commons.lang3.text;
/*     */ 
/*     */ import java.util.Formattable;
/*     */ import java.util.Formatter;
/*     */ import org.apache.commons.lang3.ObjectUtils;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class FormattableUtils
/*     */ {
/*     */   private static final String SIMPLEST_FORMAT = "%s";
/*     */   
/*     */   public static String toString(Formattable paramFormattable) {
/*  69 */     return String.format("%s", new Object[] { paramFormattable });
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
/*  86 */     return append(paramCharSequence, paramFormatter, paramInt1, paramInt2, paramInt3, ' ', null);
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
/* 103 */     return append(paramCharSequence, paramFormatter, paramInt1, paramInt2, paramInt3, paramChar, null);
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
/* 121 */     return append(paramCharSequence1, paramFormatter, paramInt1, paramInt2, paramInt3, ' ', paramCharSequence2);
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
/* 139 */     Validate.isTrue((paramCharSequence2 == null || paramInt3 < 0 || paramCharSequence2.length() <= paramInt3), "Specified ellipsis '%1$s' exceeds precision of %2$s", new Object[] { paramCharSequence2, 
/* 140 */           Integer.valueOf(paramInt3) });
/* 141 */     StringBuilder stringBuilder = new StringBuilder(paramCharSequence1);
/* 142 */     if (paramInt3 >= 0 && paramInt3 < paramCharSequence1.length()) {
/* 143 */       CharSequence charSequence = (CharSequence)ObjectUtils.defaultIfNull(paramCharSequence2, "");
/* 144 */       stringBuilder.replace(paramInt3 - charSequence.length(), paramCharSequence1.length(), charSequence.toString());
/*     */     } 
/* 146 */     boolean bool = ((paramInt1 & 0x1) == 1) ? true : false;
/* 147 */     for (int i = stringBuilder.length(); i < paramInt2; i++) {
/* 148 */       stringBuilder.insert(bool ? i : 0, paramChar);
/*     */     }
/* 150 */     paramFormatter.format(stringBuilder.toString(), new Object[0]);
/* 151 */     return paramFormatter;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\FormattableUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */