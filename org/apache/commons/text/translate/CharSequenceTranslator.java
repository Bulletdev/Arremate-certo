/*     */ package org.apache.commons.text.translate;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.Locale;
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
/*     */ public abstract class CharSequenceTranslator
/*     */ {
/*  38 */   static final char[] HEX_DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */ 
/*     */ 
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
/*     */ 
/*     */   
/*     */   public final String translate(CharSequence paramCharSequence) {
/*  63 */     if (paramCharSequence == null) {
/*  64 */       return null;
/*     */     }
/*     */     try {
/*  67 */       StringWriter stringWriter = new StringWriter(paramCharSequence.length() * 2);
/*  68 */       translate(paramCharSequence, stringWriter);
/*  69 */       return stringWriter.toString();
/*  70 */     } catch (IOException iOException) {
/*     */       
/*  72 */       throw new RuntimeException(iOException);
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
/*  85 */     Validate.isTrue((paramWriter != null), "The Writer must not be null", new Object[0]);
/*  86 */     if (paramCharSequence == null) {
/*     */       return;
/*     */     }
/*  89 */     int i = 0;
/*  90 */     int j = paramCharSequence.length();
/*  91 */     while (i < j) {
/*  92 */       int k = translate(paramCharSequence, i, paramWriter);
/*  93 */       if (k == 0) {
/*     */ 
/*     */         
/*  96 */         char c = paramCharSequence.charAt(i);
/*  97 */         paramWriter.write(c);
/*  98 */         i++;
/*  99 */         if (Character.isHighSurrogate(c) && i < j) {
/* 100 */           char c1 = paramCharSequence.charAt(i);
/* 101 */           if (Character.isLowSurrogate(c1)) {
/* 102 */             paramWriter.write(c1);
/* 103 */             i++;
/*     */           } 
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 110 */       for (byte b = 0; b < k; b++) {
/* 111 */         i += Character.charCount(Character.codePointAt(paramCharSequence, i));
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
/* 124 */     CharSequenceTranslator[] arrayOfCharSequenceTranslator = new CharSequenceTranslator[paramVarArgs.length + 1];
/* 125 */     arrayOfCharSequenceTranslator[0] = this;
/* 126 */     System.arraycopy(paramVarArgs, 0, arrayOfCharSequenceTranslator, 1, paramVarArgs.length);
/* 127 */     return new AggregateTranslator(arrayOfCharSequenceTranslator);
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
/* 138 */     return Integer.toHexString(paramInt).toUpperCase(Locale.ENGLISH);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\CharSequenceTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */