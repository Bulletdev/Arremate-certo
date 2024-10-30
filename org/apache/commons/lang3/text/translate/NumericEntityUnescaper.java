/*     */ package org.apache.commons.lang3.text.translate;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class NumericEntityUnescaper
/*     */   extends CharSequenceTranslator
/*     */ {
/*     */   private final EnumSet<OPTION> options;
/*     */   
/*     */   public enum OPTION
/*     */   {
/*  40 */     semiColonRequired, semiColonOptional, errorIfNoSemiColon;
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
/*     */   public NumericEntityUnescaper(OPTION... paramVarArgs) {
/*  63 */     if (paramVarArgs.length > 0) {
/*  64 */       this.options = EnumSet.copyOf(Arrays.asList(paramVarArgs));
/*     */     } else {
/*  66 */       this.options = EnumSet.copyOf(Collections.singletonList(OPTION.semiColonRequired));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSet(OPTION paramOPTION) {
/*  77 */     return (this.options != null && this.options.contains(paramOPTION));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/*  85 */     int i = paramCharSequence.length();
/*     */     
/*  87 */     if (paramCharSequence.charAt(paramInt) == '&' && paramInt < i - 2 && paramCharSequence.charAt(paramInt + 1) == '#') {
/*  88 */       int m, j = paramInt + 2;
/*  89 */       boolean bool1 = false;
/*     */       
/*  91 */       char c = paramCharSequence.charAt(j);
/*  92 */       if (c == 'x' || c == 'X') {
/*  93 */         j++;
/*  94 */         bool1 = true;
/*     */ 
/*     */         
/*  97 */         if (j == i) {
/*  98 */           return 0;
/*     */         }
/*     */       } 
/*     */       
/* 102 */       int k = j;
/*     */       
/* 104 */       while (k < i && ((paramCharSequence.charAt(k) >= '0' && paramCharSequence.charAt(k) <= '9') || (paramCharSequence
/* 105 */         .charAt(k) >= 'a' && paramCharSequence.charAt(k) <= 'f') || (paramCharSequence
/* 106 */         .charAt(k) >= 'A' && paramCharSequence.charAt(k) <= 'F'))) {
/* 107 */         k++;
/*     */       }
/*     */       
/* 110 */       boolean bool2 = (k != i && paramCharSequence.charAt(k) == ';') ? true : false;
/*     */       
/* 112 */       if (!bool2) {
/* 113 */         if (isSet(OPTION.semiColonRequired)) {
/* 114 */           return 0;
/*     */         }
/* 116 */         if (isSet(OPTION.errorIfNoSemiColon)) {
/* 117 */           throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 123 */         if (bool1) {
/* 124 */           m = Integer.parseInt(paramCharSequence.subSequence(j, k).toString(), 16);
/*     */         } else {
/* 126 */           m = Integer.parseInt(paramCharSequence.subSequence(j, k).toString(), 10);
/*     */         } 
/* 128 */       } catch (NumberFormatException numberFormatException) {
/* 129 */         return 0;
/*     */       } 
/*     */       
/* 132 */       if (m > 65535) {
/* 133 */         char[] arrayOfChar = Character.toChars(m);
/* 134 */         paramWriter.write(arrayOfChar[0]);
/* 135 */         paramWriter.write(arrayOfChar[1]);
/*     */       } else {
/* 137 */         paramWriter.write(m);
/*     */       } 
/*     */       
/* 140 */       return 2 + k - j + (bool1 ? 1 : 0) + (bool2 ? 1 : 0);
/*     */     } 
/* 142 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\translate\NumericEntityUnescaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */