/*     */ package org.apache.commons.text.matcher;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class AbstractStringMatcher
/*     */   implements StringMatcher
/*     */ {
/*     */   static final class AndStringMatcher
/*     */     extends AbstractStringMatcher
/*     */   {
/*     */     private final StringMatcher[] stringMatchers;
/*     */     
/*     */     AndStringMatcher(StringMatcher... param1VarArgs) {
/*  51 */       this.stringMatchers = (StringMatcher[])param1VarArgs.clone();
/*     */     }
/*     */ 
/*     */     
/*     */     public int isMatch(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/*  56 */       int i = 0;
/*  57 */       int j = param1Int1;
/*  58 */       for (StringMatcher stringMatcher : this.stringMatchers) {
/*  59 */         if (stringMatcher != null) {
/*  60 */           int k = stringMatcher.isMatch(param1ArrayOfchar, j, param1Int2, param1Int3);
/*  61 */           if (k == 0) {
/*  62 */             return 0;
/*     */           }
/*  64 */           i += k;
/*  65 */           j += k;
/*     */         } 
/*     */       } 
/*  68 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public int isMatch(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
/*  73 */       int i = 0;
/*  74 */       int j = param1Int1;
/*  75 */       for (StringMatcher stringMatcher : this.stringMatchers) {
/*  76 */         if (stringMatcher != null) {
/*  77 */           int k = stringMatcher.isMatch(param1CharSequence, j, param1Int2, param1Int3);
/*  78 */           if (k == 0) {
/*  79 */             return 0;
/*     */           }
/*  81 */           i += k;
/*  82 */           j += k;
/*     */         } 
/*     */       } 
/*  85 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/*  90 */       int i = 0;
/*  91 */       for (StringMatcher stringMatcher : this.stringMatchers) {
/*  92 */         if (stringMatcher != null) {
/*  93 */           i += stringMatcher.size();
/*     */         }
/*     */       } 
/*  96 */       return i;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class CharArrayMatcher
/*     */     extends AbstractStringMatcher
/*     */   {
/*     */     private final char[] chars;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String string;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     CharArrayMatcher(char... param1VarArgs) {
/* 121 */       this.string = String.valueOf(param1VarArgs);
/* 122 */       this.chars = (char[])param1VarArgs.clone();
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
/*     */     
/*     */     public int isMatch(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/* 136 */       int i = size();
/* 137 */       if (param1Int1 + i > param1Int3) {
/* 138 */         return 0;
/*     */       }
/* 140 */       int j = param1Int1;
/* 141 */       for (byte b = 0; b < i; b++, j++) {
/* 142 */         if (this.chars[b] != param1ArrayOfchar[j]) {
/* 143 */           return 0;
/*     */         }
/*     */       } 
/* 146 */       return i;
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
/*     */     
/*     */     public int isMatch(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
/* 160 */       int i = size();
/* 161 */       if (param1Int1 + i > param1Int3) {
/* 162 */         return 0;
/*     */       }
/* 164 */       int j = param1Int1;
/* 165 */       for (byte b = 0; b < i; b++, j++) {
/* 166 */         if (this.chars[b] != param1CharSequence.charAt(j)) {
/* 167 */           return 0;
/*     */         }
/*     */       } 
/* 170 */       return i;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 180 */       return this.chars.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 185 */       return super.toString() + "[\"" + this.string + "\"]";
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
/*     */   static final class CharMatcher
/*     */     extends AbstractStringMatcher
/*     */   {
/*     */     private final char ch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     CharMatcher(char param1Char) {
/* 208 */       this.ch = param1Char;
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
/*     */     
/*     */     public int isMatch(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/* 222 */       return (this.ch == param1ArrayOfchar[param1Int1]) ? 1 : 0;
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
/*     */     
/*     */     public int isMatch(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
/* 236 */       return (this.ch == param1CharSequence.charAt(param1Int1)) ? 1 : 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 246 */       return 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 251 */       return super.toString() + "['" + this.ch + "']";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class CharSetMatcher
/*     */     extends AbstractStringMatcher
/*     */   {
/*     */     private final char[] chars;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     CharSetMatcher(char[] param1ArrayOfchar) {
/* 273 */       this.chars = (char[])param1ArrayOfchar.clone();
/* 274 */       Arrays.sort(this.chars);
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
/*     */     
/*     */     public int isMatch(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/* 288 */       return (Arrays.binarySearch(this.chars, param1ArrayOfchar[param1Int1]) >= 0) ? 1 : 0;
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
/*     */     
/*     */     public int isMatch(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
/* 302 */       return (Arrays.binarySearch(this.chars, param1CharSequence.charAt(param1Int1)) >= 0) ? 1 : 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 312 */       return 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 317 */       return super.toString() + Arrays.toString(this.chars);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class NoneMatcher
/*     */     extends AbstractStringMatcher
/*     */   {
/*     */     public int isMatch(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/* 348 */       return 0;
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
/*     */     
/*     */     public int isMatch(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
/* 362 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 372 */       return 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class TrimMatcher
/*     */     extends AbstractStringMatcher
/*     */   {
/*     */     private static final int SPACE_INT = 32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int isMatch(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/* 408 */       return (param1ArrayOfchar[param1Int1] <= ' ') ? 1 : 0;
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
/*     */     
/*     */     public int isMatch(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
/* 422 */       return (param1CharSequence.charAt(param1Int1) <= ' ') ? 1 : 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 432 */       return 1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\matcher\AbstractStringMatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */