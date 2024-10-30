/*     */ package org.apache.commons.lang3.text.translate;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class CharSequenceTranslator
/*     */ {
/*  37 */   static final char[] HEX_DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String translate(CharSequence paramCharSequence) {
/*  59 */     if (paramCharSequence == null) {
/*  60 */       return null;
/*     */     }
/*     */     try {
/*  63 */       StringWriter stringWriter = new StringWriter(paramCharSequence.length() * 2);
/*  64 */       translate(paramCharSequence, stringWriter);
/*  65 */       return stringWriter.toString();
/*  66 */     } catch (IOException iOException) {
/*     */       
/*  68 */       throw new RuntimeException(iOException);
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
/*     */   public final void translate(CharSequence paramCharSequence, Writer paramWriter) throws IOException {
/*  81 */     if (paramWriter == null) {
/*  82 */       throw new IllegalArgumentException("The Writer must not be null");
/*     */     }
/*  84 */     if (paramCharSequence == null) {
/*     */       return;
/*     */     }
/*  87 */     int i = 0;
/*  88 */     int j = paramCharSequence.length();
/*  89 */     while (i < j) {
/*  90 */       int k = translate(paramCharSequence, i, paramWriter);
/*  91 */       if (k == 0) {
/*     */ 
/*     */         
/*  94 */         char c = paramCharSequence.charAt(i);
/*  95 */         paramWriter.write(c);
/*  96 */         i++;
/*  97 */         if (Character.isHighSurrogate(c) && i < j) {
/*  98 */           char c1 = paramCharSequence.charAt(i);
/*  99 */           if (Character.isLowSurrogate(c1)) {
/* 100 */             paramWriter.write(c1);
/* 101 */             i++;
/*     */           } 
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 108 */       for (byte b = 0; b < k; b++) {
/* 109 */         i += Character.charCount(Character.codePointAt(paramCharSequence, i));
/*     */       }
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
/*     */   public final CharSequenceTranslator with(CharSequenceTranslator... paramVarArgs) {
/* 122 */     CharSequenceTranslator[] arrayOfCharSequenceTranslator = new CharSequenceTranslator[paramVarArgs.length + 1];
/* 123 */     arrayOfCharSequenceTranslator[0] = this;
/* 124 */     System.arraycopy(paramVarArgs, 0, arrayOfCharSequenceTranslator, 1, paramVarArgs.length);
/* 125 */     return new AggregateTranslator(arrayOfCharSequenceTranslator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String hex(int paramInt) {
/* 136 */     return Integer.toHexString(paramInt).toUpperCase(Locale.ENGLISH);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\translate\CharSequenceTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */