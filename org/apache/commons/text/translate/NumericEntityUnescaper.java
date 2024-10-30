/*     */ package org.apache.commons.text.translate;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.Arrays;
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
/*     */ 
/*     */ 
/*     */ public class NumericEntityUnescaper
/*     */   extends CharSequenceTranslator
/*     */ {
/*     */   private final EnumSet<OPTION> options;
/*     */   
/*     */   public enum OPTION
/*     */   {
/*  40 */     semiColonRequired,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     semiColonOptional,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  50 */     errorIfNoSemiColon;
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
/*  73 */     if (paramVarArgs.length > 0) {
/*  74 */       this.options = EnumSet.copyOf(Arrays.asList(paramVarArgs));
/*     */     } else {
/*  76 */       this.options = EnumSet.copyOf(Arrays.asList(new OPTION[] { OPTION.semiColonRequired }));
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
/*  87 */     return (this.options != null && this.options.contains(paramOPTION));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/*  95 */     int i = paramCharSequence.length();
/*     */     
/*  97 */     if (paramCharSequence.charAt(paramInt) == '&' && paramInt < i - 2 && paramCharSequence.charAt(paramInt + 1) == '#') {
/*  98 */       int m, j = paramInt + 2;
/*  99 */       boolean bool1 = false;
/*     */       
/* 101 */       char c = paramCharSequence.charAt(j);
/* 102 */       if (c == 'x' || c == 'X') {
/* 103 */         j++;
/* 104 */         bool1 = true;
/*     */ 
/*     */         
/* 107 */         if (j == i) {
/* 108 */           return 0;
/*     */         }
/*     */       } 
/*     */       
/* 112 */       int k = j;
/*     */       
/* 114 */       while (k < i && ((paramCharSequence.charAt(k) >= '0' && paramCharSequence.charAt(k) <= '9') || (paramCharSequence
/* 115 */         .charAt(k) >= 'a' && paramCharSequence.charAt(k) <= 'f') || (paramCharSequence
/* 116 */         .charAt(k) >= 'A' && paramCharSequence.charAt(k) <= 'F'))) {
/* 117 */         k++;
/*     */       }
/*     */       
/* 120 */       boolean bool2 = (k != i && paramCharSequence.charAt(k) == ';') ? true : false;
/*     */       
/* 122 */       if (!bool2) {
/* 123 */         if (isSet(OPTION.semiColonRequired)) {
/* 124 */           return 0;
/*     */         }
/* 126 */         if (isSet(OPTION.errorIfNoSemiColon)) {
/* 127 */           throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 133 */         if (bool1) {
/* 134 */           m = Integer.parseInt(paramCharSequence.subSequence(j, k).toString(), 16);
/*     */         } else {
/* 136 */           m = Integer.parseInt(paramCharSequence.subSequence(j, k).toString(), 10);
/*     */         } 
/* 138 */       } catch (NumberFormatException numberFormatException) {
/* 139 */         return 0;
/*     */       } 
/*     */       
/* 142 */       if (m > 65535) {
/* 143 */         char[] arrayOfChar = Character.toChars(m);
/* 144 */         paramWriter.write(arrayOfChar[0]);
/* 145 */         paramWriter.write(arrayOfChar[1]);
/*     */       } else {
/* 147 */         paramWriter.write(m);
/*     */       } 
/*     */       
/* 150 */       return 2 + k - j + (bool1 ? 1 : 0) + (bool2 ? 1 : 0);
/*     */     } 
/* 152 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\NumericEntityUnescaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */